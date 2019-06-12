/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Server.Interfaz;
import java.awt.Color;
import java.io.File;
import static java.lang.Thread.sleep;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.*; 

public class VistaCliente extends javax.swing.JFrame{
    private Interfaz interfaz;
    private int[][] tablero = new int[8][8];
    private int[][] tablero2 = new int[8][8];
    private JButton[][] tableroBotones = new JButton[8][8];
    private JButton[][] tableroBotones2 = new JButton[8][8];
    private boolean turno;
    private int nJugador;
    int noJ;


    public VistaCliente(Interfaz interfaz) throws RemoteException, InterruptedException {
        initComponents();
        
        this.interfaz = interfaz;
        
        turno = interfaz.asignarTurno();
        nJugador = interfaz.asignarNJugador(nJugador, turno);
        lblJugador.setText("Jugador " + nJugador);
        
        
        
        if(nJugador == 1 ) noJ =2;
        if(nJugador == 2 ) noJ =1;
        
        File archivo= new File("Jugador1.txt");
        File archivo2= new File("Jugador2.txt");
        inicializarTableroAliado();
            inicializarTableroEnemigo();
        
        if(archivo.exists() && archivo2.exists())
        {
            if(archivo.exists() && nJugador == 1)
            {
                tablero = interfaz.recoverState(nJugador);
                tablero2 = interfaz.recoverState(noJ);
            }
            /*else if(archivo2.exists() && nJugador == 1)
            {
                tablero2 = interfaz.recoverState(nJugador);
            }*/

            if(archivo2.exists() && nJugador == 2)
            {
                tablero = interfaz.recoverState(nJugador);
                tablero2 = interfaz.recoverState(noJ);
            }
            /*
            else if(archivo.exists() && nJugador == 2)
            {
                tablero = interfaz.recoverState(nJugador);
            }
            */
            interfaz.copiarTablero(tablero, turno);
        }
               /* for(int i=0; i<8; i++)
                    {
                        for(int j=0; j<8; j++)
                        {
                            System.out.print(tablero[i][j]);
                            
                        }  
                        System.out.println("");
                    }
                System.out.println("");
                for(int i=0; i<8; i++)
                    {
                        for(int j=0; j<8; j++)
                        {
                            System.out.print(tablero2[i][j]);
                        }  
                        System.out.println("");
                    }*/
        
          else     
        {
            tablero = interfaz.inicializarTablero(tablero);
            tablero = interfaz.inicilizarBarcos(tablero);
            interfaz.copiarTablero(tablero, turno);
            
        }
                            
        
        /*tablero = interfaz.inicializarTablero(tablero);
           tablero = interfaz.inicilizarBarcos(tablero);
            interfaz.copiarTablero(tablero, turno);
            inicializarTableroAliado();
            inicializarTableroEnemigo();*/
        
        
               
        mostrarZonaAliada();
        mostrarZonaEnemiga();
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        gestionarTurno();
       // interfaz.saveState();
        if(nJugador == 2) esperarTurno();
}
    
    public void gestionarTurno(){
        if(turno){            
            
            lblTurno.setText("TU TURNO!");
            panelTurno.setBackground(Color.green);
            
            ze00.setEnabled(true);
            ze01.setEnabled(true);
            ze02.setEnabled(true);
            ze03.setEnabled(true);
            ze04.setEnabled(true);
            ze05.setEnabled(true);
            ze06.setEnabled(true);
            ze07.setEnabled(true);
            
            ze10.setEnabled(true);
            ze11.setEnabled(true);
            ze12.setEnabled(true);
            ze13.setEnabled(true);
            ze14.setEnabled(true);
            ze15.setEnabled(true);
            ze16.setEnabled(true);
            ze17.setEnabled(true);
            
            ze20.setEnabled(true);
            ze21.setEnabled(true);
            ze22.setEnabled(true);
            ze23.setEnabled(true);
            ze24.setEnabled(true);
            ze25.setEnabled(true);
            ze26.setEnabled(true);
            ze27.setEnabled(true);
            
            ze30.setEnabled(true);
            ze31.setEnabled(true);
            ze32.setEnabled(true);
            ze33.setEnabled(true);
            ze34.setEnabled(true);
            ze35.setEnabled(true);
            ze36.setEnabled(true);
            ze37.setEnabled(true);
            
            ze40.setEnabled(true);
            ze41.setEnabled(true);
            ze42.setEnabled(true);
            ze43.setEnabled(true);
            ze44.setEnabled(true);
            ze45.setEnabled(true);
            ze46.setEnabled(true);
            ze47.setEnabled(true);
            
            ze50.setEnabled(true);
            ze51.setEnabled(true);
            ze52.setEnabled(true);
            ze53.setEnabled(true);
            ze54.setEnabled(true);
            ze55.setEnabled(true);
            ze56.setEnabled(true);
            ze57.setEnabled(true);
            
            ze60.setEnabled(true);
            ze61.setEnabled(true);
            ze62.setEnabled(true);
            ze63.setEnabled(true);
            ze64.setEnabled(true);
            ze65.setEnabled(true);
            ze66.setEnabled(true);
            ze67.setEnabled(true);
            
            ze70.setEnabled(true);
            ze71.setEnabled(true);
            ze72.setEnabled(true);
            ze73.setEnabled(true);
            ze74.setEnabled(true);
            ze75.setEnabled(true);
            ze76.setEnabled(true);
            ze77.setEnabled(true);
            
        }
        if(!turno){
            
            lblTurno.setText("ESPERANDO ATAQUE...");
            panelTurno.setBackground(Color.red);
            
            ze00.setEnabled(false);
            ze01.setEnabled(false);
            ze02.setEnabled(false);
            ze03.setEnabled(false);
            ze04.setEnabled(false);
            ze05.setEnabled(false);
            ze06.setEnabled(false);
            ze07.setEnabled(false);
            
            ze10.setEnabled(false);
            ze11.setEnabled(false);
            ze12.setEnabled(false);
            ze13.setEnabled(false);
            ze14.setEnabled(false);
            ze15.setEnabled(false);
            ze16.setEnabled(false);
            ze17.setEnabled(false);
            
            ze20.setEnabled(false);
            ze21.setEnabled(false);
            ze22.setEnabled(false);
            ze23.setEnabled(false);
            ze24.setEnabled(false);
            ze25.setEnabled(false);
            ze26.setEnabled(false);
            ze27.setEnabled(false);
            
            ze30.setEnabled(false);
            ze31.setEnabled(false);
            ze32.setEnabled(false);
            ze33.setEnabled(false);
            ze34.setEnabled(false);
            ze35.setEnabled(false);
            ze36.setEnabled(false);
            ze37.setEnabled(false);
            
            ze40.setEnabled(false);
            ze41.setEnabled(false);
            ze42.setEnabled(false);
            ze43.setEnabled(false);
            ze44.setEnabled(false);
            ze45.setEnabled(false);
            ze46.setEnabled(false);
            ze47.setEnabled(false);
            
            ze50.setEnabled(false);
            ze51.setEnabled(false);
            ze52.setEnabled(false);
            ze53.setEnabled(false);
            ze54.setEnabled(false);
            ze55.setEnabled(false);
            ze56.setEnabled(false);
            ze57.setEnabled(false);
            
            ze60.setEnabled(false);
            ze61.setEnabled(false);
            ze62.setEnabled(false);
            ze63.setEnabled(false);
            ze64.setEnabled(false);
            ze65.setEnabled(false);
            ze66.setEnabled(false);
            ze67.setEnabled(false);
            
            ze70.setEnabled(false);
            ze71.setEnabled(false);
            ze72.setEnabled(false);
            ze73.setEnabled(false);
            ze74.setEnabled(false);
            ze75.setEnabled(false);
            ze76.setEnabled(false);
            ze77.setEnabled(false);
        }
    }
    
