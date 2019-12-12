package view.gui;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ManageUserDialog extends JDialog implements ActionListener

{
	private static final long serialVersionUID=1L;
	
	private JButton btnAddUser=new JButton("Add User");
	private JButton btnUpdateUser=new JButton("Update User");
	private JButton btnDeleteUser=new JButton("Delete User");
	private JButton btnViewAllUser=new JButton("View All User");
	
	
	public ManageUserDialog(MainFrame frame)
	{
		GridLayout layout = new GridLayout(8,1,10,10);
		
		this.add(btnAddUser);
		this.add(btnUpdateUser);
		this.add(btnDeleteUser);
		this.add(btnViewAllUser);
		
		
		btnAddUser.addActionListener(this);
		btnUpdateUser.addActionListener(this);
		btnDeleteUser.addActionListener(this);
		btnViewAllUser.addActionListener(this);
		
		
		this.setLayout(layout);
		this.pack();
		this.setSize(800,500);
		this.setLocationRelativeTo(frame);
		this.setVisible(true);
	}
	

	

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		Object source=event.getSource();
		
		if(source==btnAddUser) 
		{
			new AddUserDialog(this);
		}
		
		else if(source==btnUpdateUser) 
		{
			new UpdateUserDialog(this);
		}
		
		else if(source==btnDeleteUser) 
		{
			new DeleteUserDialog(this);
		}
		
		else if(source==btnViewAllUser) 
		{
			new ViewAllUserDialog(this);
		}
		
	}
}
	
