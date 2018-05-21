/*import java.awt.event.*;

public class ClickListener extends MouseAdapter
{
  public void mousePressed(MouseEvent e)
  {
   ClickReporter.l1.setText("Mouse Clicked at"+e.getX()+","+e.getY()); 
  }
}*/
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ClickClick extends JFrame {
  JLabel l1;
  JButton b1;
  ClickClick() {
    setLayout(new FlowLayout());
     l1=new JLabel();
    add(l1);
    b1=new JButton("one");
    add(b1);
    b1.addActionListener(new ButtonClickListener());
    setVisible(true);
    setSize(200,200);
  }
  public static void main(String args[])
  {
    new ClickClick();
  }
  class ButtonClickListener implements ActionListener
 {
  public void actionPerformed(ActionEvent e)
  {
   l1.setText("Button clicked"); 
  }
}
}

