import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class GUI3 implements ActionListener
{
  JButton b;
  JCheckBox c1,c2,c3;
   JComboBox <String> cb;
  GUI3()
  {
     JFrame f=new JFrame();
     b=new JButton("Click me");
    f.add(b);
    f.setLayout(new FlowLayout());
    
    f.add(b);
    b.addActionListener(this);
    String cities[]={"ktm","bkt","pkr","ltp"};
     cb=new JComboBox<String>(cities);
    cb.addItem("apple");
    f.add(cb);
    
     c1=new JCheckBox("singing");
     c2=new JCheckBox("dancing");
     c3=new JCheckBox("music");
    f.add(c1);
    f.add(c2);
    f.add(c3);
    
    f.setVisible(true);
    f.setResizable(false);
    f.setSize(200,300);
  }
  public static void main(String args[])
  {
   new GUI3();
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==b)
    {
      String hobbies="";
      if(c1.isSelected())
        hobbies+=c1.getText()+" ";
      if(c2.isSelected())
        hobbies+=c2.getText()+" ";
      if(c3.isSelected())
        hobbies+=c3.getText()+" ";
      System.out.println("Hobbies: "+hobbies);
      
      String city=cb.getSelectedItem().toString();
      System.out.println("City: "+city);
    }
  }
}