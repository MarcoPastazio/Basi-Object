package Connessione;

/**
 * ritorna la connessione al database.

 * @param istance serve per verificare la connessione 
 * @param connection serve per l'apertura del database
 * @return connection 
 */


import java.sql.*;

public class ConnessioneDatabase {
	
	private static ConnessioneDatabase instance;
	private Connection connection = null;
	private String url="jdbc:postgresql://localhost:5432/Progetto7"; //jdbc:postgresql://host:port/database  //"jdbc:postgresql://localhost:5432/Progetto"
	
	public ConnessioneDatabase() throws SQLException, ClassNotFoundException{
		try {
			Class.forName("org.postgresql.Driver");//org.postgresql.Driver
			connection=DriverManager.getConnection(url, "postgres", "marcopastore");
			System.out.print("Connessione stabilita");
		}
		catch(SQLException exc){
			System.out.print("CONNESSIONE FALLITA " + exc.getMessage());
		}
		catch(ClassNotFoundException exc) {
			System.out.print("Class ffff non trovata " +exc.getMessage());
		}
	}
		
		public static ConnessioneDatabase getInstance() throws ClassNotFoundException, SQLException {
			if(instance==null || instance.getConnection().isClosed()==true) {
				instance=new ConnessioneDatabase();
			}
			return instance;
		}

		public Connection getConnection() {
			return this.connection;
		}
				
	
}
