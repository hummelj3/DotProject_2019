
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.Timer;


public class DotTimer 
{
	private CirclePanel circle;
	private BlackScreen blackscrn;
	private MouseLsnr mouseListen;
	private static Timer timer;
	private int i;
	public static int time;
	
	public DotTimer(Container c)
	{
		//setting delay to 0
		int delay = 0;
		
		//making timer
		timer = new Timer(delay, new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) 
			{
				
				//@ 0 seconds
				if (timer.getDelay() == 0)
				{
					// Transparent 16 x 16 pixel cursor image.
					BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
					
					//if not in testing mode
					if(DotUIFrame.testing != true)
					{
						// Create a new blank cursor.
						Cursor blankCursor = c.getToolkit().getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
	
						// Set the blank cursor to the JFrame.
						c.setCursor(blankCursor);
					}
					
					//increase trial num for every trial
					DotUIFrame.trialNum++;
					
					//if in testing mode  
					if(DotUIFrame.testing == true)
					{
						//print out trial num for testing
						System.out.println("Trial Num: " + DotUIFrame.trialNum);
					}
					
					//making a circle to spawn dot in
					circle = new CirclePanel();
					
					//making black screen
					blackscrn = new BlackScreen();
					
					//add circle panel
					c.removeAll();
					c.add(circle);
					c.validate();
					
					//set intervals of 100 millisecs
					timer.setDelay(100);
				}
				
				//gets current time
				i += timer.getDelay();
				
				//@ two seconds
				if(i == 2000)
				{
					//if time == 1 then there will be a dot that spawns
					time = 1;
					
					//add circle panel
					c.removeAll();
					c.add(circle);
					c.repaint();
					c.validate();
				}
				
				//@ 2.3 seconds
				if(i == 2300)
				{
					//set time to 0 so dot is not drawn
					time = 0;
					
					//add circle panel
					c.removeAll();
					c.add(circle);
					c.repaint();
					c.validate();
				}
				
				//@ 3 seconds
				if(i == 3000)
				{
					//black screen
					c.removeAll();
					c.add(blackscrn);
					c.repaint();
					c.validate();
				}
				
				//@ 3.5 seconds
				if(i == 3500)
				{
					//add circle panel
					c.removeAll();
					c.add(circle);
					c.repaint();
					c.validate();
					
					//if not in testing mode
					if(DotUIFrame.testing != true)
					{
						//custom cursor stuff
						Image cursorImage = new ImageIcon("C:\\Users\\Jeremy\\git\\repository\\DotApp_2019\\src\\CustomHand1.png").getImage();
						Point hotspot = new Point(0, 0);
						String cursorName = "CursorHand";
						c.setCursor(c.getToolkit().createCustomCursor(cursorImage, hotspot, cursorName));
					}
					
					//reset timer
					i = 0;
					timer.setDelay(0);
					
					//if not in testing mode
					if(DotUIFrame.testing != true)
					{
						//makes && calls MouseLsnr
						mouseListen = new MouseLsnr(c);
						
						//stops timer
						timer.stop();
					}
				}
				
			}
		});
		
		//starts timer
		timer.start();
	}
	
	//restart timer
	public static void timerRestart()
	{
		timer.restart();
	}
}
