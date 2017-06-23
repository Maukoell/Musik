package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import datenbankObjekte.CD;
import datenbankObjekte.DBManager;
import datenbankObjekte.Interpret;
import datenbankObjekte.Song;
import listener.DeleteListener;
import listener.NewCDListener;
import listener.NewSongListener;

/**
 * Dies ist die Hauptklasse des Programms und gleichzeitig die GUI des
 * Programms.
 * 
 * @author Mauricio K�ll & Johannes Lindner
 * @version 1.0
 */

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTree tree;
	private ArrayList<CD> cdList = new ArrayList<>();
	private ArrayList<Interpret> interpretList = new ArrayList<>();
	private ArrayList<Song> songList = new ArrayList<>();
	private DBManager dbm = new DBManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings("serial")
	public GUI() throws SQLException {
		update();
		Dimension d = new Dimension(793, 478);
		setMinimumSize(d);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.NORTH);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel.setLayout(fl_panel);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		JButton button1 = new JButton("CD Hinzuf\u00FCgen");
		button1.addActionListener(new NewCDListener(this));
		panel_2.add(button1);

		JButton button2 = new JButton("Song Hinzuf\u00FCgen");
		button2.addActionListener(new NewSongListener(this));
		panel_2.add(button2);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JButton button4 = new JButton("Eintrag entfernen");
		button4.addActionListener(new DeleteListener(this));
		panel_1.add(button4);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		tree = new JTree();
		tree.setRootVisible(false);
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("CDs") {
			{
			}
		}));
		scrollPane.setViewportView(tree);

		JButton btnMehrInformation = new JButton("Mehr Information");
		contentPane.add(btnMehrInformation, BorderLayout.SOUTH);
	}
/**
 * Diese Methode wird beim Starten des Programms ausgef�hrt und soll alle Objekte aus der Datenbank auslesen.
 * @throws SQLException 
 */
	public void update() throws SQLException {
		
		int count = dbm.getCountCD(dbm.getConnection());
		int[] ids = dbm.getCDIDs(dbm.getConnection());
		
		for (int i = ids.length; i < count; i++) {
			try {
				CD cd1 = dbm.getCDByID(dbm.getConnection(), ids[i]);
				cdList.add(cd1);
			} catch (SQLException e) {
			}
		}

		String[] s = new String[cdList.size()];
		for (int i = 0; i < cdList.size(); i++) {
			try {
				s[i] = cdList.get(i).getName();
			} catch (NullPointerException ex) {
			}
		}
		tree = new JTree(s);

	}
/**
 * 	Diese Methode dient zum Suchen von einer bestimten TreeNode durch den Namen der Node
 * @param root Root in der gesucht werden soll
 * @param s Name der gesuchten TreeNode
 * @return Die gesuchte Tree Node
 */
	public TreePath find(DefaultMutableTreeNode root, String s) {
		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> e = root.depthFirstEnumeration();
		while (e.hasMoreElements()) {
			DefaultMutableTreeNode node = e.nextElement();
			if (node.toString().equalsIgnoreCase(s)) {
				return new TreePath(node.getPath());
			}
		}
		return null;
	}

	/**
	 * @return the tree
	 */
	public JTree getTree() {
		return tree;
	}

	/**
	 * @return the cdList
	 */
	public ArrayList<CD> getCdList() {
		return cdList;
	}

	/**
	 * @return the interpretList
	 */
	public ArrayList<Interpret> getInterpretList() {
		return interpretList;
	}

	/**
	 * @return the song
	 */
	public ArrayList<Song> getSongList() {
		return songList;
	}

	/**
	 * 
	 * @return the dbm
	 */
	
	public DBManager getDbm() {
		return dbm;
	}

}
