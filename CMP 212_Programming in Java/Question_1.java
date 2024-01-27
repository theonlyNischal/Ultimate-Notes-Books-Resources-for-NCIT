import java.util.Scanner;
/*
   This is a first question answer for the java assignment
   which is to write a simple text based application using java to display your name
    */
public class Question_1 {

    public static void main(String [] args){
        String forename,lastname ;
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Your First Name: ");
        forename = input.next();

        System.out.println("Please Enter Your Last Name: ");
        lastname = input.next();


        System.out.println("The name is: " +forename+" "+lastname);


    }

}
