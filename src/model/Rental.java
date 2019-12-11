package model;
import java.time.LocalDate;

public class Rental
{
	private int rentalID;
	private WedCloth wedCloth;
	private User user;
	private Date();
	private int duration;
	private double total;

	public Rental()
	{	

	}

	public int getRentalID() {
		return rentalID;
	}

	public void setRentalID(int rentalID) {
		this.rentalID = rentalID;
	}

	public void setWedCloth(WedCloth wedCloth) {
		this.wedCloth = wedCloth;
	}

	public void setTotal(double total) {
		this.total = total;
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
	
	public double getTotal()
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
}

	
	