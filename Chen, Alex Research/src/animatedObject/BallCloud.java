package animatedObject;

import java.util.ArrayList;

import processing.core.PApplet;

public class BallCloud extends PApplet
{
	ArrayList<Ball> balls;

	public static void main(String[] args) 
	{
		PApplet.main("animatedObject.BallCloud");
	}
	
	public void settings()
	{
		size(2000, 1000);
	}
	
	public void setup()
	{
		frameRate(30);
//		(PApplet p, int x, int y,  int trueSize, int xdirect, int ydirect, int red, int green, int blue)
		
		balls = new ArrayList<Ball>();
		
		//ERASER
		balls.add(new Ball(this, 1000, 500, 500, 15, 15, 255, 255, 255));

		
		for(int i = 0; i < 1000; i++)
		{
		balls.add(new Ball(this, genNums(1800) + 100, genNums(800) + 100, genNums(100) + 1, genNums(20), genNums(10) + 1, genNums(256), genNums(256), genNums(256)));
		}

	}
	
	public void draw()
	{		
		background(0);
		for(int i = 0; i < balls.size(); i++)
		{
			balls.get(i).bounceBall();
			
			for(int j = 1; j < balls.size(); j++)
			{
				if(balls.get(0).ballCollision(balls.get(j)) == true)
				{
					balls.remove(j);
				}
				
			}
		}
	}
	
	public int genNums(int range)
	{
		int x = (int)(Math.random() * range);
		return x;
	}
	
}
