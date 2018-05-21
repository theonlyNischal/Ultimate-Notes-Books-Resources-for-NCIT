import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Server extends JFrame
{
	private JTextField enterField;
	private JTextArea displayArea;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	private int counter=1;

	public Server()
	{
		super("server");
		Container c=getContentPane();
		enterField=new JTextField();
		enterField.setEditable(false);
		enterField.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					sendData(event.getActionCommand());
					enterField.setText("");
				}
			}
		);
		c.add(enterField,BorderLayout.NORTH);
		displayArea=new JTextArea();
		c.add(new JScrollPane(displayArea),BorderLayout.CENTER);
	
		setSize(300,150);
		setVisible(true);
	}
	
	public void runServer()
	{
		try
		{
			server=new ServerSocket(12345,100);
			while(true)
			{
				try
				{
					waitForConnection();
					getStreams();
					processConnection();
				}
				catch(EOFException e)
				{
					System.err.println("Server terminated connection");
				}
				finally
				{
					closeConnection();
					++counter;
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	private void waitForConnection()throws IOException
	{
		displayMessage("Waiting for connection\n");
		connection=server.accept();
		displayMessage("connection "+counter+" received from: "+connection.getInetAddress().getHostName());
	}
	private void getStreams()throws IOException
	{
		output=new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input=new ObjectInputStream(connection.getInputStream());
		displayMessage("\nGot I/O streams\n");
	}
	private void processConnection() throws IOException
	{
		String message="Connection successful";
		sendData(message);
		
		setTextFieldEditable(true);
		
		do
		{
			try
			{
				message=(String)input.readObject();
				displayMessage("\n"+message);
			}
			catch(ClassNotFoundException e)
			{
				displayMessage("\nUnknown object type received");
			}
		}while(!message.equals("CLIENT>>>TERMINATE"));
	}
	private void closeConnection()
	{
		displayMessage("\nTerminating connection\n");
		setTextFieldEditable(false);
		try
		{
			output.close();
			input.close();
			connection.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	private void sendData(String message)
	{
		try
		{
			output.writeObject("SERVER>> "+message);
			output.flush();
			displayMessage("\nSERVER>>> "+message);
		}
		catch(IOException e)
		{
			displayArea.append("\nError writing object");
		}
	}
	private void displayMessage(final String messageToDisplay)
	{
		SwingUtilities.invokeLater(
		new Runnable()
		{
			public void run()
			{
				displayArea.append(messageToDisplay);
				displayArea.setCaretPosition(displayArea.getText().length());
			}
		});
	}
	private void setTextFieldEditable(final boolean editable)
	{
		SwingUtilities.invokeLater(
		new Runnable()
		{
			public void run()
			{
				enterField.setEditable(editable);
			}
		});
	}
	public static void main(String args[])
	{
		Server app=new Server();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.runServer();
	}
}
		
			
		
	
			
