package model;

public class Insegnante extends Utente {

	private String corso;
	
	/**
	 * serve a dichiarare e a settare gli attributi di insegnante e a creare i costruttori
	 * @param nome dell'insegnante
	 * @param password per accedere alla piattaforma
	 * @param login la mail
	 * @param cognome dell'insegnante
	 * @param corso che detiene
	 */
	
	public Insegnante(String nome, String password, String login, String cognome, String corso) {
		super(nome, password, login, cognome);
		this.corso=corso;
	}

	public Insegnante(String login, String password) {
		super(login, password);
	}
	
	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}
}
