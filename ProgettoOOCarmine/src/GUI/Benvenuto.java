package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Benvenuto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Benvenuto frame = new Benvenuto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Benvenuto() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Benvenuto in Cama");
		lblNewLabel.setBounds(271, 33, 173, 49);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sei registrato sulla piattaforma?");
		lblNewLabel_1.setBounds(224, 124, 277, 65);
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SI");
		btnNewButton.setBounds(128, 243, 89, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("NO");
		btnNewButton_1.setBounds(504, 243, 89, 23);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btnNewButton_1);
	}
}
