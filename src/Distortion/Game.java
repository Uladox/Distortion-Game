package Distortion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


import GUIstart.PrologueWindow;
import GUIstart.StartWindow;
import Save.Ending;
import Save.PlayerSpawn;
import Save.Saving;
import Save.StartSaving;



public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static String title = "Distortion";
	//public int playerx = 136;
	//public int playery = 196;

	static BufferedImage img;
	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private Level level;
	private Player player;
	private TileTreeEntity Tree;
	//private Audioplayer audio;
	//private TileTreeEntity treeEnt;
	//private TileEntity tileEntity;
	private boolean running = false;

	private Screen screen;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = Level.spawn;
		//new SpawnLevel("/levels/spawn.png");
		//Position of Spawn!
		TileCoordinate playerSpawn = new TileCoordinate(PlayerSpawn.playerx, PlayerSpawn.playery);
		player = new Player(playerSpawn.x(), playerSpawn.y(), key);
		Tree = new TileTreeEntity(playerSpawn.x(), playerSpawn.y());
		//treeEnt = new TileTreeEntity(playerSpawn.x(), playerSpawn.y());
		player.init(level);
		Tree.init(level);
		addKeyListener(key);
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		
		img = getImage("/textures/sheets/Clock.png");
		
		
	}
	

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;

		requestFocus();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			// one second || 1000 ns = 1 sec
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle(title + "  | " + updates + " ups, " + frames + " fps");
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}

	// int x = 0, y = 0;

	public void update() {
		key.update();
		// if (key.up) y--;
		// if (key.down) y++;
		// if (key.right) x++;
		// if (key.left) x--;
		
		player.update();
		Tree.update();
		
		

	}
	

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		

		screen.clear();

		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		
		//if(Mob.front()){
		//player.render(screen);
		//level.render(xScroll, yScroll, screen);
		
		//}
		//else if(!Mob.front()){
			level.render(xScroll, yScroll, screen);
			player.render(screen);
			level.renderTree(xScroll, yScroll, screen);
			Tree.render(screen);
			//TileTreeEntity.render(screen);
			
			 
			//level.renderTree(xScroll, yScroll, screen);
			//SpawnTreeTile.render(x, y, screen);
			
		//}
		//level.renderTree(xScroll, yScroll, screen);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		// g.setColor(Color.BLACK);
		// g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 50));
		//g.fillRect(Mouse.getX(), Mouse.getY(), 64, 64);
		//g.drawString("" + Mouse.getB(), 80, 80);
		// g.drawString("X: " + x + " Y: " + y, 450, 400);
		g.dispose();
		bs.show();
	}
	
	

	public static void main(String[] args) {
	try {
		StartSaving saving = new StartSaving("A");
	} catch (IOException e) {
		File f = new File("C:\\DistortionSave");
		final String hash = "Save";
		final String fileName = hash + ".txt";
		final File file = new File(f, fileName);
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
		    if(f.mkdir()) { 
		        System.out.println("Directory Created");
		    } else {
		        System.out.println("Directory is not created");
		    }
		} catch(Exception b){
		    b.printStackTrace();
		} 
		e.printStackTrace();
	}
	//PrologueWindow Prologue1 = new PrologueWindow(1);
	//PrologueWindow Prologue2 = new PrologueWindow(2);
	//PrologueWindow Prologue3 = new PrologueWindow(3);
	//StartWindow start = new StartWindow();
	 
		////start = new StartWindow();
		//GameFrame c = new GameFrame();
		Game game = new Game();
		game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.frame.setIconImage(img);
	

		game.start();
		
		
		
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
