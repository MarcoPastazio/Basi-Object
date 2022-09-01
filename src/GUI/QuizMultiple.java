package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import GUI.HomeStudente;

import model.Studente;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.List;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class QuizMultiple extends JFrame {

	private JPanel contentPane;
	public JFrame frame;
	
	/**
	 * Crea il frame per lo svolgimento dei quiz a risposta multipla.
	 * @param framechiamante è il frame da cui viene chiamato
         * @param r è l'oggetto che fa da intermediaro tra i vari package coinvolti
     	 * @param aperte sono le risposte aperte
     	 * @param multiple sono le risposte multiple
     	 * @param st lo studente che sta usando l'applicazione
     	 * @param nometest il nome del test selezionato dallo studente
     	 * @param contoaperte è il numero di domande a risposta aperta
     	 * @param contomultiple è il numero di domande a risposta multipla
     	 * @param indice a che numero di domanda siamo
	 */

	public QuizMultiple(JFrame framechiamante, Controller r, String[] aperte, String[] multiple, Studente st, String nometest, int contoaperte, int contomultiple, int indice) {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 693);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 35));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 15));
		
		JLabel lblNewLabel = new JLabel("CARMA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(nometest);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.window);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setVgap(35);
		flowLayout.setHgap(60);
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		String nome = r.RicavoNomeM(nometest, contomultiple, indice);
		JLabel lblNewLabel_2 = new JLabel(nome);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.window);
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		flowLayout_1.setVgap(35);
		flowLayout_1.setHgap(60);
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		
		String domanda = r.RicavoDomandaM(nometest, contomultiple, indice);
		System.out.print("\n\n\n"+domanda+"\n\n\n");
		String[] split = new String[26];
		if(domanda.contains(":")) {
			split=domanda.split(":");
			split[0] = split[0]+":"; 
		}else {
			split=domanda.split("\\?");
			split[0] = split[0]+"?"; 
		}
		String[] split1 = split[1].split("@");
		
		String[] alfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		JLabel lblNewLabel_3 = new JLabel(split[0]);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.window);
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEADING);
		flowLayout_2.setVgap(35);
		flowLayout_2.setHgap(60);
		panel_4.add(panel_6, BorderLayout.SOUTH);
		
		String descrizione = r.RicavoDescrizioneM(nometest, contomultiple, indice);
		JLabel lblNewLabel_4 = new JLabel(descrizione);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		DefaultListModel demoList = new DefaultListModel();
		for(int i = 0; i<split1.length;i++) {
			demoList.addElement(split1[i]);
		}
		list.setModel(demoList);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setHgap(150);
		panel_7.setBackground(SystemColor.window);
		contentPane.add(panel_7, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("INDIETRO");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AVANTI");
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		panel_7.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CONSEGNA");
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(aperte!=null) {
					ArrayList<String> domandeaperte = r.RicavoDomandaA(nometest, contoaperte);//
					String nomeprof = r.NomeProf(nometest);//
					r.Rispostaaperta(st.getLogin(), nomeprof, domandeaperte, aperte, contoaperte);//
				}
				ArrayList<String> domandemultiple = r.RicavoDomandeM(nometest, contomultiple);
				r.Rispostamultipla(st.getLogin(), domandemultiple, multiple, contomultiple);
				r.TerminatoTrue(nometest,st);
				r.InserisciTest(nometest,st);
				if(aperte==null) {
					r.setCorretto(nometest,st);
				}
				JFrame frameDaChiamare = new HomeStudente(st, r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel_7.add(btnNewButton_2);
	}

}
