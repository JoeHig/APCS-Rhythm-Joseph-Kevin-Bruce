package rhythm;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import main.MovingImage;

public class Attack extends MovingImage {

	private int x, y, vel = -1;

	public Attack(String file, int x, int y, int w, int h) {
		super("resources" + System.getProperty("file.separator") + file, x, y, w, h);

	}

	@Override
	public void draw(Graphics g, ImageObserver io) {
		super.draw(g, io);
	}

	public boolean update() {
		moveByAmount(-1, 0);
		if (super.getX() < -super.width) {
			return true;
		} else
			return false;

	}

	public boolean updateBeat() {
		if (super.getX() < -super.width) {
			return true;
		} else
			return false;

	}

}
