package rpg;

public class Ogre extends WorldEnemy {

	public Ogre(int x, int y) {
		super("resources" + System.getProperty("file.separator") + "ogre.gif", x, y);
	}

}
