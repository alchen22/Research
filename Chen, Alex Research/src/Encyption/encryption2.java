package Encyption;

public class encryption2 {
	
	
	public static void main(String[] args)
	{
		String str = "henry";    //enter stuff
		int stringPos = 0;
		
		while(stringPos < str.length())
		{
			stringPos += 1;
			char PositionedLet = str.charAt(stringPos - 1);
			
			encryption(PositionedLet, 3);     //enter stuff
		}
		
	}
	
	//encrypt 1 letter at position stringPos
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
