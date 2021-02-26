package camera;

import processing.core.PApplet;
import processing.video.*;

public class CameraDemo extends PApplet
{
    private Capture cam;
    
    public static void main(String[] args)
    {
        PApplet.main("camera.CameraDemo");
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
        if(cam.available())
        {
            cam.read();
            image(cam, 0, 0);
        }
    }
}