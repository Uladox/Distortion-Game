package GUIstart;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;












public class StartWindow extends JFrame {
	//private static final long serialVersionUID = 1L;
	BufferedImage img, StartWhite, StartYellow;
	
	//Clip clip;
	//AudioInputStream audio;
	//AudioApp app = new AudioApp();
	//File file;
	//AudioApp.Sound sound = audio.new Sound();
	
	 // MakeSound sound = new MakeSound().playSound("spanish_inquisition.wav");
	
	// AudioPlayer audio;
	//public Clip sound = loadClip("spanish_inquisition.wav");
	//playSound("spanish_inquisition.wav");


	public StartWindow() {
		
        add(new GUIstart());
        //Sound testsong = new Sound("song.mid");
       // SoundBang sound = new SoundBang();
        //testsong.playSound();
       
     // MakeSound.playSound("spanish_inquisition.wav");
    // this.init("/sounds/spanish_inquisition.wav");
      
     //  try {
	//	Thread.sleep(2000);
	//} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
	//	e1.printStackTrace();
	//} 
     //this.playBG();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        this.setLocationRelativeTo( getRootPane());
        img = getImage("/textures/sheets/Clock.png");
        StartWhite = getImage("/textures/sheets/StartButtonWhite.png");
        StartYellow = getImage("/textures/sheets/StartButtonYellow.png");

       
        setVisible(true);
        setResizable(false);
        setIconImage(img);
        try {
        	//Sound.Test.play();
        	//Audioplayer audio = new Audioplayer("sounds/spanish_inquisition.wav");
        	Thread.sleep(5000);
			close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	
	/*
	public Clip loadClip(String filename)
	{
		Clip clip = null;
				try{
					System.out.println(filename);
					AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(filename));
					clip = AudioSystem.getClip();
					clip.open(audioIn);
					clip.drain();
				}
		catch(Exception e){
			e.printStackTrace();
		}
				return clip;
	}
	
	public void playClip(Clip clip){
		stopClip(clip);
		clip.start();
	}
	
	public void stopClip(Clip clip){
		if(clip.isRunning()){
			clip.stop();
		}
	}
	/*
	public static synchronized void playSound(final String url) {
		new Thread(new Runnable() {
		  public void run() {
		    try {
		      Clip clip = AudioSystem.getClip();
		      AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/sounds/" + url));
		      clip.open(inputStream);
		      clip.start(); 
		    } catch (Exception e) {
		      System.err.println(e.getMessage());
		    }
		  }
		}).start();}
		//playSound("spanish_inquisition.wav");
		
/*
	    public void init(String path) {

	    	
	    	    try{
	    	        File soundFile =new File(path);
	    	        audio = AudioSystem.getAudioInputStream(soundFile);
	    	        clip = AudioSystem.getClip();
	    	        clip.open(audio);
	    	        clip.start();
	    	        
	    	        }
	    	        catch(Exception e)
	    	        {
	    	            e.printStackTrace();
	    	        }
	    	}
	    
	
	
	
    */
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
	//Thread.sleep(5000);
		this.dispose();
	}
	
/*public static void sound(String path){
		
		try {

			AudioInputStream audio = AudioSystem.getAudioInputStream(StartWindow.class.getResource(path)); // Load music
			Clip clip = AudioSystem.getClip(); // create clip object
			clip.open(audio);
			clip.start();
		
		} catch (Exception e) {
			System.out.println("Might wanna check path: \n" + path);
			e.printStackTrace();
		}
		
	}
	/* public void playSound(String filename){

	        String strFilename = filename;

	        try {
	            soundFile = new File(strFilename);
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.exit(1);
	        }

	        try {
	            audioStream = AudioSystem.getAudioInputStream(soundFile);
	        } catch (Exception e){
	            e.printStackTrace();
	            System.exit(1);
	        }

	        audioFormat = audioStream.getFormat();

	        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
	        try {
	            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
	            sourceLine.open(audioFormat);
	        } catch (LineUnavailableException e) {
	            e.printStackTrace();
	            System.exit(1);
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.exit(1);
	        }

	        sourceLine.start();

	        int nBytesRead = 0;
	        byte[] abData = new byte[BUFFER_SIZE];
	        while (nBytesRead != -1) {
	            try {
	                nBytesRead = audioStream.read(abData, 0, abData.length);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            if (nBytesRead >= 0) {
	                @SuppressWarnings("unused")
	                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
	            }
	        }

	        sourceLine.drain();
	        sourceLine.close();
	    }*/
	
}