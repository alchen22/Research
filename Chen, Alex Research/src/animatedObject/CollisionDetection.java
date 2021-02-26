package animatedObject;

import processing.core.PApplet;

public class CollisionDetection extends PApplet {

	int xpos = 800, ypos = 400;
	int xdirection = 1;
	int ydirection = 1;
	int posx = 50, posy = 50;
	int backgroundcolor = 0;
	int lives = 8;
	int intCurrentTime, intEndTime, addInterval;
	double startTime, currentTime, ElapsedTime, endTime;
	boolean collision = false;

	public static void main(String[] args) 
	{
		PApplet.main("animatedObject.CollisionDetection");
	}

	public void settings()
	{
		size(1000, 500);
	}

	public void setup()
	{

	}

	public void draw()
	{
		double circlesDistance = getDistance(posx, posy, xpos, ypos);
		background(backgroundcolor, 0, 0);

		//for lives > 0, the ball will continuously move and 
		//reverse directions upon colliding with a wall
		//otherwise, the ball will not be drawn and the game ends
		if (lives > 0)
		{
			xpos = xpos + xdirection;
			ypos = ypos + ydirection;

			bounceBall();

			ellipse(xpos, ypos, 100, 100);
			ellipse(posx, posy, 100, 100); //me
		}

		//display current score

		if (lives > 0)
		{
			currentTime = millis()/1000; //current time is on loop set to current time passed from start of program
			intCurrentTime = (char)currentTime; //current time converted to integer
			textSize(32);
			text(lives, 30, 30); 
			text(intCurrentTime - (char)endTime, 80, 30);
			intEndTime = (char)endTime;  //end time converted to integer
			text(intEndTime, 150, 30);
			addInterval = intCurrentTime - intEndTime; //current time should be reset to 0

			if (collision == true)
			{
				endTime = endTime + addInterval;
			}
		}


		//display total score at endgame
		if (lives <= 0)
		{
			intEndTime = (char)endTime + addInterval;
			textSize(100);
			text("Score: " + intEndTime, 100, 200);
			text("GAME OVER", 100, 100);
		}

		//check if collision is true
		if(circlesDistance < 100)
		{
			collision = true;	
		}

		else
		{
			collision = false;
		}

		if (collision == true)
		{
			backgroundcolor += 32;

			lives -= 1;//subtract life

			//reset circle positions
			xpos = 800;
			ypos = 400;

			posx = 50;
			posy = 50;
			
			xdirection = 3;
			ydirection = 3;
		}

		if(Math.random() * 100 < 1)
		{
			if(xdirection < 0)
				xdirection--;
			else
				xdirection++;
			if(ydirection < 0)
				ydirection--;
			else
				ydirection++;		
		}
	}

	public void keyPressed() 
	{
		if (key == CODED) 
		{
			if (keyCode == UP) 
			{
				posy -= 30;
			}
			else if (keyCode == DOWN) 
			{
				posy += 30;
			}
			else if (keyCode == LEFT) 
			{
				posx -= 30;
			}
			else if (keyCode == RIGHT) 
			{
				posx += 30;
			}
		}
	}


	//CUSTOM METHODS





	public void lifetimer()
	{
		while(lives > 0)
		{
			intCurrentTime = millis()/1000;
			textSize(32);
			text(lives, 30, 30); 
			text(intCurrentTime, 80, 30);

			if(collision = true)
			{
				endTime = endTime + intCurrentTime;
			}
		}
	}

	public void bounceBall()
	{
		if (xpos > 950 || xpos < 50)
		{
			xdirection *= -1;
		}
		if (ypos > 450 || ypos < 50)
		{
			ydirection *= -1;
		}
		if (posx > 950)
		{
			posx -= 50;
		}
		if (posy > 450)
		{
			posy -= 50;
		}
		if (posy < 50)
		{
			posy += 50;
		}
		if (posx < 50)
		{
			posx += 50;
		}
	}

	//distance method (didn't know there was a pre~existing one)
	public static double getDistance(int xone, int yone, int xtwo, int ytwo)
	{
		double xdistance = xone - xtwo;
		double ydistance = yone - ytwo;

		xdistance = xdistance * xdistance;
		ydistance = ydistance * ydistance;

		double totaldistance = xdistance + ydistance;
		totaldistance = Math.sqrt(totaldistance);
		return totaldistance;

	}
}