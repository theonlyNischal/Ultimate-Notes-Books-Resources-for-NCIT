
import java.io.FileInputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SAXReader extends DefaultHandler {
    boolean name=false;
    boolean age=false;
  
 public void startElement(String u,String l,String q,Attributes a){
        if(q.equals("name"))
            name=true;
        else if(q.equals("age"))
            age=true;
 }
    
    public void characters(char ch[],int start,int len){
        String value=new String(ch,start,len);
        if(name){
            System.out.println("Name: "+value);
            name=false;
        }
        else if(age){
            System.out.println("Age: "+value);
            age=false;
         }
        
    }
 
    public static void main(String args[])throws Exception{
        SAXParser p=SAXParserFactory.newInstance().newSAXParser();
  p.parse(new FileInputStream("d:/students.xml"), new SAXReader());
    }
}
