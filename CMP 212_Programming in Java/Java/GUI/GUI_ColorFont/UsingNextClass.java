import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class GUIFC{
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
        UsingNextClass u=new UsingNextClass(this);
        b.addActionListener(u);
    }
}
class UsingNextClass implements ActionListener{
    GUIFC gui;
    public UsingNextClass(GUIFC gui){
        this.gui=gui;
    }
    public void actionPerformed(ActionEvent e){
        Font fo=new Font("Arial",Font.BOLD,15);
        this.gui.t.setFont(fo);
        this.gui.t.setText(gui.t.getText());
        this.gui.f.setBackground(Color.RED);
    }
    public static void main(String[] args){
        new GUIFC();
    }
}


