package DAO;

/**
 * All’interno del package ci sono le classi con tutte le implementazioni delle interfacce DAO rispetto a quel database
 */


public interface QuizARispostaMultiplaDAO {
	public boolean SalvaQuizMultipla(String nomedomanda, String descrizione, String domanda, float votorispostacorretta, float votorispostasbagliata, String nometest, String rispostacorretta);
}
