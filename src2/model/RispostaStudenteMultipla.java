package model;

public class RispostaStudenteMultipla {
	private char lettera;
	private float voto;
	private Studente studente;
	private QuizARispostaMultipla quiz;
	
	
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
