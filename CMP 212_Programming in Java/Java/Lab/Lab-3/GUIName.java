import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class GUIName implements ActionListener{
    TextField t;
    public GUIName(){
        Frame f=new Frame("Display Box");
        t=new TextField();
        Button b= new Button("Click Me");
        f.setSize(500,500);
        t.setBounds(150,100,100,50);
        b.setBounds(150, 200, 75, 40);;
        f.add(t);
        f.add(b);
        f.setVisible(true);
        f.setLayout(null);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        t.setText("Kamal");
    }
    public static void main(String[] args){
        new GUIName();
    }
}
