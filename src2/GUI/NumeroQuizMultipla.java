package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import model.Insegnante;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NumeroQuizMultipla extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFrame frame;

	/**
	 * Crea il frame dove decidi il numero di domande.
	 * @param frameChiamante è il frame da cui viene chiamato
         * @param st lo studente che sta usando l'applicazione
     	 * @param nometest è il nome del test creato dall'insegnante
     	 * @param r è l'oggetto che fa da intermediaro tra i vari package coinvolti
	 */
	public NumeroQuizMultipla(JFrame framechiamante, Insegnante ins, String nometest, Controller r) {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inserisci il numero di domande");
		lblNewLabel.setBounds(28, 62, 201, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(255, 59, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Avanti");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String numero=textField.getText();
				if(numero!=null) {
					int num=Integer.parseInt(numero);
					if(num>0 && num<8) {
						JFrame frameDaChiamare = new CreaQuizRispostaMultipla(framechiamante, ins,nometest, r,num);
						frameDaChiamare.setVisible(true);
						frame.setVisible(false);
						frame.dispose();
					}else {
						JOptionPane.showMessageDialog(null,"Troppe/Poche risposte");
					}
				}
			}
		});
		btnNewButton.setBounds(112, 198, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Torna indietro");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				framechiamante.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(233, 198, 111, 23);
		contentPane.add(btnNewButton_1);
	}
}
