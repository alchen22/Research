package careerSurvey;

import java.util.ArrayList;

public class DataSet 
{
	ArrayList<DataPoint> DataSet;

	public DataSet(ArrayList<DataPoint> DataSet)
	{
		this.DataSet = DataSet;
	}

	public ArrayList<String> getUniqueValues(String selector)
	{
		ArrayList<String> returnable = new ArrayList<String>();
		if(!selector.equals("hobbies"))
		{
			ArrayList recordedValues = new ArrayList<String>();

			for(int i = 0; i < DataSet.size(); i++)
			{
				String s = DataSet.get(i).getVariable(selector);
				if(!recordedValues.contains(s))
				{
					recordedValues.add(s);
				}
			}
			returnable = recordedValues;
		}

		else
		{
			ArrayList uniqueHobbies = new ArrayList<String>();

			for(int i = 0; i < DataSet.size(); i++)
			{
				String[] pointHobbies = DataSet.get(i).getHobbies();
				for(int j = 0; j <= 2; j++)
				{
					String hobby = pointHobbies[j];
					if(!uniqueHobbies.contains(hobby))
					{
						uniqueHobbies.add(hobby);
					}
				}
			}

			returnable = uniqueHobbies;
		}
		return returnable;

	}
	
	//cycle through list of primary factors.
	//given each primary factor "A", construct arraylist<factor> of secondary factors
	//cycle through dataset. if point primary factor matches cycled arraylist primary factor, store its secondary factor value in a string.
	//cycle through arraylist of secondary factors. if the secondary factor in the arraylist matches the stored string, addCount to matched factor in the arraylist.
	//once everything is done, store arraylist<factor> as new factordistribution.
	//BREAKS UPON TWO OF THE SAME VARIABLE!
	public ArrayList<FactorDistribution> twoVariableAnalysis(String primaryFactor, String secondaryFactor)
	{
		ArrayList<FactorDistribution> returnable = new ArrayList<FactorDistribution>();
		if(primaryFactor.equals("hobbies") && !secondaryFactor.equals("hobbies"))
		{
			returnable = twoVariableAnalysisPrimaryHobbyExtension(primaryFactor, secondaryFactor);
		}

		else if(!primaryFactor.equals("hobbies") && secondaryFactor.equals("hobbies"))
		{
			returnable = twoVariableAnalysisSecondaryHobbyExtension(primaryFactor, secondaryFactor);
		}

		else
		{
			returnable = twoVariableAnalysisRegularAlgorithm(primaryFactor, secondaryFactor);
		}
		return returnable;
	}

	private ArrayList<Factor> uniqueStringArrayToFactorArray(ArrayList<String> uniqueValues)
	{
		ArrayList<Factor> uniqueFactorArray = new ArrayList<Factor>();
		for(String s : uniqueValues)
		{
			uniqueFactorArray.add(new Factor(s));
		}
		return uniqueFactorArray;
	}
	
	private ArrayList<FactorDistribution> twoVariableAnalysisPrimaryHobbyExtension(String primaryFactor, String secondaryFactor)
	{
		ArrayList<String> uniquePrimaryFactors = getUniqueValues(primaryFactor);
		ArrayList<FactorDistribution> masterDistribution = new ArrayList<FactorDistribution>();

		for(String pFactor : uniquePrimaryFactors)
		{
			ArrayList<Factor> secondaryFactors = uniqueStringArrayToFactorArray(getUniqueValues(secondaryFactor));
			for(DataPoint d : DataSet)
			{
				if(d.getHobbies()[0].equals(pFactor) || d.getHobbies()[1].equals(pFactor) || d.getHobbies()[2].equals(pFactor))
				{
					String tempSecondaryFactor = d.getVariable(secondaryFactor);
					for(Factor sFactor : secondaryFactors)
					{
						if(sFactor.getID().equals(tempSecondaryFactor))
						{
							sFactor.addCount();
						}
					}
				}
			}
			masterDistribution.add(new FactorDistribution(pFactor, secondaryFactors));
		}

		return masterDistribution;
	}
	
	private ArrayList<FactorDistribution> twoVariableAnalysisSecondaryHobbyExtension(String primaryFactor, String secondaryFactor)
	{
		ArrayList<String> uniquePrimaryFactors = getUniqueValues(primaryFactor);
		ArrayList<FactorDistribution> masterDistribution = new ArrayList<FactorDistribution>();

		for(String pFactor : uniquePrimaryFactors)
		{
			ArrayList<Factor> secondaryFactors = uniqueStringArrayToFactorArray(getUniqueValues(secondaryFactor));
			for(DataPoint d : DataSet)
			{
				if(d.getVariable(primaryFactor).equals(pFactor))
				{
					ArrayList<String> secondaryHobbyList = new ArrayList<String>();
					for(int i = 0; i <= 2; i++)
					{
						secondaryHobbyList.add(d.getHobbies()[i]);
					}


					for(Factor sFactor : secondaryFactors)
					{
						if(secondaryHobbyList.contains(sFactor.getID()))
						{
							sFactor.addCount();
						}
					}
				}
			}
			masterDistribution.add(new FactorDistribution(pFactor, secondaryFactors));
		}
		return masterDistribution;
	}
	
	private ArrayList<FactorDistribution> twoVariableAnalysisRegularAlgorithm(String primaryFactor, String secondaryFactor)
	{
		ArrayList<String> uniquePrimaryFactors = getUniqueValues(primaryFactor);
		ArrayList<FactorDistribution> masterDistribution = new ArrayList<FactorDistribution>();

		for(String pFactor : uniquePrimaryFactors)
		{
			ArrayList<Factor> secondaryFactors = uniqueStringArrayToFactorArray(getUniqueValues(secondaryFactor));
			for(DataPoint d : DataSet)
			{
				if(d.getVariable(primaryFactor).equals(pFactor))
				{
					String tempSecondaryFactor = d.getVariable(secondaryFactor);
					for(Factor sFactor : secondaryFactors)
					{
						if(sFactor.getID().equals(tempSecondaryFactor))
						{
							sFactor.addCount();
						}
					}
				}
			}
			masterDistribution.add(new FactorDistribution(pFactor, secondaryFactors));
		}
		return masterDistribution;
	}
	
	public int getSize()
	{
		return DataSet.size();
	}
}
