package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class CDDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
		contentPanel.setLayout(new MigLayout("", "[259.00][263.00,grow]", "[99.00][99.00][99][]"));
		{
			JLabel lblTitel = new JLabel("Titel:");
			lblTitel.setFont(new Font("Tahoma", Font.BOLD, 15));
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
			textField_2 = new JTextField();
			textField_2.setColumns(20);
			contentPanel.add(textField_2, "cell 1 2,alignx center,aligny center");
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