    public void inicializarTableroAliado(){
        tableroBotones[0][0] = za00; 
        tableroBotones[0][1] = za01; 
        tableroBotones[0][2] = za02; 
        tableroBotones[0][3] = za03; 
        tableroBotones[0][4] = za04; 
        tableroBotones[0][5] = za05; 
        tableroBotones[0][6] = za06; 
        tableroBotones[0][7] = za07;
        
        tableroBotones[1][0] = za10; 
        tableroBotones[1][1] = za11; 
        tableroBotones[1][2] = za12; 
        tableroBotones[1][3] = za13; 
        tableroBotones[1][4] = za14; 
        tableroBotones[1][5] = za15; 
        tableroBotones[1][6] = za16; 
        tableroBotones[1][7] = za17;
        
        tableroBotones[2][0] = za20; 
        tableroBotones[2][1] = za21; 
        tableroBotones[2][2] = za22; 
        tableroBotones[2][3] = za23; 
        tableroBotones[2][4] = za24; 
        tableroBotones[2][5] = za25; 
        tableroBotones[2][6] = za26; 
        tableroBotones[2][7] = za27;
        
        tableroBotones[3][0] = za30; 
        tableroBotones[3][1] = za31; 
        tableroBotones[3][2] = za32; 
        tableroBotones[3][3] = za33; 
        tableroBotones[3][4] = za34; 
        tableroBotones[3][5] = za35; 
        tableroBotones[3][6] = za36; 
        tableroBotones[3][7] = za37;
        
        tableroBotones[4][0] = za40; 
        tableroBotones[4][1] = za41; 
        tableroBotones[4][2] = za42; 
        tableroBotones[4][3] = za43; 
        tableroBotones[4][4] = za44; 
        tableroBotones[4][5] = za45; 
        tableroBotones[4][6] = za46; 
        tableroBotones[4][7] = za47;
       
        tableroBotones[5][0] = za50; 
        tableroBotones[5][1] = za51; 
        tableroBotones[5][2] = za52; 
        tableroBotones[5][3] = za53; 
        tableroBotones[5][4] = za54; 
        tableroBotones[5][5] = za55; 
        tableroBotones[5][6] = za56; 
        tableroBotones[5][7] = za57;
       
        tableroBotones[6][0] = za60; 
        tableroBotones[6][1] = za61; 
        tableroBotones[6][2] = za62; 
        tableroBotones[6][3] = za63; 
        tableroBotones[6][4] = za64; 
        tableroBotones[6][5] = za65; 
        tableroBotones[6][6] = za66; 
        tableroBotones[6][7] = za67;
        
        tableroBotones[7][0] = za70; 
        tableroBotones[7][1] = za71; 
        tableroBotones[7][2] = za72; 
        tableroBotones[7][3] = za73; 
        tableroBotones[7][4] = za74; 
        tableroBotones[7][5] = za75; 
        tableroBotones[7][6] = za76; 
        tableroBotones[7][7] = za77;
       
        
    }
    
