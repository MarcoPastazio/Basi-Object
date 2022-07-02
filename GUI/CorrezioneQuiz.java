package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CorrezioneQuiz extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public CorrezioneQuiz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Domanda numero ");
		lblNewLabel.setBounds(43, 50, 317, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("(Domanda da correggere)");
		lblNewLabel_1.setBounds(43, 120, 231, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("(Risposta dello studente)");
		lblNewLabel_2.setBounds(263, 180, 171, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("SBAGLIATA");
		btnNewButton.setBounds(118, 265, 106, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("CORRETTA");
		btnNewButton_2.setBounds(467, 265, 120, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("FINE");
		btnNewButton_3.setBounds(299, 316, 89, 23);
		contentPane.add(btnNewButton_3);
	}

}
