//import java.rmi.registry.Registry;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;

import java.util.*;

public class ChatRoomObject implements ChatRoom {
    // Hashmap that stores Chatroom name
    static ArrayList<String> posts = new ArrayList<String>();
    static ArrayList<ChatRoom_interface> clients = new ArrayList<ChatRoom_interface>();
   
    public ChatRoomObject() {}
    
    //get chatroom
    public String get()
    {
        return posts.toString();
    }

    public void post(String Post)
        {
            posts.add(Post);
            call();
        }

    public void register(ChatRoom_interface Client)
    {
        System.out.println("REGISTER");
        clients.add(Client);
    }
    public void call()
        {
            System.out.println("NEW CALL");
            Iterator i = clients.iterator();
            while(i.hasNext())
        {
            try {
            {
                ((ChatRoom_interface) i.next()).call();
            }
            } catch (Exception e) {
    }
        }
    }
}