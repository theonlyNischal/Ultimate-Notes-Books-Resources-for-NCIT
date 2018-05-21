import javax.swing.*;
public class SwingDemo {
    SwingDemo(){
        JFrame f1=new JFrame("alal");
        f1.setSize(200,200);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img=new ImageIcon("android.png");
        JLabel l1=new JLabel(img);
        f1.add(l1);
        
    }
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new SwingDemo();
            }
        });
        
  }
}
