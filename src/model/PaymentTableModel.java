package model;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

	public class PaymentTableModel extends AbstractTableModel
	{
		private static final long serialVersionUID = 1L;

		private Vector<Payment> payment;
	     
	    private final String[] columnNames = new String[] {
	            "PaymentID", "PaymentDate", "RentalID"
	    };
	    private final Class[] columnClass = new Class[] {
	        Integer.class, String.class, Integer.class
	    };
	 
	    public PaymentTableModel(Vector<Payment> payment) throws ClassNotFoundException, SQLException
	    {
	    	this.payment=payment;
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
	        return payment.size();
	    }
	 
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex)
	    {
	        Payment row = payment.get(rowIndex);
	        if(0 == columnIndex) {
	            return row.getPaymentID();
	        }
	        else if(1 == columnIndex) {
	            return row.getPaymentDate();
	        }
	        else if(2 == columnIndex) {
	            return row.getRentalID();
	        }
	        return null;
	    }
}


