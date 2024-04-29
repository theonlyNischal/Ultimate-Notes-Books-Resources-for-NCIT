public class Truck extends Car{
    private int weight;
    public Truck(int speed, double regularprice, String color, int weight)
    {
        super(speed,regularprice,color);
        this.weight=weight;
    }

    public double getSalePrice()
    {
        if(weight>20000)
        {
            return regularprice*0.9;    //10% discount for weight >2000
        }
        else
            return regularprice*0.8;  //20% discount for weight<=2000
    }

}