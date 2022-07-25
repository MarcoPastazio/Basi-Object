package DAO;

import java.util.ArrayList;

public interface RispostaApertaDAO {
	public String RicavoRisposta(String nometest, String nomestudente, int conto, int indice);
	public boolean AggiornamentoRispostaAperta(ArrayList<String> DomandeTest, String nomestudente, int conto, float[] voti);
}
