package rpg;


public class WorldEnemy extends Tile {

	private int tileType;
	public WorldEnemy(String fileName,int x, int y) {
		super(fileName, x, y);

	}
	
	public int getTileType(){
		return 5;
	}

}