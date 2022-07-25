package Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import ImplementazioneDAO.*;
import Model.*; 

public class Controller {
	
	private ImplementazioneInsegnanteDAO in;
	private ImplementazioneStudenteDAO s;
	private ImplementazioneTestDAO t;
	private ImplementazioneQuizARispostaApertaDAO qra;
	private ImplementazioneQuizARispostaMultiplaDAO qrm;
	private ImplementazioneQuizAperteDAO qa;
	private ImplementazioneQuizMultipleDAO qm;
	private ImplementazioneRispostaApertaDAO ra;
	private ImplementazioneSceltaDAO sc;
	
	
	public Controller() {
		in = new ImplementazioneInsegnanteDAO();
		s = new ImplementazioneStudenteDAO();
		t = new ImplementazioneTestDAO();
		qra = new ImplementazioneQuizARispostaApertaDAO();
		qrm = new ImplementazioneQuizARispostaMultiplaDAO();
		qa = new ImplementazioneQuizAperteDAO();
		qm = new ImplementazioneQuizMultipleDAO();
		ra = new ImplementazioneRispostaApertaDAO();
		sc = new ImplementazioneSceltaDAO();
	}
	
	//le varie creazioni delle classi
	public Studente CreaStudente(String login, String password) {
		Studente st = new Studente(login, password);
		return st;
	}
	
	public Insegnante CreaInsegnante(String login, String password) {
		Insegnante ins = new Insegnante(login, password);
		return ins;
	}
	
	//
	public boolean LoginB(Studente st) {
		boolean ok = s.LoginB(st);
		return ok;
	}
	
	public void Login(Studente st) {
		s.Login(st);
	}
	
	public boolean LoginB(Insegnante ins) {
		boolean ok = in.LoginB(ins);
		return ok;
	}
	
	public void Login(Insegnante ins) {
		in.Login(ins);
	}
	
	public boolean RegistrazioneI(Insegnante ins) {
		boolean ok = in.Registrazione(ins);
		return ok;
	}
	
	public boolean RegistrazioneS(Studente st) {
		boolean ok = s.Registrazione(st);
		return ok;
	}
	
	//per la parte della registrazione del test
	public boolean RegistrazioneTest(Insegnante ins, String nometest, int durata) {
		boolean ok = t.RegistrazioneTest(ins, nometest, durata);
		return ok;
	}
	//per la parte del salvataggio dei quiz a risposta multipla e aperta
	
	public boolean SalvaQuizAperta(String nomedomanda, String descrizione, String domanda, int lunghezzamax, double punteggiomax, double punteggiomin, String nometest) {
		boolean ok = qra.SalvaQuizAperta(nomedomanda, descrizione, domanda, lunghezzamax, punteggiomax, punteggiomin, nometest);//devo cambiare
		return ok;
	}
	
	public int ControlloLunghezza(String nome) {
		int check = qra.ControlloLunghezza(nome);
		return check;
	}
	
	public boolean SalvaQuizMultipla(String nomedomanda, String descrizione, String domanda, float votorispostacorretta, float votorispostasbagliata, String nometest, String rispostacorretta) {
		boolean ok = qrm.SalvaQuizMultipla(nomedomanda, descrizione, domanda, votorispostacorretta, votorispostasbagliata, nometest, rispostacorretta);
		return ok;
	}
	
	public String RicavoDomanda(String nometest, int conto, int indice) {
		String ris = qa.RicavoDomanda(nometest, conto, indice);
		return ris;
	}
	
	public ArrayList<String> RicavoDomandaA(String nometest, int conto){
		ArrayList<String> ris = qa.RicavoDomandaA(nometest, conto);
		return ris;
	}
	
	
	public String RicavoNome(String nometest, int conto, int indice){
		String ris = qa.RicavoNome(nometest, conto, indice);
		return ris;
	}
	
	public String RicavoDescrizione(String nometest, int conto, int indice){
		String ris = qa.RicavoDescrizione(nometest, conto, indice);
		return ris;
	}
	
	public int ConteggioDomande (String nometest) {
		int conto = qa.ConteggioDomande(nometest);
		return conto;
	}
	
	public String NomeProf(String nometest) {
		String nomeprof = qa.NomeProf(nometest);
		return nomeprof;
	}
	
	public boolean Rispostaaperta(String nomest, String nomeins, ArrayList<String> domandeaperte, String[] aperte, int contoaperte) {
		boolean ok = qa.Rispostaaperta(nomest, nomeins, domandeaperte, aperte, contoaperte);
		return ok;
	}
	
	public int ConteggioDomandeM (String nometest) {
		int conto = qm.ConteggioDomandeM(nometest);
		return conto;
	}
	
	public String RicavoDomandaM(String nometest, int conto, int indice) {
		String ris = qm.RicavoDomandaM(nometest, conto, indice);
		return ris;
	}
	
	public ArrayList<String> RicavoDomandeM(String nometest, int conto){
		ArrayList<String> ris = qm.RicavoDomandeM(nometest, conto);
		return ris;
	}
	
	public String RicavoNomeM(String nometest, int conto, int indice){
		String ris = qm.RicavoNomeM(nometest, conto, indice);
		return ris;
	}
	
	public String RicavoDescrizioneM(String nometest, int conto, int indice){
		String ris = qm.RicavoDescrizioneM(nometest, conto, indice);
		return ris;
	}
	
	public boolean Rispostamultipla(String nomest, ArrayList<String> domandemultiple, String[] multiple, int contomultiple) {
		boolean ok = qm.Rispostamultipla(nomest, domandemultiple, multiple, contomultiple);
		return ok;
	}
	
	public ArrayList<Float>PunteggioMax(String nometest, int conto) {
		ArrayList<Float> ris = qra.PunteggioMax(nometest, conto);
		return ris;
	}
	
	public ArrayList<Float>PunteggioMin(String nometest, int conto) {
		ArrayList<Float> ris = qra.PunteggioMin(nometest, conto);
		return ris;
	}
	
	public String RicavoRisposta(String nometest, String nomestudente, int conto, int indice) {
		String ris = ra.RicavoRisposta(nometest, nomestudente, conto, indice);
		return ris;
	}
	
	public boolean AggiornamentoRispostaAperta(ArrayList<String> DomandeTest, String nomestudente, int conto, float[] voti) {
		boolean ok = ra.AggiornamentoRispostaAperta(DomandeTest, nomestudente, conto, voti);
		return ok;
	}
	
	public boolean AggiornamentoScelta(String nomestudente, float[] voti, int conto) {
		boolean ok = sc.AggiornamentoScelta(nomestudente, voti, conto);
		return ok;
	}
}
