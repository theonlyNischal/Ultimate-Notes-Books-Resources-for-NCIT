
import java.rmi.*;  
import java.rmi.registry.*;  
public class MyServer{  
public static void main(String args[]){  
try{  
AdderRemote stub=new AdderRemote();  
Naming.rebind("nabin",stub);  
}catch(Exception e){System.out.println(e);}  
}  
}  
