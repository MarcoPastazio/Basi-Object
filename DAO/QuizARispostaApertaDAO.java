package DAO;

public interface QuizARispostaApertaDAO {
	public boolean SalvaQuizAperta(String nomedomanda, String descrizione, String domanda, int lunghezzamax, double punteggiomax, double punteggiomin, String nometest);
}
