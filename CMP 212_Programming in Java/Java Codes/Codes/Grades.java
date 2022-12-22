
public class Grades{
    int math, dsa, java, malp, pqt, sef;
    float total;
    float per;

    public Grades(int math, int dsa, int java, int malp, int pqt, int sef) {
        this.math = math;
        this.dsa = dsa;
        this.java = java;
        this.malp = malp;
        this.pqt = pqt;
        this.sef = sef;
    }

    void function() {
        total = math + dsa + java + malp + pqt + sef;
        per = (total / 600) * 100;
        System.out.println("Your total marks is: " + total);
        System.out.println("Your percentage is: " + per + " % ");
    }

    public static void main(String[] args) {
        Grades total = new Grades(60, 90, 88, 65, 70, 60);
        total.function();
    }
}