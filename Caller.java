package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;


// Define the client
public interface Caller extends Remote
{
    public void call() throws RemoteException;
}