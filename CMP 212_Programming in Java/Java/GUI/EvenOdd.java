
import javax.swing.*;
import java.awt.event.*;

class EvenOdd extends JFrame implements ActionListener{
    JTextField t,t2;
    //JLabel l;
    public EvenOdd(){
        setTitle("GUI Example");
        setSize(500,500);
        JButton b=new JButton("Click me");
        t=new JTextField();
        t2=new JTextField();
        //l=new JLabel();
        t.setBounds(150,100,200,60);
        t2.setBounds(175,250,150,40);
        //l.setBounds(200,250,150,40);
        b.setBounds(200,320,100,20);
        add(t);
        add(t2);
        //add(l);
        add(b);
        setLayout(null);
        setVisible(true);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        int num=Integer.parseInt(t.getText());
        if(num%2==0)
            t2.setText("Even Number!");
        else
            t2.setText("Odd Number!");
    }
    public static void main(String [] args){
        new EvenOdd();
    }
}
