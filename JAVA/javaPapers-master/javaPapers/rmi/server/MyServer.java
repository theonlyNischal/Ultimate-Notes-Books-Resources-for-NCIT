
import java.rmi.*;  
import java.rmi.registry.*;  
public class MyServer{  
public static void main(String args[]){  
try{  
AdderRemote stub=new AdderRemote();  
Naming.rebind("rmi://localhost:5000/nd",stub);  
}catch(Exception e){System.out.println(e);}  
}  
}  
