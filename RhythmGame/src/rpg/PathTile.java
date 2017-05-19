
public class PathTile extends Tile {
	
	/**
	 * The tile that represents the path the player can walk on in the world
	 * 
	 * @param x
	 *            is the row that this tile is to be placed at
	 * @param y
	 *            is the column that this tiles is to be placed at
	 */
	public PathTile(int x, int y) {
		super("path.gif", x, y);
	}
	/**
	 * Returns the id of this tile type
	 * @returns the integer 2 
	 */
	public int getTileType(){
		return 2;
	}

}
