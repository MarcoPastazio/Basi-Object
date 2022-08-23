package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.ConnessioneDatabase;

public class ImplementazioneQuizAperteDAO {

	private Connection conn;
	
	public ImplementazioneQuizAperteDAO () {
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
	public String RicavoDomanda(String nometest, int conto, int indice) {
		/**
		 * Mi ricavo la singola domanda a risposta aperta del test che mi serve
		 * @param nometest il nome del test
		 * @param conto
		 * @param indice il numero della domanda che mi serve 
		 * @return domande.get(indice) ovvero la singola domanda a risposta aperta del test
		 */
		ArrayList<String> domande = new ArrayList();
		try {
			PreparedStatement query = this.conn.prepareStatement("Select domanda From quizarispostaaperta Where test = '"+ nometest +"'");
			ResultSet set = query.executeQuery();
			while (set.next()) {
				domande.add(set.getString("domanda"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return domande.get(indice);
	}
	
	//questo lo userò sse devo fa consegna
	public ArrayList<String> RicavoDomandaA(String nometest, int conto) {
		/**
		 * serve a generare una query che ricava tutte le domande a risposta aperta di quel determinato test
		 * @param conto
		 * @param nometest il nome del test
		 * @return domande le domande di quel determinato test
		 */
		ArrayList<String> domande = new ArrayList();
		try {
			PreparedStatement query = this.conn.prepareStatement("Select nome From quizarispostaaperta Where test = '"+ nometest +"'");//HO MODIFICATO
			ResultSet set = query.executeQuery();
			while (set.next()) {
				domande.add(set.getString("nome"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return domande;
	}
	
	public String RicavoNome(String nometest, int conto, int indice) {
		/**
		 * serve a generare una query che ricava tutti i nomi del quiz risposta aperta di quel determinato test
		 * @param conto
		 * @param indice mi indica il numero della domanda
		 * @param nometest il nome del test
		 * @return nome.get(indice) il nome della domanda con quel determinato indice
		 */
		ArrayList<String> nome = new ArrayList();
		try {
			PreparedStatement query = this.conn.prepareStatement("Select nome From quizarispostaaperta Where test = '"+ nometest +"'");
			ResultSet set = query.executeQuery();
			while (set.next()) {
				nome.add(set.getString("nome"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nome.get(indice);
	}
	
	public String RicavoDescrizione(String nometest, int conto, int indice) {
		/**
		 * serve a generare una query che ricava tutte le descrizioni del quiz risposta aperta di quel determinato test
		 * @param conto
		 * @param indice mi indica il numero della domanda
		 * @param nometest il nome del test
		 * @return descrizione.get(indice) la descrizione della domanda con quel determinato indice
		 */
		ArrayList<String> descrizione = new ArrayList();
		try {
			PreparedStatement query = this.conn.prepareStatement("Select descrizione From quizarispostaaperta Where test = '"+ nometest +"'");
			ResultSet set = query.executeQuery();
			while (set.next()) {
				descrizione.add(set.getString("descrizione"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return descrizione.get(indice);
	}
	
	public int ConteggioDomande(String nometest) {
		/**
		 * serve a generare una query che ricava il numero di quiz a risposta aperta di quel determinato test
		 * @param nometest il nome del test
		 * @return conto il numero di domande
		 */
		int conto = 0;
		try {
			PreparedStatement query = this.conn.prepareStatement("Select count(domanda) From quizarispostaaperta Where test = '"+ nometest +"'");
			ResultSet set = query.executeQuery();
			if (set.next()) {
				conto = set.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conto;
	}
	
	public String NomeProf(String nometest) {
		/**
		 * serve a generare una query che ricava il nome del prof di quel determinato test
		 * @param nometest il nome del test
		 * @return nomeprof il numero di domande
		 */
		String nomeprof = null;
		try {
			PreparedStatement query = this.conn.prepareStatement("Select insegnante From test Where nome = '"+ nometest +"'");
			ResultSet set = query.executeQuery();
			if (set.next()) {
				nomeprof = set.getString("insegnante");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomeprof;
	}
	
	public boolean Rispostaaperta(String nomest, String nomeins, ArrayList<String> domandeaperte, String[] aperte, int contoaperte) {
		/**
		 * ci sta una query in cui si inserisce nel database i dati per la tabella rispostaaperta 
		 * @param nomest il nome dello studente
		 * @param nomeins il nome dell'insegnante
		 * @param domandeaperte le domande aperte
		 * @param aperte le risposte dello studente alle domande 
		 * @param contoaperte
		 * @return esito
		 */
		boolean esito= false;
		try {
			for(int i = 0; i < contoaperte; i++) {
				PreparedStatement query= this.conn.prepareStatement("INSERT INTO RISPOSTAAPERTA VALUES( '"+nomest+"','"+nomeins+"','"+domandeaperte.get(i)+"','"+aperte[i]+"', '0', 'false')");
				esito=query.execute();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}
}
