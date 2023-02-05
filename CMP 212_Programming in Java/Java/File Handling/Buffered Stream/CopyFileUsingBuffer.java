import java.io.*;

class CopyFileUsingBuffer {
    public static void main(String []args)throws IOException{
        FileInputStream fis = new FileInputStream("seen.jpg");
        FileOutputStream fos = new FileOutputStream("seenCopy.jpg");
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int data;
        while((data = bis.read())!= -1){
            bos.write(data);
        }
        bos.close();
        bis.close();
        fis.close();
        fos.close();
    }
}
