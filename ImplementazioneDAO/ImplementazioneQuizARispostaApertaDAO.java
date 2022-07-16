package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import Connessione.ConnessioneDatabase;
import Model.Insegnante;

public class ImplementazioneQuizARispostaApertaDAO {
	
	private Connection connection;
	
	public ImplementazioneQuizARispostaApertaDAO () {
		try {
			this.connection = ConnessioneDatabase.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean SalvaQuizAperta(String nomedomanda, String descrizione, String domanda, int lunghezzamax, double punteggiomax, double punteggiomin, String nometest) {
		
		boolean esito = false;
		try {
			PreparedStatement query = this.connection.prepareStatement("INSERT INTO QUIZARISPOSTAAPERTA VALUES( '"+ nomedomanda +"','"+descrizione+"','"+ domanda + "','" + lunghezzamax + "','"+ punteggiomax + "','" + punteggiomin + "','" + nometest + "')");
			esito = query.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}
	
	public int ControlloLunghezza(String nome) {
		int conto = 0;
		try {
			PreparedStatement query = this.connection.prepareStatement("Select lunghezzamax From quizarispostaaperta Where nome = '"+ nome +"'");
			ResultSet set = query.executeQuery();
			if (set.next()) {
				conto = set.getInt("lunghezzamax");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conto;
	}
}
