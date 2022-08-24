package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import GUI.Conferma;
import GUI.ConsultaTest;
import GUI.ScegliTest;
import GUI.ScegliTestSvolgere;
import GUI.SvolgiTestScelto;
import model.Studente;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class HomeStudente extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	
	
	
	public HomeStudente( Studente st, Controller r) {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 641);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 10));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 10));
		
		JLabel lblNewLabel = new JLabel("CARMA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Ciao " + st.getNome() + ", cosa vuoi fare?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(170);
		flowLayout.setVgap(100);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Scegli e svolgi test");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new ScegliTestSvolgere(frame, st,r);
				
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare= new Conferma(r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Svolgi un test scelto");
		btnNewButton_3.setBackground(SystemColor.activeCaption);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare= new SvolgiTestScelto(frame, r, st);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnNewButton_3);
	
		
		JButton btnNewButton_4 = new JButton("Consulta voti");
		btnNewButton_4.setBackground(SystemColor.activeCaption);
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new ConsultaTest(frame,st,r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("Scegli un test che svolgerai");
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new ScegliTest(frame,r,st);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnNewButton_2);
	}

}
