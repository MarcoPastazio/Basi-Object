package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import model.Studente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class QuizAperte extends JFrame {

	public JFrame frame;
	private JPanel contentPane;
	private JTextField textField;

	
	/**
	 * Create the frame.
	 */
	public QuizAperte(JFrame framechiamante, Controller r, int contoaperte, int contomultiple, Studente st, String[] aperte, String[] multiple, int indice, String nometest) {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//carmine in scelta test si porterà in questo metodo il nome del test e lo metteremo sempre qua
		JLabel lblNewLabel = new JLabel(nometest);
		lblNewLabel.setBounds(329, 23, 102, 14);
		contentPane.add(lblNewLabel);
		
		//li devo mettere singolarmente dentro i jlabel e sto na crema e amarena
		String nome = r.RicavoNome(nometest, contoaperte, indice);
		JLabel lblNewLabel_1 = new JLabel(nome);
		lblNewLabel_1.setBounds(87, 68, 608, 14);
		contentPane.add(lblNewLabel_1);
		
		String domanda = r.RicavoDomanda(nometest, contoaperte, indice);
		JLabel lblNewLabel_2 = new JLabel(domanda);
		lblNewLabel_2.setBounds(87, 114, 608, 14);
		contentPane.add(lblNewLabel_2);
		
		String descrizione = r.RicavoDescrizione(nometest, contoaperte, indice);
		JLabel lblNewLabel_3 = new JLabel(descrizione);
		lblNewLabel_3.setBounds(87, 150, 608, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(87, 175, 608, 114);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("INDIETRO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				framechiamante.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(69, 320, 89, 23);
		contentPane.add(btnNewButton);
		
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
					
					
					//non so se salvare tutto con FINE(non so come fare) oppure fare piano piano inserisco nel db e poi update se lo studente vuole fare na modifica
					//mi serve per andare a salvare tutto in rispostaaperta
					
					//successivamente passo alle multiple e chiedere a francesco il fatto della jlist
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(342, 320, 89, 23);
		contentPane.add(btnNewButton_1);
		
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
		btnNewButton_2.setBounds(620, 320, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
	}
}
