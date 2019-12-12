package view.gui;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ManageRentalsDialog extends JDialog implements ActionListener

{
	private static final long serialVersionUID=1L;
	
	private JButton btnAddRental=new JButton("Add Rental");
	private JButton btnUpdateRental=new JButton("Update Rental");
	private JButton btnDeleteRental=new JButton("Delete Rental");
	private JButton btnViewRentalDetails=new JButton("View Rental Details");
	
	
	
	public ManageRentalsDialog(MainFrame frame)
	{
		GridLayout layout = new GridLayout(4,1,10,10);
		
		this.add(btnAddRental);
		this.add(btnUpdateRental);
		this.add(btnDeleteRental);
		this.add(btnViewRentalDetails);
		
		btnAddRental.addActionListener(this);
		btnUpdateRental.addActionListener(this);
		btnDeleteRental.addActionListener(this);
		btnViewRentalDetails.addActionListener(this);
		
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
		
		if(source==btnAddRental) 
		{
			new AddRentalDialog(this);
		}
		
		if(source==btnUpdateRental) 
		{
			new UpdateRentalDialog(this);
		}
		
		if(source==btnDeleteRental) 
		{
			new DeleteRentalDialog(this);
		}
		
		if(source==btnViewRentalDetails) 
		{
			new ViewRentalDialog(this);
		}
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		
	}
	

}
