package Rhythm;

import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;

public class Tester {

	public static void main(String[] args) {
		System.out.println("hello");

		Song n= new Song();
		
		PSurfaceAWT surf = (PSurfaceAWT) n.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		
		window.setSize(600, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setMinimumSize(new Dimension(100,100));
		window.setVisible(true);
		//n.draw();
		//n.setup();
	}
	
	

}
