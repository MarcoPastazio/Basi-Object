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
		/**
		 * qui avviene la connessione al database
		 */
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
		/**
		 * quando lo studente seleziona il test, fa il chack per vedere se esiste o meno quel test
		 * @param t il test selezionato dallo studente
		 */
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
		/**
		 * prende tutti i quiz a risposta aperta di quel determinato test
		 * @param t il test selezionato
		 * @return null
		 */
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
		/**
		 * prende tutti i quiz a risposta multipla di quel determinato test
		 * @param t il test selezionato
		 * @return null
		 */
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
	public boolean RegistrazioneTest(Insegnante ins, String nometest) {
		
		/**
		 * inserisce il nuovo test creato dall'insegnante
		 * @param ins l'insegnante che lo crea
		 * @param nometest il nome del nuovo test
		 * @return esito
		 */
		
		boolean esito = false;
		try {
			PreparedStatement query = this.connection.prepareStatement("INSERT INTO TEST VALUES( '"+ nometest +"','"+ins.getCorso()+"','"+LocalDate.now() + "','"+ins.getLogin()+"',true)");
			esito = query.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}


	public void setInvalid(String test) throws SQLException {
		
		/**
		 * cambia il flag valido da true a false
		 * @param test il test che viene messo a non valido
		 */
			PreparedStatement query= this.connection.prepareStatement("UPDATE test SET valido=false WHERE nome='"+test+"'");
			query.execute();
		
		
	}
	
	
	public boolean CheckEmptyTest(String nometest) {
		
		/**
		 * verifica se il test è consistente o meno
		 * @param nometest il test da controllare
		 */
		try {
			PreparedStatement query=this.connection.prepareStatement("SELECT COUNT(*) AS COUNT FROM QUIZARISPOSTAAPERTA WHERE TEST='"+nometest+"'");
			PreparedStatement query2=this.connection.prepareStatement("SELECT COUNT(*) AS COUNT FROM QUIZARISPOSTAMULTIPLA WHERE TEST='"+nometest+"'");
			ResultSet res=query.executeQuery();
			ResultSet res1=query2.executeQuery();
			res.next();
			res1.next();
			if(res.getInt("COUNT")+res1.getInt("COUNT") > 0)
				return false;
			else
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public void EliminaTest(String nometest) {
		
		/**
		 * serve a eliminare un test se il professore lo vuole
		 * @param nometest il test da eliminare
		 */
		try {
			PreparedStatement query=this.connection.prepareStatement("DELETE FROM TEST WHERE NOME='"+nometest+"'");
			query.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}




	

}
