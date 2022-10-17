package example.hello;

//import java.rmi.registry.Registry;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;

import java.util.*;

public class ChatRoomObject implements ChatRoom {
    static ArrayList<String> posts = new ArrayList<String>();
    static ArrayList<Caller> clients = new ArrayList<Caller>();
   
    public ChatRoomObject() {}

    public String get()
    {
        return posts.toString();
    }

    public void post(String Post)
        {
            posts.add(Post);
            call();
        }

    public void register(Caller Client)
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
                ((Caller) i.next()).call();
            }
            } catch (Exception e) {
    }
        }
    }
}