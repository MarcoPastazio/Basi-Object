package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import GUI.HomeStudente;
import GUI.QuizMultiple;
import model.Studente;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class QuizAperte extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFrame frame;

	/**
	 * Crea il frame per lo svolgimento dei quiz a risposta aperta.
	 * @param framechiamante è il frame da cui viene chiamato
         * @param r è l'oggetto che fa da intermediaro tra i vari package coinvolti
         * @param contoaperte è il numero di domande a risposta aperta
         * @param contomultiple è il numero di domande a risposta multipla
         * @param st lo studente che sta usando l'applicazione
         * @param aperte sono le risposte aperte
         * @param multiple sono le risposte multiple
         * @param indice a che numero di domanda siamo
         * @param nometest il nome del test selezionato dallo studente
	 */
	public QuizAperte(JFrame framechiamante, Controller r, int contoaperte, int contomultiple, Studente st, String[] aperte, String[] multiple, int indice, String nometest) {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 657);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 40));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 15));
		
		JLabel lblNewLabel = new JLabel("CARMA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel(nometest);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(22, 25));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(60);
		flowLayout.setVgap(35);
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel_3.setBackground(SystemColor.window);
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		
		String nome = r.RicavoNome(nometest, contoaperte, indice);
		JLabel lblNewLabel_1 = new JLabel(nome);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setVgap(35);
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		flowLayout_1.setHgap(60);
		panel_5.setBackground(SystemColor.window);
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		
		String domanda = r.RicavoDomanda(nometest, contoaperte, indice);
		JLabel lblNewLabel_3 = new JLabel(domanda);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_3);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEADING);
		flowLayout_2.setVgap(35);
		flowLayout_2.setHgap(60);
		panel_6.setBackground(SystemColor.window);
		panel_4.add(panel_6, BorderLayout.SOUTH);
		
		
		String descrizione = r.RicavoDescrizione(nometest, contoaperte, indice);
		JLabel lblNewLabel_4 = new JLabel(descrizione);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_4);
		
		textField = new JTextField();
		panel_1.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setHgap(150);
		panel_7.setBackground(SystemColor.window);
		panel_1.add(panel_7, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("INDIETRO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				framechiamante.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AVANTI");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(indice < contoaperte-1) {
						String risposta =  textField.getText();
						if(risposta.length() > r.ControlloLunghezza(nome)) {
							JOptionPane.showMessageDialog(null, "Hai sforato la lunghezzamax");
						}else {
							aperte[indice] = risposta;
							JFrame frameDaChiamare = new QuizAperte(frame, r, contoaperte, contomultiple, st, aperte, multiple, indice+1, nometest);
							frameDaChiamare.setVisible(true);
							frame.setVisible(false);
						}
					}else {
						String risposta =  textField.getText();
						aperte[indice] = risposta;
						JFrame frameDaChiamare = new QuizMultiple(frame, r, aperte, multiple, st, nometest, contoaperte, contomultiple, 0);
						frameDaChiamare.setVisible(true);
						frame.setVisible(false);
					}
					
					
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CONSEGNA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> domandeaperte = r.RicavoDomandaA(nometest, contoaperte);
				String nomeprof = r.NomeProf(nometest);
				r.Rispostaaperta(st.getLogin(), nomeprof, domandeaperte, aperte, contoaperte);
				ArrayList<String> domandemultiple = r.RicavoDomandeM(nometest, contomultiple);
				r.Rispostamultipla(st.getLogin(), domandemultiple, multiple, contomultiple);
				r.TerminatoTrue(nometest,st);
				r.InserisciTest(nometest,st);
				JFrame frameDaChiamare = new HomeStudente(st, r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(btnNewButton_2);
	}

}
