package seven13Excercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Excercises
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner fromFile = new Scanner(new File("data/nums.txt"));
		
		while(fromFile.hasNextLine())
		{
			int nums = fromFile.nextInt();
			fromFile.nextLine(); // eat end of line
			numbers.add(new Integer(nums));
		}
		
		fromFile.close();
		
		//PC 11
		System.out.println("Max number in file: " + getMax(numbers));
		System.out.println("Least number in file: " + getMin(numbers));
		System.out.println("Total sum of numbers in file: " + getTotal(numbers));
		System.out.println("Average of numbers in file: " + getAverage(numbers));
		
		//AW11
		
		System.out.println("");
		ArrayCars();
		
		//Multiple Choice
//		11. add
//		12. add
//		13. remove
//		14. size


		
	}
	
	//PC 11
	
	public static int getMax(ArrayList<Integer> x)
	{
		int max = x.get(0);
		for(int i = 0; i < x.size(); i++)
		{
			if(max < x.get(i))
			{
				max = x.get(i);
			}
		}
		return max;
	}
	
	public static int getMin(ArrayList<Integer> x)
	{
		int min = x.get(0);
		for(int i = 0; i < x.size(); i++)
		{
			if(min > x.get(i))
			{
				min = x.get(i);
			}
		}
		return min;
	}
	
	public static int getTotal(ArrayList<Integer> x)
	{
		int total = 0;
		for(int i = 0; i < x.size(); i++)
		{
			total = total + x.get(i);
		}
		
		return total;
	}
	
	public static int getAverage(ArrayList<Integer> x)
	{
		int total = 0;
		for(int i = 0; i < x.size(); i++)
		{
			total = total + x.get(i);
		}
		
		return total/(x.size() - 1);
	}
	
	//AW 11
	
	public static void ArrayCars()
	{
		ArrayList<String> Cars= new ArrayList<String>();
		Cars.add("Henry");
		Cars.add("Julia");
		Cars.add("Gordon");
		
		System.out.println(Cars);
	}

}