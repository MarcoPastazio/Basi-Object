package Model;

import ImplementazioneDAO.ImplementazioneInsegnanteDAO;

public class MainModel {

	public static void main(String[] args) {
		Insegnante ins = new Insegnante("echiaro@gmail.com", "ahokok");
		ImplementazioneInsegnanteDAO ue = new ImplementazioneInsegnanteDAO();
		
		ue.Login(ins);
		System.out.println(ins.getLogin() + ins.getNome() + ins.getCognome() + ins.getPassword() + ins.getCorso());
		
	}

}
