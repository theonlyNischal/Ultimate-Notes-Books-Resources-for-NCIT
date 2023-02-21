import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class CreateImage {
    public static void main(String []args) throws IOException {
        BufferedImage img = new BufferedImage(200, 250, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.createGraphics();
        g.setColor(Color.cyan);
        g.drawString("WELCOME PRADIP", 50, 20);
        g.dispose();//It releases all system resources
        File jpgFile = new File("mydrawing.jpg");
        ImageIO.write(img, "jpg", jpgFile);

        File pngFile = new File("mydrawing.png");
        ImageIO.write(img, "png", pngFile);
    }
}


