package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import Connessione.ConnessioneDatabase;
import Model.Insegnante;


public class ImplementazioneTestDAO {
	
	private Connection connection;
	
	public ImplementazioneTestDAO () {
		try {
			this.connection = ConnessioneDatabase.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean RegistrazioneTest(Insegnante ins, String nometest, int durata) {
		
		boolean esito = false;
		try {
			PreparedStatement query = this.connection.prepareStatement("INSERT INTO TEST VALUES( '"+ nometest +"','"+ins.getCorso()+"','"+ durata + "','" + LocalDate.now() + "','"+ins.getLogin()+"')");
			esito = query.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}
}
