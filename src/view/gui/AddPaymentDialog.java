package view.gui;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.manager.WedClothManager;
import controller.validator.MaximumLengthException;
import controller.validator.RequiredFieldException;
import controller.validator.Validator;
import model.ClothesTableModel;
import view.gui.ClothesView;

public class AddPaymentDialog extends JDialog implements ActionListener 
{

	private static final long serialVersionUID = 1L;
	
	private JTextField txtID = new JTextField();
	private JCheckBox chkPayment = new JCheckBox();
	private JButton btnSubmit = new JButton("Submit");
	private JButton btnReset = new JButton("Reset");
	
	public AddPaymentDialog(ManageClothesDialog dialog)
	{
		super(dialog, "Payment", true);
		
		JPanel pnlCentre = new JPanel(new GridLayout(2,1,10,10));
		JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		pnlCentre.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
		pnlSouth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		pnlCentre.add(new JLabel("Please enter the Rental ID to be paid.", JLabel.CENTER));
		pnlCentre.add(new JLabel("Rental ID: ", JLabel.LEFT));
		pnlCentre.add(txtID);
		pnlCentre.add(new JLabel("Paid?", JLabel.RIGHT));
		pnlCentre.add(chkPayment);
		
		pnlSouth.add(btnSubmit);
		pnlSouth.add(btnReset);
		
		
		this.add(pnlCentre);
		this.add(pnlSouth, BorderLayout.SOUTH);
		
		btnSubmit.addActionListener(this);
		btnReset.addActionListener(this);
		
		this.getRootPane().setDefaultButton(btnSubmit);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(dialog);
		this.setVisible(true);
		}

	public void actionPerformed(ActionEvent event) 
	{
		Object source = event.getSource();
		if(source == btnSubmit)
		{
			Vector<Exception> exceptions = new Vector<>();
			int id;
			String x=null;
			Boolean paid=chkPayment.isSelected();
			
			try 
			{
				x=Validator.validate("Rental ID", txtID.getText(), true, 15);
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
					if(WedClothManager.AddPayment(id)!=0)
					{
						JOptionPane.showMessageDialog(this, "Payment Completed" , "Success", JOptionPane.INFORMATION_MESSAGE);
						reset();
					}
					else
						JOptionPane.showMessageDialog(this, "Unable to process payment","Unsuccessful",JOptionPane.WARNING_MESSAGE);
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
					message="PLease fix the following errors: ";
						
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
		chkPayment.setText("false");

	}
	
}