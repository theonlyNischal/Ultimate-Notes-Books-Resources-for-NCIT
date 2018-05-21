RandomAccessFile:
-------------------
It is a class in java.io package used for creating a file to write or read randomly at any position. 

Its constructor uses two arguments:
RandomAccessFile(String filename,String mode);
Mode can be "r" for read only
and "rw" for read and write both.

-->Methods writeInt(), writeUTF(),writeDouble()etc are used for writing to file and readInt(), readUTF(), readDouble() etc for reading from file.
-->seek() is used to place the cursor at specified position and getFilePointer() returns the current position of cursor.






import java.io.*;
class RandomDemo
{
  public static void main(String args[])throws FileNotFoundException,IOException
  {
    File f1=new File("hello.txt");
    RandomAccessFile rFile=new RandomAccessFile(f1,"rw");
    rFile.seek(f1.length());
    rFile.writeInt(10);
    rFile.writeDouble(10.5);
    long pos=rFile.getFilePointer();
    rFile.writeChar('A');
    rFile.seek(0);
    System.out.println(rFile.readInt());
    System.out.println(rFile.readDouble());
    rFile.seek(f1.length());
    rFile.writeBoolean(true);
    rFile.seek(pos);
    System.out.println(rFile.readChar());
    System.out.println(rFile.readBoolean());
  
    rFile.close();
      
  }
}