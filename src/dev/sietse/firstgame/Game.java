package dev.sietse.firstgame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.sietse.firstgame.display.Display;
import dev.sietse.firstgame.gfx.Assets;
import dev.sietse.firstgame.input.KeyManager;
import dev.sietse.firstgame.states.GameState;
import dev.sietse.firstgame.states.MenuState;
import dev.sietse.firstgame.states.State;
import dev.sietse.firstgame.world.World;
//import dev.sietse.firstgame.world.MenuClass;

public class Game implements Runnable {

	private Display display;	
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gamestate;
	private State menustate;
	
	private String strGamestate = "";
	
//	public String getstrGamestate() {
//		return this.strGamestate;
//	}
//	public void setstrGamestate(String value) {
//		this.strGamestate = "Done";
//	}
	
	//Input
	private KeyManager keyManager;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		
	}
	private void init() {
		display = new Display(title, width, height);
		display.getJframe().addKeyListener(keyManager);
		Assets.init();
		
		
		
		//menu
		gamestate = new GameState(this);

		//if() {
		State.setState(gamestate);
		//}else {
		//	State.setState(menustate);
		//}
	}
	
	
	
	private void update() {
		keyManager.update();
		if(State.getState() != null) {
			State.getState().update();
			}
	}
	
	private void render() {
		
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		World w = new World();
		if(State.getState() != null) {
			if(this.strGamestate == "")
			{
				MenuState menu = new MenuState(this);
				String strReturn = menu.menuRender(g);
				if(strReturn == "true")
				{
					this.strGamestate = "true";	
				} 
			}
			else
			{
				w.init(g);
				State.getState().render(g);	 
			}
			
		}
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerUpdate = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerUpdate;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			
			if(timer > 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
