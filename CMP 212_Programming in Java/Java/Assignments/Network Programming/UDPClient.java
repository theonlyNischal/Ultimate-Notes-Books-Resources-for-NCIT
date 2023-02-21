import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.io.IOException;
import java.util.Scanner;
public class UDPClient {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            DatagramSocket client = new DatagramSocket();

            /* suppose that the server is running at 5000 */
            InetAddress add = InetAddress.getLocalHost();

            while(true){
            /* send  to the server */
            byte [] sendBuffer = null;
            System.out.println("Enter a string to send to the server:- ");
            String msg = sc.nextLine();
            if(msg.equalsIgnoreCase("bye")){
                System.out.println("Session terminated...");
                break;
            }
            sendBuffer = msg.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, add, 5000);
            client.send(sendPacket);

            /* receive from the server */
            byte [] rxBuffer = new byte[1024];
            DatagramPacket rxPacket = new DatagramPacket(rxBuffer, rxBuffer.length);
            client.receive(rxPacket);
            String server_replies = new String(rxPacket.getData());
            System.out.println("Server replies:- "+server_replies);

           
            }
            client.close();
           
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
