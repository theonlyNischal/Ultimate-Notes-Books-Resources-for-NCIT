import java.lang.*;

class Storage
{
    int memory;
    boolean hdd;

    public Storage(int memory,boolean hdd){
        this.memory=memory;
        this.hdd=hdd;
    }

    public void showDetails(){
        System.out.println("Is hdd ? "+this.hdd+"Memory = "+this.memory);
    }
}

class Computer
{
    Storage str;
    String brand;
    int price;

    public Computer(String brand,int price,Storage s)
    {
        this.brand=brand;
        this.price=price;
        this.str=s;
    }

    public void showDetails(){
        System.out.println("Brand = "+this.brand+"Price = "+this.price);
        this.str.showDetails();
    }
}

class Memory{
    public static void main(String []args)
    {
        Storage s = new Storage(20,false);
        Computer c = new Computer("DELL",80000,s);
        c.showDetails();
    }
}