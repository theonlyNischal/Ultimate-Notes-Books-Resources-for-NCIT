import java.net.*;
import java.io.*;
public class UDPServer {

    public static void main(String[] args) {
        try{
            DatagramSocket server = new DatagramSocket(5000);
            System.out.println("Server is running at port 5000");
        
            while(true){
           
            /* recieve from the client */
            byte [] rxBuffer = new byte[1024];
            DatagramPacket rxPacket = new DatagramPacket(rxBuffer, rxBuffer.length);
            server.receive(rxPacket);

            String client_sends = new String(rxPacket.getData());
            System.out.println("Client says:- "+client_sends);
            
            /* prints out the client port and address */
            InetAddress client_add = rxPacket.getAddress();
            int client_port = rxPacket.getPort();
            
            String msg = "oh, hello myself SERVER";
            byte [] sendBuffer = msg.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,client_add, client_port);
            server.send(sendPacket);

           
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
