package animatedObject;

import processing.core.PApplet;

public class AnimatedObject extends PApplet {
	
	int radius = 50;
	float xpos, ypos;
	float red = random(0, 256);
	float yellow = random(0, 256);
	float green = random(0, 256);
	int xdirection = 1;
	int ydirection = 1;

	public static void main(String[] args) {
		PApplet.main("animatedObject.AnimatedObject");
	}
	
	public void mouseClicked()
	{
		red = random(0, 256);
		yellow = random(0, 256);
		green = random(0, 256);
		
	}
	public void settings() 
	{
		size(1000, 500);
	}

	public void setup() 
	{
		noStroke();
		frameRate(250);
		xpos = 50;
		ypos = 50;
	}

	public void draw() 
	{
		background(red, yellow, green);
		
		xpos = xpos + xdirection;
		ypos = ypos + ydirection;
		
		moveBall();
		
		if (xpos < 1000 && xpos > 950 )
		{
			red = random(0, 256);
			yellow = random(0, 256);
			green = random(0, 256);
		}	
		if (xpos < 50 && xpos > 0 )
		{
			red = random(0, 256);
			yellow = random(0, 256);
			green = random(0, 256);
		}	
		if (ypos < 500 && ypos > 450 )
		{
			red = random(0, 256);
			yellow = random(0, 256);
			green = random(0, 256);
		}	
		if (ypos < 50 && ypos > 0 )
		{
			red = random(0, 256);
			yellow = random(0, 256);
			green = random(0, 256);
		}	
		fill(red + 100, yellow + 100, green + 100);
		ellipse(xpos, ypos, 100, 100);
		fill(red - 50, yellow - 50, green - 50);
		ellipse(xpos, ypos, 50, 50);
	}

	public void moveBall() {
		if (xpos > 950 || xpos < 50) 
		{
		    xdirection *= -1;
		}
		if (ypos > 450 || ypos < 50) 
		{
		    ydirection *= -1;
		}
	}
}