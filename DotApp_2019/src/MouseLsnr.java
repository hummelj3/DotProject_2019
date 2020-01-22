import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.event.EventListenerList;

public class MouseLsnr
{
	private TxtWriter txtWriter;
	private EndOfDotClickHell theEnd;
	//private EventListenerList listenerList = new EventListenerList();
	
	public MouseLsnr(Container c)
	{
		String mousePath;
		String mousePath2;
		//custom cursor stuff
		/*if(DotUIFrame.isExe == false)
		{
			mousePath = "C:\\Users\\Jeremy\\git\\repository\\DotApp_2019\\src\\CustomHand.png";
			mousePath2 = "C:\\Users\\Jeremy\\git\\repository\\DotApp_2019\\src\\CustomHand1.png";
		}*/
		//else
		//{
		//String path = Paths.get("").toAbsolutePath().toString();
		//mousePath = path + ".\\src\\CustomHand.png";
		//mousePath2 = path + ".\\src\\CustomHand1.png";
		//}
		Point hotspot = new Point(0, 0);
		Image cursorImage2 = new ImageIcon("./src/CustomHand.png").getImage();
		String cursorName2 = "CursorHand1";
		Image cursorImage = new ImageIcon("./src/CustomHand1.png").getImage();
		String cursorName = "CursorHand";

		//making txt writer
		txtWriter = new TxtWriter();
		
		//set cursor
		//c.setCursor(c.getToolkit().createCustomCursor(cursorImage2, hotspot, cursorName2));   
		
		//if testing mode on...
		if(DotUIFrame.testing == true)
		{
			//if 80 trials gone by...
	    	 if(DotUIFrame.trialNum == 80)
	    	 {
	    		 System.out.println("event fired");
	    		 System.out.println("Act dot highest angle: " + DotUIFrame.highAng);
				 System.out.println("Act dot lowest angle: " + DotUIFrame.lowAng);
				 //send data to txt doc
		    	 txtWriter.txtWriter(DotUIFrame.actX, DotUIFrame.actY,0, 0, DotUIFrame.quad, DotUIFrame.trialNum);
	    		 //bring up ending dialog so user can be done with this nightmare
	    		 theEnd = new EndOfDotClickHell();
	    	 }
	    	 else
	    	 {
	    		 //send data to txt doc
		    	 txtWriter.txtWriter(DotUIFrame.actX, DotUIFrame.actY, 0, 0, DotUIFrame.quad, DotUIFrame.trialNum);
	    		 //restart timer
		    	 DotTimer.timerRestart();
	    	 }
		}
		
		//if testing mode is off
		if(DotUIFrame.testing != true)
		{
			//mouse listener
			c.addMouseListener(new MouseAdapter()
			{
				 //mouse pressed
			     public void mousePressed(MouseEvent e) 
			     {
			    	 
			    	 //set to custom clicked cursor
			    	 c.setCursor(c.getToolkit().createCustomCursor(cursorImage2, hotspot, cursorName2));   
			    	
			    	 //send data to txt doc
			    	 txtWriter.txtWriter(DotUIFrame.actX, DotUIFrame.actY, e.getX(), e.getY(), DotUIFrame.quad, DotUIFrame.trialNum);
			     }
			     //mouse released
			     public void mouseReleased(MouseEvent e)
			     {
			    	//set cursor to regular
			    	 c.setCursor(c.getToolkit().createCustomCursor(cursorImage, hotspot, cursorName));
			    	 
			    	 //if 80 trials gone by...
			    	 if(DotUIFrame.trialNum == 80)
			    	 {
			    		//bring up ending dialog so user can be done with this nightmare
			    		 theEnd = new EndOfDotClickHell();
			    	 }
			    	 
			    	 else
			    	 {
				    	 //restart timer
				    	 DotTimer.timerRestart();
			    	 }
			    	 
			    	 //remove this listener at end of code so I don't make multiple listeners
			    	 c.removeMouseListener(this);
			     }
			});
		
		}
	}
	
	/*
	public void fireMouseLsnrEvent(MouseLsnrEvent event) 
    {
        Object[] listeners = listenerList.getListenerList();
        
        for(int i = 0; i < listeners.length; i += 2) 
        {
            if(listeners[i] == MouseLsnrListener.class) 
            {
                ((MouseLsnrListener)listeners[i+1]).MouseLsnrEventOccurred(event);
            }
        }
    }

    public void addMouseLsnrListener(MouseLsnrListener listener) 
    {
        listenerList.add(MouseLsnrListener.class, listener);
    }

    public void removeMouseLsnrListener(MouseLsnrListener listener) 
    {
        listenerList.remove(MouseLsnrListener.class, listener);
    }
    */
}
