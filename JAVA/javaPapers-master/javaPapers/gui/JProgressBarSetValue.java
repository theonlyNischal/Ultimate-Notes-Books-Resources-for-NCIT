import java.awt.*;;
import java.awt.event.*;
import javax.swing.*;

public class JProgressBarSetValue extends JFrame implements ActionListener {
  JProgressBar bar = new JProgressBar();
  JButton step = new JButton("Step");

  public JProgressBarSetValue() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    step.addActionListener(this); 
      
    bar.setForeground(java.awt.Color.red);
    add(bar, BorderLayout.NORTH);
    add(step, BorderLayout.EAST);
    pack();
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
        int value = bar.getValue() + 7;
        if (value > bar.getMaximum()) {
          value = bar.getMaximum();
        }
        bar.setValue(value);
      }
    
  public static void main(String arg[]) {
    new JProgressBarSetValue();
  }
}
