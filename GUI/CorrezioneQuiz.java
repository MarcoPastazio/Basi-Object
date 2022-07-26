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
import Model.Insegnante;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CorrezioneQuiz extends JFrame {

	private JPanel contentPane;
	public JFrame frame;
	private JTextField textField;
	
	/**
	 * Create the frame.
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
									JFrame frameDaChiamare = new CorrezioneQuiz(frame, r, nometest, nomestudente, indice+1, voti, ins);
									frameDaChiamare.setVisible(true);
									frame.setVisible(false);
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
									ArrayList<String> DomandeTest = r.RicavoNomeA(nometest, conto);
									r.AggiornamentoRispostaAperta(DomandeTest, nomestudente, conto, voti);
									r.AggiornamentoScelta(nomestudente, nometest, voti, conto);
									JFrame frameDaChiamare = new HomeInsegnante(frame, ins, r);
									frameDaChiamare.setVisible(true);
									frame.setVisible(false);
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
