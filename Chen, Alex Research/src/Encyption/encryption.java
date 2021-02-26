package Encyption;

public class encryption {
	
	public static void main(String[] args)
	
	{
		encryption('y', 13);
	}
	
	public static char encryption(char Letter, int key)
	{
	
		int UniLetter = Letter + key;
		char ShiftedLetter = (char)UniLetter;
		
		if (UniLetter > 'z')
		{
		UniLetter = UniLetter - 26;
		ShiftedLetter = (char)UniLetter;
		System.out.println(ShiftedLetter);		
		return ShiftedLetter;
		}
		
		else
			System.out.println(ShiftedLetter);
		return ShiftedLetter;
	}
	
}
