package dev.sietse.firstgame.states;

import java.awt.Graphics;

import dev.sietse.firstgame.Game;

public abstract class State {

	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	//CLASS
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);	
}
