package model;

public class WedCloth 
{
	private int Cloth_ID;
	private String color;
	private String type;
	
	public WedCloth() 
	{
		//take id from db
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}