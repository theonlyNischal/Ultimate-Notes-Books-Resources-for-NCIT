
// Application to copy a file
import java.io.*;
class CopyFile {
    public static void main(String []args)throws IOException{
        FileInputStream fis = new FileInputStream("happybdday.mp3");
        FileOutputStream fos = new FileOutputStream("happybdday2.mp3");
        int data;
        while((data = fis.read())!= -1){
            fos.write(data);
        }
        fis.close();
        fos.close();
    }
}
