package flappybird;

import flappybird.FlappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private Bird bird;
	private ArrayList<Rectangle> rects;
	private FlappyBird fb;
	private Font scoreFont, pauseFont;
	public static final Color color = new Color(22, 63, 105);
	public static final int PIPE_W = 50, PIPE_H = -20;
	private Image pipeLength;

	public GamePanel(FlappyBird fb, Bird bird, ArrayList<Rectangle> rects) {
		this.fb = fb;
		this.bird = bird;
		this.rects = rects;
		scoreFont = new Font("Comic Sans MS", Font.BOLD, 18);
		pauseFont = new Font("Arial", Font.BOLD, 48);

		try {
			pipeLength = ImageIO.read(new File("tranbludiadisk.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) 
	{
		g.setColor(color);
		g.fillRect(0,0,FlappyBird.WIDTH,FlappyBird.HEIGHT);
		bird.update(g);
		g.setColor(Color.BLUE);
		
		for(Rectangle r : rects) 
		{
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.BLUE);
			AffineTransform old = g2d.getTransform();
			g2d.translate(r.x+PIPE_W/2, r.y+PIPE_H/2);
			
			if(r.y < FlappyBird.HEIGHT / 2) 
			{
				g2d.translate(0, r.height);
				g2d.rotate(Math.PI);
			}
			
			g2d.drawImage(pipeLength, -PIPE_W/2, PIPE_H / 2, GamePanel.PIPE_W, r.height, null);
			g2d.setTransform(old);
		}
		
		g.setFont(scoreFont);
		g.setColor(Color.BLACK);
		g.drawString("Score: "+fb.getScore(), 10, 20);

		if(fb.paused()) 
		{
			g.setFont(pauseFont);
			g.setColor(new Color(0,0,0,170));
			g.drawString("Game Ended", FlappyBird.WIDTH/2-150, FlappyBird.HEIGHT/2-100);
			g.drawString("Press Space to Begin", FlappyBird.WIDTH/2-250, FlappyBird.HEIGHT/2+50);
			g.drawString("Previous Score: " + FlappyBird.getTime(), FlappyBird.WIDTH/2-250, FlappyBird.HEIGHT/2+150);

		}
	}
}
