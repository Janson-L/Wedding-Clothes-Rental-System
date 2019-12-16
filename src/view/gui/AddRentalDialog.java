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
	
	private JTextField txtDate = new JTextField();
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
		
		pnlCenter.add(new JLabel("Rent(RM):", JLabel.RIGHT));
		pnlCenter.add(txtDate);
		pnlCenter.add(new JLabel("Colour:", JLabel.RIGHT));
		pnlCenter.add(txtDuration);
		pnlCenter.add(new JLabel("Size (S,M,L,XL):", JLabel.RIGHT));
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
			String date=null,duration=null,total=null;
			
			try {
				duration=Validator.validate("Duration", txtDuration.getText(), true,50);
			} 
			catch (RequiredFieldException | MaximumLengthException e) {
				exceptions.add(e);
			}
			
			try {
				size=Validator.validate("Size", txtSize.getText(), true,50);
			} 
			catch (RequiredFieldException | MaximumLengthException e) {
				exceptions.add(e);
			}
			
			
			try {
				try {
					rent = txtRent.getText();
				double x = Double.valueOf(rent.trim()).doubleValue();
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Please enter a valid number in area 'Rent' .","Unsuccessful",JOptionPane.WARNING_MESSAGE);
				}
				double x = Double.valueOf(rent.trim()).doubleValue();
				x=Validator.validate1("Rent", txtRent.getText(), true,20);
			} 
			catch (RequiredFieldException e) {
				exceptions.add(e);
			}
			
			int size1 =exceptions.size();	
			if(size1 == 0)
			{
				try 
				{
					int id = Model.getID("Clothes");
					double x = Double.valueOf(rent.trim()).doubleValue();
					if(WedClothManager.addWedCloth(id, x, dress, colour, size)!=0)
					{
						if(dress == true)
							JOptionPane.showMessageDialog(this, "Dress has been added." , "Success", JOptionPane.INFORMATION_MESSAGE);
						else if(dress == false)
							JOptionPane.showMessageDialog(this, "Suit has been added." , "Success", JOptionPane.INFORMATION_MESSAGE);

						txtRent.setText("");
						txtColour.setText("");
						txtSize.setText("");
						chkClothesType.setText("false");
						txtRent.grabFocus();
					}
					else
						JOptionPane.showMessageDialog(this, "Unable to add new clothes.","Unsuccessful",JOptionPane.WARNING_MESSAGE);
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
		txtDate.setText("");
		txtDuration.setText("");
		txtTotal.setText("");
		txtRent.grabFocus();
	}
	
}
