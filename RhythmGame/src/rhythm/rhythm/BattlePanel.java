package rhythm;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import main.RGMain;

//import main.KeyHandler;
//import main.RGMain;

import java.util.*;

public class BattlePanel extends JPanel implements Runnable,KeyListener {
	public static final int DRAWING_WIDTH = 650;
	public static final int DRAWING_HEIGHT = 650;

	private Rectangle screenRect;

	// private BattlePlayer scrub;
	private ArrayList<Shape> obstacles;

	// private KeyHandler keyControl;
	private RGMain window;

	public BattlePanel(RGMain w) {
		super();
		this.window = w;

		// keyControl = new KeyHandler();
		setBackground(Color.CYAN);
		screenRect = new Rectangle(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
		obstacles = new ArrayList<Shape>();
		obstacles.add(new Rectangle(200, 400, 400, 50));
		obstacles.add(new Rectangle(0, 250, 100, 50));
		obstacles.add(new Rectangle(700, 250, 100, 50));
		obstacles.add(new Rectangle(375, 300, 50, 100));
		obstacles.add(new Rectangle(300, 250, 200, 50));
		// spawnNewMario();
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
		for (Shape s : obstacles) {
			g2.fill(s);
		}
		// scrub.draw(g2,this);

		g2.setTransform(at);

		// TODO Add any custom drawings here
	}
	public void switchToWorld() {
		window.changePanel("1");
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

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_E) {
			switchToWorld();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}