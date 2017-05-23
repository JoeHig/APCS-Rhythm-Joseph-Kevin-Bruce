package rhythm;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import main.MovingImage;

public class Attack extends MovingImage {

	private int x, y, vel = -1;

	/**
	 * Creates MovingImage
	 * 
	  * @param file location of the picture
	 * @param x the top left location of the object's x cordinate
	 * @param y the top left location of the object's y cordinate
	 * @param wid the width of the object
	 * @param hgh the height of the object
	 **/ 
	public Attack(String file, int x, int y, int w, int h) {
		super("resources" + System.getProperty("file.separator") + file, x, y, w, h);

	}

	@Override
	public void draw(Graphics g, ImageObserver io) {
		super.draw(g, io);
	}

	/**
	 * moves to the left by one unit
	 * 
	 * @return true if attack is out of bounds, else false
	 */
	public boolean update() {
		moveByAmount(-1, 0);
		if (super.getX() < -super.width) {
			return true;
		} else
			return false;

	}

}
