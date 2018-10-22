public class Car
{
    private double milesDriven;
    private double gasInTank;
    private Picture pic;
    private double milesPerGallon;

    public Car() // Discussed later
    {
        milesDriven = 0;
        gasInTank = 0;
        milesPerGallon = 50;
        pic = new Picture("car.jpg");
        pic.draw();
    }

    public void drive(double distance)
    {
        milesDriven = milesDriven + distance;
        
        double gasConsumed = distance /milesPerGallon;
        int pixelsPerMile = 10;
        pic.translate(distance * pixelsPerMile, 0);
    }

    public void addGas(double amount)
    {
        gasInTank = gasInTank + amount;
    }
    
    public double getMilesDriven()
    {
        return milesDriven;
    }
    
    public double getGasInTank()
    {
        return gasInTank;
    }
    
    // More methods ...

}
