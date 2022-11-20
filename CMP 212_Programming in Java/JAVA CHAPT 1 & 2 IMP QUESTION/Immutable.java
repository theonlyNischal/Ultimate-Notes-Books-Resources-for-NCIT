public class Immutable {
    public static void main(String[] args) {
        String fname = "Isha";
        String lname = "Isha";
        String anotherName = new String("Isha");
        System.out.println(fname == anotherName);
    }
}
