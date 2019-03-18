
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class IntroPopUp {

  
  public IntroPopUp(JFrame parent) 
  { 
	//dialog
	String Intro_popUp = " In this experiment there will be 80 trials. \n In each trial you will be asked to remember the location of a dot within a circle.\n Each trial will begin with a circle, and inside the circle will be a dot.\n The circle and the dot will then disappear, and a new circle will appear.\n Your task will be to place the mouse on the exact location where the dot appeared and click there.\n Please be as accurate as possible when responding.";
	//getting screen size
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	//intro pop-up	
	UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("ARIAL", 1, 30)));
	UIManager.put("OptionPane.minimumSize", new Dimension(screenSize.width/5, screenSize.height/6));
	UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", 0, 40)));
	Object[] options = { "OK" };
	JOptionPane.showOptionDialog(null, Intro_popUp, "Instructions", -1, 3, null, options,  options[0]);
  }

}


