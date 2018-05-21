import java.io.*;
import java.net.*;
class TCPServer
{
	public static void main(String args[])throws Exception
	{
		String clientSentence,capitalizedSentence;
		clientSentence="yes";
		ServerSocket welcomeSocket=new ServerSocket(6789);
		Socket connectionSocket;
		while(!clientSentence.equals("exit"))
		{
		
		connectionSocket=welcomeSocket.accept();
		
BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());

clientSentence=inFromClient.readLine();




System.out.println("From Client: "+clientSentence);

BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
capitalizedSentence=br.readLine();
outToClient.writeBytes(capitalizedSentence);
connectionSocket.close();
}


}



}



