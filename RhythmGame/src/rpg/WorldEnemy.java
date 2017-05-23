package rpg;



public class WorldEnemy extends Tile {

	private int tileType;

	/**
	 * The tile representation of the enemy in the world
	 * 
	 * @param fileName
	 *            the file name of the image of the enemy
	 * @param x
	 *            is the row that this enemy is to be placed at
	 * @param y
	 *            is the column that this enemy is to be placed at
	 */
	public WorldEnemy(String fileName, int x, int y) {
		super(fileName, x, y);

	}

	/**
	 * Returns the id of tile type
	 * 
	 * @returns the integer 3
	 */
	public int getTileType() {
		return 5;
	}

}
