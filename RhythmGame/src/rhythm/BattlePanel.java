package rhythm;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;

import main.KeyHandler;
import main.RGMain;

import java.util.*;


public class BattlePanel extends JPanel implements Runnable
{
  public static final int DRAWING_WIDTH = 800;
  public static final int DRAWING_HEIGHT = 600;
  
  private Rectangle screenRect;
	
  private BattlePlayer scrub;
  private ArrayList<Shape> obstacles;
  
  private KeyHandler keyControl;
  private RGMain window;


  public BattlePanel (RGMain w) {
	  super();
	  this.window = w;
	  
	  keyControl = new KeyHandler();
	  setBackground(Color.CYAN);
	  screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
	  obstacles = new ArrayList<Shape>();
	  obstacles.add(new Rectangle(200,400,400,50));
	  obstacles.add(new Rectangle(0,250,100,50));
	  obstacles.add(new Rectangle(700,250,100,50));
	  obstacles.add(new Rectangle(375,300,50,100));
	  obstacles.add(new Rectangle(300,250,200,50));
	  spawnNewMario();
	  new Thread(this).start();
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

	Graphics2D g2 = (Graphics2D)g;

    int width = getWidth();
    int height = getHeight();
    
    double ratioX = (double)width/DRAWING_WIDTH;
    double ratioY = (double)height/DRAWING_HEIGHT;
    
    AffineTransform at = g2.getTransform();
    g2.scale(ratioX, ratioY);

    g.setColor(new Color(205,102,29));
    for (Shape s : obstacles) {
    	g2.fill(s);
    }
    scrub.draw(g2,this);
    
    g2.setTransform(at);

	// TODO Add any custom drawings here
  }

  
  public void spawnNewMario() {
	  scrub = new BattlePlayer(DRAWING_WIDTH/2-BattlePlayer.MARIO_WIDTH/2,50);
  }
  
  public KeyHandler getKeyHandler() {
	  return keyControl;
  }


  public void run() {
	while (true) { // Modify this to allow quitting
		long startTime = System.currentTimeMillis();
		
		if (keyControl.isPressed(KeyEvent.VK_LEFT))
	  		scrub.walk(-1);
		if (keyControl.isPressed(KeyEvent.VK_RIGHT))
	  		scrub.walk(1);
		if (keyControl.isPressed(KeyEvent.VK_UP))
	  		scrub.jump();
	
	  	scrub.act(obstacles);
	  	
	  	if (!screenRect.intersects(scrub))
	  		spawnNewMario();
	  	
	  	repaint();
	  	
	  	long waitTime = 17 - (System.currentTimeMillis()-startTime);
	  	try {
	  		if (waitTime > 0)
	  			Thread.sleep(waitTime);
	  		else
	  			Thread.yield();
	  	} catch (InterruptedException e) {}
	}
	
  }
  
  
  	public void switchToWorld() {
		window.changePanel("1");
	}


}