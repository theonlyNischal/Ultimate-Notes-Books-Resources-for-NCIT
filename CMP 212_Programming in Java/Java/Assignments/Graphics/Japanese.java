import javax.swing.*;
import java.awt.*;

public class Japanese extends JFrame {
        public Japanese(){
            setSize(500,500);
            setVisible(true);
        }
        public void paint(Graphics g){

            // For Rectangular Portion 

            g.setColor(Color.white);           
            g.fillRect(100,100,400,200);

             // For Circle Portion in the middle of the flag

            g.setColor(Color.red);
            g.fillOval(250,150,100,100);
        }
        public static void main(String []args){
            new Japanese();
        }
}
