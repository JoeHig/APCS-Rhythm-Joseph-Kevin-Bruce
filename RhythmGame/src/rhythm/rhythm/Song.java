package rhythm;		
 import java.io.FileInputStream;		
 import java.io.FileNotFoundException;		
 import java.io.InputStream;		
 import java.nio.file.Paths;			
 import ddf.minim.AudioPlayer;		
 import ddf.minim.Minim;		
 import processing.core.PApplet;				
 import ddf.minim.*;			
 		
 		
 public class Song extends PApplet{		
 	Minim minim;		
 	AudioPlayer song;		
 	String 	fileFolder;		
 	AudioMetaData meta;		
 	SongThread st;
 	
 	
 	public Song()		
 	{		
 	 runSketch();		
 	 sketchPath();		
 	}		
 	 		
 	public void setup()		
 	{		
 		/*
 		st = new SongThread("resources" + System.getProperty("file.separator") + "Sound.mp3");		
 		st.play();		
 		*/
 	
 		minim = new Minim(this);		 		
 		song = minim.loadFile(dataPath("resources" + System.getProperty("file.separator") + "Sound.mp3"));		
 		//song.play();		 
	
 	}	
 	
 	public void draw()		
 	{		
 	 	background(0,255,255);  		
 	}		
 	public void stop()
 	{
 		song.close();
 		minim.stop();
 		super.stop();
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