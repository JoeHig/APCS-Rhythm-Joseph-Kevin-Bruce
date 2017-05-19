import java.awt.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WorldPanel extends JPanel implements Runnable, KeyListener {
	public static final int DRAWING_WIDTH = 650;
	public static final int DRAWING_HEIGHT = 650;

	private World world;
	private RGMain window;

	/**
	 * Panel where the world is to be drawn on
	 * 
	 * @param window
	 *            the window that this panel is drawn on
	 */
	public WorldPanel(RGMain window) {
		super();

		this.window = window;
		setBackground(Color.WHITE);

		world = new World(this);

		new Thread(this).start();
	}

	/**
	 * Draws the panel using graphics
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
		window.changePanel("2", false);
	}

	public void switchToWin() {
		window.changePanel("3", true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			world.moveScreen(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			world.moveScreen(1);
		if (e.getKeyCode() == KeyEvent.VK_UP)
			world.moveScreen(2);
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			world.moveScreen(3);
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