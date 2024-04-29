import java.util.Scanner;

/*
This is the question Number four which is to Write an application that inputs three integers from the user
and displays the sum, average, product, smallest and largest of the numbers

 */
public class Question_4 {
    public static void main(String[] args)
    {
        int num1, num2,num3;
        float sum=0,average=0,product,smallest,largest;

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the Numbers: ");
        num1 = input.nextInt();
        num2 = input.nextInt();
        num3 = input.nextInt();

        sum = (float)num1+num2+num3;
        average=sum/3;
        product=(float)num1*num2*num3;

        if(num1>num2 && num1>num3)
        {
            largest=num1;
        }
        else if(num2>num3 && num2>num1)
        {
            largest=num2;
        }

        else
        {
            largest=num3;
        }

        if(num1<num2 && num1<num3)
        {
            smallest=num1;
        }

        else if(num2<num3 && num2<num1)
        {
            smallest=num2;
        }

        else
        {
            smallest=num3;
        }

        System.out.println("The Sum is: "+sum);
        System.out.println("The Aveerage is: "+average);
        System.out.println("The Product is: "+product);
        System.out.println("The Smallest is: "+smallest);
        System.out.println("The Highest is:  "+largest);


    }
}
