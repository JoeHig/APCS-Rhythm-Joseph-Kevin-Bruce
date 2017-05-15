package main;

import java.awt.event.*;
import javax.swing.*;

import rhythm.BattlePanel;
import rpg.WorldPanel;

import java.awt.*;


public class RGMain extends JFrame {

	JPanel cardPanel;
	
	public RGMain(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		WorldPanel panel1 = new WorldPanel(this);    
	    BattlePanel panel2 = new BattlePanel(this);
	    
	    addKeyListener(panel2.getKeyHandler());
	
	    cardPanel.add(panel1,"1");
	    cardPanel.add(panel2,"2");
	    
	    add(cardPanel);
	
	    setVisible(true);
	}

	public static void main(String[] args)
	{
		RGMain w = new RGMain("Rhythm World");
	}
  
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
	}
  
}