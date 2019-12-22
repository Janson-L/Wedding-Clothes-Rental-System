package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date; 

public class Rental
{ 
	private int id;
	private Date rentDate;
	private double rentDuration;
	private double total;
	private int userID;
	private int clothesID;
	
	public Rental(int id,Date rentDate,double rentDuration, double total, int userID,int clothesID) throws ClassNotFoundException, SQLException
	{	
		setId(id);
		setRentDate(rentDate);
		setRentDuration(rentDuration);
		setTotal(total);
		setUserID(userID);
		setClothesID(clothesID);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public double getRentDuration() {
		return rentDuration;
	}

	public void setRentDuration(double rentDuration) {
		this.rentDuration = rentDuration;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getClothesID() {
		return clothesID;
	}

	public void setClothesID(int clothesID) {
		this.clothesID = clothesID;
	}

	
}

	
	