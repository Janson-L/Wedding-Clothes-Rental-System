package controller.manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;

import model.User;
import model.WedCloth;

public class WedClothManager
{	
	public static int addWedCloth(WedCloth wedCloth) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
		PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO clothes(ClothesID, RentRate,ClothesType,Colour,Size)VALUES(?,?,?,?,?)");
		
		ps.setInt(1, wedCloth.getCloth_ID());
		ps.setDouble(2, wedCloth.getRentRate());
		ps.setInt(3, wedCloth.getClothesType());
		ps.setString(4, wedCloth.getColour());
		ps.setString(5, wedCloth.getSize());
		
		int status = ps.executeUpdate();
		
		connection.close();
		
		return status;
	}

	public static Vector<WedCloth> getWedClothes() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
		PreparedStatement ps=connection.prepareStatement("SELECT * FROM clothes ");
		ResultSet rs=ps.executeQuery();
		Vector<WedCloth> wedClothes = new Vector<>();
		
		while(rs.next())
		{
			WedCloth wedCloth = new WedCloth();
			
			wedCloth.setCloth_ID(rs.getInt(2));//plateNo is 2nd column in database table
			wedCloth.setRentRate(rs.getDouble(3));
			wedCloth.setClothesType(rs.getInt(4));
			wedCloth.setColour(rs.getString(5));
			wedCloth.setSize(rs.getString(6));
			
			wedClothes.add(wedCloth);
		}
		
		connection.close();
		
		return wedClothes;
	}

	public static Vector<WedCloth> getWedClothes(int clothesType)
	{
		Vector<WedCloth> temp = new Vector<WedCloth>();
		
		for(WedCloth wedCloth : wedClothes)
			if(wedCloth.getClothesType() == clothesType)
				temp.add(wedCloth);
		
		return temp;
	}
	
	
	public static Vector<WedCloth> getWedClothes(String colour)
	{
		Vector<WedCloth> temp = new Vector<WedCloth>();
		
		for(WedCloth wedCloth : wedClothes)
		{
			if(wedCloth.getColour().toLowerCase().contains(colour.toLowerCase()))
			{
				temp.add(wedCloth);
			}
		}
		return temp;
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

	
	public static boolean deleteWedCloth(int cloth_ID)
	{
		WedCloth wedCloth = null;
		
		for(WedCloth wc : wedClothes)
		{
			if(wc.getCloth_ID() == cloth_ID)
			{
				wedCloth = wc;
				break;
			}
		}
		return wedClothes.remove(wedCloth);
	}

	@SuppressWarnings("unused")
	private static void displayWedCloth(WedCloth wedCloth)
	{
		System.out.println();
		System.out.println("Wedding Cloth ID: " + wedCloth.getCloth_ID());
		System.out.println("Rent Rate " + wedCloth.getRentRate());
		System.out.println("Type: " + wedCloth.getClothesType());
		System.out.println("Color: RM" + wedCloth.getColour());
		System.out.println("Size: " + wedCloth.getSize());
	}
	
	private static Vector<User> user = new Vector<>();
	
	public static int addUser(User user)
	{
		User.add(user);
		
		if ( User.add(user)== 0)
		{
			
		}else
		{
			return 0;
		}
	}
}

	