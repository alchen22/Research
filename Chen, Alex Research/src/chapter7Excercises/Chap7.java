package chapter7Excercises;

import java.util.Scanner;

public class Chap7 
{
	
	public static void main(String[] args) 
	{

	}
	
	public void multipleChoice()
	{
		//2: subscript
		//3: 0
		//4: 1 less than the number of elements
		//5: when the program runs
		//6: length
		//16: false
		//17: true
		//19: true
		//20: true
		//21: true
	}
	
	public void fixTheError()
	{
//	the length parameter is negative
//	missing brackets
//	the for method will run 11 times, which is outside of the array's parameters
//	the first time it adds up
//	the parameters should be set to <=, or else it only runs one time, and will only add up the first term of the array.
//	You cannot instantly convert the entire array, however, you can do it one term at a time
	}
	
	public void shortAnswer()
	{
//	SA 3		
//		
//		a. 2
//		b. 14
//		c. 7
//		
//		
//	SA 5
//
//		each array has multiple terms, you cannot assign an entire array to another.

	}
	
	public static void AW1()
	{
		int []names = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		for (int i = 0; i <= 19; i++)
		{
			System.out.println(names[(i)]);
		}
	}
	
	public static void AW2()
	{
		int []array1 = new int[100], array2 = new int[100];
		for(int i = 0; i < 100; i++)
		{
			array2[i] = array1[i];
		}
	}
	
	public static void Rainfall()
	{
		double[]rainfall = new double[13];
		double totalRain = 0;
		double max = 0, min = 0;
		
		Scanner fromKeyboard = new Scanner(System.in);
		for (int i = 1; i <= 12; i++)
		{
		System.out.println("PLEASE ENTER RAINFALL FOR MONTH " + i);
		rainfall[i] = fromKeyboard.nextDouble();
		}
		
		for (int i = 1; i < 13; i++)
		{
		totalRain = totalRain + rainfall[i];
		}
		
		max = rainfall[1];
		min = rainfall[1];
		
		for (int i = 1; i < 13; i++)
		{
			if(max < rainfall[i])
			{
				max = rainfall[i];
			}
			
			if(min > rainfall[i])
			{
				min = rainfall[i];
			}
		}
		
		System.out.println("Total rain: " + totalRain);
		System.out.println("Average Rain: " + totalRain/12);
		System.out.println("Max rain: " + max);
		System.out.println("Minimum rain: " + min);
	
	}
	
	//PC 10 Array Operations
	
	public static int getTotal(int[] x)
	{
		int total = 0;
		for(int i = 0; i < x.length; i++)
		{
			total = total + x[i];
		}
		
		return total;
	}
	
	public static int getAverage(int[] x)
	{
		int total = 0;
		for(int i = 0; i < x.length; i++)
		{
			total = total + x[i];
		}
		
		return total/(x.length - 1);
	}
	
	public static int getMax(int[] x)
	{
		int max = x[0];
		for(int i = 0; i < x.length; i++)
		{
			if(max < x[i])
			{
				max = x[i];
			}
		}
		return max;
	}
	
	public static int getMin(int[] x)
	{
		int min = x[0];
		for(int i = 0; i < x.length; i++)
		{
			if(min > x[i])
			{
				min = x[i];
			}
		}
		return min;
	}
	
	public static int[] swapper(int[]x, int pos1, int pos2)
	{
		pos2--;
		pos1--;
		
		int newPos1 = x[pos2];
		int newPos2 = x[pos1];
		
		x[pos1] = newPos1;
		x[pos2] = newPos2;
		
		return x;	
	}
	
	public static int[] generator(int limit)
	{
			int[]x = new int[limit];
			for(int i = 0; i < limit; i++)
			{
				int random = (int)(Math.random() * 10);
				x[i] = random;
			}
			
			return x;
	}
}
