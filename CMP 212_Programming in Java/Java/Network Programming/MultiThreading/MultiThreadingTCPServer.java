import java.net.*;
import java.io.*;
class ClientHandler extends Thread{
    private Socket socket;
    public ClientHandler(Socket socket){
        this.socket = socket;
    }
    public void run(){

        try{

            System.out.println("Client is accepted at port: "+socket.getPort());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            while(true){
                String client_sends = dis.readUTF();
                String rev = "";
                System.out.println("Client says:- "+client_sends);
                for(int i=client_sends.length()-1;i>=0;i--){
                    rev = rev + client_sends.charAt(i);
                }
                System.out.println("Reverse of the string is:- "+rev);

                if(client_sends.equals(rev)){
                    dos.writeUTF("PALINDROME");
                }else{
                    dos.writeUTF("NOT A PALINDROME");
                }
            }    
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
class MultiThreadingTCPServer{
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("server is running at 5000");

            while(true){
            Socket socket = ss.accept();
            ClientHandler client_handler = new ClientHandler(socket);
            client_handler.start();
            }  
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
} 