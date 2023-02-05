import java.io.IOException;
import java.io.FileOutputStream;
import java.io.DataOutputStream;

import java.util.Scanner;

class WriteData{
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        FileOutputStream fos=new FileOutputStream("record.dat");
        DataOutputStream dos=new DataOutputStream(fos);
        String key;
        do{
            System.out.println("Enter your name: ");
            String name=s.next();
            System.out.println("Enter roll no: ");
            int roll=s.nextInt();
            System.out.println("Enter faculty: ");
            String faculty=s.next();
            dos.writeUTF(name);
            dos.writeInt(roll);
            dos.writeUTF(faculty);
            System.out.println("Enter n to exit or any other key to continue: ");
            key=s.next().toLowerCase();
        }while(!key.startsWith("n"));
        dos.close();
        fos.close();
    }
}
