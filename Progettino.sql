CREATE DATABASE PROGETTOCM;

DOPO AVER CREATO IL DATABASE COPIARE TUTTO E INCOLLARE

CREATE TABLE Insegnante(
	Login varchar(71) Not Null,
	Nome varchar(71),
	Cognome varchar(71),
	Password varchar(71),
	Corso varchar(71),
	
	Constraint Insegnantepk 
	PRIMARY KEY (Login)

);

CREATE TABLE Test(
	Nome varchar(71) Not NULL,
	Corso varchar(71),
	Data date,
	Insegnante varchar(71),
	valido boolean,
	
	Constraint Insegnantefk
	FOREIGN KEY(Insegnante) references Insegnante(Login),
	
	Constraint testpk 
	PRIMARY KEY (Nome)

);

CREATE TABLE Studente(
	Login varchar(71) Not Null,
	Nome varchar(71),
	Cognome varchar(71),
	Password varchar(71),
	
	Constraint Studentepk 
	PRIMARY KEY (Login)

);




CREATE TABLE Quizarispostamultipla(
	Nome varchar(71) Not NULL,
	Descrizione varchar(200),
	Domanda varchar(500),
	votoRispostaCorretta float,
	votoRispostaSbagliata float,
	Test varchar(71),
	RispostaCorretta varchar(2),

	constraint Quizarispostamultiplapk
	primary key (Nome),
	
	constraint Quizarispostamultiplafk
	foreign key(Test) references Test(nome)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

CREATE TABLE Quizarispostaaperta(
	Nome varchar(71) Not NULL,
	Descrizione varchar(200),
	Domanda varchar(500),
	lunghezzamax int,
	punteggiomax float,
	punteggiomin float,
	Test varchar(71),
	
	constraint Quizarispostaapertapk
	primary key (Nome),
	
	constraint Quizarispostaapertafk
	foreign key(Test) references Test(nome)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);





CREATE TABLE SCELTA(
	Studente varchar(71) NOT NULL,
	Test varchar(71) NOT NULL,
	Voto float,
	Corretto boolean,
	Data date,
	Termina boolean,
	
	constraint Sceltapk
	primary key (Studente, Test),
	
	constraint Sceltafk1
		foreign key (Studente) references studente(login)
			ON DELETE CASCADE
			ON UPDATE CASCADE,
	
	constraint Sceltafk2
		foreign key (Test) references test(nome)
			ON DELETE CASCADE
			ON UPDATE CASCADE
);



CREATE TABLE RISPOSTAMULTIPLA(
	Studente varchar(71) NOT NULL,
	Quiz varchar(71) NOT NULL,
	Risposta varchar(2),
	Voto float,
	
	constraint rispostamultiplapk
	primary key (Studente, Quiz),
	
	constraint rispostamultiplafk1
		foreign key (Studente) references studente(login)
			ON DELETE CASCADE
			ON UPDATE CASCADE,
	
	constraint rispostamultiplafk2
		foreign key (Quiz) references quizarispostamultipla(nome)
			ON DELETE CASCADE
			ON UPDATE CASCADE
);

CREATE TABLE RISPOSTAAPERTA(
	Studente varchar(71) NOT NULL,
	Insegnante varchar(71) NOT NULL,
	Quiz varchar(71) NOT NULL,
	Risposta varchar(200),
	Voto float,
	Corretta boolean,
	
	constraint rispostaapertacorrettapk
	primary key (Studente, Insegnante, Quiz),
	
	constraint rispostaapertacorrettafk1
		foreign key (Studente) references studente(login)
			ON DELETE CASCADE
			ON UPDATE CASCADE,
	
	constraint rispostaapertacorrettafk2
		foreign key (Insegnante) references insegnante(login)
			ON DELETE CASCADE
			ON UPDATE CASCADE,
	
	constraint rispostaapertacorrettafk3
		foreign key (Quiz) references quizarispostaaperta(nome)
			ON DELETE CASCADE
			ON UPDATE CASCADE
);



create or replace function  correggiaperte() returns trigger as $$
begin
	if(new.voto is NULL)then
	new.corretta=false;
end if;
	return new;
end;
$$ language plpgsql;

create or replace trigger correggiaperte
before update of corretta on rispostaaperta
for each row
when(new.corretta=true)
execute function correggiaperte();


create or replace function  correzionemultipla() returns trigger as $$
Declare
	quiz quizarispostamultipla%rowtype;
BEGIN
	
	Select * Into quiz
	from quizarispostamultipla
	where nome=new.quiz;
	if(new.risposta=quiz.rispostacorretta)then
		new.voto=quiz.votorispostacorretta;
	else
		new.voto=quiz.votorispostasbagliata;
	end if;
	return new;
end
$$ language plpgsql;


create or replace trigger correggimultipla
before insert on rispostamultipla
for each row
execute function correzionemultipla();


create  or replace function scorretto() returns trigger as $$
declare
sum1 float;
sum2 float;

Begin
	if((Select nome 
		from quizarispostaaperta 
		where test=new.test  AND nome NOT IN(
			Select quiz 
			From rispostaaperta 
			where corretta=true AND studente=new.studente AND quiz IN (
																		 Select nome
																		 From quizarispostaaperta
																		 Where test=new.test
			) )) IS NULL AND new.termina=true) then
		
		Select SUM(ra.voto) INTO sum1
		FROM rispostaaperta AS ra 
		WHERE ra.studente=new.studente AND ra.quiz IN(
			SELECT nome 
			FROM quizarispostaaperta 
			WHERE test=new.test);
			
		Select SUM(rm.voto) INTO sum2
		FROM rispostamultipla as rm
		where rm.studente=new.studente AND rm.quiz IN (
				SELECT nome 
				FROM quizarispostamultipla 
				WHERE test=new.test);
		new.voto=sum1+sum2;
	else
		raise notice 'non sono stati tutti corretti o non è terminato';
		new.corretto=false;
	end if;
	return new;
end
$$ language plpgsql;


create or replace trigger sceltacorretto
before update of corretto on scelta
for each row
when(new.corretto=true)
execute function scorretto();


create or replace function tscelta() returns trigger as $$
BEGIN
	if(((Select nome 
		 from quizarispostaaperta 
		 where test=new.test AND nome not IN (
			 SELECT quiz 
			 FROM rispostaaperta 
			 WHERE studente=new.studente and quiz IN (select nome
													  from quizarispostaaperta
													  where test=new.test))) IS not NULL)
	   
	   OR 
	   	
	   ((Select nome 
		 from quizarispostamultipla 
		 where test=new.test AND nome not IN (
			 SELECT quiz 
			 FROM rispostamultipla 
			 WHERE studente=new.studente and quiz IN (select nome
													   from quizarispostamultipla
													   where test=new.test))) IS not NULL )) then
		
		
		
		RAISE NOTICE 'NON SONO STATE INSERITE TUTTE LE RISPOSTE';
		new.termina:=false;
	else
		new.data:=current_timestamp;
	end if; 
	return new;
END;
$$ language plpgsql;



create or replace trigger sceltaterminato
before update of termina on scelta
for each row
when(new.termina=true)
execute function tscelta();





insert into insegnante
values('echiaro@gmail.com', 'Marco', 'Pastore', 'ahokok', 'Base di Dati');

insert into insegnante
values('cmascia@libero.it', 'Carmine', 'Mascia', 'devofaasd', 'Object Oriented');

insert into insegnante
values('insertionsort@gmail.com', 'Alfredo', 'Laino', 'mcdonald', 'Programmazione I');

insert into insegnante
values('ecarino@hotmail.com', 'Luigi', 'Penza', 'elden ring', 'Algoritmi e Strutture Dati');

insert into insegnante
values('cumana@gmail.com', 'Francesco', 'Orlando', 'quartonelcuore', 'Architettura degli Elaboratori');

insert into insegnante
values('spotify@libero.it', 'Antonio', 'Lanuto', 'sotuttelematricole', 'Laboratorio di Programmazione');

insert into insegnante
values('vienialduel@hotmail.com', 'Alessandro', 'Tafuto', '3kditavolo', 'Analisi I');

insert into insegnante
values('sparea@libero.it', 'Giovanni', 'Zampetti', 'ouagliu', 'Fisica');

insert into insegnante
values('nessunosaniente@libero.it', 'Erasmo', 'Prosciutto', '19', 'Geometria');

insert into insegnante
values('gmercorio@gmail.com', 'Gianluigi', 'Mercorio', 'salsicceefriarielli', 'Linguaggi di programmazione');

insert into insegnante
values('vengolaprossimavolta@gmail.com', 'Giovanni', 'Tedesco', 'Acerra', 'Sistemi Operativi');

insert into insegnante
values('unultimopezzo@libero.it', 'Gianmarco', 'Lembo', 'adhonorem', 'Elementi di Informatica teorica');

insert into insegnante
values('tidevouncaffe@libero.it', 'Fabrizio', 'Pino', 'nonvedròmaiilmiocaffe', 'Algebra');

insert into insegnante
values('forlife@gmail.com', 'Oleksandr', 'Sosovskyy', 'youngtambu', 'Computer Forensics');

insert into test
values('La Magica Roma', 'Analisi I', '12/01/2021', 'vienialduel@hotmail.com',true);

insert into test
values('Algebra nel cuore', 'Algebra', '27/03/2021', 'tidevouncaffe@libero.it',true);

insert into test
values('Aspettate 10 minuti', 'Programmazione I', '17/02/2021', 'insertionsort@gmail.com',true);

insert into test
values('Il cane salta sul divano', 'Architettura degli Elaboratori', '16/06/2021', 'cumana@gmail.com',true);

insert into test
values('Non fa per me', 'Geometria', '19/07/2021', 'nessunosaniente@libero.it',true);

insert into test
values('Mizzica', 'Laboratorio di Programmazione', '18/09/2021', 'spotify@libero.it',true);

insert into test
values('Cucine Stellate', 'Fisica', '19/09/2022', 'sparea@libero.it',true);

insert into test
values('Salernitana', 'Base di Dati', '13/12/2021', 'echiaro@gmail.com',true);

insert into test
values('Procida', 'Object Oriented', '14/02/2022', 'cmascia@libero.it',true);

insert into test
values('Naive', 'Algoritmi e Strutture Dati', '22/03/2022', 'ecarino@hotmail.com',true);

insert into test
values('Etica delle Macchine', 'Elementi di Informatica teorica', '17/01/2021', 'unultimopezzo@libero.it',true);

insert into test
values('Game Design', 'Linguaggi di programmazione', '12/12/2021', 'gmercorio@gmail.com',true);

insert into test
values('SSRI', 'Computer Forensics', '15/12/2020', 'forlife@gmail.com',true);

insert into test
values('Fozza Napoli', 'Sistemi Operativi', '09/01/2012', 'vengolaprossimavolta@gmail.com',true);

insert into test
values('Mission Impossible', 'Algoritmi e Strutture Dati', '21/01/2008', 'ecarino@hotmail.com',true);

insert into test
values('Banalmente', 'Programmazione I', '21/02/2008', 'insertionsort@gmail.com',true);

insert into test
values('E Vabbuò', 'Object Oriented', '25/09/2008', 'cmascia@libero.it',true);


insert into test
values('Bonazzoli', 'Base di Dati', '21/01/2022', 'echiaro@gmail.com',true);

insert into studente
values ('Ostico@gmail.com', 'Daniele', 'Castorina', '1927');

insert into studente
values ('+agebra@yahoo.com', 'Giovanni', 'Cutolo', '4L');

insert into studente
values ('scomparso@libero.it', 'Daniel', 'Riccio', 'confermoivoti');

insert into studente
values ('davideeeee@outlook.com', 'Silvia', 'Rossi', 'virgilio');

insert into studente
values ('nikopandetta@libero.it', 'Francesco', 'Isgrò', 'maria');

insert into studente
values ('fcioffi@hotmail.com', 'Francesca', 'Cioffi', 'iuppi');

insert into studente
values ('nicoromito@libero.it', 'Fedele', 'Lizzi', 'mattiatorreF');

insert into studente
values ('forzasalerno@libero.it', 'Silvio', 'Barra', '1919');

insert into studente
values ('chebbellaprocida@libero.it', 'Porfirio', 'Tramontana', 'WProcida');

insert into studente
values ('inplace@gmail.com', 'Fabio', 'Mogavero', 'inloco');

insert into studente
values ('etica@hotmail.com', 'Guglielmo', 'Tamburrini', 'Oxford');

insert into quizarispostaaperta
values('Domanda1a', 'Devi dirmi la formula', 'Come si calcola la x in una equazione di primo grado?', '70', '10', '1', 'La Magica Roma');

insert into quizarispostaaperta
values('Domanda2a', 'Devi dirmi la risposta', 'Quanto fa 3^2?', '1', '10', '1', 'La Magica Roma');

insert into quizarispostaaperta
values('Domanda3a', 'Devi dirmi la formula usando non il nome completo ma le abbreviazioni', 'Area di un triangolo è uguale a?', '5', '10', '1', 'La Magica Roma');

insert into quizarispostaaperta
values('Domanda4a', 'Devi dirmi la risposta solo della conversione', 'A quanti decimetri corrispondono 3,26 centimetri?', '10', '10', '1', 'La Magica Roma');

insert into quizarispostaaperta
values('Domanda5a', 'Scrivere solo il tipo', 'Che tipo di triangolo è un triangolo che ha angoli di 25°, 90°, 85° ?', '10', '10', '1', 'La Magica Roma');

insert into quizarispostaaperta
values('Domanda1b', 'scrivi la definizione', 'Cosa è uno spazio vettoriale?', '100', '10', '1', 'Algebra nel cuore');

insert into quizarispostaaperta
values('Domanda2b', 'scrivi la definizione', 'Cosa è un sottospazio vettoriale?', '100', '10', '1', 'Algebra nel cuore');

insert into quizarispostaaperta
values('Domanda3b', 'scrivi la definizione', 'Come si definisce l’indipendenza lineare?', '100', '10', '1', 'Algebra nel cuore');

insert into quizarispostaaperta
values('Domanda1c', 'definisci le definizioni di variabile in entrambi gli ambiti', 'Qual è la differenza tra una variabile in matematica e in programmazione?', '200', '10', '1', 'Aspettate 10 minuti');

insert into quizarispostaaperta
values('Domanda2c', 'scrivi il costo', 'Quanto costa visitare tutti gli elementi di un array?', '100', '10', '1', 'Aspettate 10 minuti');

insert into quizarispostaaperta
values('Domanda3c', 'scriverne almeno 5', 'Quali sono i tipi di dati?', '50', '10', '1', 'Aspettate 10 minuti');

insert into quizarispostaaperta
values('Domanda4c', 'scrivi la definizione', 'cosa è un puntatore?', '50', '10', '1', 'Aspettate 10 minuti');

insert into quizarispostaaperta
values('Domanda5c', 'scrivi la definizione', 'cosa è una lista?', '100', '10', '1', 'Aspettate 10 minuti');

insert into quizarispostaaperta
values('Domanda1d', 'definiscilo molto semlicemente', 'Cosa è un flip flop?', '50', '10', '1', 'Il cane salta sul divano');

insert into quizarispostaaperta
values('Domanda2d', 'descrivi il procedimento', 'come convertire un numero da decimale a binario?', '100', '10', '1', 'Il cane salta sul divano');

insert into quizarispostaaperta
values('Domanda3d', 'descrivi il procedimento', 'come convertire un numero da binario a esadecimale?', '100', '10', '1', 'Il cane salta sul divano');

insert into quizarispostaaperta
values('Domanda4d', 'scrivi solamente la definizione', 'dove sta la cache?', '100', '10', '1', 'Il cane salta sul divano');

insert into quizarispostaaperta
values('Domanda1e', 'scrivi la definizione', 'Cosa è una matrice?', '100', '10', '1', 'Non fa per me');

insert into quizarispostaaperta
values('Domanda2e', 'scrivi la definizione', 'Cosa è il rango di una matrice?', '100', '10', '1', 'Non fa per me');

insert into quizarispostaaperta
values('Domanda3e', 'scrivi la definizione', 'Cosa è il pivot?', '50', '10', '1', 'Non fa per me');

insert into quizarispostaaperta
values('Domanda1f', 'scrivi un algoritmo che vuoi, però deve essere corretto', 'come si ordina una matrice?', '1000', '10', '1', 'Mizzica');

insert into quizarispostaaperta
values('Domanda2f', 'scrivi un algoritmo che vuoi, però deve essere corretto', 'come si ordina una lista?', '1000', '10', '1', 'Mizzica');

insert into quizarispostaaperta
values('Domanda1g', 'scrivi rispetto a cosa agisce', 'Dove agisce la forza di Lorentz?', '100', '10', '1', 'Cucine Stellate');

insert into quizarispostaaperta
values('Domanda2g', 'scrivi soltanto se pesi di più o di meno o zero', 'Se posizionassi sotto i tuoi piedi una bilancia mentre sei dentro un ascensore in caduta libera quale sarebbe il tuo peso?', '100', '10', '1', 'Cucine Stellate');

insert into quizarispostaaperta
values('Domanda3g', 'scrivi il nome', 'Come si chiama la legge delle maglie di un circuito elettrico?', '30', '10', '1', 'Cucine Stellate');

insert into quizarispostaaperta
values('Domanda4g', 'come deve essere considerata la carica per far si che valga la legge di Coulomb', 'Quando vale la legge di Coulomb?', '100', '10', '1', 'Cucine Stellate');

insert into quizarispostaaperta
values('Domanda5g', 'scrivi solo cosa rimane costante, se vuoi scrivi anche la formula per farmelo capire', 'Cosa rimane costante nel moto circolare uniforme?', '20', '10', '1', 'Cucine Stellate');

insert into quizarispostaaperta
values('Domanda1h', 'definisci', 'cosa è una entità?', '100', '10', '1', 'Salernitana');

insert into quizarispostaaperta
values('Domanda2h', 'definisci la relazione', 'cosa è una relazione', '100', '10', '1', 'Salernitana');

insert into quizarispostaaperta
values('Domanda3h', 'dimmi la struttura', 'come è strutturata una query in SQL?', '20', '10', '1', 'Salernitana');

insert into quizarispostaaperta
values('Domanda1i', 'definire javadoc', 'cosa è javadoc', '100', '10', '1', 'Procida');

insert into quizarispostaaperta
values('Domanda2i', 'definire la gui', 'cosa è una gui', '100', '10', '1', 'Procida');

insert into quizarispostaaperta
values('Domanda3i', 'definizione di sequence diagram', 'cosa è un sequence diagram', '100', '10', '1', 'Procida');

insert into quizarispostaaperta
values('Domanda1j', 'scrivi solo il costo', 'quanto costa Build Heap', '10', '10', '1', 'Naive');

insert into quizarispostaaperta
values('Domanda2j', 'scrivi solo il costo', 'quanto costa Heapify', '10', '10', '1', 'Naive');

insert into quizarispostaaperta
values('Domanda3j', 'scrivi solo il costo e dimmi anche qual è il caso peggiore e il caso migliore', 'quanto costa Heapsort', '10', '10', '1', 'Naive');

insert into quizarispostaaperta
values('Domanda1k', 'Definiscimi un linguaggio Contex-Free', 'Cosa è un linguaggio Contex-Free?', '100', '10', '1', 'Etica delle Macchine');

insert into quizarispostaaperta
values('Domanda2k', 'scrivere solo le operazioni di base', 'Quali sono i comandi base in un S-programma?', '100', '10', '1', 'Etica delle Macchine');

insert into quizarispostaaperta
values('Domanda1l', 'definisci una macchina astratta in generale', 'Cosa è una macchina astratta?', '100', '10', '1', 'Game Design');

insert into quizarispostaaperta
values('Domanda2l', 'definiscilo in generale', 'cosa è un linguaggio di programmazione?', '100', '10', '1', 'Game Design');

insert into quizarispostaaperta
values('Domanda3l', 'dimmi la proprietà', 'cosa è un linguaggio completo?', '20', '10', '1', 'Game Design');

insert into quizarispostaaperta
values('Domanda1m', 'definiscimi il PM', 'chi è il PM?', '100', '10', '1', 'SSRI');

insert into quizarispostaaperta
values('Domanda2m', 'definisci computer forensics', 'cosa è il computer forensics?', '100', '10', '1', 'SSRI');

insert into quizarispostaaperta
values('Domanda1n', 'definisci un sistema operativo', 'cosa è un S.O?', '100', '10', '1', 'Fozza Napoli');

insert into quizarispostaaperta
values('Domanda2n', 'definisci il thread', 'cosa è un thread?', '100', '10', '1', 'Fozza Napoli');

insert into quizarispostaaperta
values('Domanda3n', 'definisci il processo', 'cosa è un processo?', '100', '10', '1', 'Fozza Napoli');

insert into quizarispostaaperta
values('Domanda1o', 'definisci le proprietà dei alberi binari di ricerca', 'quali sono le proprietà di un ABR', '1000', '10', '1', 'Mission Impossible');

insert into quizarispostaaperta
values('Domanda2o', 'rispondere solo con si o no', 'un AVL è un ABR?', '2', '10', '1', 'Mission Impossible');

insert into quizarispostaaperta
values('Domanda1p', 'scrivi le differenze', 'Che differenza ci sta tra allocazione statica e allocazione dinamica?', '10', '10', '1', 'Banalmente');

insert into quizarispostaaperta
values('Domanda2p', 'scrivere solo il numero di byte', 'quanti byte servono per rappresentare un char?', '2', '10', '1', 'Banalmente');

insert into quizarispostaaperta
values('Domanda3p', 'scrivere solo il numero di byte', 'quanti byte servono per rappresentare un int?', '2', '10', '1', 'Banalmente');

insert into quizarispostaaperta
values('Domanda1q', 'definisci la JVM', 'cosa è la JVM?', '100', '10', '1', 'E Vabbuò');

insert into quizarispostaaperta
values('Domanda2q', 'se dai un parere negativo, ti lincio.', 'quanto è bella Procida?', '100', '10', '1', 'E Vabbuò');

insert into quizarispostaaperta
values('Domanda1r', 'definisci il cursore', 'cosa è un cursore?', '100', '10', '1', 'Bonazzoli');

insert into quizarispostaaperta
values('Domanda2r', 'scrivi solo la differenza', 'che differenza ci sta tra varchar e char in SQL?', '100', '10', '1', 'Bonazzoli');


insert into quizarispostamultipla
values('Domanda1aa', 'metti una delle 4 opzioni', 'radice di 144 è uguale a: 12@13@9@14', '1', '-1', 'La Magica Roma', 'A');

insert into quizarispostamultipla
values('Domanda2aa', 'metti una delle 4 opzioni', '12-3*4 fa: 0@36@-3@1', '1', '-1', 'La Magica Roma', 'A');

insert into quizarispostamultipla
values('Domanda3aa', 'metti una delle 3 opzioni', 'il coseno di pi greco mezzi è: 0@1@1/2', '1', '-1', 'La Magica Roma', 'A');

insert into quizarispostamultipla
values('Domanda1bb', 'rispondi', 'in una espressione si fa prima: moltiplicazione@sottrazione', '1', '-1', 'Algebra nel cuore', 'A');

insert into quizarispostamultipla
values('Domanda2bb', 'rispondi', '3^2 cosa indica? 3*3@3-3', '1', '-1', 'Algebra nel cuore', 'A');

insert into quizarispostamultipla
values('Domanda3bb', 'rispondi', 'è bello studiare: si@no', '1', '-1', 'Algebra nel cuore', 'B');

insert into quizarispostamultipla
values('Domanda1cc', 'rispondi', 'Per il linguaggio C, l’istruzione if identifica una struttura di controllo: ricorsione@sequenza@iterativa@condizionale', '1', '-1', 'Aspettate 10 minuti', 'D');

insert into quizarispostamultipla
values('Domanda1dd', 'rispondi', 'Per il linguaggio C, le variabili locali hanno per default: uno scope relativo al file sorgente in cui sono dichiarate@una durata di memorizzazione statica@una durata di memorizzazione automatica@uno scope relativo all’intero programma', '1', '-1', 'Il cane salta sul divano', 'C');

insert into quizarispostamultipla
values('Domanda1ee', 'il * sta per prodotto scalare', 'a*b con alfa = 0 fa: a*b@a/b', '1', '-1', 'Non fa per me', 'A');

insert into quizarispostamultipla
values('Domanda2ee', 'il * sta prodotto vettoriale', 'a*b se a e b sono paralleli fa: 0@a*b@a/b', '1', '-1', 'Non fa per me', 'A');

insert into quizarispostamultipla
values('Domanda1ff', 'intendo dire ... main() etc', 'in c cosa che tipo metti prima della parola main: int@float@varchar', '1', '-1', 'Mizzica', 'A');

insert into quizarispostamultipla
values('Domanda1gg', 'cgs sono i: (cm, g, s)', 'Nel sistema cgs la unità di misura della energia è: Watt@Dina@Erg@Joule@Caloria', '1', '-1', 'Cucine Stellate', 'C');

insert into quizarispostamultipla
values('Domanda2gg', 'rispondi', 'Quali delle seguenti grandezze ha un carattere vettoriale? Energia cinetica@Massa@Momento Angolare@Temperatura', '1', '-1', 'Cucine Stellate', 'C');

insert into quizarispostamultipla
values('Domanda3gg', 'rispondi', 'la temperatura si misura in: kelvin@litri@kilometri@secondi', '1', '-1', 'Cucine Stellate', 'A');

insert into quizarispostamultipla
values('Domanda4gg', 'i 3 numeri sono in gradi celsius', 'il ghiaccio fonde a: 0@10@20@dipende dalla pressione', '1', '-1', 'Cucine Stellate', 'D');

insert into quizarispostamultipla
values('Domanda5gg', 'rispondi', 'il vetro è: solido cristallino@solido amorfo@liquido', '1', '-1', 'Cucine Stellate', 'B');

insert into quizarispostamultipla
values('Domanda1hh', 'dai che è facile', 'di che colore è la maglia? granata@rossa@blu', '1', '-1', 'Salernitana', 'A');

insert into quizarispostamultipla
values('Domanda2hh', 'anche questa', 'quando è stata fondata la squadra salernitana? 1919@1920@1918@1921', '1', '-1', 'Salernitana', 'A');

insert into quizarispostamultipla
values('Domanda3hh', 'dai che è semplice', 'qual è stato il primo anno in cui è salita in seria A? 1947/48@1997/98@2020/21', '1', '-1', 'Salernitana', 'A');

insert into quizarispostamultipla
values('Domanda1ii', 'questa è per riscaldarci', 'un abitante di procida, come si chiama? procidano@procidese@procido', '1', '-1', 'Procida', 'A');

insert into quizarispostamultipla
values('Domanda2ii', 'attento è a trabbocchetto', 'quale delle 3 isole campane è più bella? capri@procida@ischia', '1', '-1', 'Procida', 'B');

insert into quizarispostamultipla
values('Domanda1jj', 'attento', 'il meme di asd qual è? è naive@in loco/in place@ la legge della strada@ tutte e tre', '1', '-1', 'Naive', 'D');

insert into quizarispostamultipla
values('Domanda2jj', 'banale', 'gli alberi R&B è stato ogetto di ilarità? si@no', '1', '-1', 'Naive', 'A');

insert into quizarispostamultipla
values('Domanda3jj', 'uhmmmmmmm', 'naive cosa vuol dire? facile@e un nome di un algoritmo', '1', '-1', 'Naive', 'A');

insert into quizarispostamultipla
values('Domanda1kk', 'F', 'il cielo di mattina di che colore è? rosso@blu@nero@azzurro', '1', '-1', 'Etica delle Macchine', 'D');

insert into quizarispostamultipla
values('Domanda2kk', 'non farti ingannare dalle apparenze', 'Il professore di fisica come mi chiamava? Marco Pastore@Mattia Torre', '1', '-1', 'Etica delle Macchine', 'B');

insert into quizarispostamultipla
values('Domanda1ll', 'attenzione e non fare lo scostumato :)', 'a tavola con degli sconosciuti si fanno i ruttini? si@no', '1', '-1', 'Game Design', 'B');

insert into quizarispostamultipla
values('Domanda2ll', 'attenzione', 'chi ha popolato questa base di dati? boh@io@tu', '1', '-1', 'Game Design', 'B');

insert into quizarispostamultipla
values('Domanda3ll', 'è a tranello', 'Perchè le domande diventano sempre meno sensate? perchè mi va così@perchè dopo aver scritto 100 domande non hai più fantasia', '1', '-1', 'Game Design', 'B');

insert into quizarispostamultipla
values('Domanda4ll', 'questa è tosta', 'il panino ca meusa è meglio: maritata@schietta', '1', '-1', 'Game Design', 'A');

insert into quizarispostamultipla
values('Domanda1mm', 'attento, è un tranello', 'youngtambu e tambu sono la stessa persona? si@no', '1', '-1', 'SSRI', 'A');

insert into quizarispostamultipla
values('Domanda2mm', 'lo slang è quello, ma rispondi bene', '4L cosa vuol dire? forlife@gang', '1', '-1', 'SSRI', 'A');

insert into quizarispostamultipla
values('Domanda1nn', 'ok questa è semplice', 'Che squadra tifa il professor Balzano? napoli@juventus@milan', '1', '-1', 'Fozza Napoli', 'A');

insert into quizarispostamultipla
values('Domanda2nn', 'attento, non confonderti', 'qual è il simbolo del napoli? il ciuccio@la lupa@il davolo', '1', '-1', 'Fozza Napoli', 'A');

insert into quizarispostamultipla
values('Domanda1oo', 'è naive', 'il 22/03/2022 passerò ASD? si@no', '1', '-1', 'Mission Impossible', 'B');

insert into quizarispostamultipla
values('Domanda2oo', 'se sai la prima, sai anche la seconda', 'se è si, passerò la parte orale? si@tanto non ci arrivo', '1', '-1', 'Mission Impossible', 'B');

insert into quizarispostamultipla
values('Domanda1pp', 'attento, può essere un trabbochetto, ma qui...', 'un concetto è: banale@naive', '1', '-1', 'Banalmente', 'A');

insert into quizarispostamultipla
values('Domanda2pp', 'può essere un prank', 'quanto è banale il banale? troppo@per niente', '1', '-1', 'Banalmente', 'A');

insert into quizarispostamultipla
values('Domanda1qq', 'cultura trap', 'niko pandetta è: napoletano@procidano@catanese', '1', '-1', 'E Vabbuò', 'C');

insert into quizarispostamultipla
values('Domanda2qq', 'ascolta salvatore di paky', 'chi è salvatore? lo zio di paky@il padre di paky@paky', '1', '-1', 'E Vabbuò', 'A');

insert into quizarispostamultipla
values('Domanda3qq', 'è dura, ma la risposta è più semplice di quel che pensi', 'chi è il king del rap? marra@gue@fibra@jake la furia', '1', '-1', 'E Vabbuò', 'A');

insert into quizarispostamultipla
values('Domanda1rr', 'pensa allo slang milanese', 'chi è zzala? lazza@sfera@marra@capo plaza', '1', '-1', 'Bonazzoli', 'A');

insert into quizarispostamultipla
values('Domanda2rr', 'è easy', 'Perchè gue pequeno si chiama adesso solo gue? perchè ormai è grande@per sfizio', '1', '-1', 'Bonazzoli', 'A');

insert into quizarispostamultipla
values('Domanda3rr', 'pensa beneeee', 'gg sta per? good game@ giorno gino@ graygin', '1', '-1', 'Bonazzoli', 'A');
insert into scelta
values('Ostico@gmail.com', 'La Magica Roma', NULL, 'false', NULL, 'false');

insert into scelta
values('Ostico@gmail.com', 'Algebra nel cuore', '1.2', 'true', '19/02/2021', 'true');

insert into scelta
values('+agebra@yahoo.com', 'Aspettate 10 minuti', NULL, 'false', NULL, 'false');

insert into scelta
values('scomparso@libero.it', 'Il cane salta sul divano', NULL, 'false', NULL, 'false');

insert into scelta
values('davideeeee@outlook.com', 'Non fa per me', '1.2', 'true', '12/01/2021', 'true');

insert into scelta
values('nikopandetta@libero.it', 'Mizzica', '2.3', 'true', '16/02/2021', 'true');

insert into scelta
values('fcioffi@hotmail.com', 'Cucine Stellate', '1.5', 'true', '18/02/2022', 'true');

insert into scelta
values('nicoromito@libero.it', 'Salernitana', NULL, 'false', '12/07/2021', 'true');

insert into scelta
values('forzasalerno@libero.it', 'Salernitana', '1.1', 'true', '12/09/2021', 'true');

insert into scelta
values('chebbellaprocida@libero.it', 'Procida', '2.8', 'true', '12/02/2021', 'true');

insert into scelta
values('inplace@gmail.com', 'Naive', NULL, 'false', NULL, 'false');

insert into scelta
values('etica@hotmail.com', 'Naive', NULL, 'false', NULL, 'false');

insert into scelta
values('inplace@gmail.com', 'Etica delle Macchine', NULL, 'false', '12/07/2022', 'true');

insert into scelta
values('scomparso@libero.it', 'Game Design', '1.6', 'true', '19/02/2022', 'true');

insert into scelta
values('fcioffi@hotmail.com', 'SSRI', NULL, 'false', NULL, 'false');

insert into scelta
values('nikopandetta@libero.it', 'Fozza Napoli', NULL, 'false', NULL, 'true');

insert into scelta
values('forzasalerno@libero.it', 'Mission Impossible', NULL, 'false', NULL, 'false');

insert into scelta
values('chebbellaprocida@libero.it', 'Banalmente', '1.6', 'true', '19/04/2021', 'true');

insert into scelta
values('etica@hotmail.com', 'E Vabbuò', NULL, 'false', NULL, 'false');

insert into scelta
values('nicoromito@libero.it', 'Bonazzoli', '2.6', 'true', '09/03/2022', 'true');

insert into rispostamultipla
values('Ostico@gmail.com', 'Domanda1bb', 'B', '-1');

insert into rispostamultipla
values('Ostico@gmail.com', 'Domanda2bb', 'A', '1');

insert into rispostamultipla
values('Ostico@gmail.com', 'Domanda3bb', 'B', '1');

insert into rispostamultipla
values('davideeeee@outlook.com', 'Domanda1ee', 'A', '-1');

insert into rispostamultipla
values('davideeeee@outlook.com', 'Domanda2ee', 'A', '1');

insert into rispostamultipla
values('nikopandetta@libero.it', 'Domanda1ff', 'A', '1');

insert into rispostamultipla
values('fcioffi@hotmail.com', 'Domanda1gg', 'B', '-1');

insert into rispostamultipla
values('fcioffi@hotmail.com', 'Domanda2gg', 'B', '-1');

insert into rispostamultipla
values('fcioffi@hotmail.com', 'Domanda3gg', 'A', '1');

insert into rispostamultipla
values('fcioffi@hotmail.com', 'Domanda4gg', 'D', '1');

insert into rispostamultipla
values('fcioffi@hotmail.com', 'Domanda5gg', 'B', '1');

insert into rispostamultipla
values ('forzasalerno@libero.it', 'Domanda1hh', 'A', '1');

insert into rispostamultipla
values ('nicoromito@libero.it', 'Domanda1hh', 'B', '-1');

insert into rispostamultipla
values ('forzasalerno@libero.it', 'Domanda2hh', 'A', '1');

insert into rispostamultipla
values ('nicoromito@libero.it', 'Domanda2hh', 'B', '-1');

insert into rispostamultipla
values ('forzasalerno@libero.it', 'Domanda3hh', 'A', '1');

insert into rispostamultipla
values ('nicoromito@libero.it', 'Domanda3hh', 'B', '-1');

insert into rispostamultipla
values('chebbellaprocida@libero.it', 'Domanda1ii', 'A', '1');

insert into rispostamultipla
values('chebbellaprocida@libero.it', 'Domanda2ii', 'B', '1');

insert into rispostamultipla
values('inplace@gmail.com', 'Domanda1kk', 'D', '1');

insert into rispostamultipla
values('inplace@gmail.com', 'Domanda2kk', 'B', '1');

insert into rispostamultipla
values('scomparso@libero.it', 'Domanda1ll', 'B', '1');

insert into rispostamultipla
values('scomparso@libero.it', 'Domanda2ll', 'A', '-1');

insert into rispostamultipla
values('scomparso@libero.it', 'Domanda3ll', 'B', '1');

insert into rispostamultipla
values('scomparso@libero.it', 'Domanda4ll', 'A', '1');

insert into rispostamultipla
values('nikopandetta@libero.it', 'Domanda1nn', 'B', '-1');

insert into rispostamultipla
values('nikopandetta@libero.it', 'Domanda2nn', 'A', '1');

insert into rispostamultipla
values('chebbellaprocida@libero.it', 'Domanda1pp', 'A', '1');

insert into rispostamultipla
values('chebbellaprocida@libero.it', 'Domanda2pp', 'A', '1');

insert into rispostamultipla
values('nicoromito@libero.it', 'Domanda1rr', 'A', '1');

insert into rispostamultipla
values('nicoromito@libero.it', 'Domanda2rr', 'B', '-1');

insert into rispostamultipla
values('nicoromito@libero.it', 'Domanda3rr', 'C', '1');

insert into rispostaaperta
values('Ostico@gmail.com', 'tidevouncaffe@libero.it', 'Domanda1b', 'la cipolla', '2', 'true');

insert into rispostaaperta
values('Ostico@gmail.com', 'tidevouncaffe@libero.it', 'Domanda2b', 'yeah', '2', 'true');

insert into rispostaaperta
values('Ostico@gmail.com', 'tidevouncaffe@libero.it', 'Domanda3b', 'daii', '2', 'true');

insert into rispostaaperta
values('davideeeee@outlook.com', 'nessunosaniente@libero.it', 'Domanda1e', 'uau', '2', 'true');

insert into rispostaaperta
values('davideeeee@outlook.com', 'nessunosaniente@libero.it', 'Domanda2e', 'yeahu', '2', 'true');

insert into rispostaaperta
values('davideeeee@outlook.com', 'nessunosaniente@libero.it', 'Domanda3e', 'uaaausa', '2', 'true');

insert into rispostaaperta
values('nikopandetta@libero.it', 'spotify@libero.it', 'Domanda1f', 'lol', '3', 'true');

insert into rispostaaperta
values('nikopandetta@libero.it', 'spotify@libero.it', 'Domanda2f', 'lol2', '3', 'true');

insert into rispostaaperta
values('fcioffi@hotmail.com', 'sparea@libero.it', 'Domanda1g', 'uauuu', '2', 'true');

insert into rispostaaperta
values('fcioffi@hotmail.com', 'sparea@libero.it', 'Domanda2g', 'lalo', '1', 'true');

insert into rispostaaperta
values('fcioffi@hotmail.com', 'sparea@libero.it', 'Domanda3g', 'malo', '3', 'true');

insert into rispostaaperta
values('fcioffi@hotmail.com', 'sparea@libero.it', 'Domanda4g', 'skuuu', '2', 'true');

insert into rispostaaperta
values('fcioffi@hotmail.com', 'sparea@libero.it', 'Domanda5g', 'gang', '4', 'true');

insert into rispostaaperta
values('forzasalerno@libero.it', 'echiaro@gmail.com', 'Domanda1h', 'il salerno', '1', 'true');

insert into rispostaaperta
values('forzasalerno@libero.it', 'echiaro@gmail.com', 'Domanda2h', 'è', '1', 'true');

insert into rispostaaperta
values('forzasalerno@libero.it', 'echiaro@gmail.com', 'Domanda3h', 'trap', '1.5', 'true');

insert into rispostaaperta
values('nicoromito@libero.it', 'echiaro@gmail.com', 'Domanda1h', 'non mi hai corretto ancora', NULL, 'false');

insert into rispostaaperta
values('nicoromito@libero.it', 'echiaro@gmail.com', 'Domanda2h', 'posso farcela a passare', NULL, 'false');

insert into rispostaaperta
values('nicoromito@libero.it', 'echiaro@gmail.com', 'Domanda3h', 'siuuuuuuuuuuum', NULL, 'false');

insert into rispostaaperta
values('chebbellaprocida@libero.it', 'cmascia@libero.it', 'Domanda1i', 'bella', '2', 'true');

insert into rispostaaperta
values('chebbellaprocida@libero.it', 'cmascia@libero.it', 'Domanda2i', 'viva procida', '4', 'true');

insert into rispostaaperta
values('chebbellaprocida@libero.it', 'cmascia@libero.it', 'Domanda3i', 'amo procida', '6', 'true');

insert into rispostaaperta
values('inplace@gmail.com', 'unultimopezzo@libero.it', 'Domanda1k', 'fallo', NULL, 'false');

insert into rispostaaperta
values('inplace@gmail.com', 'unultimopezzo@libero.it', 'Domanda2k', 'cartellino giallo', NULL, 'false');

insert into rispostaaperta
values('scomparso@libero.it', 'gmercorio@gmail.com', 'Domanda1l', 'napoliii', '2', 'true');

insert into rispostaaperta
values('scomparso@libero.it', 'gmercorio@gmail.com', 'Domanda2l', 'fozza napoli ammo', '3', 'true');

insert into rispostaaperta
values('scomparso@libero.it', 'gmercorio@gmail.com', 'Domanda3l', 'però la roma è sempre la roma', '4', 'true');

insert into rispostaaperta
values('nikopandetta@libero.it', 'vengolaprossimavolta@gmail.com', 'Domanda1n', 'allo', NULL, 'false');

insert into rispostaaperta
values('nikopandetta@libero.it', 'vengolaprossimavolta@gmail.com', 'Domanda2n', 'ci vediamo', NULL, 'false');

insert into rispostaaperta
values('nikopandetta@libero.it', 'vengolaprossimavolta@gmail.com', 'Domanda3n', 'domani', NULL, 'false');

insert into rispostaaperta
values('chebbellaprocida@libero.it', 'insertionsort@gmail.com', 'Domanda1p', 'ya', '1', 'true');

insert into rispostaaperta
values('chebbellaprocida@libero.it', 'insertionsort@gmail.com', 'Domanda2p', 'ma', '1', 'true');

insert into rispostaaperta
values('chebbellaprocida@libero.it', 'insertionsort@gmail.com', 'Domanda3p', 'uauh', '4', 'true');

insert into rispostaaperta
values('nicoromito@libero.it', 'echiaro@gmail.com', 'Domanda1r', 'ciao', '1', 'true');

insert into rispostaaperta
values('nicoromito@libero.it', 'echiaro@gmail.com', 'Domanda2r', 'finalmente ho finito di popolare', '10', 'true');