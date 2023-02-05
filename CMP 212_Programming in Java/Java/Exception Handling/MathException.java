import java.util.InputMismatchException;
import java.util.Scanner;

class MathException{
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        try{
            System.out.println("Enter first number: ");
            int num=s.nextInt();
            System.out.println("Enter second number: ");
            int denum=s.nextInt();
            int ans=num/denum;
            System.out.println(ans);
        }catch(ArithmeticException e){
            System.out.println("Enter valid denumerator!");
        }catch(InputMismatchException e){
            System.out.println("Enter integer only!");
        }
        s.close();
    }
}