import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatRoom extends Remote {
    //get chatroom
    String get() throws RemoteException;

    //post to a chatroom
    void post(String Post) throws RemoteException;
    
    // Registers client
    void register(ChatRoom_interface Client) throws RemoteException;
}