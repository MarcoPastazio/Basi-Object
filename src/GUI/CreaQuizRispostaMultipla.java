package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import model.Insegnante;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

public class CreaQuizRispostaMultipla extends JFrame {

	public JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	
	/**
	 * Create the frame.
	 */
	public CreaQuizRispostaMultipla(JFrame framechiamante, Insegnante ins, String nometest, Controller r, int numeroRisposte) {
		JTextField[] textField_2=new JTextField[numeroRisposte];
		frame = this;
		JPanel panel_1 = new JPanel();
		//panel_1=r.setTextField(panel_1,textField_2);
		for(int i=0;i<textField_2.length;i++) {
			textField_2[i]=new JTextField();
			textField_2[i].setBounds(524, 236, 96, 20);
			textField_2[i].setColumns(10);
			panel_1.add(textField_2[i]);
		}
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
				framechiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(512, 358, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Nome Domanda");
		lblNewLabel.setBounds(105, 11, 122, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(87, 36, 166, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Inserisci la descrizione ");
		lblNewLabel_1.setBounds(310, 70, 146, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(87, 95, 560, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Voto Risposta Corretta");
		lblNewLabel_3.setBounds(157, 239, 146, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Voto Risposta Sbagliata");
		lblNewLabel_4.setBounds(157, 274, 146, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Risposta Corretta");
		lblNewLabel_5.setBounds(157, 310, 122, 14);
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
				JFrame frameDaChiamare = new CreaQuizRispostaAperta(framechiamante, ins, nometest, r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(55, 358, 166, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("AGGIUNGI MULTIPLA");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new NumeroQuizMultipla(framechiamante, ins, nometest, r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
				
				
			}
		});
		btnNewButton_3.setBounds(277, 358, 182, 23);
		contentPane.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(87, 133, 560, 92);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Inserisci le risposte");
		panel.add(lblNewLabel_2, BorderLayout.NORTH);
		
		
		panel.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_6 = new JLabel("Inserisci la domanda");
		lblNewLabel_6.setBounds(414, 11, 111, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(313, 37, 334, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("AGGIUNGI");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomedomanda = textField.getText();
				String descrizione = textField_1.getText();
				String risposte=r.PrendiDomanda(textField_2);
				String domanda=textField_6.getText();
				
				
				String votorispostac = textField_3.getText();
				float votorispostacorretta = 0;
				String votorispostas = textField_4.getText();
				float votorispostasbagliata = 0;
				String rispostacorretta = textField_5.getText();
				boolean flag = true;
				
				try {
					if(risposte.isEmpty() ||nomedomanda.isEmpty() || domanda.isEmpty() || descrizione.isEmpty() || votorispostac.isEmpty() || votorispostas.isEmpty() && rispostacorretta.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Errore! devi riempire i campi");
					}else {
						if(domanda.contains("?")) {
							domanda=domanda+risposte;
						}else {
							domanda=domanda+":"+risposte;
						}
						votorispostacorretta = Float.parseFloat(votorispostac);
						votorispostasbagliata = Float.parseFloat(votorispostas);
					}
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Errore! devi mettere un numero!");
					flag = false;
				}
				
				if(votorispostacorretta > 0 && votorispostasbagliata < 1 && flag == true) {
					r.SalvaQuizMultipla(nomedomanda, descrizione, domanda, votorispostacorretta, votorispostasbagliata, nometest, rispostacorretta);
				}else {
					JOptionPane.showMessageDialog(null,"controlla i voti");
				}
				btnNewButton.setVisible(false);
			}
		});
		btnNewButton.setBounds(670, 270, 89, 23);
		contentPane.add(btnNewButton);
	}
}