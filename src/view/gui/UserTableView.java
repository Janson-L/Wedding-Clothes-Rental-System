package view.gui;

import javax.swing.JFrame;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import controller.manager.WedClothManager;
import model.UserTableModel;

public class UserTableView extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	public UserTableView() throws ClassNotFoundException, SQLException
    {
        UserTableModel model = new UserTableModel(WedClothManager.searchUser());
        //create the table
        JTable table = new JTable(model);
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("User Table");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
					new UserTableView();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }    
	

}
