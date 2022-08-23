package model;

public class RispostaAperta {
		private String risposta;
		private float voto;
		private boolean corretto;
		private Studente studente;
		private QuizARispostaAperta quiz;
		private Insegnante insegnante;
		
		/**
		 * serve a dichiarare e a settare gli attributi di risposta aperta e a creare i costruttori
		 * @param risposta la risposta che da lo studente
		 * @param voto come viene valutata la risposta
		 * @param corretto se è corretto o meno
		 * @param studente colui che risponde
		 * @param quiz quale domanda è
		 * @param insegnante colui che la corregge
		 */
		
		public RispostaAperta(String risposta, float voto, boolean corretto, Studente studente, QuizARispostaAperta quiz, Insegnante insegnante){
			this.risposta=risposta;
			this.voto=voto;
			this.corretto=corretto;
			this.studente=studente;
			this.quiz=quiz;
			this.insegnante=insegnante;
		}
		
		public String getRisposta() {
			return risposta;
		}
		public void setRisposta(String risposta) {
			this.risposta = risposta;
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
		public Studente getStudente() {
			return studente;
		}
		public void setStudente(Studente studente) {
			this.studente = studente;
		}
		public QuizARispostaAperta getQuiz() {
			return quiz;
		}
		public void setQuiz(QuizARispostaAperta quiz) {
			this.quiz = quiz;
		}
		public Insegnante getInsegnante() {
			return insegnante;
		}
		public void setInsegnante(Insegnante insegnante) {
			this.insegnante = insegnante;
		}
		
}
