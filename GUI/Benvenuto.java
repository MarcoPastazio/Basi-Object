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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Benvenuto extends JFrame {

	public JFrame frame;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Benvenuto() {
		frame=this;
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
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
		
		JButton btnNewButton = new JButton("NO");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new Login(frame);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(128, 243, 89, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SI");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new Conferma(frame);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(504, 243, 89, 23);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(55, 27, 583, 362);
		contentPane.add(panel);
	}
}
