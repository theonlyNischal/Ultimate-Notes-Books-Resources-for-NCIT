// Create a Graphic Application to display NCIT with font (Ariel), type Bold, size 20 whe a butto is clicked.

import java.awt.event.*;
import java.awt.Color;
import java.awt.*;

class ChangeFonts implements ActionListener {
    TextField t;
    Button b;
    Frame f;

    public ChangeFonts() {
        f = new Frame("Pradip Dhungana");
        f.setSize(300, 300);
        t = new TextField("Hello");
        t.setBounds(50, 50, 150, 20);
        b = new Button("Click");
        b.setBounds(50, 100, 60, 30);
        f.add(t);
        f.add(b);
        f.setLayout(null);
        f.setVisible(true);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Font font = new Font("Arial", Font.BOLD, 20);
        t.setFont(font);
        t.setText(t.getText());
        f.setBackground(Color.RED);
    }

    public static void main(String args[]) {
        new ChangeFonts();
    }
}