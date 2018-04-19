package dev.sietse.firstgame.world;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.sietse.firstgame.gfx.Assets;
import dev.sietse.func.Functions;

public class World {

	int width = 1920;
	int height = 1080;
	int ammount = 64;
	
	public void init(Graphics g)
	{
		checkconfig(g);
	}
	
	public void worldgenerate(Graphics g) 
	{
		ArrayList arraydata = new ArrayList();
		for(int widthf = 0; widthf < width; widthf+=ammount) {
			for(int heightf = 0; heightf < height; heightf+=ammount) {
				Functions func = new Functions();
				int r = func.rnd(1, 5000);
				arraydata.add(heightf);
				arraydata.add(widthf);
				arraydata.add(r);
			}
		}
		file(arraydata, 1);
   }
	
   public void texture(Graphics g) {
	  
	    List<String> myList = getData("data.txt");
	    double htimes = (double)height/(double)ammount;
	    double wtimes = (double)width/(double)ammount;
	    int ihtimes = (int)height/(int)ammount;
	    int iwtimes = (int)width/(int)ammount;
	    double ftimes = Math.round(htimes) * wtimes - 1;
    	int height = 0;
    	int width = 1;
    	int type = 2;
	    for(int f = 0; f<=ftimes;f++)
	    {
	    	String listheight = myList.get(height);
	    	int iheight = Integer.parseInt(listheight.trim());
	    	String listwidth = myList.get(width);
	    	int iwidth = Integer.parseInt(listwidth.trim());
	    	String listtype = myList.get(type);
	    	int itype = Integer.parseInt(listtype.trim());
	    	sorttexture(g,iheight,iwidth,itype);
	    	g.drawImage(Assets.gras1, (int) iwidth, (int) iheight, 64, 64, null);
	    	height += 3;
	    	width += 3;
	    	type +=3;
	    }    
	    
   }
   
 //g.drawImage(Assets.gras1, (int) iwidth, (int) iheight, 64, 64, null);
   
   public void sorttexture(Graphics g, int iheight, int iwidth, int itype){
	   if(itype > 0 && itype < 1001)
	   {
		   
	   }	   
	   if(itype > 1000 && itype < 2001)
	   {
		   
	   }	   
	   if(itype > 2000 && itype < 3001)
	   {
		   
	   }
	   if(itype > 3000 && itype < 4501)
	   {
		   
	   }
	   if(itype < 5001 && itype > 4500)
	   {
		   
	   }
   }
  
   
   public void checkconfig(Graphics g){
	   File file = new File("data.txt");
	   String path = file.getAbsolutePath();
	   Path p = Paths.get(path);
	   boolean exists = Files.exists(p);
	   boolean notExists = Files.notExists(p);

	   if (exists) {
	       texture(g);
	   } else if (notExists) {
	       worldgenerate(g);
	   } else {
	       System.out.printf("File's status is unknown!");
	   }
   }
   
   public void file(ArrayList array, int num)
   {	    
	    if(num == 1){
		    File file = new File("data.txt");	
		    createfile(file, array);
	    }
   }
   
   public void createfile(File f, ArrayList array){
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(f);
	        
	        String arrays = array.toString();
	        writer.write(arrays);
	    } catch (IOException e) {
	        e.printStackTrace(); // I'd rather declare method with throws IOException and omit this catch.
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    System.out.printf("File is located at %s%n", f.getAbsolutePath());
   }
   

   public ArrayList getData(String filename){
	    String content = null;
	    File file = new File("data.txt"); // For example, foo.txt
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
}
