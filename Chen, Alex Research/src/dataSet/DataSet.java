package dataSet;

public class DataSet 
{
	private double sum = 0;
	private double termCounter = 0;
	
	public DataSet(double addInt)
	{
		sum = addInt;
		termCounter++;
	}
	
	public DataSet()
	{
		sum = 0;
	}
	
	public void add(double integer)
	{
		sum += integer;
		termCounter++;
	}
	
	public double getAverage()
	{
		return sum / termCounter;
	}
	
	public double getSum()
	{
		return sum;
	}
	
	
}
