package rpg;

public class ScreenTile extends Tile {

	/**
	 * The tile that represents an empty spot in the screen of the game
	 * 
	 * @param x
	 *            is the row that this tile is to be placed at
	 * @param y
	 *            is the column that this tiles is to be placed at
	 */
	public ScreenTile(int x, int y) {
		super("screentile.gif", x, y);
	}

}
