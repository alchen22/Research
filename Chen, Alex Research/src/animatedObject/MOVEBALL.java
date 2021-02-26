package animatedObject;

import processing.core.PApplet;

public class MOVEBALL extends PApplet
{
	int posx = 50;
	int posy = 50;
	public static void main(String[] args) 
	{
		PApplet.main("animatedObject.MOVEBALL");
	}
	
	public void settings()
	{
		size(500, 500);
	}
	
	public void setup()
	{
		
	}
	
	public void draw()
	{
		background(0);
		ellipse(posx, posy, 100, 100);
	}
	
	public void keyPressed() 
	{
	 if (key == CODED) 
	 	{
		   if (keyCode == UP) 
		   {
		    	posy -= 10;
		   }
		   else if (keyCode == DOWN) 
		   {
		    	posy += 10;
		   }
		   else if (keyCode == LEFT) 
		   {
		    	posx -= 10;
		   }
		   else if (keyCode == RIGHT) 
		   {
		    	posx += 10;
		   }
		}	    
	}
}

