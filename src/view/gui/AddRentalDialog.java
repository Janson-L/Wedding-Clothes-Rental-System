package view.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Date; 

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import model.Rental;
import controller.manager.WedClothManager;

public class AddRentalDialog extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JTextField txtRentDate = new JTextField();
	private JTextField txtDuration = new JTextField();
	private JTextField txtTotal = new JTextField();
	private JButton btnSubmit=new JButton("Submit");
	private JButton btnReset=new JButton("Reset");
	
	
	public AddRentalDialog (ManageRentalsDialog dialog)
	{
		super(dialog, "Add Rental",true);
		
		JPanel pnlCenter=new JPanel(new GridLayout(3,2,10,10));
		JPanel pnlSouth=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		pnlCenter.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
		pnlSouth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		pnlCenter.add(new JLabel("Date:", JLabel.RIGHT));
		pnlCenter.add(txtRentDate);
		pnlCenter.add(new JLabel("Duration (Days):", JLabel.RIGHT));
		pnlCenter.add(txtDuration);
		pnlCenter.add(new JLabel("Total(RM):", JLabel.RIGHT));
		pnlCenter.add(txtTotal);
		
		
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
			String total=null;
			
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
			
			try {
				try {
					total = txtTotal.getText();
				double x = Double.valueOf(total.trim()).doubleValue();
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Please enter a valid number in area 'Total' .","Unsuccessful",JOptionPane.WARNING_MESSAGE);
				}
				double x = Double.valueOf(total.trim()).doubleValue();
				x=Validator.validate1("Total", txtTotal.getText(), true,20);
			} 
			catch (RequiredFieldException e) {
				exceptions.add(e);
			}
			
			
			
			int size1 =exceptions.size();	
			if(size1 == 0)
			{
				try 
				{
					int id = Model.getID("Rental");
					double x = Double.valueOf(total.trim()).doubleValue();
					double y = Double.valueOf(duration.trim()).doubleValue();
					if(WedClothManager.addRental(id, rentDate, y, x)!=0)
					{
				
							JOptionPane.showMessageDialog(this, "Rental has been added" , "Success", JOptionPane.INFORMATION_MESSAGE);
	

						txtRentDate.setText("");
						txtDuration.setText("");
						txtTotal.setText("");
						txtRentDate.grabFocus();
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
		txtDuration.setText("");
		txtTotal.setText("");
		txtRentDate.grabFocus();
	}
	
}
