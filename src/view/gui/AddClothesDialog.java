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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.manager.WedClothManager;
import controller.validator.InvalidNumberException;
import controller.validator.MaximumLengthException;
import controller.validator.MaximumNumberException;
import controller.validator.MinimumNumberException;
import controller.validator.RequiredFieldException;
import controller.validator.Validator;

public class AddClothesDialog extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JTextField txtClothesColor= new JTextField();
	private JTextField txtClothesType = new JTextField();
	private JTextField txtRent = new JTextField();
	private JButton btnSubmit=new JButton("Submit");
	private JButton btnReset=new JButton("Reset");
	
	
	public AddClothesDialog (ManageWedClothDialog dialog)
	{
		super(dialog, "Add Clothes",true);
		
		JPanel pnlCenter=new JPanel(new GridLayout(3,2,10,10));
		JPanel pnlSouth=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		pnlCenter.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
		pnlSouth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		pnlCenter.add(new JLabel("Clothes Color:", JLabel.RIGHT));
		pnlCenter.add(txtClothesColor);
		pnlCenter.add(new JLabel("ClothesType:", JLabel.RIGHT));
		pnlCenter.add(txtClothesType);
		pnlCenter.add(new JLabel("Rent(RM):", JLabel.RIGHT));
		pnlCenter.add(txtRent);
		
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
		if (source==btnSubmit)
		{
			Vector<Exception> exceptions =new Vector<>();
			String clothesColor=null, clothesType=null;
			double rent=0;
			
			
			try {
				clothesColor=Validator.validate("Clothes Color", txtClothesColor.getText(), true, 15);
			}
			catch (RequiredFieldException | MaximumLengthException e) {
				// TODO Auto-generated catch block
				exceptions.add(e);
			}
			
			try {
				clothesType=Validator.validate("Clothes Type", txtClothesType.getText(), true,50);
			} 
			catch (RequiredFieldException | MaximumLengthException e) {
				// TODO Auto-generated catch block
				exceptions.add(e);
			}
			
			try {
				rent=Validator.validate("Rent", txtRent.getText(), true, true, true, 5, 20);
			} 
			catch (RequiredFieldException | MaximumLengthException | InvalidNumberException | MinimumNumberException
					| MaximumNumberException e) {
				exceptions.add(e);
			}
			
			
			
			
			int size=exceptions.size();
			if(size==0) 
			{
				try 
				{
					if(WedClothManager.addWedCloth()!=-1)
					{
						reset();
						JOptionPane.showMessageDialog(this,"Clothes successfully added","Success",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Unable to add clothes.","Unsuccessful", JOptionPane.WARNING_MESSAGE);
					}
				}
				
				catch (ClassNotFoundException | SQLException e)
				{
					JOptionPane.showMessageDialog(this,e.getMessage(),"Database Error",JOptionPane.WARNING_MESSAGE);
				}
			}
			
			else 
			{
				String message=null;
			
			if(size==1) 
			{
				message=exceptions.firstElement().getMessage();
			}
			
			else 
			{
				message="Please fix the following errors:";
				for (int i=0;i<size;i++) 
				{
					message+="\n" + (i+1) +". " +exceptions.get(i).getMessage();
				}
			}
			
			JOptionPane.showMessageDialog(this,message,"Validation Error",JOptionPane.WARNING_MESSAGE);
		
			
		    }}
		
		else if(source==btnReset)
		{
			reset();
		}
	}
	
	private void reset()
	{
		txtClothesColor.setText("");
		txtClothesType.setText("");
		txtRent.setText("");
	}
	
}
