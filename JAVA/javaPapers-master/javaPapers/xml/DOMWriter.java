package test;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class DOMWriter {
    public static void main(String args[])throws Exception{
        DocumentBuilderFactory f=DocumentBuilderFactory.newInstance();
        DocumentBuilder b=f.newDocumentBuilder();
        Document doc=b.newDocument();
        
        Element rootele=doc.createElement("students");
        Element studentele=doc.createElement("student");
        Element nameele=doc.createElement("name");
        Element ageele=doc.createElement("age");
        
        Text t1=doc.createTextNode("Hari");
        Text t2=doc.createTextNode("44");
        
        nameele.appendChild(t1);
        ageele.appendChild(t2);
        
        studentele.appendChild(nameele);
        studentele.appendChild(ageele);
        
        rootele.appendChild(studentele);
        doc.appendChild(rootele);
        
    Transformer t=TransformerFactory.newInstance().newTransformer();
    t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("d:/students.xml")));
    System.out.println("xml file generated...........");
    }
}
