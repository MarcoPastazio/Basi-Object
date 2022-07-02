package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class SceltaCorrezioneTest extends JFrame {

	public JFrame frame;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SceltaCorrezioneTest(JFrame framechiamante) {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quale test vuoi correggere?");
		lblNewLabel.setBounds(294, 57, 147, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("INDIETRO");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				framechiamante.setVisible(true);
			}
		});
		btnNewButton.setBounds(151, 292, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AVANTI");
		btnNewButton_1.setBounds(558, 292, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Test");
		lblNewLabel_1.setBounds(151, 92, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome Studente");
		lblNewLabel_2.setBounds(558, 92, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TROVA UN MODO PER FAR SCEGLIERE IL TEST");
		lblNewLabel_3.setBounds(254, 188, 244, 14);
		contentPane.add(lblNewLabel_3);
	}

}
