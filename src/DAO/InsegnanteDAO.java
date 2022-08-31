package DAO;

/**
 * All’interno del package ci sono le classi con tutte le implementazioni delle interfacce DAO rispetto a quel database
 */

import java.sql.ResultSet;

import model.Insegnante;

public interface InsegnanteDAO {
	public ResultSet PrendiTestCorreggere (Insegnante ins);
	public boolean Registrazione(Insegnante ins);
	public void Login(Insegnante ins);
	public boolean LoginB(Insegnante ins);
}
