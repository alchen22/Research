package dataSet;

public class DataSetTester 
{

	
	public static void main(String[] args)
	{
		DataSet data = new DataSet(1); // single term dataset
		
		DataSet dat = new DataSet(); //empty set
		
		//addValues
		data.add(2);
		data.add(5);
		data.add(10);
		
		//get sum and average
		System.out.println(data.getSum());
		System.out.println(data.getAverage());
		
	}
}
