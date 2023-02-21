# Java Assignment: Network Programming 

# Question

![CHEESE!](Network.png)

# Question no.1:- Define Port, Socket, IP Address and URL.

Answer:-

   **Port :-**

   - Port is a logical construct.
      
   - Port is a number assigned to a processor running on a server
      
   - It is a 16-bit number unsigned integer range from (0-65535).

            From (0-1023), known as "system port or widely known port"

            From (1024-49159), known as "Reserved Port"

            Remaining ports(49159-65535), known as the "dynamic port or client port" used by client while connecting to server.

   - Only one application can run in a single port in a server.
      
   - Ports are used in transport layers.
      
   - Example: HTTPS:80, HTTP:443, FTP:20.

  **Socket :-**

   - Combination o fIP address and Port number is called the Socket.

   - Socket is the end point for the communication.

   - Different types of the Socket are : 

            a. TCP Socket

            b. Datagram Socket

            c. Raw Socket Interface
      
   - It works as an interface between an Application layer and Transport Layer.

   **IP Addresses :-** 

   - An IP Address is an address having information about how to reach a specific host which is a 32-bit unique address number having an address space of 2 ^ 32.
    
   - InetAddress is a class that allows us to work with the IP Addresses belongs to java.net package.

   - InetAddress is the base class of both Inet4Address(IPv4) and Inet6Address(IPv6)

   - Some of the methods present in InetAddress class are:- 

      a. public static InetAddress getByName(String host) throws UnknownHostException:-

         - It returns the instances of the InetAddress class containing the LocalHost IP and Name

      b. public static InetAddress getByAddress(byte IPAdress[]) throws UnknownHostException:-
            
         - It returns the instance of the InetAddress class created from the raw IP Address.

      c. public static InetAddress getLocalHost() throws UnknownHostException

         - It returns the instances of the InetAddress class containing the localhost name and address

      d. public static InetAddress[] getAllByName(String hostName) throws UnknownHostException

         - It returns the array of the instances of the InetAddress class which contains the IP Addresses.


Example program:- "[InetDemo.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/InetDemo.java)"

      Output :
               Host Name: www.dhunganapradip.com.np
               IP Address: 172.67.196.125

**URL :-** 

   - It is a class that is used to represent URL
    
   - It is a package of java.net.

   - A URL is divided into many sections : 

      ![CHEESE!](Url.png)

Example program:- "[URLMethod.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/URLMethod.java)"

      Output :
               1. Protocol:- https
               2. Host/Domain:- github.com
               3. Host Authority:- github.com
               4. Port:- -1
               5. Default Port:- 443
               6. Path:- /dhunganaPradeep
               7. File:- /dhunganaPradeep?tab=repositories&type=source
               8. Reference/Anchor:- null
               9. Query String:- tab=repositories&type=source
               10. URI:- https://github.com/dhunganaPradeep?tab=repositories&type=source

# Question no.2:- Write a program to process URL processing.

Answer:-

"[URLMethod.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/URLMethod.java)"

     Output :
               1. Protocol:- https
               2. Host/Domain:- github.com
               3. Host Authority:- github.com
               4. Port:- -1
               5. Default Port:- 443
               6. Path:- /dhunganaPradeep
               7. File:- /dhunganaPradeep?tab=repositories&type=source
               8. Reference/Anchor:- null
               9. Query String:- tab=repositories&type=source
               10. URI:- https://github.com/dhunganaPradeep?tab=repositories&type=source


# Question no.3 :- Differentiate between URL and URLConnection class in java.

Answer:-

 | URL Class  | URLConnection Class |
| ------------- | ------------- |
| It represents a Uniform Resource Locator (URL) and provides methods for working with URLs.  | It represents a connection to a URL resource.  |
| It can be used to create an instance of a URL from a string representation.  | It can be used to establish a connection to a URL and obtain input and/or output streams. |
| It provides methods for accessing the components of a URL such as protocol, host, path, query, etc.  | It provides methods for setting and getting request properties such as headers, cookies, etc.  |
| It can be used to compare two URLs for equality.  | It provides methods for getting the response code, content type, and length of the resource.  |
| It provides methods for encoding and decoding URL strings.  |It supports both HTTP and HTTPS protocols. |
|It is used to open a connection to a resource identified by the URL.  | It can be used to handle redirects and authentication.  |
| It is part of the java.net package.  | It is part of the java.net package.  |
|Example :- "[URLMethod.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/URLMethod.java)"  | Example :- "[URLConnectionClass.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/URLConnectionClass.java)"  |


