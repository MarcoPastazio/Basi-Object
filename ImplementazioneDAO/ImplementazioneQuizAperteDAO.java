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
		try {
			this.conn = ConnessioneDatabase.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String RicavoDomanda(String nometest, int conto, int indice) {
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
		return domande;
	}
	
	public String RicavoNome(String nometest, int conto, int indice) {
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
		boolean esito= false;
		try {
			for(int i = 0; i < contoaperte; i++) {
				//0 di default perchè non posso mettere null
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
