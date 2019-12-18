package view.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageUserDialog extends JDialog implements ActionListener 
{

	private static final long serialVersionUID = 1L;
	private JButton btnAddUser = new JButton("Add User");
	private JButton btnDeleteUser = new JButton("Delete User");

	public ManageUserDialog(MainFrame dialog) 
	{
		super(dialog, "Manage User", true);
		
		GridLayout layout = new GridLayout(2,1);
		
		btnAddUser.addActionListener(this);
		btnDeleteUser.addActionListener(this);
		
		this.add(btnAddUser);
		this.add(btnDeleteUser);
		
		this.setSize(300,200);
		this.setLayout(layout);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Object source=event.getSource();
		if(source==btnAddUser)
			new AddUserDialog(this);
		else if(source==btnDeleteUser)
			new DeleteUserDialog(this);
	}
}
