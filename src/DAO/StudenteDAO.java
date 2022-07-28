package DAO;

import java.sql.ResultSet;

import model.Studente;

public interface StudenteDAO {
	public boolean Registrazione(Studente s);
	public void Login(Studente s);
	public ResultSet LeggiTest(Studente s);
	public ResultSet ConsultaVoti(Studente s);
	public ResultSet PrendiScelte(Studente s);
	public ResultSet LeggiTestS(Studente s);
	public boolean LoginB(Studente s);
}
