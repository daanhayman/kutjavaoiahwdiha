package dev.sietse.firstgame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;
	public static BufferedImage player1, player2, player3, player4,stone1, gras1,gras2,gras3,gras4,teleporter1;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));
		SpriteSheet ufo = new SpriteSheet(ImageLoader.loadImage("/textures/teleport.png"));
		
		
		player1 = sheet.crop(0, 0, width, height);
		player2 = sheet.crop(width, 0, width, height);
		player3 = sheet.crop(width * 2, 0, width, height);
		player4 = sheet.crop(width * 3, 0, width, height);
		
		
		gras1 = tiles.crop(0, 64 * 2, 64, 64);
		gras2 = tiles.crop(64*1, 64*2, 64, 64);
		gras3 = tiles.crop(64*4, 64*2, 64, 64);
		gras4 = tiles.crop(64*6, 64*2, 64, 64);
		stone1 = tiles.crop(0, 0, 64, 64);
		teleporter1 = ufo.crop(128*6, 0, 128 *2, 128*2);
		
		
	}
}
