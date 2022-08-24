package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import model.Studente;
import java.awt.SystemColor;

public class ScegliTest extends JFrame {

	private static final int N_ROWS = 2;
    private DefaultTableModel dtm ;
    private JTable table ;
    private JScrollPane scrollPane ;
    private JScrollBar vScroll ;
    private int row;
    private boolean isAutoScroll;
    private JTextField textField;
    private JFrame frame;
	/**
	 * Crea il frame per far selezionare allo studente il test che vuole mettere nella "lista di attesa".
	 * @param frameChiamante è il frame da cui viene chiamato
	 * @param r è l'oggetto che fa da intermediaro tra i vari package coinvolti
	 * @param s lo studente che sta usando l'applicazione
	 */
	public ScegliTest(JFrame frameChiamante,Controller r,Studente s) {
		this.frame=this;
		setBounds(100, 100, 735, 560);
		getContentPane().setLayout(new BorderLayout());
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	
    	this.table=new JTable(r.buildTableModel(4,s,null));
    	
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
        
        JLabel lblNewLabel = new JLabel("Scrivi il nome del test scelto");
        panel.add(lblNewLabel);
        
        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("SALVA");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		r.salvaScelta(textField.getText(),s);
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


