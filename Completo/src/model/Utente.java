package model;

public abstract class Utente {
	private String nome;
	private String password;
	private String login;
	private String cognome;
	
	/**
	 * serve a dichiarare e a settare gli attributi di utente e a creare i costruttori
	 * @param nome dell'utente
	 * @param password per accedere alla piattaforma
	 * @param login la mail
	 * @param cognome dell'utente
	 */
	
	public Utente(String nome, String password, String login, String cognome) {
		this.nome=nome;
		this.cognome=cognome;
		this.login=login;
		this.password=password;
	}
	
	public Utente(String login, String password) {
		this.login=login;
		this.password=password;
	}
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
}
