package rhythm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import jay.jaysound.JayLayer;
import jay.jaysound.JayLayerListener;

public class Song implements JayLayerListener {

	String[] songs = new String[] { "game1.mp3", "game2.mp3", "game3.mp3", "game4.mp3", "game5.mp3" };
	String[] soundEffects = new String[] { "title1.mp3", "title2.mp3", "title3.mp3", "title4.mp3", "title5.mp3" };
	private JComboBox<String> effects;
	private JayLayer sound;
	private long position;

	public Song(JPanel p0) {
		super();

		p0.setLayout(new BoxLayout(p0, BoxLayout.Y_AXIS));
		p0.setBackground(Color.WHITE);

		//String[] soundEffects = new String[] { "title1.mp3", "title2.mp3", "title3.mp3", "title4.mp3", "title5.mp3" };
		String[] songs = new String[] { "game1.mp3", "game2.mp3", "game3.mp3", "game4.mp3" };

		//effects = new JComboBox<String>(soundEffects);

		sound = new JayLayer("resources/", "resources/", false);
		sound.addPlayList();
		sound.addSongs(0, songs);
		//sound.addSoundEffects(soundEffects);
		sound.changePlayList(0);
		sound.addJayLayerListener(this);


	}

	public long songPostion() {
		return position;
	}

	public void start() {
		
		sound.nextSong();
		System.out.print(sound.isPlaying());
		
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

	public void stopSong() {
		sound.stopSong();
	}

}
