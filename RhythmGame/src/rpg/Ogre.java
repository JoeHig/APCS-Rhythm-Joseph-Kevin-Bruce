package rpg;
public class Ogre extends WorldEnemy {

	/**
	 * This represents the ogre enemy
	 * 
	 * @param x
	 *            is the row that this tile is to be placed at
	 * @param y
	 *            is the column that this tiles is to be placed at
	 */
	public Ogre(int x, int y) {
		super("resources/ogre.gif", x, y);
	}

}
