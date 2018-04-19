package dev.sietse.firstgame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;
	public static BufferedImage player1, player2, player3, player4, gras1;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));
		
		player1 = sheet.crop(0, 0, width, height);
		player2 = sheet.crop(width, 0, width, height);
		player3 = sheet.crop(width * 2, 0, width, height);
		player4 = sheet.crop(width * 3, 0, width, height);
		
		gras1 = tiles.crop(0, 64 * 2, 64, 64);
	}
}
