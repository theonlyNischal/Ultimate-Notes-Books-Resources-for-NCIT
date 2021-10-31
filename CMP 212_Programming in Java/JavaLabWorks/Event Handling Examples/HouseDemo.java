import java.awt.*;
import javax.swing.JFrame;

class HouseDemo extends Canvas
{
	public void paint(Graphics g)
	{
		// main bulding rectangle
		g.drawRect(100, 300, 400, 300);
		// windows
		g.drawRect(150, 350, 70, 70);
		g.drawRect(380, 350, 70, 70);
		// door
		g.drawRect(250, 430, 100, 170);

		// roof
		g.drawLine(300, 50, 100, 300);
		g.drawLine(300, 50, 500, 300);
		
		// coloring roof
		// g.setColor(Color.GREEN);
		// g.fillArc(100, 5, 300, 500, 225, 90);  

		// coloring building
		g.setColor(Color.RED);
		g.fillRect(100, 300, 400, 300);

		// coloring the window and door
		g.setColor(Color.WHITE);
		g.fillRect(150, 350, 70, 70);
		g.fillRect(380, 350, 70, 70);

		g.fillRect(250, 430, 100, 170);

		// color for the rims
		g.setColor(Color.BLACK);

		// window rims
		g.drawLine(160, 350, 160, 420);
		g.drawLine(180, 350, 180, 420);
		g.drawLine(200, 350, 200, 420);
		g.drawLine(400, 350, 400, 420);
		g.drawLine(420, 350, 420, 420);
		g.drawLine(440, 350, 440, 420);
	}	

	public static void main(String[] args) 
	{
		HouseDemo ob = new HouseDemo();

		JFrame f = new JFrame();

			f.add(ob);
			f.setSize(800, 800);
			f.setVisible(true);
	}
}