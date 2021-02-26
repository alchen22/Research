package montyHall;



import processing.core.PApplet;
import java.util.Random;


public class HallofMonty extends PApplet

{
	
	static Random random = new Random();

	int prizeDoor;

	int playerDoor = 0;

	int eliminatedDoor = (int) random(1,4);	

	int oldPlayerDoor;

	boolean change = false;

	int alreadyChosen = 0;

	boolean alreadyClicked = false;


	 public static void main(String[] args)

	{

		PApplet.main("montyHall.HallofMonty");

	}

	 public void settings()

	{

		size(650, 500);

	}

	 public void setup()

	{

		pickPrizeDoor();
		if (alreadyChosen == 1)
		{
		outputResult();
		}
		

	}

	 public void draw()

	{

		drawDoors();

		if(playerDoor != 0 && eliminatedDoor == 0)

		{

			eliminateDoor();

		}
	}

	 public void drawDoors()

	{

		fill(0);

		rect(75,100,100,175);

		rect(275,100,100,175);

		rect(475,100,100,175);																						

		fill(255);

		textSize(32);

		text("1", 115, 150);

		textSize(32);

		text("2", 315, 150);

		textSize(32);

		text("3", 515, 150);

	}

	 public void pickPrizeDoor()

	{

		double x = Math.random();

		if(x < 0.33)

		{

			prizeDoor = 1;

		}

		else if(x < 0.66)

		{

			prizeDoor = 2;

		}

		else if (prizeDoor < 1)

		{

			prizeDoor = 3;

		}

	}

	 public void pickPlayerDoor()

	{

		

	}

	 public void mouseClicked()

	 {

		if(alreadyClicked == false)

		{

		if(playerDoor < 1) 

		{

		checkDoorArea(75, 1);

		checkDoorArea(275, 2);

		checkDoorArea(475, 3);

		}

		alreadyClicked = true;

		eliminateDoor(); 

		}

	}

	 public void checkDoorArea(int doorX, int door)

	{

		 if(mouseX > doorX && mouseX < doorX + 100 && mouseY > 100 && mouseY < 275)

		 {

			 fill(0);

			 textSize(28);

			 text("Door " + door + " has been chosen", 75, 350);

			 playerDoor = door;
			 oldPlayerDoor = door;

		 }

	}

	 public void eliminateDoor()

	 

	 {

		 while(eliminatedDoor == prizeDoor || eliminatedDoor == playerDoor)

		 {

			 eliminatedDoor = (int) random(1,4);

		 }

		 fill(0);

		 textSize(28);

		 text("Door " + eliminatedDoor + " has a goat behind it", 75, 390);

		 text("Press Up to switch and down to stay", 75, 425);

	 }

	 public void keyPressed()

	 {

			 if(key == CODED)

			 {

				 if(keyCode == DOWN && alreadyChosen == 0)

				 {
					 alreadyChosen++;
				 }
					
				 else if(keyCode == UP && alreadyChosen == 0)

				 {
					 alreadyChosen++;
					 
					 playerDoor = (int) random(1,4);
					 System.out.println(playerDoor);
					 
					 while(playerDoor == eliminatedDoor || playerDoor == oldPlayerDoor)
					 {
						 playerDoor = (int) random(1,4);
						 System.out.println(playerDoor);
					 }
				 }
			 }
	 }

				
	 public void outputResult()

	 {

	 if(playerDoor == prizeDoor)

	 	{

		 	fill(0);

		 	textSize(28);

		 	text("You have won!", 75, 495);

	 	}

	 else

		 {

			 fill(0);

			 textSize(28);

			 text("You lost.", 75, 495);

		 }

	 }

	 public void drawEliminatedDoor(int x)

	 {

		 fill(255,0,0);

		 rect(x, x + 100, 100, 275);

	 }
	 
	 public void simulate()
	 {
		 int stayWins = 0;
		 int changeWins = 0;
		 int trials = 1000; //input
		 for (int i = 0; i < trials; i++)
		 {
			 int prizeDoor = random.nextInt(3);
		 	 int choice = random.nextInt(3);
		 			
		 		if (choice == prizeDoor)
		        {
		 			stayWins ++;
		 		}
		 			
		 		else
		        {
		 			if (choice != prizeDoor)
		 			{
		 				changeWins ++;
		 			}
		 		}
		 }
		 System.out.println("Staying gives you: " + stayWins + " wins!");
		 System.out.println("Changing gives you: " + changeWins + " wins!");
	 }	 
	 
	 public void simulat()
	 {
		 int stayWins = 0;
		 int changeWins = 0;
		 int trials = 1000; //input
		 for (int i = 0; i < trials; i++)
		 {
			 int prizeDoor = random.nextInt(3);
		 	 int choice = random.nextInt(3);
		 			
		 		if (choice == prizeDoor)
		        {
		 			stayWins ++;
		 		}
		 			
		 		else
		        {
		 			if (choice != prizeDoor)
		 			{
		 				changeWins ++;
		 			}
		 		}
		 }
		 System.out.println("Staying gives you: " + stayWins + " wins!");
		 System.out.println("Changing gives you: " + changeWins + " wins!");
	 }	 
}

