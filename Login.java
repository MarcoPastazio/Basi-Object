package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ImplementazioneDAO.ImplementazioneInsegnanteDAO;
import ImplementazioneDAO.ImplementazioneStudenteDAO;
import Model.Insegnante;
import Model.Studente;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JSplitPane;

public class Login extends JFrame {

	public JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public Login (JFrame framechiamante) {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 437);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(442, 78, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(442, 109, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(442, 140, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(442, 171, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(442, 202, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblNewLabel.setBounds(137, 80, 49, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cognome");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(137, 111, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mail");
		lblNewLabel_2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(137, 142, 49, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(137, 173, 89, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Per accedere al sito devi registrarti!");
		lblNewLabel_4.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(180, 27, 318, 42);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cosa sei?");
		lblNewLabel_5.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(297, 281, 75, 20);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("INDIETRO");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				framechiamante.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		btnNewButton.setBounds(220, 366, 89, 23);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Insegnante");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(137, 325, 111, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Studente");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(449, 325, 111, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_1 = new JButton("CONFERMA");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnNewRadioButton_1.isSelected() & !rdbtnNewRadioButton.isSelected()) {
					String nome = textField.getText();
					String cognome = textField_1.getText();
					String login = textField_2.getText();
					String password = textField_3.getText();
					Studente st = new Studente(nome, password, login, cognome);
					ImplementazioneStudenteDAO ue = new ImplementazioneStudenteDAO();
					
					ue.Registrazione(st);
					//rec studente
				}else if(rdbtnNewRadioButton.isSelected() & !rdbtnNewRadioButton_1.isSelected()) {
					String nome = textField.getText();
					String cognome = textField_1.getText();
					String login = textField_2.getText();
					String password = textField_3.getText();
					String corso = textField_4.getText();
					Insegnante ins = new Insegnante(nome, password, login, cognome, corso);
					ImplementazioneInsegnanteDAO ue = new ImplementazioneInsegnanteDAO();
					
					ue.Registrazione(ins);
					//rec insegnante
				}
				frame.setVisible(false);
				framechiamante.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 10));
		btnNewButton_1.setBounds(409, 366, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Corso");
		lblNewLabel_6.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(137, 206, 69, 17);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("P.S. l'ultima casella \u00E8 da compilare solo se si \u00E8 un insegnante");
		lblNewLabel_7.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(123, 234, 437, 24);
		contentPane.add(lblNewLabel_7);
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 27, 550, 362);
		contentPane.add(panel);
	}
}
