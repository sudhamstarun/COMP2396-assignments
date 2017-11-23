import java.awt.Color;



/**
 * This class is a tester class which is being used to test the working of the Shape class by giving sample values to instance variables
 * @author Tarun
 * 
 *
 */

public class ShapeTester {
	
	/**
	 * Created an instance variable d to check the output of the variables and methods of the Shape Class
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		Shape d = new Shape();
		d.setColor(new Color(0, 0, 0)); // setting the color of the shape
		d.setFilled(true); // defining the fill type
		d.setTheta(0); // storing the angle for orientation of the shape
		d.setXc(0); // x-coordinate of the center of the shape
		d.setYc(0); // y-coordinate of the center of the shape
		double [] xLocalcoordinates = new double [2] ; // an array storing the local x-coordinates of the shape
		double [] yLocalcoordinates = new double [2]; // an array storing the local y-coordinates of the shape
		
		xLocalcoordinates [0] = -2; // assigning random values to x and y coordinates to run the tester class
		yLocalcoordinates [0] = -2;
		xLocalcoordinates [1] = 4;
		yLocalcoordinates [1] = 4;
		
		d.setXLocal(xLocalcoordinates); 
		d.setYLocal(yLocalcoordinates);
		
		System.out.println("Color: " + d.getColor()); // debugging statements by printing out values
		System.out.println("filled: " + d.getFilled());
		System.out.println("theta: " + d.getTheta());
		System.out.println("Intial value of (xc,yc): " + "(" + d.getXc() + "," + d.getYc() + ")");
		
		d.translate(12, 12); // providing parameters to translate the shape in x and y direction 
		d.rotate(150); // provides the orientation(in radians) for the shape to rotate 
		
		int [] new_xCoordinate = d.getX(); // storing the array of x-screen coordinates returned by the getX method
		int [] new_yCoordinate = d.getY(); // storing the array of y-screen coordinates returned by the getY method
		
		
		for(int i = 0; i < new_xCoordinate.length;i ++)
		{
			System.out.println("The X Coordinates are: " + new_xCoordinate[i]);
		}
		
		for(int i = 0; i < new_yCoordinate.length;i ++)
		{
			System.out.println("The Y Coordinates are: " + new_yCoordinate[i]);
		}
		
		
		System.out.println("New angle is " + d.getTheta());
		System.out.println("value after change of (xc,yc): " + "(" + d.getXc() + "," + d.getYc() + ")");
	
		
	}
	
	
	
}