package model;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

	public class RentalTableModel extends AbstractTableModel
	{
		private static final long serialVersionUID = 1L;

		private Vector<Rental> rental;
	     
	    private final String[] columnNames = new String[] {
	            "RentalID", "Date", "Duration", "Total","UserID"
	    };
	    private final Class[] columnClass = new Class[] {
	        Integer.class, String.class, Integer.class, Double.class, Integer.class
	    };
	 
	    public RentalTableModel(Vector<Rental> rental) throws ClassNotFoundException, SQLException
	    {
	    	this.rental=rental;
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
	        return rental.size();
	    }
	 
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex)
	    {
	        Rental row = rental.get(rowIndex);
	        if(0 == columnIndex) {
	            return row.getId();
	        }
	        else if(1 == columnIndex) {
	            return row.getRentDate();
	        }
	        else if(2 == columnIndex) {
	            return row.getRentDuration();
	        }
	        else if(3 == columnIndex) {
	            return row.getTotal();
	        }
	        else if(4 == columnIndex) {
	            return row.getUserID();
	        }
	        return null;
	    }
}


