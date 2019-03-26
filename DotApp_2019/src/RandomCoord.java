import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCoord 
{
	public int[] randCoord(int q)
	{
		//array to hold coords, place 0 for x, place 1 for y...
		double[] xy = {2, 3};
		
		//PI
		double PI = Math.PI;
		
		//circ radius
		double rad = (CirclePanel.radius + .5);
		
		//make rand
		Random rand = new Random();
		
		//angle
		double theta = 0;
		double theta2 = 100;
		
		//getting relevant info to chug equations 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//get coord in sector
		Boolean inSector = false;
		while(!inSector)
		{	
			//if q1 chosen
			if(q == 1)
			{
				//screen dimensions 
				int w = screenSize.width;
				int h = screenSize.height;
				
				//random distance from center of circle x
				double min = .5*w;
				double max = (.5*w) + rad;
				double ranDisCentx = ThreadLocalRandom.current().nextDouble(min, max + 1);
				
				//max and min values for y w/in quadrant 1:
				double minY = (Math.tan( (50*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				double maxY = (Math.tan( (85*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				
				//random distance from center of circle y
				double y = ThreadLocalRandom.current().nextDouble(minY, maxY + 1);
				
				//max and min values for y w/in quadrant 1:
				double minX = ( (1/(Math.tan( (85*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				double maxX = ( (1/(Math.tan( (50*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				
				//randomly choose value between max and min x
				double x = ThreadLocalRandom.current().nextDouble(minX, maxX + 1);
				
				//calc angle
				theta = Math.atan( (y - (.5*h)) / (x - (.5*w)) );
				theta2 = theta;
				
				//check if it is w/in circle
				if(inCircle(x,y) == true)
				{
					//if in circle assign x and y then return xy
					xy[0] = x;
					xy[1] = y;
					inSector = true;
					//return xy;
				}	
			}
			
			//if q1 chosen
			else if(q == 2)
			{
				//screen dimensions 
				int w = screenSize.width;
				int h = screenSize.height;
				
				//random distance from center of circle x
				double min = 5*w;
				double max = (.5*w) + rad;
				double ranDisCentx = ThreadLocalRandom.current().nextDouble(min, max + 1);
				
				//max and min values for y w/in quadrant 1:
				double minY = (Math.tan( (-40*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				double maxY = (Math.tan( (-5*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				
				//random distance from center of circle y
				double y = ThreadLocalRandom.current().nextDouble(minY, maxY + 1);
				
				//max and min values for y w/in quadrant 1:
				double minX = ( (1/(Math.tan( (-40*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				double maxX = ( (1/(Math.tan( (-5*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				
				//randomly choose value between max and min
				double x = ThreadLocalRandom.current().nextDouble(minX, maxX + 1);
				
				//calc angle
				theta = Math.atan( (y - (.5*h)) / (x - (.5*w)) );
				theta2 = theta;
				
				//check if it is w/in circle
				if(inCircle(x,y) == true)
				{
					//if in circle assign x and y then return xy
					xy[0] = x;
					xy[1] = y;
					inSector = true;
					//return xy;
				}	
			}
			
			//if q1 chosen
			else if(q == 3)
			{
				//screen dimensions 
				int w = screenSize.width;
				int h = screenSize.height;
				
				//random distance from center of circle x
				double min = (.5*w) - rad;
				double max = (.5*w);
				double ranDisCentx = ThreadLocalRandom.current().nextDouble(min, max + 1);
				
				//max and min values for y w/in quadrant 1:
				double minY = (Math.tan( (85*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				double maxY = (Math.tan( (50*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				
				//random distance from center of circle y
				double y = ThreadLocalRandom.current().nextDouble(minY, maxY + 1);
				
				//max and min values for y w/in quadrant 1:
				double minX = ( (1/(Math.tan( (50*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				double maxX = ( (1/(Math.tan( (85*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				
				//randomly choose value between max and min
				double x = ThreadLocalRandom.current().nextDouble(minX, maxX + 1);
				
				//calc angle
				theta = Math.atan( (y - (.5*h)) / (x - (.5*w)) );
				theta2 = theta;
				
				//check if it is w/in circle
				if(inCircle(x,y) == true)
				{
					//if in circle assign x and y then return xy
					xy[0] = x;
					xy[1] = y;
					inSector = true;
					//return xy;
				}	
			}
			
			//if q1 chosen
			else if(q == 4)
			{
				//screen dimensions 
				int w = screenSize.width;
				int h = screenSize.height;
				
				//random distance from center of circle x
				double min = (.5*w) - rad;
				double max = (.5*w);
				double ranDisCentx = ThreadLocalRandom.current().nextDouble(min, max + 1);

				//max and min values for y w/in quadrant 1:
				double minY = (Math.tan( (-5*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				double maxY = (Math.tan( (-40*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				
				//random distance from center of circle y
				double y = ThreadLocalRandom.current().nextDouble(minY, maxY + 1);

				//max and min values for y w/in quadrant 1:
				double minX = ( (1/(Math.tan( (-5*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				double maxX = ( (1/(Math.tan( (-40*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				
				//randomly choose value between max and min
				double x = ThreadLocalRandom.current().nextDouble(minX, maxX + 1);

				//calc angle
				theta = Math.atan( (y - (.5*h)) / (x - (.5*w)) );
				theta2 = theta;
				
				//check if it is w/in circle
				if(inCircle(x,y) == true)
				{
					//if in circle assign x and y then return xy
					xy[0] = x;
					xy[1] = y;
					inSector = true;
					//return xy;
				}	
			}
		}
		
		//if testing mode on then print angle of act dot coords
		if(DotUIFrame.testing == true)
		{
			System.out.println("act dot angle q1: " + theta);
			DotUIFrame.highAng = theta;
			DotUIFrame.lowAng = theta2;
			if(theta > DotUIFrame.highAng)
			{
				DotUIFrame.highAng = theta;
			}
			if(theta2 < DotUIFrame.lowAng)
			{
				DotUIFrame.lowAng = theta2;
			}
			if(DotUIFrame.trialNum == 80)
			{
				System.out.println("Act dot highest angle: " + DotUIFrame.highAng);
				System.out.println("Act dot lowest angle: " + DotUIFrame.lowAng);
				System.exit(0);
			}
		}
		
		//return random coordinates of dot
		int[] xy2 = {1,2};
		xy2[0] = (int) xy[0];
		xy2[1] = (int) xy[1];
		return xy2;
	}
	
	//method that returns true if x && y within a circle
	public Boolean inCircle(double x, double y)
	{
		//getting relevant info to chug equations 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = screenSize.width;
		int h = screenSize.height;
		double p1 = (x - (.5 * w));
		double p2 = (y - (.5 * h));
		double radius = (CirclePanel.radius - 10);
		
		//checking if within circle
		if( ((p1*p1) + (p2*p2)) <= (radius*radius) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
