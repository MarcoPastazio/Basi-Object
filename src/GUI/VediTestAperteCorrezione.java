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
import model.Insegnante;
import java.awt.FlowLayout;

public class VediTestAperteCorrezione extends JFrame {


	private static final int N_ROWS = 2;//modificato
    //private static String[] header = {"Nome", "Corso", "Pubblicazione", "Durata","Insegnante"};
    private DefaultTableModel dtm ;
    private JTable table ;
    private JScrollPane scrollPane ;
    private JScrollBar vScroll ;
    private int row;
    private boolean isAutoScroll;
    private JTextField textField;
    private JFrame frame;
    private JTextField textField_1;


	/**
	 * Create the frame.
	 */
	public VediTestAperteCorrezione(JFrame framechiamante, Insegnante ins , Controller r) {
		frame=this;
		setBounds(100, 100, 735, 560);
		getContentPane().setLayout(new BorderLayout());
    	//setDefaultCloseOperation(JPanel);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	//System.out.print("\n\n\n\nMAMAMAMAMAMAMAAMAMAMAMA\n"+t+"\n\n\n\n");
    	
    	//this.dtm=t;
    	//System.out.print("\ncicciolina\n"+t+" mammt a percr\n "+t==null+"\n\n\n");
    	
    	this.table=new JTable(r.buildTableModel(5,null,ins));
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
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblNewLabel = new JLabel("Scrivi il nome del test da correggere");
        panel.add(lblNewLabel);
        
        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("START");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String test=textField.getText();
        		float voti[]=new float[r.ConteggioDomande(test)];
        		String studente= textField_1.getText();
        		if(test!=null && studente!= null && r.CheckTestStudente(test,studente)) {
        			JFrame frameDaChiamare= new CorrezioneQuiz(frame,r,test,studente,0,voti,ins );//JFrame framechiamante, Controller r, String nometest, String nomestudente, int indice, float[] voti, Insegnante ins
        			frameDaChiamare.setVisible(true);
        			frame.setVisible(false);
        			frame.dispose();
        		}
        		
        	}
        });
        
        JLabel lblNewLabel_1 = new JLabel("Scrivi il login dello studente");
        panel.add(lblNewLabel_1);
        
        textField_1 = new JTextField();
        panel.add(textField_1);
        textField_1.setColumns(10);
        panel.add(btnNewButton);
        
        JMenuBar menuBar = new JMenuBar();
        getContentPane().add(menuBar, BorderLayout.NORTH);
        
        JMenu mnNewMenu = new JMenu("Menu");
        menuBar.add(mnNewMenu);
        
        JButton btnNewButton_1 = new JButton("Torna indietro");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		framechiamante.setVisible(true);
        		frame.setVisible(false);
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
