/*reading a file */

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

class ReadChan
{
 public static void main(String args[])throws IOException
 {
  FileInputStream fin=new FileInputStream("RandomDemo.java");
  
  FileChannel fchan=fin.getChannel(); //obtain channel to the file
  
  long fsize=fchan.size(); //get file size
  ByteBuffer mbuf=ByteBuffer.allocate((int)fsize); //allocate buffer size according to file size
  
  fchan.read(mbuf); //read the file into the buffer
  mbuf.rewind(); 
  
  for(int i=0;i<fsize;i++)
    System.out.print((char)mbuf.get());
  fchan.close();
  fin.close();
 }
}

                                          