
package Client;

import Server.Interfaz;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente{
    private static final String IP = "127.0.0.1"; 
	private static final int PUERTO = 1100; 
	
    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException  {
        
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interfaz interfaz = (Interfaz) registry.lookup("cliente");
        VistaCliente vista = new VistaCliente(interfaz);
       
        
     
        
        
    }

}
