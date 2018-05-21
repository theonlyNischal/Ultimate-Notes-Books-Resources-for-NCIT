import javax.swing.*;
import java.awt.event.*;

class OptionDialogDemo implements ActionListener
{
  JButton gender[];
  int response;
  OptionDialogDemo()
  {
    gender=new JButton[3];
    gender[0]=new JButton("Male");
    gender[1]=new JButton("Female");
    gender[2]=new JButton("none of your business");
    
    gender[0].addActionListener(this);
 gender[1].addActionListener(this);
  gender[2].addActionListener(this);
    
     JOptionPane.showOptionDialog(null,"What is your gender","Gender",0,JOptionPane.QUESTION_MESSAGE,null,gender,gender[0]);
   
  }
  public static void main(String args[])
  {
    new OptionDialogDemo();
  }
  public void actionPerformed(ActionEvent e)
  {
    /*
    if(e.getSource()==gender[0])
      System.out.println(0);
    if(e.getSource()==gender[1])
      System.out.println(1);
    if(e.getSource()==gender[2])
     System.out.println(2);*/
     
    System.out.println(response);
    
  }
}
    