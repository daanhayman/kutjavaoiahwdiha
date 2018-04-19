package dev.sietse.firstgame.entities.creatures;

import java.awt.Graphics;

import dev.sietse.firstgame.Game;
import dev.sietse.firstgame.gfx.Assets;

public class Player extends Creature{

	private Game game;
	
	public Player(Game game,float x, float y) {
		super(x,y);
		this.game = game;
	}

	@Override
	public void update() {
		if(game.getKeyManager().up)
			y -= 3;
		if(game.getKeyManager().down)
			y += 3;
		if(game.getKeyManager().left)
			x -= 3;
		if(game.getKeyManager().rigth)
			x += 3;
	
	}
	
	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.player1, (int) x, (int) y, null);
		
		
	}

	
}
