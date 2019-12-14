package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User 
{	
	
	private int userID;
	private String password;
	private String phoneNo;
	private String icNo;
	private String email;
	private boolean userType;
	
	public static int addUser(int id, String name, String password, String phoneNo, String ICNo, String email, Boolean type) throws ClassNotFoundException, SQLException
	{		
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");
			PreparedStatement ps= connection.prepareStatement(
					"INSERT INTO user (UserID, Name, Password, PhoneNo, ICNo, Email, Class) VALUES(?, ?, ?, ?, ?, ?, ?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, password);
			ps.setString(4, phoneNo);
			ps.setString(5, ICNo);
			ps.setString(6, email);
			ps.setBoolean(7, type);

			int status = ps.executeUpdate();
			
			connection.close();
			
			return status;

	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getIcNo() {
		return icNo;
	}

	public void setIcNo(String icNo) {
		this.icNo = icNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isUserType() {
		return userType;
	}

	public void setUserType(boolean userType) {
		this.userType = userType;
	}
}