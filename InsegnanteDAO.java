//restituire flag negli update e insert
package DAO;

import java.util.ArrayList;
import Model.Insegnante;
import Model.Quiz;
import Model.Test;
import Model.TestSvolto;

public interface InsegnanteDAO {
	
	public ArrayList<TestSvolto> TestDaCorreggere(Insegnante ins);
	public boolean Registrazione(Insegnante ins);
	public boolean SavePassword (String pass, Insegnante ins);
	public boolean NomeCognome(Insegnante ins);
	public ArrayList<Test> TestDaPoterEliminare(Insegnante ins);
	//in questo di sotto ci deve essere un controllo se lui è effettivamente il prof
	public boolean EliminaTestDiretto(Insegnante ins, Test t);
	public boolean validAut(Insegnante ins);
}
