package rpg;
public class Goblin extends WorldEnemy {

	/**
	 * This represents the goblin enemy
	 * 
	 * @param x
	 *            is the row that this tile is to be placed at
	 * @param y
	 *            is the column that this tiles is to be placed at
	 */
	public Goblin(int x, int y) {
		super("resources/goblin.gif", x, y);
	}

}
