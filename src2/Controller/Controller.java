package Controller;

/**
 * il controller è quella classe che serve a collegare le GUI con le DAO e il Model. In questo caso,
 * per questo progetto ci metteremo solo una classe all'interno del package controller
 */

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import GUI.CreaQuizRispostaMultipla;
import GUI.ScegliTestSvolgere;
import ImplementazioneDAO.ImplementazioneInsegnanteDAO;
import ImplementazioneDAO.ImplementazioneQuizARispostaApertaDAO;
import ImplementazioneDAO.ImplementazioneQuizARispostaMultiplaDAO;
import ImplementazioneDAO.ImplementazioneQuizAperteDAO;
import ImplementazioneDAO.ImplementazioneQuizMultipleDAO;
import ImplementazioneDAO.ImplementazioneRispostaApertaDAO;
import ImplementazioneDAO.ImplementazioneSceltaDAO;
import ImplementazioneDAO.ImplementazioneStudenteDAO;
import ImplementazioneDAO.ImplementazioneStudenteDAO;
import ImplementazioneDAO.ImplementazioneTestDAO;
import model.*;

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
		try {
			in = new ImplementazioneInsegnanteDAO();
			s = new ImplementazioneStudenteDAO();
			t = new ImplementazioneTestDAO();
			qra = new ImplementazioneQuizARispostaApertaDAO();
			qrm = new ImplementazioneQuizARispostaMultiplaDAO();
			qa = new ImplementazioneQuizAperteDAO();
			qm = new ImplementazioneQuizMultipleDAO();
			ra = new ImplementazioneRispostaApertaDAO();
			sc = new ImplementazioneSceltaDAO();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
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
	
	public boolean AggiornamentoScelta(String nomestudente, float[] voti, int conto, String nometest) {
		float resM= qm.RisultatoMultiple(nomestudente,nometest);
		System.out.print("\n\n\n"+resM+"\n\n\n");
		boolean ok = sc.AggiornamentoScelta(nomestudente, voti, conto,nometest,resM);
		return ok;
	}
	
	
	public DefaultTableModel buildTableModel(int query,Studente st,Insegnante ins) {
		try {
			ResultSet val;
			switch (query) { 
				case 1: val=s.LeggiTest(st); 
				break; 
				case 2: val=s.ConsultaVoti(st);
				break;
				case 3: val=s.PrendiScelte(st);
				break;
				case 4: val=s.LeggiTestS(st);
				break;
				case 5: val=in.PrendiTestCorreggere(ins);
				break;
				case 6: val=in.EliminaTest(ins);
				break;
				default: val=null; 
			}
			
			
			ResultSetMetaData metaData = val.getMetaData();

		    Vector<String> columnNames = new Vector<String>();
		    int columnCount = metaData.getColumnCount();
		    for (int column = 1; column <= columnCount; column++) {
		        columnNames.add(metaData.getColumnName(column));
		    }
		    
		    
		    	
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		    while (val.next()) {
		        Vector<Object> vector = new Vector<Object>();
		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		            vector.add(val.getObject(columnIndex));
		        }
		        data.add(vector);
		    }
		    	
		   
		    
		    DefaultTableModel tmp =new DefaultTableModel(data,columnNames);
		    return tmp;
		    
		   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	    
	}
	
	public void CheckAndStartTest(Test te) {
		boolean check;
		check= t.CheckTest(te);
		if(check) {
			PrendiTest(te);
		}
		
	}
	private void PrendiTest(Test te) {
		
		ResultSet ris=t.PrendiTestAperte(te);
		try {
			int lunghezzaMax;
			float punteggioMax;
			float punteggioMin;
			String nome;
			String descrizione;
			String domanda;
			QuizARispostaAperta quiz;
			while(ris.next()) {
				lunghezzaMax=ris.getInt("lunghezzamax");
				nome=ris.getString("nome");
				descrizione=ris.getString("descrizione");
				domanda=ris.getString("domanda");
				punteggioMax=ris.getFloat("punteggiomax");
				punteggioMin=ris.getFloat("punteggiomin");
				quiz=new QuizARispostaAperta(lunghezzaMax,  punteggioMax,  punteggioMin,  nome,  descrizione ,  domanda);
				te.getQuizAperti().add(quiz);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ris=t.PrendiTestMultiple(te);
		float votoRispostaCorretta;
		float votoRispostaSbagliata;
		String nome;
		String descrizione;
		String domanda;
		char rispostaCorretta;
		QuizARispostaMultipla quiz;
		try {
			while(ris.next()) {
				votoRispostaCorretta=ris.getFloat("votorispostacorretta");
				votoRispostaSbagliata=ris.getFloat("votorispostasbagliata");
				nome=ris.getString("nome");
				descrizione=ris.getString("descrizione");
				domanda=ris.getString("domanda");
				try {
					rispostaCorretta=(char)ris.getCharacterStream("rispostacorretta").read();
					quiz=new QuizARispostaMultipla( votoRispostaCorretta,  votoRispostaSbagliata,  nome,  descrizione,  domanda,  rispostaCorretta);
					te.getQuizMultipla().add(quiz);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ;
	}

	public void salvaScelta(String test,Studente st) {
		try {
			sc.SalvaScelta(test,st.getLogin());
			JOptionPane.showMessageDialog(null,"Inserimento completato");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Già è inserita");
			e.printStackTrace();
		}
		
		
	}

	public void TerminatoTrue(String nometest, Studente st) {
		sc.TerminatoTrue(nometest,st);
		
	}

	public void InserisciTest(String nometest, Studente st) {
		sc.InserisciTest(nometest,st);
		
	}

	public JPanel setTextField(JPanel Panel, JTextField[] textField_2) {
		for(int i=0;i<textField_2.length;i++) {
			Panel.add(textField_2[i]);
		}
		return Panel;
		
	}

	public String PrendiDomanda(JTextField[] textField_2) {
		String descrizione = textField_2[0].getText();
		for(int i=1;i<textField_2.length;i++) {
			descrizione=descrizione+"@"+textField_2[i].getText();
		}
		System.out.print(descrizione);
		return descrizione;
		
	}

	public boolean CheckTestStudente(String test, String studente) {
		if(sc.CheckTestStudente(test,studente)) return true;
		else return false;
		
	}





	public void EliminaTestScelto(String test) {
		try {
			t.setInvalid(test);
			JOptionPane.showMessageDialog(null,"ELIMINAZIONE COMPLETATA");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"ELIMINAZIONE FALLITA");
		}
		
	}





	public void setCorretto(String nometest, Studente st) {
		float resM= qm.RisultatoMultiple(st.getLogin(),nometest);
		sc.UpdateSoloMultiple(resM,st.getLogin(),nometest);
	}
	
	
	public void CheckEmptyTest(String nometest) {
		boolean flag=t.CheckEmptyTest(nometest);
		if(flag)
			t.EliminaTest(nometest);
	}
	
}
