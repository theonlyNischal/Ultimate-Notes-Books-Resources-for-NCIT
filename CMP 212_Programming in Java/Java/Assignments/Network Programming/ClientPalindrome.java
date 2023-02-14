import java.net.*;
import java.io.*;
import java.util.Scanner;

class ClientPalindrome{
    public static void main(String [] args) throws IOException{
        Socket soc = new Socket("localhost",5000);
        Scanner s=new Scanner(System.in);
        DataOutputStream dos=new DataOutputStream(soc.getOutputStream());
        DataInputStream dis=new DataInputStream(soc.getInputStream());
        while(true){
            System.out.println("Enter any string to check for palindrome or not: ");
            String str=s.next();
            if(str.equalsIgnoreCase("exit")){
                System.out.println("Session terminated!");
                break;
            }
            dos.writeUTF(str);
            String msg=dis.readUTF();
            System.out.println("Message from server: "+msg);
        }
        dis.close();
        dos.close();
        soc.close();
        s.close();
    }
}