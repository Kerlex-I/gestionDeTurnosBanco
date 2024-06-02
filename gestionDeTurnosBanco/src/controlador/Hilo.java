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
public class Hilo extends Thread{
    
    ControladorEmpleado ce;
    public Hilo( ControladorEmpleado ce){
        this.ce= ce;
        
    }
    
    @Override
    public void run() {
        
        while(true){
            
            ce.mostrarTurnos();
            try {
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
