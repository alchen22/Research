package colllision;

import processing.core.PApplet;

public class BouncyBalls extends PApplet
{
	int xpos = 500;
	int xdirection = 5;
	int ypos = 250;
	int ydirection = 5;

	public static void main(String[] args)
	{
		PApplet.main("colllision.BouncyBalls");
	}
	
	public void settings()
	{
		size(1000, 500);
	}
	
	public void setup()
	{
		noStroke();
	}
	
	public void draw()
	{
		
		background(0);
		moveBall();
		fill(255, 255, 255);
		ellipse(xpos, ypos, 100, 100);
		
		fill(255, 255, 255);
		ellipse(100, 100, 100, 100);
		
		xpos = xpos + xdirection;
		ypos = ypos + ydirection;
		
		double circleDistance = getDistance(xpos, ypos, 100, 100);
		
		if(circleDistance < 100)
		{
			
		}
		
		
	}
	
	public void moveBall() 
	{
		if (xpos > 950 || xpos < 50) 
		{
		    xdirection *= -1;
		}
		if (ypos > 450 || ypos < 50) 
		{
		    ydirection *= -1;
		}
	}
	public static double getDistance(int firstxposition, int firstyposition, int secondxposition, int secondyposition)
	{
		int xdistance = firstxposition - secondxposition;
		int ydistance = firstyposition - secondyposition;
		
		xdistance = xdistance * xdistance;
		ydistance = ydistance * ydistance;
		
		double totaldistance = xdistance + ydistance;
		totaldistance = Math.sqrt(totaldistance);
		System.out.println(totaldistance);
		return totaldistance;
	}
}



