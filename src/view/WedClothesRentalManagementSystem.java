package view;
import java.util.Scanner;

public class WedClothesRentalManagementSystem extends View
{
	@Override
	public void displayOptions()
	{
		System.out.println("Welcome to Wedding Clothes Rental Management System");
		System.out.println("=======================================");
		System.out.println("1. Manage wedding clothes");
		System.out.println("2. Manage users");
		System.out.println("3. Manage rentals");
		System.out.println("4. Exit");
	}
	
	@Override
	public void processOption(Scanner scanner, int choice)
	{
		if(choice==1)
			{
				WedClothView cv=new WedClothView();
				
				cv.displayOptions();
				cv.selectOption(scanner,10);
				displayOptions();//display main menu again
			}
			else if(choice==2)
			{
				UserView uv=new UserView();
				uv.displayOptions();
				//uv.selectOption(scanner,5);
				displayOptions();
			}
			else if(choice==3)
			{
				RentalView rv=new RentalView();
				rv.displayOptions();
				//rv.selectOption(scanner,5);
				displayOptions();
			}
	}
	
	public static void main(String[] args)
	{	
		Scanner scanner= new Scanner(System.in);
		WedClothesRentalManagementSystem wcrms=new WedClothesRentalManagementSystem();
		
		wcrms.displayOptions();
		wcrms.selectOption(scanner,4);
	}
}