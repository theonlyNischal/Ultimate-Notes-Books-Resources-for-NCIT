import java.awt.*;
import java.util.Calendar;
import javax.swing.*;

class AnalogWatch extends JFrame {
    private int hour;
    private int minute;
    private int second;
    
    public AnalogWatch() {
        Calendar calendar = Calendar.getInstance();
        this.hour = calendar.get(Calendar.HOUR);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        setTitle("Analog Watch");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void paint(Graphics g) {
        super.paint(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int clockRadius = Math.min(centerX, centerY)/2;
        
        g.setColor(Color.BLACK);
        g.drawOval(centerX - clockRadius, centerY - clockRadius, 2 * clockRadius, 2 * clockRadius);
        for (int i = 1; i <= 12; i++) {
            int x = (int)(centerX + (clockRadius - 15) * Math.sin(i * 2 * Math.PI / 12));
            int y = (int)(centerY - (clockRadius - 15) * Math.cos(i * 2 * Math.PI / 12));
            g.drawString(String.valueOf(i), x, y);
        }
        
        int hourHandLength = clockRadius / 2;
        int minuteHandLength = (int) Math.round(clockRadius / 1.5);
        int secondHandLength = clockRadius - 10;
        
        int hourX = (int)(centerX + hourHandLength * Math.sin((hour % 12 + minute / 60.0) * 2 * Math.PI / 12));
        int hourY = (int)(centerY - hourHandLength * Math.cos((hour % 12 + minute / 60.0) * 2 * Math.PI / 12));
        g.setColor(Color.RED);
        g.drawLine(centerX, centerY, hourX, hourY);
        
        int minuteX = (int)(centerX + minuteHandLength * Math.sin(minute * 2 * Math.PI / 60));
        int minuteY = (int)(centerY - minuteHandLength * Math.cos(minute * 2 * Math.PI / 60));
        g.setColor(Color.PINK);
        g.drawLine(centerX, centerY, minuteX, minuteY);
        
        int secondX = (int)(centerX + secondHandLength * Math.sin(second * 2 * Math.PI / 60));
        int secondY = (int)(centerY - secondHandLength * Math.cos(second * 2 * Math.PI / 60));
        g.setColor(Color.CYAN);
        g.drawLine(centerX, centerY, secondX, secondY);
    }
    
    public static void main(String[] args) {
        AnalogWatch watch = new AnalogWatch();
        watch.setVisible(true);
    }
}
    