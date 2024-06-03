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
    
    public void mostrarTurnos(){
        empleado.limpiarTabla();
        Turno t = new Turno();
        ArrayList<Turno> turnos = t.listarEnTabla();
        
        for(Turno turn : turnos){
            String datos[] = {turn.getUsuario().getCedula(), turn.getTipo_tramite(), String.valueOf(turn.getTiempo_espera())};
            empleado.agregarFila(datos);
        }
    }
    
    
    
    public JFEmpleado getJFEmpleado(){
        return empleado;
    }
    public void setJFEmpleado(JFEmpleado empleado){
        this.empleado = empleado;
    }
    
}
