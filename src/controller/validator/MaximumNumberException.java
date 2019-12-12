package controller.validator;

public class MaximumNumberException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public MaximumNumberException(String field, int maximum)
	{
		super(field + " must be less than or equal to "+maximum+".");
	}
	
	public MaximumNumberException(String field, double maximum)
	{
		super(field + " must be less than or equal to "+maximum+".");
	}

}
