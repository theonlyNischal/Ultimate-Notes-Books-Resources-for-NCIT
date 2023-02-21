/* Write a program that takes a string input from the user and sends the
string to the server. The server should check whether the string is
palindrome or not and return back to the client. */
import java.net.*;
import java.io.*;

class ServerPalindrome{
    public static void main(String [] args) throws IOException{
        ServerSocket ss= new ServerSocket(5000);
        System.out.println("Server running at 5000");
        Socket soc = ss.accept();
        System.out.println("Client accepted");
        DataInputStream dis=new DataInputStream(soc.getInputStream());
        String in=dis.readUTF();
        System.out.println(in);
        DataOutputStream dos=new DataOutputStream(soc.getOutputStream());
        dos.writeUTF(checkPalindrome(in));
        dos.close();
        dis.close();
        soc.close();
        ss.close();
    }
    public static String checkPalindrome(String str){
        String s="";
        char ch;
        for(int i=0;i<str.length();i++){
            ch=str.charAt(i);
            s=ch+s;
        }
        System.out.println(s);
        if(str.equalsIgnoreCase(s))
            return ("Palindrome");
        else
            return ("Not a palindrome");
    }
}
