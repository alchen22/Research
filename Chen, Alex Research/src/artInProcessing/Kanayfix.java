package artInProcessing;

import processing.core.PApplet;

public class Kanayfix extends PApplet {

	int xCoordinate = 800, yCoordinate = 400;
	
	int xMovement = 10;
	
	int yMovement = 10;
	
	int keyX = 50, keyY = 50;
		
	int life = 8;
	
	int integerTimeNow, intergerEnd, addToEndTime;
	
	double startTime, currentTime, ElapsedTime, endTime;
	
	boolean collision = false;
	
	public static void main(String[] args) 
	{
		PApplet.main("artInProcessing.Kanayfix");
	}

	public void settings()
	{
	size(1900, 750);
	}

	public void draw()
	{
		double circlesDistance = dist(keyX, keyY, xCoordinate, yCoordinate);
		background(0);
		
		if (life > 0)
		{
		xCoordinate = xCoordinate + xMovement;
		yCoordinate = yCoordinate + yMovement;
		
		if (xCoordinate > 1825 || xCoordinate < 75)
		{
		    xMovement *= -1;
		}
		if (yCoordinate > 675 || yCoordinate < 75)
		{
		    yMovement *= -1;
		}
		if (keyX > 1825)
		{
			keyX = 150;
		}
		if (keyY > 675)
		{
			keyY = 100;
		}
		if (keyY < 75)
		{
			keyY = 600;
		}
		if (keyX < 75)
		{
			keyX = 1750;
		}		
		
		fill(50, 256, 50);
		ellipse(xCoordinate, yCoordinate, 150, 150);
		ellipse(keyX, keyY, 150, 150);
		}
				
		if (life > 0)
		{
			currentTime = millis()/1000; 
			
			integerTimeNow = (char)currentTime; 
			
			textSize(32);
			
			text(life, 30, 30); 
			
			text(integerTimeNow - (char)endTime, 80, 30);
			
			intergerEnd = (char)endTime;  
			
			text(intergerEnd, 150, 30);
			
			addToEndTime = integerTimeNow - intergerEnd; 
			
			if (collision == true)
			{
				endTime = endTime + addToEndTime;
			}
		}
		
		if (life <= 0)
		{
				intergerEnd = (char)endTime + addToEndTime;
				
				textSize(200);
				
				text("Score: " + intergerEnd, 500, 400);
				
				text("GAME OVER", 500, 250);
		}
		
		if(circlesDistance < 150)
		{
			collision = true;	
		}
		
		else
		{
			collision = false;
		}
		
		if (collision == true)
		{
			
			life -= 1;
			
			xCoordinate = 800;
			yCoordinate = 400;
			
			keyX = 50;
			keyY = 50;
		}
	}
	
	public void keyPressed() 
	{
	 if (key == CODED) 
	 	{
		   if (keyCode == UP) 
		   {
		    	keyY -= 30;
		   }
		   else if (keyCode == DOWN) 
		   {
		    	keyY += 30;
		   }
		   else if (keyCode == LEFT) 
		   {
		    	keyX -= 30;
		   }
		   else if (keyCode == RIGHT) 
		   {
		    	keyX += 30;
		   }
	 	}
	}
}