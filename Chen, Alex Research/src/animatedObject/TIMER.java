package animatedObject;

import processing.core.PApplet;

public class TIMER extends PApplet {
	
	double startTime = System.currentTimeMillis();
	double ElapsedTime;
	
	public static void main(String[] args) 
	{
		PApplet.main("animatedObject.TIMER");
	}

	public void settings()
	{
	size(1900, 750);
	}

	public void setup()
	{
	
	}

	public void draw()
	{
		
	}
			
	public void keyPressed() 
	{
	 if (key == CODED) 
	 	{
		   if (keyCode == UP) 
		   {
		    	println(millis() / 1000);
		   }
	 	}
	}
	
}