import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.event.EventListenerList;


public class DotTimer 
{
	private CirclePanel circle;
	private BlackScreen blackscrn;
	private MouseLsnr mouseListen;
	private Timer timer;
	private EventListenerList listenerList = new EventListenerList();
	private int i;
	public static int quad;
	public static int time;
	
	public DotTimer(Container c)
	{
		//setting delay to 0
		int delay = 0;
		//making black screen
		blackscrn = new BlackScreen();
		//making a circle to spawn dot in
		circle = new CirclePanel();
		//making timer
		timer = new Timer(delay, new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) 
			{
				if (timer.getDelay() == 0)
				{
					//making a circle to spawn dot in
					circle = new CirclePanel();
					
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
					//set time to 0 so dot is not drawn
					time = 0;
					
					//add circle panel
					c.removeAll();
					c.add(circle);
					c.repaint();
					c.validate();
					
					//makes && calls MouseLsnr
					mouseListen = new MouseLsnr(c);
					
					//stops timer
					timer.stop();
				}
				
			}
		});
		
		//starts timer
		timer.start();
	}
}
