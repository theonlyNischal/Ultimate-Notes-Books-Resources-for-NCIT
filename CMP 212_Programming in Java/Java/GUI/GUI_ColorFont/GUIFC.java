import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.awt.Frame;
// import java.awt.TextField;
// import java.awt.Button;
// import java.awt.Font;
// import java.awt.Color;

class GUIFC implements ActionListener{
    TextField t;
    Frame f;
    public GUIFC(){
        f=new Frame("Changing Font & Style");
        t=new TextField();
        Button b= new Button("Click me");
        f.setSize(500,500);
        t.setBounds(150, 100, 200, 50);
        b.setBounds(150,200,100,30);
        f.add(t);
        f.add(b);
        f.setLayout(null);
        f.setVisible(true);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        Font fo=new Font("Arial",Font.BOLD,15);
        t.setFont(fo);
        t.setText(t.getText());
        f.setBackground(Color.RED);
    }
    public static void main(String[] args){
        new GUIFC();
    }
}

