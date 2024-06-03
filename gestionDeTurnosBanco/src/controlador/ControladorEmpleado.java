/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.ArrayList;
import modelo.Turno;
import modelo.Empleado;
import vista.JFEmpleado;
/**
 *
 * @author elker
 */
public class ControladorEmpleado {
    
    JFEmpleado empleado;
    
    public ControladorEmpleado(){
        
    }
    
    public JFEmpleado getJFEmpleado(){
        return empleado;
    }
    public void setJFEmpleado(JFEmpleado empleado){
        this.empleado = empleado;
    }
    
}
