public class Animal {
    // private access modifier that is only accessible inside the class.
    private String animalName = "Badar";

    public static void main(String[] args) {
        Animal animalobj = new Animal();
        System.out.println(animalobj.animalName);
    }

}
