import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class SpawnDot extends JPanel
{
	public static int dotCoords[];
	public static int quad; 
	//private RandomCoord rand;
	
	public SpawnDot(Graphics2D g2)
	{
		//getting screensize 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//center coords for circle
		int centerX = screenSize.width/2;
		int centerY = screenSize.height/2;
		
		//TODO: math to spawn dot 
		//rand = new RandomCoord();
		//int[] xy = rand();
		
		//temp:
		int x = screenSize.width / 2 - 10;
		int y = screenSize.height / 2 - 10;
		
		//draws dot
		g2.drawOval(x,y,10,10);
		
		//saves which quadrant dot spawned in to sends to txt file:
		//if quad 1
		if(x > centerX && y > centerY)
		{
			quad = 1;
		}
		
		//if quad 2 
		if(x > centerX && y < centerY)
		{
			quad = 2;
		}
		
		//if quad 3
		if(x < centerX && y < centerY)
		{
			quad = 3;
		}
		
		//if quad 4
		if(x < centerX && y > centerY)
		{
			quad = 4;
		}
	}
	
}
