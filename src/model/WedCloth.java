package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WedCloth 
{
	private int clothesID;
	private double rentRate;
	private Boolean clothesType;
	private String colour;
	private String size;
	
	public int getClothesID() 
	{
		return clothesID;
	}
	public void setClothesID(int clothesID) 
	{
		this.clothesID = clothesID;
	}
	public double getRentRate() 
	{
		return rentRate;
	}
	public void setRentRate(double rentRate) 
	{
		this.rentRate = rentRate;
	}
	public Boolean getClothesType() 
	{
		return clothesType;
	}
	public void setClothesType(Boolean clothesType) 
	{
		this.clothesType = clothesType;
	}
	public String getColour() 
	{
		return colour;
	}
	public void setColour(String colour) 
	{
		this.colour = colour;
	}
	public String getSize() 
	{
		return size;
	}
	public void setSize(String size) 
	{
		this.size = size;
	}
}