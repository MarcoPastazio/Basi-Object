package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;

import Connessione.ConnessioneDatabase;

public class ImplementazioneSceltaDAO {

	private Connection conn;
	
	public ImplementazioneSceltaDAO () {
		try {
			this.conn = ConnessioneDatabase.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean AggiornamentoScelta(String nomestudente, String nometest, float[] voti, int conto) {
		boolean esito= false;
		float somma = 0;
		for(int i = 0;i < voti.length;i++) {
			somma += voti[i]; 
		}
		
		try {
			for(int i = 0; i < conto; i++) {
				PreparedStatement query= this.conn.prepareStatement("UPDATE SCELTA SET VOTO = '"+somma+"' , CORRETTO = true WHERE studente = '"+nomestudente+"' AND termina = true AND test = '"+nometest+"' ");
				esito=query.execute();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}

}
