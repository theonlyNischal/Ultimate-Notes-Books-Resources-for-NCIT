import java.net.URLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.io.InputStream;
public class URLConnectionClass {

    public static void main(String [] args){

        try{

            URL url = new URL("https://google.com");
            URLConnection con = url.openConnection();

             // InputStream reads the string of the specified URL
            InputStream is = con.getInputStream();
            // to write the data in a file
            FileOutputStream fos = new FileOutputStream("index.html");
            int data;

            while((data = is.read()) != -1){
                System.out.print((char)data);
                fos.write(data);
            }
            fos.close();
            is.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
