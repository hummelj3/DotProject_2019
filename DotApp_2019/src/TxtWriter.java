import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TxtWriter 
{
	public void txtWriter(String num, String sex, String age, String hand, String date, Dimension screen)
	{
		try(FileWriter fw = new FileWriter("./Data/TestData.txt", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter out = new PrintWriter(bw))
		{
			//outputting data to txt doc
			out.println("User Data :");
		    out.println("Assigned Num:               " + num);
		    out.println("User Gender:                " + sex);
		    out.println("User age:                   " + age);
		    out.println("User dominant hand:         " + hand);
		    out.println("Date :                      " + date);
		    out.println("Width and Height of Screen: " + screen.width + ", " + screen.height);
		    out.println("Center of Circle X:         " + screen.width/2);
		    out.println("Center of Circle Y:         " + screen.height/2);
		    out.println("\n");
		    
		} 
		catch (IOException e) 
		{
		    //exception handling left as an exercise for the reader
		}
	}
	public void txtWriter(int actCoordx, int actCoordy, int userX, int userY, int actQuad, int trial)
	{
		try(FileWriter fw = new FileWriter("./Data/TestData.txt", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter out = new PrintWriter(bw))
		{
			//0 place is quadrant
			int[] info = {1,2,3,4,5};
			info = maths(actCoordx, actCoordy, userX, userY);
			
			//outputting data to txt doc
			out.print("trial Number: " + trial);
			out.print(" | ");
			out.print("Actual Quadrant: " + actQuad);
		    out.print(" | ");
		    out.print("Actual Coord x: " + actCoordx);
		    out.print(" | ");
		    out.print("Actual Coord y: " + actCoordy);
		    out.print(" | ");
		    out.print("User Quadrant: " + info[0]);
		    out.print(" | ");
		    out.print("User Coord x: " + userX);
		    out.print(" | ");
		    out.print("User Coord y: " + userY);
		    out.print("\n");
		    out.println();
		    
		} 
		catch (IOException e) 
		{
		    //exception handling left as an exercise for the reader
		}
	}
	
	//maths for data in txt doc
	public int[] maths(int actCoordx, int actCoordy, int userX, int userY)
	{
		//0 place is quadrant
		int[] info = {1,2,3,4,5};
		
		//getting screen dimension
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//center coords
		int centerX = screenSize.width/2;
		int centerY = screenSize.height/2;
		
		//give what quad user clicked in
		//if in quad 1
		if(userX > centerX && userY > centerY)
 		{
 			info[0] = 1;
 		}
 		
 		//if quad 2 
 		if(userX > centerX && userY < centerY)
 		{
 			info[0] = 2;
 		}
 		
 		//if quad 3
 		if(userX < centerX && userY < centerY)
 		{
 			info[0] = 3;
 		}
 		
 		//if quad 4
 		if(userX < centerX && userY > centerY)
 		{
 			info[0] = 4;
 		}
 		
 		//will only happen in testing
 		if(userX == centerX && userY == centerY)
 		{
 			info[0] = 0;
 		}
 		
 		return info;
	}
}
