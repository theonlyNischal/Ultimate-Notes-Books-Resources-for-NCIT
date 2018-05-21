import java.awt.*;
import javax.swing.*;

class GridDemo
{
  public static void main(String args[])
  {
    JFrame frame=new JFrame();
    frame.setLayout(new GridLayout(3,2,4,4));
    JButton b1=new JButton("Button one");
    JButton b2=new JButton("Button two");
    JButton b3=new JButton("Button three");
    JButton b4=new JButton("Button four");
    JButton b5=new JButton("Button five");
    JButton b6=new JButton("Button six");
    JButton b7=new JButton("Button seven");
    frame.add(b1);
    frame.add(b2);
    frame.add(b3);
    frame.add(b4);
    frame.add(b5);
    frame.add(b6);
 //   frame.add(b7);
    
    frame.setVisible(true);
    frame.setSize(200,200);
  }
}