import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Dialogs implements ActionListener
{
  JButton b1,b2;
  JTextField t1;
  
  Dialogs()
  {
    JFrame frame=new JFrame();
    frame.setLayout(new FlowLayout());
    
     b1=new JButton("sum");
    frame.add(b1);
    
     t1=new JTextField(10);
    frame.add(t1);
    
    b2=new JButton("delete");
    frame.add(b2);
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    
    frame.setVisible(true);
    frame.setSize(200,200);
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==b1)
    {
      int a=Integer.parseInt(JOptionPane.showInputDialog("enter a number"));
      int b=Integer.parseInt(JOptionPane.showInputDialog("enter a number"));
      int c=a+b;
      JOptionPane.showMessageDialog(null,c);
    }
    if(e.getSource()==b2)
    {
      int a=JOptionPane.showConfirmDialog(null,"Are u sure?","Warning",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
      System.out.println(a);
      
      
    }
  }
  public static void main(String args[])
  {
    new Dialogs();
  }
}
    
    