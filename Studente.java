package model;

public class Studente extends Utente {
	
	public Studente (String nome, String password, String login, String cognome) {
		super(nome, password, login, cognome);
	}
	
	public Studente (String login, String password) {
		super(login,password);
	}
	
}
