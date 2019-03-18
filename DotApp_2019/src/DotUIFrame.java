import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class DotUIFrame extends JFrame
{
	private JTextArea txtArea;
	private JButton introBtn;
	private  DetailsPanel detailsPanel;
	private IntroPopUp introPopUp;
	private ConfirmPopUp confirmPopUp;
	private EnterCorrectInfoPopUp correctInfoQPop;
	private int input;
	
	public DotUIFrame(String title)
	{
		//setting name
		super(title);
		
		//setting layout manager and stuff
		setLayout(new BorderLayout());
		setUndecorated(true);
		
		//making a details panel
		detailsPanel = new DetailsPanel();
		
		//makes to where app closes on close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//making txt writer to write to file
		TxtWriter write = new TxtWriter();
		
		//making confirmPopUp
		confirmPopUp = new ConfirmPopUp();
		
		//listens for command from details panel to send stuff to txt file
		detailsPanel.addDetailListener(new DetailListener() 
		{
            public void detailEventOccurred(DetailEvent event) 
            {
            	//array to hold data from user
                String[] data = event.getData();
                
        		//call confirm pop-up     		
        		input = confirmPopUp.ConfirmPopUp();
        		
        		//checks if data enter is correct
        		if(input == 0)
        		{
        			//test call to txt writer
        			write.txtWriter(data[0],data[1],data[2],data[3],data[4]);
        			
        			//TODO: call to circle dot
        		
        			
        		}
        		else
        		{
        			correctInfoQPop = new EnterCorrectInfoPopUp();
        		}
            }
        });
		
		//TODO: Listens for click in circle panel
		/*
		CirclePanel.addCircleListener(new CircleListener() 
		{
            public void cirlceEventOccurred(CircleEvent event) 
            {
            	
            }
		}
		*/
		
		//kill program on esc key press
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		    KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "EXIT"); 
		    getRootPane().getActionMap().put("EXIT", new AbstractAction(){ 
		        public void actionPerformed(ActionEvent e)
		        {
		            dispose();
		        }
	    });
	    
		//getting screen size
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//setting width and height to fit screen 
		//setSize(screenSize.width,screenSize.height);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		//adding swing components
		Container c = getContentPane();
		c.add(detailsPanel, BorderLayout.CENTER);
		
		//making visible
		setVisible(true);
		
		//making intro popup 
		introPopUp = new IntroPopUp(this);
	}
}
