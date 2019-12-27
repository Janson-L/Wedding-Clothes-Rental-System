package view.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrameUser extends JFrame implements ActionListener
{
	private static final long serialVersionUID =1L;
	
	private JButton btnManageRentals= new JButton("Manage Rentals");
	private JButton btnManageWedCloth=new JButton("Manage Wedding Clothes");
	
	
	public MainFrameUser()
	{
		btnManageRentals.addActionListener(this);
		btnManageWedCloth.addActionListener(this);
		
		GridLayout layout = new GridLayout(2, 1, 10, 10);
		
		this.add(btnManageRentals);
		this.add(btnManageWedCloth);
	
		this.setSize(800,500);
		this.setResizable(false);
		this.setLayout(layout);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent event) 
	{
		Object source=event.getSource();
		
		if(source==btnManageRentals) {
			new ManageRentalsDialog(this);
		}
		else if(source==btnManageWedCloth) {
			new ManageClothesDialog(this);
		}
	}
	
	public static void main(String[] args) 
	{
		new MainFrameUser();
	}

	
	
	
}
