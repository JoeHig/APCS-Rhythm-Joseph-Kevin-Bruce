package rpg;


public class WorldEnemy extends Tile {
	
	
	public WorldEnemy() { // Put here to remove compiler errors. should be removed once ogre, zombie, & goblin are done.
		super("", 0, 0);
	}
	
	
	public WorldEnemy(int x, int y) {
		super("mario.png", x, y);

	}

}
