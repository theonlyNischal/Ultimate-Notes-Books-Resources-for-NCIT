import java.io.IOException;
import java.io.FileInputStream;
import java.io.DataInputStream;

class ReadData{
    public static void main(String[] args) throws IOException{
        FileInputStream fis=new FileInputStream("record.dat");
        DataInputStream dis=new DataInputStream(fis);
        while((dis.available())>0)
        {
            String name=dis.readUTF();
            int roll=dis.readInt();
            String faculty=dis.readUTF();
            if(faculty.toLowerCase().equals("software")){
                System.out.println("Name: "+name+" Roll: "+roll+" Faculty: "+faculty);
            }
        }
        dis.close();
        fis.close();
    }
}

