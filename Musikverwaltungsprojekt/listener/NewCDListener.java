package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import view.*;

/**
 * Diese Klasse dient zum Öffnen der CDDialog Klasse.
 * 
 * @author Mauricio Köll & Johannes Lindner
 * @version 1.0
 *  */

public class NewCDListener implements ActionListener {
	private GUI g;
	
	public NewCDListener(GUI g) {
		this.g = g;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			CDDialog dialog = new CDDialog(g);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
