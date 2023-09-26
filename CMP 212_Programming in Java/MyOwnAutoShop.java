public class MyOwnAutoShop {
    public static void main(String [] args)
    {
        //Creating an instance of Sedan Class
        Sedan sedan =  new Sedan(280,25000,"Black", 20);

        //Creating two instances of Ford Class
        Ford ford1 = new Ford(180,15000,"Blue",2022, 2500);
        Ford ford2 = new Ford(190,18000,"White",2023,1500);

        //Creating an instance of Car Class
        Car car1 = new Car(290,25000, "Gray");


        //Displaying the Sale prices of all the instances
        System.out.println("Sedan Sale Price: $" +sedan.getSalePrice());
        System.out.println("Ford1 Sale Price: $" +ford1.getSalePrice());
        System.out.println("Ford2 Sale Price: $" +ford2.getSalepPrice());
        System.out.println("Car Sale Price: $" +car1.getSalepPrice());
    }
}
