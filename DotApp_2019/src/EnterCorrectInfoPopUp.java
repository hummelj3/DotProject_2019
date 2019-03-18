import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class EnterCorrectInfoPopUp 
{
	
	public EnterCorrectInfoPopUp()
	{
		//dialog
		String enterCorrectPop = "Please enter the correct information";
		//getting screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//intro pop-up	
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL", 1, 30)));
		UIManager.put("OptionPane.minimumSize", new Dimension(screenSize.width/5, screenSize.height/6));
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", 0, 40)));
		JOptionPane.showMessageDialog(null, enterCorrectPop);
	}
}
