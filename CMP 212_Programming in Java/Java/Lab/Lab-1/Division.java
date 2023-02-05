import java.util.Scanner;
import java.util.InputMismatchException;
class Division{
	public static void main(String [] args){
		Scanner s=new Scanner(System.in);
		try{
			System.out.println("Enter first number: ");
			int a=s.nextInt();
			System.out.println("Enter second number: ");
			int b=s.nextInt();
			int ans= a/b;
			System.out.println("Result: "+ans);
		}catch(ArithmeticException e){
			System.out.println("Enter non zero denumenator!");
		}catch(InputMismatchException e){
			System.out.println("No character in division!");
		}
		s.close();
	}
}