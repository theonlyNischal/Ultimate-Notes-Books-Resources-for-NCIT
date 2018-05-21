import javax.swing.*;
import java.awt.*;

class GridBagDemo2
{
  GridBagDemo2()
  {
    JFrame frame=new JFrame();
    GridBagLayout g1= new GridBagLayout();
    frame.setLayout(g1);
    
    GridBagConstraints gbc=new GridBagConstraints();
    
    JLabel l1=new JLabel("Id");
    gbc.gridx=0;
    gbc.gridy=0;
    g1.setConstraints(l1,gbc);
    frame.add(l1);
    
    
    JTextField t1=new JTextField(10);
    gbc.gridx=2;
    gbc.gridy=0;
   // gbc.gridwidth=3;
    //gbc.fill=GridBagConstraints.HORIZONTAL;
    g1.setConstraints(t1,gbc);
    frame.add(t1);
    
    
     JLabel l2=new JLabel("Name");
    gbc.gridx=0;
    gbc.gridy=1;
    g1.setConstraints(l2,gbc);
    frame.add(l2);
    
    
    JTextField t2=new JTextField(20);
    gbc.gridx=1;
    gbc.gridy=1;
    gbc.gridwidth=2;
    gbc.gridheight=2;
    gbc.fill=GridBagConstraints.BOTH;
    g1.setConstraints(t2,gbc);
    frame.add(t2);
    
    JLabel l3=new JLabel("Address");
    gbc.gridx=0;
    gbc.gridy=3;
    g1.setConstraints(l3,gbc);
    frame.add(l3);
    
    
    frame.setVisible(true);
    frame.setSize(300,300);
  }
  public static void main(String args[])
  {
    new GridBagDemo2();
  }
}
      