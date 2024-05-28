/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Sucursal;
import modelo.Usuario;
import vista.JFTramite;
/**
 *
 * @author elker
 */
public class ControladorSucursal {
    
    JFTramite tramite;
    
    public ControladorSucursal(){
        
    }
    
    public void sucursalSeleccionada(Usuario user){
        
        
        Sucursal sucursal = new Sucursal();
        String ciudad = tramite.getSucursal();
        
        int idSucursal = sucursal.retornarIDSucursal(ciudad);
        String direccion = sucursal.retornarDireccionSucursal(ciudad);
        
        sucursal.setCiudad(ciudad);
        sucursal.setDireccion(direccion);
        sucursal.setId_sucursal(idSucursal);
        
        user.actualizarIDUsuario(sucursal.getId_sucursal(), user.getCedula());
        
    }
    
    public JFTramite getJFtramite(){
        return tramite;
    }
    public void setJFtramite(JFTramite tramite){
        this.tramite = tramite;
    }
    
    
    
}
