import java.net.*;
class URLDemo
{
	public static void main(String args[])throws Exception
	{
		URL hp=new URL("http://www.hotmail.com:80/downloads");
		System.out.println("Protocol: "+hp.getProtocol());
		System.out.println("Port: "+hp.getPort());
		System.out.println("Host: "+hp.getHost());
		System.out.println("File: "+hp.getFile());
		System.out.println("Ext: "+hp.toExternalForm());


		InetAddress Ip=InetAddress.getLocalHost();
		System.out.println(Ip);

		
		System.out.println(Ip.getHostName());
		System.out.println(Ip.getHostAddress());
	}
}