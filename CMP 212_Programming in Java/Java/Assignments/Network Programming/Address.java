import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Collections;
public class Address {

    public static void main(String[] args) {
        
        try{
            System.out.println("a. the hostname and ip address of ncit’s webpage:- ");
            InetAddress add = InetAddress.getByName("www.ncit.edu.np");
            System.out.println("Host Name:- "+add.getHostName());
            System.out.println("IP Address:- "+add.getHostAddress());

            System.out.println("****************************************************");

            System.out.println("b. Name and address of my localhost:- ");
            InetAddress adds = InetAddress.getLocalHost();
            System.out.println("LocalHost Name:- "+adds.getHostName());
            System.out.println("LocalHost IP Address:- "+adds.getHostAddress());

            System.out.println("****************************************************");

            System.out.println("c. Print the loopback address:- ");
            byte [] b = {127, 0, 1, 1};
            InetAddress loopb = InetAddress.getByAddress(b);
            System.out.println("Is loopback address ? " + loopb.isLoopbackAddress());
            System.out.println("Loopback address:- "+InetAddress.getLoopbackAddress());

            System.out.println("****************************************************");

            System.out.println("d. Given that the ip address is 123.1.100.1, check if it is a loopback address, multicast address, global multicast address.");
            byte [] by = {123, 1, 100, 1};
            InetAddress check = InetAddress.getByAddress(by);
            System.out.println("Is loopback Address ?"+check.isLoopbackAddress());
            System.out.println("is multicast Address ?"+check.isMulticastAddress());
            System.out.println("Is global multi cast address ?"+check.isMCGlobal());

            System.out.println("****************************************************");
            System.out.println("e. Display name and addresses of all the network interfaces.");
            Enumeration<NetworkInterface>ifaces = NetworkInterface.getNetworkInterfaces();
            for(NetworkInterface iface : Collections.list(ifaces)){
                System.out.println("Display Name:- "+iface.getDisplayName());
                System.out.println("Name:- "+iface.getName());
            
            
            System.out.println("****************************************************");
            Enumeration <InetAddress> inets = iface.getInetAddresses();
            for(InetAddress inet : Collections.list(inets)){
                System.out.println("Address:- "+inet.getHostAddress());
            }
        }

        }catch(UnknownHostException e){
            System.out.println(e.getMessage());
        }catch(java.net.SocketException e){
            System.out.println(e.getMessage());
        }
    }
    
}
