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
//import model.Studente;

public class ConsultaTest extends JFrame {
	
	private static final int N_ROWS = 2;//modificato
    //private static String[] header = {"Nome", "Corso", "Pubblicazione", "Durata","Insegnante"};
    private DefaultTableModel dtm ;
    private JTable table ;
    private JScrollPane scrollPane ;
    private JScrollBar vScroll ;
    private int row;
    private JFrame frame;
    private boolean isAutoScroll;

    public ConsultaTest(JFrame frameChiamante, Studente st,Controller r) {
    	this.frame=this;
    	setBounds(100, 100, 735, 560);
    	getContentPane().setLayout(new BorderLayout());
    	//setDefaultCloseOperation(JPanel);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	//System.out.print("\n\n\n\nMAMAMAMAMAMAMAAMAMAMAMA\n"+t+"\n\n\n\n");
    	
    	//this.dtm=t;
    	//System.out.print("\ncicciolina\n"+t+" mammt a percr\n "+t==null+"\n\n\n");
    	
    	this.table=new JTable(r.buildTableModel(2,st,null));
    	/*table.addAncestorListener(new AncestorListener() {
    		public void ancestorAdded(AncestorEvent event) {
    			table.setVisible(true);
    		}
    		public void ancestorMoved(AncestorEvent event) {}
    		public void ancestorRemoved(AncestorEvent event) {
    			table.setVisible(false);
    		}
    	});*/
    	//System.out.print(table);
    	this.scrollPane=new JScrollPane(this.table);
    	this.vScroll=this.scrollPane.getVerticalScrollBar();
        //this.setLayout(new BorderLayout());
        Dimension d = new Dimension(320, N_ROWS * table.getRowHeight());
        table.setPreferredScrollableViewportSize(d);
        /*for (int i = 0; i < N_ROWS; i++) {
        	System.out.println("\n\n\n\na soreta\n\n\n\n");
            addRow();
        }*/
        scrollPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        vScroll.addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                isAutoScroll = !e.getValueIsAdjusting();
            }
        });
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        JMenuBar menuBar = new JMenuBar();
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
        /*JPanel panel = new JPanel();
        panel.add(new JButton(new AbstractAction("Add Row") {

            @Override
            public void actionPerformed(ActionEvent e) {
                addRow();//jooo
            }
        }));
        this.add(panel, BorderLayout.SOUTH);*///baam
    }
}

    /*private void addRow() {//baam
        char c = (char) ('A' + row++ % 26);
        System.out.println("\n\ncess e mammt\n"+dtm+"\n\n");
        dtm.addRow(new Object[]{
                Character.valueOf(c),
                String.valueOf(c) + String.valueOf(row),
                Integer.valueOf(row),
                Boolean.valueOf(row % 2 == 0)
            });
    }*/

   