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
		/**
		 * qui avviene la classica connessione al database
		 */
		try {
			this.connection = ConnessioneDatabase.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean SalvaQuizAperta(String nomedomanda, String descrizione, String domanda, int lunghezzamax, double punteggiomax, double punteggiomin, String nometest) {
		
		/**
		 * è una query che serve a inserire i dati in quizarispostaaperta
		 * @param nomedomanda il nome della domanda
		 * @param descrizione la descrizione della domanda
		 * @param domanda la domanda effettiva
		 * @param lunghezzamax il numero massimo di caratteri disponibili per una risposta
		 * @param punteggiomax il voto più alto per una risposta data da uno studente
		 * @param punteggiomin il voto più basso per una risposta data da uno studente
		 * @param nometest il nome del test
		 * @return esito serve a verificare se viene fatta o meno l'operazione di inserimento nel database
		 */
		
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
		
		/**
		 * controlla la lunghezza massima della domanda
		 * @param nome del quiz
		 * @return conto ovvero la lunghezzamax
		 */
		
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
		
		/**
		 * qui si ricava il punteggio massimo per tutti i quiz a risposta aperta di quel determinato test
		 * @param nometest il nome del test
		 * @param conto
		 * @return punteggio
		 */
		
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
		
		/**
		 * qui si ricava il punteggio minimo per tutti i quiz a risposta aperta di quel determinato test
		 * @param nometest il nome del test
		 * @param conto
		 * @return punteggio
		 */
		
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