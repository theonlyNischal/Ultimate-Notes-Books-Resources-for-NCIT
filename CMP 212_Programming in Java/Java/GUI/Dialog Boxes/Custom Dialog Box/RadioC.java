import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Dialog{
    static JDialog jd;
    static JButton b;
    static JLabel l;
    public static void showDialog(JFrame f,String msg,String title){
        jd = new JDialog(f,title);
        jd.setSize(100,100);
        l = new JLabel(msg);
        b = new JButton("Ok");
        jd.setLayout(new BoxLayout(jd.getContentPane(),BoxLayout.Y_AXIS));
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        jd.add(l);
        jd.add(b);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            jd.setVisible(false);
        }
    });
    }
}
class RadioC extends Dialog implements ActionListener {
    JFrame f;
    JTextField text;
    JRadioButton eng,mgmt;
    public RadioC(){
        f = new JFrame();
        f.setSize(700,700);
        text = new JTextField();
        text.setColumns(20);
        eng = new JRadioButton("Engineering",true);
        mgmt = new JRadioButton("Management");
        f.add(text);
        f.add(eng);
        f.add(mgmt);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        ButtonGroup btgrp = new ButtonGroup();
        btgrp.add(eng);
        btgrp.add(mgmt);
        eng.addActionListener(this);
        mgmt.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        String title = this.text.getText();
        if(e.getSource()==eng){
            showDialog(this.f,"You Choose Engineering",title);
        }
        else{
            showDialog(this.f,"You Choose Management",title);
        }
    }
    public static void main(String []args){
        new RadioC();
    }
}
