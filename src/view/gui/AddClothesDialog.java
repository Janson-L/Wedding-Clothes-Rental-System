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
			String clothesNo=null, clothesType=null;
			double rent=0;
			
			
			try {
				clothesNo=Validator.validate("Clothes Number", txtClothesNo.getText(), true, 15);
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
			
			
		}
		
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
