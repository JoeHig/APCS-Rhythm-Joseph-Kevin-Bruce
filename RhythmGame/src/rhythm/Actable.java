package rhythm;

import main.MovingImage;

public class Actable extends MovingImage {

	int hp;

	/**
	 * creates MovingImage with hp of 100
	 * 
	 * @param file location of the picture
	 * @param x the top left location of the object's x cordinate
	 * @param y the top left location of the object's y cordinate
	 * @param wid the width of the object
	 * @param hgh the height of the object
	 */
	public Actable(String file, int x, int y, int wid, int hgh) {
		super(file, x, y, wid, hgh);
		hp = 100;
	}

	/**
	 * decreases HP my amount x
	 * @param x rate of hp decreasing
	 */
	public void removeHealth(int x) {
		hp -= x;
	}

}