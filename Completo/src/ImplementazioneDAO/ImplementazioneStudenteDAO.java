package ImplementazioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Connessione.ConnessioneDatabase;
import DAO.StudenteDAO;
//import Connessione.ConnessioneDatabase;
import model.Studente;




 


public class ImplementazioneStudenteDAO  implements StudenteDAO {
	
		private Connection connection;
		
		public ImplementazioneStudenteDAO () throws SQLException, ClassNotFoundException{	
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
		public boolean Registrazione(Studente s) {
			
			/**
			 * La registrazione dello studente sulla piattaforma
			 * @param s lo studente che si registra sulla piattaforma
			 * @return esito se è andato a buon fine o meno la registrazione
			 */
			
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
			/**
			 * Serve a verificare se lo studente mette mail e password correttamente 
			 * @param s lo studente che prova a entrare nella piattaforma
			 */
			try {
				PreparedStatement query= this.connection.prepareStatement("SELECT nome,corso,data,insegnante FROM public.studente WHERE login='"+s.getLogin()+"' AND password='"+s.getPassword()+"'");
				ResultSet res=query.executeQuery();
				if(res.next()) {
					s.setNome(res.getString("nome"));
					s.setCognome(res.getString("cognome"));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}


		@Override
		public ResultSet LeggiTest(Studente s) {
			
			/**
			 * seleziona i test che non sono stati ancora scelti dallo studente			
			 * @param s lo studente che prova a leggere i test non scelti ancora
			 * @return null
			 */
			
			try {
				PreparedStatement query=this.connection.prepareStatement("SELECT nome,corso,data,insegnante FROM public.test WHERE nome NOT IN(SELECT test FROM scelta WHERE studente='"+s.getLogin()+"'AND termina =true) AND valido=true");                                   
				ResultSet ris=query.executeQuery();
				return ris;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}


		@Override
		public ResultSet ConsultaVoti(Studente s) {
			/**
			 * Lo studente può consultare i voti
			 * @param s lo studente che prova a consultare i voti
			 * @return null
			 */
			try {
				PreparedStatement query=this.connection.prepareStatement("SELECT test,voto,data FROM public.scelta WHERE studente='"+s.getLogin()+"' AND corretto=true");
				ResultSet ris=query.executeQuery();
				return ris;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public ResultSet PrendiScelte(Studente s) {
			
			/**
			 * prende tutti i test che sono stati scelti dallo studente e che sono validi
			 * @param s lo studente che prova
			 * @return null
			 */
			
			try {
				PreparedStatement query=this.connection.prepareStatement("SELECT nome,corso,data,insegnante FROM public.test WHERE nome IN(SELECT test FROM scelta WHERE studente='"+s.getLogin()+"'AND corretto=false AND termina=false)AND valido=true");
				ResultSet ris=query.executeQuery();
				return ris;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}


		public ResultSet LeggiTestS(Studente s) {
			
			/**
			 * seleziona i test che non sono stati ancora scelti dallo studente			
			 * @param s lo studente che prova a leggere i test non scelti ancora
			 * @return null
			 */
			
			try {
				PreparedStatement query=this.connection.prepareStatement("SELECT nome,corso,data,insegnante FROM public.test WHERE nome NOT IN(SELECT test FROM scelta WHERE studente='"+s.getLogin()+"') AND valido=true");                                   
				ResultSet ris=query.executeQuery();
				return ris;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public boolean LoginB(Studente s) {
			
			/**
			 * serve a verificare se lo studente è registrato o meno sulla piattaforma
			 * @param s lo studente che prova ad accedere sulla piattaforma
			 * @return esito
			 */
			
			boolean esito = false;
			try {
				PreparedStatement query= this.connection.prepareStatement("SELECT * FROM studente WHERE login='"+s.getLogin()+"' AND password='"+s.getPassword()+"'");
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
		
		
}

