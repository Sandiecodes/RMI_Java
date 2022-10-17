package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatRoom extends Remote {
    
    String get() throws RemoteException;
    void post(String Post) throws RemoteException;
    void register(Caller Client) throws RemoteException;
}