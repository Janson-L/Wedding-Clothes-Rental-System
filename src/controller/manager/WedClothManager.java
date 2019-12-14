package controller.manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import model.User;
import model.WedCloth;

public class WedClothManager
{	
	public static int loginAdmin(String userName, String password) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");
		PreparedStatement ps= connection.prepareStatement(
				"SELECT * FROM user WHERE Name = ? AND Password = ? AND Class = 1");
		
		ps.setString(1, userName);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		if(!rs.isBeforeFirst())
			return 0;
		else
			return 1;
	}
	
	public static int loginUser(String userName, String password) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");
		PreparedStatement ps= connection.prepareStatement(
				"SELECT * FROM user WHERE Name = ? AND Password = ?");
		
		ps.setString(1, userName);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		if(!rs.isBeforeFirst())
			return 0;
		else
			return 1;
	}
	
	public static void getWedClothesID() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
		PreparedStatement ps=connection.prepareStatement("SELECT * FROM clothes ");
		ResultSet rs=ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		    }
		    System.out.println("");
		}
		connection.close();
	}

	public static void getWedClothesType() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
		//WHERE havent complete
		PreparedStatement ps=connection.prepareStatement("SELECT * FROM clothes WHERE CLothesType = ?");
		ResultSet rs=ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		    }
		    System.out.println("");
		}
		connection.close();
	}
	
	
	public static void getWedClothesColour() throws SQLException, ClassNotFoundException
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
		//WHERE havent complete
		PreparedStatement ps=connection.prepareStatement("SELECT * FROM clothes WHERE Colour = ?");
		ResultSet rs=ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		    }
		    System.out.println("");
		}
		connection.close();
	} 	
	
	public static int updateWedCloth(WedCloth wedCloth)
	{
		/*int index=-1;
		for(int i=0;i<wedClothes.length;i++)
		{
			WedCloth temp=wedClothes[i];
			
			if (temp!=null && temp.getUniqueID()==wedCloth.getUniqueID())
			{
				wedClothes[i]=wedCloth;
				index=i;
				
				break;
			}
		}
		return index;*/
		return -1;
	}

	
	public static void deleteWedCloth() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
		//WHERE havent complete
		PreparedStatement ps=connection.prepareStatement("DELETE * FROM clothes WHERE");
		ResultSet rs=ps.executeQuery();
		
		connection.close();
	}

	@SuppressWarnings("unused")
	private static void displayWedCloth()
	{
		System.out.println("Wedding Cloth ID: " + wedCloth.getCloth_ID());
		System.out.println("Rent Rate: RM" + wedCloth.getRentRate());
		System.out.println("Type: " + wedCloth.getClothesType());
		System.out.println("Color: " + wedCloth.getColour());
		System.out.println("Size: " + wedCloth.getSize());
	}
	
	public static Vector<User> searchUser() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps;
		
		Vector<User> users=new Vector<>();
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");


		ps= connection.prepareStatement("SELECT userID,password,phoneNo,icNo,email, class FROM User ORDER BY UserID;");
		
		ResultSet rs=ps.executeQuery();
		
			while(rs.next()) {
				User user=new User();
				user.setUserID(rs.getInt("userID"));
				user.setPassword(rs.getString("password"));
				user.setPhoneNo(rs.getString("phoneNo"));
				user.setIcNo(rs.getString("icNo"));
				user.setEmail(rs.getString("email"));
				user.setUserType(rs.getBoolean("class"));
				
				users.add(user);
			}
			
		connection.close();
		
		return users;
	}

	}

	