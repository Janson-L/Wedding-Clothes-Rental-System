package view.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MainFrame extends JFrame implements ActionListener
{
	private static final long serialVersionUID =1L;
	
	private JButton btnManageRentals= new JButton("Manage Rentals");
	private JButton btnManageUser=new JButton("Manage Users");
	private JButton btnManageWedCloth=new JButton("Manage Wedding Clothes");
	
	
	public MainFrame()
	{
		btnManageRentals.addActionListener(this);
		btnManageUser.addActionListener(this);
		btnManageWedCloth.addActionListener(this);
		
		GridLayout layout = new GridLayout(3, 1, 10, 10);
		
		this.add(btnManageRentals);
		this.add(btnManageUser);
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
		
		if(source==btnManageWedCloth) {
			new ManageClothesDialog(this);
		}
		else if(source==btnManageUser) {
			new ManageUserDialog(this);
		}
		//else if(source==btnManageRentals)
		//{
		//	new ManageRentalsDialog(this);
		//}
	}
	
	public static void main(String[] args) 
	{
		new MainFrame();
	}

	
	
	
}
