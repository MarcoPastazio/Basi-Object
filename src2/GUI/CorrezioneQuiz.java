package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import model.Insegnante;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CorrezioneQuiz extends JFrame {

	private JPanel contentPane;
	public JFrame frame;
	private JTextField textField;
	
	/**
	 * Crea il frame in cui l'insegnante corregge i quiz a risposta aperta e mette un voto in base alla correttezza
	 * della risposta.
	 * @param framechiamante è il frame da cui viene chiamato
	 * @param r è l'oggetto che fa da intermediaro tra i vari package coinvolti
	 * @param nometest è il nome del test
	 * @param nomestudente è il nome per il login dello studente che ha svolto il quiz
	 * @param indice è il numero del quiz da correggere
	 * @param voti è un array di float dove si salvano i voti
	 * @param ins è l'insegnante che deve correggere il quiz  
	 */
	
	public CorrezioneQuiz(JFrame framechiamante, Controller r, String nometest, String nomestudente, int indice, float[] voti, Insegnante ins) {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int conto = r.ConteggioDomande(nometest);
		ArrayList<Float> punteggiomax = r.PunteggioMax(nometest, conto);
		ArrayList<Float> punteggiomin = r.PunteggioMin(nometest, conto);
		
		String nome = r.RicavoNome(nometest, conto, indice);
		JLabel lblNewLabel = new JLabel(nome);
		lblNewLabel.setBounds(43, 50, 317, 14);
		contentPane.add(lblNewLabel);
		
		String domanda = r.RicavoDomanda(nometest, conto, indice);
		JLabel lblNewLabel_1 = new JLabel(domanda);
		lblNewLabel_1.setBounds(43, 120, 231, 14);
		contentPane.add(lblNewLabel_1);
		
		String risposta = r.RicavoRisposta(nometest, nomestudente, conto, indice);
		JLabel lblNewLabel_2 = new JLabel(risposta);
		lblNewLabel_2.setBounds(42, 179, 643, 76);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(297, 247, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("AVANTI");
		//la mia idea è la seguente, se indice è uguale a conto, allo me lo salvo tutto nel db, altrimenti vado avanti
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String votos =  textField.getText();
				float voto;
				try{
					if(indice < conto-1) {
						try {
							if(votos.isEmpty()) {
								JOptionPane.showMessageDialog(null, "Errore! devi riempire i campi");
							}else {
								voto = Float.parseFloat(votos);
								if(voto > punteggiomax.get(indice) | voto < punteggiomin.get(indice)) {
									JOptionPane.showMessageDialog(null, "Il voto è compreso tra " + punteggiomin.get(indice) + "e "+ punteggiomax.get(indice));
								}else {
									voti[indice] = voto;
									JFrame frameDaChiamare = new CorrezioneQuiz(framechiamante, r, nometest, nomestudente, indice+1, voti, ins);
									frameDaChiamare.setVisible(true);
									frame.setVisible(false);
									frame.dispose();
								}
							}
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Errore! devi mettere un numero!");
						}
					}else {
						try {
							if(votos.isEmpty()) {
								JOptionPane.showMessageDialog(null, "Errore! devi riempire i campi");
							}else {
								voto = Float.parseFloat(votos);
								if(voto > punteggiomax.get(indice) | voto < punteggiomin.get(indice)) {
									JOptionPane.showMessageDialog(null, "Il voto è compreso tra " + punteggiomin.get(indice) + "e "+ punteggiomax.get(indice));
								}else {
									voto = Float.parseFloat(votos);
									voti[indice] = voto;
									ArrayList<String> DomandeTest = r.RicavoDomandaA(nometest, conto);
									r.AggiornamentoRispostaAperta(DomandeTest, nomestudente, conto, voti);
									r.AggiornamentoScelta(nomestudente, voti, conto,nometest);
									framechiamante.setVisible(true);
									frame.setVisible(false);
									frame.dispose();
									
								}
							}
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Errore! devi mettere un numero!");
						}
						
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(442, 315, 120, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("INDIETRO");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				framechiamante.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(131, 315, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Voto:");
		lblNewLabel_3.setBounds(225, 250, 49, 14);
		contentPane.add(lblNewLabel_3);
	}
}
