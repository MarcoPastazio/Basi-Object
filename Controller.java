package Controller;

import ImplementazioneDAO.*;
import Model.*; 

public class Controller {
	
	private ImplementazioneInsegnanteDAO in;
	private ImplementazioneStudenteDAO s;
	
	
	public Controller() {
		in = new ImplementazioneInsegnanteDAO();
		s = new ImplementazioneStudenteDAO();	
	}
	
	public boolean LoginB(Studente st) {
		boolean ok = s.LoginB(st);
		return ok;
	}
	
	public void Login(Studente st) {
		s.Login(st);
	}
	
	public boolean LoginB(Insegnante ins) {
		boolean ok = in.LoginB(ins);
		return ok;
	}
	
	public void Login(Insegnante ins) {
		in.Login(ins);
	}
	
	
}
