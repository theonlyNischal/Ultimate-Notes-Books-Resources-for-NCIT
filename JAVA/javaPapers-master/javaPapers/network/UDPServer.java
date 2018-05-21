import java.io.*;
import java.net.*;
class UDPServer
{
  public static void main(String args[])throws Exception
  {
    
    DatagramSocket serverSocket=new DatagramSocket(9876);
    byte[] sendData=new byte[1024];
    byte[] receiveData=new byte[1024];
    
      DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
      serverSocket.receive(receivePacket);
      
      String s1=new String(receivePacket.getData());
      System.out.println("received: "+s1);
      
      InetAddress IpAddress=receivePacket.getAddress();
      int port=receivePacket.getPort();
      String s2=s1.toUpperCase();
      sendData=s2.getBytes();
      
    
      DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IpAddress,port);
      serverSocket.send(sendPacket);
      serverSocket.close();
      
  }
}