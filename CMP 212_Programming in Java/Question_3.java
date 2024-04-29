import java.util.Scanner;
/*
This is the third question which is to convert the
farenheit value into a celcius value
 */
public class Question_3 {
    public static void main(String [] args)
    {
        float farenheit,celcius;
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Temperature in Farenheit: ");
        farenheit = input.nextFloat();

        celcius=(5.0f/9.0f)*(farenheit-32);

        System.out.println("The Temperature in Celcius is: "+celcius);
    }
}
