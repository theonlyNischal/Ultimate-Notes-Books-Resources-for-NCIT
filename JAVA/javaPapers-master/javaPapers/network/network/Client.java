import java.io.*;
import java.net.*;

public class Client
{
	public static void main(String args[])throws Exception
	{
		Client myCli=new Client();
		myCli.run();
	}
	public void run()throws Exception
	{
		Socket mySkt=new Socket("localhost",9999);
		PrintStream myPS=new PrintStream(mySkt.getOutputStream());
		myPS.println("Hello server");
	}
}
