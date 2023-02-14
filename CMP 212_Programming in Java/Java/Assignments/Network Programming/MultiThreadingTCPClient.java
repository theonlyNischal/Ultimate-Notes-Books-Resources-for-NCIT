import java.net.*;
import java.io.*;
import java.util.Scanner;
class MultiThreadingTCPClient{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            Socket socket = new Socket("localhost",5000);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            while(true){

                System.out.println("Enter a string to send to the server:- ");
                String input = sc.nextLine();
                dos.writeUTF(input);

                if(input.equalsIgnoreCase("bye")){
                    break;
                }
                /* recieving from the server */
                String server_sends = dis.readUTF();
                System.out.println("Server sends:- "+server_sends);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}