package model;

public class User 
{
	private int userID;
	private String phoneNo;
	private String ic;
	private String name;
	private String email;
	private String userType;

	public User()
	{
		Model.getID("user")=;
	}
	
	public int getUserID() {
		return userID;
	}

	public String getPhoneNo()
	{
		return phoneNo;
	}

	public String getIC()
	{
		return ic;
	}

	public void setIC(String ic)
	{
		this.ic=ic;
	}

	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo = phoneNo;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getUserType()
	{
		return userType;
	}

	public void setUserType(String userType)
	{
		this.userType = userType;
	}

	
}