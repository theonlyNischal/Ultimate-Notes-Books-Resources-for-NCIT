import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class Client {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        try{

            Socket socket = new Socket("localhost", 5000);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while(true){
                /* send to the server */
                System.out.println("Enter a message to send to the Server:- ");
                String msg = sc.nextLine();
                dos.writeUTF(msg);
                
                if(msg.equalsIgnoreCase("bye")){
                    break;
                }

                /* recieve from the server */
                String reply = dis.readUTF();
                System.out.println("Server replies:- "+reply);

            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
