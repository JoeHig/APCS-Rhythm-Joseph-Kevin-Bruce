package rpg;

public class Goblin extends WorldEnemy{

	public Goblin(int x, int y) {
		super("resources" + System.getProperty("file.separator") + "goblin.gif",x, y);
	}

}
