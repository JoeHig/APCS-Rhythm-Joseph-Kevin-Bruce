package rpg;

public class Tile extends DrawableImage {

	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;

	/**
	 * Represents a single position in the world
	 * 
	 * @param fileName
	 *            the name of the image file
	 * 
	 * @param x
	 *            is the row that this tile is to be placed at
	 * @param y
	 *            is the column that this tiles is to be placed at
	 */
	public Tile(String fileName, int x, int y) {
		super(fileName, x * 50, y * 50, WIDTH, HEIGHT);

	}

	/**
	 * Changes the tiles location on the screen
	 * 
	 * @param x
	 *            is the row that this tile is at
	 * @param y
	 *            is the column that this tile is at
	 */
	public void setTileLocation(int x, int y) {
		super.x = x * 50;
		super.y = y * 50;
	}

	/**
	 * Returns the id of tile type
	 * @return the integer 0
	 */
	public int getTileType() {
		return 0;
	}

}
