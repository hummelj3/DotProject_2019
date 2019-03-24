import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JPanel;


public class CirclePanel extends JPanel 
{
	
	private static final long serialVersionUID = -4871329561880268345L;
	
	private SpawnDot dotSpawn;
	
	public static int radius;
	
	public void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);
		
		//getting screensize 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//dimensions of circle
		int x = screenSize.width / 2 - 400;
		int y = screenSize.height / 2 - 400;
		radius = 400;
		
		//setting color and line weight
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		
		//drawing circle to center of screen
		g2.drawOval(x, y, radius * 2, radius * 2);
		
		//TODO: draw dot w/in circle
		if(DotTimer.time == 1)
		{
			
			//setting color of dot
			g2.setColor(Color.red);
			
			//spawn dot w/in bounds of 5 - 40 degrees
			dotSpawn = new SpawnDot(g2);	
		}	
	}
}
