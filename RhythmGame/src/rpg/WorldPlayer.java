package rpg;
import main.MovingImage;

public class WorldPlayer extends MovingImage {

	public WorldPlayer(int x, int y) {
		super("worldplayer.gif", x, y,50,50);
	}

	public int move(int dir) {
		if (canMove()) {
			return dir;
		}
		return -1;
	}

	public boolean canMove() {
		
		return true;
	}

}
