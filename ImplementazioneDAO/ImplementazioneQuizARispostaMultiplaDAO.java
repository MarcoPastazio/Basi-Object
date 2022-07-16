package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connessione.ConnessioneDatabase;

public class ImplementazioneQuizARispostaMultiplaDAO {
	
	private Connection connection;
	
	public ImplementazioneQuizARispostaMultiplaDAO () {
		try {
			this.connection = ConnessioneDatabase.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean SalvaQuizMultipla(String nomedomanda, String descrizione, String domanda, float votorispostacorretta, float votorispostasbagliata, String nometest, String rispostacorretta){
		
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
