public class Immutable {
    public static void main(String[] args) {
        String fname = "Pradip";
        String lname = "Pradip";
        String anotherName = new String("Pradip");
        System.out.println(fname == anotherName);
    }
}
