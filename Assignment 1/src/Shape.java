import java.awt.Color;

/**
 * The class shape is the superclass which helps to model the shapes described in the subclass. The instance variables include color, fill-type, orientation, local coordinates and screen coordinates of the vertices of a shape. It also has methods to deduce the screen coordinates of the vertices of the concerned shape.
 * @author Tarun
 * 
 */
public class Shape {
	
	/**
	 * This object implements the Color class present in the "import java.awt.Color" to specify the color of the object.
	 */
	
	Color color; 
	/**
	 *  a boolean type instance variable used to implement if the color is filled in the shape or not
	 */
	
	boolean filled;
	
	/**
	 * a double instance which specifies the orientation of the shape in radians
	 */
	double theta; 
	
	/**
	 * a double instance which specifies the x-coordinate of the center of the shape
	 */
	
	double xc;
	
	/**
	 * a double instance which specifies the y-coordinate of the center of the shape
	 */
	
	double yc;
	
	/**
	 * an array of double values specifying the x-coordinates of vertices of the local coordinates of the shape
	 */
	double [] xLocal;
	
	/**
	 * an array of double values specifying the y-coordinates of the vertices of the local coordinates of the shape
	 */
	
	double [] yLocal;
	
	/**
	 * This method is a dummy method which would be overridden by other methods in the respective subclasses of the shapes. The main function of the method is to set local coordinates of the shape
	 * 
	 * @param d
	 * 			The parameter d in the method refers to the length of the vertices which could be the side of a circle, radius of a circle or side of an equilateral triangle	
	 */
	
	public void setVertices(double d)
	{

	}
	
	/**
	 * This method will push the shape in the x and y directions by adding the parameters dx and dy to the x and y coordinates of the center of the shape.
	 * 
	 * @param dx
	 * 		The parameter dx is used to store the value of the change we want to add in the x coordinate of the center of the shape.
	 * @param dy
	 * 		The parameter dy is used to store the value of the change we want to add in the y coordinate of the center of the shape.
	 */
	
	public void translate(double dx, double dy)
	{
		xc = xc + dx;
		yc = yc + dy;
	}
	
	/**
	 * This method helps in changing the orientation of the concerned shape by angle in radians 
	 * 
	 * @param dt
	 * 		The parameter dt is used to store the value of the angle at which the shape is to be rotated in radians
	 */
	
	public void rotate(double dt)
	{
		theta = dt + theta;
	}
	
	/**
	 *  This method helps in generating the x coordinates of the vertices in the screen coordinate system
	 * @return
	 * 			It returns an integer array with the rounded value of x coordinates of the vertices in the screen coordinate system
	 */
	
	public int[] getX()
	{
		
		int j = xLocal.length; // variable which stores the length of the integer xLocal
		
		int [] screenCoordinatesX = new int[j]; // an array which stores the y-screen coordinates of the shape 
		
		for(int i = 0; i < xLocal.length;i++)
		{
			screenCoordinatesX[i] =(int)((Math.round(xLocal[i]*Math.cos(theta) - yLocal[i]*Math.sin(theta) + xc))) ;
		}
		
		return screenCoordinatesX;
	}
	
	/**
	 *  This method helps in generating the y coordinates of the vertices in the screen coordinate system
	 * @return
	 * 			It returns an integer array with rounded value of y coordinates of the vertices in the screen coordinate system
	 */
	
	public int[] getY()
	{
		
		int k = yLocal.length; // variable which stores the length of the integer yLocal 
		
		int [] screenCoordinatesY = new int [k]; // an array which stores the y-screen coordinates of the shape 
				
		for(int i = 0; i < yLocal.length;i++)
		{
			screenCoordinatesY[i] = (int)((Math.round(xLocal[i]*Math.sin(theta) + yLocal[i]*Math.cos(theta) + yc)));
		}
		
		return screenCoordinatesY;
	}

}
