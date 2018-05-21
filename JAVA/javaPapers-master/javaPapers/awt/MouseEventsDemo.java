//handling mouse events
import java.awt.event.*;
import java.awt.*;
//import javax.swing.*;
class MouseEventsDemo extends WindowAdapter implements MouseListener
{
  Panel p;
  Label l1;
Frame f1;
  MouseEventsDemo()
  {
    f1=new Frame();
    f1.setLayout(new BorderLayout());
    p=new Panel();
    f1.add(p,BorderLayout.CENTER);
    l1=new Label("Status");
    f1.add(l1,BorderLayout.SOUTH);
    
    p.addMouseListener(this);
    f1.setSize(200,200);
    f1.setVisible(true);
	f1.addWindowListener(this);
  }
	public void windowClosing(WindowEvent e){
		f1.dispose();
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
	l1.setText("mouse clicked");
  }
}
