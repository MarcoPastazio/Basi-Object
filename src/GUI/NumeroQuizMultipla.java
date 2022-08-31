package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import GUI.CreaQuizRispostaMultipla;
import model.Insegnante;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class NumeroQuizMultipla extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFrame frame;

	/**
	 * Crea il frame dove decidi il numero di domande.
	 * @param frameChiamante è il frame da cui viene chiamato
         * @param st lo studente che sta usando l'applicazione
         * @param nometest è il nome del test creato dall'insegnante
         * @param r è l'oggetto che fa da intermediaro tra i vari package coinvolti
	 */
	
	public NumeroQuizMultipla(JFrame framechiamante, Insegnante ins, String nometest, Controller r) {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 627);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 15));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 15));
		
		JLabel lblNewLabel = new JLabel("CARMA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("numero risposte");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(40);
		flowLayout.setVgap(200);
		panel_1.setBackground(SystemColor.window);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("inserisci il numero di risposte: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setHgap(150);
		panel_2.setBackground(SystemColor.window);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("AVANTI");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String numero=textField.getText();
				if(numero!=null) {
					int num=Integer.parseInt(numero);
					if(num>0 && num<8) {
						System.out.print("\n\n"+num+"\n\n");
						JFrame frameDaChiamare = new CreaQuizRispostaMultipla(framechiamante, ins,nometest, r,num);
						frameDaChiamare.setVisible(true);
						frame.setVisible(false);
						frame.dispose();
					}else {
						JOptionPane.showMessageDialog(null,"Troppe/Poche risposte");
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(SystemColor.activeCaption);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("TORNA INDIETRO");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				framechiamante.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		panel_2.add(btnNewButton_1);
	}

}
