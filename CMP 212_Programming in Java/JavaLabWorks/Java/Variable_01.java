class Variable_01 {
    static String addr = "Kathmandu, Nepal";
    int age = 19;

    public static void main(String[] args) {
        Variable_01 a = new Variable_01();
        String name = "isha hitang"; // static variable
        System.out.println(name);
        System.out.println(Variable_01.addr);
        System.out.println(a.age);
    }

}
