package DAO;

/**
 * All’interno del package ci sono le classi con tutte le implementazioni delle interfacce DAO rispetto a quel database
 */

import java.util.ArrayList;

public interface RispostaApertaDAO {
	public String RicavoRisposta(String nometest, String nomestudente, int conto, int indice);
	public boolean AggiornamentoRispostaAperta(ArrayList<String> DomandeTest, String nomestudente, int conto, float[] voti);
}
