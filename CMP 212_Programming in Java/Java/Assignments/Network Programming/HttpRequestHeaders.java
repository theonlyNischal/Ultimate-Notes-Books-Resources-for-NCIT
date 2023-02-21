import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.List;
public class HttpRequestHeaders {

    public static void main(String[] args) {
        
        try{

            URL url = new URL("https://www.google.com");
              //casting to HttpURLConnection
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            Map<String,List<String>>headers = con.getHeaderFields();

            // Loop 
            for(Map.Entry<String, List<String>> h : headers.entrySet()){
                System.out.println(h.getKey() + "\n" + h.getValue());
            }
        }catch(java.io.IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
