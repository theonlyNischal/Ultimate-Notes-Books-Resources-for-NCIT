package test;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMReader {
    public static void main(String args[])throws Exception{
        File xmlfile=new File("d:/employee.xml");
     DocumentBuilderFactory f=DocumentBuilderFactory.newInstance();
        DocumentBuilder b=f.newDocumentBuilder();
        Document doc=b.parse(xmlfile);
        
        String rootElement=doc.getDocumentElement().getNodeName();
        System.out.println("Root Element:"+rootElement);
        
        NodeList nList=doc.getElementsByTagName("employee");
        for(int i=0;i<nList.getLength();i++){
            Node nNode=nList.item(i);
                    
            Element element=(Element)nNode;
System.out.println("Name : "+element.getElementsByTagName("name").item(0).getTextContent());
System.out.println("Address : "+element.getElementsByTagName("address").item(0).getTextContent());
System.out.println("Salary : "+element.getElementsByTagName("salary").item(0).getTextContent());
        }
    }
}
