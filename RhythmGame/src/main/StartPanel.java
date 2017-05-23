package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.geom.AffineTransform;

public class StartPanel extends JPanel implements ActionListener {

	private RGMain window;
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 800;
	private Graphics2D g2;
	private MovingImage img = new MovingImage("resources" + System.getProperty("file.separator") + "MainScreen", 0, 0,
			800, 800);
	private JPanel p1;

	/**
	 * panel where the main screen is created
	 * @param w
	 */
	public StartPanel(RGMain w) {
		super();
		this.window = w;
		p1 = new JPanel();	
		setBackground(Color.WHITE);
		setBounds(0, 0, 800, 600);
		JButton Start = new JButton("Start!");
		Start.addActionListener(this);
		p1.add(Start);
		add(p1);


	}
	/**
	 * draws using graphics
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint
									// the background
		int width = getWidth();
		int height = getHeight();
		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;
		
		g2 = (Graphics2D) g;
		AffineTransform at = g2.getTransform();
		g2.setTransform(at);
		g2.scale(ratioX, ratioY);
		
		

		img.draw(g, this);
		
	}
	/**
	 * Changes cardLayout to world
	 */
	public void switchToWorld() {
		window.restartWorldPanel1();
		window.changePanel("1", false);
		window.addKeyListenerPanel1();

	}
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if (source.equals("Start!")) {
			this.remove(p1);
			switchToWorld();
			
		}
	}
}
