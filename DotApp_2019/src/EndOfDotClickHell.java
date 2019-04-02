import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class EndOfDotClickHell 
{
	
	public EndOfDotClickHell()
	{
		//dialog
		String endDialog = "Thank you for participating! Click 'OK' to Exit Program";
		//getting screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//exit pop-up	
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL", 1, 30)));
		UIManager.put("OptionPane.minimumSize", new Dimension(screenSize.width/5, screenSize.height/6));
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", 0, 40)));
		Object[] options = { "OK" };
		int exit = JOptionPane.showOptionDialog(null, endDialog, "END OF EXPERIMENT", -1, 3, null, options, options[0]);
		//user clicks 'ok' to exit program
		if (exit == 0)
		{ 
			System.exit(0);
		}
	}
}

