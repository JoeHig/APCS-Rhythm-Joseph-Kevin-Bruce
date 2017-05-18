package rpg;

public class WallTile extends Tile {
	public WallTile(int x, int y) {
		super("resources" + System.getProperty("file.separator") + "wall.gif", x, y);
	}
	
	public int getTileType(){
		return 1;
	}
}
