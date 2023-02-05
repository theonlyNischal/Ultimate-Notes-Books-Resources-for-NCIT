// Write a Program to write name, roll no & address in a record.txt file

import java.io.*;
import java.util.Scanner;

class Example {
 static Scanner s = new Scanner(System.in);
 
 public static void main(String[] args)throws IOException {
        FileOutputStream fos = new FileOutputStream("record.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        do{
            System.out.println("Enter Name");
            String name = s.next();
            System.out.println("Enter Roll No");
            int rollNo = s.nextInt();
            System.out.println("Enter Address");
            String address = s.next();
            dos.writeUTF(name);
            dos.writeInt(rollNo);
            dos.writeUTF(address);

            System.out.println("Press n to Exit; Press any key to continue...");
        }
        while(!( s.next().equals("n") ));
        dos.close();
        fos.close();
 }
}