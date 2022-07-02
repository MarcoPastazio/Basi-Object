package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuizAperte extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	/**
	 * Create the frame.
	 */
	public QuizAperte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Domanda numero ");
		lblNewLabel.setBounds(36, 43, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("(mettere la domanda che sta nel db)");
		lblNewLabel_1.setBounds(82, 122, 545, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(82, 197, 608, 68);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("INDIETRO");
		btnNewButton.setBounds(69, 320, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AVANTI");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(342, 320, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CONSEGNA");
		btnNewButton_2.setBounds(620, 320, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
