/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import vista.JFDatosPersonales;
import vista.JFTramite;


/**
 *
 * @author elker
 */
public class ControladorUsuario {
    JFDatosPersonales datospersonales;
    
    public ControladorUsuario(){
        
    }
    
    public void crearUsuario(){
        Usuario usuario = new Usuario();
        
        usuario.setCedula(datospersonales.getCedula());
        usuario.setPrioridad(datospersonales.getPrioridad());
        usuario.setTelefono(datospersonales.getCelular());
        
        
        JFTramite tramite = new JFTramite(usuario);
        tramite.setVisible(true);       
    }
    
    public JFDatosPersonales getJFdatos_personales(){
        return datospersonales;
    }
    
    public void setJFdatos_personales(JFDatosPersonales datospersonales){
        this.datospersonales = datospersonales;
    }
    
    
}
