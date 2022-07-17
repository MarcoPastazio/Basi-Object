package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Studente;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class QuizMultiple extends JFrame {

	public JFrame frame;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public QuizMultiple(JFrame framechiamante, Controller r, String[] aperte, String[] multiple, Studente st, String nometest, int contoaperte, int contomultiple, int indice) {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel(nometest);
		lblNewLabel_3.setBounds(275, 11, 135, 14);
		contentPane.add(lblNewLabel_3);
		
		String nome = r.RicavoNomeM(nometest, contomultiple, indice);
		JLabel lblNewLabel = new JLabel(nome);
		lblNewLabel.setBounds(119, 64, 490, 14);
		contentPane.add(lblNewLabel);
		
		String domanda = r.RicavoDomandaM(nometest, contomultiple, indice);
		String[] split = new String[26];
		if(domanda.contains(":")) {
			split=domanda.split(":");
			split[0] = split[0]+":"; 
		}else {
			split=domanda.split("?");
			split[0] = split[0]+"?"; 
		}
		String[] split1 = split[1].split("@");
		
		String[] alfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		
		JLabel lblNewLabel_1 = new JLabel(split[0]);
		lblNewLabel_1.setBounds(119, 101, 490, 14);
		contentPane.add(lblNewLabel_1);
		
		String descrizione = r.RicavoDescrizioneM(nometest, contomultiple, indice);
		JLabel lblNewLabel_2 = new JLabel(descrizione);
		lblNewLabel_2.setBounds(119, 149, 490, 14);
		contentPane.add(lblNewLabel_2);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(258, 207, 187, 112);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		DefaultListModel demoList = new DefaultListModel();
		for(int i = 0; i<split1.length;i++) {
			demoList.addElement(split1[i]);
		}
		list.setModel(demoList);
		//list.setBorder(BorderFactory.createDashedBorder(null));
		
		JButton btnNewButton = new JButton("INDIETRO");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				framechiamante.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(119, 336, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("AVANTI");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					if(!list.isSelectionEmpty()) {
						int risposta = list.getSelectedIndex();
						multiple[indice] = alfabeto[risposta];
					}
					
					if(indice < contomultiple-1) {
						JFrame frameDaChiamare = new QuizMultiple(frame, r, aperte, multiple, st, nometest, contoaperte, contomultiple, indice+1);
						frameDaChiamare.setVisible(true);
						frame.setVisible(false);
					}
					//non so se salvare tutto con CONSEGNA(non so come fare) oppure fare piano piano inserisco nel db e poi update se lo studente vuole fare na modifica
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(321, 336, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CONSEGNA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> domandeaperte = r.RicavoDomandaA(nometest, contoaperte);
				String nomeprof = r.NomeProf(nometest);
				r.Rispostaaperta(st.getLogin(), nomeprof, domandeaperte, aperte, contoaperte);
				ArrayList<String> domandemultiple = r.RicavoDomandeM(nometest, contomultiple);
				r.Rispostamultipla(st.getLogin(), domandemultiple, multiple, contomultiple);
				
				JFrame frameDaChiamare = new HomeStudente(null, st, r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(520, 336, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
		//cosa mi manca: 
		//1) fare la funzione di traduzione creando un array di lettere dell'alfabeto
		//2) salvare tutti i dati nel db
		//mi devo salvare il numero e poi con la hash-table lo traduco in carattere
		
		
	}
}
