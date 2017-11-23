import java.awt.Color;

/**
 * This class is a tester class which is being used to test the working of the RegularPolygon class by giving sample values to instance variables
 * @author Tarun
 *
 */
public class RegularPolygonTester 
{
	/**
	 * Created an instance variable dand d31,d2  to check the output of the variables and methods of the Shape Class
	 * @param args
	 */
	public static void main(String[] args)
	{
		RegularPolygon d = new RegularPolygon(3, 5);
		System.out.println("Number of sides: " + d.getNumOfSides());
		System.out.println("Radius: " + d.getRadius());
		
		RegularPolygon d2 = new RegularPolygon(3);
		System.out.println("Number of sides: " + d2.getNumOfSides());
		System.out.println("Radius: " + d2.getRadius());
		
		RegularPolygon d3 = new RegularPolygon();
		System.out.println("Number of sides: " + d3.getNumOfSides());
		System.out.println("Radius: " + d3.getRadius());
		
		Color color = new Color(0,0,0);
		d.setColor(color); //color variable to indicate the color of the shape
		d.setFilled(true); //The boolean filled indicates whether the shape is filled with
		d.setTheta(0); //Theta indicates the initial angle at which the shape is oriented
		d.setXc(0); //xc is the x-coordinate of the center of the shape
		d.setYc(0); //yc is the y-coordinate of the center of the shape
		

		
		System.out.println("Color: " + d.getColor());
		System.out.println("Filled: " + d.getFilled());
		System.out.println("Initial angle: " + d.getTheta());
		System.out.println("Initial center co-ordinates: " + d.getXc() + "," + d.getYc());
		for(int i = 0; i < d.getXLocal().length; i++)
		{
			System.out.println("Initial co-ordinates: of vertice "+ i + " is "+ d.getXLocal()[i] + "," + d.getYLocal()[i]);
		}
		
		System.out.println("The point 10,0 lies inside the shape is : " + d.contains(10, 0));
		
	}
}