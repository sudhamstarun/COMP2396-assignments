
/**
 * This is a subclass of the superclass Shape which has setVertices,getX and getY methods  which override the setVertices,getX and getY methods in the Shape class to make a circle
 * @author Tarun
 *
 */

public class Circle extends Shape{
	
	/**
	 * This method is a dummy method which would be overridden by other methods in the respective subclasses of the shapes. The main function of the method is to set local coordinates of the circle
	 * 
	 * @param d
	 * 			The parameter d in the method refers to the length of the radius of the circle	
	 */
	
	public void setVertices(double d)
	{
		xLocal = new double[2]; // setting the size of the xLocal array
		yLocal = new double[2]; // setting the size of the yLocal array
		xLocal[0] = -d; // initiating local coordinates of the circle
		yLocal[0] = -d;
		xLocal[1] = d;
		yLocal[1] = d;
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
		
		screenCoordinatesX[0] = (int) (xLocal[0] + xc);
		screenCoordinatesX[1] = (int) (xLocal[1] + xc);
		
		
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
		
		int [] screenCoordinatesY = new int[k]; // an array which stores the y-screen coordinates of the shape 
		
		screenCoordinatesY[0] = (int) (yLocal[0] + yc);
		screenCoordinatesY[1] = (int) (yLocal[1] + yc);
		
		return screenCoordinatesY;
	}

}
