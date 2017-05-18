package rpg;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import javax.swing.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.RGMain;

public class WorldPanel extends JPanel implements Runnable, KeyListener {
	public static final int DRAWING_WIDTH = 650;
	public static final int DRAWING_HEIGHT = 650;

	private World world;
	private RGMain window;

	public WorldPanel(RGMain window) {
		super();
		
		this.window = window;
		setBackground(Color.BLACK);

		world = new World();

		new Thread(this).start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

		g.setColor(new Color(205, 102, 29));

		world.drawWorld(g2, this);

		g2.setTransform(at);

	}
	
	
	
	public void run() {
		while (true) {
			long startTime = System.currentTimeMillis();
			
			repaint();

			long waitTime = 17 - (System.currentTimeMillis() - startTime);
			try {
				if (waitTime > 0)
					Thread.sleep(waitTime);
				else
					Thread.yield();
			} catch (InterruptedException e) {
			}
		}
	}
	
	
	public void switchToBattle() {
		window.changePanel("2");
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			world.moveScreen(0);
//			System.out.print('L');
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			world.moveScreen(1);
//			System.out.print('R');
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			world.moveScreen(2);
//			System.out.print('U');
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			world.moveScreen(3);
//			System.out.print('D');
//		} else if (e.getKeyCode() == KeyEvent.VK_S) {
//			this.switchToBattle();
//			System.out.println("switch");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}



}


