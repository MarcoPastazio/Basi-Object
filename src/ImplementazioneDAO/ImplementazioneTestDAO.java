package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import Connessione.ConnessioneDatabase;
import DAO.TestDAO;
import model.Insegnante;
import model.Test;

public class ImplementazioneTestDAO implements TestDAO {

	private Connection connection;
	
	public ImplementazioneTestDAO () throws SQLException, ClassNotFoundException{		
		try {
			this.connection = ConnessioneDatabase.getInstance().getConnection();
		}catch (SQLException e ) {
			System.out.print("ERRORE "+e.getErrorCode());
		}catch (ClassNotFoundException e) {
			System.out.print("ERRORE "+e.getStackTrace());
		}
	}
	
	
	@Override
	public boolean CheckTest(Test t) {
		try {
			PreparedStatement query=this.connection.prepareStatement("SELECT nome FROM public.test WHERE test='"+t.getNome()+"'");
			ResultSet ris=query.executeQuery();
			if(ris.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

//dividere in prendi aperte e multiple.
	public ResultSet PrendiTestAperte(Test t) {
		try {
			PreparedStatement query=this.connection.prepareStatement("SELECT * FROM public.quizarispostaaperta WHERE test='"+t.getNome()+"'");
			ResultSet ris=query.executeQuery();
			return ris;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet PrendiTestMultiple(Test t) {
		try {
			PreparedStatement query=this.connection.prepareStatement("SELECT * FROM public.quizarispostamultipla WHERE test='"+t.getNome()+"'");
			ResultSet ris=query.executeQuery();
			return ris;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean RegistrazioneTest(Insegnante ins, String nometest, int durata) {
		
		boolean esito = false;
		try {
			PreparedStatement query = this.connection.prepareStatement("INSERT INTO TEST VALUES( '"+ nometest +"','"+ins.getCorso()+"','"+ durata + "','" + LocalDate.now() + "','"+ins.getLogin()+"',true)");
			esito = query.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}


	public void setInvalid(String test) throws SQLException {
			PreparedStatement query= this.connection.prepareStatement("UPDATE test SET valido=false WHERE nome='"+test+"'");
			query.execute();
		
		
	}




	

}
