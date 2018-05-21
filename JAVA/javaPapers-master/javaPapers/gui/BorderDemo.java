import javax.swing.*;
import java.awt.*;

class BorderDemo
{
  BorderDemo()
  {
    JFrame frame=new JFrame();
    frame.setLayout(new BorderLayout());
    
    JButton b1=new JButton("Button one");
    JButton b2=new JButton("Button two");
    JButton b3=new JButton("Button three");
    JButton b4=new JButton("Button four");
    JButton b5=new JButton("Button five");
    
    frame.add(b1,BorderLayout.NORTH);
    frame.add(b2,BorderLayout.SOUTH);
    frame.add(b3,BorderLayout.EAST);
    frame.add(b4,BorderLayout.WEST);
    frame.add(b5,BorderLayout.CENTER);
    
    frame.setVisible(true);
    frame.pack();
   // frame.setSize(400,300);
    
  }
  public Insets getInsets()
  {
    return new Insets(20,20,20,20);
  }
  public static void main(String args[])
  {
    new BorderDemo();
  }
}