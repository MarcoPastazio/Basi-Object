package DAO;

import java.util.ArrayList;

public interface QuizAperteDAO {
	
	public String RicavoDomanda(String nometest, int conto, int indice);
	public ArrayList<String> RicavoDomandaA(String nometest, int conto);
	public String RicavoNome(String nometest, int conto, int indice);
	public String RicavoDescrizione(String nometest, int conto, int indice);
	public int ConteggioDomande(String nometest);
	public String NomeProf(String nometest);
	public boolean Rispostaaperta(String nomest, String nomeins, ArrayList<String> domandeaperte, String[] aperte, int contoaperte);
	public ArrayList<String> RicavoNomeA(String nometest, int conto);
}
