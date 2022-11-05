public class Variable_02 {
    static String name = "Many kumar";// static variable

    void function() {
        String addr = "Many kumar";// instance variable
        System.out.println(name + " " + addr);
        name = "hima kumar";
        addr = "Butwal";
    }

    public static void main(String[] args) {
        Variable_02 obj = new Variable_02();
        obj.function();
        obj.function();
    }
}
/*
 * i'm expecting the output at first:-
 * many kumar many kumar
 * and at second:-
 * hima kumar many kumar
 */
