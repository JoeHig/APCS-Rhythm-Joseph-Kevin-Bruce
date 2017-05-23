package rhythm;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.Timer;

import main.RGMain;
//import main.KeyHandler;
//import main.RGMain;

import java.util.*;

public class BattlePanel extends JPanel implements Runnable, KeyListener, ActionListener {
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 800;

	private RGMain window;
	private Song s;
	private JPanel p1;
	private ArrayList<Attack> attack = new ArrayList<Attack>();
	private boolean once = true, once1 = true, inBeat = false;
	private Monster ogre;
	private BattlePlayer player;
	private Timer timer = new Timer(1, this);
	private Graphics2D g2;

	/**
	 * Initializes song, creates the player and enemy
	 * 
	 * @param w
	 */
	public BattlePanel(RGMain w) {
		super();
		this.window = w;
		p1 = new JPanel();
		p1.setBounds(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
		s = new Song(p1);
		add(p1);
		ogre = new Monster("ogre.gif", 600, 0, 50, 50);
		player = new BattlePlayer("player.png", 0, 0, 50, 50);
		setBackground(Color.WHITE);
		new Thread(this).start();
	}

	/**
	 * draws background such as health in the background
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint
									// the background
		int width = getWidth();
		int height = getHeight();
		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;
		g2 = (Graphics2D) g;
		g2.scale(ratioX, ratioY);
		g.setColor(new Color(205, 102, 29));
		g2.drawRect(0, 50, 30, 800);
		g2.drawRect(0, 50, 800, 0);
		ogre.draw(g, this);
		player.draw(g, this);
		initializeOnce();
		draw(g2);
		TimeSong();
		checkArrayList();
		update();
	}

	/**
	 * Initializes things such as timer and song, only once
	 */
	public void initializeOnce() {
		if (once) {
			initializeAttack();
			once = false;
		}
	}

	public void TimeSong() {
		if (once1) {
			s.start();
			timer.start();
			once1=false;
		}
	}

	/**
	 * Checks if attack is empty, then song stops, panel is switched
	 */
	private void checkArrayList() {
		if (attack.isEmpty()) {
			switchToWorld();
		}
	}

	/**
	 * Reads from file called "resources/Attack.txt" and initializes all attack
	 * objects into an ArrayList called attack
	 */
	private void initializeAttack() {
		readData("resources/Attack.txt");

	}

	private void draw(Graphics2D g) {

		for (Attack f : attack) {
			f.draw(g, this);
		}

	}

	/**
	 * Checks if the player's input is off of an attack, or if input was on an
	 * attack. removes
	 * 
	 * @return true if there was an attack, false if not
	 */
	private boolean checkBeat() {
		inBeat = false;
		int n = 0;
		for (Attack f : attack) {

			inBeat = (inBeat || f.intersects(0, 50, 30, 800));

			if (f.intersects(0, 50, 30, 800)) {
				attack.set(n, null);
			}

		}
		while (attack.contains(null)) {
			attack.remove(null);
		}
		return inBeat;
	}

	/**
	 * Checks if any Attacks gotten past the player. Deals 10 damage if so.
	 * Removes all attacks that went past the border
	 * 
	 */
	private void update() {
		int n = 0;
		for (Attack f : attack) {
			if (f.update()) {
				attack.set(n, null);
				player.removeHealth(10);
			}
			n++;
		}
		while (attack.contains(null)) {
			attack.remove(null);
		}

	}

	/**
	 * switches cardlayout to world.Also stops music
	 */
	public void switchToWorld() {
		s.stopSong();
		window.changePanel("1", false);
	}

	/**
	 * adds all of the attack objects into the arrayList attack;
	 * 
	 * @param fileName
	 *            Where the file is located
	 */
	private void readData(String fileName) {
		File dataFile = new File(fileName);

		if (dataFile.exists()) {

			FileReader reader = null;
			BufferedReader bReader = null;
			try {
				reader = new FileReader(dataFile);
				bReader = new BufferedReader(reader);

				String s;
				while ((s = bReader.readLine()) != null) {
					attack.add(new Attack("FireBall.png", Integer.parseInt(s), 500, 50, 50));
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
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (checkBeat()) {
				ogre.removeHealth(8);
				if (ogre.hp <= 0) {
					switchToWorld();
				}
			} else {
				player.removeHealth(10);
				if (player.hp <= 0) {
					switchToWorld();
				}
			}

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