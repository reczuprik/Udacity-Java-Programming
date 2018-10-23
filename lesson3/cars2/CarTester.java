
public class CarTester
{
    public static void main(String[] args)
    {
        Car car = new Car();
        car.addGas(20);
        car.drive(100);
        
        System.out.println(car.getGasInTank());
        System.out.println("Expected: 18");
    }
}
