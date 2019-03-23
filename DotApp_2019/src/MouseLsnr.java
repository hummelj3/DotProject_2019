import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class MouseLsnr
{
	public MouseLsnr(Container c)
	{
		//custom cursor stuff
		Point hotspot = new Point(0, 0);
		Image cursorImage2 = new ImageIcon("C:\\Users\\Jeremy\\git\\repository\\DotApp_2019\\src\\CustomHand.png").getImage();
		String cursorName2 = "CursorHand2";
		Image cursorImage = new ImageIcon("C:\\Users\\Jeremy\\git\\repository\\DotApp_2019\\src\\CustomHand1.png").getImage();
		String cursorName = "CursorHand";
		
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
		    	 
		    	 //TODO: send to txt doc
		    	 
		     }
		     //mouse released
		     public void mouseReleased(MouseEvent e)
		     {
		    	//set cursor to regular
		    	 c.setCursor(c.getToolkit().createCustomCursor(cursorImage, hotspot, cursorName));
		    	 
		    	 if(DotUIFrame.trialNum == 80)
		    	 {
		    		//fire action event to signal dot ui frame to bring up ending dialog so user can be done with this nightmare
		    		
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
		     }
		});
	}
}
