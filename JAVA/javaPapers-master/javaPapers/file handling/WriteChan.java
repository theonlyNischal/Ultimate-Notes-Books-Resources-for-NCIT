import java.io.*;
import java.nio.*;
import java.nio.channels.*;

class WriteChan
{
 public static void main(String args[])throws IOException
 {
   FileOutputStream fout=new FileOutputStream("ada.txt");
   FileChannel fchan=fout.getChannel();
   
   ByteBuffer mbuf=ByteBuffer.allocate(100); //allocate size of buffer
   String str="this is a test using file channel";
   byte b[]=str.getBytes();
   
   for(int i=0;i<b.length;i++)
     mbuf.put(b[i]);  //write contents to buffer
   mbuf.rewind();
   fchan.write(mbuf); //write contents to the file
   
   System.out.println("Data written to file");
   fchan.close();
   fout.close();
 }
}
     
   
   