package DAO;

/**
 * All�interno del package ci sono le classi con tutte le implementazioni delle interfacce DAO rispetto a quel database
 */

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Studente;

public interface SceltaDAO {
	public void SalvaScelta(String test,String studente) throws SQLException ;
	public boolean AggiornamentoScelta(String nomestudente, float[] voti, int conto,String nometest,float risM);
	public boolean CheckTestStudente(String test, String studente);
	public void InserisciTest(String nometest, Studente st);
}
