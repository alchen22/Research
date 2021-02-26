package artInProcessing;

import processing.core.PApplet;

public class Art extends PApplet
{
	public static void main(String[] args)
	{
		// argument is <package name>.class name>
		PApplet.main("artInProcessing.Art");
	}
	
	public void settings()
	{
		size(1000, 500);
	}
	
	public void setup()
	{
		
	}
	
	public void mouseClicked()
	{
		System.out.println(mouseX);
		System.out.println(mouseY);
	}
	public void draw()
	{
		fill(255, 255, 255);
		ellipse(479, 243, 220, 200);
		ellipse(354, 142, 120, 120);
		
		fill(0, 0, 0);
		ellipse(338, 123, 20, 20);
		
		fill(255, 152, 0);
		beginShape(TRIANGLES);
		vertex(300, 119);
		vertex(301, 170);
		vertex(256, 143);
		endShape();
		
		line(481, 340, 481, 389);
		line(481, 356, 450, 389);
		line(481, 356, 512, 389);
		
		fill(0, 128, 0);
		rect(0, 373, 1000, 373);
	}
}
