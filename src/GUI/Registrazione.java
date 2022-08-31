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
import java.awt.Color;

public class Registrazione extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create il frame che nel caso in cui non sei registrato, ti fa fare il login.
	 * @param frameChiamante è il frame da cui viene chiamato
         * @param r è l'oggetto che fa da intermediaro tra i vari package coinvolti
	 */
	
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
		panel_1.setBackground(SystemColor.window);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_3.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 250, 22));
		
		JLabel lblNewLabel_2 = new JLabel("nome");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setVgap(22);
		flowLayout.setHgap(250);
		panel_6.setBackground(Color.WHITE);
		panel_5.add(panel_6, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("cognome");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_6.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_8.getLayout();
		flowLayout_2.setVgap(22);
		flowLayout_2.setHgap(250);
		panel_8.setBackground(Color.WHITE);
		panel_7.add(panel_8, BorderLayout.NORTH);
		
		JLabel lblNewLabel_4 = new JLabel("e-mail");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_8.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_8.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_10.getLayout();
		flowLayout_3.setVgap(22);
		flowLayout_3.setHgap(250);
		panel_10.setBackground(Color.WHITE);
		panel_9.add(panel_10, BorderLayout.NORTH);
		
		JLabel lblNewLabel_5 = new JLabel("password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_10.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_10.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11, BorderLayout.SOUTH);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_12.getLayout();
		flowLayout_4.setVgap(22);
		flowLayout_4.setHgap(250);
		panel_12.setBackground(Color.WHITE);
		panel_11.add(panel_12, BorderLayout.NORTH);
		
		JLabel lblNewLabel_6 = new JLabel("corso");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_12.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_12.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_13.getLayout();
		flowLayout_5.setVgap(22);
		flowLayout_5.setHgap(250);
		panel_13.setBackground(Color.WHITE);
		panel_11.add(panel_13, BorderLayout.SOUTH);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("insegnante");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		panel_13.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("studente");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		panel_13.add(rdbtnNewRadioButton_1);
		
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