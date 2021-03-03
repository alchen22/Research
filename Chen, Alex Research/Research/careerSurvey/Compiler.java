package careerSurvey;

import java.util.ArrayList;

public class Compiler 
{

	public static ArrayList<DataPoint> DataSet = new ArrayList<DataPoint>();
	public static DataSet dataSet;
	public static void main(String[] args)
	{
		fillDataSet();
		dataSet = new DataSet(DataSet);
		System.out.println(dataSet.getUniqueValues("studentField"));
		filteredPrinter("gender", "studentField", 0.0);
//		masterPrinter("gender", 0.2);
	}

	public static void fillDataSet()
	{
		DataSet.add(new DataPoint("Finance", "Masters", "Finance", "Masters", "Finance", "Above 200k", "Junior", "Female", false, "Asian", "Democrat", "A", "8to10", "Music", "Videogames", "Netflix", "Pagan", 8, 7, 4, 5, "Pop", 3, 3, 7));
		DataSet.add(new DataPoint("Health/Medical", "Bachelors", "Health/Medical", "Attended College, with less than 1 year of college credit", "Health/Medical", "Below 25k", "Junior", "Female", false, "Asian", "Democrat", "A", "2to4", "Music", "Videogames", "Netflix", "Agnostic", 7, 2, 2, 8, "Pop", 8, 7, 8));
		DataSet.add(new DataPoint("Aviation", "Bachelors", "Childcare", "Bachelors", "Education", "75to100k", "Junior", "Male", false, "White", "Apolitical", "A", "8to10", "Singing", "Netflix", "Hockey", "Presbyterian", 4, 3, 5, 6, "Rock", 1, 3, 2));
		DataSet.add(new DataPoint("Health/Medical", "Attended College, with less than 1 year of college credit", "Unemployed", "Bachelors", "Logistics", "Above 200k", "Junior", "Male", false, "White", "Independent", "A", "MoreThan16", "Videogames", "TimeWithFriends", "Sleeping", "Muslim", 4, 1, 2, 5, "Lo-fi", 5, 5, 5));
		DataSet.add(new DataPoint("Biological/Biomedical Science", "Masters", "Biological/Biomedical Science", "Professional", "Law", "Don't Know", "Junior", "Male", false, "White", "N/A", "A", "5to7", "Videogames", "TimeWithFriends", "ContentConsumption", "Catholic", 2, 4, 7, 7, "Rock", 7, 7, 7));
		DataSet.add(new DataPoint("Health/Medical", "Bachelors", "Finance", "Professional", "Health/Medical", "Above 200k", "Junior", "Male", false, "Asian", "Independent", "A", "5to7", "Tennis", "Videogames", "Learning", "Hindu", 7, 7, 7, 3, "Rhythm&Blues", 3, 3, 7));
		DataSet.add(new DataPoint("Law", "Bachelors", "Computer Science", "Bachelors", "Computer Science", "175to200k", "Junior", "Female", false, "White", "Democrat", "A", "2to4", "Skiing", "Basketball", "Baseball", "Jewish", 7, 3, 6, 7, "HipHop", 7, 9, 9));
		DataSet.add(new DataPoint("Math/Statistics", "Bachelors", "Journalism/Writing", "Doctorate", "Health/Medical", "Don't Know", "Junior", "Male", false, "White", "Democrat", "A", "MoreThan16", "Skiing", "Biking", "Basketball", "Protestant", 8, 3, 3, 7, "Pop", 7, 6, 8));
		DataSet.add(new DataPoint("Entrepreneurship", "Doctorate", "Health/Medical", "Doctorate", "Biological/Biomedical Science", "Above 200k", "Junior", "Male", false, "Asian", "Democrat", "A", "2to4", "Music", "Reading", "Running", "None", 3, 0, 2, 7, "Classical", 4, 6, 7));
		DataSet.add(new DataPoint("Health/Medical", "Masters", "Computer Science", "Masters", "Finance", "Don't Know", "Junior", "Male", false, "Asian", "Apolitical", "A", "8to10", "Videogames", "WorkingOut", "Sleeping", "None", 3, 4, 4, 5, "Rap", 4, 6, 7));
		DataSet.add(new DataPoint("Business Management", "Masters", "Human Resources", "Bachelors", "Unemployed", "Don't Know", "Junior", "Male", false, "White", "Apolitical", "A", "8to10", "Videogames", "Youtube", "Aviation", "None", 4, 1, 4, 5, "Classical", 5, 7, 8));
		DataSet.add(new DataPoint("Biological/Biomedical Science", "Bachelors", "Unemployed", "Masters", "Business Management", "Above 200k", "Junior", "Male", false, "Asian", "Democrat", "A", "5to7", "Videogames", "Music", "Exercise", "Agnostic", 9, 6, 2, 8, "Pop", 6, 9, 6));
		DataSet.add(new DataPoint("Journalism/Writing", "Bachelors", "Unemployed", "Professional", "Business Management", "150to175k", "Junior", "Male", false, "White", "Independent", "A", "5to7", "Writing", "Reading", "Singing", "None", 3, 0, 2, 5, "Rock", 6, 7, 8));
		DataSet.add(new DataPoint("Business Management", "Bachelors", "Finance", "Bachelors", "Finance", "Above 200k", "Junior", "Male", false, "White", "Democrat", "A", "5to7", "Videogames", "Hiking", "Skiing", "None", 3, 0, 5, 5, "EDM", 3, 3, 6));
		DataSet.add(new DataPoint("Law", "Professional", "Health/Medical", "Professional", "Law", "Above 200k", "Senior", "Female", false, "Asian", "Democrat", "A", "5to7", "Netflix", "Reading", "Hiking", "Hindu", 6, 5, 4, 5, "Rhythm&Blues", 4, 1, 8));
		DataSet.add(new DataPoint("Political Science", "Masters", "Health/Medical", "Masters", "Law", "Don't Know", "Senior", "Female", false, "White", "Independent", "A", "2to4", "Netflix", "Tiktok", "Reading", "Jewish", 4, 3, 1, 9, "Country", 9, 7, 7));
		DataSet.add(new DataPoint("Health/Medical", "Bachelors", "Business Management", "Bachelors", "Finance", "Above 200k", "Junior", "Male", false, "Asian", "Democrat", "A", "2to4", "Singing", "Television", "HelpingOthers", "Hindu", 9, 2, 5, 6, "Pop", 10, 6, 8));
		DataSet.add(new DataPoint("Law", "Doctorate", "Health/Medical", "Doctorate", "Health/Medical", "Above 200k", "Senior", "Female", false, "Asian", "Democrat", "A", "2to4", "Art", "Acting", "Reading", "Christian", 8, 3, 2, 7, "Pop", 5, 3, 6));
		DataSet.add(new DataPoint("Finance", "Doctorate", "Education", "Doctorate", "Health/Medical", "Above 200k", "Junior", "Male", false, "White", "Independent", "A", "2to4", "Skiing", "WorkingOut", "Netflix", "None", 7, 3, 2, 7, "Rap", 6, 8, 8));
		DataSet.add(new DataPoint("Biological/Biomedical Science", "Masters", "Health/Medical", "1 or more years of college credit, no degree", "Health/Medical", "Don't Know", "Junior", "Female", false, "White", "Independent", "A", "2to4", "Skiing", "Lacrosse", "Soccer", "None", 6, 3, 3, 7, "Rap", 7, 6, 9));
		DataSet.add(new DataPoint("Psychology", "Masters", "Music", "Masters", "Business Management", "Above 200k", "Junior", "Female", false, "White", "Democrat", "A", "8to10", "Running", "Yoga", "Hiking", "None", 7, 4, 1, 7, "Rap", 5, 7, 8));
		DataSet.add(new DataPoint("Psychology", "Associates", "Health/Medical", "Doctorate", "Education", "Don't Know", "Junior", "Female", false, "White", "Independent", "A", "2to4", "Netflix", "Running", "TimeWithFriends", "Christian", 3, 3, 3, 10, "Everything", 3, 3, 4));
		DataSet.add(new DataPoint("Health/Medical", "Bachelors", "Education", "Doctorate", "Law", "Don't Know", "Junior", "Female", false, "White", "N/A", "A", "5to7", "Sports", "Netflix", "Dancing", "None", 8, 2, 1, 7, "Rap", 8, 7, 8));
		DataSet.add(new DataPoint("Finance", "Bachelors", "Education", "Bachelors", "Law", "Don't Know", "Senior", "Female", false, "White", "Independent", "A", "11to13", "None", "None", "None", "None", 7, 2, 0, 8, "Country", 9, 9, 8));
		DataSet.add(new DataPoint("Journalism/Writing", "Bachelors", "Bookstore Worker", "Masters", "Marketing", "Don't Know", "Junior", "Male", false, "White", "Independent", "A", "5to7", "Television", "Sports", "Videogames", "Christian", 4, 3, 7, 7, "Pop", 7, 6, 8));
		DataSet.add(new DataPoint("Law", "Professional", "Social Worker", "Doctorate", "Education", "Above 200k", "Senior", "Female", false, "White", "Democrat", "A", "5to7", "Traveling", "TimeWithFriends", "Singing", "Jewish", 8, 5, 2, 7, "Pop", 7, 5, 8));
		DataSet.add(new DataPoint("Education", "1 or more years of college credit, no degree", "Real Estate", "Professional", "Law", "100to125k", "Junior", "Female", true, "White", "Independent", "B", "2to4", "Videogames", "Crochet", "Writing", "Catholic", 2, 3, 5, 6, "Rock", 4, 3, 3));
		DataSet.add(new DataPoint("Math/Statistics", "Doctorate", "Education", "1 or more years of college credit, no degree", "Retail", "Above 200k", "Senior", "Male", false, "White", "Democrat", "A", "2to4", "Videogames", "Tennis", "Running", "None", 3, 0, 4, 7, "Pop", 8, 7, 10));
		DataSet.add(new DataPoint("Computer Science", "Masters", "Computer Science", "Masters", "Engineering", "Above 200k", "Junior", "Female", false, "White", "Independent", "A", "8to10", "Running", "Piano", "Baking", "None", 4, 1, 0, 6, "Rock", 6, 6, 9));
		DataSet.add(new DataPoint("Business Management", "Bachelors", "N/A", "Bachelors", "N/A", "Don't Know", "Junior", "Female", false, "White", "Republican", "A", "5to7", "Lacrosse", "Art", "Television", "Catholic", 7, 4, 2, 7, "Rap", 6, 6, 5));
		DataSet.add(new DataPoint("Health/Medical", "Graduated High School", "N/A", "Graduated High School", "Business Management", "Don't Know", "Junior", "Female", false, "White", "Apolitical", "A", "14to16", "Soccer", "TimeWithFriends", "Biking", "Muslim", 9, 6, 6, 6, "Rap", 5, 1, 6));
		DataSet.add(new DataPoint("Finance", "1 or more years of college credit, no degree", "N/A", "Graduated High School", "Entrepreneurship", "Above 200k", "Senior", "Male", false, "White", "Democrat", "A", "8to10", "Stocks", "Lacrosse", "Surfing", "Muslim", 6, 2, 2, 7, "Everything", 8, 8, 8));
		DataSet.add(new DataPoint("Finance", "Professional", "Health/Medical", "Professional", "Finance", "Above 200k", "Senior", "Male", false, "White", "Republican", "A", "5to7", "Sports", "TimeWithFriends", "Netflix", "Catholic", 4, 4, 1, 7, "Country", 9, 10, 8));
		DataSet.add(new DataPoint("Health/Medical", "Masters", "Health/Medical", "Bachelors", "Engineering", "Above 200k", "Senior", "Male", false, "White", "Apolitical", "B", "8to10", "Golf", "WorkingOut", "Vibing", "Pagan", 7, 3, 6, 5, "Rock", 6, 10, 7));
		DataSet.add(new DataPoint("Finance", "Bachelors", "Insurance", "Masters", "Finance", "Above 200k", "Senior", "Male", false, "White", "Republican", "A", "2to4", "WorkingOut", "Stocks", "Tennis", "Catholic", 9, 3, 0, 6, "EDM", 5, 8, 7));
		DataSet.add(new DataPoint("Social Sciences", "Bachelors", "Unemployed", "Bachelors", "Entrepreneurship", "Don't Know", "Senior", "Female", false, "White", "Democrat", "A", "5to7", "Running", "Music", "Hiking", "None", 9, 2, 0, 7, "Rhythm&Blues", 9, 7, 7));
		DataSet.add(new DataPoint("Biological/Biomedical Science", "Bachelors", "Education", "Associates", "Law", "Above 200k", "Junior", "Female", false, "White", "Republican", "A", "5to7", "Hiking", "Reading", "Videogames", "Catholic", 6, 5, 4, 7, "None", 7, 4, 8));
		DataSet.add(new DataPoint("Health/Medical", "Bachelors", "Marketing", "Bachelors", "Self-Employed", "125to150k", "Junior", "Female", false, "White", "Independent", "A", "8to10", "Netflix", "Shopping", "Soccer", "Catholic", 7, 5, 4, 7, "Pop", 7, 5, 7));
		DataSet.add(new DataPoint("Computer Science", "Masters", "Marketing", "Masters", "N/A", "Don't Know", "Senior", "Male", false, "White", "Democrat", "A", "2to4", "Music", "Singing", "Reading", "None", 4, 3, 3, 7, "Pop", 7, 7, 5));
		DataSet.add(new DataPoint("Finance", "Bachelors", "Finance", "Bachelors", "Finance", "Don't Know", "Junior", "Female", false, "White", "Republican", "A", "2to4", "Dancing", "Baking", "TimeWithFriends", "Catholic", 5, 3, 1, 7, "Pop", 5, 5, 6));
		DataSet.add(new DataPoint("Health/Medical", "Doctorate", "Health/Medical", "Doctorate", "Health/Medical", "Above 200k", "Junior", "Female", false, "White", "Independent", "A", "5to7", "Tennis", "TimeWithFriends", "Netflix", "Jewish", 4, 3, 2, 8, "Pop", 7, 7, 6));
		DataSet.add(new DataPoint("Biological/Biomedical Science", "Masters", "Engineering", "Masters", "Computer Science", "Don't Know", "Senior", "Female", false, "N/A", "Independent", "A", "2to4", "Hiking", "Reading", "Netflix", "Atheist", 2, 1, 4, 6, "EDM", 3, 5, 3));
		DataSet.add(new DataPoint("Math/Statistics", "Masters", "Finance", "Bachelors", "Finance", "Don't Know", "Junior", "Female", false, "Asian", "Independent", "A", "5to7", "Art", "Music", "Netflix", "Catholic", 7, 1, 4, 8, "Rhythm&Blues", 6, 7, 9));
		DataSet.add(new DataPoint("Film Studies", "Bachelors", "Cinematography", "Masters", "Finance", "25to50k", "Junior", "Female", false, "White", "Independent", "A", "2to4", "Art", "Guitar", "ContentConsumption", "None", 5, 4, 7, 7, "Pop", 3, 9, 7));
		DataSet.add(new DataPoint("Education", "Masters", "Computer Science", "Masters", "Engineering", "Don't Know", "Senior", "Female", true, "White", "Independent", "A", "2to4", "Dancing", "Art", "Reading", "Catholic", 4, 4, 3, 7, "Pop", 8, 4, 6));
		DataSet.add(new DataPoint("Economics", "Masters", "Education", "Bachelors", "Finance", "Above 200k", "Senior", "Male", false, "White", "Republican", "A", "2to4", "Videogames", "ContentConsumption", "Running", "Baptist", 2, 0, 7, 5, "HeavyMetal", 5, 5, 8));
		DataSet.add(new DataPoint("Journalism/Writing", "Masters", "Biological/Biomedical Science", "Masters", "Education", "Don't Know", "Junior", "Female", false, "White", "Democrat", "A", "2to4", "Swim", "Writing", "Tiktok", "Christian", 8, 7, 4, 5, "Pop", 7, 5, 5));
		DataSet.add(new DataPoint("Engineering", "Bachelors", "Education", "Bachelors", "Marketing", "Don't Know", "Senior", "Male", false, "White", "Republican", "A", "11to13", "Lacrosse", "Football", "Piano", "Catholic", 7, 1, 2, 7, "Rock", 8, 8, 8));
		DataSet.add(new DataPoint("Health/Medical", "Associates", "Computer Science", "Bachelors", "Health/Medical", "150to175k", "Junior", "Female", false, "White", "Democrat", "A", "2to4", "Music", "ContentConsumption", "Baking", "Atheist", 3, 3, 4, 5, "Alternative", 4, 3, 8));
		DataSet.add(new DataPoint("Engineering", "Bachelors", "N/A", "Masters", "Engineering", "Don't Know", "Senior", "Male", false, "White", "Independent", "A", "2to4", "None", "None", "None", "None", 7, 1, 2, 8, "Pop", 7, 7, 9));
		DataSet.add(new DataPoint("Engineering", "Masters", "Health/Medical", "Masters", "Law", "Don't Know", "Senior", "Female", false, "White", "Independent", "A", "8to10", "None", "None", "None", "None", 4, 2, 2, 7, "Pop", 9, 8, 8));
		DataSet.add(new DataPoint("International Affairs", "Masters", "Health/Medical", "Bachelors", "Engineering", "Above 200k", "Junior", "Female", false, "White", "Independent", "A", "2to4", "Netflix", "Tiktok", "Reading", "Jewish", 4, 3, 1, 9, "Country", 9, 7, 7));
		DataSet.add(new DataPoint("Finance", "Associates", "Marketing", "Bachelors", "Finance", "Don't Know", "Junior", "Male", false, "White", "Republican", "A", "8to10", "Sports", "Videogames", "Youtube", "Catholic", 7, 2, 3, 7, "Country", 8, 7, 9));
		DataSet.add(new DataPoint("Computer Science", "Masters", "Health/Medical", "Doctorate", "Health/Medical", "Don't Know", "Junior", "Female", false, "White", "Democrat", "A", "8to10", "WorkingOut", "Netflix", "Reading", "Christian", 8, 4, 2, 7, "Pop", 7, 6, 7));
		DataSet.add(new DataPoint("Finance", "Bachelors", "Unemployed", "Masters", "Engineering", "100to125k", "Senior", "Female", true, "White", "Independent", "B", "Below2", "TimeWithFriends", "Skating", "Netflix", "None", 8, 3, 2, 6, "Rap", 5, 5, 5));
		DataSet.add(new DataPoint("Engineering", "Bachelors", "Au Pair Counselor", "Masters", "Computer Science", "Above 200k", "Junior", "Male", false, "White", "Republican", "A", "5to7", "Sports", "Videogames", "Chess", "Catholic", 9, 2, 2, 8, "Rap", 7, 7, 8));
		DataSet.add(new DataPoint("Finance", "Bachelors", "Finance", "Bachelors", "Headhunter", "Above 200k", "Junior", "Male", false, "White", "Democrat", "A", "5to7", "Drums", "Sports", "Netflix", "Jewish", 8, 3, 2, 7, "EDM", 8, 7, 9));
		DataSet.add(new DataPoint("Psychology", "Masters", "Finance", "Masters", "Warehouse Management", "Above 200k", "Junior", "Male", false, "Asian", "Independent", "B", "2to4", "Chess", "Videogames", "Walking", "Hindu", 5, 2, 4, 8, "Rap", 8, 3, 5));
		DataSet.add(new DataPoint("Finance", "Associates", "Finance", "Masters", "Education", "Above 200k", "Senior", "Female", false, "White", "Independent", "A", "MoreThan16", "Sports", "Music", "TimeWithFriends", "Catholic", 8, 7, 5, 7, "Rock", 9, 9, 9));
		DataSet.add(new DataPoint("Biological/Biomedical Science", "Masters", "Marketing", "Masters", "Computer Science", "Don't Know", "Junior", "Female", false, "Asian", "None", "A", "8to10", "ContentConsumption", "Art", "Baking", "Christian", 6, 2, 4, 8, "Pop", 8, 5, 5));
		DataSet.add(new DataPoint("Law", "Associates", "Real Estate", "Bachelors", "Engineering", "Don't Know", "Junior", "Female", true, "White", "Democrat", "A", "5to7", "Reading", "ContentConsumption", "TimeWithFriends", "Catholic", 4, 4, 2, 8, "Rap", 9, 7, 5));
		DataSet.add(new DataPoint("Business Management", "Bachelors", "Interior Design", "Masters", "Business Management", "Above 200k", "Senior", "Female", false, "White", "Independent", "A", "5to7", "Sewing", "Art", "Running", "None", 8, 4, 4, 8, "Rap", 3, 7, 8));
		DataSet.add(new DataPoint("Law", "Professional", "Law", "Professional", "Law", "Above 200k", "Junior", "Female", false, "White", "Independent", "A", "5to7", "Sports", "TimeWithFriends", "Netflix", "Jewish", 8, 2, 3, 8, "Pop", 8, 7, 8));
		DataSet.add(new DataPoint("Health/Medical", "Bachelors", "Logistics", "Graduated High School", "Business Management", "Don't Know", "Junior", "Female", true, "White", "Independent", "A", "5to7", "Volleyball", "Reading", "Netflix", "Catholic", 7, 2, 3, 6, "Pop", 8, 8, 8));
	}

