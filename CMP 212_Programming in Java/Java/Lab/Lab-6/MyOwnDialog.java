import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class MyOwnDialog extends JFrame implements ActionListener{
    JButton btn;

    public MyOwnDialog(){
        btn = new JButton("click");
        setSize(400, 500);
        //setLayout(null); no need to do as we have added BoxLayout there in class MyDialog
        add(btn);
        btn.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        //adding own JPopupDialog MyDialog with it's static function showMessageDialog with the same argumenst passed in the function.
        MyDialog.showMessageDialog(this, "This is warning message !", "message-dialog", JOptionPane.WARNING_MESSAGE);
    }
    public static void main(String [] args){
        new MyOwnDialog();
    }
}
class MyDialog{
    //Static variable is the one that is common to all the instances of the class. 
    //A single copy of the variable is shared among all objects.
    static JDialog d;
    static JLabel l;
    static JButton b;

    public static void showMessageDialog(JFrame frame, String msg, String title, int type_of_message){
        d = new JDialog(frame, title);
        l = new JLabel(msg);
        b = new JButton("ok");
        d.setSize(200, 120);
        d.setLayout(new BoxLayout(d.getContentPane(),BoxLayout.Y_AXIS));
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        d.add(Box.createRigidArea(new Dimension(0, 10)));
        d.add(l);
        d.add(Box.createRigidArea(new Dimension(0, 10)));
        d.add(b);
        d.setLocationRelativeTo(frame);
        d.setVisible(true);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                d.setVisible(false);
            }
        });
    }
}