
import java.rmi.*;  
import java.rmi.server.*;  
public class AdderRemote extends UnicastRemoteObject implements Adder
{  
AdderRemote()throws RemoteException{  
super();  
}  
public int add(int x,int y){return x+y;}  
}  
