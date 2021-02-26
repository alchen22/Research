package animatedObject;

import java.util.ArrayList;

import processing.core.PApplet;

public class Ball 
{
	private PApplet parent;
	private int size;
	private int posX = 0, posY = 0;
	private int ydirection, xdirection, r, g, b;
	
	public Ball(PApplet p, int x, int y,  int trueSize, int xdirect, int ydirect, int red, int green, int blue)
	{
		parent = p;
		posX = x;
		posY = y;
		size = trueSize;
		xdirection = xdirect;
		ydirection = ydirect;
		r = red;
		g = green;
		b = blue;
		

	}
	
	public void drawSelf(PApplet p)
	{
		parent.fill(r, g, b);
		parent.ellipse(posX, posY, size, size);
	}
	
	public void bounceBall()
	{
	
		if (posX <= size / 2 || posX >= 2000 - size / 2)
		{
			xdirection *= -1;
		}
		
		if (posY <= size / 2 || posY >= 1000 - size / 2)
		{
			ydirection *= -1;
		}
		
		posX = posX + xdirection;
		posY = posY + ydirection;
		
		parent.fill(r, g, b);
		parent.ellipse(posX, posY, size, size);
	}
	
	public int getRadius()
	{
		return size / 2;
	}
	
	public int getY()
	{
		return posY;
	}

	public int getX() 
	{
		return posX;
	}
	
	public void movePowerShape()
	{
		if (posX <= size / 2 || posX >= 2000 - size / 2)
		{
			xdirection *= -1;
		}
		
		if (posY <= size / 2 || posY >= 1000 - size / 2)
		{
			ydirection *= -1;
		}
		
		posX = posX + xdirection;
		posY = posY + ydirection;
	}
	
	private static double getDistance(int xone, int yone, int xtwo, int ytwo)
	{
		double xdistance = xone - xtwo;
		double ydistance = yone - ytwo;
		
		xdistance = xdistance * xdistance;
		ydistance = ydistance * ydistance;
		
		double totaldistance = xdistance + ydistance;
		totaldistance = Math.sqrt(totaldistance);
		return totaldistance;
		
	}
	
	public boolean ballCollision(Ball otherBall)
	{
		if(getDistance(posX, posY, otherBall.getX(), otherBall.getY()) < (size / 2) + otherBall.getRadius())
		{
			return true;
		}
		else 
			
			return false;
	}

	

}