    public void inicializarTableroEnemigo(){
        tableroBotones2[0][0] = ze00; 
        tableroBotones2[0][1] = ze01; 
        tableroBotones2[0][2] = ze02; 
        tableroBotones2[0][3] = ze03; 
        tableroBotones2[0][4] = ze04; 
        tableroBotones2[0][5] = ze05; 
        tableroBotones2[0][6] = ze06; 
        tableroBotones2[0][7] = ze07;
        
        tableroBotones2[1][0] = ze10; 
        tableroBotones2[1][1] = ze11; 
        tableroBotones2[1][2] = ze12; 
        tableroBotones2[1][3] = ze13; 
        tableroBotones2[1][4] = ze14; 
        tableroBotones2[1][5] = ze15; 
        tableroBotones2[1][6] = ze16; 
        tableroBotones2[1][7] = ze17;
        
        tableroBotones2[2][0] = ze20; 
        tableroBotones2[2][1] = ze21; 
        tableroBotones2[2][2] = ze22; 
        tableroBotones2[2][3] = ze23; 
        tableroBotones2[2][4] = ze24; 
        tableroBotones2[2][5] = ze25; 
        tableroBotones2[2][6] = ze26; 
        tableroBotones2[2][7] = ze27;
        
        tableroBotones2[3][0] = ze30; 
        tableroBotones2[3][1] = ze31; 
        tableroBotones2[3][2] = ze32; 
        tableroBotones2[3][3] = ze33; 
        tableroBotones2[3][4] = ze34; 
        tableroBotones2[3][5] = ze35; 
        tableroBotones2[3][6] = ze36; 
        tableroBotones2[3][7] = ze37;
        
        tableroBotones2[4][0] = ze40; 
        tableroBotones2[4][1] = ze41; 
        tableroBotones2[4][2] = ze42; 
        tableroBotones2[4][3] = ze43; 
        tableroBotones2[4][4] = ze44; 
        tableroBotones2[4][5] = ze45; 
        tableroBotones2[4][6] = ze46; 
        tableroBotones2[4][7] = ze47;
      
        tableroBotones2[5][0] = ze50; 
        tableroBotones2[5][1] = ze51; 
        tableroBotones2[5][2] = ze52; 
        tableroBotones2[5][3] = ze53; 
        tableroBotones2[5][4] = ze54; 
        tableroBotones2[5][5] = ze55; 
        tableroBotones2[5][6] = ze56; 
        tableroBotones2[5][7] = ze57;
      
        tableroBotones2[6][0] = ze60; 
        tableroBotones2[6][1] = ze61; 
        tableroBotones2[6][2] = ze62; 
        tableroBotones2[6][3] = ze63; 
        tableroBotones2[6][4] = ze64; 
        tableroBotones2[6][5] = ze65; 
        tableroBotones2[6][6] = ze66; 
        tableroBotones2[6][7] = ze67;
        
        tableroBotones2[7][0] = ze70; 
        tableroBotones2[7][1] = ze71; 
        tableroBotones2[7][2] = ze72; 
        tableroBotones2[7][3] = ze73; 
        tableroBotones2[7][4] = ze74; 
        tableroBotones2[7][5] = ze75; 
        tableroBotones2[7][6] = ze76; 
        tableroBotones2[7][7] = ze77;
       
        
    }
    
