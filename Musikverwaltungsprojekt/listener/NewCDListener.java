package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import view.CDDialog;
import view.GUI;

public class NewCDListener implements ActionListener {
	private GUI g;
	
	public NewCDListener(GUI g) {
		this.g = g;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// Kommentar 2
			CDDialog dialog = new CDDialog(g);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
