import java.util.Vector;

import model.WedCloth;

public class WedClothManager
{
	private static Vector<WedCloth> wedClothes = new Vector<>();

	private static boolean addWedCloth(WedCloth wedCloth)
	{
		return wedClothes.add(wedCloth);
	}

	public static Vector<WedCloth> getWedClothes()
	{
		return new Vector <>(wedClothes);
	}

	public static Vector<WedCloth> getWedClothes(double maxRentalFee)
	{
		Vector<WedCloth> temp = new Vector<WedCloth>();
		
		for(WedCloth wedCloth : wedClothes)
			if(wedCloth.getRentalFee() <= maxRentalFee)
				temp.add(wedCloth);
		
		return temp;
	}
	
	
	public static Vector<WedCloth> getWedCothes(String color)
	{
		Vector<WedCloth> temp = new Vector<WedCloth>();
		
		for(WedCloth wedCloth : wedClothes)
		{
			if(wedCloth.getColor().toLowerCase().contains(color.toLowerCase()))
			{
				temp.add(WedCloth);
			}
		return temp;
	} 


	public static Vector<WedCloth> getWedCothes(String type)
	{
		Vector<WedCloth> temp = new Vector<WedCloth>();
		
		for(WedCloth wedCloth : wedClothes)
		{
			if(wedCloth.getType().toLowerCase().contains(color.toLowerCase()))
			{
				temp.add(WedCloth);
			}
		return temp;
	} 

	public static Vector<WedCloth> getWedCothes(String size)
	{
		Vector<WedCloth> temp = new Vector<WedCloth>();
		
		for(WedCloth wedCloth : wedClothes)
		{
			if(wedCloth.getSize().toLowerCase().contains(color.toLowerCase()))
			{
				temp.add(WedCloth);
			}
		return temp;
	}

	
	
	public static int updateWedCloth(WedCloth wedCloth)
	{
		/*int index=-1;
		for(int i=0;i<wedClothes.length;i++)
		{
			WedCloth temp=wedClothes[i];
			
			if (temp!=null && temp.getUniqueID()==wedCloth.getUniqueID())
			{
				wedClothes[i]=wedCloth;
				index=i;
				
				break;
			}
		}
		return index;*/
		return -1;
	}

	
	public static boolean deleteWedCloth(int clothID)
	{
		WedCloth wedCloth = null;
		
		for(WedCloth c : wedClothes)
		{
			if(c.getUniqueID() == clothID)
			{
				wedCloth = c;
				break;
			}
		}
		return wedClothes.remove(wedCloth);
	}

	@SuppressWarnings("unused")
	private static void displayWedCloth(WedCoth wedCloth)
	{
		System.out.println();
		System.out.println("Wedding Cloth ID: " + wedCloth.getUniqueID());
		System.out.println("Color " + wedCloth.getColor());
		System.out.println("Type: " + wedCoth.getType());
		System.out.println("Rental Fee: RM" + wedCloth.getRentalFee());
		System.out.println("Size: " + wedCoth.getSize());
	}
}

	