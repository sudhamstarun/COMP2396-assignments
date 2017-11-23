import java.awt.Color;

/**
 * The class shape is the superclass which helps to model the shapes described in the subclass. The instance variables include color, fill-type, orientation, local coordinates and screen coordinates of the vertices of a shape. It also has methods to deduce the screen coordinates of the vertices of the concerned shape.
 * @author Tarun
 *
 */

public class Shape 
{
	
	/**
	 * This object implements the Color class present in the "import java.awt.Color" to specify the color of the object.
	 */
	private Color color;
	
	/**
	 * a boolean type instance variable used to implement if the color is filled in the shape or not
	 */
	
	private boolean filled;
	
	/**
	 * a double instance which specifies the orientation of the shape in radians
	 */
	
	private double theta;
	
	/**
	 * a double instance which specifies the x-coordinate of the center of the shape
	 */
	
	private double xc;
	
	/**
	 * a double instance which specifies the y-coordinate of the center of the shape
	 */
	
	private double yc;
	
	/**
	 * an array of double values specifying the x-coordinates of vertices of the local coordinates of the shape
	 */
	
	private double [] xLocal;
	
	/**
	 * an array of double values specifying the y-coordinates of the vertices of the local coordinates of the shape
	 */
	
	private double [] yLocal;
	
	/**
	 * This getter method helps us get the color of the shape
	 * @return
	 * 		Returns the private value of the instance variable color
	 * */		
	
	public Color getColor()
	{
		return color;
	}
	

	/**
	 * This getter method helps us get the fill type of the shape
	 * @return
	 *		Returns the private value of the instance variable filled
	 */	
	
	
	public boolean getFilled()
	{
		return filled;
	}
	
	/**
	 * This getter method helps us get the angle of orientation of the shape
	 * @return
	 * 		Returns the private value of the instance variable theta
	 */
	
	public double getTheta()
	{
		return theta;
	}
	
	/**
	 * This getter method helps us get the x-coordinate of the center of the shape
	 * @return
	 * 		Returns the private value of the instance variable xc
	 */
	
	public double getXc()
	{
		return xc;
		
	}
	
	/**
	 * This getter method helps us get the y-coordinate of the center of the shape
	 * @return
	 * 		Returns the private value of the instance variable yc
	 */
	
	public double getYc()
	{
		
		return yc;
	}
	
	/**
	 * This getter method helps us get a double array containing the x-coordinates of the shape in local coordinate system
	 * @return
	 * 		Returns the private value of the instance variable xLocal
	 */
	
	public double [] getXLocal()
	{
	
		return xLocal;
	}
	
	/**
	 * This getter method helps us get a double array containing the y-coordinates of the shape in the local coordinate system 
	 * @return
	 * 		Returns the private value of the instance variable yLocal
	 */		
	
	public double [] getYLocal()
	{
		
		return yLocal;
	}
	
	/**
	 * This method helps in setting the color of the shape 
	 * @param color
	 * 		The parameter color is an instance variable which stores the color of the shape and belongs to the Color class
	 */
	
	public void setColor(Color color)
	{
		
		this.color = color;	
	}
	
	/**
	 * This method helps in setting the fill type of the shape 
	 * @param filled
	 * 		The parameter filled is a boolean type instance variable which can either be true or false 
	 */
	
	public void setFilled(boolean filled)
	{
		
		this.filled = filled;
	}
	
	/**
	 * This method helps in setting the angle of orientation of the shape
	 * @param theta
	 * 		The parameter theta is a double type instance variable which stores the angle of orientation of the shape
	 */
	
	
	public void setTheta(double theta)
	{
		
		this.theta = theta;
	}
	
	/**
	 * This method helps in setting the x-coordinate of the center of the shape
	 * 
	 * @param xc
	 * 		The parameter xc is a double which stores the value of the x-coordinate of the center of the shape
	 */
	
	public void setXc(double xc)
	{
		
		this.xc = xc;
	}
	
	/**
	 * This method helps in setting the y-coordinate of the center of the shape 
	 * 
	 * @param yc
	 * 		The parameter yc is a double which stores the value of the y-coordinate of the center of the shape
	 */
	
	public void setYc(double yc)
	{
		
		this.yc = yc;
	}
	
	/**
	 * This method will help us in setting the xLocal array
	 * 
	 * @param xLocal
	 * 		The parameter xLocal is an array used to store the x-coordinates of the shape in the local coordinates system
	 */
	public void setXLocal(double [] xLocal)
	{
		
		this.xLocal = xLocal;
	}
	
	/**
	 * This method will help us in the setting the  yLocal array
	 * 
	 * @param yLocal
	 * 		The parameter yLocal is an array used to store the y-coordinates of the shape in the local coordinates system
	 */
	public void setYLocal(double [] yLocal)
	{
		
		this.yLocal = yLocal;
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
		this.xc = this.xc + dx;
		this.yc = this.yc + dy; 	
	}
	
	/**
	 * This method helps in changing the orientation of the concerned shape by angle in radians 
	 * 
	 * @param dt
	 * 		The parameter dt is used to store the value of the angle at which the shape is to be rotated in radians
	 */
	 
	public void rotate(double dt)
	{
		this.theta = dt + this.theta;	
	}
	
	/**
	 *  This method helps in generating the x coordinates of the vertices in the screen coordinate system
	 * @return
	 * 			It returns an integer array with the rounded value of x coordinates of the vertices in the screen coordinate system
	 */
	
	public int[] getX()
	{
		int [] screenCoordinatesX = new int[this.getXLocal().length]; // an array which stores the y-screen coordinates of the shape v
		
		for(int i = 0; i < this.getXLocal().length;i++)
		{
			screenCoordinatesX[i] =(int)((Math.round(this.getXLocal()[i]*Math.cos(this.getTheta()) - this.getYLocal()[i]*Math.sin(getTheta()) + this.getXc()))) ;
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
		int [] screenCoordinatesY = new int [this.getXLocal().length]; // an array which stores the y-screen coordinates of the shape 
				
		for(int i = 0; i < this.getXLocal().length;i++)
		{
			screenCoordinatesY[i] = (int)((Math.round(this.getXLocal()[i]*Math.sin(this.getTheta()) + this.getYLocal()[i]*Math.cos(this.getTheta()) + this.getYc())));
		}
		
		return screenCoordinatesY;
	}
}