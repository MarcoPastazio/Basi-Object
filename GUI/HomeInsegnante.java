package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class HomeInsegnante extends JFrame {

	public JFrame frame;
	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public HomeInsegnante(JFrame framechiamante) {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 411);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buongiorno " + "..." + ", Cosa vuole fare?");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblNewLabel.setBounds(256, 50, 239, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Crea test");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new CreaTest(frame);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnNewButton.setBounds(79, 132, 212, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				framechiamante.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnNewButton_1.setBounds(283, 219, 191, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Correggi Test");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new SceltaCorrezioneTest(frame);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnNewButton_2.setBounds(457, 132, 223, 33);
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(52, 30, 644, 296);
		contentPane.add(panel);
	}

}
