package Rhythm;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import javax.swing.Timer;

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


public class Song extends PApplet{
	Minim minim;
	AudioPlayer song;
	String 	fileFolder;
	AudioMetaData meta;
	Song()
	{
	 runSketch();
	 sketchPath();
	}
	 
	public void setup()
	{
	background(0,255,255);  
	SongThread st = new SongThread("ThunderSound.mp3");
	st.play();

	/*
	 minim = new Minim(this);
	 
	  try {
		song = minim.loadFile(Tester.class.getResource("Sound3.mp3").toURI().toString());
		//song.play();
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally
	  {
		song.stop();
	  }
	  
	*/
	
	
	  //dataPath("game1.mp3")"F:\\Final AP\\AP CS Final\\data\\song1.wav"
	  //song.play();
	//  meta = song.getMetaData();
	 // super.stop();
	}
	 
	public void draw()
	{
		 
	}
	public String sketchPath( String fileName )
	{
		return Paths.get( fileFolder, fileName ).toString();
		
	}
	public InputStream createInput( String fileName )
	{
		FileInputStream stream = null;
		try
		{
			stream = new FileInputStream(sketchPath(fileName));
		}
		catch( FileNotFoundException ex )
		{
			System.err.println( "Unable to find file " + fileName );
		}
		
		return stream;
		
	}
	
}
