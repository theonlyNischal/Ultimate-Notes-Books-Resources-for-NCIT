import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyOwnDialogWithRadio extends JFrame implements ActionListener {
    
    JRadioButton se, it;

    public MyOwnDialogWithRadio(){
        se = new JRadioButton("SE", true);
        it = new JRadioButton("IT");
        setSize(300, 400);
        add(se);
        add(it);
        ButtonGroup bg = new ButtonGroup();
        bg.add(se);
        bg.add(it);
        se.addActionListener(this);
        it.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == se)
            JOptionPane.showMessageDialog(this, "You have selected the software field", "SE-III", JOptionPane.WARNING_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "You have selected an IT field", "IT-III", JOptionPane.ERROR_MESSAGE);
    }
    public static void main(String [] args){
        new MyOwnDialogWithRadio();
    }
}
class MyDialog{
    static JDialog d;
    static JLabel l;
    static JButton b;

    public static void showMessageDialog(JFrame frame, String msg, String title, int type_of_message){
        d = new JDialog(frame, title);
        l = new JLabel(msg);
        b = new JButton("ok");
        d.setSize(200, 100);
        d.setLayout(new BoxLayout(d.getContentPane(), BoxLayout.Y_AXIS));
        d.setVisible(true);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                d.setVisible(true);
            }
        });
    }
}