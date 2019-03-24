import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

public class RandomCoord 
{
	public int[] randCoord(int q)
	{
		//array to hold coords, place 0 for x, place 1 for y...
		int[] xy = {2, 3};
		
		//PI
		double PI = Math.PI;
		double rad = (CirclePanel.radius + .5);
		
		//make rand
		Random rand = new Random();
		
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
				
				//maths to plug and chug:
				int xPlug = (int) ((.5*w + rad) - (.5*w) ) + 1;
				int z = (int) (.5*w);
				
				//random distance from center of circle x
				int ranDisCentx = rand.nextInt(xPlug) + z;
				
				//max and min values for y w/in quadrant 1:
				int minY = (int) (Math.tan( (50*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				int maxY = (int) (Math.tan( (85*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				
				//random distance from center of circle y
				int y = rand.nextInt((maxY - minY) + 1) + minY;
				
				//max and min values for y w/in quadrant 1:
				int minX = (int) ( (1/(Math.tan( (85*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				int maxX = (int) ( (1/(Math.tan( (50*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				
				//randomly choose value between max and min
				int x = rand.nextInt((maxX - minX) + 1) + minX;
				
				//check if it is w/in circle
				if(inCircle(x,y) == true)
				{
					//if in circle assign x and y then return xy
					xy[0] = x;
					xy[1] = y;
					inSector = true;
					return xy;
				}	
			}
			
			//if q1 chosen
			else if(q == 2)
			{
				//screen dimensions 
				int w = screenSize.width;
				int h = screenSize.height;
				
				//maths to plug and chug:
				int xPlug = (int) ((.5*w + rad) - (.5*w) ) + 1;
				int z = (int) (.5*w);
				
				//random distance from center of circle x
				int ranDisCentx = rand.nextInt(xPlug) + z;
				
				//max and min values for y w/in quadrant 1:
				int minY = (int) (Math.tan( (50*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				int maxY = (int) (Math.tan( (85*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				
				//random distance from center of circle y
				int y = rand.nextInt((maxY - minY) + 1) + minY;
				
				//max and min values for y w/in quadrant 1:
				int minX = (int) ( (1/(Math.tan( (85*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				int maxX = (int) ( (1/(Math.tan( (50*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				
				//randomly choose value between max and min
				int x = rand.nextInt((maxX - minX) + 1) + minX;
				
				//check if it is w/in circle
				if(inCircle(x,y) == true)
				{
					//if in circle assign x and y then return xy
					xy[0] = x;
					xy[1] = y;
					inSector = true;
					return xy;
				}	
			}
			
			//if q1 chosen
			else if(q == 3)
			{
				//screen dimensions 
				int w = screenSize.width;
				int h = screenSize.height;
				
				//maths to plug and chug:
				int xPlug = (int) ((.5*w + rad) - (.5*w) ) + 1;
				int z = (int) (.5*w);
				
				//random distance from center of circle x
				int ranDisCentx = rand.nextInt(xPlug) + z;
				
				//max and min values for y w/in quadrant 1:
				int minY = (int) (Math.tan( (50*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				int maxY = (int) (Math.tan( (85*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				
				//random distance from center of circle y
				int y = rand.nextInt((maxY - minY) + 1) + minY;
				
				//max and min values for y w/in quadrant 1:
				int minX = (int) ( (1/(Math.tan( (85*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				int maxX = (int) ( (1/(Math.tan( (50*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				
				//randomly choose value between max and min
				int x = rand.nextInt((maxX - minX) + 1) + minX;
				
				//check if it is w/in circle
				if(inCircle(x,y) == true)
				{
					//if in circle assign x and y then return xy
					xy[0] = x;
					xy[1] = y;
					inSector = true;
					return xy;
				}	
			}
			
			//if q1 chosen
			else if(q == 4)
			{
				//screen dimensions 
				int w = screenSize.width;
				int h = screenSize.height;
				
				//maths to plug and chug:
				int xPlug = (int) ((.5*w + rad) - (.5*w) ) + 1;
				int z = (int) (.5*w);
				
				//random distance from center of circle x
				int ranDisCentx = rand.nextInt(xPlug) + z;
				
				//max and min values for y w/in quadrant 1:
				int minY = (int) (Math.tan( (50*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				int maxY = (int) (Math.tan( (85*PI)/180) * (ranDisCentx - (.5*w) ) + (.5*h));
				
				//random distance from center of circle y
				int y = rand.nextInt((maxY - minY) + 1) + minY;
				
				//max and min values for y w/in quadrant 1:
				int minX = (int) ( (1/(Math.tan( (85*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				int maxX = (int) ( (1/(Math.tan( (50*PI)/180) ) ) * (y - (.5*h) ) + (.5*w) );
				
				//randomly choose value between max and min
				int x = rand.nextInt((maxX - minX) + 1) + minX;
				
				//check if it is w/in circle
				if(inCircle(x,y) == true)
				{
					//if in circle assign x and y then return xy
					xy[0] = x;
					xy[1] = y;
					inSector = true;
					return xy;
				}	
			}
		}
		
		//if testing mode on then print angle of act dot coords
		if(DotUIFrame.testing == true)
		{
			System.out.println("act dot angle q1: " + 2);
		}
		//return random coordinates of dot
		return xy;
	}
	
	//method that returns random coordinates within a circle
	public Boolean inCircle(int x, int y)
	{
		//getting relevant info to chug equations 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = screenSize.width;
		int h = screenSize.height;
		double p1 = (x - (.5 * w));
		double p2 = (y - (.5 * h));
		double radius = (CirclePanel.radius + .5);
		
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
