package view.gui;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ManageRentalsDialog extends JDialog implements ActionListener

{
	private static final long serialVersionUID=1L;
	
	private JButton btnAddRental=new JButton("Add Rental");
	private JButton btnDeleteRental=new JButton("Delete Rental");
	private JButton btnViewRental=new JButton("View Rental");

	public ManageRentalsDialog(MainFrameUser frame) 
	{
		super(frame, "Manage Rental", true);
		
		GridLayout layout = new GridLayout(3,1,10,10);
		
		this.add(btnAddRental);
		this.add(btnDeleteRental);
		this.add(btnViewRental);
		
		
		btnAddRental.addActionListener(this);
		btnDeleteRental.addActionListener(this);
		btnViewRental.addActionListener(this);
		
		
		
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
		else if (source == btnDeleteRental)
		{
			new DeleteRentalDialog(this);
		}
		else if(source == btnViewRental)
		{
			try {
				new RentalView(null);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	

}