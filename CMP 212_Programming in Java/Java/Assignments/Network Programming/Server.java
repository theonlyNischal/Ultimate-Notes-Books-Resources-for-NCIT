import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

class Server{
    public static void main(String [] args){
        try{
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server is running at 5000");
            Socket socket = ss.accept();
            System.out.println("Client is accpeted at port "+socket.getPort());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            while(true){
                /* receives from the server */
                String msg = dis.readUTF();
                System.out.println("client says:- "+msg);

                /* send to the server */
                String send = "oh, hello, i'm server...";
                dos.writeUTF(send);
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}