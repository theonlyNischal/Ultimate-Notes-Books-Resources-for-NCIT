import java.awt.*;
import java.awt.event.*;
class GUI1 extends WindowAdapter
{
  Frame f1;
  GUI1()
  {
    f1=new Frame("this is AWT frame");
    f1.setSize(300,300);
    f1.setVisible(true);
    f1.addWindowListener(this);

  }
  public void windowClosing(WindowEvent e)
  {
    f1.dispose();
  }
  public static void main(String args[])
  {
    new GUI1();
  }
}