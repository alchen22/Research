package chess;

import java.util.ArrayList;
import processing.core.PApplet;

public class Rook
{//color 1 = black, color 0 = green
	private int x, y, colour;
	private PApplet parent;

	
	public Rook(PApplet p, int xx, int yy, int color)
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
			parent.text("R", x, y + 100);

			
		}
		
		if (colour == 0)
		{
			parent.fill(0, 256, 0);
			parent.textSize(100);
			parent.text("R", x, y + 100);

		}
		
	}
	
	public ArrayList<Integer> returnPossibleTiles()
	{
		
		ArrayList<Integer> possibleTiles = new ArrayList<Integer>();

		for(int i = 1; i <= 8; i++)
		{
			if(i * 100 != y)
			{
				possibleTiles.add(convertCoordinatestoTileArrayPos(x, i * 100));
			}
		}
		
		for(int i = 1; i <= 8; i++)
		{
			if(i * 100 != x)
			{
				possibleTiles.add(convertCoordinatestoTileArrayPos(i * 100, y));
			}
		}	
		
		return possibleTiles;
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