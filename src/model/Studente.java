package model;

public class Studente extends Utente {
	
	/**
	 * serve a dichiarare e a settare gli attributi di studente e a creare i costruttori
	 * @param nome dello studente
	 * @param password per accedere alla piattaforma
	 * @param login la mail
	 * @param cognome dello studente
	 */
	
	public Studente (String nome, String password, String login, String cognome) {
		super(nome, password, login, cognome);
	}
	
	public Studente (String login, String password) {
		super(login,password);
	}
	
}
