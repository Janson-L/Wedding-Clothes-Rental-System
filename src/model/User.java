package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User 
{
	//private int userID;
	//private String phoneNo;
	//private String ic;
	//private String name;
	//private String email;
	//private int userType;
	
	public static int addUser(int id, String userName, String phoneNo, String ICNo, String email, Boolean type) throws ClassNotFoundException, SQLException
	{		
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");
			PreparedStatement ps= connection.prepareStatement(
					"INSERT INTO user (UserID, Name, PhoneNo, ICNo, Email, Class) VALUES(?, ?, ?, ?, ?, ?)");
			
			ps.setInt(1, id);
			ps.setString(2, userName);
			ps.setString(3, phoneNo);
			ps.setString(4, ICNo);
			ps.setString(5, email);
			ps.setBoolean(6, type);

			int status = ps.executeUpdate();
			
			connection.close();
			
			return status;

	}
}