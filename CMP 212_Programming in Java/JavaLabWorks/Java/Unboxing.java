class Unboxing {
    public static void main(String[] args) {
        Integer i = new Integer(12);
        int a = i.intValue();
        int k = i;
        System.out.println(i + " " + a + " " + k);
    }
}
