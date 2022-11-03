class Autoboxing {
    public static void main(String[] args) {
        int a = 10;
        Integer i = Integer.valueOf(a);
        Integer k = a;
        System.out.println(a + " " + i + " " + k);
    }
}
