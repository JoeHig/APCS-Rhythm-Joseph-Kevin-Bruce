package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Handles keyboard input for rhythm part of the game.
 * Based on Mr. Shelby's KeyHandler in AP Animation Demo.
 *
 */
public class KeyHandler implements KeyListener {
	
	private ArrayList<Integer> keysPressed;
	
	public KeyHandler() {
		keysPressed = new ArrayList<Integer>();
	}
	
	public void keyPressed(KeyEvent e) {
		keysPressed.add(e.getKeyCode());
	}
	
	public void keyReleased(KeyEvent e) {
		Integer code = e.getKeyCode();
		while(keysPressed.contains(code))
			keysPressed.remove(code);
	}
	
	public void keyTyped(KeyEvent e) {

	}
	
	public boolean isPressed(int code) {
		return keysPressed.contains(code);
	}
	
	
}