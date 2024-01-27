import java.util.Scanner;

public class Question_2 {
    /*
    This is the question number 2 which is to calculate product of three user input inteegers.
     */

    public static void main(String[] args)
    {
        int num1,num2,num3,product;
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Numbers: ");
        num1 = input.nextInt();
        num2 = input.nextInt();
        num3 = input.nextInt();

        product=num1*num2*num3;

        System.out.println("The Product pf the numbers is: "+product);




    }


}
