import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class BlackScreen extends JPanel
{

	private static final long serialVersionUID = -8884010467351253504L;

	public void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);
		
		//getting screensize 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//make black box to fill screen
		g2.setColor(Color.black);
		g2.fillRect(0, 0, screenSize.width, screenSize.height);
		
     }
}
