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
		try {
			this.conn = ConnessioneDatabase.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public String RicavoRisposta(String nometest, String nomestudente, int conto, int indice) {
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
		boolean esito= false;
		try {
			for(int i = 0; i < conto; i++) {
				System.out.println(DomandeTest.get(i));
				PreparedStatement query= this.conn.prepareStatement("UPDATE RISPOSTAAPERTA SET VOTO = '"+voti[i]+"' , CORRETTA = true WHERE studente = '"+nomestudente+"' AND quiz = '"+DomandeTest.get(i)+"' AND CORRETTA = false ");
				esito=query.execute();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}
	
	
}
