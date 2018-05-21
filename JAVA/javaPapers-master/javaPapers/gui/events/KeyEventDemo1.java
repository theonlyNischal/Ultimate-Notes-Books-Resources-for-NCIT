//handling key events
//key event is generated when a key is pressed in the keyboard

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class KeyEventDemo1 extends KeyAdapter implements FocusListener
{
  JTextField t1,t2;
  KeyEventDemo1()
  {
    JFrame frame=new JFrame();
    frame.setLayout(new FlowLayout());
    JLabel l1=new JLabel("Name");
    frame.add(l1);
    t1=new JTextField(20);
    frame.add(t1);
    JLabel l2=new JLabel("Phone");
    frame.add(l2);
    t2=new JTextField(20);
    frame.add(t2);
    
    t1.addKeyListener(this);
    t2.addKeyListener(this);
    
    t1.addFocusListener(this);
    t2.addFocusListener(this);
    
    frame.setSize(200,200);
    frame.setVisible(true);
    
  }
  public static void main(String args[])
  {
    new KeyEventDemo1();
  }
  public void keyTyped(KeyEvent e)
  {
    char ch=e.getKeyChar();
    if(e.getSource()==t1)
    {
      if(ch>='0' && ch<='9')
        e.consume();
    }
    if(e.getSource()==t2)
    {
      if(ch<'0' || ch>'9')
        e.consume();
    }
  }
  public void focusGained(FocusEvent e)
  {
    if(e.getSource()==t1)
      t1.setBackground(Color.PINK);
    if(e.getSource()==t2)
      t2.setBackground(Color.PINK);
    
  }
  public void focusLost(FocusEvent e)
  {
    if(e.getSource()==t1)
      t1.setBackground(Color.WHITE);
    if(e.getSource()==t2)
      t2.setBackground(Color.WHITE);
  }
  
}
      