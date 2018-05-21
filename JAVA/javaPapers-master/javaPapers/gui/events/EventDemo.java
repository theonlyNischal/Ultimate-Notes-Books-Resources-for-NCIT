import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class EventDemo
{
  EventDemo()
  {
    JFrame frame=new JFrame();
    frame.setLayout(new FlowLayout());
    
    String []flowers={"rose","lotus","lily","poppy"};
   JComboBox<String> cmb=new JComboBox<String>(flowers);
   frame.add(cmb);
   
   JLabel l1=new JLabel("Status");
   frame.add(l1);
   
   cmb.addItemListener(new ItemListener(){
     public void itemStateChanged(ItemEvent e)
     {
       String item=cmb.getSelectedItem().toString();
       l1.setText(item);
     }});
   
   
   frame.setVisible(true);
   frame.pack();
  }
  public static void main(String args[])
  {
    new EventDemo();
  }
}