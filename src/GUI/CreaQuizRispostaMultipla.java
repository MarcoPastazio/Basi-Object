package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import GUI.CreaQuizRispostaAperta;
import GUI.NumeroQuizMultipla;
import model.Insegnante;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class CreaQuizRispostaMultipla extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JFrame frame;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	

	/**
	 * Crea il frame in cui viene creato il singolo quiz a risposta multipla per un determinato test
	 * e si possono aggiungere o altri quiz a risposta multipla o aperta.
	 * @param framechiamante il frame da cui veniamo
	 * @param ins è l'insegnante che sta creando il quiz
	 * @param nometest è il nome del test che il prof ha dato
	 * @param r è l'oggetto che fa da intermediaro tra i vari package coinvolti
	 * @param numeroRisposte è il numero di quiz a risposta multipla
	 */


	public CreaQuizRispostaMultipla(JFrame framechiamante, Insegnante ins, String nometest, Controller r, int numeroRisposte) {
		
		frame=this;
		
		JTextField[] textField_5=new JTextField[numeroRisposte];
		frame = this;
		JPanel panel_10 = new JPanel();
		
		FlowLayout flowLayout = (FlowLayout) panel_10.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(15);
		panel_10.setBackground(SystemColor.window);
		
		for(int i=0;i<textField_5.length;i++) {
			textField_5[i]=new JTextField();
			textField_5[i].setBounds(524, 236, 96, 20);
			textField_5[i].setColumns(10);
			panel_10.add(textField_5[i]);
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 703);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 15));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 15));
		
		JLabel lblNewLabel = new JLabel("CARMA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("quiz multipla");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.window);
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 35));
		
		JLabel lblNewLabel_2 = new JLabel("inserisci il nome: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(textField);
		textField.setColumns(45);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.window);
		panel_2.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.window);
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 35));
		
		JLabel lblNewLabel_3 = new JLabel("inserisci la domanda: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(42);
		panel_5.add(textField_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.window);
		panel_4.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 35));
		
		JLabel lblNewLabel_4 = new JLabel("inserisci la descrizione: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(textField_2);
		textField_2.setColumns(42);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.window);
		panel_1.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new BorderLayout(15, 0));
		
		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_9.getLayout();
		flowLayout_2.setVgap(15);
		panel_9.setBackground(SystemColor.window);
		panel_8.add(panel_9, BorderLayout.NORTH);
		
		JLabel lblNewLabel_5 = new JLabel("inserisci le risposte:");
		lblNewLabel_5.setBackground(SystemColor.window);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_9.add(lblNewLabel_5);
		
		panel_8.add(panel_10, BorderLayout.SOUTH);
		
		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_11.getLayout();
		flowLayout_1.setVgap(35);
		flowLayout_1.setHgap(15);
		panel_11.setBackground(SystemColor.window);
		panel_7.add(panel_11, BorderLayout.CENTER);
		
		JLabel lblNewLabel_6 = new JLabel("voto risposta corretta");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_11.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_11.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("voto risposta sbagliata");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_11.add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_11.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("risposta corretta");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_11.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_11.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_12.getLayout();
		flowLayout_3.setHgap(30);
		panel_12.setBackground(SystemColor.window);
		contentPane.add(panel_12, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("AGGIUNGI APERTA");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new CreaQuizRispostaAperta(framechiamante, ins, nometest, r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(SystemColor.activeCaption);
		panel_12.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AGGIUNGI MULTIPLA");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new NumeroQuizMultipla(framechiamante, ins, nometest, r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		panel_12.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("TERMINA");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				r.CheckEmptyTest(nometest);
				framechiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		panel_12.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("AGGIUNGI");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomedomanda = textField.getText();
				String descrizione = textField_2.getText();
				String risposte= r.PrendiDomanda(textField_5);
				String domanda=textField_1.getText();
				
				
				String votorispostac = textField_3.getText();
				float votorispostacorretta = 0;
				String votorispostas = textField_4.getText();
				float votorispostasbagliata = 0;
				String rispostacorretta = textField_6.getText();
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
					btnNewButton_3.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,"controlla i voti");
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBackground(SystemColor.activeCaption);
		panel_12.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CANCELLA TUTTO");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				r.EliminaTestScelto(nometest);
				framechiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
			
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBackground(SystemColor.activeCaption);
		panel_12.add(btnNewButton_4);

		
	}

}
