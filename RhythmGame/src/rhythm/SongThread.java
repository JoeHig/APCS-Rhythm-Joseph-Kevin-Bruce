package Rhythm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.BeatDetect;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import ddf.minim.signals.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.ugens.*;
import ddf.minim.effects.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class SongThread extends Thread{

	private Player player;
	private File file;
	private boolean isLoop;
	private BufferedInputStream bis;
	private FileInputStream fis;
	
	public SongThread(String name)
	{
		try{
		file= new File(Tester.class.getResource(name).toURI());
		fis = new FileInputStream(file);
		bis = new BufferedInputStream(bis);
		player= new Player(bis);
		}
		catch (Exception e)
		{
			System.out.println("fix location");
		}
	}
	public void close()
	{
		player.close();
		this.interrupt();
	}
	public void play()
	{
		try{
		player.play();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	

}
