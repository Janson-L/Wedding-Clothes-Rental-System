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
		
		ResultSet rs=ps.executeQuery();
		
		int idDB=0;
		if(!rs.isBeforeFirst()) {
			idDB=1;
		}
		else {
		
			while(rs.next()) {
				if(searchType=="Clothes")
				{
					idDB= rs.getInt("ClothesID");
				}
				else if(searchType=="User")
				{
					idDB= rs.getInt("UserID");
				}
				else if(searchType=="Rental")
				{
					idDB= rs.getInt("RentalID");
				}
				else if(searchType=="Payment")
				{
					idDB= rs.getInt("PaymentID");
				}
			}
			 idDB++;
		}
		connection.close();
		
		return idDB;
	}
		
}