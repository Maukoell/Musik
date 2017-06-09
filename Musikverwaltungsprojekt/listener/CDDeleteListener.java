package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import view.GUI;

public class CDDeleteListener implements ActionListener{

private GUI g;
	
	public CDDeleteListener(GUI g) {
		this.g = g;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = g.getTree();
		DefaultTreeModel dtm = (DefaultTreeModel) tree.getModel();
		TreePath tp = tree.getSelectionPath();
		
		DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.getLastPathComponent();
		dtm.removeNodeFromParent(dmtn);
	}
	
}
