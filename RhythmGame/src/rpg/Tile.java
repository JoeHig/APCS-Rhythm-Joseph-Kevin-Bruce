package rpg;
import main.MovingImage;

public class Tile extends MovingImage {

	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;

	public Tile(String fileName, int x, int y) {
		super(fileName, x, y, WIDTH, HEIGHT);

	}

}
