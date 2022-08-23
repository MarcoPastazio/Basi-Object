package model;

public class RispostaStudenteMultipla {
	private char lettera;
	private float voto;
	private Studente studente;
	private QuizARispostaMultipla quiz;
	
	/**
	 * serve a dichiarare e a settare gli attributi di risposta studente multipla e a creare i costruttori
	 * @param lettera indica una delle risposte possibili
	 * @param voto come viene valutata
	 * @param studente lo studente che risponde
	 * @param quiz quale domanda è
	 */
	
	
	public RispostaStudenteMultipla(char lettera, char voto ) {
		this.lettera=lettera;
		this.voto=voto;
	}
	
	
	public char getLettera() {
		return lettera;
	}
	public void setLettera(char lettera) {
		this.lettera = lettera;
	}
	public float getVoto() {
		return voto;
	}
	public void setVoto(char voto) {
		this.voto = voto;
	}
	public Studente getStudente() {
		return studente;
	}
	public void setStudente(Studente studente) {
		this.studente = studente;
	}
	public QuizARispostaMultipla getQuiz() {
		return quiz;
	}
	public void setQuiz(QuizARispostaMultipla quiz) {
		this.quiz = quiz;
	}
	
}
