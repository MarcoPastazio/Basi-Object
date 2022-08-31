//ok
package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Controller.Controller;
import model.Studente;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class SvolgiTestScelto extends JFrame {

	private JFrame frame;
	private static final int N_ROWS = 2;//modificato
    //private static String[] header = {"Nome", "Corso", "Pubblicazione", "Durata","Insegnante"};
    private DefaultTableModel dtm ;
    private JTable table ;
    private JScrollPane scrollPane ;
    private JScrollBar vScroll ;
    private int row;
    private boolean isAutoScroll;
    private JTextField textField;

	/**
	 * serve a far svolgere il test scelto dallo studente
	 * @param frameChiamante è il frame da cui viene chiamato
         * @param r è l'oggetto che fa da intermediaro tra i vari package coinvolti
         * @param s lo studente che sta usando l'applicazione
	 */
    public SvolgiTestScelto(JFrame frameChiamante,Controller r, Studente s) {
    	this.frame=this;
    	setBounds(100, 100, 735, 560);
    	getContentPane().setLayout(new BorderLayout());
    	//setDefaultCloseOperation(JPanel);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
	
    	this.table=new JTable(r.buildTableModel(3,s,null));
    	
    	this.scrollPane=new JScrollPane(this.table);
    	this.vScroll=this.scrollPane.getVerticalScrollBar();
    	Dimension d = new Dimension(320, N_ROWS * table.getRowHeight());
    	table.setPreferredScrollableViewportSize(d);
    	
    	scrollPane.setVerticalScrollBarPolicy(
    			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	vScroll.addAdjustmentListener(new AdjustmentListener() {

    		@Override
    		public void adjustmentValueChanged(AdjustmentEvent e) {
    			isAutoScroll = !e.getValueIsAdjusting();
    		}
    	});
    	getContentPane().add(scrollPane, BorderLayout.CENTER);
    
    	JPanel panel = new JPanel();
    	panel.setBackground(SystemColor.activeCaption);
    	getContentPane().add(panel, BorderLayout.SOUTH);
    
    	JLabel lblNewLabel = new JLabel("Scrivi il nome del test che vuoi svolgere");
    	panel.add(lblNewLabel);
    
    	textField = new JTextField();
    	panel.add(textField);
    	textField.setColumns(10);
    
    	JButton btnNewButton = new JButton("START");
    	btnNewButton.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			String nomeTest=textField.getText();
        		int nAperte=r.ConteggioDomande(nomeTest);
        		int nMultiple=r.ConteggioDomandeM(nomeTest);
        		JFrame frameDaChiamare;
        		if(nAperte>0) {
        			 frameDaChiamare = new QuizAperte(frame, r, nAperte, nMultiple, s,new String[nAperte] , new String[nMultiple],0,textField.getText());
        		}else {
        			 frameDaChiamare= new QuizMultiple(frame,r,null,new String[nMultiple],s,textField.getText(),0,nMultiple,0);/*JFrame framechiamante, Controller r, String[] aperte, String[] multiple, Studente st, String nometest, int contoaperte, int contomultiple, int indice)*/
        		}
        		frameDaChiamare.setVisible(true);
				frame.setVisible(false);
    		}
    	});
    	panel.add(btnNewButton);
    
    	JMenuBar menuBar = new JMenuBar();
    	menuBar.setBackground(SystemColor.activeCaption);
    	getContentPane().add(menuBar, BorderLayout.NORTH);
    
    	JMenu mnNewMenu = new JMenu("Menu");
    	menuBar.add(mnNewMenu);
    
    	JButton btnNewButton_1 = new JButton("Torna indietro");
    	btnNewButton_1.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			frame.setVisible(false);
    			frameChiamante.setVisible(true);
    			frame.dispose();
    		}
    	});
    	mnNewMenu.add(btnNewButton_1);
    
    	JButton btnNewButton_2 = new JButton("Esci");
    	btnNewButton_2.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			System.exit(1);
    		}
    	});
    	mnNewMenu.add(btnNewButton_2);
   
}
}

