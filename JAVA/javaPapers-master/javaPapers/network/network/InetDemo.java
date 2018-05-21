import java.net.*;
class InetDemo
{
	public static void main(String args[])throws UnknownHostException
	{
		InetAddress Ip=InetAddress.getLocalHost();
		System.out.println(Ip);

		
		System.out.println(Ip.getHostName());
		System.out.println(Ip.getHostAddress());

		//byte[] ss=Ip.getAddress();
		//System.out.println(ss);
	}
}