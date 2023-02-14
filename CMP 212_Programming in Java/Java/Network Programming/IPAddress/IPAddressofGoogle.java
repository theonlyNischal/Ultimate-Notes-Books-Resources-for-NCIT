
import java.net.InetAddress;


public class IPAddressofGoogle{
    public static void main(String [] args){

        try{

           

            /* Returns all the IP Addresses associated  with the given URL */
            System.out.println("IP Addressess associted with the URL are:- ");
            InetAddress [] ipaddress = InetAddress.getAllByName("www.google.com");

            // Loop 
            for(InetAddress address : ipaddress){
                System.out.println(address.getHostAddress());
            }



        }catch(java.net.UnknownHostException e){
            System.out.println(e.getMessage());
        }
    }
}