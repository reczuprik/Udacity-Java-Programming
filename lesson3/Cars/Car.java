
public class Car
{
    private double milesDriven;
    private double gasInTank;
    private Picture pic;
    
    
    public void drive(double distance){
        milesDriven = milesDriven + distance;
        pic.translate(distance,0);
    }
    
    public void addGas(double amount){
        gasInTank = gasInTank + amount;
    }
}
