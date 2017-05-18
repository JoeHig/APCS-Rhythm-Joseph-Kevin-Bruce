package rpg;

public class DoorTile extends Tile {
	public DoorTile(int x, int y) {
		super("resources"+ System.getProperty("file.separator") +"door.gif", x, y);
	}
}
