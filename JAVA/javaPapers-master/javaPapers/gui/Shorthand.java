import java.awt.*;
import javax.swing.*;
public class Shorthand  {
public Shorthand () {
JFrame frame=new JFrame();
frame.setLayout(new GridBagLayout());
GridBagConstraints c = new GridBagConstraints();
c.fill = GridBagConstraints.BOTH;
c.weightx = 1;
frame.add(new JButton("1"), c);
frame.add(new JButton("2"), c);
frame.add(new JButton("3"), c);
frame.add(new JButton("4"), c);
c.gridwidth = GridBagConstraints.REMAINDER;
frame.add(new JButton("5"), c);
c.gridwidth = 1;
c.weightx = 0;
frame.add(new JButton("A"), c);
frame.add(new JButton("B"), c);

frame.add(new JButton("C"), c);
c.gridwidth = GridBagConstraints.REMAINDER;
frame.add(new JButton("D"), c);
c.gridwidth = 1;
frame.add(new JButton("a"), c);
c.gridwidth = GridBagConstraints.RELATIVE;
frame.add(new JButton("b"), c);
c.gridwidth = GridBagConstraints.REMAINDER;
frame.add(new JButton("c"), c);
c.gridwidth = 1;
frame.setVisible(true);
frame.setSize(300,150);
}
public static void main(String args[]) {
new Shorthand();

}
}