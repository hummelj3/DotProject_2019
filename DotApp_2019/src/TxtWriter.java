import java.awt.Dimension;
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
		    out.println("\n");
		    
		} 
		catch (IOException e) 
		{
		    //exception handling left as an exercise for the reader
		}
	}
	public void txtWriter(int actCoordx, int actCoordy, int userX, int userY, int centerX, int centerY, int actQuad)
	{
		try(FileWriter fw = new FileWriter("./Data/TestData.txt", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter out = new PrintWriter(bw))
		{
			//0 place is quadrant
			int[] info = {1,2,3,4,5};
			info = maths(actCoordx, actCoordy, userX, userY, centerX, centerY);
			
			//outputting data to txt doc
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
		    out.print(" | ");
		    out.print("Center of Circle x : " + centerX);
		    out.print(" | ");
		    out.print("Center of Circle x : " + centerY);
		    out.print("\n");
		    
		} 
		catch (IOException e) 
		{
		    //exception handling left as an exercise for the reader
		}
	}
	
	//maths for data in txt doc
	public int[] maths(int actCoordx, int actCoordy, int userX, int userY, int centerX, int centerY)
	{
		//0 place is quadrant
		int[] info = {1,2,3,4,5};
		
		//give what quad user clicked in
		//if in quad 1
		if(actCoordx > centerX && actCoordy > centerY)
 		{
 			info[0] = 1;
 			DotUIFrame.trackQuad1--;
 		}
 		
 		//if quad 2 
 		if(actCoordx > centerX && actCoordy < centerY)
 		{
 			info[0] = 2;
 			DotUIFrame.trackQuad2--;
 		}
 		
 		//if quad 3
 		if(actCoordx < centerX && actCoordy < centerY)
 		{
 			info[0] = 3;
 			DotUIFrame.trackQuad3--;
 		}
 		
 		//if quad 4
 		if(actCoordx < centerX && actCoordy > centerY)
 		{
 			info[0] = 4;
 			DotUIFrame.trackQuad4--;
 		}
 		
 		//will only happen in testing
 		if(actCoordx == centerX && actCoordy == centerY)
 		{
 			info[0] = 0;
 		}
 		
 		return info;
	}
}
