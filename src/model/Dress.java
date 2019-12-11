package model;

public class Dress extends WedCloth
{
	private int latest_ID;
	private String color;
	private String type;
	private double rentalFee;
	private String size;

	public Dress()
	{
		super(++latest_ID);
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type=type;
	}

	public double getRentalFee()
	{
		return rentalFee;
	}

	public void setRentalFee(double rentalFee)
	{
		this.rentalFee = rentalFee;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size=size;
	}