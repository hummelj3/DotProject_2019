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
			System.out.println("error txtwrite");
		}
	}
	public void txtWriter(double actCoordx, double actCoordy, int userX, int userY, int actQuad, int trial)
	{
		try(FileWriter fw = new FileWriter("./Data/TestData.txt", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter out = new PrintWriter(bw))
		{
			//0 place is quadrant, place 1 is dist between, place 2 is act dot dist from center, place 3 is user dist from center,
			//place 4 is dot angle, place 5 is user dot angle, place 6 is diff between angles, place 7 is diff between radii
			double[] info = {1,2,3,4,5,6,7,8};
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
		    out.print("User Quadrant: " + (int)info[0]);
		    out.print(" | ");
		    out.print("User Coord x: " + userX);
		    out.print(" | ");
		    out.print("User Coord y: " + userY);
		    out.write(" | ");
		    out.write("Distance between: " + info[1]);
		    out.write(" | ");
		    out.write("Actual dot distance from center: " + info[2]);
		    out.write(" | ");
		    out.write("User aprox distance from center: " + info[3]);
		    out.write(" | ");
		    out.write("Dot angle: " + info[4]);
		    out.write(" | ");
		    out.write("User aprox angle: " + info[5]);
		    out.write(" | ");
		    out.write("Difference between angles: " + info[6]);
		    out.write(" | ");
		    out.write("Difference between radii: " + info[7]);
		    out.print("\n");
		    out.println();
		    
		    
		} 
		catch (IOException e) 
		{
		    //exception handling left as an exercise for the reader
		}
	}
	
	//maths for data in txt doc
	public double[] maths(double actCoordx, double actCoordy, int userX, int userY)
	{
		//0 place is quadrant
		double[] info = {1,2,3,4,5,6,7,8};
		
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
		else if(userX > centerX && userY < centerY)
 		{
 			info[0] = 2;
 		}
 		
 		//if quad 3
		else if(userX < centerX && userY < centerY)
 		{
 			info[0] = 3;
 		}
 		
 		//if quad 4
		else if(userX < centerX && userY > centerY)
 		{
 			info[0] = 4;
 		}
 		
 		//will only happen in testing
		else if(userX == centerX && userY == centerY)
 		{
 			info[0] = 0;
 		}
 		
 		//calculations to get angles, distance from center, distance from each other etc.
		double vertexX = centerX;
		
		double vertexY = centerY;
		
		double xact = actCoordx;
		
		double yact = actCoordy;
		
		double xuser = userX;
		
		double yuser = userY;
		
		double vert_1 = Math.sqrt(Math.pow((vertexX - vertexX),2) + Math.pow((vertexY - (vertexY + 400)),2));
		
		double p1_user = Math.sqrt(Math.pow((vertexX - xuser),2) + Math.pow(((vertexY + 400) - yuser),2));
		
		double p1_act = Math.sqrt(Math.pow((vertexX - xact),2) + Math.pow(((vertexY + 400) - yact),2));
		
		double user_vert = Math.sqrt(Math.pow((vertexX - xuser),2) + Math.pow((vertexY - yuser),2));
		
		double act_vert = Math.sqrt(Math.pow((vertexX - xact),2) + Math.pow((vertexY - yact),2));
		
		double a[] = {vertexX - vertexX, vertexY - (vertexY + 400)};
		
		double bUser[] = {vertexX - xuser, vertexY - yuser};
		
		double bAct[] = {vertexX - xact, vertexY - yact};  

	    //calculations here
	    double distBetween = Math.sqrt(Math.pow((xuser - xact),2) + Math.pow((yuser - yact),2));

	    //not sure, should be same as dot radius?
	    double resp_rad = user_vert;

	    //dist from center of circle of user entered coordinates
	    double dot_rad = act_vert;;

	    //distance of dot from center 
	    double resp_ang  = Math.acos((Math.pow(vert_1, 2) + Math.pow(user_vert, 2) - Math.pow(p1_user, 2)) / (2 * vert_1 * user_vert));

	    //angle of user entered dot
	    double dot_angle = Math.acos((Math.pow(vert_1, 2) + Math.pow(act_vert, 2) - Math.pow(p1_act, 2)) / (2 * vert_1 * act_vert));

	    //angle of dot:
	    //dependent on quadrant values determined here
	    if(info[0] == 3 || info[0] == 4 ) 
	    {

		    dot_angle = (2*Math.PI) - dot_angle;
	
		    resp_ang = (2*Math.PI) - resp_ang;

	    }

	    double angleBias = dot_angle - resp_ang; //difference between angles
	    double radialBias = dot_rad - resp_rad; //difference between radii
	    
	    //put everything into array
	    info[1] = distBetween;
	    info[2] = dot_rad;
	    info[3] = resp_rad;
	    info[4] = dot_angle;
	    info[5] = resp_ang;
	    info[6] = angleBias;
	    info[7] = radialBias;
	    
	    //return all data within array info
 		return info;
	}
}
