package rpg;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import java.util.*;
import main.RGMain;

public class GameWonPanel extends JPanel implements Runnable {
	public static final int DRAWING_WIDTH = 650;
	public static final int DRAWING_HEIGHT = 650;

	private Rectangle screenRect;
	private RGMain window;

	/**
	 * Is the panel that draws the screen when the player escapes the world
	 * 
	 * @param w
	 *            the window that this panel is drawn on
	 */
	public GameWonPanel(RGMain w) {
		super();
		this.window = w;

		setBackground(Color.BLACK);
		screenRect = new Rectangle(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);

		new Thread(this).start();
	}

	/**
	 * Draws this panel which is screen that tells the user that they have won the game using
	 * graphics
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

		Font myFont = new Font("Serif", Font.BOLD, 35);
		String score = "You Have Escaped!";
		g2.setColor(Color.WHITE);
		g2.setFont(myFont);
		g2.drawString(score, width / 4, height / 4);

		g2.setTransform(at);

	}

	/**
	 * Method that runs while this panel is in the window
	 */
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
