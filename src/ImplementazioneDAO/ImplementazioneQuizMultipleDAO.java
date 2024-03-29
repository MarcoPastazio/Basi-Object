package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.ConnessioneDatabase;

public class ImplementazioneQuizMultipleDAO {
	
	private Connection conn;
	
	public ImplementazioneQuizMultipleDAO () {
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
	
	public int ConteggioDomandeM(String nometest) {
		/**
		 * serve a generare una query che ricava il numero di quiz a risposta multipla di quel determinato test
		 * @param nometest il nome del test
		 * @return conto il numero di domande
		 */
		int conto = 0;
		try {
			PreparedStatement query = this.conn.prepareStatement("Select count(domanda) From quizarispostamultipla Where test = '"+ nometest +"'");
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
	
	public String RicavoDomandaM(String nometest, int conto, int indice) {
		/**
		 * Mi ricavo la singola domanda a risposta multipla del test che mi serve
		 * @param nometest il nome del test
		 * @param conto
		 * @param indice il numero della domanda che mi serve 
		 * @return domande.get(indice) ovvero la singola domanda a risposta multipla del test
		 */
		ArrayList<String> domande = new ArrayList();
		try {
			PreparedStatement query = this.conn.prepareStatement("Select domanda From quizarispostamultipla Where test = '"+ nometest +"'");
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
	
	//lo usero sse faccio consegna
	public ArrayList<String> RicavoDomandeM(String nometest, int conto) {
		/**
		 * serve a generare una query che ricava tutte le domande a risposta multipla di quel determinato test
		 * @param nometest il nome del test
		 * @param conto
		 * @return domande le domande di quel determinato test
		 */
		ArrayList<String> domande = new ArrayList();
		try {
			PreparedStatement query = this.conn.prepareStatement("Select nome From quizarispostamultipla Where test = '"+ nometest +"'");
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
	
	public String RicavoNomeM(String nometest, int conto, int indice) {
		
		/**
		 * serve a generare una query che ricava tutti i nomi del quiz risposta multipla di quel determinato test
		 * @param nometest il nome del test
		 * @param conto
		 * @param indice mi indica il numero della domanda
		 * @return nome.get(indice) il nome della domanda con quel determinato indice
		 */
		
		ArrayList<String> nome = new ArrayList();
		try {
			PreparedStatement query = this.conn.prepareStatement("Select nome From quizarispostamultipla Where test = '"+ nometest +"'");
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
	
	public String RicavoDescrizioneM(String nometest, int conto, int indice) {
		
		/**
		 * serve a generare una query che ricava tutte le descrizioni del quiz risposta multipla di quel determinato test
		 * @param nometest il nome del test
		 * @param conto
		 * @param indice mi indica il numero della domanda
		 * @return descrizione.get(indice) la descrizione della domanda con quel determinato indice
		 */
		
		ArrayList<String> descrizione = new ArrayList();
		try {
			PreparedStatement query = this.conn.prepareStatement("Select descrizione From quizarispostamultipla Where test = '"+ nometest +"'");
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
	
	public boolean Rispostamultipla(String nomest, ArrayList<String> domandemultiple, String[] multiple, int contomultiple) {
		
		/**
		 * ci sta una query in cui si inserisce nel database i dati per la tabella rispostamultipla 
		 * @param nomest il nome dello studente
		 * @param nomeins il nome dell'insegnante
		 * @param domandemultiple le domande aperte
		 * @param multiple le risposte dello studente alle domande 
		 * @param contomultiple
		 * @return esito
		 */
		
		boolean esito= false;
		try {
			for(int i = 0; i < contomultiple; i++) {
				PreparedStatement query= this.conn.prepareStatement("INSERT INTO RISPOSTAMULTIPLA VALUES( '"+nomest+"','"+domandemultiple.get(i)+"','"+multiple[i]+"', '0')");
				esito=query.execute();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}

	public float RisultatoMultiple(String nomestudente, String nometest) {
		
		/**
		 * fa la somma dei quiz a risposta multipla di quei determinati test
		 * @param nomestudente il nome dello studente
		 * @param nometest il nome del test
		 * @return 0
		 */
		
		try {
			PreparedStatement query=this.conn.prepareStatement("select sum(voto) as somma from rispostamultipla where quiz IN (select nome from quizarispostamultipla where test='"+nometest+"')AND studente='"+nomestudente+"'");
			ResultSet res=query.executeQuery();
			if(res.next()) {
				float ret= res.getFloat("somma") ;
				return ret;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