	public static void filteredPrinter(String pFactor, String sFactor, double threshold)
	{
		ArrayList<FactorDistribution> currentDistro = dataSet.twoVariableAnalysis(pFactor, sFactor); //TWO VARIABLES
		String toPrint = "";
		for(FactorDistribution f: currentDistro)
		{
			toPrint += "___________________________________\n" + "Given " + pFactor + ": " + f.masterFactor + "\n _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n"  + sFactor + " probabilities:" + "\n";
			for(int i = 0; i < f.factors.size(); i++)
			{
				String factorName = f.factors.get(i).getID();
				double x = f.factors.get(i).getCount();
				int populationSize = 0;
				for(Factor F : f.factors)
				{
					populationSize += F.getCount();
				}
				x = x/(double) populationSize;
				if(x > threshold)
				{
					toPrint += factorName + ": " + x + "\n";
				}
			}
		}
		System.out.println(toPrint);
	}

	public static void masterPrinter(String primaryFactor, double threshold)
	{
		for(int j = 0; j <= 22; j++)
		{
			if(!(primaryFactor.equals(getVariableCode(j))))
			{
				System.out.println(":::::::::::::::::::::::::::::::::::::");
				filteredPrinter(primaryFactor, getVariableCode(j), threshold);
			}
		}
	}

