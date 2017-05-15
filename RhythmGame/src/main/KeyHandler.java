package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyHandler implements KeyListener {
	
	private ArrayList<Integer> keys;
	
	public KeyHandler() {
		keys = new ArrayList<Integer>();
	}
	
	public void keyPressed(KeyEvent e) {
		keys.add(e.getKeyCode());
	}
	
	public void keyReleased(KeyEvent e) {
		Integer code = e.getKeyCode();
		while(keys.contains(code))
			keys.remove(code);
	}
	
	public void keyTyped(KeyEvent e) {

	}
	
	public boolean isPressed(int code) {
		return keys.contains(code);
	}
	
	
}