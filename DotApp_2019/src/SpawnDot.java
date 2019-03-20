import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class SpawnDot extends JPanel
{
	public SpawnDot(Graphics2D g2)
	{
		//getting screensize 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//center coords for circle
		int centerX = screenSize.width/2;
		int centerY = screenSize.height/2;
		
		//TODO: math to spawn dot 
		//int[] xy = RandCoord();
		
		//temp:
		int x = screenSize.width / 2 - 10;
		int y = screenSize.height / 2 - 10;
		
		//draws dot
		g2.drawOval(x,y,10,10);
		
		//if quad 1
		if(x > centerX && y > centerY)
		{
			DotTimer.quad = 1;
		}
		
		//if quad 2 
		
		//if quad 3
		
		//if quad 4
	}
	
}
