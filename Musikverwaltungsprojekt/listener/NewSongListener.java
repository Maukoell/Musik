package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import view.GUI;
import view.SongDialog;

public class NewSongListener implements ActionListener {
	
	private GUI g;
	
	public NewSongListener(GUI g) {
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			SongDialog dialog = new SongDialog(g);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
