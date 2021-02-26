package clicky;

import processing.core.PApplet;

public class Cluckyshape extends PApplet

{
	public static void main(String[] args) 

	{
		PApplet.main("clicky.Cluckyshape");

	}

	public void settings() 
	{
		size(1000, 1000);
	}

	public void setup() 
	{
		

	}
	
	public void mouseClicked() 
	{
		if (mouseX >= 250 && mouseX <= 750 && mouseY >= 250 && mouseY <= 750)
		{
			System.out.println("Cluck");
		}
		
			
		else 
		{
			System.out.println("Bok Bok");
		}
	}

	public void draw() 
	{
		fill(255, 255, 255);
		rect(250, 250, 500, 500);
		
		fill(0);
		ellipse(400, 400, 10, 10);
		ellipse(600, 400, 10, 10);
		
		fill(255, 144, 0);
		triangle(400, 550, 600, 550, 500, 650);
	}
}
