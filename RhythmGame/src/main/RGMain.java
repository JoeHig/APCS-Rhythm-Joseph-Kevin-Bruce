package main;

import javax.swing.*;
import rhythm.BattlePanel;
import rpg.GameWonPanel;
import rpg.WorldPanel;

import java.awt.*;

public class RGMain extends JFrame {

	JPanel cardPanel;
	private boolean isInWorld;
	private WorldPanel panel1;
	private BattlePanel panel2;
	private GameWonPanel panel3;
	private StartPanel panel0;

	public RGMain(String title) {
		super(title);
		isInWorld = true;
		setBounds(0, 0, 800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);

		panel0 = new StartPanel(this);
		panel1 = new WorldPanel(this);
		panel2 = new BattlePanel(this);
		panel3 = new GameWonPanel(this);

		cardPanel.add(panel0, "0");
		cardPanel.add(panel1, "1");
		cardPanel.add(panel2, "2");
		cardPanel.add(panel3, "3");


		add(cardPanel);

		setVisible(true);
	}

	public static void main(String[] args) {
		RGMain w = new RGMain("Rhythm World");
	}
	public void restartBattlePanel2() {
		cardPanel.remove(this);
		panel2 = new BattlePanel(this);
		cardPanel.add(panel2,"2");
	}
	public void addKeyListenerPanel1()
	{
		this.addKeyListener(panel1);
	}
	public void	addKeyListenerPanel2()
	{
		this.addKeyListener(panel2);
		System.out.println("x");
	}
	public void restartWorldPanel1() {
		cardPanel.remove(2);
		panel1 = new WorldPanel(this);
		cardPanel.add(panel1,"1");
	}
	
	

	public void changePanel(String name, boolean isWin,boolean isLost) {
		isInWorld = !isInWorld;
		if (isWin) {
			this.removeKeyListener(panel1);
			this.removeKeyListener(panel2);
		} else if (isInWorld) {
			//this.removeKeyListener(panel2);
			System.out.println("remove panel2");
			this.addKeyListener(panel1);
		} else {
			this.removeKeyListener(panel1);
			restartBattlePanel2();
			System.out.println("add panel2");

			
			
		}

		((CardLayout) cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}
}
