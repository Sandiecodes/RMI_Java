import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Server {
    public static void main(String args[]) {
        try {
            ChatRoomObject obj = new ChatRoomObject();
            ChatRoom stub = (ChatRoom) UnicastRemoteObject.exportObject(obj, 0);
        
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Hello", stub);
       
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }   
}
