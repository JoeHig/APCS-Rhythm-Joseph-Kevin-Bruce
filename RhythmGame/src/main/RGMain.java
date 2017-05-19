import javax.swing.*;

//import rhythm.BattlePanel;
//import rpg.WorldPanel;

import java.awt.*;

public class RGMain extends JFrame {

	JPanel cardPanel;
	private boolean isInWorld;
	private WorldPanel panel1;
	private BattlePanel panel2;
	private GameWonPanel panel3;

	public RGMain(String title) {
		super(title);
		isInWorld = true;
		setBounds(100, 100, 650, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);

		panel1 = new WorldPanel(this);
		panel2 = new BattlePanel(this);
		panel3 = new GameWonPanel(this);
		addKeyListener(panel1);

		cardPanel.add(panel1, "1");
		cardPanel.add(panel2, "2");
		cardPanel.add(panel3, "3");

		add(cardPanel);

		setVisible(true);
	}

	public static void main(String[] args) {
		RGMain w = new RGMain("Rhythm World");
	}

	public void changePanel(String name, boolean isWin) {
		isInWorld = !isInWorld;
		if (isWin) {
			this.removeKeyListener(panel1);
			this.removeKeyListener(panel2);
		} else if (isInWorld) {
			this.removeKeyListener(panel2);
			this.addKeyListener(panel1);
		} else {
			this.removeKeyListener(panel1);
			this.addKeyListener(panel2);
		}

		((CardLayout) cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}
}