import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


class CardDemo implements ActionListener
{
  JPanel p;
  JButton b1,b2;
  JTextField t1;
  JPasswordField p1;
  CardLayout c;
  CardDemo()
  {
    JFrame frame=new JFrame();
    frame.setLayout(new FlowLayout());
    b1=new JButton("Button1");
    b2=new JButton("Button2");
    frame.add(b1);
    frame.add(b2);
    
    b1.addActionListener(this);
    b2.addActionListener(this);
                      
    p=new JPanel();
    c=new CardLayout();
    p.setLayout(c);
    
    t1=new JTextField("hello");
    p1=new JPasswordField("Hello");
    JPanel pan1=new JPanel();
    JPanel pan2=new JPanel();
    
    pan1.add(t1);
    pan2.add(p1);
    
   
    p.add(pan1,"one");
    p.add(pan2,"two");
    
    frame.add(p);
    
    frame.setSize(200,200);
    frame.setVisible(true);
  }
  public static void main(String args[])
  {
    new CardDemo();
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==b1)
    {
      c.show(p,"one");
    }
    else if(e.getSource()==b2)
    {
      c.show(p,"two");
    }
  }
}