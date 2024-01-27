public class Sedan extends Car{
    int length;

    public Sedan(int speed, double regularprice, String color, int length)
    {
        super(speed, regularprice, color);
        this.length=length;
    }

    double getSalePrice()
    {
        if(length>20)
        {
            return regularprice*0.95; // 5% discount for length > 20
        }
        else{
            return regularprice*0.9; // 10% discount for length <=20
        }
    }

}
