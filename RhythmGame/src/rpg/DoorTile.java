package rpg;
public class DoorTile extends Tile {

	/**
	 * The tile that represents a door also the exit at the xth row and yth column in the world
	 * 
	 * @param x
	 *            is the row that this tile is to be placed at
	 * @param y
	 *            is the column that this tiles is to be placed at
	 */
	public DoorTile(int x, int y) {
		super("resources/door.gif", x, y);
	}

	/**
	 * Returns the id of this tile type
	 * @returns the integer 3 
	 */
	public int getTileType() {
		return 3;
	}
}
