class Storage {
    int memory;
    boolean SDD;

    Storage(int memory, boolean SDD) {
        this.memory = memory;
        this.SDD = SDD;
    }

    public void display() {
        System.out.println("Memory occupied:- " + memory + "\nIs SDD ? " + SDD);
    }
}

class Computer {
    String brand;
    double price;
    Storage s;

    Computer(String brand, double price, Storage s) {
        this.brand = brand;
        this.price = price;
        this.s = s;
    }

    public void display() {
        System.out.println("Brand Name:- " + brand + "\nPrice:- " + price);
        this.s.display();
    }

}

public class ComputerTest {
    public static void main(String[] args) {
        Storage str = new Storage(8, false);
        Computer c = new Computer("Lenovo ip3", 77000.76, str);
        c.display();
    }
}