package rhythm;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import jay.jaysound.JayLayer;
import jay.jaysound.JayLayerListener;

public class Song implements JayLayerListener {

	String[] songs = new String[] { "game1.mp3", "game2.mp3", "game3.mp3", "game4.mp3", "game5.mp3" };
	String[] soundEffects = new String[] { "title1.mp3", "title2.mp3", "title3.mp3", "title4.mp3", "title5.mp3" };
	private JayLayer sound;

	/**
	 * Creates a song list
	 * 
	 * @param p0
	 *            Jpanel from
	 */
	public Song(JPanel p0) {
		super();

		String[] songs = new String[] { "game1.mp3"};

		sound = new JayLayer("resources/", "resources/", false);
		sound.addPlayList();
		sound.addSongs(0, songs);
		sound.changePlayList(0);
		sound.addJayLayerListener(this);

	}

	/**
	 * adds music
	 */
	public void start() {
		sound.nextSong();

	}

	@Override
	public void songEnded() {
		// TODO Auto-generated method stub

	}

	@Override
	public void playlistEnded() {
		// TODO Auto-generated method stub

	}

	@Override
	public void musicStarted() {

	}

	@Override
	public void musicStopped() {
	}

	/**
	 * removes music
	 */
	public void stopSong() {
		sound.stopSong();
	}

}
