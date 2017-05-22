package rhythm;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.util.*;
import main.MovingImage;

public class BattlePlayer extends Actable {

	public BattlePlayer(String file, int x, int y, int wid, int hig) {
		super("resources" + System.getProperty("file.separator") + file, x, y, wid, hig);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g, ImageObserver io) {
		super.draw(g, io);
		g.drawRect(50, 00, 100, 50);
		g.drawRect(50, 00, hp, 50);

		g.setColor(Color.RED);
		g.fillRect(50, 0, hp, 50);
	}
}
