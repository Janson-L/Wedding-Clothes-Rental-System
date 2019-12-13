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
		PreparedStatement ps=connection.prepareStatement("SELECT * FROM clothes WHERE");
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
		System.out.println();
		System.out.println("Wedding Cloth ID: " + wedCloth.getCloth_ID());
		System.out.println("Rent Rate: RM" + wedCloth.getRentRate());
		System.out.println("Type: " + wedCloth.getClothesType());
		System.out.println("Color: " + wedCloth.getColour());
		System.out.println("Size: " + wedCloth.getSize());
	}
		
	public static int addUser()
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
		PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO User(UserID, Name, PhoneNo, IC, Email, Class)VALUES(?,?,?,?,?,?)");
		
		ps.setInt(1, user.getCloth_ID());
		ps.setDouble(2, user.getRentRate());
		ps.setInt(3, user.getClothesType());
		ps.setString(4, user.getColour());
		ps.setString(5, user.getSize());
		ps.setString(6, user.getSize());
		
		int status = ps.executeUpdate();
		
		connection.close();
		
		return status;
	}
}

	