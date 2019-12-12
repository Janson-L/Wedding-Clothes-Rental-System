package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract class Model
{
	public int getID(String searchType) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		String id,tableName;
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");
		PreparedStatement ps= connection.prepareStatement("SELECT ? FROM ? DESC LIMIT 1;");
		if(searchType=="Clothes")
		{
			id="ClothesID";
			tableName="Clothes";
		}
		else if(searchType=="User")
		{
			id="UserID";
			tableName="User";
		}
		else if(searchType=="Rental")
		{
			id="RentalID";
			tableName="Rental";
		}
		else if(searchType=="Payment")
		{
			id="PaymentID";
			tableName="Payment";
		}
		else {return -1;}
		
		ps.setString(1, id);
		ps.setString(2, tableName);

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