package model;

public class QuizARispostaAperta {
		private int lunghezzaMax;
		private float punteggioMax;
		private  float punteggioMin;
		private String nome;
		private String descrizione;
		private String domanda;
		
		public QuizARispostaAperta(int lunghezzaMax, float punteggioMax, float punteggioMin, String nome, String descrizione , String domanda) {
			this.lunghezzaMax=lunghezzaMax;
			this.punteggioMin=punteggioMin;
			this.punteggioMax=punteggioMax;
			this.nome=nome;
			this.descrizione=descrizione;
			this.domanda=domanda;
		}
		
		
		public int getLunghezzaMax() {
			return lunghezzaMax;
		}
		public void setLunghezzaMax(int lunghezzaMax) {
			this.lunghezzaMax = lunghezzaMax;
		}
		public float getPunteggioMax() {
			return punteggioMax;
		}
		public void setPunteggioMax(float punteggioMax) {
			this.punteggioMax = punteggioMax;
		}
		public float getPunteggioMin() {
			return punteggioMin;
		}
		public void setPunteggioMin(float punteggioMin) {
			this.punteggioMin = punteggioMin;
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
}
