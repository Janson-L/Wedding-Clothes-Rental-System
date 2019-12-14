package view.gui;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ViewTable {
	
	public class UserTableModel extends AbstractTableModel
	{
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		//id, name,password, phoneNo, icNo, email, admin
	     
	    private final String[] columnNames = new String[] {
	            "ID", "Name", "phoneNo", "IC No","Email","Admin"
	    };
	    private final Class[] columnClass = new Class[] {
	        Integer.class, String.class, String.class, String.class, String.class, Boolean.class
	    };
	 
	    public EmployeeTableModel(List<Employee> employeeList)
	    {
	    	
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
	        return employeeList.size();
	    }
	 
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex)
	    {
	        Employee row = employeeList.get(rowIndex);
	        if(0 == columnIndex) {
	            return row.getId();
	        }
	        else if(1 == columnIndex) {
	            return row.getName();
	        }
	        else if(2 == columnIndex) {
	            return row.getHourlyRate();
	        }
	        else if(3 == columnIndex) {
	            return row.isPartTime();
	        }
	        return null;
	    }
}
}

