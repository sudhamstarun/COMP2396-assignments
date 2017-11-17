/**
 * This is a subclass of the superclass Shape which has a method setvertices which overrides the setVertices method in the Shape class to make the shape square.
 * @author Tarun
 * 
 */

public class Square extends Shape {
	
	/**
	 *   This method overrides the setVertices method in the Shape superclass. The main function of the method is to set local coordinates of the square shape.
	 * 
	 * @param d
	 * 			The parameter d in the method refers to the length of the vertices of a square
	 */
	
	public void setVertices(double d)
	{
		xLocal = new double[4]; // setting the size of the xLocal array
		yLocal = new double[4]; // setting the size of the yLocal array
		xLocal[0] = d; //initiating the local coordinates of the Square
		yLocal[0] = d;
		xLocal[1] = d;
		yLocal[1] = -d;
		xLocal[2] = -d;
		yLocal[2] = -d;
		xLocal[3] = -d;
		yLocal[3] = d;
	}

}
