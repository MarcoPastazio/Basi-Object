package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SceltaTest extends JFrame {

	public JFrame frame;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SceltaTest(JFrame framechiamante) {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quale test vuoi sostenere?");
		lblNewLabel.setBounds(262, 41, 132, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("INDIETRO");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				framechiamante.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(283, 289, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("Decidere come far decidere i test agli studeti");
		lblNewLabel_1.setBounds(213, 164, 223, 14);
		contentPane.add(lblNewLabel_1);
	}

}
