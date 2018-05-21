import java.io.*;
import java.net.*;

class UDPServer
{
	public static void main(String args[])throws Exception
	{
		
		DatagramSocket serverSocket=new DatagramSocket(9876);
		
		byte[]sendData=new byte[1024];
		byte[]receiveData=new byte[1024];


		

			DatagramPacket dp_receive=new DatagramPacket(receiveData,receiveData.length);
			serverSocket.receive(dp_receive);
			String s2="";
			 s2=new String(dp_receive.getData());
			System.out.println("From client"+s2);
		
			InetAddress IPAddress=dp_receive.getAddress();
			int port=dp_receive.getPort();
		
			String s1=s2.toUpperCase();
			sendData=s1.getBytes();

		DatagramPacket dp_send=new DatagramPacket(sendData,sendData.length,IPAddress,port);
		serverSocket.send(dp_send);

		
		serverSocket.close();
		
		
	}
}