package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model
{
	public static int getID(String searchType) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps;
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");
<<<<<<< HEAD
		PreparedStatement ps= connection.prepareStatement("SELECT ? FROM ? ORDER BY ? DESC LIMIT 1;");
=======
>>>>>>> a8081f9d5cb7fcb2339cb02651ed6c2cf47c62de
		if(searchType=="Clothes")
		{
			ps= connection.prepareStatement("SELECT ClothesID FROM Clothes ORDER BY ClothesID DESC LIMIT 1;");
		}
		else if(searchType=="User")
		{
			ps= connection.prepareStatement("SELECT UserID FROM User ORDER BY UserID DESC LIMIT 1;");
		}
		else if(searchType=="Rental")
		{
			ps= connection.prepareStatement("SELECT RentalID FROM Rental ORDER BY RentalID DESC LIMIT 1;");
		}
		else if(searchType=="Payment")
		{
			ps= connection.prepareStatement("SELECT PaymentID FROM Payment ORDER BY PaymentID DESC LIMIT 1;");
		}
		else {return -1;}
		
<<<<<<< HEAD
		ps.setString(1, id);
		ps.setString(2, tableName);
		ps.setString(3, id);

=======
>>>>>>> a8081f9d5cb7fcb2339cb02651ed6c2cf47c62de
		ResultSet rs=ps.executeQuery();
		connection.close();
		
		int idDB=0;
		if(!rs.isBeforeFirst()) {
			idDB=1;
		}
		else {
		
			while(rs.next()) {
			 idDB= rs.getInt("ClothesID");
			 idDB++;
			}
		}
		return idDB;
	}
		
}