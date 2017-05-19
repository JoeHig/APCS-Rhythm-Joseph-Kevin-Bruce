package rpg;

public class WorldPlayer extends Tile {

	/**
	 * The tile representation of the player in the world
	 * 
	 * @param x
	 *            is the row that this player is to be placed at
	 * @param y
	 *            is the column that this player is to be placed at
	 */
	public WorldPlayer(int x, int y) {
		super("worldplayer.gif", x, y);
	}

	/**
	 * Checks to see if the player is able to move in the world
	 * 
	 * @param world
	 *            the tile representation of the world
	 * @param dir
	 * @param x
	 *            is the row that the player is to be placed at
	 * @param y
	 *            is the column that the player is to be placed at
	 * @return true if the player can move to the specified location or false if
	 *         it can't
	 */
	public boolean canMove(Tile[][] world, int dir, int x, int y) {

		if (x < 1 || x > 38 || y < 1 || y > 38) {
			return false;
		}
		if (dir == 0) {
			if (world[x - 1][y].getTileType() == 1) {
				return false;
			} else if (world[x - 1][y].getTileType() == 2) {
				return true;
			}
		}
		if (dir == 1) {
			if (world[x + 1][y].getTileType() == 1) {
				return false;
			} else if (world[x + 1][y].getTileType() == 2) {
				return true;
			}
		}
		if (dir == 2) {
			if (world[x][y - 1].getTileType() == 1) {
				return false;
			} else if (world[x][y - 1].getTileType() == 2) {
				return true;
			}
		}
		if (dir == 3) {
			if (world[x][y + 1].getTileType() == 1) {
				return false;
			} else if (world[x][y + 1].getTileType() == 2) {
				return true;
			}
		}
		return false;

	}
	/**
	 * Returns the id of this tile type
	 * @returns the integer 4 
	 */
	public int getTileType() {
		return 4;
	}
}
