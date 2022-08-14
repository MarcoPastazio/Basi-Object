package model;

public class Insegnante extends Utente {

	private String corso;
	
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

	public String getDomanda() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAut() {
		// TODO Auto-generated method stub
		return null;
	}

}
