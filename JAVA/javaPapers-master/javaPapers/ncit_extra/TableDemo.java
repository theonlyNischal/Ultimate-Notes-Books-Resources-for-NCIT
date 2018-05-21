import javax.swing.*;
import java.awt.*;
class TableDemo
{
  JFrame f1;
  JTable t1;
  TableDemo()
  {
     f1=new JFrame();
     f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f1.setLayout(new BorderLayout());

     String cols[]={"Id","Name","salary"};
     Object data[][]={{1,"Ram",2000},{2,"Hari",3000},{1,"Ram",2000},{2,"Hari",3000},{1,"Ram",2000},{2,"Hari",3000}
     ,{1,"Ram",2000},{2,"Hari",3000},{1,"Ram",2000},{2,"Hari",3000}};
     t1=new JTable(data,cols);
     JScrollPane jp=new JScrollPane(t1);
     f1.add(jp,BorderLayout.CENTER);
     f1.setSize(300,300);
     f1.setVisible(true);
     f1.setLocation(300,300);
   }
   public static void main(String args[])
   {
     new TableDemo();
   }
}