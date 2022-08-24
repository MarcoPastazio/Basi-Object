package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import GUI.NumeroQuizMultipla;
import model.Insegnante;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class CreaQuizRispostaAperta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JFrame frame;


	public CreaQuizRispostaAperta(JFrame framechiamante, Insegnante ins, String nometest, Controller r) {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1012, 721);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 16));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 10));
		
		JLabel lblNewLabel = new JLabel("CARMA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("QUIZ APERTA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(35);
		flowLayout.setHgap(60);
		panel_3.setBackground(Color.WHITE);
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("nome quiz: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(textField);
		textField.setColumns(43);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setVgap(35);
		flowLayout_1.setHgap(60);
		panel_5.setBackground(SystemColor.window);
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("inserisci la domanda: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(textField_1);
		textField_1.setColumns(38);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setVgap(35);
		flowLayout_2.setHgap(60);
		panel_6.setBackground(SystemColor.window);
		panel_4.add(panel_6, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_4 = new JLabel("inserisci la descrizione: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(textField_2);
		textField_2.setColumns(37);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setHgap(15);
		flowLayout_3.setVgap(35);
		panel_7.setBackground(SystemColor.window);
		panel_1.add(panel_7, BorderLayout.CENTER);
		
		JLabel lblNewLabel_5 = new JLabel("lunghezza max:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("punteggio max:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("punteggio min:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_8.getLayout();
		flowLayout_4.setHgap(30);
		panel_8.setBackground(SystemColor.window);
		contentPane.add(panel_8, BorderLayout.SOUTH);
		
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
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_8.add(btnNewButton);
		
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
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_8.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("TERMINA");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				r.CheckEmptyTest(nometest);
				//aggiungere un bottone salva e uno cancella tutto che in corso chiama elimina test e cancella 
				framechiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_8.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("AGGIUNGI");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomedomanda = textField.getText();
				String domanda = textField_1.getText();
				String descrizione = textField_2.getText();
				String lunghezzamas = textField_3.getText();
				int lunghezzamax = 0;
				String punteggiomas = textField_4.getText();
				double punteggiomax = 0;
				String punteggiomi = textField_5.getText();
				double punteggiomin = 0;
				boolean flag = true;
				
				try {
					if(nomedomanda.isEmpty() || domanda.isEmpty() || descrizione.isEmpty() || lunghezzamas.isEmpty() || punteggiomas.isEmpty() || punteggiomi.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Errore! devi riempire i campi");
					}else {
						lunghezzamax = Integer.parseInt(punteggiomas);
						punteggiomax = Double.parseDouble(punteggiomas);
						punteggiomin = Double.parseDouble(punteggiomi);
					}
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Errore! devi mettere un numero!");
					flag = false;
				}
				if(lunghezzamax > 0 && punteggiomax > 0 && punteggiomin<=0  && flag == true) {
					r.SalvaQuizAperta(nomedomanda, descrizione, domanda, lunghezzamax, punteggiomax, punteggiomin, nometest);
					
				}else {
					JOptionPane.showMessageDialog(null,"controlla i voti");
				}
				btnNewButton_3.setVisible(false);
				
			}
		});
		panel_8.add(btnNewButton_3);
		btnNewButton_3.setBackground(SystemColor.activeCaption);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
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
		btnNewButton_4.setBackground(SystemColor.activeCaption);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_8.add(btnNewButton_4);
	}

}
