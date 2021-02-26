package mattPackage;

public class PackageofMatt 
{
	public void correctMove(int playerCard, int dealerCard)
	{
		if (dealerCard <= 8)
		{
			System.out.println("HIT");
		}
		
		if (dealerCard == 9)
		{
			if(playerCard >= 3 && playerCard <= 6)
			{
				System.out.println("Double");
			}
			
			else
			{
				System.out.println("Hit");
			}
		}
		
		if (dealerCard == 10)
		{
			if(playerCard >= 2 && playerCard <= 10)
			{
				System.out.println("Double");
			}
			
			else
			{
				System.out.println("Hit");
			}
		}
		
		if (dealerCard == 11)
		{
			if(playerCard >= 3 && playerCard <= 6)
			{
				System.out.println("Double");
			}
			
			else
			{
				System.out.println("Hit");
			}
		}
	}

}
