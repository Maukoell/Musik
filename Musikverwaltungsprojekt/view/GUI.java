package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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
import datenbankObjekte.Interpret;
import datenbankObjekte.Song;
import listener.CDDeleteListener;
import listener.NewCDListener;
import listener.NewSongListener;
import listener.SongDeleteListener;

public class GUI extends JFrame {

	/**
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTree tree;
	private ArrayList<CD> cdList = new ArrayList<>();
	private ArrayList<Interpret> interpretList = new ArrayList<>();
	private ArrayList<Song> songList = new ArrayList<>();
	

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
	 */
	@SuppressWarnings("serial")
	public GUI() {
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
		
		JButton button3 = new JButton("CD Entfernen");
		button3.addActionListener(new CDDeleteListener(this));
		panel_1.add(button3);
		
		JButton button4 = new JButton("Song Entfernen");
		button4.addActionListener(new SongDeleteListener(this));
		panel_1.add(button4);
		
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		tree = new JTree();
		tree.setRootVisible(false);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("CDs") {
				{
				}
			}
		));
		scrollPane.setViewportView(tree);
		
		JButton btnMehrInformation = new JButton("Mehr Information");
		contentPane.add(btnMehrInformation, BorderLayout.SOUTH);
	}

	@SuppressWarnings("unused")
	private TreePath find(DefaultMutableTreeNode root, String s) {
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

	
	
}
