package rpg;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import javax.swing.*;

public class DrawableImage extends Rectangle2D.Double {

	private Image image;

	/**
	 * This represents anything that can be drawn on the screen
	 * 
	 * @param filename
	 *            the name of the image file
	 * @param x
	 *            position of the image along the x axis in pixels
	 * @param y
	 *            position of the image along the y axis in pixels
	 * @param w
	 *            the width of the image in pixels
	 * @param h
	 *            the height of the image in pixels
	 */
	public DrawableImage(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(), x, y, w, h);
	}

	/**
	 * This represents anything that can be drawn on the screen
	 * 
	 * @param img
	 *            the image file to be used
	 * @param x
	 *            position of the image along the x axis in pixels
	 * @param y
	 *            position of the image along the y axis in pixels
	 * @param w
	 *            the width of the image in pixels
	 * @param h
	 *            the height of the image in pixels
	 */
	public DrawableImage(Image img, int x, int y, int w, int h) {
		super(x, y, w, h);
		image = img;
	}

	/**
	 * Draws this image 
	 * @param g2 renderer for two dimensional objects
	 * @param io the image observer to be notified
	 * @post the image is drawn with the given attributes
	 */
	public void draw(Graphics2D g2, ImageObserver io) {
		g2.drawImage(image, (int) x, (int) y, (int) width, (int) height, io);
	}

}
