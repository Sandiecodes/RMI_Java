import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Client extends UnicastRemoteObject implements ChatRoom_interface{
    private ChatRoom room;

    public Client(ChatRoom Room) throws RemoteException
    {
        super();
        room = Room;
    }

    public void register(){
        try{
            room.register(this);
            System.out.println("REG");
        }
        catch(Exception e) {System.out.println(e);};
    }

    public void call()
    {
        System.out.println("NEW POSTS");
        try
        {
            String response = room.get();
            System.out.println("POST");
            System.out.println("response: " + response);
            }
        catch (Exception e) {};
    }
    public void post(String Text)
    {
        try{
            room.post(Text);
        }
        catch(Exception e) {};
    }
    public synchronized void waiting()
    {
        try{
            wait();
            }
        catch(Exception e) {};
    }
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Client client = new Client(((ChatRoom) registry.lookup("Hello")) );
            
            client.register();
            
            client.post("hello");
            client.post("123");
            client.call();
            client.waiting();

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
            }
        }
}

