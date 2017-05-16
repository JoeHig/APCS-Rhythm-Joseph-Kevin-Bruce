package rpg;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

public class World {
	private Tile[][] screen;
	private Tile[][] theWorld;
	private WorldPlayer worldPlayer;
	private final int WORLD_ROWS = 39;
	private final int WORLDS_COLUMNS = 39;
	private int xMid = 0;
	private int yMid = 0;

	public World() {
		screen = new Tile[13][13];
		theWorld = new Tile[WORLD_ROWS][WORLDS_COLUMNS];

		for (int i = 0; i < theWorld.length; i++) {
			for (int j = 0; j < theWorld[i].length; j++) {
				if (i == 0 || j == 0 || i == theWorld.length - 1 || j == theWorld[i].length - 1) {
					theWorld[i][j] = new WallTile(i * 50, j * 50);
				} else {
					theWorld[i][j] = new PathTile(i * 50, j * 50);
				}
			}
		}
		setScreen();
	}

	public void drawWorld(Graphics2D g2, ImageObserver io) {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				Tile t = screen[i][j];
				t.draw(g2, io);
			}
		}
	}

	public Tile[][] getScreenGrid() {
		return theWorld;
	}

	public void setScreen() {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				screen[i][j] = theWorld[i][j];
	
			}
		}
	}

	public WorldPlayer getWorldPlayer() {
		return worldPlayer;
	}

	public void moveScreen(int dir) {
		if (dir == 0 && xMid > 0) {
			xMid--;
		}
		if (dir == 1 && xMid < 100) {
			xMid++;
		}
		if (dir == 2 && yMid > 0) {
			yMid--;
		}
		if (dir == 3 && yMid < 100) {
			yMid++;
		}
		setScreen();
	}
}
