import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
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
	private MouseLsnr mouseListen;
	private DotTimer timer;
	private IntroPopUp introPopUp;
	private ConfirmPopUp confirmPopUp;
	private EnterCorrectInfoPopUp correctInfoQPop;
	private EndOfDotClickHell theEnd;
	private int input;
	public static Boolean testing = false;
	public static Boolean isExe = true;
	public static int trialNum = 0;
	public static int trackQuad1 = 20;
	public static int trackQuad2 = 20;
	public static int trackQuad3 = 20;
	public static int trackQuad4 = 20;
	public static double highAng = -100;
	public static double lowAng  = 100;
	public static int quad;
	public static double actX;
	public static double actY;
	
	public DotUIFrame(String title)
	{
		//setting name
		super(title);
		
		//setting layout manager and stuff
		setLayout(new BorderLayout());
		setUndecorated(true);
		Container c = getContentPane();
		
		//making a details panel
		detailsPanel = new DetailsPanel();
		
		//making mouselistener 
		//mouseListen = new MouseLsnr(c);
		
		//makes to where app closes on close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//making txt writer to write to file
		TxtWriter write = new TxtWriter();
		
		//making confirmPopUp
		confirmPopUp = new ConfirmPopUp();
		
		//getting screensize 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				
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
        			write.txtWriter(data[0],data[1],data[2],data[3],data[4], screenSize);
        			
        			//call to timer, timer will call and draw circle and dot at specified intervals 80x
    				timer = new DotTimer(c);
        		}
        		
        		//if user entered incorrectly
        		else
        		{
        			correctInfoQPop = new EnterCorrectInfoPopUp();
        		}
            }
        });
		
		//TODO: Listens for last click in MouseLsnr
		//mouseListen.addMouseLsnrListener(new MouseLsnrListener() 
		//{
			//public void MouseLsnrEventOccurred(MouseLsnrEvent event) 
			//{
				//after 80 trials give last pop-up so user can be over with this awfully dull dot clicking hell... 
				//theEnd = new EndOfDotClickHell();
			//}
		//});
		
		//kill program on esc key press for testing, user will not be able to do this
		if(testing == true)
		{
			getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			    KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "EXIT"); 
			    getRootPane().getActionMap().put("EXIT", new AbstractAction()
			    { 
			        public void actionPerformed(ActionEvent e)
			        {
			        	System.exit(0);
			        }
			    });
		}
		
		//makes fullscreen
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		//adding detail panel to collect demographics
		c.add(detailsPanel, BorderLayout.CENTER);
		
		//making visible
		setVisible(true);
		
		//making intro popup 
		introPopUp = new IntroPopUp(this);
	}
}

