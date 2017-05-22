package rhythm;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import javax.swing.Timer;

import main.RGMain;
//import main.KeyHandler;
//import main.RGMain;

import java.util.*;

public class BattlePanel extends JPanel implements Runnable, KeyListener, ActionListener {
	public static final int DRAWING_WIDTH = 650;
	public static final int DRAWING_HEIGHT = 650;

	private Rectangle screenRect;

	// private BattlePlayer scrub;
	private ArrayList<Shape> obstacles;

	// private KeyHandler keyControl;
	private RGMain window;
	private Song s;
	private JPanel p1;
	private ArrayList<Attack> attack = new ArrayList<Attack>();
	private boolean once = true, inBeat = false;
	private Monster ogre;
	private BattlePlayer player;
	Attack att = new Attack("FireBall.png", 500, 500, 50, 50);
	Timer timer = new Timer(1, this);
	Graphics2D g2;

	public BattlePanel(RGMain w) {
		super();
		this.window = w;
		p1 = new JPanel();
		p1.setBounds(0, 0, 800, 800);
		s = new Song(p1);
		add(p1);
		ogre = new Monster("ogre.gif", 600, 0, 50, 50);
		player = new BattlePlayer("player.png", 0, 0, 50, 50);
		// keyControl = new KeyHandler();
		setBackground(Color.WHITE);

		// spawnNewMario();
		// new Thread(this).start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint
									// the background
		int width = getWidth();
		int height = getHeight();
		g2 = (Graphics2D) g;
		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;
		g2.scale(ratioX, ratioY);
		g.setColor(new Color(205, 102, 29));
		AffineTransform at = g2.getTransform();
		g2.setTransform(at);
		g2.drawRect(0, 50, 30, 800);
		g2.drawRect(0, 50, 800, 0);
		ogre.draw(g, this);
		player.draw(g, this);

		if (once) {
			initializeAttack();
			draw(g2);
			s.start();
			timer.start();
			once = false;
		}
		checkArrayList();
		draw(g2);
		update(g2);
	}

	private void checkArrayList() {
		if (attack.isEmpty()) {
			s.stopSong();
			switchToWorld();
			//new BattlePanel(window);
		}
	}

	private void initializeAttack() {
		// this is where file IO comes
		attack.add(att);
	}

	private void draw(Graphics2D g) {

		for (Attack f : attack) {
			f.draw(g, this);
		}

	}

	private boolean checkBeat() {
		inBeat = false;
		for (Attack f : attack) {
			inBeat = (inBeat || f.intersects(0, 50, 30, 800));
		}
		System.out.println(inBeat);
		return inBeat;
	}

	private void update(Graphics2D g) {
		int n = 0;
		for (Attack f : attack) {
			if (f.update(g)) {
				attack.set(n, null);
			}
			n++;
		}
		while (attack.contains(null)) {
			attack.remove(null);
			System.out.println("remove null");
		}

	}

	public void switchToWorld() {
		s.stopSong();
		window.changePanel("1", false);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (checkBeat())
			{
				ogre.removeHealth(50);
				attack.remove(0);
			}
			else
				player.removeHealth(50);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		if (ev.getSource() == timer) {
			repaint();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}