	public static String getVariableCode(int x)
	{
		String returnable = "";
		if(x == 0)
			returnable = "studentField";
		if(x == 1)
			returnable = "motherEducation";
		if(x == 2)
			returnable = "motherField";
		if(x == 3)
			returnable = "fatherEducation";
		if(x == 4)
			returnable = "fatherField";
		if(x == 5)
			returnable = "incomeRange";
		if(x == 6)
			returnable = "gradeLevel";
		if(x == 7)
			returnable = "gender";
		if(x == 8)
			returnable = "isHispanicLatino";
		if(x == 9)
			returnable = "ethnicity";
		if(x == 10)
			returnable = "politicalAffiliation";
		if(x == 11)
			returnable = "averageGrades";
		if(x == 12)
			returnable = "friendGroupSize";
		if(x == 13)
			returnable = "hobbies";
		if(x == 14)
			returnable = "religion";
		if(x == 15)
			returnable = "introExtroversion";
		if(x == 16)
			returnable = "socialMediaHrs";
		if(x == 17)
			returnable = "contentConsumptionHrs";
		if(x == 18)
			returnable = "sleepHrs";
		if(x == 19)
			returnable = "musicGenre";
		if(x == 20)
			returnable = "happiness";
		if(x == 21)
			returnable = "appearanceConfidence";
		if(x == 22)
			returnable = "intelligence";
		return returnable;
	}

}
