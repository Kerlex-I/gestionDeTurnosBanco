/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Empleado;
import vista.JFCRUDEmpleado;
/**
 *
 * @author elker
 */
public class ControladorEmpleado {
    
    JFCRUDEmpleado empleado;
    
    public ControladorEmpleado(){
        
    }
    
    public void registrarEmpleado(){
        
        Empleado e = new Empleado();
        
        e.setNombre(this.empleado.getNombre());
        e.setContrasena(this.empleado.getContrasena());
        e.setModulo(this.empleado.getModulo());
        e.setSucursal(this.empleado.getSucursal());
        e.setCredencial(this.empleado.getCredencial());
        
        e.registrarEmpleado();
    }
    
    public void buscarEmpleado(){
        
        Empleado e = new Empleado();
        e = e.buscarEmpleado(empleado.getTxtIngresoCredencial());
        
        if(e != null){
            empleado.setNombre(e.getNombre());
            empleado.setContrasena(e.getContrasena());
            empleado.setModulo(e.getModulo());
            empleado.setSucursal(e.getSucursal());
            empleado.setCredencial(e.getCredencial());
            
        }else{
            JOptionPane.showMessageDialog(empleado, "Usuario no encontrado", "Error", 0);
        }
    }
    public boolean validarEmpleado(){
        Empleado e = new Empleado();
        e = e.buscarEmpleado(empleado.getTxtIngresoCredencial());
        
        return e != null;
    }
    public void actualizarEmpleado(String credencial){
        
        Empleado e = new Empleado();
        
        e.setCredencial(credencial);
        e.setNombre(this.empleado.getNombre());
        e.setContrasena(this.empleado.getContrasena());
        e.setModulo(this.empleado.getModulo());
        e.setSucursal(this.empleado.getSucursal());
        e.actualizarEmpleado();
    }
    public void eliminarEmpleado(){
        Empleado e = new Empleado();
        
        e.setCredencial(empleado.getTxtIngresoCredencial());
        e.eliminarEmpleado();
    }
    public JFCRUDEmpleado getFCRUDEmpleado(){
        return empleado;
    }
    public void setFCRUDEmpleado(JFCRUDEmpleado empleado){
        this.empleado = empleado;
    }
    
}
