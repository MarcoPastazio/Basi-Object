package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Connessione.ConnessioneDatabase;
import DAO.StudentiDAO;
//import Connessione.ConnessioneDatabase;
import model.Studente;




 


public class ImplementazioneStudentiDAO  implements StudentiDAO {
	
		private Connection connection;
		
		public ImplementazioneStudentiDAO () throws SQLException, ClassNotFoundException{		
			try {
				this.connection = ConnessioneDatabase.getInstance().getConnection();
			}catch (SQLException e ) {
				System.out.print("ERRORE "+e.getErrorCode());
			}catch (ClassNotFoundException e) {
				System.out.print("ERRORE "+e.getStackTrace());
			}
		}
		
		
		  /*public ImplementazioneStudentiDAO () {
				try {
					this.connection=ConnessioneDatabase.getInstance().getConnection();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
		
		
		
		@Override
		public boolean Registrazione(Studente s) {
			boolean esito= false;
			try {
				PreparedStatement query= this.connection.prepareStatement("INSERT INTO PUBLIC.STUDENTE VALUES( '"+s.getLogin()+"','"+s.getNome()+"','"+s.getCognome()+"','"+s.getPassword()+"')");
				esito=query.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return esito;
		}
		@Override
		public void Login(Studente s) {
			try {
				PreparedStatement query= this.connection.prepareStatement("SELECT * FROM public.studente WHERE login='"+s.getLogin()+"' AND password='"+s.getPassword()+"'");
				ResultSet res=query.executeQuery();
				//res.next();
				//System.out.println("mammt\n"+res.getString("nome"));
				if(res.next()) {
					s.setNome(res.getString("nome"));
					System.out.println(s.getNome());
					s.setCognome(res.getString("cognome"));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
}

