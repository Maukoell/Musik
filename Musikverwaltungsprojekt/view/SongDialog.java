package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import datenbankObjekte.CD;
import datenbankObjekte.DBManager;
import datenbankObjekte.Interpret;
import datenbankObjekte.Song;
import net.miginfocom.swing.MigLayout;

public class SongDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tf_name;
	private JTextField tf_dauer;
	private GUI g;
	private ArrayList<CD> cdList = g.getCdList();
	private ArrayList<Song> songList = g.getSongList();
	private JTree tree;
	private JComboBox<String> comboBox;
	private JTextField tf_iVorname;
	private JTextField tf_iNachname;
	private CD cd;
	private DBManager dbm;

	/**
	 * Create the dialog.
	 */
	public SongDialog(GUI g) {
		this.g = g;
		dbm = g.getDbm();
		tree = g.getTree();
		setBounds(100, 100, 476, 289);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[259.00][263.00,grow]", "[99.00][99.00][112.00][][][]"));
		{
			JLabel lblTitel = new JLabel("Name:");
			lblTitel.setFont(new Font("Tahoma", Font.BOLD, 15));
			contentPanel.add(lblTitel, "cell 0 0,grow");
			contentPanel.add(lblTitel, "cell 0 0,alignx center,aligny center");
		}
		{  
			tf_name = new JTextField();
			contentPanel.add(tf_name, "cell 1 0");
			tf_name.setColumns(20);
		}
		{
			JLabel lblVerlag = new JLabel("Dauer:");
			lblVerlag.setFont(new Font("Tahoma", Font.BOLD, 15));
			contentPanel.add(lblVerlag, "cell 0 1,alignx center,aligny center");
		}
		{
			tf_dauer = new JTextField();
			tf_dauer.setColumns(20);
			contentPanel.add(tf_dauer, "cell 1 1");
		}
		{
			JLabel lblErscheinungsdatum = new JLabel("CD:");
			lblErscheinungsdatum.setFont(new Font("Tahoma", Font.BOLD, 15));
			contentPanel.add(lblErscheinungsdatum, "cell 0 2,alignx center,aligny center");
		}
		{
			ArrayList<CD> cdList = g.getCdList();
			ArrayList<String> ls = new ArrayList<>();
			
			for (int i = 0; i < cdList.size(); i++) {
				CD cd = cdList.get(i);
				String cds = cd.getName();
				ls.add(cds);
			}
			String[] s = null;
			s = ls.toArray(new String[0]); 
			
	//		comboBox = new JComboBox<String>(s);
			contentPanel.add(comboBox, "cell 1 2,growx");
		}
		{
			JLabel lblInterpret = new JLabel("Interpret Vorname");
			lblInterpret.setFont(new Font("Tahoma", Font.BOLD, 15));
			contentPanel.add(lblInterpret, "cell 0 3,alignx center,aligny center");
		}
		{
			tf_iVorname = new JTextField();
			contentPanel.add(tf_iVorname, "cell 1 3");
			tf_iVorname.setColumns(20);
		}
		{
			JLabel lblInterpretNachname = new JLabel("Interpret Nachname:");
			lblInterpretNachname.setFont(new Font("Tahoma", Font.BOLD, 15));
			contentPanel.add(lblInterpretNachname, "cell 0 4,alignx center,aligny center");
		}
		{
			tf_iNachname = new JTextField();
			contentPanel.add(tf_iNachname, "cell 1 4,growx");
			tf_iNachname.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Hinzufügen");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String s = (String) comboBox.getSelectedItem();
						TreePath tp = g.find((DefaultMutableTreeNode) tree.getModel().getRoot(), s);
						DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.getLastPathComponent();
						DefaultTreeModel tm = (DefaultTreeModel) tree.getModel();
						DefaultMutableTreeNode dmtn1 = new DefaultMutableTreeNode(tf_name.getText());
						dmtn.setAllowsChildren(true);
						tm.insertNodeInto(dmtn1, dmtn, 0);
						for (int i = 0; i < cdList.size(); i++) {
							CD c = cdList.get(i);
							if (c.getName() == s) {
								cd = c;
							}
						}
						Interpret i = new Interpret(tf_iNachname.getText(), tf_iVorname.getText());
						Song s1 = new Song(tf_name.getText(), Double.parseDouble(tf_name.getText()), i, cd);
						try {
							dbm.insertSong(dbm.getConnection(), s1);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						songList.add(s1);
						dispose();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Abbrechen");
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
