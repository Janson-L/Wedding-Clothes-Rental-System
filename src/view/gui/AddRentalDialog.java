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

//import controller.validator.InvalidNumberException;
import controller.validator.MaximumLengthException;
//import controller.validator.MaximumNumberException;
//import controller.validator.MinimumNumberException;
import controller.validator.RequiredFieldException;
import controller.validator.Validator;

import model.Model;

import controller.manager.WedClothManager;

public class AddRentalDialog extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JTextField txtRentDate = new JTextField();
	private JTextField txtClothesid = new JTextField();
	private JTextField txtDuration = new JTextField();
	//private JTextField txtTotal = new JTextField();
	private JTextField txtUid = new JTextField();
	private JButton btnSubmit=new JButton("Submit");
	private JButton btnReset=new JButton("Reset");
	
	
	public AddRentalDialog (ManageRentalsDialog dialog)
	{
		super(dialog, "Add Rental",true);
		
		JPanel pnlCenter=new JPanel(new GridLayout(4,2,10,10));
		JPanel pnlSouth=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		pnlCenter.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
		pnlSouth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		pnlCenter.add(new JLabel("Date: (Format->'Year-Month-Day'):", JLabel.RIGHT));
		pnlCenter.add(txtRentDate);
		pnlCenter.add(new JLabel("ClothesID:", JLabel.RIGHT));
		pnlCenter.add(txtClothesid);
		pnlCenter.add(new JLabel("Duration (Days):", JLabel.RIGHT));
		pnlCenter.add(txtDuration);
		//pnlCenter.add(new JLabel("Total(RM):", JLabel.RIGHT));
		//pnlCenter.add(txtTotal);
		pnlCenter.add(new JLabel("UserID: ",JLabel.RIGHT));
		pnlCenter.add(txtUid);
		
		
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
			String rentDate=null;
			String duration=null;
			//String total=null;
			int clothesID=0, uid=0;
			String z=null;
			
			try {
				rentDate=Validator.validate("Date", txtRentDate.getText(), true,50);
			} 
			catch (RequiredFieldException | MaximumLengthException e) {
				exceptions.add(e);
			}
			
			try {
				rentDate=Validator.validate("Date", txtRentDate.getText(), true,50);
			} 
			catch (RequiredFieldException | MaximumLengthException e) {
				exceptions.add(e);
			}
			
			try {
				try {
					duration = txtDuration.getText();
				double x = Double.valueOf(duration.trim()).doubleValue();
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Please enter a valid number in area 'Duration' .","Unsuccessful",JOptionPane.WARNING_MESSAGE);
				}
				double x = Double.valueOf(duration.trim()).doubleValue();
				x=Validator.validate1("Duration", txtDuration.getText(), true,20);
			} 
			catch (RequiredFieldException e) {
				exceptions.add(e);
			}
			
			/*
			 * try { try { total = txtTotal.getText(); double x =
			 * Double.valueOf(total.trim()).doubleValue(); } catch(NumberFormatException e)
			 * { JOptionPane.showMessageDialog(this,
			 * "Please enter a valid number in area 'Total' .","Unsuccessful",JOptionPane.
			 * WARNING_MESSAGE); } double x = Double.valueOf(total.trim()).doubleValue();
			 * x=Validator.validate1("Total", txtTotal.getText(), true,20); } catch
			 * (RequiredFieldException e) { exceptions.add(e); }
			 */
			
			try 
			{
				z=Validator.validate("User ID", txtUid.getText(), true, 15);
				uid= Integer.parseInt(z);
			} 
			catch (RequiredFieldException | MaximumLengthException e) 
			{
				exceptions.add(e);
			}
			
			try 
			{
				z=Validator.validate("Clothes ID", txtClothesid.getText(), true, 15);
				clothesID= Integer.parseInt(z);
			} 
			catch (RequiredFieldException | MaximumLengthException e) 
			{
				exceptions.add(e);
			}
			
			
			
			
			
			
			int size1 =exceptions.size();
			if(size1 == 0)
			{
				try 
				{
					int id = Model.getID("Rental");
					//double x = Double.valueOf(total.trim()).doubleValue();
					double y = Double.valueOf(duration.trim()).doubleValue();
					if(WedClothManager.addRental(id, rentDate, y,uid,clothesID)!=0)
					{
				
							JOptionPane.showMessageDialog(this, "Rental has been added" , "Success", JOptionPane.INFORMATION_MESSAGE);
	

						reset();
					}
					else
						JOptionPane.showMessageDialog(this, "Unable to add new rental","Unsuccessful",JOptionPane.WARNING_MESSAGE);
				}
				catch (ClassNotFoundException | SQLException e)
				{
						JOptionPane.showMessageDialog(this, e.getMessage(), "Database Error", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		}
		
		else if(source==btnReset)
		{
			reset();
		}
	}
	
	private void reset()
	{
		txtRentDate.setText("");
		txtClothesid.setText("");
		txtDuration.setText("");
		//txtTotal.setText("");
		txtUid.setText("");
		txtRentDate.grabFocus();
	}
	
}
