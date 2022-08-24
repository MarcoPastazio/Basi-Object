package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import model.Insegnante;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CorrezioneQuiz extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFrame frame;

	
	
	public CorrezioneQuiz(JFrame framechiamante, Controller r, String nometest, String nomestudente, int indice, float[] voti, Insegnante ins) {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 639);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 10));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 15));
		
		JLabel lblNewLabel = new JLabel("CARMA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(nometest);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 15));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.window);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(35);
		flowLayout.setHgap(60);
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		int conto = r.ConteggioDomande(nometest);
		ArrayList<Float> punteggiomax = r.PunteggioMax(nometest, conto);
		ArrayList<Float> punteggiomin = r.PunteggioMin(nometest, conto);
		
		String nome = r.RicavoNome(nometest, conto, indice);
		JLabel lblNewLabel_2 = new JLabel(nome);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.window);
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		flowLayout_1.setVgap(35);
		flowLayout_1.setHgap(60);
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		String domanda = r.RicavoDomanda(nometest, conto, indice);
		JLabel lblNewLabel_3 = new JLabel(domanda);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.window);
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEADING);
		flowLayout_2.setVgap(35);
		flowLayout_2.setHgap(60);
		panel_4.add(panel_6, BorderLayout.SOUTH);
		
		String risposta = r.RicavoRisposta(nometest, nomestudente, conto, indice);
		JLabel lblNewLabel_4 = new JLabel(risposta);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_4);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setHgap(20);
		panel_7.setBackground(SystemColor.window);
		panel_1.add(panel_7, BorderLayout.CENTER);
		
		JLabel lblNewLabel_5 = new JLabel("Voto:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_7.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_7.add(textField);
		textField.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.window);
		FlowLayout flowLayout_4 = (FlowLayout) panel_8.getLayout();
		flowLayout_4.setHgap(200);
		contentPane.add(panel_8, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("INDIETRO");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				framechiamante.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_8.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AVANTI");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_8.add(btnNewButton_1);
	}

}
