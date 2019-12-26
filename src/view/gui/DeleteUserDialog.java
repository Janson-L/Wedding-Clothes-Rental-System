package view.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.manager.WedClothManager;
import controller.validator.MaximumLengthException;
import controller.validator.RequiredFieldException;
import controller.validator.Validator;

public class DeleteUserDialog extends JDialog implements ActionListener 
{
	private JTextField txtID = new JTextField();
	private JButton btnDelete = new JButton("Delete");
	private JButton btnReset = new JButton("Reset");

	public DeleteUserDialog(ManageUserDialog dialog)
	{
		super(dialog, "Delete User", true);
		JPanel pnlCentre = new JPanel(new GridLayout(6,2,10,10));
		JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));//flow layout by default
	
		pnlCentre.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		pnlSouth.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
	
		
		pnlCentre.add(new JLabel("Please enter the User ID that you want to delete.", JLabel.CENTER));
		pnlCentre.add(new JLabel("User ID: ", JLabel.LEFT));
		pnlCentre.add(txtID);
		
		pnlSouth.add(btnDelete);
		pnlSouth.add(btnReset);
		
		
		this.add(pnlCentre);
		this.add(pnlSouth, BorderLayout.SOUTH);
		
		btnDelete.addActionListener(this);
		btnReset.addActionListener(this);
		
		this.getRootPane().setDefaultButton(btnDelete);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(dialog);
		this.setVisible(true);
		}

	public void actionPerformed(ActionEvent event) 
	{
		Object source = event.getSource();
		if(source == btnDelete)
		{
			Vector<Exception> exceptions = new Vector<>();
			int id;
			String x=null;
			
			try 
			{
				x=Validator.validate("User ID", txtID.getText(), true, 15);
			} 
			catch (RequiredFieldException | MaximumLengthException e) 
			{
				exceptions.add(e);
			}
			
			int size = exceptions.size();
			if(size == 0)
			{
				id = Integer.parseInt(x);
				try {
					if(WedClothManager.deleteUser(id)!=0)
					{
						JOptionPane.showMessageDialog(this, "User has been deleted." , "Success", JOptionPane.INFORMATION_MESSAGE);
						reset();
					}
					else
						JOptionPane.showMessageDialog(this, "Unable to delete user.","Unsuccessful",JOptionPane.WARNING_MESSAGE);
				}
				catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(this, e.getMessage(), "Database Error", JOptionPane.WARNING_MESSAGE);
				}
			}
			else
			{
				String message=null;
				if(size==1)
					message=exceptions.firstElement().getMessage();
				else
				{
					message="Please fix the following errors: ";
						
					for(int z=0;z<size;z++)
						message+="\n"+(z+1)+"."+exceptions.get(z).getMessage();
				}
					JOptionPane.showMessageDialog(this, message, "Validation Error", JOptionPane.WARNING_MESSAGE);
			}
			reset();
		}
		else if(source == btnReset)
		{
			reset();
		}	
	}
	private void reset()
	{
		txtID.setText("");

	}
	
}