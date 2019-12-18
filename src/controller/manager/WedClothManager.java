package controller.manager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import model.Rental;
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
	
	public static int updateWedCloth(Double rent, Boolean dress, int id) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
		PreparedStatement ps = connection.prepareStatement(
				"UPDATE clothes SET RentRate = ?, ClothesType = ? WHERE ClothesID = ?");
		
		ps.setDouble(1, rent);
		ps.setBoolean(2, dress);
		ps.setInt(3, id);
		
		int status = ps.executeUpdate();
		
		connection.close();
		
		return status;
	}
	
	public static int deleteWedCloth(int id) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
		PreparedStatement ps = connection.prepareStatement(
				"DELETE FROM clothes WHERE ClothesID = ?");
		
		ps.setInt(1, id);
		
		int status = ps.executeUpdate();
		
		connection.close();
		
		return status;
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

	public static Vector<WedCloth> searchClothes() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps;
	
		Vector<WedCloth> clothes=new Vector<>();
	
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");


		ps= connection.prepareStatement("SELECT * FROM Clothes ORDER BY ClothesID;");
	
		ResultSet rs=ps.executeQuery();
	
			while(rs.next()) {
				WedCloth wedCloth=new WedCloth();
				wedCloth.setClothesID(rs.getInt("ClothesID"));
				wedCloth.setRentRate(rs.getDouble("RentRate"));
				wedCloth.setClothesType(rs.getBoolean("clothesType"));
				wedCloth.setColour(rs.getString("Colour"));
				wedCloth.setSize(rs.getString("Size"));
			
				clothes.add(wedCloth);
			}
			
			connection.close();
	
			return clothes;
	}
	
	public static int addRental(int id,String rentDate, double duration, double total, int Uid) throws ClassNotFoundException, SQLException
	{ 
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO rental(RentalID,Date,Duration,Total,UserID)VALUES(?,?,?,?,?)");
			
			//just another alternative,ignore this
			//long millis=System.currentTimeMillis();  
			//long longDate = Long.parseLong(rentDate);
	        //java.sql.Date date=new java.sql.Date(longDate); 
	        
			java.sql.Date date = java.sql.Date.valueOf(rentDate);//converting string into sql date  
	        System.out.println(date); 
			
			ps.setInt(1, id);
			ps.setDate(2, date);
			ps.setDouble(3, duration);
			ps.setDouble(4, total);
			ps.setInt(5, Uid);
			
			
			int status = ps.executeUpdate();
			
			connection.close();
			
			return status;
		}
	
	public static int deleteRental(int id) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
		PreparedStatement ps = connection.prepareStatement(
				"DELETE FROM rental WHERE RentalID = ?");
		
		ps.setInt(1, id);
		
		int status = ps.executeUpdate();
		
		connection.close();
		
		return status;
	}
	
	public static void deleteRental() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
		//WHERE havent complete
		PreparedStatement ps=connection.prepareStatement("DELETE * FROM rental WHERE");
		ResultSet rs=ps.executeQuery();
		
		connection.close();
	}
	
	public static Vector<Rental> searchRental() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps;
	
		Vector<Rental> rentals=new Vector<>();
	
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_cloth_management_system","root","");


		ps= connection.prepareStatement("SELECT * FROM Rental ORDER BY RentalID;");
	
		ResultSet rs=ps.executeQuery();
	
			while(rs.next()) {
				Rental rental=new Rental();
				rental.setId(rs.getInt("RentalID"));
				rental.setRentDate(rs.getDate("RentRate"));
				rental.setRentDuration(rs.getDouble("Duration"));
				rental.setTotal(rs.getDouble("Total"));
				rental.setUserID(rs.getInt("UserID"));
			
				rentals.add(rental);
			}
			
			connection.close();
	
			return rentals;
	}
	
	public static int addPayment(int id, Boolean paid,String paymentDate,int Rid) throws ClassNotFoundException, SQLException
	{ 
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wed_cloth_management_system","root","");
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO payment(PaymentID,Paid,PaymentDate,RentalID)VALUES(?,?,?,?)");
			
			
			java.sql.Date paydate = java.sql.Date.valueOf(paymentDate);
			
			ps.setInt(1, id);
			ps.setBoolean(2, paid);
			ps.setDate(3, paydate);
			ps.setInt(1, Rid);
		
			
			int payment = ps.executeUpdate();
			
			connection.close();
			
			return payment;
		}
}

	