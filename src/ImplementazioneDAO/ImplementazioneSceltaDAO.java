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
			try {
				this.connection = ConnessioneDatabase.getInstance().getConnection();
			}catch (SQLException e ) {
				System.out.print("ERRORE "+e.getErrorCode());
			}catch (ClassNotFoundException e) {
				System.out.print("ERRORE "+e.getStackTrace());
			}
		}
	
	
	
	
	@Override

		public void SalvaScelta(String test,String studente) throws SQLException{
				long millis=System.currentTimeMillis();  
			      
				    // creating a new object of the class Date  
				java.sql.Date date = new java.sql.Date(millis);       
				//System.out.println(date);
				PreparedStatement query=this.connection.prepareStatement("INSERT INTO public.scelta VALUES('"+studente+"','"+test+"',null,false,'"+date+"',false)");                                                                
				query.execute();
			
		}
	
	public boolean AggiornamentoScelta(String nomestudente, float[] voti, int conto,String nometest,float risM) {
		boolean esito= false;
		float somma = 0;
		for(int i = 0;i < voti.length;i++) {
			somma += voti[i];
			System.out.print("\n"+voti[i]);
		}
		System.out.print("\n\n\n"+risM+"\n\n\n");
		somma+=risM;
		System.out.print("\n\n\n"+somma+"\n\n\n");
		try {
				PreparedStatement query= this.connection.prepareStatement("UPDATE SCELTA SET VOTO = "+somma+" , CORRETTO = true WHERE studente = '"+nomestudente+"' AND termina = true AND test='"+nometest+"'");
				esito=query.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esito;
	}




	public void TerminatoTrue(String nometest, Studente st) {
		try {
			PreparedStatement query = this.connection.prepareStatement("UPDATE SCELTA SET termina= true WHERE studente='"+st.getLogin()+"'AND test='"+nometest+"'");
			query.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	public void InserisciTest(String nometest, Studente st) {
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
		try {
			PreparedStatement query= this.connection.prepareStatement("UPDATE SCELTA SET VOTO = "+somma+" , CORRETTO = true WHERE studente = '"+login+"' AND termina = true AND test='"+nometest+"'");
			query.execute();
		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
	}

}
