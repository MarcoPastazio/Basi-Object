package Controller;

import java.time.LocalDate;
import java.util.Date;

import ImplementazioneDAO.*;
import Model.*; 

public class Controller {
	
	private ImplementazioneInsegnanteDAO in;
	private ImplementazioneStudenteDAO s;
	private ImplementazioneTestDAO t;
	private ImplementazioneQuizARispostaApertaDAO qa;
	private ImplementazioneQuizARispostaMultiplaDAO qm;
	
	
	public Controller() {
		in = new ImplementazioneInsegnanteDAO();
		s = new ImplementazioneStudenteDAO();
		t = new ImplementazioneTestDAO();
		qa = new ImplementazioneQuizARispostaApertaDAO();
		qm = new ImplementazioneQuizARispostaMultiplaDAO();
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
		boolean ok = qa.SalvaQuizAperta(nomedomanda, descrizione, domanda, lunghezzamax, punteggiomax, punteggiomin, nometest);//devo cambiare
		return ok;
	}
	
	public boolean SalvaQuizMultipla(String nomedomanda, String descrizione, String domanda, float votorispostacorretta, float votorispostasbagliata, String nometest, String rispostacorretta) {
		boolean ok = qm.SalvaQuizMultipla(nomedomanda, descrizione, domanda, votorispostacorretta, votorispostasbagliata, nometest, rispostacorretta);
		return ok;
	}
}