# Question no.4:-  Write a program to print the content of any given URL. Also save the content in an index.html file.

Answer:- "[URLConnectionClass.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/URLConnectionClass.java)"
  
# Question no.5:-  Write a program to display the HttpRequest Headers.

Answer:- "[HttpRequestHeaders.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/HttpRequestHeaders.java)"

# Question no.6:- Write a program to print all the Http Responses.


Answer:- "[HttpResponses.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/HttpResponses.java)"

# Question no. 7:- Write a program that prints all the ip addresses associated with 'google.com'.

Answer:- "[IPAddressofGoogle.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/IPAddressofGoogle.java)"

# Question no.8:- Write a program to do the following:
- # a) Print the hostname and ip address of ncit’s webpage.
- # b) Print the name and address of your localhost.
- # c) Print the loopback address.
- # d) Given that the ip address is 123.1.100.1, check if it is a loopback address, multicast address, global multicast address.
- # e) Display name and addresses of all the network interfaces.

Answer:- "[Address.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/Address.java)"

# Question no.9 :- Differentiate between TCP and UDP.

Answer:-

 | TCP  | UDP |
| ------------- | ------------- |
| Transmission control protocol |User datagram protocol |
| TCP is a connection-oriented protocol. Connection-orientation means that the communicating devices should establish a connection before transmitting data and should close the connection after transmitting the data. | UDP is the Datagram-oriented protocol. This is because there is no overhead for opening a connection, maintaining a connection, and terminating a connection. UDP is efficient for broadcast and multicast types of network transmission. |
|TCP is reliable as it guarantees the delivery of data to the destination router.  |The delivery of data to the destination cannot be guaranteed in UDP. |
|	TCP is comparatively slower than UDP.  |UDP is faster, simpler, and more efficient than TCP.  |
| TCP is mainly used in data sensitive application.  | UDP is mainly used in time sensitive application. |
| Header Size is 20-bytes.  | Header size is 8-bytes.  |
| TCP follows threeway handshake concept  | UDP doesn't wait for the acknowledgement.  |
| Performs errorchecking by using checksum.  | Doesn't perform errorchecking. |
|Example :- Web Browsing, email etc.  | Example :- DNS, VOIP, line-data streaming |


# Question no. 10:- Write the steps to create the TCP Client and Server.

Answer:-

**Steps to create the TCP Client and Server :**

## TCP Server:

- Create a ServerSocket object by providing a port number to listen to incoming client connections.
- Call the accept() method on the ServerSocket object to block and wait for a client to connect. This method returns a Socket object.
- Create an input and output stream for the socket to communicate with the client.
- Use the input stream to read data sent by the client and use the output stream to send data to the client.
- Close the socket and release the resources when the communication with the client is complete.

## TCP Client:

- Create a Socket object by providing the IP address and port number of the server to connect to.
- Create an input and output stream for the socket to communicate with the server.
- Use the output stream to send data to the server and use the input stream to read data sent by the server.
- Close the socket and release the resources when the communication with the server is complete.

Example Programs : 

**SERVER:-** "[Server.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/Server.java)"

**CLIENT:-**"[Client.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/Client.java)"
# Question no. 11:- Write a program that takes a string input from the user and sends the string to the server. The server should check whether the string is palindrome or not and return back to the client.

Answer:-

**SERVER:-** "[ServerPalindrome.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/ServerPalindrome.java)"

**CLIENT:-**"[ClientPalindrome.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/ClientPalindrome.java)"
# Question no. 12:- Create a multithreaded multiuser TCP client server application.

Answer:-

**SERVER:-** "[MultiThreadingTCPServer.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/MultiThreadingTCPServer.java)"

**CLIENT:-** "[MultiThreadingTCPClient.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/MultiThreadingTCPClient.java)"

# Question no. 13:- Create a UDP server and client application.

Answer:-

**SERVER:-** "[UDPServer.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/UDPServer.java)"

**CLIENT:-** "[UDPClient.java](https://github.com/dhunganaPradeep/Java/blob/main/Assignments/Network%20Programming/UDPClient.java)"