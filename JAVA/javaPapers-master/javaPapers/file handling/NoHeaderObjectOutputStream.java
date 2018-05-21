//every time we write an object using objectoutput stream it writes header information to the file. so we need to override that
//header information both for objectoutputstream and objectinputstream
import java.io.*;
class NoHeaderObjectOutputStream extends ObjectOutputStream {
  public NoHeaderObjectOutputStream(OutputStream os)throws IOException {
    super(os);
  }
  protected void writeStreamHeader() {
    try{ reset();}
    catch(Exception e){};
  }
}
  class NoHeaderObjectInputStream extends ObjectInputStream{
    public NoHeaderObjectInputStream(InputStream os)throws IOException {
    super(os);
  }
  protected void readStreamHeader() {
    try{ reset();}
    catch(Exception e){};
  }
  }
  class ReadWriteMultipleObjects
  {
  public static void main(String args[])throws IOException{
  FileOutputStream fout=new FileOutputStream("wobj",true);
  NoHeaderObjectOutputStream oout=new NoHeaderObjectOutputStream(fout);
    
    Person p=new Person();
    p.setName("chuda");
    oout.writeObject(p);
    Person p1=new Person();
    p1.setName("ghanu");
    oout.writeObject(p1);
    System.out.println("Data written to file");
   
    oout.close();
    fout.close();
    
    
    FileInputStream fin=new FileInputStream("wobj");
    NoHeaderObjectInputStream oin=new NoHeaderObjectInputStream(fin);
    boolean EOF=false;
    while(!EOF){try{
    Person p2=(Person)oin.readObject();
    System.out.println(p2.getName());
    }catch(Exception e){EOF=true;}}

    
    oin.close();
    fin.close();
    
}
}