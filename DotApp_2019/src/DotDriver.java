import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DotDriver 
{
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				//TODO 
				//This is the dot driver this will be the engine of my code
				/*
				 * 1) Make the UI and test it
				 * 2) Test sending everything to docs with class called txtWriter...of which I also have 
				 * 	  to make
				 * 3) Make circle that draws dots in quadrants based on input i.e. 1-4
				 * 4) Send user input to txt doc.
				 */
				//opens dot program :D
				new DotUIFrame("dot.exe");
			}
			
		});
		
	}
	
}

