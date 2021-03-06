package Model;

import java.util.ArrayList;

public class QuizARispostaMultipla {
	private float votoRispostaCorretta;
	private float votoRispostaSbagliata;
	private String nome;
	private String descrizione;
	private String domanda;
	private char rispostaCorretta;
	private ArrayList<RispostaMultipla> risposte;
	
	public QuizARispostaMultipla(float votoRispostaCorretta, float votoRispostaSbagliata, String nome, String descrizione, String domanda, char rispostaCorretta, ArrayList<RispostaMultipla> risposte){
		this.votoRispostaCorretta=votoRispostaCorretta;
		this.votoRispostaSbagliata=votoRispostaSbagliata;
		this.nome=nome;
		this.descrizione=descrizione;
		this.domanda=domanda;
		this.rispostaCorretta=rispostaCorretta;
		this.risposte=risposte;
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
	public ArrayList<RispostaMultipla> getRisposte() {
		return risposte;
	}
	public void setRisposte(ArrayList<RispostaMultipla> risposte) {
		this.risposte = risposte;
	}
	
}