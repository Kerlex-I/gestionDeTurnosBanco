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
public class HiloA extends Thread{
    
    ControladorModulo cm;
    public HiloA( ControladorModulo cm){
        this.cm= cm;  
    }
    
    @Override
    public void run() {
        
        while(true){
            
            cm.abrirModuloAsesor();
            try {
                sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
