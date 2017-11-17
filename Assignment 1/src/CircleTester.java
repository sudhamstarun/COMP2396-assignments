import java.awt.Color;

/**
 * This class is a tester class which is being used to test the working of the Circle class by giving sample values to instance variables
 * @author Tarun
 *
 */
public class CircleTester {
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Circle d = new Circle(); // creating a new Circle object
		d.color = new Color(0, 0, 0); // setting the color of the shape
		d.filled = true; // defining the fill type
		d.theta = 0; // storing the angle for the orientation of the shape
		d.xc = 0; // x-coordinate of the center of the shape
		d.yc = 0; // y-coordinate of the center of the shape
		
		System.out.println("Color: " + d.color); // debugging statements by printing out values
		System.out.println("filled: " + d.filled);
		System.out.println("theta: " + d.theta);
		System.out.println("Intial value of (xc,yc): " + "(" + d.xc + "," + d.yc + ")");
	
		d.translate(10, 10); // providing parameters to translate in x and y direction
		d.rotate(180); // provides the orientation for the square to rotate
		d.setVertices(10); // provides the length of the radius of the circle
		
		int [] new_xCoordinate = d.getX(); // storing the array of x-screen coordinates returned by the getX method
		int [] new_yCoordinate = d.getY(); // storing the array of x-screen coordinates returned by the getY method 
		
		
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
