//reading from console and displaying the output

import java.io.*;

class Test
{
  public static void main(String args[])throws Exception
  {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 
    System.out.println("Enter two numbers: ");
    int a=Integer.parseInt(br.readLine());
    int b=Integer.parseInt(br.readLine());
    int c=a+b;
    System.out.println("Sum is: "+c);
  }
}
    