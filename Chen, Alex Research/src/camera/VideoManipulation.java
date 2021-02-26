package camera;

import processing.core.PApplet;
import processing.core.PImage;
import processing.video.*;

public class VideoManipulation extends PApplet
{
	private Capture cam;
	private boolean newEditedFrameAvailable;
	//	private boolean pictureAvailable = false;
	private PImage editedFrame;
	PImage savedPicture = createImage(1280, 720, RGB); //backgroundSubtraction

	public static void main(String[] args)
	{
		PApplet.main("camera.VideoManipulation");
	}

	public void settings()
	{
		size(1280, 720);
	}

	public void setup()
	{
		String[] cameras = Capture.list();

		System.out.println("Available cameras:");
		for(String camera : cameras)
			System.out.println(camera);

		cam = new Capture(this, cameras[0]);
		cam.start();
	}

	public void draw()
	{
		if(newEditedFrameAvailable)
		{
			image(editedFrame, 0, 0);
			newEditedFrameAvailable = false;
		}

		if(cam.available() && ! newEditedFrameAvailable)
			readAndEditFrame();
	}

	// precondition: cam.available() && background != null
	private void readAndEditFrame()
	{
		mirror();
		invert();
		greenScreen();
		backgroundSubtraction();
	}

	private void invert()
	{
		cam.read();
		cam.loadPixels();
		editedFrame = createImage(width, height, RGB);
		editedFrame.loadPixels();

		for(int i = 0; i < editedFrame.pixels.length; i++) //accesses every pixel
		{
			int pixel = cam.pixels[i]; //gets color of pixel at position i
			editedFrame.pixels[i] = color(255 - red(pixel), 255 - green(pixel), 255 - blue(pixel)); //inverts colors
		}


		editedFrame.updatePixels();

		newEditedFrameAvailable = true;
	}

	public void greenScreen()
	{
		cam.read();
		cam.loadPixels();
		editedFrame = createImage(width, height, RGB);
		editedFrame.loadPixels();    	

		for(int i = 0; i < editedFrame.pixels.length; i++)
		{
			int pixel = cam.pixels[i];
			if(Math.pow(red(pixel) - 256, 2) <= 900 && Math.pow(green(pixel) - 256, 2) <= 900 && Math.pow(blue(pixel) - 256, 2) <= 900)
			{
				editedFrame.pixels[i] = color(256, 0, 0);
			}

			else
			{
				editedFrame.pixels[i] = cam.pixels[i];
			}
		}
		editedFrame.updatePixels();
		newEditedFrameAvailable = true;
	}

	public void mirror()
	{
		cam.read();
		cam.loadPixels();
		editedFrame = createImage(width, height, RGB);
		editedFrame.loadPixels();


		//		editedFrame.pixels = cam.pixels;

		for (int x = 0; x < cam.width; x++)
		{
			for(int y = 0; y < cam.height / 2; y++)
			{
				editedFrame.pixels[cam.width * y + x] = cam.pixels[cam.width * (cam.height - y - 1) + x];
			}
		}


		editedFrame.updatePixels();
		newEditedFrameAvailable = true;
	}

	public void backgroundSubtraction()
	{
		cam.read();
		editedFrame = createImage(width, height, RGB);
		editedFrame.loadPixels();
		cam.loadPixels();

		for (int i = 0; i < editedFrame.pixels.length; i++)
		{
			int pixel = cam.pixels[i];
			editedFrame.pixels[i] = color(red(pixel), green(pixel), blue(pixel));
		}

		changeBackground();
		editedFrame.updatePixels();
		newEditedFrameAvailable = true;
	}

	public void changeBackground()
	{
		for(int i = 0; i < editedFrame.pixels.length; i++)
		{
			if(Math.pow(red(editedFrame.pixels[i]) - red(savedPicture.pixels[i]), 2) <= 900 && Math.pow(green(editedFrame.pixels[i]) - green(savedPicture.pixels[i]), 2) <= 900 && Math.pow(blue(editedFrame.pixels[i]) - blue(savedPicture.pixels[i]), 2) <= 900)
			{
				editedFrame.pixels[i] = color(0);
			}
		}
	}

	public void mouseClicked()
	{
		for(int i = 0; i < editedFrame.pixels.length; i++) //saves background
		{
			savedPicture.pixels[i] = editedFrame.pixels[i];
		}
	}
}
