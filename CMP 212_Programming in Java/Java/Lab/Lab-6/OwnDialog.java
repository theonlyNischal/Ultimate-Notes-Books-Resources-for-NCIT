import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class OwnDialog extends JFrame implements ActionListener{
    JButton btn;

    public OwnDialog(){
        btn = new JButton("click");
        setSize(400, 500);
        //setLayout(null); no need to do as we have added BoxLayout there in class Dialog
        add(btn);
        btn.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        //adding own JPopupDialog Dialog with it's static function showMessageDialog with the same argumenst passed in the function.
        Dialog.showConfirmeDialog(this, "This is warning message !", "message-dialog");
    }
    public static void main(String [] args){
        new OwnDialog();
    }
}
class Dialog{
    //Static variable is the one that is common to all the instances of the class. 
    //A single copy of the variable is shared among all objects.
    
    static JDialog d;
    static JLabel l;
    static JButton btn_f, btn_s;

    public static boolean showConfirmeDialog(JFrame frame, String msg, String title){
        d = new JDialog(frame, title);
        l = new JLabel(msg);
        btn_f = new JButton("Ok");
        btn_s = new JButton("Cancel");
        d.setSize(200, 180);
        d.setLayout(new BoxLayout(d.getContentPane(),BoxLayout.Y_AXIS));
        btn_f.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn_s.setAlignmentX(Component.CENTER_ALIGNMENT);
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        d.add(Box.createRigidArea(new Dimension(0, 10)));
        d.add(l);
        d.add(Box.createRigidArea(new Dimension(0, 10)));
        d.add(btn_f);
        d.add(Box.createRigidArea(new Dimension(0, 10)));
        d.add(btn_s);
        d.setLocationRelativeTo(frame);
        d.setVisible(true);
        btn_f.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                  String ans = "true";
                  l.setText(ans);
                    
            }
        });
        btn_s.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String ans = "false";
            l.setText(ans);
        }
    });
    return true;
    }

}