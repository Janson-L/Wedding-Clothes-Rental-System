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
import model.Model;
import view.gui.ClothesView;

public class AddPaymentDialog extends JDialog implements ActionListener 
{

	private static final long serialVersionUID = 1L;
	
	private JTextField txtRid = new JTextField();
	private JCheckBox chkPayment = new JCheckBox();
	private JTextField txtPaymentDate = new JTextField();
	private JButton btnSubmit = new JButton("Submit");
	private JButton btnReset = new JButton("Reset");
	
	public AddPaymentDialog(MainFrame mainFrame)
	{
		super(mainFrame, "Payment", true);
		
		JPanel pnlCentre = new JPanel(new GridLayout(3,1,10,10));
		JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		pnlCentre.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
		pnlSouth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		
		pnlCentre.add(new JLabel("Rental ID: ", JLabel.LEFT));
		pnlCentre.add(txtRid);
		pnlCentre.add(new JLabel("Paid?", JLabel.LEFT));
		pnlCentre.add(chkPayment);
		pnlCentre.add(new JLabel("Payment Date(Format->'Year-Month-Day':", JLabel.LEFT));
		pnlCentre.add(txtPaymentDate);
		
		
		pnlSouth.add(btnSubmit);
		pnlSouth.add(btnReset);
		
		
		this.add(pnlCentre);
		this.add(pnlSouth, BorderLayout.SOUTH);
		
		btnSubmit.addActionListener(this);
		btnReset.addActionListener(this);
		
		this.getRootPane().setDefaultButton(btnSubmit);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(mainFrame);
		this.setVisible(true);
		}

	public void actionPerformed(ActionEvent event) 
	{
		Object source = event.getSource();
		if(source == btnSubmit)
		{
			Vector<Exception> exceptions = new Vector<>();
			int rid;
			String x=null;
			String paymentDate=null;
			Boolean paid=chkPayment.isSelected();
			
			try 
			{
				x=Validator.validate("Rental ID", txtRid.getText(), true, 15);
			} 
			catch (RequiredFieldException | MaximumLengthException e) 
			{
				exceptions.add(e);
			}
			
			try {
				paymentDate=Validator.validate("Payment Date", txtPaymentDate.getText(), true,50);
			} 
			catch (RequiredFieldException | MaximumLengthException e) {
				exceptions.add(e);
			
			int size = exceptions.size();
			rid = Integer.parseInt(x);
			if(size == 0)
			{
				try 
				{
					int id=Model.getID("Payment");
					
					if(WedClothManager.addPayment(id,paid,paymentDate,rid)!=0)
					{
						JOptionPane.showMessageDialog(this, "Payment Completed" , "Success", JOptionPane.INFORMATION_MESSAGE);
						
						txtRid.setText("");
						chkPayment.setText("false");
						txtPaymentDate.setText("");
						txtPaymentDate.grabFocus();
					}
					else
						JOptionPane.showMessageDialog(this, "Unable to process payment","Unsuccessful",JOptionPane.WARNING_MESSAGE);
				}
				catch (ClassNotFoundException | SQLException ev) 
				{
					JOptionPane.showMessageDialog(this, e.getMessage(), "Database Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		
			
		else if(source == btnReset)
		{
			reset();
	    }
			}}}
	private void reset()
	{
		txtRid.setText("");
		chkPayment.setText("false");
		txtPaymentDate.setText("");
		txtPaymentDate.grabFocus();

	}
	
}