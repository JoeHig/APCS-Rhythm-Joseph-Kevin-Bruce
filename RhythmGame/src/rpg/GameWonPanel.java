package rpg;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import main.RGMain;

//import main.KeyHandler;
//import main.RGMain;

import java.util.*;

public class GameWonPanel extends JPanel implements Runnable {
	public static final int DRAWING_WIDTH = 650;
	public static final int DRAWING_HEIGHT = 650;

	private Rectangle screenRect;

	// private KeyHandler keyControl;
	private RGMain window;

	public GameWonPanel(RGMain w) {
		super();
		this.window = w;

		// keyControl = new KeyHandler();
		setBackground(Color.CYAN);
		screenRect = new Rectangle(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
	
		new Thread(this).start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint
									// the background

		Graphics2D g2 = (Graphics2D) g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

		g.setColor(new Color(205, 102, 29));
		
		// scrub.draw(g2,this);

		g2.setTransform(at);

		// TODO Add any custom drawings here
	}


	@Override
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



}