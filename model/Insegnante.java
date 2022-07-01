package model;

public class Insegnante extends Utente {

	private String corso;
	
	public Insegnante(String nome, String password, String login, String cognome, String corso) {
		super(nome, password, login, cognome);
		this.corso=corso;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

}
