package rhythm;

import main.MovingImage;

public class Actable extends MovingImage{

	int hp;
	public Actable(String file, int x, int y, int wid,int hig)
	{
		super(file,x,y,wid, hig);
		hp=100;
	}
	public void removeHealth(int x)
	{
		hp-=x;
	}
	
	
	
}