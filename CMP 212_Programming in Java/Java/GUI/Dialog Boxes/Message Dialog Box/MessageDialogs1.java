
// Java program to show ERROR_MESSAGE dialog

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MessageDialogs1 extends JFrame implements ActionListener
{
   
    JButton b1;
    MessageDialogs1()
    {
        this.setLayout(null);
        b1 = new JButton("Button 1");
        b1.setBounds(130, 05, 100, 50);
        this.add(b1);
        b1.addActionListener(this);
        f.setVisible(true);
    }
 
    // Override Method
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b1)
        {
            // Code To popup an ERROR_MESSAGE Dialog.
            JOptionPane.showMessageDialog(this, "Enter a valid Number",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String args[])
    {
        MessageDialogs1 f = new MessageDialogs1();   
    }
}
