package Model;

import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Test {

	private String nome;
	private String corso;
	private int durata;
	private Date data;
	private Insegnante insegnante;
	private ArrayList<QuizARispostaAperta> quizAperti;
	private ArrayList<QuizARispostaMultipla> quizMultipla;
	
	public Test(String nome, String corso, int durata, LocalDate data2, Insegnante insegnante, Date data) {
		this.nome=nome;
		this.corso=corso;
		this.durata=durata;
		this.data = data;
		this.insegnante=insegnante;
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public Insegnante getInsegnante() {
		return insegnante;
	}

	public void setInsegnante(Insegnante insegnante) {
		this.insegnante = insegnante;
	}

	public ArrayList<QuizARispostaAperta> getQuizAperti() {
		return quizAperti;
	}

	public void setQuizAperti(ArrayList<QuizARispostaAperta> quizAperti) {
		this.quizAperti = quizAperti;
	}

	public ArrayList<QuizARispostaMultipla> getQuizMultipla() {
		return quizMultipla;
	}

	public void setQuizMultipla(ArrayList<QuizARispostaMultipla> quizMultipla) {
		this.quizMultipla = quizMultipla;
	}
	
}
