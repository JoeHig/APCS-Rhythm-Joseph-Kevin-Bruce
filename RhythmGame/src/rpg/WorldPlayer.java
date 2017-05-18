package rpg;

public class WorldPlayer extends Tile {

	public WorldPlayer(int x, int y) {
		super("resources" + System.getProperty("file.separator") + "worldplayer.gif", x, y);
	}

	public boolean canMove(Tile[][] world, int dir, int x, int y) {

		if (x < 1 || x > 38 || y < 1 || y > 38) {
			return false;
		}
		if (dir == 0) {
			if (world[x - 1][y].getTileType() == 1) {
				return false;
			} else if (world[x - 1][y].getTileType() == 2) {
				return true;
			}
		}
		if (dir == 1) {
			if (world[x + 1][y].getTileType() == 1) {
				return false;
			} else if (world[x + 1][y].getTileType() == 2) {
				return true;
			}
		}
		if (dir == 2) {
			if (world[x][y - 1].getTileType() == 1) {
				return false;
			} else if (world[x][y - 1].getTileType() == 2) {
				return true;
			}
		}
		if (dir == 3) {
			if (world[x][y + 1].getTileType() == 1) {
				return false;
			} else if (world[x][y + 1].getTileType() == 2) {
				return true;
			}
		}
		return false;

	}

	public int getTileType() {
		return 4;
	}
}
