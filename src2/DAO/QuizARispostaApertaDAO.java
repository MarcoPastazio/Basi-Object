package DAO;

/**
 * All’interno del package ci sono le classi con tutte le implementazioni delle interfacce DAO rispetto a quel database
 */

import java.util.ArrayList;

public interface QuizARispostaApertaDAO {
	public boolean SalvaQuizAperta(String nomedomanda, String descrizione, String domanda, int lunghezzamax, double punteggiomax, double punteggiomin, String nometest);
	public int ControlloLunghezza(String nome);
	public ArrayList<Float>PunteggioMax(String nometest, int conto);
	public ArrayList<Float>PunteggioMin(String nometest, int conto);
}
