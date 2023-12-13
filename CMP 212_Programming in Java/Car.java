/*
This is the 9th Question of the Assignment which has many child classes
child classes - Truck,Ford,Sedan
 */
public class Car {
    private int speed;
    double regularprice;
    private String color;

    public Car(int speed, double regularprice, String color)
    {
        this.speed=speed;
        this.regularprice=regularprice;
        this.color=color;
    }

    public double getSalepPrice()
    {
        return regularprice;
    }

}
