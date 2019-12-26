package view.gui;

import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import controller.manager.WedClothManager;
import model.RentalTableModel;

public class RentalView extends JDialog
{
	private static final long serialVersionUID = 1L;
	
	public RentalView(ManageRentalsDialog dialog) throws ClassNotFoundException, SQLException
    {
		super(dialog, "View Rentals", true);
        RentalTableModel model = new RentalTableModel(WedClothManager.searchRental());
        //create the table
        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Rental Table");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        this.setLocationRelativeTo(dialog);
        this.pack();
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
					new RentalView(null);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }    
	

}
