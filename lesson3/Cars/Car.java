public class Car
{
    private double milesDriven;
    private double gasInTank;
    private Picture pic;
    private double milesPerGallon;

    public Car(double mpg) // Discussed later
    {
        milesDriven = 0;
        gasInTank = 0;
        milesPerGallon = mpg;
        pic = new Picture("car.jpg");
        pic.draw();
    }
    
    public Car(double mpg, String pictureFile) // Discussed later
    {
        milesDriven = 0;
        gasInTank = 0;
        milesPerGallon = mpg;
        pic = new Picture(pictureFile);
        pic.draw();
    }
    
    public void drive(double distance)
    {
        milesDriven = milesDriven + distance;
        
        double gasConsumed = distance /milesPerGallon;
        gasInTank=gasInTank-gasConsumed;
        int pixelsPerMile = 10;
        pic.translate(distance * pixelsPerMile, 0);
    }
  
    /**
     * 
     *  Add gas  to the tank of this car
     *  @param amount the amount of the gas to add
    */
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
