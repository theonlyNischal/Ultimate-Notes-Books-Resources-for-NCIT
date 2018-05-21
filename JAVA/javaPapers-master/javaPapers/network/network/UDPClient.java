import java.io.*;
import java.net.*;

class UDPClient
{
	public static void main(String args[])throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader		(System.in));
		DatagramSocket ds=new DatagramSocket();
	
		InetAddress IPAddress=InetAddress.getByName("localhost");
		byte[]sendData=new byte[1024];
		byte[]receiveData=new byte[1024];

		String s1=br.readLine();
		sendData=s1.getBytes();

		DatagramPacket dp_send=new DatagramPacket		(sendData,sendData.length,IPAddress,9876);
		ds.send(dp_send);

		DatagramPacket dp_receive=new DatagramPacket		(receiveData,receiveData.length);
		ds.receive(dp_receive);
		
		String s2=new String(dp_receive.getData());
		System.out.println("From server"+s2);
		
		ds.close();
	}
}