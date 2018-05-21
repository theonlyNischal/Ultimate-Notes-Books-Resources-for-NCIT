import java.io.*;
import java.net.*;
class TCPServer1
{
	public static void main(String args[])throws Exception
	{
		String clientSentence,capitalizedSentence;
		
		ServerSocket welcomeSocket=new ServerSocket(6789);
		Socket connectionSocket;
				
		connectionSocket=welcomeSocket.accept();
		
BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
clientSentence=inFromClient.readLine();
System.out.println(clientSentence);






BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
capitalizedSentence=br.readLine();
DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());
outToClient.writeBytes(capitalizedSentence);
connectionSocket.close();
}


}







