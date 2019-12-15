package view.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.manager.WedClothManager;
import model.ClothesTableModel;


public class TestXia extends JDialog
{

	private static final long serialVersionUID = 1L;
	private JTextField txtID = new JTextField();
	private JButton btnDelete = new JButton("Delete");
	private JButton btnReset = new JButton("Reset");

    public TestXia(ManageRentalsDialog dialog) throws ClassNotFoundException, SQLException 
    {
    	super(dialog, "Delete Clothes", true);
        ClothesTableModel model = new ClothesTableModel(WedClothManager.searchClothes());
        //create the table
        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);
         
        JFrame frame = new JFrame();
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
        contentPane.add(btnDelete, BorderLayout.SOUTH);
        
        //add the table to the frame
        //panel.add(new JScrollPane(table));
        //frame.add(panel);
        //this.add(new JScrollPane(txtID));
        /*JPanel pnlCentre = new JPanel(new GridLayout(3,1,10,10));
    	JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	pnlCentre.add(table);
    	pnlCentre.add(new JLabel("Please enter the Clothes ID that you want to delete.", JLabel.CENTER));
		pnlCentre.add(new JLabel("Clothes ID: ", JLabel.LEFT));
		pnlCentre.add(txtID);
		pnlSouth.add(btnDelete);
		pnlSouth.add(btnReset);*/
         
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
					new TestXia(null);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }    
}
