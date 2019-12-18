package view;
import java.util.Scanner;
import java.util.Vector;

import controller.manager.WedClothManager;
import model.WedCloth;

public class WedClothView extends View
{
	
	@Override
	public void displayOptions()
	{
		System.out.println("Manage Wedding Clothes");
		System.out.println("===========");
		System.out.println("1. Add wedding clothes");
		System.out.println("2. Update wedding clothes");
		System.out.println("3. Delete wedding clothes");
		System.out.println("4. Display all wedding clothes");
		System.out.println("5. Display wedding clothes by maximum rental fee");
		System.out.println("6. Display wedding clothes by color");
		System.out.println("7. Display wedding clothes by type");
		System.out.println("8. Display wedding clothes by size");
		System.out.println("9. Display single wedding clothes");
		System.out.println("10. Back to main menu");
	}
	
	@Override
	public void processOption(Scanner scanner, int choice)
	{
		if(choice==1)
		{
			WedCloth wedCloth=new WedCloth();//clothid is from WedCloth.java static variable
			
			scanner.nextLine();
			System.out.println("Please enter the wedding clothes' details");
			System.out.print("Color : ");
			wedCloth.setColor(scanner.nextLine());
			
			System.out.print("Type : ");
			wedCloth.setType(scanner.nextLine());
			
			System.out.print("Rental Fee : RM");
			wedCloth.setRentalFee(scanner.nextDouble());
			
			System.out.print("Size : ");
			wedCloth.setSize(scanner.nextInt());
			
			try 
			{
				if(WedClothManager.addWedCloth(wedCloth)!=0)
					System.out.println("Successfully added a new wedding clothes.");
				else
					System.err.println("Unable to add new wedding clothes.");
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(choice==2)
		{
			
		}
		else if(choice==3)
		{
		}
		else if(choice==4)
		{
			try
			{
				Vector<WedCloth> wedClothes= WedClothManager.getWedClothes();
				for(WedCloth wedCloth: wedClothes)
					displayWedCloth(wedCloth);
			}
			catch(ClassNotFoundException|SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if(choice==5)
		{
		}
		
	}

	private static void displayWedCloth(WedCloth wedCloth)
	{
		System.out.println();
		System.out.println("Wedding Cloth ID: " + wedCloth.getUniqueID());
		System.out.println("Color: " + wedCloth.getColor());
		System.out.println("Type: " + wedCloth.getType());
		System.out.println("Rental Fee: RM" + wedCloth.getRentalFee());
		System.out.println("Size: " + wedCloth.getSize());
	
	}
		
}