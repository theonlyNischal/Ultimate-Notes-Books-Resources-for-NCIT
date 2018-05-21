import java.awt.*;
import javax.swing.*;

class GroupLayoutDemo
{
  GroupLayoutDemo()
  {
    JFrame frame=new JFrame();
    JPanel p=new JPanel();
    GroupLayout grpLayout=new GroupLayout(p);
    p.setLayout(grpLayout);
    
 grpLayout.setAutoCreateGaps(true);      // specify automatic gap insertion  
 grpLayout.setAutoCreateContainerGaps(true); 

    
    JButton b1=new JButton("one");
    JButton b2=new JButton("two");
    
    JButton b3=new JButton("three");
    JButton b4=new JButton("four");
    
   GroupLayout.SequentialGroup horizontalSeqGrp = grpLayout.createSequentialGroup();  
   GroupLayout.SequentialGroup verticalSeqGrp = grpLayout.createSequentialGroup();  
   
 //create two parallel group for adding the components in the horizontal sequential group  
   GroupLayout.ParallelGroup hParallelGroup1 = grpLayout.createParallelGroup();  
   GroupLayout.ParallelGroup hParallelGroup2 = grpLayout.createParallelGroup();  
   
 //add the components  
   hParallelGroup1.addComponent(b1); 
   hParallelGroup1.addComponent(b3);
   
   hParallelGroup2.addComponent(b2);  
   hParallelGroup2.addComponent(b4);
  
 //add two parallel groups sequentially in the horizontal sequential group  
 horizontalSeqGrp.addGroup(hParallelGroup1);  
 horizontalSeqGrp.addGroup(hParallelGroup2);  
   
 //create one parallel group for adding the components in the vertical sequential group  
 GroupLayout.ParallelGroup vparallelGroup1 = grpLayout.createParallelGroup();  
 GroupLayout.ParallelGroup vparallelGroup2 = grpLayout.createParallelGroup();
  
 //add the components  
 vparallelGroup1.addComponent(b1);  
 vparallelGroup1.addComponent(b2);  
 
 vparallelGroup2.addComponent(b3);
 vparallelGroup2.addComponent(b4);
 
   
//add this parallel group in the vertical sequential group  
 verticalSeqGrp.addGroup(vparallelGroup1); 
 verticalSeqGrp.addGroup(vparallelGroup2);
  
 //finally set the both sequential group to the grpLayout object  
 grpLayout.setHorizontalGroup(horizontalSeqGrp);  
 grpLayout.setVerticalGroup(verticalSeqGrp);  

    frame.add(p);
    frame.setVisible(true);
    frame.setSize(300,200);
  }
  public static void main(String args[])
  {
    new GroupLayoutDemo();
  }
}