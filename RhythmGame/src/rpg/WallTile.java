package rpg;
public class WallTile extends Tile {
	/**
	 * Represents the tile that the player can't walk on or onto
	 * 
	 * @param x
	 *            is the row that this tile is to be placed at
	 * @param y
	 *            is the column that this tiles is to be placed at
	 */
	public WallTile(int x, int y) {
		super("resources/wall.gif", x, y);
	}

	/**
	 * Returns the id of this tile type
	 * 
	 * @returns the integer 1
	 */
	public int getTileType() {
		return 1;
	}
}
