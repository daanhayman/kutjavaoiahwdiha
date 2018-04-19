package dev.sietse.firstgame;


public class Launcher {
	
	public static void main(String[] args) {
		
		Game game = new Game("FirstGame", 1920, 1080);
		game.start();
	}
}
