import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

public class HttpHeaders {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.facebook.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            Map<String, java.util.List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, java.util.List<String>> header : headers.entrySet()) {
                System.out.println(header.getKey() + ": " + header.getValue());
            }
        } catch (MalformedURLException e) {
            System.out.println("The URL is invalid.");
        } catch (IOException e) {
            System.out.println("An I/O error has occurred.");
        }
    }
}
