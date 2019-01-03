// BlueJ project: lesson9/scene2

import java.util.ArrayList;

public class Scene
{
    public static void main(String[] args)
    {
        // TODO: Change to an ArrayList<Drawable>
        ArrayList<Drawable> elements = new ArrayList<Drawable>();
        //ArrayList<Car> cars = new ArrayList<Car>();
        elements.add(new Car(100, 300));
        elements.add(new Car(250, 300));
        elements.add(new Car(250, 350));
            
        //ArrayList<House> houses = new ArrayList<House>();
        elements.add(new House(100, 150, 100, 100));
        elements.add(new House(250, 100, 150, 150));

        //ArrayList<Dog> dogs = new ArrayList<Dog>();
        elements.add(new Dog(200, 100, "Fido.jpg"));
        elements.add(new Dog(100, 400, "Rex.jpg"));
        elements.add(new Dog(200, 400, "Lucky.jpg"));

        // TODO: Change to a single loop
        for (Drawable d : elements)
        {
            d.draw();
        }
 
    }
}
