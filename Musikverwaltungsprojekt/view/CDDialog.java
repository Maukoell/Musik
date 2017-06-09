package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import datenbankObjekte.CD;
import net.miginfocom.swing.MigLayout;

public class CDDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtDdmmyyyy;
	private GUI g;

	/**
	 * Create the dialog.
	 */
	public CDDialog(GUI g) {
		this.g = g;
		setBounds(100, 100, 476, 233);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[259.00][263.00]", "[99.00][99.00][112.00]"));
		contentPanel.setLayout(new MigLayout("", "[1px]", "[1px]"));
		contentPanel.setLayout(new MigLayout("", "[259.00][263.00,grow]", "[99.00][99.00][99][]"));
		{
			JLabel lblTitel = new JLabel("Titel:");
			lblTitel.setFont(new Font("Tahoma", Font.BOLD, 15));
			contentPanel.add(lblTitel, "cell 0 0,grow");
			contentPanel.add(lblTitel, "cell 0 0,alignx center,aligny center");
		}
		{
			textField = new JTextField();
			contentPanel.add(textField, "cell 1 0,alignx center,aligny center");
			textField.setColumns(20);
		}
		{
			JLabel lblVerlag = new JLabel("Verlag:");
			lblVerlag.setFont(new Font("Tahoma", Font.BOLD, 15));
			contentPanel.add(lblVerlag, "cell 0 1,alignx center,aligny center");
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(20);
			contentPanel.add(textField_1, "cell 1 1,alignx center,aligny center");
		}
		{
			JLabel lblErscheinungsdatum = new JLabel("Erscheinungsdatum:");
			lblErscheinungsdatum.setFont(new Font("Tahoma", Font.BOLD, 15));
			contentPanel.add(lblErscheinungsdatum, "cell 0 2,alignx center,aligny center");
		}
		{
			txtDdmmyyyy = new JTextField();
			txtDdmmyyyy.setText("dd.mm.yyyy");
			txtDdmmyyyy.setColumns(20);
			contentPanel.add(txtDdmmyyyy, "cell 1 2,alignx center,aligny center");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
						Date d = null;
						try {
							d = (Date) format.parse(txtDdmmyyyy.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						CD c = new CD(textField.getText(), textField_1.getText(), d );
						ArrayList<CD> cdList = g.getCdList();
						cdList.add(c);
						
						String[] s = new String[cdList.size()];
						for (int i = 0; i < cdList.size(); i++) {
							s[i] = cdList.get(i).getName();
						}
						JTree tree = new JTree(s);
						JTree tree1 = g.getTree();
						tree1.setModel(tree.getModel());
						dispose();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
