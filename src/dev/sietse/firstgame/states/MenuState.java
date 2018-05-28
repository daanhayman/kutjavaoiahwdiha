package dev.sietse.firstgame.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import dev.sietse.firstgame.Game;

import dev.sietse.firstgame.gfx.ImageLoader;

public class MenuState {
	
private Game game;

	public MenuState(Game game) {
		this.game = game;
	}
	
	public String strGameState(){
		return "False";
	}
	
	public String menuUpdate() {	
		if(game.getKeyManager().space) {
			return "true";
		}
	  return "false";
	}

	public String menuRender(Graphics g) {
		String strReturn = this.menuUpdate();
		g.setColor(new Color(0, 0, 0, 200));
		g.fillRect(0,0,1920,1080);
		g.fillRoundRect(560,100,800,880,20,20);
		
		g.setColor(new Color(58, 132, 81, 200));
		Font fnt0 = new Font ("Apple Casual", Font.BOLD, 72);
		g.setFont(fnt0);
		g.drawString("Monster Defender", 665, 450);
		g.drawImage(ImageLoader.loadImage("/textures/start.png"), 560, 450, 800 , 220, null);
		return strReturn;
	}
}
