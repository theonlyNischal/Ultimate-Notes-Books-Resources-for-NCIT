import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class MouseListenerExam extends JFrame implements MouseListener, MouseMotionListener {
    JTextField tf, ts;

    public MouseListenerExam() {
        tf = new JTextField();
        ts = new JTextField();
        setTitle("IN-OUT and X,Y Cord of the Frame");
        setSize(400, 500);
        tf.setBounds(100, 150, 170, 50);
        ts.setBounds(100, 200, 170, 50);
        add(tf);
        add(ts);
        addMouseListener(this);
        addMouseMotionListener(this);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mouseEntered(MouseEvent e) {
        Font font = new Font("Arial", Font.BOLD, 14);
        tf.setFont(font);
        tf.setText("IN!");
    }

    public void mouseExited(MouseEvent e) {
        Font font = new Font("Arial", Font.BOLD, 14);
        tf.setFont(font);
        tf.setText("OUT !");
    }

    public void mouseMoved(MouseEvent e) {
        String cord = "X :- " + e.getX() + "Y :- " + e.getY();
        Font font = new Font("Times New Roman", Font.ITALIC, 20);
        ts.setFont(font);
        ts.setText(cord);
    }

    public static void main(String[] args) {
        new MouseListenerExam();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

}
