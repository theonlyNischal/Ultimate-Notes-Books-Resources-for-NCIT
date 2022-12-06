// WAP to take two integers from User and Perform Division.

import java.util.InputMismatchException;
import java.util.Scanner;
public class Division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
        System.out.println("Enter the First Number");
        int a = sc.nextInt();
        System.out.println("Enter the Second Number");
        int b = sc.nextInt();
        int c = a / b;
        System.out.println("The Division of " + a + " and " + b + " is " + c);
        } 
        catch (ArithmeticException e) {
            System.out.println("You can't divide a number by Zero");
        }
        catch (InputMismatchException e) {
            System.out.println("Enter Only Integers");
        }
    }
    
}
