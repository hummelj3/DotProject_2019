import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

public class SpawnDot extends JPanel
{
	public static int dotCoords[];
	public static int quad; 
	private RandomCoord random;
	private int max = 4;
	private int min = 1;
	public SpawnDot(Graphics2D g2)
	{
		//getting screensize 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//center coords for circle
		int centerX = screenSize.width/2;
		int centerY = screenSize.height/2;
		
		//make RandomCoord
		random = new RandomCoord();
		
		//make rand
		Random rand = new Random();
		
		//randomly choose quadrant to spawn dot in
		Boolean enterIf = false;
		int qspawn = 0;
		while(!enterIf)
		{
			int randomQuad = rand.nextInt((max - min) + 1) + min;
			if((randomQuad == 1) && DotUIFrame.trackQuad1 >= 0)
			{
				qspawn = randomQuad;
				enterIf = true;
			}
			if((randomQuad == 2) && DotUIFrame.trackQuad2 >= 0)
			{
				qspawn = randomQuad;
				enterIf = true;
			}
			if((randomQuad == 3) && DotUIFrame.trackQuad3 >= 0)
			{
				qspawn = randomQuad;
				enterIf = true;
			}
			if((randomQuad == 4) && DotUIFrame.trackQuad4 >= 0)
			{
				qspawn = randomQuad;
				enterIf = true;
			}
		}
				
		//Spawns dot in specified quad
		int[] xy = random.randCoord(1);
		
		//temp:
		int x = screenSize.width / 2 - 10;
		int y = screenSize.height / 2 - 10;
		
		//draws dot
		g2.drawOval(xy[0],xy[1],10,10);
		
		//saves which quadrant dot spawned in to sends to txt file:
		//if quad 1
		if(xy[0] > centerX && xy[1] > centerY)
		{
			quad = 1;
			DotUIFrame.trackQuad1--;
		}
		
		//if quad 2 
		if(xy[0] > centerX && xy[1] < centerY)
		{
			quad = 2;
			DotUIFrame.trackQuad2--;
		}
		
		//if quad 3
		if(xy[0] < centerX && xy[1] < centerY)
		{
			quad = 3;
			DotUIFrame.trackQuad3--;
		}
		
		//if quad 4
		if(xy[0] < centerX && xy[1] > centerY)
		{
			quad = 4;
			DotUIFrame.trackQuad4--;
		}
		
		//will only happen in testing
		if(xy[0] == centerX && xy[1] == centerY)
		{
			quad = 0;
		}
		
		//if testing mode == true then print relevant info
		if(DotUIFrame.testing == true)
		{
			System.out.println("quad: " + quad);
			System.out.println("track num q1: " + DotUIFrame.trackQuad1 + " track num q2: " + DotUIFrame.trackQuad2);
			System.out.println("track num q3: " + DotUIFrame.trackQuad3 + " track num q4: " + DotUIFrame.trackQuad4);
			System.out.println("quadSpawn: " + qspawn);
		}
	}
	
}
