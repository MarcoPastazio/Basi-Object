package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class HomeStudente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeStudente frame = new HomeStudente();
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
	public HomeStudente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 404);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ciao " + "..." + ", cosa vuoi fare?");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblNewLabel.setBounds(253, 71, 213, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Scelta test");
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnNewButton.setBounds(83, 182, 192, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnNewButton_1.setBounds(265, 245, 157, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Consulta punteggio");
		btnNewButton_2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnNewButton_2.setBounds(414, 182, 198, 35);
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(62, 42, 565, 302);
		contentPane.add(panel);
	}

}
