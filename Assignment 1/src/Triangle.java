
/**
 * This is a subclass of the superclass Shape which has a method setVertices which overrides the setVertices method in the Shape class to make a equilateral triangle
 * @author Tarun
 *
 */

public class Triangle extends Shape  {

	/**
	 * This method overrides the setVertices method in the Shape superclass. The main function of the method is to set local coordinates of the equilateral triangle shape
	 * 
	 * @param d
	 * 			The parameter d in the method refers to the length of the vertices for the equilateral triangle shape
	 */
	
	public void setVertices(double d)
	{
		xLocal = new double[3]; // setting the size of the xLocal array
		yLocal = new double[3]; // setting the size of the yLocal array
		xLocal[0] = d;
		yLocal[0] = 0;
		xLocal[1] = (-d)*(Math.cos((Math.PI)/3)); // initiating the local coordinates of the triangle 
		yLocal[1] = (-d)*(Math.sin((Math.PI)/3));
		xLocal[2] = (-d)*(Math.cos((Math.PI)/3));
		yLocal[2] = (d)*(Math.sin((Math.PI)/3)); 
	}
}
