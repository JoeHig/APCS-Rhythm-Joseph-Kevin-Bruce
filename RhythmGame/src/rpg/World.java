package rpg;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class World {

	private Tile[][] world;
	private WorldPlayer worldPlayer;
	private final int WORLD_ROWS = 65;
	private final int WORLD_COLUMNS = 65;
	private int xWorld;
	private int yWorld;
	private WorldPanel wPanel;
	private boolean inBattle;

	public World(WorldPanel wPanel) {
		inBattle = false;
		world = new Tile[WORLD_ROWS][WORLD_COLUMNS];
		readData("resources" + System.getProperty("file.separator") + "world.txt");
		this.wPanel = wPanel;
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[0].length; j++) {
				if (world[i][j].getTileType() == worldPlayer.getTileType()) {
					xWorld = i;
					yWorld = j;

				}
			}
		}

	}

	private void readData(String fileName) {
		File dataFile = new File(fileName);

		if (dataFile.exists()) {

			FileReader reader = null;
			BufferedReader bReader = null;
			try {
				reader = new FileReader(dataFile);
				bReader = new BufferedReader(reader);

				int i = 0;
				String s;
				while ((s = bReader.readLine()) != null) {
					for (; i < world.length;) {

						for (int j = 0; j < world[0].length; j++) {
							char c = s.charAt(j);
							if (c == 'x') {
								world[i][j] = new WallTile(i, j);
							} else if (c == 'p') {
								world[i][j] = new PathTile(i, j);
							} else if (c == 'h') {
								worldPlayer = new WorldPlayer(i, j);
								world[i][j] = worldPlayer;
							} else if (c == 'd') {
								world[i][j] = new DoorTile(i, j);
							} else if (c == 'm') {
								int num = (int) (Math.random() * 3);
								if (num == 0) {
									world[i][j] = new Zombie(i, j);
								} else if (num == 1) {
									world[i][j] = new Ogre(i, j);
								} else if (num == 2) {
									world[i][j] = new Goblin(i, j);
								}
							}
						}
						i++;
						break;
					}
				}

			} catch (NumberFormatException ex) {
				System.out.println("File is in the wrong format.");

			} catch (IOException ex) {
				System.out.println("File cannot be read.");
				ex.printStackTrace();
			} finally {
				try {
					bReader.close();
				} catch (IOException ex) {
					System.out.println("File cannot be closed.");
				}
			}

		} else

		{
			throw new IllegalArgumentException("Data file " + fileName + " does not exist.");
		}
	}

	public void drawWorld(Graphics2D g2, ImageObserver io) {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				Tile t = null;
				if (i + xWorld - 6 >= 0 && i + xWorld + 6 <= 50 && j + yWorld - 6 >= 0 && j + yWorld + 6 <= 50) {
					t = world[i + xWorld - 6][j + yWorld - 6];
				} else {
					t = new ScreenTile(i, j);
				}
				t.setTileLocation(i, j);
				t.draw(g2, io);
			}
		}
	}

	public void moveScreen(int dir) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[0].length; j++) {
				if (world[i][j].getTileType() == worldPlayer.getTileType()) {
					x = i;
					y = j;
				}
			}
		}

		if (checkBattle(x, y) >= 0 && !inBattle) {
			if (dir == 0) {
				world[x - 1][y] = new PathTile(x - 1, y);
			} else if (dir == 1) {
				world[x + 1][y] = new PathTile(x + 1, y);
			} else if (dir == 2) {
				world[x][y - 1] = new PathTile(x, y - 1);
			} else if (dir == 3) {
				world[x][y + 1] = new PathTile(x, y + 1);

			}
			wPanel.switchToBattle();
			inBattle = true;
		}

		if (checkExit(x, y) >= 0) {
			System.out.println("Win");
			wPanel.switchToWin();
		}

		if (dir == 0 && xWorld > 1 && (world[x - 1][y].getTileType() == 2 || world[x - 1][y].getTileType() == 3)) {
			moveWorldPlayer(0, x, y);
			xWorld--;
		} else if (dir == 1 && xWorld < WORLD_ROWS - 2
				&& (world[x + 1][y].getTileType() == 2 || world[x + 1][y].getTileType() == 3)) {
			moveWorldPlayer(1, x, y);
			xWorld++;
		} else if (dir == 2 && yWorld > 1
				&& (world[x][y - 1].getTileType() == 2 || world[x][y - 1].getTileType() == 3)) {
			moveWorldPlayer(2, x, y);
			yWorld--;
		} else if (dir == 3 && yWorld < WORLD_COLUMNS - 2
				&& (world[x][y + 1].getTileType() == 2 || world[x][y + 2].getTileType() == 3)) {
			moveWorldPlayer(3, x, y);
			yWorld++;
		}

	}

	public void moveWorldPlayer(int dir, int x, int y) {
		// System.out.println(x + "," + y);
		Tile t = world[x][y];
		if (dir == 0 && x > 0) {
			world[x - 1][y] = t;
			world[x][y] = new PathTile(x, y);
		}
		if (dir == 1 && x < WORLD_ROWS - 1) {
			world[x + 1][y] = t;
			world[x][y] = new PathTile(x, y);
		}
		if (dir == 2 && y > 0) {
			world[x][y - 1] = t;
			world[x][y] = new PathTile(x, y);
		}
		if (dir == 3 && y < WORLD_COLUMNS - 1) {
			world[x][y + 1] = t;
			world[x][y] = new PathTile(x, y);
		}
	}

	public int checkBattle(int x, int y) {
		if (world[x - 1][y].getTileType() == 5) {
			return 0;
		} else if (world[x + 1][y].getTileType() == 5) {
			return 1;
		} else if (world[x][y - 1].getTileType() == 5) {
			return 2;
		} else if (world[x][y + 1].getTileType() == 5) {
			return 3;
		}
		return -1;
	}

	public int checkExit(int x, int y) {
		if (world[x - 1][y].getTileType() == 3) {
			return 0;
		} else if (world[x + 1][y].getTileType() == 3) {
			return 1;
		} else if (world[x][y - 1].getTileType() == 3) {
			return 2;
		} else if (world[x][y + 1].getTileType() == 3) {
			return 3;
		}
		return -1;
	}

}
