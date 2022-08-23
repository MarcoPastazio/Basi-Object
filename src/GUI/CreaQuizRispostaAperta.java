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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class CreaQuizRispostaAperta extends JFrame {

	public JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Crea il frame in cui viene creato il singolo quiz a risposta aperta per un determinato test
	 * e si possono aggiungere o altri quiz a risposta aperta o multipla.
	 * @param framechiamante il frame da cui veniamo
	 * @param ins è l'insegnante che sta creando il quiz
	 * @param nometest è il nome del test che il prof ha dato
	 * @param r è l'oggetto che fa da intermediaro tra i vari package coinvolti
	 */
	public CreaQuizRispostaAperta(JFrame framechiamante, Insegnante ins, String nometest, Controller r) {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fai mettere la domanda al prof");
		lblNewLabel.setBounds(269, 69, 153, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(105, 35, 539, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("TERMINA");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				framechiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(555, 328, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Far mettere la descrizione al prof");
		lblNewLabel_1.setBounds(250, 146, 216, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 173, 539, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome Domanda");
		lblNewLabel_2.setBounds(298, 11, 97, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 94, 539, 41);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Lunghezza Max");
		lblNewLabel_3.setBounds(177, 223, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Punteggio Max");
		lblNewLabel_4.setBounds(177, 248, 72, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Punteggio Min");
		lblNewLabel_5.setBounds(177, 273, 89, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(465, 220, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(465, 245, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(465, 270, 96, 20);
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
		btnNewButton_2.setBounds(105, 328, 131, 23);
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
		btnNewButton_3.setBounds(298, 328, 179, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("AGGIUNGI");
		btnNewButton.addMouseListener(new MouseAdapter() {
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
				btnNewButton.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(630, 264, 89, 23);
		contentPane.add(btnNewButton);
	}
}
