import java.time.LocalDate;

public class Rental
{
	private int rentalID;
	private WedCloth wedCloth;
	private User user;
	private Date();
	private int duration;
	private double total;

	public Rental(int rentalID)
	{	
		super(rentalID);
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuration(int duration)
	{
		if(duration>0)
		{
			this.duration=duration;
			this.total = duration *wedCloth.getRentalFee();
		}
	}
	
	public duble getTotal()
	{
		return total;
	}

	public WedCloth getWedCloth()
	{
		return wedCloth;
	}

	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user=user;
	}

	
	