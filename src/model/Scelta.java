package model;

import java.util.Date;

public class Scelta {

	private float voto;
	private boolean corretto;
	private Date data;
	private boolean termina;
	private Studente studente;
	private Test test;
	
	/**
	 * serve a dichiarare e a settare gli attributi di scelta e a creare i costruttori
	 * @param studente colui che sceglie il test
	 * @param test quello scelto dallo studente
	 * @param data quando viene fatto
	 * @param termina se è terminato o meno
	 * @param corretto se è stato corretto o meno
	 * @param voto del test scelto
	 */
	
	public Scelta(Studente studente , Test test ,Date data, boolean termina , boolean corretto , float voto) {
		this.studente=studente;
		this.test=test;
		this.data=data;
		this.termina=termina;
		this.corretto=corretto;
		this.voto=voto;
	}

	public float getVoto() {
		return voto;
	}

	public void setVoto(float voto) {
		this.voto = voto;
	}

	public boolean isCorretto() {
		return corretto;
	}

	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isTermina() {
		return termina;
	}

	public void setTermina(boolean termina) {
		this.termina = termina;
	}

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	
	
	

}
