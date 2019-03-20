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
	public void txtWriter(String actCoordx, String actCoordy, String userX, String userY, String centerX, String centerY)
	{
		try(FileWriter fw = new FileWriter("./Data/TestData.txt", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter out = new PrintWriter(bw))
		{
		    out.print("Actual Coord x: " + actCoordx);
		    out.print(" | ");
		    out.print("Actual Coord y: " + actCoordy);
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
}
