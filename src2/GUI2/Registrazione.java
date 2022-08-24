package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import model.Insegnante;
import model.Studente;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Registrazione extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JFrame frame;

	
	
	public Registrazione(JFrame framechiamante, Controller r) {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 656);
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
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PER ACCEDERE DEVI REGISTRARTI !");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(40);
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setHgap(219);
		panel_1.setBackground(SystemColor.window);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("nome");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("cognome");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("e-mail");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Corso");
		lblNewLabel_6.setToolTipText("compilare solo se si \u00E8 insegnanti");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("compilare solo se si \u00E8 insegnanti");
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Insegnante");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBackground(SystemColor.window);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Studente");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBackground(SystemColor.window);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setHgap(200);
		panel_2.setBackground(SystemColor.window);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
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
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AVANTI");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnNewRadioButton_1.isSelected() & !rdbtnNewRadioButton.isSelected()) {
					String nome = textField.getText();
					String cognome = textField_1.getText();
					String login = textField_2.getText();
					String password = textField_3.getText();
					Studente st = new Studente(nome, password, login, cognome);
					
					if(nome.isEmpty() | cognome.isEmpty() | login.isEmpty() | password.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Errore! devi riempire i campi indicati");
					}else {
						r.RegistrazioneS(st);
					}
				}else if(rdbtnNewRadioButton.isSelected() & !rdbtnNewRadioButton_1.isSelected()) {
					String nome = textField.getText();
					String cognome = textField_1.getText();
					String login = textField_2.getText();
					String password = textField_3.getText();
					String corso = textField_4.getText();
					Insegnante ins = new Insegnante(nome, password, login, cognome, corso);
					
					if(nome.isEmpty() | cognome.isEmpty() | login.isEmpty() | password.isEmpty() | corso.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Errore! devi riempire i campi indicati");
					}else {
						r.RegistrazioneI(ins);
					}
					//rec insegnante
				}
				frame.setVisible(false);
				framechiamante.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(btnNewButton_1);
	}

}
