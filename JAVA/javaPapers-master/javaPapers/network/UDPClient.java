import java.io.*;
import java.net.*;
class UDPClient
{
  public static void main(String args[])throws Exception
  {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String sentence=br.readLine();
    
    DatagramSocket clientSocket=new DatagramSocket();
    InetAddress IpAddress=InetAddress.getByName("localhost");
    byte[] sendData=new byte[1024];
    byte[] receiveData=new byte[1024];
    
    
    sendData=sentence.getBytes();
    
    DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IpAddress,9876);
    clientSocket.send(sendPacket);
    
    DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
    clientSocket.receive(receivePacket);
    
    String s2=new String(receivePacket.getData());
    System.out.println("From server: "+s2);
    
    clientSocket.close();
  }
}