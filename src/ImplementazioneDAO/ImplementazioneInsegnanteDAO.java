package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connessione.ConnessioneDatabase;
import DAO.InsegnanteDAO;
import model.Insegnante;

public class ImplementazioneInsegnanteDAO implements InsegnanteDAO {
	

	private Connection connection;
	
	public ImplementazioneInsegnanteDAO () throws SQLException, ClassNotFoundException{
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
	
	public ResultSet PrendiTestCorreggere (Insegnante ins) {
		/**
		 * L'insegnante seleziona il test dello studente da correggere
		 * @param ins � l'insegnante che sta usando l'applicazione
		 * @return null
		 */
		try {
			PreparedStatement query=this.connection.prepareStatement("SELECT studente,test,data FROM public.scelta WHERE corretto=false AND termina=true AND test  IN(SELECT nome FROM public.test WHERE insegnante='"+ins.getLogin()+"')");                                   
			ResultSet ris=query.executeQuery();
			return ris;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}

	@Override
	public boolean Registrazione(Insegnante ins) {
		/**
		 * nella schermata di login, quando si clicca conferma, vengono inseriti nel database i dati dell'insegnante
		 * @param ins � l'insegnante che sta usando l'applicazione
		 * @return esito
		 */
		boolean esito = false;
		try {
			PreparedStatement query = this.connection.prepareStatement("INSERT INTO public.INSEGNANTE VALUES( '"+ins.getLogin()+"','"+ins.getNome()+"','"+ins.getCognome()+"','"+ins.getPassword()+"','"+ ins.getCorso()+"')");
			esito = query.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;

	}
	
	public void Login(Insegnante ins) {
		/**
		 * un metodo che seleziona login e password dell'insegnante selezionato
		 * @param ins � l'insegnante che sta usando l'applicazione
		 */
		try {
			PreparedStatement query = this.connection.prepareStatement("Select * From Insegnante Where Login = '"+ ins.getLogin() +"' AND Password = '"+ ins.getPassword()+"'");
			ResultSet set = query.executeQuery();
			if (set.next()) {
				ins.setNome(set.getString("nome"));
				ins.setCognome(set.getString("cognome"));
				ins.setCorso(set.getString("corso"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean LoginB(Insegnante ins) {
		/**
		 * un metodo che restituisce true o false se trova o meno login e password dell'insegnante selezionato
		 * @param ins � l'insegnante che sta usando l'applicazione
		 * @return esito ovvero se la query � verificata o meno
		 */
		boolean esito = false;
		try {
			PreparedStatement query= this.connection.prepareStatement("SELECT * FROM insegnante WHERE login='"+ins.getLogin()+"' AND password='"+ins.getPassword()+"'");
			ResultSet res=query.executeQuery();
			if(res.next()) {
				esito = true;
			}else {
				esito = false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return esito;
	}

	public ResultSet EliminaTest(Insegnante ins) {
		/**
		 * una query che serve a eliminare il test desiderato dall'insegnante
		 * @param ins � l'insegnante che sta usando l'applicazione
		 * @return null
		 */
		try {
			PreparedStatement query= this.connection.prepareStatement("SELECT nome,corso,data,insegnante FROM test WHERE insegnante='"+ins.getLogin()+"' AND valido=true");
			ResultSet res=query.executeQuery();
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
