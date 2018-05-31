package dev.sietse.firstgame.entities.creatures;

import java.awt.Graphics;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.sietse.firstgame.Game;
import dev.sietse.firstgame.gfx.Assets;

public class Player extends Creature{

	private Game game;
	public List<String> data;
	public int count;
	
	public Player(Game game,float x, float y) {
		super(x,y);
		this.game = game;
		this.data = getData("stone.txt");
		this.count = (this.data.size() / 2) - 1;
		System.out.println(this.count);
	}
	
	   public ArrayList getData(String filename){
		    String content = null;
		    File file = new File("stone.txt"); // For example, foo.txt
		    FileReader reader = null;
		    try {
		        reader = new FileReader(file);
		        char[] chars = new char[(int) file.length()];
		        reader.read(chars);
		        content = new String(chars);
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        if(reader != null){
		        }
		    }
		    String s1 = content;
		    String replace = s1.replace("[","");
		    String replace1 = replace.replace("]","");
		    ArrayList myList = new ArrayList<String>(Arrays.asList(replace1.split(",")));
		    return myList;
	   }

	@Override
	public void update() {
		if(y <= 0)
		{
			y += 3;
		}
		if(y >= 1016)
		{
			y -= 3;
		}
		if(x <= 0)
		{
			x += 3;
		}
		if(x >= 1856) 
		{
			x -= 3;
		}
		int stonewidth = 0;
		
		int stoneheight = 1;
		
		List<String> myList = this.data;
		
		for(int f = 0; f<=this.count; f++)
		{
			//links boven
			float strstonePosWidth = Integer.parseInt(this.data.get(stonewidth).replaceAll("\\s+",""));
			float strstonePosHeight = Integer.parseInt(this.data.get(stoneheight).replaceAll("\\s+",""));
			
			//rechts onder
			float stonePosWidthMax = strstonePosWidth + 64;
			float stonePosHeightmax = strstonePosHeight + 64;
			
			float intMaxHeightplayer = y + 40;
			float intMaxWidthplayer = x + 64;
			
			
			if(x > strstonePosWidth && x < stonePosWidthMax)
			{
				if(y > strstonePosHeight && y < stonePosHeightmax)
				{
					x += 200;
					y += 200;

				}	
			}
			
			stonewidth++;
			stonewidth++;
			stoneheight++;
			stoneheight++;
		}
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
		
		g.drawImage(Assets.player1, (int) x, (int) y, 64 , 64, null);
		
		
	}

	
}
