package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Insegnante;
import model.Test;

public interface TestDAO {
	
	public boolean RegistrazioneTest(Insegnante ins, String nometest, int durata);
	public boolean CheckTest (Test t);
	public ResultSet PrendiTestAperte(Test t);
	public ResultSet PrendiTestMultiple(Test t);
	public void setInvalid(String test) throws SQLException;
}
