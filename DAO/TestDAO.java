package DAO;

import Model.Insegnante;

public interface TestDAO {
	
	public boolean RegistrazioneTest(Insegnante ins, String nometest, int durata);
}
