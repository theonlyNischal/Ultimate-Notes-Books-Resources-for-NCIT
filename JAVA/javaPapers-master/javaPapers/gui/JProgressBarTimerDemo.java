import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 class JProgressBarTimerDemo extends JFrame implements ActionListener
 {
 JProgressBar jp;
 Timer t;
 int i=0;
 public JProgressBarTimerDemo()
 {
 
 setTitle("JProgressBar Timer Demo");
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setLayout(new FlowLayout());

 setVisible(true);
 // Create a progress bar
 jp=new JProgressBar();
 // Start at 0
 jp.setMinimum(0);
 // End at 1000
 jp.setMaximum(1000);
  // Create a timer that executes for every 2 millisec
 t=new Timer(2,null);
 t.addActionListener(this);
 // Start the timer
 t.start();
 add(jp);
 pack();
 }
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==t){
   if(i==1000)
     t.stop();
   jp.setValue(i++);
  }
  }
 
 public static void main(String args[])
 {
 new JProgressBarTimerDemo();
 }
 }