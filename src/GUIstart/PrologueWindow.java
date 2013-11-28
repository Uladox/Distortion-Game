package GUIstart;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;







public class PrologueWindow extends JFrame {
	//private static final long serialVersionUID = 1L;
	BufferedImage img, StartWhite, StartYellow;
	



	public PrologueWindow(int num) {
		
	
        add(new PrologueStart(num));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        this.setLocationRelativeTo( getRootPane());
       
        img = getImage("/textures/sheets/Clock.png");
        setVisible(true);
        setResizable(false);
        setIconImage(img);
        try {
        	
        	Thread.sleep(5000);
        	if(num == 11){
        		Thread.sleep(5000);
        	}
        	if(num == 12){
        		Thread.sleep(1000000);
        	}
        	if(num == 1){
        		Thread.sleep(2000);
        	}
        	if(num == 4){
        		Thread.sleep(5000);
        	}
        	if(num == 5){
        		Thread.sleep(1000000);
        	}
        	
			close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	private void close() throws InterruptedException{
	
		this.dispose();
	}
	

	
}