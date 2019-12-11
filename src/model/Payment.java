import java.utill.*;

public class Payment
{
	private int paymentID;

	public int getPaymentID()
	{
		return paymentID;
	}

	public void setPaymentID(int paymentID)
	{
		this.paymentID = paymentID;
	}

	
	public class Date
	{
		private int day;
		private int month;
		private int year;
		
		public int getDay() 
		{
        		return this.day;
    		}

		 public int getMonth() 
		{
        		return this.month;
		}

		public int getYear() 
		{
        		return this.year;
    		}

		
    }
}