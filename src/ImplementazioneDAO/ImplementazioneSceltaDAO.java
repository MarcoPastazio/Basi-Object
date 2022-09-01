package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connessione.ConnessioneDatabase;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter; 
import DAO.SceltaDAO;
import DAO.StudenteDAO;
import model.Studente;

public class ImplementazioneSceltaDAO implements SceltaDAO {
	
		
	private Connection connection;
		
	public ImplementazioneSceltaDAO () throws SQLException, ClassNotFoundException{
		
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
	public void SalvaScelta(String test, String studente) throws SQLException{
		/**
		 * una query che serve a salvare i dati nella tabella scelta
		 * @param test il nome del test
		 * @param studente il login dello studente che ha scelto il test
		 */
		long millis=System.currentTimeMillis();  
			      
		java.sql.Date date = new java.sql.Date(millis);       
		PreparedStatement query=this.connection.prepareStatement("INSERT INTO public.scelta VALUES('"+studente+"','"+test+"',null,false,'"+date+"',false)");                                                                
		query.execute();
			
	}
	
	public boolean AggiornamentoScelta(String nomestudente, float[] voti, int conto,String nometest,float risM) {
		
		/**
		 * Nel caso in cui viene aggiornata la tabella scelta
		 * @param nomestudente il login dello studente
		 * @param voti i risultati dei voti dei quiz a risposta aperta
		 * @param conto il numero dei quiz a risposta aperta
		 * @param nometest il nome del test
		 * @param risM il risultato delle risposta ai quiz a risposta multipla
		 * @return esito se viene o meno salvato la query nel database
		 */
		
		boolean esito= false;
		float somma = 0;
		for(int i = 0;i < voti.length;i++) {
			somma += voti[i];
		}
		
		somma+=risM;
		
		try {
			PreparedStatement query= this.connection.prepareStatement("UPDATE SCELTA SET VOTO = "+somma+" , CORRETTO = true WHERE studente = '"+nomestudente+"' AND termina = true AND test='"+nometest+"'");
			esito=query.execute();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}




	public void TerminatoTrue(String nometest, Studente st) {
		
		/**
		 * se lo studente consegna, aggiorna la tabella scelta e mette terminato a true
		 * @param nometest il nome del test
		 * @param st lo studente che sta usando l'applicazione
		 */
		
		try {
			PreparedStatement query = this.connection.prepareStatement("UPDATE SCELTA SET termina= true WHERE studente='"+st.getLogin()+"'AND test='"+nometest+"'");
			query.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	public void InserisciTest(String nometest, Studente st) {
		
		/**
		 * Inserisce nella tabella scelta il test scelto dallo studente
		 * @param nometest il nome del test
		 * @param st lo studente che sta usando l'applicazione
		 */
		try {
			long millis=System.currentTimeMillis();    
		    java.sql.Date date = new java.sql.Date(millis); 
			PreparedStatement query = this.connection.prepareStatement("INSERT INTO SCELTA VALUES ('"+st.getLogin()+"' , '"+nometest+"' , null , false ,'"+date+"' , true)");
			query.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	public boolean CheckTestStudente(String test, String studente) {
		
		/**
		 * Quando il professore vuole controllare il test scelto dallo studente
		 * @param test il nome del test
		 * @param studente lo studente che ha scelto il test
		 */
		try {
			PreparedStatement query=this.connection.prepareStatement("SELECT* FROM SCELTA WHERE TEST='"+test+"' AND STUDENTE='"+studente+"'");
			return (query.execute());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}


	public void UpdateSoloMultiple(float somma, String login, String nometest) {
		
		/**
		 * Viene aggiornato la tabella scelta con il voto momentaneo che conta solo i voti dei quiz a risposta multipla
		 * @param somma il voto delle multiple
		 * @param login dello studente
		 * @param nometest il nome del test
		 */
		try {
			PreparedStatement query= this.connection.prepareStatement("UPDATE SCELTA SET VOTO = "+somma+" , CORRETTO = true WHERE studente = '"+login+"' AND termina = true AND test='"+nometest+"'");
			query.execute();
		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
	}

}
