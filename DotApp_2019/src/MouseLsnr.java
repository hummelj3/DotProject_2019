import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseLsnr
{
	public MouseLsnr(Container c)
	{
		c.addMouseListener(new MouseAdapter() 
		{
			 //mouse pressed
		     public void mousePressed(MouseEvent e) 
		     {
		    	 System.out.println("click");
		    	 System.out.println(e.getX());
		    	 System.out.println(e.getY());
		     }
		     //mouse released
		     public void mouseReleased(MouseEvent e)
		     {
		    	 System.out.println("unclick");
		     }
		});
	}
}
