/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestiondeturnosbanco;

import Controlador.Controlador;
import Modelo.ModelSucursal;
import vista.JFSucursal;

/**
 *
 * @author elker
 */
public class GestionDeTurnosBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        ModelSucursal ms = new ModelSucursal();
        JFSucursal vs = new JFSucursal();
        Controlador ctr = new Controlador(vs, ms);
        
        ctr.iniciar();
        vs.setVisible(true);
        
        
        
    }
    
}
