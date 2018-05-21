import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MouseEventDemo extends MouseAdapter
{
  JLabel l1;
  JPanel p;
  MouseEventDemo()
  {
    JFrame frame=new JFrame();
    
    frame.setLayout(new BorderLayout());
    l1=new JLabel();
    frame.add(l1,BorderLayout.SOUTH);
     p=new JPanel();
   frame. add(p,BorderLayout.CENTER);
    
    p.addMouseListener(this);
  frame.  setVisible(true);
    frame.setSize(200,200);
  }
  public static void main(String args[])
  {
    new MouseEventDemo();
  }
  public void mouseEntered(MouseEvent e)
  {
    p.setBackground(Color.BLUE);
  }
  public void mouseExited(MouseEvent e)
  {
    p.setBackground(Color.WHITE);
  }
/*  public void mouseReleased(MouseEvent e)
  {
    l1.setText("Mouse released");
  }
  public void mousePressed(MouseEvent e)
  {
    l1.setText("MousePressed");
  }
  public void mouseClicked(MouseEvent e)
  {
    l1.setText("Mouse Clicked");
  }*/
}