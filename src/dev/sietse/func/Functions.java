package dev.sietse.func;

import java.util.Random;

public class Functions {

	public int rnd(int getal1, int getal2){
		Random rand = new Random();
		int uitkomst = rand.nextInt(getal2) + getal1;
		return uitkomst;
	}
}
