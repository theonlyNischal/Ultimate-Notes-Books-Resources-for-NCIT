import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SetBackgroundColor extends JFrame implements ActionListener {
    JButton cyan, magenta, yellow;

    public SetBackgroundColor() {
        cyan = new JButton("CYAN");
        magenta = new JButton("MAGENTA");
        yellow = new JButton("YELLOW");
        setTitle("Set the Background-Color");
        setSize(400, 500);
        cyan.setBounds(100, 150, 170, 50);
        magenta.setBounds(100, 200, 170, 50);
        yellow.setBounds(100, 250, 170, 50);
        add(cyan);
        add(magenta);
        add(yellow);
        cyan.addActionListener(this);
        magenta.addActionListener(this);
        yellow.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if (s == cyan)
            getContentPane().setBackground(Color.CYAN);
        else if (s == magenta)
            getContentPane().setBackground(Color.MAGENTA);
        else
            getContentPane().setBackground(Color.YELLOW);
    }

    public static void main(String[] args) {
        new SetBackgroundColor();
    }

}
