package careerSurvey;

public class DataPoint 
{
	public String isHispanicLatino, introExtroversion, socialMediaHrs, contentConsumptionHrs, sleepHrs, happiness, appearanceConfidence, intelligence, studentField, motherEducation, motherField, fatherEducation, fatherField, gender, ethnicity, politicalAffiliation, averageGrades, religion, musicGenre, friendGroupSize, gradeLevel, incomeRange;
	public String[] hobbies;
	
	public DataPoint(String studentField, String motherEducation, String motherField, String fatherEducation, String fatherField, String incomeRange, String gradeLevel, String gender, boolean isHispanicLatino, String ethnicity, String politicalAffiliation, String averageGrades, String friendGroupSize, String hobbyOne, String hobbyTwo, String hobbyThree, String religion, int introExtroversion, int socialMediaHrs, int contentConsumptionHrs, int sleepHrs, String musicGenre, int happiness, int appearanceConfidence, int intelligence)
	{
		this.studentField = studentField;
		this.motherEducation = motherEducation;
		this.motherField = motherField;
		this.fatherEducation = fatherEducation;
		this.fatherField = fatherField;
		this.incomeRange = incomeRange;
		this.gradeLevel = gradeLevel;
		this.gender = gender;
		if(isHispanicLatino == true)
			this.isHispanicLatino = "Yes";
		else
			this.isHispanicLatino = "No";
		this.ethnicity = ethnicity;
		this.politicalAffiliation = politicalAffiliation;
		this.averageGrades = averageGrades;
		this.friendGroupSize = friendGroupSize;
		hobbies = alphabeticalHobbies(hobbyOne, hobbyTwo, hobbyThree);
		this.religion = religion;
		this.introExtroversion = Integer.toString(introExtroversion);
		if(socialMediaHrs != 0 && socialMediaHrs != 7)
			this.socialMediaHrs = Integer.toString(socialMediaHrs);
		else
		{
			if(socialMediaHrs == 0)
				this.socialMediaHrs = "Less than 1";
			else
				this.socialMediaHrs = "Greater than 6";
		}
		if(contentConsumptionHrs != 0 && contentConsumptionHrs != 7)
			this.contentConsumptionHrs = Integer.toString(contentConsumptionHrs);
		else
		{
			if(contentConsumptionHrs == 0)
				this.contentConsumptionHrs = "Less than 1";
			else
				this.contentConsumptionHrs = "Greater than 6";
		}
		this.sleepHrs = Integer.toString(sleepHrs);
		this.musicGenre = musicGenre;
		this.happiness = Integer.toString(happiness);
		this.appearanceConfidence = Integer.toString(appearanceConfidence);
		this.intelligence = Integer.toString(intelligence);
	}

	private String[] alphabeticalHobbies(String h1, String h2, String h3)
	{
		String[] s = new String[] {h1, h2, h3};
		String[] sortedS = new String[3];
		
		for(int i = 0; i <= 2; i++)
		{
			sortedS[i] = returnAndRemoveMinString(s);
		}
		return sortedS;
	}
	
	private String returnAndRemoveMinString(String[] s)
	{
		String min = "zzzzzzzzzzzzzzzzzzzzz";
		int minIndex = -1;
		for(int i = 0; i < s.length; i++)
		{
			if(s[i].compareTo(min) < 0)
			{
				min = s[i];
				minIndex = i;
			}
		}
		
		s[minIndex] = "zzzzzzzzzzzzzzzzzzzzz";
		return min;
	}
	
	public String[] getHobbies()
	{
		return hobbies;
	}
	
	public String getPrintableHobbies()
	{
		String returnable = "";
		for(int i = 0; i <= 2; i++)
		{
			returnable += hobbies[i];
			if(i != 2)
				returnable += " ";
		}
		return returnable;
	}
	
	public String getVariable(String selector)
	{
		if(selector.equals("introExtroversion"))
			return introExtroversion;
		if(selector.equals("isHispanicLatino"))
			return isHispanicLatino;
		if(selector.equals("socialMediaHrs"))
			return socialMediaHrs;
		if(selector.equals("contentConsumptionHrs"))
			return contentConsumptionHrs;
		if(selector.equals("sleepHrs"))
			return sleepHrs;
		if(selector.equals("happiness"))
			return happiness;
		if(selector.equals("appearanceConfidence"))
			return appearanceConfidence;
		if(selector.equals("intelligence"))
			return intelligence;
		if(selector.equals("studentField"))
			return studentField;
		if(selector.equals("motherEducation"))
			return motherEducation;
		if(selector.equals("motherField"))
			return motherField;
		if(selector.equals("fatherEducation"))
			return fatherEducation;
		if(selector.equals("fatherField"))
			return fatherField;
		if(selector.equals("gender"))
			return gender;
		if(selector.equals("ethnicity"))
			return ethnicity;
		if(selector.equals("politicalAffiliation"))
			return politicalAffiliation;
		if(selector.equals("averageGrades"))
			return averageGrades;
		if(selector.equals("religion"))
			return religion;
		if(selector.equals("musicGenre"))
			return musicGenre;
		if(selector.equals("friendGroupSize"))
			return friendGroupSize;
		if(selector.equals("gradeLevel"))
			return gradeLevel;
		if(selector.equals("incomeRange"))
			return incomeRange;
		return "invalid";
	}
}
