package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import model.Studente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class HomeStudente extends JFrame {

	public JFrame frame;
	private JPanel contentPane;

	
	/**
	 * Create il frame dove ci sta la home del lato studente dove si può o svolgere un test o
	 * scegliere un test per il futuro o consultare i punteggi dei vari test.
	 * @param st è lo studente che ha avuto accesso all'applicazione
	 * @param r è l'oggetto che fa da intermediaro tra i vari package coinvolti
	 */
	public HomeStudente( Studente st, Controller r) {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 404);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 93, 698, 272);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Scelta test");
		btnNewButton.setBounds(59, 57, 229, 29);
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new ScegliTestSvolgere(frame, st,r);
				
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		
		JButton btnNewButton_3 = new JButton("Scegli un test per il futuro");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new ScegliTest(frame,r,st);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(59, 120, 229, 29);
		panel.add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("Consulta punteggio");
		btnNewButton_2.setBounds(59, 175, 229, 29);
		panel.add(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new ConsultaTest(frame,st,r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBounds(451, 57, 195, 29);
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
		
		JButton btnNewButton_4 = new JButton("Esegui test scelto");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare= new SvolgiTestScelto(frame, r, st);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnNewButton_4.setBounds(451, 120, 195, 29);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Ciao " + st.getNome() + ", cosa vuoi fare?");
		lblNewLabel.setBounds(222, 49, 228, 21);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.controlHighlight);
		menuBar.setBounds(0, 0, 698, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JButton btnNewButton_5 = new JButton("Esci");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(1);
			}
		});
		mnNewMenu.add(btnNewButton_5);
	}
}
