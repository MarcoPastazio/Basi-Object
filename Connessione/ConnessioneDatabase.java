package Connessione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDatabase {
	private static ConnessioneDatabase instance;
	private Connection connection = null;
	private String url="jdbc:postgresql://localhost:5432/Progetto7";
	
	public ConnessioneDatabase() throws SQLException, ClassNotFoundException{
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection(url, "postgres", "marcopastore");
			System.out.println("Connessione stabilita");
		}
		catch(SQLException exc){
			System.out.print("CONNESSIONE FALLITA " + exc.getMessage());
		}
		catch(ClassNotFoundException exc) {
			System.out.print("Class non trovata " +exc.getMessage());
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