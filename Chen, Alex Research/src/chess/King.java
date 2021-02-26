package chess;

import processing.core.PApplet;

public class King
{//color 1 = red, color 0 = green
	private int x, y, colour;
	private PApplet parent;
	
	public King(PApplet p, int xx, int yy, int color)
	{
		parent = p;
		x = xx;
		y = yy;
		colour = color;
	}
	
	public void drawSelf()
	{
		if (colour == 1)
		{
			parent.fill(256, 0, 0);
			parent.textSize(100);
			parent.text("K", x, y + 100);

			
		}
		
		if (colour == 0)
		{
			parent.fill(0, 256, 0);
			parent.textSize(100);
			parent.text("K", x, y + 100);

		}
		
	}
	
	public int convertCoordinatestoTileArrayPos(int xcoordinate, int ycoordinate)
	{
		return ((ycoordinate + (8 * xcoordinate)) / 100) - 9;
	}
	
	public void updateCoordinates(int xx, int yy)
	{
		x = xx;
		y = yy;
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