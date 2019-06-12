
package Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;


 class Servidor {
    private static final int PUERTO = 1100; 
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        
        
        Remote remote = UnicastRemoteObject.exportObject(new Interfaz() {
            
            int turno[] = {0,0};
            boolean turno1 = true, turno2=false;
            int copiados[] = {0,0};
            int[][] tablero1 = new int[8][8];
            int[][] tablero2 = new int[8][8];
            
            @Override
            public void atacar(int x, int y, int nJugador) throws RemoteException {
                if(nJugador == 1 && tablero2[x][y] == 2) tablero2[x][y] = 3;
                if(nJugador == 1 && tablero2[x][y] == 0) tablero2[x][y] = 1;
                
                if(nJugador == 2 && tablero1[x][y] == 2) tablero1[x][y] = 3;
                if(nJugador == 2 && tablero1[x][y] == 0) tablero1[x][y] = 1;                
            }
            
            @Override
            public int[][] inicializarTablero(int[][] tablero) throws RemoteException {
                for(int i=0; i<tablero.length; i++)
                    for(int j=0; j<tablero.length; j++)
                        tablero[i][j] = 0; 
                return tablero;
            }

            @Override
            public int[][] inicilizarBarcos(int[][] tablero) throws RemoteException {
                int nBarcos = 0,ni, nj;
                while(nBarcos < 15 ){                    
                    ni = (int) (Math.random() * tablero.length );                    
                    nj = (int) (Math.random() * tablero.length );                
                    if(tablero[ni][nj] != 2){
                        tablero[ni][nj] = 2;
                        nBarcos++;
                    }                    
                }    
                return tablero;                
            }

            @Override
            public void copiarTablero(int[][] tablero, boolean turno) {
                if(turno && copiados[0] == 0){
                    this.tablero1 = tablero;
                    this.copiados[0] = 1;
                    System.out.println("tab1:");
                for(int i=0;i<tablero1.length;i++){
                    for(int j=0;j<tablero1.length;j++)
                        System.out.print(tablero1[i][j]);
                    System.out.println("");
                }
                }
                if(!turno && copiados[0] != 0){
                    this.tablero2 = tablero;
                    this.copiados[1] = 1;
                     System.out.println("tab2:");
                for(int i=0;i<tablero2.length;i++){
                    for(int j=0;j<tablero2.length;j++)
                        System.out.print(tablero2[i][j]);
                    System.out.println("");
                }
                }                        
            }

            @Override
            public boolean asignarTurno() {
                if(this.turno[0] == 0){ 
                    this.turno[0] = 1;                   
                    return true;
                }
                if(this.turno[0] != 0 && this.turno[1] == 0){
                    this.turno[1] = 2;                                        
                    return false;
                }
                return false;
            }

            @Override
            public boolean cambiarTurno(int nJugador) throws RemoteException {
                boolean t = false;                
                if(nJugador == 1){
                    turno1 = false;
                    turno2 = true;
                }
                if(nJugador == 2){
                    turno2 = false;
                    turno1 = true;
                }
                return false;
            }

            @Override
            public int asignarNJugador(int nJugador, boolean turno) throws RemoteException {
                int n;
                if(turno) n = 1;
                else n=2;
                return n;
            }

            @Override
            public int[][] actualizarZonaAliada(int nJugador) throws RemoteException {
                int [][] tab = new int [8][8];
                if(nJugador == 1) tab = tablero1;
                if(nJugador == 2) tab = tablero2;
                return tab;
            }

            @Override
            public int[][] actualizarZonaEnemiga(int nJugador) throws RemoteException {
                int [][] tab = new int [8][8];
                if(nJugador == 1) tab = tablero2;
                if(nJugador == 2) tab = tablero1;
                return tab;
            }

            @Override
            public boolean comprobarTurno(int nJugador) throws RemoteException {
                boolean t = false;
                if(nJugador == 1) t = turno1;
                if(nJugador == 2) t = turno2;
                return t;
            }

            @Override
            public int checkWin(int nJugador) {
                boolean gana = false;
                int count1 = 0, count2 = 0,i,j;
                if(nJugador == 1){
                    for( i=0;i<tablero1.length;i++)
                        for( j=0;j<tablero1.length;j++)
                            if(tablero1[i][j] == 3) count1++;
                    if(count1 == 15) return 1;
                }
                if(nJugador == 2){   
                    for( i=0;i<tablero2.length;i++)
                        for( j=0;j<tablero2.length;j++)
                            if(tablero2[i][j] == 3) count2++;
                    if(count1 == 15) return 2;
                }                   
                return 0;                
            }

            @Override
            public void saveState() throws RemoteException 
            {
                String nombre="jugador1.txt";
                String nombre2="jugador2.txt";
                int i, j;
                File archivo= new File(nombre);
                File archivo2= new File(nombre2);
                try 
                {
                    PrintWriter pw = new PrintWriter(archivo);
                    PrintWriter pw2 = new PrintWriter(archivo2);
                    //pw.print("lola");
                    //Tablero 1
                    for(i=0; i<8; i++)
                    {
                        for(j=0; j<8; j++)
                        {
                            pw.println(tablero1[i][j]);
                        }  
                    }
                    
                    //Tablero 1
                    for(i=0; i<8; i++)
                    {
                        for(j=0; j<8; j++)
                        {
                            pw2.println(tablero2[i][j]);
                        }  
                    }
                    
                    pw.close();
                    pw2.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public int[][] recoverState(int nJugador) 
            {
                int [][] tabAux=new int[8][8];                
                int i, j;
                
                if(nJugador==1)
                {
                    FileReader fr=null;
                    try {
                        String nombre="jugador1.txt";
                        fr = new FileReader(nombre);
                        BufferedReader br = new BufferedReader(fr);
                        for(i=0; i<8; i++)
                        {
                            for(j=0; j<8; j++)
                            {  
                                try {
                                    //System.out.println(br.readLine());
                                    tabAux[i][j]=Integer.parseInt(br.readLine());
                                } catch (IOException ex) {
                                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            fr.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
                else
                {
                    
                    
                    FileReader fr=null;
                    try {
                        String nombre="jugador2.txt";
                        fr = new FileReader(nombre);
                        BufferedReader br = new BufferedReader(fr);
                        for(i=0; i<8; i++)
                        {
                            for(j=0; j<8; j++)
                            {  
                                try {
                                    tabAux[i][j]=Integer.parseInt(br.readLine());
                                } catch (IOException ex) {
                                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            fr.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    
                }
                 
                
              //  String nombre2="jugador2.txt";
                
                
            //    File archivo2= new File(nombre2);
                
                
                return tabAux;
            }
        }, 0);
        Registry registry = LocateRegistry.createRegistry(PUERTO);
       	System.out.println("Servidor escuchando en el puerto " + String.valueOf(PUERTO));
        registry.bind("cliente", remote); // Registrar cliente 
}

    
}
