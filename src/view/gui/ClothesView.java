package view.gui;

import javax.swing.JFrame;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import controller.manager.WedClothManager;
import model.ClothesTableModel;

public class ClothesView extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	public ClothesView() throws ClassNotFoundException, SQLException
    {
        ClothesTableModel model = new ClothesTableModel(WedClothManager.searchClothes());
        //create the table
        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Clothes Table");
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
					new ClothesView();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }    
	

}
