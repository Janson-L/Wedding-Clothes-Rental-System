public class User 
{
	private int userID;
	private String phoneNo;
	private String ic;
	private String name;
	private String email;
	private int class;

	public User(int userID)
	{
		super(userID);
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
		thic.ic=ic;
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
		this.email=email;
	}

	public int getClass()
	{
		return class;
	}

	public void setClass(int class)
	{
		this.class=class;
	}