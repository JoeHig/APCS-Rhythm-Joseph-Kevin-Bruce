package rhythm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class Monster extends Actable {

	/**
	 * creates MovingImage
	 * 
	 * @param file location of the picture
	 * @param x the top left location of the object's x cordinate
	 * @param y the top left location of the object's y cordinate
	 * @param wid the width of the object
	 * @param hgh the height of the object
	 */
	public Monster(String file, int x, int y, int wid, int hig) {
		super("resources" + System.getProperty("file.separator") + file, x, y, wid, hig);
		// TODO Auto-generated constructor stub
	}
	/**
	 * draws the enemy and its hp
	 */
	public void draw(Graphics g, ImageObserver io) {
		super.draw(g, io);
		g.drawRect(500, 0, 100, 50);
		g.drawRect(500, 0, hp, 50);

		g.setColor(Color.RED);
		g.fillRect(500, 00, hp, 50);
	}

}
