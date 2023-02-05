// FILE  OUTPUTSTREAM =============== THIS IS USED TO WRITE TO A FILE

import java.io.*;
import java.util.Scanner;
class Outputstream {
    static Scanner s = new Scanner(System.in);
    public static void main (String []args)throws IOException{
        File file = new File("pradip.txt");
       FileOutputStream fos = new FileOutputStream(file);
        System.out.println("Enter a message to write in a file");
        String msg = s.next();
        byte []b = msg.getBytes();
        fos.write(b);
        fos.close();
    } 
}
