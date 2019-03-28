import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.event.EventListenerList;

public class MouseLsnr
{
	private TxtWriter txtWriter;
	private EventListenerList listenerList = new EventListenerList();
	
	public MouseLsnr(Container c)
	{
		//custom cursor stuff
		Point hotspot = new Point(0, 0);
		Image cursorImage2 = new ImageIcon("C:\\Users\\Jeremy\\git\\repository\\DotApp_2019\\src\\CustomHand.png").getImage();
		String cursorName2 = "CursorHand2";
		Image cursorImage = new ImageIcon("C:\\Users\\Jeremy\\git\\repository\\DotApp_2019\\src\\CustomHand1.png").getImage();
		String cursorName = "CursorHand";

		//making txt writer
		txtWriter = new TxtWriter();
		
		//mouse listener
		c.addMouseListener(new MouseAdapter()
		{
			
			 //mouse pressed
		     public void mousePressed(MouseEvent e) 
		     {
		    	 //testing
		    	 if(DotUIFrame.testing == true)
		    	 {
			    	 System.out.println("click");
			    	 System.out.println(e.getX());
			    	 System.out.println(e.getY());
		    	 }
		    	 
		    	 //set to custom clicked cursor
		    	 c.setCursor(c.getToolkit().createCustomCursor(cursorImage2, hotspot, cursorName2));   
		    	
		    	 //TODO: send data to txt doc
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
		    		//TODO: fire action event to signal dot ui frame to bring up ending dialog so user can be done with this nightmare
		    		 fireMouseLsnrEvent(new MouseLsnrEvent(this));
		    	 }
		    	 
		    	 else
		    	 {
			    	 //testing
			    	 if(DotUIFrame.testing == true)
			    	 {
			    		 System.out.println("unclick");
			    	 }
			    	 
			    	 //restart timer
			    	 DotTimer.timerRestart();
		    	 }
		    	 
		    	 //remove this listener at end of code so I don't make multiple listeners
		    	 c.removeMouseListener(this);
		     }
		});
	}
	
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
}
