package chess;

import processing.core.PApplet;

public class Tile 
{
	private int x, y;
	private boolean available;
	private PApplet parent;
	
	public Tile(PApplet p, int xx, int yy)
	{
		parent = p;
		x = xx;
		y = yy;
		available = true;
	}
	
	public boolean available()
	{
		return available;
	}
	
	public void drawSelf()
	{
		if(((x + y) / 100) % 2 == 0)
		{
			parent.fill(0);
			parent.rect(x, y, 100, 100);
		}
		
		else
		{
			parent.fill(256, 256, 256);
			parent.rect(x, y, 100, 100);	
		}
	}
	
	public void drawLight()
	{
		parent.fill(0, 150, 150);
		parent.rect(x, y, 100, 100);	
	}
	
	public void setAvailable()
	{
		available = true;
	}
	
	public void setUnavailable()
	{
		available = false;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}
