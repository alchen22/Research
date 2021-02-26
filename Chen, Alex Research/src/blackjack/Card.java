package blackjack;

public class Card
{
	private String[] suitPos = {"H", "D","S", "C"};
	private String[] numPos = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private String suit, number;

	public Card()
	{
		suit = suitPos[(int) (Math.random() * 4)];
		number = numPos[(int) (Math.random() * 13)];
	}

	public int getNumValue()
	{
		int value = 0;
		if(number.substring(0,1).equals("A"))
			value = 11;
		else if(isDouble(number)&&(!number.substring(0,1).equals("1")))
			value = (int) Double.parseDouble(number.substring(0,1));
		else
			value = 10;
		return value;
	}

		

	public String toString()
	{
		String card = (number + suit);
		return card;
	}

	public boolean isAce()
	{
		if(number.substring(0,1).equals("A"))
		{
			return true;
		}		

		else
		{
			return false;
		}
	}

	 private static boolean isDouble(String value)
	    {
	        try
	        {
	            Double.parseDouble(value);
	        }
	        catch(NumberFormatException e)
	        {
	            return false;
	        }
	        
	        return true;
	    }
}

