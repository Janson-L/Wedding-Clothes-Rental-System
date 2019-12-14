package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User 
{
	
	public static int addUser(int id, String userName, String password, String phoneNo, String ICNo, String email, Boolean type) throws ClassNotFoundException, SQLException
	{		
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");
			PreparedStatement ps= connection.prepareStatement(
					"INSERT INTO user (UserID, Name, Password, PhoneNo, ICNo, Email, Class) VALUES(?, ?, ?, ?, ?, ?, ?)");
			
			ps.setInt(1, id);
			ps.setString(2, userName);
			ps.setString(3, password);
			ps.setString(4, phoneNo);
			ps.setString(5, ICNo);
			ps.setString(6, email);
			ps.setBoolean(7, type);

			int status = ps.executeUpdate();
			
			connection.close();
			
			return status;

	}
	
	public static int login(String userName, String password) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");
		PreparedStatement ps= connection.prepareStatement(
				"SELECT * FROM user WHERE Name = ? AND Password = ?");
	}
}