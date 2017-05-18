package rpg;

public class Tile extends MovingImage {

	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;

	public Tile(String fileName, int x, int y) {
		super(fileName, x * 50, y * 50, WIDTH, HEIGHT);

	}

	public void setTileLocation(int x, int y) {
		super.x = x * 50;
		super.y = y * 50;
	}
	
	public int getTileType(){
		return 0;
	}

}
