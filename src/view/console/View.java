package view.console;
import java.util.Scanner;

abstract class View
{
	abstract void displayOptions();
	
	abstract void processOption(Scanner scanner,int choice);
	
	int selectOption(Scanner scanner, int maximum)
	{
		int choice;
		
		do
		{
			choice=0;
			
			while(choice<1||choice>maximum)
			{
				System.out.print("Please enter an option: ");
				choice=scanner.nextInt();
				
				if(choice<1||choice>maximum)
					System.out.println("Invalid option, please try again.");
			}
			
			processOption(scanner,choice);
		}while(choice!=maximum);
		return choice;
	}
}