import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

class SumandSubs extends JFrame {
    JButton sum, subs;
    JTextField tf, ts, res;

    public SumandSubs() {
        sum = new JButton("+");
        subs = new JButton("-");
        setTitle("addition-substraction");
        setSize(400, 500);
        sum.setBounds(30, 280, 100, 50);
        subs.setBounds(260, 280, 100, 50);
        add(sum);
        add(subs);
        tf = new JTextField();
        ts = new JTextField();
        res = new JTextField();
        tf.setBounds(100, 150, 170, 50);
        ts.setBounds(100, 180, 170, 50);
        res.setBounds(100, 210, 170, 50);
        add(tf);
        add(ts);
        add(res);
        Controller c = new Controller(this);
        sum.addActionListener(c);
        subs.addActionListener(c);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    class Controller implements ActionListener {
        SumandSubs con;

        public Controller(SumandSubs con) {
            this.con = con;
        }

        public void actionPerformed(ActionEvent e) {
            int a = Integer.parseInt(tf.getText());
            int b = Integer.parseInt(ts.getText());
            Object source = e.getSource();
            if (source == con.sum) {
                int ans = a + b;
                con.res.setForeground(Color.RED);
                con.res.setText("" + ans);
            } else {
                int ans = a - b;
                con.res.setForeground(Color.BLUE);
                con.res.setText("" + ans);
            }
        }
    }

    public static void main(String[] args) {
        new SumandSubs();
    }

}