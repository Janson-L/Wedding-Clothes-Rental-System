package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WedCloth 
{
	
	public static int addWedCloth(int id,double rent, Boolean dress, String colour, String size) throws ClassNotFoundException, SQLException
	{ 
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO clothes(ClothesID, RentRate,ClothesType,Colour,Size)VALUES(?,?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setDouble(2, rent);
			ps.setBoolean(3, dress);
			ps.setString(4, colour);
			ps.setString(5, size);
			
			int status = ps.executeUpdate();
			
			connection.close();
			
			return status;
		}
}