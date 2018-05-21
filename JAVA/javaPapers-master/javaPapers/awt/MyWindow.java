import java.awt.*;

class MyWindow extends Frame
{
	MyWindow(String title)
	{
		super(title);
		setVisible(true);
		Dimension d=new Dimension(300,300);
		setSize(d);
	}
	public static void main(String args[])
	{
		new MyWindow("This is title");
	}
}