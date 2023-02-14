import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

class Digital extends JFrame{
    JLabel label;
    public Digital(){
        setSize(500,400);
        label = new JLabel();
        add(label);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void showTime(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("hh:mm:ss");
        while(true){
            String time = f.format(cal.getTime());
            label.setText(time);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void main(String []args){
        Digital d = new Digital();
        d.showTime();
    }
}