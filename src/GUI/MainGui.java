

package GUI;

import java.awt.EventQueue;

import Controller.Controller;

public class MainGui{
	
	/**
	 * serve ad avviare l'applicazione e come prima schermata, lancerà quella di benvenuto
	 * @param args
	 */
	
	public static void main(String[] args) {
		Controller r = new Controller();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Benvenuto frame = new Benvenuto(r);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
