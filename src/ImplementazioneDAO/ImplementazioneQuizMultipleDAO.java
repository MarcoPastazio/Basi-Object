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
		try {
			this.conn = ConnessioneDatabase.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int ConteggioDomandeM(String nometest) {
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
		try {
			PreparedStatement query=this.conn.prepareStatement("select sum(voto) as somma from rispostamultipla where quiz IN (select nome from quizarispostamultipla where test='"+nometest+"')AND studente='"+nomestudente+"'");
			ResultSet res=query.executeQuery();
			if(res.next()) {
				float ret= res.getFloat("somma") ;
				System.out.print("\n\n\n"+ret+"\n\n\n");
				return ret;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
