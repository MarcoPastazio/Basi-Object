package model;

import java.util.ArrayList;

public class QuizARispostaMultipla {
	private float votoRispostaCorretta;
	private float votoRispostaSbagliata;
	private String nome;
	private String descrizione;
	private String domanda;
	private char rispostaCorretta;
	
	/**
	 * serve a dichiarare e a settare gli attributi di quiz a risposta multipla e a creare i costruttori
	 * @param votoRispostaCorretta il voto se la risposta è corretta
	 * @param votoRispostaSbagliata il voto se la risposta è sbagliata
	 * @param nome il nome della domanda a risposta multipla
	 * @param descrizione le peculiarità che riserva la singola domanda
	 * @param domanda la domanda in se
	 * @param rispostaCorretta tra tutte le risposte, indica quale è la corretta
	 */
	
	public QuizARispostaMultipla(float votoRispostaCorretta, float votoRispostaSbagliata, String nome, String descrizione, String domanda, char rispostaCorretta){
		this.votoRispostaCorretta=votoRispostaCorretta;
		this.votoRispostaSbagliata=votoRispostaSbagliata;
		this.nome=nome;
		this.descrizione=descrizione;
		this.domanda=domanda;
		this.rispostaCorretta=rispostaCorretta;
	}
	
	public float getVotoRispostaCorretta() {
		return votoRispostaCorretta;
	}
	public void setVotoRispostaCorretta(float votoRispostaCorretta) {
		this.votoRispostaCorretta = votoRispostaCorretta;
	}
	public float getVotoRispostaSbagliata() {
		return votoRispostaSbagliata;
	}
	public void setVotoRispostaSbagliata(float votoRispostaSbagliata) {
		this.votoRispostaSbagliata = votoRispostaSbagliata;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getDomanda() {
		return domanda;
	}
	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}
	public char getRispostaCorretta() {
		return rispostaCorretta;
	}
	public void setRispostaCorretta(char rispostaCorretta) {
		this.rispostaCorretta = rispostaCorretta;
	}
	
}