    public void mostrarZonaAliada(){
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero.length;j++){
                if(tablero[i][j] == 2)
                    tableroBotones[i][j].setBackground(Color.blue);
                if(tablero[i][j] == 1)
                    tableroBotones[i][j].setBackground(Color.white);
                if(tablero[i][j] == 3)
                    tableroBotones[i][j].setBackground(Color.red);
            }
        }
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public void mostrarZonaEnemiga(){
        for(int i=0;i<tablero2.length;i++){
            for(int j=0;j<tablero2.length;j++){
                if(tablero2[i][j] == 1)
                    tableroBotones2[i][j].setBackground(Color.white);
                if(tablero2[i][j] == 3)
                    tableroBotones2[i][j].setBackground(Color.red);
            }
        }
        SwingUtilities.updateComponentTreeUI(this);
        
    }
    
    public void esperarTurno() throws RemoteException, InterruptedException{
        while(turno == false){
            turno = interfaz.comprobarTurno(nJugador);            
            sleep(500);
        }
        if(turno == true){
            gestionarTurno();            
            tablero = interfaz.actualizarZonaAliada(nJugador);
            mostrarZonaAliada();
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "HAS PERDIDO...", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
        }
       
    }
    

    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        zonaAliada = new javax.swing.JPanel();
        za00 = new javax.swing.JButton();
        za01 = new javax.swing.JButton();
        za02 = new javax.swing.JButton();
        za03 = new javax.swing.JButton();
        za04 = new javax.swing.JButton();
        za05 = new javax.swing.JButton();
        za06 = new javax.swing.JButton();
        za07 = new javax.swing.JButton();
        za10 = new javax.swing.JButton();
        za11 = new javax.swing.JButton();
        za12 = new javax.swing.JButton();
        za13 = new javax.swing.JButton();
        za14 = new javax.swing.JButton();
        za15 = new javax.swing.JButton();
        za16 = new javax.swing.JButton();
        za17 = new javax.swing.JButton();
        za20 = new javax.swing.JButton();
        za21 = new javax.swing.JButton();
        za22 = new javax.swing.JButton();
        za23 = new javax.swing.JButton();
        za24 = new javax.swing.JButton();
        za25 = new javax.swing.JButton();
        za26 = new javax.swing.JButton();
        za27 = new javax.swing.JButton();
        za30 = new javax.swing.JButton();
        za31 = new javax.swing.JButton();
        za32 = new javax.swing.JButton();
        za33 = new javax.swing.JButton();
        za34 = new javax.swing.JButton();
        za35 = new javax.swing.JButton();
        za36 = new javax.swing.JButton();
        za37 = new javax.swing.JButton();
        za40 = new javax.swing.JButton();
        za41 = new javax.swing.JButton();
        za42 = new javax.swing.JButton();
        za43 = new javax.swing.JButton();
        za44 = new javax.swing.JButton();
        za45 = new javax.swing.JButton();
        za46 = new javax.swing.JButton();
        za47 = new javax.swing.JButton();
        za50 = new javax.swing.JButton();
        za51 = new javax.swing.JButton();
        za52 = new javax.swing.JButton();
        za53 = new javax.swing.JButton();
        za54 = new javax.swing.JButton();
        za55 = new javax.swing.JButton();
        za56 = new javax.swing.JButton();
        za57 = new javax.swing.JButton();
        za60 = new javax.swing.JButton();
        za61 = new javax.swing.JButton();
        za62 = new javax.swing.JButton();
        za63 = new javax.swing.JButton();
        za64 = new javax.swing.JButton();
        za65 = new javax.swing.JButton();
        za66 = new javax.swing.JButton();
        za67 = new javax.swing.JButton();
        za70 = new javax.swing.JButton();
        za71 = new javax.swing.JButton();
        za72 = new javax.swing.JButton();
        za73 = new javax.swing.JButton();
        za74 = new javax.swing.JButton();
        za75 = new javax.swing.JButton();
        za76 = new javax.swing.JButton();
        za77 = new javax.swing.JButton();
        zonaEnemiga = new javax.swing.JPanel();
        ze00 = new javax.swing.JButton();
        ze01 = new javax.swing.JButton();
        ze02 = new javax.swing.JButton();
        ze03 = new javax.swing.JButton();
        ze04 = new javax.swing.JButton();
        ze05 = new javax.swing.JButton();
        ze06 = new javax.swing.JButton();
        ze07 = new javax.swing.JButton();
        ze10 = new javax.swing.JButton();
        ze11 = new javax.swing.JButton();
        ze12 = new javax.swing.JButton();
        ze13 = new javax.swing.JButton();
        ze14 = new javax.swing.JButton();
        ze15 = new javax.swing.JButton();
        ze16 = new javax.swing.JButton();
        ze17 = new javax.swing.JButton();
        ze20 = new javax.swing.JButton();
        ze21 = new javax.swing.JButton();
        ze22 = new javax.swing.JButton();
        ze23 = new javax.swing.JButton();
        ze24 = new javax.swing.JButton();
        ze25 = new javax.swing.JButton();
        ze26 = new javax.swing.JButton();
        ze27 = new javax.swing.JButton();
        ze30 = new javax.swing.JButton();
        ze31 = new javax.swing.JButton();
        ze32 = new javax.swing.JButton();
        ze33 = new javax.swing.JButton();
        ze34 = new javax.swing.JButton();
        ze35 = new javax.swing.JButton();
        ze36 = new javax.swing.JButton();
        ze37 = new javax.swing.JButton();
        ze40 = new javax.swing.JButton();
        ze41 = new javax.swing.JButton();
        ze42 = new javax.swing.JButton();
        ze43 = new javax.swing.JButton();
        ze44 = new javax.swing.JButton();
        ze45 = new javax.swing.JButton();
        ze46 = new javax.swing.JButton();
        ze47 = new javax.swing.JButton();
        ze50 = new javax.swing.JButton();
        ze51 = new javax.swing.JButton();
        ze52 = new javax.swing.JButton();
        ze53 = new javax.swing.JButton();
        ze54 = new javax.swing.JButton();
        ze55 = new javax.swing.JButton();
        ze56 = new javax.swing.JButton();
        ze57 = new javax.swing.JButton();
        ze60 = new javax.swing.JButton();
        ze61 = new javax.swing.JButton();
        ze62 = new javax.swing.JButton();
        ze63 = new javax.swing.JButton();
        ze64 = new javax.swing.JButton();
        ze65 = new javax.swing.JButton();
        ze66 = new javax.swing.JButton();
        ze67 = new javax.swing.JButton();
        ze70 = new javax.swing.JButton();
        ze71 = new javax.swing.JButton();
        ze72 = new javax.swing.JButton();
        ze73 = new javax.swing.JButton();
        ze74 = new javax.swing.JButton();
        ze75 = new javax.swing.JButton();
        ze76 = new javax.swing.JButton();
        ze77 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        panelTurno = new javax.swing.JPanel();
        lblJugador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        zonaAliada.setBackground(new java.awt.Color(153, 153, 255));
        zonaAliada.setName("zonaAliada"); // NOI18N
        zonaAliada.setPreferredSize(new java.awt.Dimension(450, 450));

        za07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                za07ActionPerformed(evt);
            }
        });

        za14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                za14ActionPerformed(evt);
            }
        });

        za15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                za15ActionPerformed(evt);
            }
        });

        za77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                za77ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout zonaAliadaLayout = new javax.swing.GroupLayout(zonaAliada);
        zonaAliada.setLayout(zonaAliadaLayout);
        zonaAliadaLayout.setHorizontalGroup(
            zonaAliadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zonaAliadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(zonaAliadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zonaAliadaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(za60, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(za61, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(za62, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(za63, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(za64, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(za65, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(za66, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(za67, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(zonaAliadaLayout.createSequentialGroup()
                        .addGroup(zonaAliadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(zonaAliadaLayout.createSequentialGroup()
                                .addComponent(za00, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za01, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za02, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za03, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za04, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za05, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za06, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za07, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(zonaAliadaLayout.createSequentialGroup()
                                .addComponent(za10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(zonaAliadaLayout.createSequentialGroup()
                                .addComponent(za20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(zonaAliadaLayout.createSequentialGroup()
                                .addComponent(za30, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za31, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za35, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za36, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za37, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(zonaAliadaLayout.createSequentialGroup()
                                .addComponent(za40, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za41, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za42, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za43, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za44, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za45, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za46, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za47, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(zonaAliadaLayout.createSequentialGroup()
                                .addComponent(za50, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za51, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za52, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za53, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za54, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za55, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za56, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za57, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(zonaAliadaLayout.createSequentialGroup()
                                .addComponent(za70, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za71, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za72, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za73, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za74, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za75, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za76, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(za77, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        zonaAliadaLayout.setVerticalGroup(
            zonaAliadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zonaAliadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(zonaAliadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(za06, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za07, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za05, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za04, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za03, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za02, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za01, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za00, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaAliadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(za16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaAliadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(za26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaAliadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(za36, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za37, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za35, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za31, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za30, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaAliadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(za46, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za47, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za45, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za44, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za43, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za42, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za41, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za40, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaAliadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(za56, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za57, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za55, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za54, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za53, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za52, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za51, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za50, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaAliadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(za66, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za67, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za65, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za64, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za63, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za62, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za61, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za60, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaAliadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(za76, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za77, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za75, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za74, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za73, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za72, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za71, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(za70, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        zonaEnemiga.setBackground(new java.awt.Color(153, 153, 255));
        zonaEnemiga.setName("zonaEnemiga"); // NOI18N
        zonaEnemiga.setPreferredSize(new java.awt.Dimension(450, 450));

        ze00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze00ActionPerformed(evt);
            }
        });

        ze01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze01ActionPerformed(evt);
            }
        });

        ze02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze02ActionPerformed(evt);
            }
        });

        ze03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze03ActionPerformed(evt);
            }
        });

        ze04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze04ActionPerformed(evt);
            }
        });

        ze05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze05ActionPerformed(evt);
            }
        });

        ze06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze06ActionPerformed(evt);
            }
        });

        ze07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze07ActionPerformed(evt);
            }
        });

        ze10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze10ActionPerformed(evt);
            }
        });

        ze11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze11ActionPerformed(evt);
            }
        });

        ze12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze12ActionPerformed(evt);
            }
        });

        ze13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze13ActionPerformed(evt);
            }
        });

        ze14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze14ActionPerformed(evt);
            }
        });

        ze15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze15ActionPerformed(evt);
            }
        });

        ze16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze16ActionPerformed(evt);
            }
        });

        ze17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze17ActionPerformed(evt);
            }
        });

        ze20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze20ActionPerformed(evt);
            }
        });

        ze21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze21ActionPerformed(evt);
            }
        });

        ze22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze22ActionPerformed(evt);
            }
        });

        ze23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze23ActionPerformed(evt);
            }
        });

        ze24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze24ActionPerformed(evt);
            }
        });

        ze25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze25ActionPerformed(evt);
            }
        });

        ze26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze26ActionPerformed(evt);
            }
        });

        ze27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze27ActionPerformed(evt);
            }
        });

        ze30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze30ActionPerformed(evt);
            }
        });

        ze31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze31ActionPerformed(evt);
            }
        });

        ze32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze32ActionPerformed(evt);
            }
        });

        ze33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze33ActionPerformed(evt);
            }
        });

        ze34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze34ActionPerformed(evt);
            }
        });

        ze35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze35ActionPerformed(evt);
            }
        });

        ze36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze36ActionPerformed(evt);
            }
        });

        ze37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze37ActionPerformed(evt);
            }
        });

        ze40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze40ActionPerformed(evt);
            }
        });

        ze41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze41ActionPerformed(evt);
            }
        });

        ze42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze42ActionPerformed(evt);
            }
        });

        ze43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze43ActionPerformed(evt);
            }
        });

        ze44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze44ActionPerformed(evt);
            }
        });

        ze45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze45ActionPerformed(evt);
            }
        });

        ze46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze46ActionPerformed(evt);
            }
        });

        ze47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze47ActionPerformed(evt);
            }
        });

        ze50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze50ActionPerformed(evt);
            }
        });

        ze51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze51ActionPerformed(evt);
            }
        });

        ze52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze52ActionPerformed(evt);
            }
        });

        ze53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze53ActionPerformed(evt);
            }
        });

        ze54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze54ActionPerformed(evt);
            }
        });

        ze55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze55ActionPerformed(evt);
            }
        });

        ze56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze56ActionPerformed(evt);
            }
        });

        ze57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze57ActionPerformed(evt);
            }
        });

        ze60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze60ActionPerformed(evt);
            }
        });

        ze61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze61ActionPerformed(evt);
            }
        });

        ze62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze62ActionPerformed(evt);
            }
        });

        ze63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze63ActionPerformed(evt);
            }
        });

        ze64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze64ActionPerformed(evt);
            }
        });

        ze65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze65ActionPerformed(evt);
            }
        });

        ze66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze66ActionPerformed(evt);
            }
        });

        ze67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze67ActionPerformed(evt);
            }
        });

        ze70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze70ActionPerformed(evt);
            }
        });

        ze71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze71ActionPerformed(evt);
            }
        });

        ze72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze72ActionPerformed(evt);
            }
        });

        ze73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze73ActionPerformed(evt);
            }
        });

        ze74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze74ActionPerformed(evt);
            }
        });

        ze75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze75ActionPerformed(evt);
            }
        });

        ze76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze76ActionPerformed(evt);
            }
        });

        ze77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ze77ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout zonaEnemigaLayout = new javax.swing.GroupLayout(zonaEnemiga);
        zonaEnemiga.setLayout(zonaEnemigaLayout);
        zonaEnemigaLayout.setHorizontalGroup(
            zonaEnemigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zonaEnemigaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(zonaEnemigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zonaEnemigaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ze60, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ze61, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ze62, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ze63, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ze64, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ze65, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ze66, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ze67, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(zonaEnemigaLayout.createSequentialGroup()
                        .addGroup(zonaEnemigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(zonaEnemigaLayout.createSequentialGroup()
                                .addComponent(ze00, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze01, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze02, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze03, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze04, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze05, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze06, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze07, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(zonaEnemigaLayout.createSequentialGroup()
                                .addComponent(ze10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(zonaEnemigaLayout.createSequentialGroup()
                                .addComponent(ze20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(zonaEnemigaLayout.createSequentialGroup()
                                .addComponent(ze30, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze31, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze35, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze36, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze37, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(zonaEnemigaLayout.createSequentialGroup()
                                .addComponent(ze40, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze41, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze42, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze43, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze44, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze45, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze46, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze47, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(zonaEnemigaLayout.createSequentialGroup()
                                .addComponent(ze50, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze51, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze52, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze53, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze54, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze55, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze56, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze57, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(zonaEnemigaLayout.createSequentialGroup()
                                .addComponent(ze70, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze71, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze72, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze73, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze74, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze75, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze76, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ze77, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        zonaEnemigaLayout.setVerticalGroup(
            zonaEnemigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zonaEnemigaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(zonaEnemigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ze06, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze07, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze05, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze04, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze03, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze02, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze01, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze00, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaEnemigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ze16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaEnemigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ze26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaEnemigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ze36, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze37, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze35, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze31, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze30, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaEnemigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ze46, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze47, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze45, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze44, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze43, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze42, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze41, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze40, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaEnemigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ze56, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze57, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze55, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze54, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze53, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze52, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze51, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze50, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaEnemigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ze66, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze67, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze65, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze64, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze63, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze62, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze61, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze60, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zonaEnemigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ze76, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze77, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze75, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze74, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze73, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze72, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze71, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ze70, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setText("Barcos con vida:");

        jLabel5.setText("Barcos derrivados:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zonaAliada, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(zonaEnemiga, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zonaEnemiga, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zonaAliada, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("ZONA ALIADA");

        jLabel3.setText("ZONA ENEMIGA");

        lblTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurno.setText("TURNO");

        panelTurno.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout panelTurnoLayout = new javax.swing.GroupLayout(panelTurno);
        panelTurno.setLayout(panelTurnoLayout);
        panelTurnoLayout.setHorizontalGroup(
            panelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelTurnoLayout.setVerticalGroup(
            panelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        lblJugador.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblJugador))
                        .addGap(153, 153, 153)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(155, 155, 155)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTurno)
                    .addComponent(lblJugador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(panelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void za14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_za14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_za14ActionPerformed

    private void za15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_za15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_za15ActionPerformed

    private void za77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_za77ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_za77ActionPerformed

    private void ze00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze00ActionPerformed
        try {            
            interfaz.atacar(0, 0, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga(); 
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador); 
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ze00ActionPerformed

    private void ze01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze01ActionPerformed
        try {            
            interfaz.atacar(0, 1, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);            
            mostrarZonaEnemiga();                      
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            this.paintAll(this.getGraphics()); 
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_ze01ActionPerformed

    private void ze02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze02ActionPerformed
        try {            
            interfaz.atacar(0, 2, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }        

            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze02ActionPerformed

    private void ze03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze03ActionPerformed
        try {            
            interfaz.atacar(0, 3, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze03ActionPerformed

    private void ze04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze04ActionPerformed
        try {            
            interfaz.atacar(0, 4, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze04ActionPerformed

    private void ze05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze05ActionPerformed
        try {            
            interfaz.atacar(0, 5, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze05ActionPerformed

    private void ze06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze06ActionPerformed
        try {            
            interfaz.atacar(0, 6, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze06ActionPerformed

    private void ze07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze07ActionPerformed
        try {            
            interfaz.atacar(0, 7, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze07ActionPerformed

    private void ze10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze10ActionPerformed
        try {            
            interfaz.atacar(1, 0, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze10ActionPerformed

    private void ze11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze11ActionPerformed
        try {            
            interfaz.atacar(1, 1, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze11ActionPerformed

    private void ze12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze12ActionPerformed
        try {            
            interfaz.atacar(1, 2, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze12ActionPerformed

    private void ze13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze13ActionPerformed
        try {            
            interfaz.atacar(1, 3, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze13ActionPerformed

    private void ze14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze14ActionPerformed
        try {            
            interfaz.atacar(1, 4, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze14ActionPerformed

    private void ze15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze15ActionPerformed
        try {            
            interfaz.atacar(1, 5, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze15ActionPerformed

    private void ze16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze16ActionPerformed
        try {            
            interfaz.atacar(1, 6, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze16ActionPerformed

    private void ze17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze17ActionPerformed
        try {            
            interfaz.atacar(1, 7, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze17ActionPerformed

    private void ze20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze20ActionPerformed
        try {            
            interfaz.atacar(2, 0, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze20ActionPerformed

    private void ze21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze21ActionPerformed
        try {            
            interfaz.atacar(2, 1, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze21ActionPerformed

    private void ze22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze22ActionPerformed
        try {            
            interfaz.atacar(2, 2, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze22ActionPerformed

    private void ze23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze23ActionPerformed
        try {            
            interfaz.atacar(2, 3, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze23ActionPerformed

    private void ze24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze24ActionPerformed
        try {            
            interfaz.atacar(2, 4, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze24ActionPerformed

    private void ze25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze25ActionPerformed
        try {            
            interfaz.atacar(2, 5, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze25ActionPerformed

    private void ze26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze26ActionPerformed
        try {            
            interfaz.atacar(2, 6, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze26ActionPerformed

    private void ze27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze27ActionPerformed
        try {            
            interfaz.atacar(2, 7, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze27ActionPerformed

    private void ze30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze30ActionPerformed
        try {            
            interfaz.atacar(3, 0, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze30ActionPerformed

    private void ze31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze31ActionPerformed
        try {            
            interfaz.atacar(3, 1, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze31ActionPerformed

    private void ze32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze32ActionPerformed
        try {            
            interfaz.atacar(3, 2, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze32ActionPerformed

    private void ze33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze33ActionPerformed
        try {            
            interfaz.atacar(3, 3, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze33ActionPerformed

    private void ze34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze34ActionPerformed
        try {            
            interfaz.atacar(3, 4, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze34ActionPerformed

    private void ze35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze35ActionPerformed
        try {            
            interfaz.atacar(3, 5, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze35ActionPerformed

    private void ze36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze36ActionPerformed
        try {            
            interfaz.atacar(3, 6, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze36ActionPerformed

    private void ze37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze37ActionPerformed
        try {            
            interfaz.atacar(3, 7, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze37ActionPerformed

    private void ze40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze40ActionPerformed
        try {            
            interfaz.atacar(4, 0, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze40ActionPerformed

    private void ze41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze41ActionPerformed
        try {            
            interfaz.atacar(4, 1, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze41ActionPerformed

    private void ze42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze42ActionPerformed
        try {            
            interfaz.atacar(4, 2, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze42ActionPerformed

    private void ze43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze43ActionPerformed
        try {            
            interfaz.atacar(4, 3, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze43ActionPerformed

    private void ze44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze44ActionPerformed
        try {            
            interfaz.atacar(4, 4, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze44ActionPerformed

    private void ze45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze45ActionPerformed
        try {            
            interfaz.atacar(4, 5, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze45ActionPerformed

    private void ze46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze46ActionPerformed
        try {            
            interfaz.atacar(4, 6, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze46ActionPerformed

    private void ze47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze47ActionPerformed
        try {            
            interfaz.atacar(4, 7, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze47ActionPerformed

    private void ze50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze50ActionPerformed
        try {            
            interfaz.atacar(5, 0, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_ze50ActionPerformed

    private void ze51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze51ActionPerformed
        try {            
            interfaz.atacar(5, 1, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze51ActionPerformed

    private void ze52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze52ActionPerformed
        try {            
            interfaz.atacar(5, 2, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze52ActionPerformed

    private void ze53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze53ActionPerformed
        try {            
            interfaz.atacar(5, 3, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze53ActionPerformed

    private void ze54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze54ActionPerformed
        try {            
            interfaz.atacar(5, 4, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze54ActionPerformed

    private void ze55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze55ActionPerformed
        try {            
            interfaz.atacar(5, 5, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze55ActionPerformed

    private void ze56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze56ActionPerformed
        try {            
            interfaz.atacar(5, 6, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze56ActionPerformed

    private void ze57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze57ActionPerformed
        try {            
            interfaz.atacar(5, 7, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze57ActionPerformed

    private void ze60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze60ActionPerformed
        try {            
            interfaz.atacar(6, 0, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze60ActionPerformed

    private void ze61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze61ActionPerformed
        try {            
            interfaz.atacar(6, 1, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ze61ActionPerformed

    private void ze62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze62ActionPerformed
        try {            
            interfaz.atacar(6, 2, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ze62ActionPerformed

    private void ze63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze63ActionPerformed
        try {            
            interfaz.atacar(6, 3, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ze63ActionPerformed

    private void ze64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze64ActionPerformed
        try {            
            interfaz.atacar(6, 4, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ze64ActionPerformed

    private void ze65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze65ActionPerformed
        try {            
            interfaz.atacar(6, 5, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ze65ActionPerformed

    private void ze66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze66ActionPerformed
        try {            
            interfaz.atacar(6, 6, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ze66ActionPerformed

    private void ze67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze67ActionPerformed
        try {            
            interfaz.atacar(6, 7, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ze67ActionPerformed

    private void ze70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze70ActionPerformed
        try {            
            interfaz.atacar(7, 0, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ze70ActionPerformed

    private void ze71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze71ActionPerformed
        try {            
            interfaz.atacar(7, 1, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze71ActionPerformed

    private void ze72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze72ActionPerformed
        try {            
            interfaz.atacar(7, 2, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze72ActionPerformed

    private void ze73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze73ActionPerformed
        try {            
            interfaz.atacar(7, 3, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze73ActionPerformed

    private void ze74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze74ActionPerformed
        try {            
            interfaz.atacar(7, 4, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze74ActionPerformed

    private void ze75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze75ActionPerformed
        try {            
            interfaz.atacar(7, 5, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze75ActionPerformed

    private void ze76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze76ActionPerformed
        try {            
            interfaz.atacar(7, 6, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze76ActionPerformed

    private void ze77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ze77ActionPerformed
        try {            
            interfaz.atacar(7, 7, nJugador);
            
            tablero2 = interfaz.actualizarZonaEnemiga(nJugador);
            
            mostrarZonaEnemiga();            
            if(interfaz.checkWin(nJugador) == nJugador ){
                JOptionPane.showMessageDialog(null, "GANASTE!", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
            turno = interfaz.cambiarTurno(nJugador);                       
            interfaz.saveState();
            gestionarTurno();
            this.paintAll(this.getGraphics());
            esperarTurno();            
        } catch (RemoteException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VistaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ze77ActionPerformed

    private void za07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_za07ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_za07ActionPerformed

   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel panelTurno;
    private javax.swing.JButton za00;
    private javax.swing.JButton za01;
    private javax.swing.JButton za02;
    private javax.swing.JButton za03;
    private javax.swing.JButton za04;
    private javax.swing.JButton za05;
    private javax.swing.JButton za06;
    private javax.swing.JButton za07;
    private javax.swing.JButton za10;
    private javax.swing.JButton za11;
    private javax.swing.JButton za12;
    private javax.swing.JButton za13;
    private javax.swing.JButton za14;
    private javax.swing.JButton za15;
    private javax.swing.JButton za16;
    private javax.swing.JButton za17;
    private javax.swing.JButton za20;
    private javax.swing.JButton za21;
    private javax.swing.JButton za22;
    private javax.swing.JButton za23;
    private javax.swing.JButton za24;
    private javax.swing.JButton za25;
    private javax.swing.JButton za26;
    private javax.swing.JButton za27;
    private javax.swing.JButton za30;
    private javax.swing.JButton za31;
    private javax.swing.JButton za32;
    private javax.swing.JButton za33;
    private javax.swing.JButton za34;
    private javax.swing.JButton za35;
    private javax.swing.JButton za36;
    private javax.swing.JButton za37;
    private javax.swing.JButton za40;
    private javax.swing.JButton za41;
    private javax.swing.JButton za42;
    private javax.swing.JButton za43;
    private javax.swing.JButton za44;
    private javax.swing.JButton za45;
    private javax.swing.JButton za46;
    private javax.swing.JButton za47;
    private javax.swing.JButton za50;
    private javax.swing.JButton za51;
    private javax.swing.JButton za52;
    private javax.swing.JButton za53;
    private javax.swing.JButton za54;
    private javax.swing.JButton za55;
    private javax.swing.JButton za56;
    private javax.swing.JButton za57;
    private javax.swing.JButton za60;
    private javax.swing.JButton za61;
    private javax.swing.JButton za62;
    private javax.swing.JButton za63;
    private javax.swing.JButton za64;
    private javax.swing.JButton za65;
    private javax.swing.JButton za66;
    private javax.swing.JButton za67;
    private javax.swing.JButton za70;
    private javax.swing.JButton za71;
    private javax.swing.JButton za72;
    private javax.swing.JButton za73;
    private javax.swing.JButton za74;
    private javax.swing.JButton za75;
    private javax.swing.JButton za76;
    private javax.swing.JButton za77;
    private javax.swing.JButton ze00;
    private javax.swing.JButton ze01;
    private javax.swing.JButton ze02;
    private javax.swing.JButton ze03;
    private javax.swing.JButton ze04;
    private javax.swing.JButton ze05;
    private javax.swing.JButton ze06;
    private javax.swing.JButton ze07;
    private javax.swing.JButton ze10;
    private javax.swing.JButton ze11;
    private javax.swing.JButton ze12;
    private javax.swing.JButton ze13;
    private javax.swing.JButton ze14;
    private javax.swing.JButton ze15;
    private javax.swing.JButton ze16;
    private javax.swing.JButton ze17;
    private javax.swing.JButton ze20;
    private javax.swing.JButton ze21;
    private javax.swing.JButton ze22;
    private javax.swing.JButton ze23;
    private javax.swing.JButton ze24;
    private javax.swing.JButton ze25;
    private javax.swing.JButton ze26;
    private javax.swing.JButton ze27;
    private javax.swing.JButton ze30;
    private javax.swing.JButton ze31;
    private javax.swing.JButton ze32;
    private javax.swing.JButton ze33;
    private javax.swing.JButton ze34;
    private javax.swing.JButton ze35;
    private javax.swing.JButton ze36;
    private javax.swing.JButton ze37;
    private javax.swing.JButton ze40;
    private javax.swing.JButton ze41;
    private javax.swing.JButton ze42;
    private javax.swing.JButton ze43;
    private javax.swing.JButton ze44;
    private javax.swing.JButton ze45;
    private javax.swing.JButton ze46;
    private javax.swing.JButton ze47;
    private javax.swing.JButton ze50;
    private javax.swing.JButton ze51;
    private javax.swing.JButton ze52;
    private javax.swing.JButton ze53;
    private javax.swing.JButton ze54;
    private javax.swing.JButton ze55;
    private javax.swing.JButton ze56;
    private javax.swing.JButton ze57;
    private javax.swing.JButton ze60;
    private javax.swing.JButton ze61;
    private javax.swing.JButton ze62;
    private javax.swing.JButton ze63;
    private javax.swing.JButton ze64;
    private javax.swing.JButton ze65;
    private javax.swing.JButton ze66;
    private javax.swing.JButton ze67;
    private javax.swing.JButton ze70;
    private javax.swing.JButton ze71;
    private javax.swing.JButton ze72;
    private javax.swing.JButton ze73;
    private javax.swing.JButton ze74;
    private javax.swing.JButton ze75;
    private javax.swing.JButton ze76;
    private javax.swing.JButton ze77;
    private javax.swing.JPanel zonaAliada;
    private javax.swing.JPanel zonaEnemiga;
    // End of variables declaration//GEN-END:variables


}
