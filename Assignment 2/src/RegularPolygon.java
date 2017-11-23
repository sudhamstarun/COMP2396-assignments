
/**
 * The RegularPolygon class is a subclass of Shape which helps us to create a general polygon 
 * @author Tarun
 *
 */
public class RegularPolygon extends Shape {
	
	/**
	 * an int type private instance variable which stores the number of sides of a shape
	 */
	
	private int numOfSides;
	
	/**
	 * a double type private instance variable which stores the radius of the shape 
	 */
	
	private double radius;
	

	/**
	 * This constructor helps in building a regular polygon with n sides and r radius 
	 * @param n
	 * 		The parameter n specifies the number of sides of the polygon
	 * @param r
	 * 		The parameter r specifies the radius of the polygon
	 */
	
	public RegularPolygon(int n, double r)
	{
		
		if(n < 3)
		{
			this.numOfSides = 3;
		}
		else
		{
			this.numOfSides = n;
		}
		if(r < 0)
		{
			this.radius = 0;
		}
		else
		{
			this.radius = r;
		}
		
		this.setVertices();
	}
	
	/**
	 * This constructor helps in building a regular polygon with n sides of radius 1.0
	 * @param n
	 * 		The parameter n specifies the number of the sides of the polygon
	 */
	
	public RegularPolygon(int n)
	{
		
		if(n < 3)
		{
			this.numOfSides = 3;
		}
		else
		{
			this.numOfSides = n;
		}
		this.radius = 1.0;
		
		this.setVertices();
	}
	
	/**
	 * 
	 */
	
	/**
	 * This constructor helps in building a regular polygon with 3 sides of radius 1.0
	 */
	
	public RegularPolygon()
	{
		this.numOfSides = 3;
		this.radius = 1.0;
		
		this.setVertices();
	}
	
	/**
	 * This method helps in getting the number of sides of the polygon
	 * @return
	 * 		Returns a private instance variable numOfSides which contains the number of sides of the polygon
	 */
	
	public int getNumOfSides()
	{
		return this.numOfSides;
	}
	
	/**
	 * This method helps in getting the radius of the polygon
	 * @return
	 * 		Returns a private instance variable radius which contains the radius of the polygon
	 */
	
	public double getRadius()
	{
		return this.radius;
	}
	
	/**
	 * This method helps in setting the number of sides of the polygon
	 * @param n
	 * 		The parameter n specifies the number of sides of the polygon
	 */
	
	public void setNumOfSides(int n)
	{
		
		if(n < 3)
		{
			this.numOfSides = 3;
		}
		else
		{
			this.numOfSides = n;
		}
	
		this.setVertices();
	}
	
	/**
	 * This method helps in setting the radius of the polygon
	 * @param r
	 * 		The parameter r specifies the radius of the polygon
	 */
	
	public void setRadius(double r)
	{
		if(r < 0)
		{
			this.radius = 0;
		}
		else
		{
			this.radius = r;
		}
		
		this.setVertices();
	}
	
	/**
	 * This method helps in setting the local coordinates of a regular-sized polygon depending on the radius and number of sides
	 */
	
	private void setVertices()
	{
		double alpha; // a mathematical constant used to calculate the screen coordinates
		
		if(this.numOfSides%2 == 0)
		{
			alpha = Math.PI/this.numOfSides;
		}
		
		else
		{
			alpha = 0;
		}
		
		double [] xcoordinates = new double[this.getNumOfSides()]; // an array of local x-coordinates of the vertices
		double [] ycoordinates = new double[this.getNumOfSides()]; // an array of local y-coordinates of the vertices
		
		for(int i = 0; i < this.getNumOfSides(); i++)
		{
			xcoordinates[i] = (this.getRadius())*(Math.cos(alpha - (i)*(2*Math.PI/this.getNumOfSides())));
			ycoordinates[i] = (this.getRadius())*(Math.sin(alpha - (i)*(2*Math.PI/this.getNumOfSides())));
		}
		
		setXLocal(xcoordinates);
		setYLocal(ycoordinates);
	}
	
	/**
	 * This method helps in finding if a certain point in screen coordinate system lies inside or outside the shape
	 * @param x
	 * 		The parameter x specifies the x-coordinate of the point that we want to check if it lies inside the polygon
	 * @param y
	 * 		The parameter y specifies the y-coordinate of the point that we want to check if it lies inside the polygon
	 * @return
	 * 		Returns true or false if the point lies inside the polygon or not
	 */
	
	public boolean contains(double x, double y)
	{
		double [] x_temporary = getXLocal();
		double x_minimum = 0;
		
		double local_x = (x - this.getXc())*Math.cos(-this.getTheta()) - (y - this.getYc())*Math.sin(-this.getTheta()); // converting screencoordinates into local coordinates
		double local_y = (x - this.getXc())*Math.sin(-this.getTheta()) + (y - this.getYc())*Math.cos(-this.getTheta());
		double new_x = local_x;
		
		for(int i = 1; i < numOfSides; i++)
		{	
			if(x_temporary[i] <= x_minimum)
			{
				x_minimum  = x_temporary[i];
			}
		}
		
		for(int i = 1; i <= numOfSides; i++)	
		{
			if(new_x < x_minimum)
			{
				return false;
			}
			
			new_x = local_x*Math.cos(2*i*Math.PI/this.getNumOfSides()) - local_y*Math.sin(2*i*Math.PI/this.getNumOfSides());
		}
		
		return true;
	}
}