import java.awt.Color;

/**
 * This class is a tester class which is being used to test the working of the Shape class by giving sample values to instance variables
 * @author Tarun
 *
 */

public class ShapeTester {

	/**
	 * Main helps in testing the sample input value provided to the instance variables and methods
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		Shape d = new Shape(); // creating a new Shape object
		d.color = new Color(0, 0, 0); // setting the color of the shape
		d.filled = true; // defining the fill type
		d.theta = 0; // storing the angle for orientation of the shape
		d.xc = 0; // x-coordinate of the center of the shape
		d.yc = 0; // y-coordinate of the center of the shape
		d.xLocal = new double[2]; // an array storing the local x-coordinates of the shape
		d.yLocal = new double[2]; // an array storing the local y-coordinates of the shape
		d.xLocal[0] = 2; // assigning random values to x and y coordinates to run the tester class
		d.yLocal[0] = 4;
		d.xLocal[1] = 6;
		d.yLocal[1] = 7;
		
		System.out.println("Color: " + d.color); // debugging statements by printing out values
		System.out.println("filled: " + d.filled);
		System.out.println("theta: " + d.theta);
		System.out.println("Intial value of (xc,yc): " + "(" + d.xc + "," + d.yc + ")");
	
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
		
		
		System.out.println("New angle is " + d.theta);
		System.out.println("value after change of (xc,yc): " + "(" + d.xc + "," + d.yc + ")");
		
	}
}
