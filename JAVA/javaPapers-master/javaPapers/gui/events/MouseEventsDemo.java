//handling mouse events
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class MouseEventsDemo implements MouseListener
{
  JPanel p;
  JLabel l1;
  MouseEventsDemo()
  {
    JFrame frame=new JFrame();
    frame.setLayout(new BorderLayout());
    p=new JPanel();
    frame.add(p,BorderLayout.CENTER);
    l1=new JLabel("Status");
    frame.add(l1,BorderLayout.SOUTH);
    
    p.addMouseListener(this);
    frame.setSize(200,200);
    frame.setVisible(true);
  }
  public static void main(String args[])
  {
    new MouseEventsDemo();
  }
  public void mouseEntered(MouseEvent e)
  {
    p.setBackground(Color.BLUE);
  }
  public void mouseExited(MouseEvent e)
  {
    p.setBackground(Color.WHITE);
  }
  public void mouseReleased(MouseEvent e)
  {
    l1.setText("mouse released");
  }
  public void mousePressed(MouseEvent e)
  {
    l1.setText("mouse pressed");
  }
  public void mouseClicked(MouseEvent e)
  {
  }
}
