package GUIstart;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class PrologueStart extends JPanel{
	
	BufferedImage img;
	//PrologueWindow win = new PrologueWindow();
	//int num = 1;
	public PrologueStart(int num){
		
	img = getImage("/textures/sheets/LookingBack" +num +".png");
	this.setPreferredSize(new Dimension(img.getWidth() - 15 , img.getHeight()-15));
	}
	
	public void paintComponent(Graphics g) {
		
		g.drawImage(img, 0,0,null);
		
		//paintComponent(g );
		
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
