package pictureManipulation;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageManipulation extends PApplet
{
    private PImage picture;
    private PImage secret1;
    private PImage secret2;
    private PImage disney;
    private PImage ocean;

    
    public static void main(String[] args)
    {
        PApplet.main("pictureManipulation.ImageManipulation");
    }
    
    public void settings()
    {
        size(900, 900);
    }
    
    public void setup()
    {
        picture = loadImage("images/ross.jpg");
        secret1 = loadImage("images/secret1.png");
        secret2 = loadImage("images/secret2.png");
        disney = loadImage("images/grayscale.png");
        ocean = loadImage("images/ocean.jpg");
    }
    
    public void mouseClicked()
    {
    	greenScreen();
    }
    
    public void draw()
    {
        image(picture, 0, 0);
    }
    
    public void grayScale()
    {
        picture.loadPixels(); //creates arraylist of pixels called pixels, each stores a color
        
        for(int i = 0; i < picture.pixels.length; i++) //accesses every pixel
        {
           int pixel = picture.pixels[i]; //gets color of pixel at position i
           float grayScale; //placeholder for updated pixel
           grayScale = (red(pixel) + green(pixel) + blue(pixel)) / 3; //setting grayScale to desired colors
           pixel = (int)grayScale; //Setting colors of pixel variable to grayscale
           picture.pixels[i] = color(pixel, pixel, pixel); //sets actual displayed pixels to grayscale

           
        }
        
        picture.updatePixels();
    }
    
    public void invertColors()
    {
        picture.loadPixels(); //creates arraylist of pixels called pixels, each stores a color
        
        for(int i = 0; i < picture.pixels.length; i++) //accesses every pixel
        {
           int pixel = picture.pixels[i]; //gets color of pixel at position i
           picture.pixels[i] = color(255 - red(pixel), 255 - green(pixel), 255 - blue(pixel)); //inverts colors
        }
        
        picture.updatePixels();
    }
    
    public void mirrorImage()
    {
        picture.loadPixels(); //creates arraylist of pixels called pixels, each stores a color

    	for (int x = 0; x < picture.width; x++) //loops through all x values
    	{
    		for(int y = 0; y < picture.height; y++) //loops through each y value for a determined x value
    		{
    			picture.pixels[picture.width * y + x] = picture.pixels[picture.width * (picture.width - y - 1) + x]; //flips the positions of pixels
    		}
    	}
    		
        picture.updatePixels();

    }
    
    public void decode()
    {
    	disney.loadPixels();
    	for(int i = 0; i < disney.pixels.length; i++)
    	{
    		int pixel = disney.pixels[i];
    		if(color(red(pixel)) % 2 == 0)
    		{
    			disney.pixels[i] = color(0 , 0, 0);
    		}
    		else
    		{
    			disney.pixels[i] = color(256, 256, 256);
    		}
    	}
    	disney.updatePixels();
    }
    
    public void greenScreen()
    {
    	picture.loadPixels(); //loads picture to be modified
    	ocean.loadPixels(); //loads greenScreen picture
    	
    	
    	int pixel = picture.pixels[mouseY * picture.width + mouseX]; //determines the color of the pixel that user clicks
    	
    	 for(int x = 0; x < picture.width; x++)
         {
           for(int y = 0; y < picture.height; y++)
           {
        	   //Thresholding, determines how far scanned pixel colors are from the clicked pixel by acquiring the square of the difference of the colors. (Squared to eliminate negatives)
        	   if(Math.pow(red(picture.pixels[x * picture.width + y]) - red(pixel), 2) <= 2500 && Math.pow(green(picture.pixels[x * picture.width + y]) - green(pixel), 2) <= 2500 && Math.pow(blue(picture.pixels[x * picture.width + y]) - blue(pixel), 2) <= 2500)
        	   {
        	   picture.pixels[x * picture.width + y] = ocean.pixels[x * ocean.width + y]; //pixels effected get swapped with their ocean counterparts
        	   }
           }
         }
    
    	picture.updatePixels();
    }
}
    
    