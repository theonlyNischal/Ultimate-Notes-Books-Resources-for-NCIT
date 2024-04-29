public class Ford extends Car {
    private int year,manufacturerDiscount;
    public Ford(int speed, double regularprice,String color, int year, int manufacturerDiscount )
    {
        super(speed,regularprice,color);
        this.year=year;
        this.manufacturerDiscount=manufacturerDiscount;
    }

    public double getSalePrice()
    {
        return super.getSalepPrice()-manufacturerDiscount;
    }


}
