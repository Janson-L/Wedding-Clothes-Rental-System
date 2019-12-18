package view.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteUserDialog extends JDialog implements ActionListener 
{
	/*private static final long serialVersionUID = 1L;
	private JTextField txtUserName = new JTextField();
	private JTextField txtPhoneNo = new JTextField();
	private JTextField txtICNo = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JCheckBox chkAdmin = new JCheckBox("Admin");
	private JButton btnSubmit = new JButton("Submit");
	private JButton btnReset = new JButton("Reset");*/

	public DeleteUserDialog(ManageUserDialog dialog)
	{
		super(dialog, "Delete User", true);
		JPanel pnlCenter = new JPanel(new GridLayout(6,2,10,10));
		JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));//flow layout by default
	
		pnlCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		pnlSouth.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
	
		/*pnlCenter.add(new JLabel("User Name: ", JLabel.RIGHT));
		pnlCenter.add(txtUserName);
		pnlCenter.add(new JLabel("Phone Number: ", JLabel.RIGHT));
		pnlCenter.add(txtPhoneNo);
		pnlCenter.add(new JLabel("IC Number: ", JLabel.RIGHT));
		pnlCenter.add(txtICNo);
		pnlCenter.add(new JLabel("E-mail: ", JLabel.RIGHT));
		pnlCenter.add(txtEmail);
		pnlCenter.add(new JLabel("User class: ", JLabel.RIGHT));
		pnlCenter.add(chkAdmin);
	
		pnlSouth.add(btnSubmit);
		pnlSouth.add(btnReset);
	
		this.add(pnlCenter);
		this.add(pnlSouth,BorderLayout.SOUTH);
	
		btnSubmit.addActionListener(this);
		btnReset.addActionListener(this);
	
		this.getRootPane().setDefaultButton(btnSubmit);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(dialog);
		this.setVisible(true);*/
	}

@Override
	public void actionPerformed(ActionEvent event) 
	{
		/*Object source = event.getSource();
	
		if(source == btnSubmit)
		{
			
		}
	
		else if(source==btnReset)
		{
			txtUserName.setText("");
			txtPhoneNo.setText("");
			txtICNo.setText("");
			txtEmail.setText("");
			chkAdmin.setSelected(false);
			txtUserName.grabFocus();
		}*/
	}
}