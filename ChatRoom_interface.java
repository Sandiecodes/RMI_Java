import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ChatRoom_interface extends Remote{

    public void call () throws RemoteException;
    
}
