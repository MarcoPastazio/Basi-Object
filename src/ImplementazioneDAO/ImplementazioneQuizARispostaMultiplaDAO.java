package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connessione.ConnessioneDatabase;

public class ImplementazioneQuizARispostaMultiplaDAO {
	
	private Connection connection;
	
	public ImplementazioneQuizARispostaMultiplaDAO () {
		/**
		 * qui avviene la connessione al database
		 */
		try {
			this.connection = ConnessioneDatabase.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean SalvaQuizMultipla(String nomedomanda, String descrizione, String domanda, float votorispostacorretta, float votorispostasbagliata, String nometest, String rispostacorretta){
		
		/**
		 * @param nomedomanda il nome della domanda
		 * @param descrizione la descrizione della domanda
		 * @param domanda la domanda effettiva
		 * @param votorispostacorretta il voto nel caso in cui la risposta del quiz a risposta multipla è corretta
		 * @param votorispostasbagliata il voto nel caso in cui la risposta del quiz a risposta multipla è sbagliata
		 * @param nometest il nome del test
		 * @param rispostacorretta quale risposta è corretta
		 */
		
		boolean esito = false;
		try {
			PreparedStatement query = this.connection.prepareStatement("INSERT INTO QUIZARISPOSTAMULTIPLA VALUES( '"+ nomedomanda +"','"+ descrizione +"','"+ domanda + "','" + votorispostacorretta + "','"+ votorispostasbagliata + "','" + nometest + "','" + rispostacorretta + "')");
			esito = query.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}
}
