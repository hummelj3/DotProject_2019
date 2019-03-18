
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class ConfirmPopUp {

  

  public int ConfirmPopUp() 
  { 
	//dialog
	String confirmDialog = "Is this information accurate?";
	//getting screen size
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	//intro pop-up	
	UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL", 1, 30)));
	UIManager.put("OptionPane.minimumSize", new Dimension(screenSize.width/5, screenSize.height/6));
	UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", 0, 40)));
	int input = JOptionPane.showConfirmDialog(null, confirmDialog, "Confirm Dialog", 0, JOptionPane.QUESTION_MESSAGE);
	return input;
  }

}



