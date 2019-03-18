import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.FontUIResource;

import java.awt.Font;

public class DetailsPanel extends JPanel 
{

	private static final long serialVersionUID = 6915622549267792262L;
	
	private EventListenerList listenerList = new EventListenerList();
	
	public DetailsPanel()
	{
		//setting size of panel to left
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(screenSize);
		
		//setting title and such
		setBorder(BorderFactory.createTitledBorder("PersonalDetails"));
		//making labels and such
		JLabel numLabel = new JLabel("Enter your assigned number:        ");	
		JLabel sexLabel = new JLabel("Enter your Gender:                 ");
		JLabel ageLabel = new JLabel("Enter your age:                    ");
		JLabel handLabel = new JLabel("Enter your dominant hand:         ");
		JLabel dateLabel = new JLabel("Enter the Date (mm/dd/yy):        ");
				
		//making txt fields for users to enter data into
		JTextField numField = new JTextField();
		JTextField sexField = new JTextField();
		JTextField ageField = new JTextField();
		JTextField handField = new JTextField();
		JTextField dateField = new JTextField();
		
		//making button
		JButton subBtn = new JButton("SUBMIT");
		
		//submit button action listener//listens for button press
		subBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				// put user data into array to send to txt file
				String data[] = {"","","","",""};
				data[0] = numField.getText();
				data[1] = sexField.getText();
				data[2] = ageField.getText();
				data[3] = handField.getText();
				data[4] = dateField.getText();
				
				fireDetailEvent(new DetailEvent(this, data));
				
			}
		});
				
		//setting layout
		setLayout(null);
		
		//// FIRST COLUMN //////////////////////////////
		
		//user number
		numLabel.setSize(screenSize.width/5, screenSize.height/20);
		numLabel.setLocation(screenSize.width - (screenSize.width - 10), screenSize.height*1/20);
		numLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(numLabel);
		
		//user sex
		sexLabel.setSize(screenSize.width/5, screenSize.height/20);
		sexLabel.setLocation(screenSize.width - (screenSize.width - 10), screenSize.height*5/20);
		sexLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(sexLabel);
		//user age
		ageLabel.setSize(screenSize.width/5, screenSize.height/20);
		ageLabel.setLocation(screenSize.width - (screenSize.width - 10), screenSize.height*9/20);
		ageLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(ageLabel);
		
		//user dom hand
		handLabel.setSize(screenSize.width/5, screenSize.height/20);
		handLabel.setLocation(screenSize.width - (screenSize.width - 10), screenSize.height*13/20);
		handLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(handLabel);
		
		//the date
		dateLabel.setSize(screenSize.width/5, screenSize.height/20);
		dateLabel.setLocation(screenSize.width - (screenSize.width - 10), screenSize.height*17/20);
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(dateLabel);
		
		//// SECOND COLUMN //////////////////////////////
		
		//text field user num
		numField.setSize(screenSize.width/3, screenSize.height/20);
		numField.setLocation(screenSize.width/3, screenSize.height*1/20);
		numField.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(numField);
		
		//text field sex
		sexField.setSize(screenSize.width/3, screenSize.height/20);
		sexField.setLocation(screenSize.width/3, screenSize.height*5/20);
		sexField.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(sexField);
		
		//text field age
		ageField.setSize(screenSize.width/3, screenSize.height/20);
		ageField.setLocation(screenSize.width/3, screenSize.height*9/20);
		ageField.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(ageField);
		
		//text field dom hand
		handField.setSize(screenSize.width/3, screenSize.height/20);
		handField.setLocation(screenSize.width/3, screenSize.height*13/20);
		handField.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(handField);
		
		//text field date
		dateField.setSize(screenSize.width/3, screenSize.height/20);
		dateField.setLocation(screenSize.width/3, screenSize.height*17/20);
		dateField.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(dateField);
		
		//// FINAL ROW  //////////////////////////////
		subBtn.setSize(273,155);
		subBtn.setLocation(screenSize.width*26/30, screenSize.height*17/20);
		subBtn.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(subBtn);
		
	}
	
    public void fireDetailEvent(DetailEvent event) 
    {
        Object[] listeners = listenerList.getListenerList();
        
        for(int i = 0; i < listeners.length; i += 2) 
        {
            if(listeners[i] == DetailListener.class) 
            {
                ((DetailListener)listeners[i+1]).detailEventOccurred(event);
            }
        }
    }

    public void addDetailListener(DetailListener listener) 
    {
        listenerList.add(DetailListener.class, listener);
    }

    public void removeDetailListener(DetailListener listener) 
    {
        listenerList.remove(DetailListener.class, listener);
    }
}
