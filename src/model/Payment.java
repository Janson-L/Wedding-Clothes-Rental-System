package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Payment
{
	public int newPayment(int paymentID, Date paymentDate, int rentalID ) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");
		PreparedStatement ps= connection.prepareStatement("INSERT INTO Payment (PaymentID,PaymentDate,RentalID) VALUES(?,?,?);");
		
		ps.setInt(1, paymentID);
		ps.setDate(2, paymentDate); //wait for the date input from Yong
		ps.setInt(3, rentalID);
		
		return 0;
	}
}