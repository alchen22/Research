package careerSurvey;

public class Factor
{
	private int counter;
	private String factorID;
	
	public Factor(String factorID)
	{
		this.factorID = factorID;
		counter = 0;
	}
	
	public void addCount()
	{
		counter++;
	}
	
	public String getID()
	{
		return factorID;
	}
	
	public int getCount()
	{
		return counter;
	}
	
	public String toString()
	{
		return factorID + " with " + counter + " entries";
	}

}
