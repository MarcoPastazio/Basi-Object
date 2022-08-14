package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Connessione.ConnessioneDatabase;
import model.Insegnante;

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
	
	public ArrayList<Float>PunteggioMax(String nometest, int conto){
		ArrayList<Float> punteggio = new ArrayList();
		ArrayList<String> appoggio = new ArrayList();
		int indice = 0;
		try {
			PreparedStatement query = this.connection.prepareStatement("Select punteggiomax From quizarispostaaperta Where test = '"+ nometest +"'");
			ResultSet set = query.executeQuery();
			while (set.next()) {
				appoggio.add(set.getString("punteggiomax"));
				Float num = Float.parseFloat(appoggio.get(indice));
				punteggio.add(indice, num);
				indice++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return punteggio;
	}
	
	public ArrayList<Float>PunteggioMin(String nometest, int conto){
		ArrayList<Float> punteggio = new ArrayList();
		ArrayList<String> appoggio = new ArrayList();
		int indice = 0;
		try {
			PreparedStatement query = this.connection.prepareStatement("Select punteggiomin From quizarispostaaperta Where test = '"+ nometest +"'");
			ResultSet set = query.executeQuery();
			while (set.next()) {
				appoggio.add(set.getString("punteggiomin"));
				Float num = Float.parseFloat(appoggio.get(indice));
				punteggio.add(indice, num);
				indice++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return punteggio;
	}
}