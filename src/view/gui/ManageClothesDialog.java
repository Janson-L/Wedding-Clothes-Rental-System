package view.gui;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ManageClothesDialog extends JDialog implements ActionListener

{
	private static final long serialVersionUID=1L;
	
	private JButton btnAddClothes=new JButton("Add Clothes");
	private JButton btnUpdateClothes=new JButton("Update Clothes");
	private JButton btnDeleteClothes=new JButton("Delete Clothes");
	private JButton btnViewAllClothes=new JButton("View All Clothes");
	
	
	public ManageClothesDialog(MainFrame frame)
	{
		super(frame, "Manage Clothes", true);
		
		GridLayout layout = new GridLayout(4,1,10,10);
		
		this.add(btnAddClothes);
		this.add(btnUpdateClothes);
		this.add(btnDeleteClothes);
		this.add(btnViewAllClothes);
		
		
		btnAddClothes.addActionListener(this);
		btnUpdateClothes.addActionListener(this);
		btnDeleteClothes.addActionListener(this);
		btnViewAllClothes.addActionListener(this);
		
		
		this.setLayout(layout);
		this.pack();
		this.setSize(800,500);
		this.setLocationRelativeTo(frame);
		this.setVisible(true);
	}
	

	

	public ManageClothesDialog(MainFrameUser frame) 
	{
		super(frame, "Manage Clothes", true);
		
		GridLayout layout = new GridLayout(4,1,10,10);
		
		this.add(btnAddClothes);
		this.add(btnUpdateClothes);
		this.add(btnDeleteClothes);
		this.add(btnViewAllClothes);
		
		
		btnAddClothes.addActionListener(this);
		btnUpdateClothes.addActionListener(this);
		btnDeleteClothes.addActionListener(this);
		btnViewAllClothes.addActionListener(this);
		
		
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
		else if (source == btnViewAllClothes)
		{
			try {
				new ClothesView(this);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(source == btnUpdateClothes)
		{
			new UpdateClothesDialog(this);
		}
		else if(source == btnDeleteClothes)
		{
			new DeleteClothesDialog(this);
		}
		
	}
	

}
