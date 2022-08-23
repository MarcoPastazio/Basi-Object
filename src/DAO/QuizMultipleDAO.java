package DAO;

/**
 * All’interno del package ci sono le classi con tutte le implementazioni delle interfacce DAO rispetto a quel database
 */

import java.util.ArrayList;

public interface QuizMultipleDAO {
	public int ConteggioDomandeM(String nometest);
	public String RicavoDomandaM(String nometest, int conto, int indice);
	public ArrayList<String> RicavoDomandeM(String nometest, int conto);
	public String RicavoNomeM(String nometest, int conto, int indice);
	public String RicavoDescrizioneM(String nometest, int conto, int indice);
	public boolean Rispostamultipla(String nomest, ArrayList<String> domandemultiple, String[] multiple, int contomultiple);
}
