/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elker
 */
public class HiloC extends Thread{
    ControladorTurnoProceso ctp;
    
    public HiloC( ControladorTurnoProceso ctp){
        this.ctp= ctp;  
    }
    
    @Override
    public void run() {
        
        while(true){
            
            ctp.mostrarTurnosPantalla();
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
