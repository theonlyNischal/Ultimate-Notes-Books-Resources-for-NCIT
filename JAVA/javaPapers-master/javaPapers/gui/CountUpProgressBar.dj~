import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

class CountUpProgressBar extends JPanel {

    private JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
    private JLabel label = new JLabel("", JLabel.CENTER);
    private Timer timer = new Timer(100, new ActionListener() {

        private int counter = 1;

        @Override
        public void actionPerformed(ActionEvent ae) {
            label.setText(String.valueOf(counter));
            bar.setValue(++counter);
            if (counter > 100) {
                timer.stop();
            }
        }
    });

    CountUpProgressBar() {
        super.setLayout(new GridLayout(0, 1));
        bar.setValue(0);
        timer.start();
        this.add(bar);
        this.add(label);
        JOptionPane.showMessageDialog(null, this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                CountUpProgressBar cdpb = new CountUpProgressBar();
            }
        });
    }
}