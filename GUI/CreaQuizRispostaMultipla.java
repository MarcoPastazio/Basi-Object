package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Insegnante;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class CreaQuizRispostaMultipla extends JFrame {

	public JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
	/**
	 * Create the frame.
	 */
	public CreaQuizRispostaMultipla(JFrame framechiamante, Insegnante ins, String nometest, Controller r) {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("TERMINA");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new CreaTest(frame, ins, r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(576, 358, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Nome Domanda");
		lblNewLabel.setBounds(310, 11, 94, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(87, 46, 560, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("La domanda effettiva");
		lblNewLabel_1.setBounds(310, 77, 122, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(87, 102, 560, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descrizione della domanda");
		lblNewLabel_2.setBounds(315, 123, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(87, 148, 560, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Voto Risposta Corretta");
		lblNewLabel_3.setBounds(157, 239, 122, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Voto Risposta Sbagliata");
		lblNewLabel_4.setBounds(157, 274, 122, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Risposta Corretta");
		lblNewLabel_5.setBounds(157, 310, 100, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(524, 236, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(524, 271, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(524, 307, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("AGGIUNGI APERTA");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomedomanda = textField.getText();
				String domanda = textField_1.getText();
				String descrizione = textField_2.getText();
				String votorispostac = textField_3.getText();
				float votorispostacorretta = 0;
				String votorispostas = textField_4.getText();
				float votorispostasbagliata = 0;
				String rispostacorretta = textField_5.getText();
				boolean flag = true;
				
				try {
					if(nomedomanda.isEmpty() | domanda.isEmpty() | descrizione.isEmpty() | votorispostac.isEmpty() | votorispostas.isEmpty() & rispostacorretta.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Errore! devi riempire i campi");
					}else {
						votorispostacorretta = Float.parseFloat(votorispostac);
						votorispostasbagliata = Float.parseFloat(votorispostas);
					}
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Errore! devi mettere un numero!");
					flag = false;
				}
				
				if(votorispostacorretta > 0 & votorispostasbagliata < 1 & flag == true) {
					r.SalvaQuizMultipla(nomedomanda, descrizione, domanda, votorispostacorretta, votorispostasbagliata, nometest, rispostacorretta);
					JFrame frameDaChiamare = new CreaQuizRispostaAperta(frame, ins, nometest, r);
					frameDaChiamare.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		btnNewButton_2.setBounds(105, 358, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("AGGIUNGI MULTIPLA");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String nomedomanda = textField.getText();
				String domanda = textField_1.getText();
				String descrizione = textField_2.getText();
				String votorispostac = textField_3.getText();
				float votorispostacorretta = 0;
				String votorispostas = textField_4.getText();
				float votorispostasbagliata = 0;
				String rispostacorretta = textField_5.getText();
				boolean flag = true;
				
				try {
					if(nomedomanda.isEmpty() | domanda.isEmpty() | descrizione.isEmpty() | votorispostac.isEmpty() | votorispostas.isEmpty() & rispostacorretta.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Errore! devi riempire i campi");
					}else {
						votorispostacorretta = Float.parseFloat(votorispostac);
						votorispostasbagliata = Float.parseFloat(votorispostas);
					}
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Errore! devi mettere un numero!");
					flag = false;
				}
				
				if(votorispostacorretta > 0 & votorispostasbagliata < 1 & flag == true) {
					r.SalvaQuizMultipla(nomedomanda, descrizione, domanda, votorispostacorretta, votorispostasbagliata, nometest, rispostacorretta);
					JFrame frameDaChiamare = new CreaQuizRispostaMultipla(frame, ins, nometest, r);
					frameDaChiamare.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		btnNewButton_3.setBounds(343, 358, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
