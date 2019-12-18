package model;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

	public class ClothesTableModel extends AbstractTableModel
	{
		private static final long serialVersionUID = 1L;

		private Vector<WedCloth> clothes;
	     
	    private final String[] columnNames = new String[] {
	            "ClothesID", "RentRate", "Dress", "Colour","Size"
	    };
	    private final Class[] columnClass = new Class[] {
	        Integer.class, String.class, Boolean.class, String.class, String.class
	    };
	 
	    public ClothesTableModel(Vector<WedCloth> clothes) throws ClassNotFoundException, SQLException
	    {
	    	this.clothes=clothes;
	    }
	     
	    @Override
	    public String getColumnName(int column)
	    {
	        return columnNames[column];
	    }
	 
	    @Override
	    public Class<?> getColumnClass(int columnIndex)
	    {
	        return columnClass[columnIndex];
	    }
	 
	    @Override
	    public int getColumnCount()
	    {
	        return columnNames.length;
	    }
	 
	    @Override
	    public int getRowCount()
	    {
	        return clothes.size();
	    }
	 
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex)
	    {
	        WedCloth row = clothes.get(rowIndex);
	        if(0 == columnIndex) {
	            return row.getClothesID();
	        }
	        else if(1 == columnIndex) {
	            return row.getRentRate();
	        }
	        else if(2 == columnIndex) {
	            return row.getClothesType();
	        }
	        else if(3 == columnIndex) {
	            return row.getColour();
	        }
	        else if(4 == columnIndex) {
	            return row.getSize();
	        }
	        return null;
	    }
}


