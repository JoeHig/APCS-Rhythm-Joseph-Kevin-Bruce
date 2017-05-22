package rhythm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class Monster extends Actable{

	public Monster(String file,int x,int y, int wid,int hig) {
		super("resources" + System.getProperty("file.separator")+file,x,y,wid,hig);
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g, ImageObserver io)
	{
		super.draw(g, io);
		g.drawRect(500,0,100,50);
		g.drawRect(500,0,hp,50);
		
		g.setColor(Color.RED);
		g.fillRect(500,00,hp,50);
	}

}
