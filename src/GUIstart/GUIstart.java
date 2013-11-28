package GUIstart;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GUIstart extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	BufferedImage img;
	
	public GUIstart() {
		// Load the image 

		img = getImage("/textures/sheets/Start.png");
		
	
		this.setPreferredSize(new Dimension(img.getWidth() -10, img.getHeight()-10));
	
	}
	
	public void paintComponent(Graphics g) {
		// Draw the image on the panel

		//Mouse mouse = new Mouse();
		//addMouseListener(mouse);
		//addMouseMotionListener(mouse);
		g.drawImage(img, 0,0,null);
		
		//g.setColor(Color.WHITE);
		//g.setFont(new Font("Verdana", 0, 20));
		 //g.drawString("X: "  + mouse.getX() + " Y: " + mouse.getY(), 20, 20);
		
	//	 if( !(Mouse.getX() > 450)){
		//g.setColor(Color.WHITE);
		//g.setFont(new Font("Verdana", 0, 20));
		//g.drawString("Start", 500, 100);
		//}
		//
	}
	
	private BufferedImage getImage(String filename) {
		// This time, you can use an InputStream to load
		try {
			// Grab the InputStream for the image.
			InputStream in = getClass().getResourceAsStream(filename);
			
			// Then read it in.
			return ImageIO.read(in);
		} catch (IOException e) {
			System.out.println("The image was not loaded.");
			System.exit(1);
		}
		return null;
	}
}

