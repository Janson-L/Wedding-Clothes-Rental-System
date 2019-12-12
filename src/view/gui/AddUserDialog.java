package view.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.validator.InvalidNumberException;
import controller.validator.MaximumLengthException;
import controller.validator.MaximumNumberException;
import controller.validator.MinimumNumberException;
import controller.validator.RequiredFieldException;
import controller.validator.Validator;

public class AddUserDialog extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JTextField txtName= new JTextField();
	private JTextField txtPhoneNo = new JTextField();
	private JTextField txtIC = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtClass = new JTextField();
	private JButton btnSubmit=new JButton("Submit");
	private JButton btnReset=new JButton("Reset");
	
	
	public AddUserDialog (ManageUserDialog dialog)
	{
		super(dialog, "Add User",true);
		
		JPanel pnlCenter=new JPanel(new GridLayout(3,2,10,10));
		JPanel pnlSouth=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		pnlCenter.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
		pnlSouth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		pnlCenter.add(new JLabel("Name:", JLabel.RIGHT));
		pnlCenter.add(txtName);
		pnlCenter.add(new JLabel("Phone Number :", JLabel.RIGHT));
		pnlCenter.add(txtPhoneNo);
		pnlCenter.add(new JLabel("IC Number:", JLabel.RIGHT));
		pnlCenter.add(txtIC);
		pnlCenter.add(new JLabel("Email:", JLabel.RIGHT));
		pnlCenter.add(txtEmail);
		pnlCenter.add(new JLabel("Class:", JLabel.RIGHT));
		pnlCenter.add(txtClass);
		
		pnlSouth.add(btnSubmit);
		pnlSouth.add(btnReset);
		
		btnSubmit.addActionListener(this);
		btnReset.addActionListener(this);
		
		this.add(pnlCenter);
		this.add(pnlSouth, BorderLayout.SOUTH);
		
		this.getRootPane().setDefaultButton(btnSubmit);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(dialog);
		this.setVisible(true);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		Object source = event.getSource();
		if(source==btnSubmit)
		{
		reset();
			
			
		}
		
		else if(source==btnReset)
		{
			reset();
		}
	}
	
	private void reset()
	{
		txtName.setText("");
		txtPhoneNo.setText("");
		txtIC.setText("");
		txtEmail.setText("");
		txtClass.setText("");
	}
	
}
