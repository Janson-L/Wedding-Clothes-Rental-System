package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date; 

public class Rental
{ 
	private int id;
	private Date rentDate;
	private int rentDuration;
	private Double total;
	private int userID;
	
	public Rental() throws ClassNotFoundException, SQLException
	{	
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");
		PreparedStatement ps= connection.prepareStatement("INSERT INTO rental (RentalID, Date, Duration, Total, UserID) VALUES(?, ?, ?, ?, ?)");
		
		ps.setInt(1, id);
		ps.setDate(2, rentDate);
		ps.setInt(3, rentDuration);
		ps.setDouble(4, total);
		ps.setInt(5, userID);
		
		connection.close();
	}

	
}

	
	