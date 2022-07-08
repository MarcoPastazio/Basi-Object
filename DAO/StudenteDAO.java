package DAO;

import Model.Studente;

public interface StudenteDAO {
	public boolean Registrazione(Studente s);
	public void Login(Studente s);
	public boolean LoginB(Studente s);
}