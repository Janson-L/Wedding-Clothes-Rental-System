package view.gui;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ManageRentalsDialog extends JDialog implements ActionListener

{
	private static final long serialVersionUID=1L;
	
	private JButton btnAddClothes=new JButton("Add Clothes");
	private JButton btnUpdateClothes=new JButton("Update Clothes");
	private JButton btnDeleteClothes=new JButton("Delete Clothes");
	private JButton btnViewAllClothes=new JButton("View All Clothes");
	private JButton btnViewClothesByMaxPrice=new JButton("View Clothes by Maximum Price");
	private JButton btnViewClothesByType=new JButton("View Clothes by Type");
	private JButton btnViewClothesByColour=new JButton("View Clothes by Colour");
	private JButton btnViewSingleClothes=new JButton("View Single Wedding Clothes");
	
	public ManageRentalsDialog(MainFrame frame)
	{
		super(frame, "Manage Rentals", true);
		
		GridLayout layout = new GridLayout(8,1,10,10);
		
		this.add(btnAddClothes);
		this.add(btnUpdateClothes);
		this.add(btnDeleteClothes);
		this.add(btnViewAllClothes);
		this.add(btnViewClothesByMaxPrice);
		this.add(btnViewClothesByType);
		this.add(btnViewClothesByColour);
		this.add(btnViewSingleClothes);
		
		btnAddClothes.addActionListener(this);
		btnUpdateClothes.addActionListener(this);
		btnDeleteClothes.addActionListener(this);
		btnViewAllClothes.addActionListener(this);
		btnViewClothesByMaxPrice.addActionListener(this);
		btnViewClothesByType.addActionListener(this);
		btnViewClothesByColour.addActionListener(this);
		btnViewSingleClothes.addActionListener(this);
		
		this.setLayout(layout);
		this.pack();
		this.setSize(800,500);
		this.setLocationRelativeTo(frame);
		this.setVisible(true);
	}
	

	

	public ManageRentalsDialog(MainFrameUser frame) 
	{
		super(frame, "Manage Rentals", true);
		
		GridLayout layout = new GridLayout(8,1,10,10);
		
		this.add(btnAddClothes);
		this.add(btnUpdateClothes);
		this.add(btnDeleteClothes);
		this.add(btnViewAllClothes);
		this.add(btnViewClothesByMaxPrice);
		this.add(btnViewClothesByType);
		this.add(btnViewClothesByColour);
		this.add(btnViewSingleClothes);
		
		btnAddClothes.addActionListener(this);
		btnUpdateClothes.addActionListener(this);
		btnDeleteClothes.addActionListener(this);
		btnViewAllClothes.addActionListener(this);
		btnViewClothesByMaxPrice.addActionListener(this);
		btnViewClothesByType.addActionListener(this);
		btnViewClothesByColour.addActionListener(this);
		btnViewSingleClothes.addActionListener(this);
		
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
		
		if(source==btnAddClothes) 
		{
			new AddClothesDialog(this);
		}
		
		
		
		
		// TODO Auto-generated method stub
		
	}
	

}
