import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ClickReporter extends JFrame {
  public static JLabel l1;
  ClickReporter() {
    setLayout(new FlowLayout());
     l1=new JLabel();
    add(l1);
    addMouseListener(new ClickListener());
    setVisible(true);
    setSize(200,200);
  }
  public static void main(String args[])
  {
    new ClickReporter();
  }
  class ClickListener extends MouseAdapter
 {
  public void mousePressed(MouseEvent e)
  {
   l1.setText("Mouse Clicked at"+e.getX()+","+e.getY()); 
  }
}
}

