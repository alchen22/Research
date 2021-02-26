package careerSurvey;

import java.util.ArrayList;

public class FactorDistribution 
{
	public String masterFactor;
	public ArrayList<Factor> factors;
	
	public FactorDistribution(String m, ArrayList<Factor> f)
	{
		factors = f;
		masterFactor = m;
	}
	
	public String toString()
	{
		String factorsParse = "";
		for(Factor f : factors)
		{
			factorsParse += f.toString() + ":";
		}
		
		String returnable = masterFactor + ": " + factorsParse;

		return returnable;
	}
}
