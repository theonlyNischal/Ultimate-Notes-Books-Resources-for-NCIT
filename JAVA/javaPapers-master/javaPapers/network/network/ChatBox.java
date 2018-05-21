import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.net.*;

class ChatBox extends JFrame implements ActionListener
{
	JTextArea t1,t2;
	JButton b;
	

	ServerSocket welcomeSocket;
	Socket connectionSocket;
	public ChatBox()
	{
		super("Chat Box");
		t1=new JTextArea(20,30);
		t1.setEnabled(false);
		t2=new JTextArea(4,30);
		b=new JButton("Send");

		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(t1);
		c.add(t2);
		c.add(b);

		b.addActionListener(this);
		setVisible(true);
		setSize(400,465);
	}
	public void actionPerformed(ActionEvent e)
	{
		try{
		chatWithClient();}
		catch(Exception ex){System.out.println(ex);}
	}
	public static void main(String args[]) throws Exception
	{
		ChatBox cb=new ChatBox();
		cb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cb.runServer();
	}
	public void runServer()throws Exception
	{
		String clientSentence="yes";
		
		if(!clientSentence.equals("exit"))
		{
		welcomeSocket=new ServerSocket(6789);
		connectionSocket=welcomeSocket.accept();
		
		BufferedReader inFromClient=new BufferedReader(new InputStreamReader				(connectionSocket.getInputStream()));
		clientSentence=inFromClient.readLine();


		String s="";
		s=s+clientSentence;
		t1.setText("From Client: "+ clientSentence);	
		}
		else
		{
			connectionSocket.close();
		}
	}
	public void chatWithClient() throws Exception
	{

		String serverSentence;
		ServerSocket welcomeSocket=new ServerSocket(6789);
		Socket connectionSocket;
		connectionSocket=welcomeSocket.accept();
		
	DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());



		serverSentence=t2.getText();
		outToClient.writeBytes(serverSentence);
	}
}	