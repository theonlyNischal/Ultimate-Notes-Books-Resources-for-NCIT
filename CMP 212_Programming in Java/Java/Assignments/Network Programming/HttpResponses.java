import java.net.URL;
import java.io.IOException;
import java.net.HttpURLConnection;
public class HttpResponses {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.google.com");
            // casting to HttpURLConnection
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            System.out.println("1. Response code:- "+con.getResponseCode());
            System.out.println("2. Response message:- "+con.getResponseMessage());
            System.out.println("3. Connection timeout:- "+con.getConnectTimeout());
            System.out.println("4. Encoding:- "+con.getContentEncoding());
            System.out.println("5. Length of content:- "+con.getContentLength());

            System.out.println("6. Request type:- "+con.getRequestMethod());
            System.out.println("7. Date:- "+con.getDate());

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
