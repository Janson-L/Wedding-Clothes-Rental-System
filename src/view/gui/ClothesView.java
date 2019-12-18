package view.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;

import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import controller.manager.WedClothManager;
import model.ClothesTableModel;

public class ClothesView extends JDialog
{
	private static final long serialVersionUID = 1L;
	
	public ClothesView(ManageClothesDialog dialog) throws ClassNotFoundException, SQLException
    {
		super(dialog, "View Clothes", true);
        ClothesTableModel model = new ClothesTableModel(WedClothManager.searchClothes());
        //create the table
        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Clothes Table");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(dialog);
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
					new ClothesView(null);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }    
	

}
