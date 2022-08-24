package GUI;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import GUI.Conferma;
import GUI.Registrazione;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.border.BevelBorder;
import Controller.Controller;

public class Benvenuto extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

	/**
	 * Create the frame.
	 */
	public Benvenuto(Controller r) {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 549);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 10));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 8));
		
		JLabel lblNewLabel = new JLabel("BENVENUTO IN CARMA");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBackground(SystemColor.window);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("sei registrato?");
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(SystemColor.info);
		panel.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(SystemColor.window);
		/*panel_2.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				panel_2.setPreferredSize(getPreferredSize());
			}
		});*/
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 180, 150));
		
		JButton btnNewButton_1 = new JButton("NO");
		btnNewButton_1.setForeground(SystemColor.desktop);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameDaChiamare = new Registrazione(frame, r);
				frameDaChiamare.setVisible(true);
				frame.setVisible(false);

			}
		});
		
		JButton btnNewButton = new JButton("SI");
		panel_2.add(btnNewButton);
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setBackground(SystemColor.activeCaption);
		
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						JFrame frameDaChiamare = new Conferma(r);
						frameDaChiamare.setVisible(true);
						frame.setVisible(false);

					}
				});
		panel_2.add(btnNewButton_1);
	}
	
	

}
