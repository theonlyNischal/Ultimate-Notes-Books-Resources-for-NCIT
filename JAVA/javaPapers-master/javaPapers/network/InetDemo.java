/*InetAddress
InetAddress is a class used to encapsulate both 
numerical IP address and domain name for that address.
It can handle both IPv4 and IPv6 addresses.
*/

import java.net.*;
class InetDemo
{
  public static void main(String args[])throws UnknownHostException
  {
    InetAddress Ip=InetAddress.getLocalHost();
    System.out.println(Ip);
    
    System.out.println(Ip.getHostName());
    System.out.println(Ip.getHostAddress());
  }
}