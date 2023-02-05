//Write a program to display all the http request headers.
import java.net.*;
import java.io.*;
import java.util.*;

class HttpRequest {
    public static void main(String [] args){
        try{
            URL url=new URL("https://pu.edu.np");
            HttpURLConnection cn=(HttpURLConnection)url.openConnection();
            Map<String,List<String>> headers=cn.getHeaderFields();
            for(Map.Entry<String,List<String>>h:headers.entrySet()){
                System.out.println(h.getKey()+" : "+h.getValue());
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
