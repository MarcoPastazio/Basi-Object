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

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreaTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFrame frame;


	/**
	 * Crea il frame in cui l'insegnante dichiara il nome del test, la durata e può aggiungere
	 * quiz a risposta aperta o multipla.
	 * @param framechiamante il frame da cui veniamo
	 * @param ins è l'insegnante che sta creando il quiz
	 * @param r è l'oggetto che fa da intermediaro tra i vari package coinvolti
	 */
	
	public CreaTest(JFrame framechiamante, Insegnante ins, Controller r) {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 655);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 15));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 10));
		
		JLabel lblNewLabel = new JLabel("CARMA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CREA TEST");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(35);
		flowLayout.setHgap(100);
		panel_3.setBackground(SystemColor.window);
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("Come si chiama il nuovo test?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
		flowLayout_2.setHgap(100);
		panel_5.setBackground(SystemColor.window);
		panel_1.add(panel_5, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("INDIETRO");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				framechiamante.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(SystemColor.activeCaption);
		panel_5.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AGGIUNGI APERTA");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nometest = textField.getText();
					if(nometest.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Errore! devi riempire i campi");
					}else {
						r.RegistrazioneTest(ins, nometest);
						JFrame frameDaChiamare = new CreaQuizRispostaAperta(frame, ins, nometest, r);
						frameDaChiamare.setVisible(true);
						frame.setVisible(false);
						
					}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		panel_5.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("AGGIUNGI MULTIPLA");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nometest = textField.getText();
					if(nometest.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Errore! devi riempire i campi");
					}else {
						r.RegistrazioneTest(ins, nometest);
						JFrame frameDaChiamare = new CreaQuizRispostaAperta(frame, ins, nometest, r);
						frameDaChiamare.setVisible(true);
						frame.setVisible(false);
						
					}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		panel_5.add(btnNewButton_2);
	}

}
