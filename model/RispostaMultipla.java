package model;

public class RispostaMultipla {
	private String descrizione;
	private char lettera;
	public String getDescrizione() {
		return descrizione;
	}
	
	public RispostaMultipla(String descrizione , char lettera) {
		this.descrizione=descrizione;
		this.lettera=lettera;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public char getLettera() {
		return lettera;
	}
	public void setLettera(char lettera) {
		this.lettera = lettera;
	}
}
