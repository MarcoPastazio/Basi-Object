package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.ConnessioneDatabase;

public class ImplementazioneRispostaApertaDAO {
	
	private Connection conn;
	
	public ImplementazioneRispostaApertaDAO () {
		/**
		 * qui avviene la connessione al database
		 */
		try {
			this.conn = ConnessioneDatabase.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public String RicavoRisposta(String nometest, String nomestudente, int conto, int indice) {
		/**
		 * una query che serve a ricavare le risposte
		 * @param nometest il nome del test
		 * @param nomestudente il nome dello studente
		 * @param conto 
		 * @param indice indice della risposta che ci serve
		 * @return risposta.get(indice) il la risposta di quella determinata
		 */
		ArrayList<String> risposta = new ArrayList();
		try {
			PreparedStatement query = this.conn.prepareStatement("Select risposta From rispostaaperta r, quizarispostaaperta q, studente s Where r.quiz = q.nome AND q.test = '"+ nometest +"' AND s.login = r.studente AND s.login = '"+ nomestudente +"' AND r.corretta = false");
			ResultSet set = query.executeQuery();
			while (set.next()) {
				risposta.add(set.getString("risposta"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return risposta.get(indice);
	}
	
	public boolean AggiornamentoRispostaAperta(ArrayList<String> DomandeTest, String nomestudente, int conto, float[] voti) {
		/**
		 * Una query che serve ad aggiornare i voti delle domande a risposta aperta 
		 * @param DomandeTest le varie domande di quel test
		 * @param nomestudente il nome dello studente
		 * @param conto il numero di domande 
		 * @param voti
		 * @return esito
		 */
		boolean esito= false;
		try {
			for(int i = 0; i < conto; i++) {
				PreparedStatement query= this.conn.prepareStatement("UPDATE RISPOSTAAPERTA SET VOTO = '"+voti[i]+"' , CORRETTA = true WHERE studente = '"+nomestudente+"' AND quiz = '"+DomandeTest.get(i)+"' ");
				esito=query.execute();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}
	
	
}