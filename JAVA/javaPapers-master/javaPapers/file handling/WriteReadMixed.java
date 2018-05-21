import java.io.*;
class WriteReadMixed
{
  public static void main(String args[])throws IOException
  {
    FileOutputStream fout=new FileOutputStream("mixed.txt");
    DataOutputStream dout=new DataOutputStream(fout);
    
    
    dout.writeInt(30);
    dout.writeChar('a');
    dout.writeDouble(2.55);
    dout.writeUTF("This is mixed data");
    
    System.out.println("Data written to file");
    fout.close();
    dout.close();
	
    System.out.println("Reading from file.......");
    
    FileInputStream fin=new FileInputStream("mixed.txt");
    DataInputStream din=new DataInputStream(fin);
    
    System.out.println(din.readInt());
    System.out.println(din.readChar());
    System.out.println(din.readDouble());
    System.out.println(din.readUTF());
    
    fin.close();
    din.close();
  }
}
                   