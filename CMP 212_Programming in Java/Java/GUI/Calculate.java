// Create a Swing GUI that contains two buttons add & subtract and three text fields when the buttons are clicked sum or difference of values of first two text field should be displayed in a third text field

import java.awt.event.*;
import javax.swing.*;

class Calculate extends JFrame implements ActionListener {
    JTextField first, sec, result;
    JButton sum, sub;
    public Calculate(){
        setSize(800,1000);
        first = new JTextField();
        sec = new JTextField();
        result = new JTextField();
        sum = new JButton("Add");
        sub = new JButton("Subtract");
        first.setBounds(50,50,100,30);
        sec.setBounds(50,100,100,30);
        result.setBounds(50,200,100,30);
        sum.setBounds(50,250,100,30);
        sub.setBounds(50,300,100,30);
        add(first);
        add(sec);
        add(result);
        add(sum);
        add(sub);
        setLayout(null);
        setVisible(true);
        sum.addActionListener(this);
        sub.addActionListener(this);
        first.addActionListener(this);
        sec.addActionListener(this);
        result.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        int a = Integer.parseInt(first.getText());
        int b = Integer.parseInt(sec.getText());
        if(e.getSource()==sum){
          int ans = a+b;
          result.setText(" "+ans);
        }
        else{
            int ans = a-b;
            result.setText(" "+ans);
        }
    }
    public static void main(String args[]) {
        new Calculate();
    }
}