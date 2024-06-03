/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Empleado;
import modelo.Modulo;
import vista.JFLogin;
/**
 *
 * @author elker
 */
public class ControladorLogin {
    JFLogin login;

    public ControladorLogin() {
    }
    
    public boolean validarInicioSesion(){
        
          Empleado encontrarEmpleado = retornarEmpleadoIniciado();
 
        return encontrarEmpleado != null;        
    }
    
    public Empleado retornarEmpleadoIniciado(){
        Empleado empleado = new Empleado();
        String credencial = login.getCredencial();
        String contrasena = login.getContrasena();
        Empleado encontrarEmpleado = empleado.encontrarEmpleado(credencial, contrasena);
        
        return encontrarEmpleado;
    }    
    
    public String retornarTipoDeModulo(){
        Modulo modulo = new Modulo();
        Empleado encontrarEmpleado = retornarEmpleadoIniciado();
        String idModulo = String.valueOf(encontrarEmpleado.getModulo());
        String tipoModulo = modulo.retornarTipoModulo(idModulo);
        
        return tipoModulo;
    }
    public JFLogin getJFLogin(){
        return login;
    }
    public void setJFLogin(JFLogin login){
        this.login = login;
    }
}
