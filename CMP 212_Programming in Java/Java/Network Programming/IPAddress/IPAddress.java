package Practice.IPAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddress {
    public static void main(String[] args) {
        try {
            InetAddress[] addresses = InetAddress.getAllByName("dhunganapradip.com.np");
            for (InetAddress address : addresses) {
                System.out.println(address.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.out.println("The host could not be resolved.");
        }
    }
}
