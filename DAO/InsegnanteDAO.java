//restituire flag negli update e insert
package DAO;

//import java.util.ArrayList;

//import javax.swing.JTextField;

import Model.Insegnante;
//import Model.QuizARispostaMultipla;
//import Model.QuizARispostaAperta;
//import Model.Test;


public interface InsegnanteDAO {
	
	//public ArrayList<Test> TestDaCorreggere(Insegnante ins);
	public boolean Registrazione(Insegnante ins);
	//public boolean SavePassword (String pass, Insegnante ins);
	//public boolean NomeCognome(Insegnante ins);
	//public ArrayList<Test> TestDaPoterEliminare(Insegnante ins);
	//in questo di sotto ci deve essere un controllo se lui è effettivamente il prof
	//public boolean EliminaTestDiretto(Insegnante ins, Test t);
	//public boolean validAut(Insegnante ins);
	public void Login(Insegnante ins);
	public boolean LoginB(Insegnante ins);
}
