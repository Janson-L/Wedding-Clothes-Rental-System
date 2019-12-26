package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Payment
{
	private int paymentID;
	private Date paymentDate;
	private int rentalID;
	private boolean paid;
	
	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getRentalID() {
		return rentalID;
	}

	public void setRentalID(int rentalID) {
		this.rentalID = rentalID;
	}

	public int newPayment(int paymentID, Date paymentDate, int rentalID ) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");
		PreparedStatement ps= connection.prepareStatement("INSERT INTO Payment (PaymentID,PaymentDate,RentalID) VALUES(?,?,?);");
		
		ps.setInt(1, paymentID);
		ps.setDate(2, paymentDate); //wait for the date input from Yong
		ps.setInt(3, rentalID);
		
		return 0;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
}