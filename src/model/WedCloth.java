package model;

public class WedCloth 
{
	private int cloth_ID;
	private String colour;
	private int clothesType;
	private double rentRate;
	private String size;
	
	public WedCloth() 
	{
		//take id from db
	}
	
	public int getCloth_ID() {
		return cloth_ID;
	}

	public void setCloth_ID(int cloth_ID) {
		this.cloth_ID = cloth_ID;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getClothesType() {
		return clothesType;
	}

	public void setClothesType(int clothesType) {
		this.clothesType = clothesType;
	}
	
	public double getRentRate()
	{
		return rentRate;
	}

	public void setRentRate(double rentRate)
	{
		this.rentRate = rentRate;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size=size;
	}
}