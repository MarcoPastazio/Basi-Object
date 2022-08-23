package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import model.Insegnante;
import model.Utente;

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
	 * Create il frame dove ci sta la home del lato insegnante dove si può o creare un test o
	 * correggere un test o eliminare un test.
	 * @param ins è l'insegnante che sta creando il quiz
	 * @param r è l'oggetto che fa da intermediaro tra i vari package coinvolti
	 */
	public HomeInsegnante( Insegnante ins, Controller r) {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 411);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(52, 30, 644, 296);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBounds(81, 203, 81, 29);
		panel.add(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare= new Conferma(r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("Crea test");
		btnNewButton.setBounds(30, 101, 212, 33);
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new CreaTest(frame, ins, r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("Correggi Test");
		btnNewButton_2.setBounds(411, 101, 223, 33);
		panel.add(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new VediTestAperteCorrezione(frame,ins,r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("Buongiorno " + ins.getNome() + ", Cosa vuole fare?");
		lblNewLabel.setBounds(145, 11, 286, 21);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		
		JButton btnNewButton_3 = new JButton("Elimina Test");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new EliminaTest(frame,r,ins);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnNewButton_3.setBounds(385, 209, 177, 23);
		panel.add(btnNewButton_3);
	}
}
