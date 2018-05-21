/*URLConnection class represents a communication link
 between the URL and the application. 
This class can be used to read and write data to the 
specified resource referred by the URL.*/
//connecting to url and reading from it
import java.net.*;
import java.io.*;
class URLConnectionDemo{
  public static void main(String args[])throws MalformedURLException,IOException  {
    URL url=new URL("http://www.onlinekhabar.com");
    URLConnection urlcon=url.openConnection();
    InputStream in=urlcon.getInputStream();
    int i;
    while((i=in.read())!=-1)
      System.out.print((char)i);
  }
}
