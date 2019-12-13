package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WedCloth 
{
	private int clothID;
	private Double rentRate;
	private int type;
	private String colour;
	private String size;
	
	public WedCloth() 
	{ 
		public static int addWedCloth() throws SQLException, ClassNotFoundException
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO clothes(ClothesID, RentRate,ClothesType,Colour,Size)VALUES(?,?,?,?,?)");
			
			ps.setInt(1, clothID);
			ps.setDouble(2, rentRate);
			ps.setInt(3, type);
			ps.setString(4, colour);
			ps.setString(5, size);
			
			int status = ps.executeUpdate();
			
			connection.close();
			
		}
}
}