package rpg;

public class PathTile extends Tile {
	public PathTile(int x, int y) {
		super("resources" + System.getProperty("file.separator") + "path.gif", x, y);
	}
	
	public int getTileType(){
		return 2;
	}

}
