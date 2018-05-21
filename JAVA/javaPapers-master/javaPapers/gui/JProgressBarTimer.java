import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 class JProgressBarTimer extends JFrame
 {
 JProgressBar jp;
 Timer t;
 int i=0;
 public JProgressBarTimer()
 {
 try
 {
 UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
 }catch(Exception e){}
 setTitle("JProgressBar Timer Demo");
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setLayout(new GridBagLayout());
 setLocationRelativeTo(null);
 setVisible(true);
 // Create a progress bar
 jp=new JProgressBar();
 // Paint the percent complete on progress bar
 jp.setStringPainted(true);
 // Set a size (optional)
 jp.setPreferredSize(new Dimension(500,30));
 // Start at 0
 jp.setMinimum(0);
 // End at 1000
 jp.setMaximum(1000);
  // Create a timer that executes for every 2 millisec
 t=new Timer(2,new ActionListener(){
  public void actionPerformed(ActionEvent ae)
  {
   if(i==1000)
   i=0;
   jp.setValue(i++);
  }
 });
 // Start the timer
 t.start();
 add(jp);
 pack();
 }
 public static void main(String args[])
 {
 new JProgressBarTimer();
 }
 }