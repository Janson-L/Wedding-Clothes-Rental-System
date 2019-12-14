package model;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

	public class RentalTableModel extends AbstractTableModel
	{
		private static final long serialVersionUID = 1L;

		private Vector<User> users;
	     
	    private final String[] columnNames = new String[] {
	            "ID", "Name", "phoneNo", "IC No","Email","Admin"
	    };
	    private final Class[] columnClass = new Class[] {
	        Integer.class, String.class, String.class, String.class, String.class, Boolean.class
	    };
	 
	    public RentalTableModel(Vector<User> users) throws ClassNotFoundException, SQLException
	    {
	    	this.users=users;
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
	        return users.size();
	    }
	 
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex)
	    {
	        User row = users.get(rowIndex);
	        if(0 == columnIndex) {
	            return row.getUserID();
	        }
	        else if(1 == columnIndex) {
	            return row.getPassword();
	        }
	        else if(2 == columnIndex) {
	            return row.getPhoneNo();
	        }
	        else if(3 == columnIndex) {
	            return row.getIcNo();
	        }
	        else if(4 == columnIndex) {
	            return row.getEmail();
	        }
	        else if(5 == columnIndex) {
	            return row.isUserType();
	        }
	        return null;
	    }
}


