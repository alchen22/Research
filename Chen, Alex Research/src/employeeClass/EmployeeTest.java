package employeeClass;

import processing.core.PApplet;

public class EmployeeTest 
{
	
	public static void main(String[] args)
	{
		Employee Employee1 = new Employee();
		Employee Employee2 = new Employee();
		Employee Employee3 = new Employee();
		
		Employee1.changeName("Susan Meyers");
		Employee2.changeName("Mark Jones");
		Employee3.changeName("Joy Rogers");
		
		Employee1.changeDepo("Accounting");
		Employee2.changeDepo("IT");
		Employee3.changeDepo("Manufacturing");
		
		Employee1.changeID(47899);
		Employee2.changeID(39119);
		Employee3.changeID(81774);
		
		Employee1.changePos("Vice President");
		Employee2.changePos("Programmer");
		Employee3.changePos("Engineer");
		
		System.out.println(Employee1);
		System.out.println(Employee2);
		System.out.println(Employee3);


		
		
		
		
		

		
	}
	
}
