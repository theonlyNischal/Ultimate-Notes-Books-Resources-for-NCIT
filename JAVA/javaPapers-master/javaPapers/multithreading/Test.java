import java.io.*;
public class Test{
   public static void main(String args[]){
	     Console console=System.console();
        //Scanner scan=new Scanner(System.in);
        if(console!=null){
	
            String name=console.readLine("Enter username: ");
            System.out.println(name);
        char password[]=console.readPassword("Enter Password: ");
        System.out.println(password);
   	}
   }
}