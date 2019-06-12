
package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interfaz extends Remote{
    public void atacar(int x, int y, int nJugador)throws RemoteException;    
    int[][] inicializarTablero(int[][] tablero )throws RemoteException;    
    int[][] inicilizarBarcos(int[][] tablero )throws RemoteException;
    public void copiarTablero(int[][] tablero, boolean turno)throws RemoteException;
    public boolean asignarTurno()throws RemoteException;
    public int asignarNJugador(int nJugador, boolean turno)throws RemoteException;
    public boolean cambiarTurno( int nJugador) throws RemoteException;
    public int[][] actualizarZonaAliada(int nJugador)throws RemoteException;
    public int[][] actualizarZonaEnemiga(int nJugador)throws RemoteException;
    public boolean comprobarTurno(int nJugador)throws RemoteException;
    public int checkWin(int nJugador)throws RemoteException;
    public void saveState()throws RemoteException;
    public int[][] recoverState(int nJugador)throws RemoteException;
    
}
