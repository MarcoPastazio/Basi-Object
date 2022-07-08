package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Insegnante;
import Model.Test;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

public class CreaTest extends JFrame {

	public JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	
	/**
	 * Create the frame.
	 */
	public CreaTest(JFrame framechiamante, Insegnante ins, Controller r) {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 429);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(515, 73, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("INDIETRO");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				framechiamante.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(109, 297, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AGGIUNGI APERTA");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nometest = textField.getText();
				String durata = textField_1.getText();
				int durataa = 0;
				boolean flag = true;
				
				try {
					if(durata.isEmpty() | nometest.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Errore! devi riempire i campi");
					}else {
						durataa = Integer.parseInt(durata);
					}
				}catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "Errore! devi mettere un numero!");
					flag = false;
				}
				
				if(durataa > 0 & flag == true) {
					r.RegistrazioneTest(ins, nometest, durataa);
					JFrame frameDaChiamare = new CreaQuizRispostaAperta(frame, ins, nometest, r);
					frameDaChiamare.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		btnNewButton_1.setBounds(347, 297, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Come si chiama il nuovo test?");
		lblNewLabel.setBounds(168, 76, 169, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("AGGIUNGI MULTIPLA");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nometest = textField.getText();
				String durata = textField_1.getText();
				int durataa = 0;
				boolean flag = true;
				
				try {
					if(durata.isEmpty() | nometest.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Errore! devi riempire i campi");
					}else {
						durataa = Integer.parseInt(durata);
					}
				}catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "Errore! devi mettere un numero!");
					flag = false;
				}
				
				if(durataa > 0 & flag == true) {
					r.RegistrazioneTest(ins, nometest, durataa);
					JFrame frameDaChiamare = new CreaQuizRispostaMultipla(frame, ins, nometest, r);
					frameDaChiamare.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		btnNewButton_3.setBounds(611, 297, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Quanto durer\u00E0 il tuo test?");
		lblNewLabel_1.setBounds(168, 179, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(515, 176, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
