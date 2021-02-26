package employeeClass;

public class Employee
{
	
	private String name, department, position;
	private int idNumber;
	
	
	public Employee()
	{
		name = "";
		department = "";
		position = "";
		idNumber = 0;		
	}

	//mutator methods
	public String changeName(String namex)
	{
		name = namex;
		return name;
	}
	
	public int changeID(int newID)
	{
		idNumber = newID;
		return idNumber;
	}
	
	public String changeDepo(String newDepo)
	{
		department = newDepo;
		return department;
	}
	
	public String changePos(String newPos)
	{
		position = newPos;
		return position;
	}
	
	//accessors
	
	public String getName()
	{
		return name;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public String getPosition()
	{
		return position;
	}
	
	public int getID()
	{
		return idNumber;
	}
	
	public String toString()
	{
		System.out.println(name + " " + idNumber + " " + position + " " + department);
		return "";
	}
	
	
}
