// formulas for surface area and volume
// http://math.about.com/od/formulas/ss/surfaceareavol.htm
//
// TODO: complete the code so that Sphere implements the GeometricSolid interface
//
public class Sphere implements GeometricSolid
{
    private double radius;

    /**
     * Constructor for objects of class Sphere
     */
    public Sphere()
    {
        radius = 0;
    }

    /**
     * Constructs a Shpere with the given radius
     * @param r the radius
     */
    public Sphere( double r)
    {
        radius = r;
    }

    public void setRadius(double r)
    {
        radius = r;
    }

    public double getRadius()
    {
        return radius;
    }

    //other methods
    public double getVolume()
    {
        return (radius*radius*radius*Math.PI)*4/3;
    }
    public double getSurfaceArea()
    {
        return (radius*radius*Math.PI)*4;
    }
}
