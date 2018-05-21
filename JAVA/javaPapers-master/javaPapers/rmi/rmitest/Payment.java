import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Payment extends Remote {
    public double calculatePayment(double principal, double annualRate, int terms)
                    throws RemoteException;
}


