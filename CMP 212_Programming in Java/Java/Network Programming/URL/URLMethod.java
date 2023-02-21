import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLMethod {

    public static void main(String[] args) {
        
        try{

            URL url = new URL("https://github.com/dhunganaPradeep?tab=repositories&type=source");
            
            System.out.println("1. Protocol:- "+url.getProtocol());
            System.out.println("2. Host/Domain:- "+url.getHost());
            System.out.println("3. Host Authority:- "+url.getAuthority());
            System.out.println("4. Port:- "+url.getPort());
            System.out.println("5. Default Port:- "+url.getDefaultPort());
            System.out.println("6. Path:- "+url.getPath());
            System.out.println("7. File:- "+url.getFile());
            System.out.println("8. Reference/Anchor:- "+url.getRef());
            System.out.println("9. Query String:- "+url.getQuery());
            System.out.println("10. URI:- "+url.toURI());

        }catch(MalformedURLException e){
            System.out.println(e.getMessage());
            // toURI() throws the URISyntaxException
        }catch(URISyntaxException e){
            System.out.println(e.getMessage());
        }
    }
    
}
