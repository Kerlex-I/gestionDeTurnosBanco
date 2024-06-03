/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.JFEmpleado;
import vista.JFEmpleadoA;

/**
 *
 * @author elker
 */
public class ControladorModulo {
    
    JFEmpleado empleado;
    JFEmpleadoA empleadoa;

    public ControladorModulo() {
    }
    
    public void abrirModuloCaja(){
        
    }
    public void abrirModuloAsesor(){
        
    }
    
    public JFEmpleado getJFEmpleado(){
        return empleado;
    }
    public void setJFEmpleado(JFEmpleado empleado){
        this.empleado = empleado;
    }
    public JFEmpleadoA getJFEmpleadoA(){
        return empleadoa;
    }
    public void setJFEmpleadoA(JFEmpleadoA empleadoa){
        this.empleadoa = empleadoa;
    }
}
