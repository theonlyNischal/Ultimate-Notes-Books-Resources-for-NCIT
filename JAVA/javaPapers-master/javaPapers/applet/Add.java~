import java.awt.*;
import java.awt.event.*;
import java.applet.*;

class Add extends Applet implements ActionListener
{
  TextField t1,t2,t3;
  Label l1,l2,l3;
  Button b1;
  public void init()
  {
    t1=new TextField(10);
    t2=new TextField(10);
    t3=new TextField(10);
    l1=new Label("First Num");
    l2=new Label("Second Num");
    l3=new Label("Result");
    b1=new Button("Add");
    
    add(l1);
    add(t1);
    add(l2);
    add(t2);
    add(l3);
    add(t3);
    add(b1);
    
    b1.addActionListener(this);
    
  }
  public void actionPerformed(ActionEvent e)
  {
    int num1=Integer.parseInt(t1.getText());
    int num2=Integer.parseInt(t2.getText());
    int num3=num1+num2;
    t3.setText(String.valueOf(num3));
    
  }
}
    