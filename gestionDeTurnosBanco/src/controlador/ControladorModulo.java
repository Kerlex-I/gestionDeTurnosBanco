/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import vista.JFEmpleado;
import vista.JFEmpleadoA;
import modelo.Turno;

/**
 *
 * @author elker
 */
public class ControladorModulo {
    
    JFEmpleado empleadoc;
    JFEmpleadoA empleadoa;

    public ControladorModulo() {
    }
    
    public void abrirModuloCaja(){
        empleadoc.limpiarTabla();
        Turno t = new Turno();
        ArrayList<Turno> turnos = t.listarEnTablaCaja();
        
        for(Turno turn: turnos){
            String datos[] = {turn.getUsuario().getCedula(), turn.getTipo_tramite(), String.valueOf(turn.getTiempo_espera())};
            empleadoc.agregarFila(datos);
        }
    }
    public void abrirModuloAsesor(){
        empleadoa.limpiarTabla();
        Turno t = new Turno();
        ArrayList<Turno> turnos = t.listarEnTablaAsesor();
        
        for(Turno turn: turnos){
            String datos[] = {turn.getUsuario().getCedula(), turn.getTipo_tramite(), String.valueOf(turn.getTiempo_espera())};
            empleadoa.agregarFila(datos);
        }
    }
    
    public void mostrarTurnosC(){
        Hilo hilo = new Hilo(this);
        hilo.start();
    }
    
    public void mostrarTurnosA(){
        HiloA hilo = new HiloA(this);
        hilo.start();
    }
    
    public JFEmpleado getJFEmpleado(){
        return empleadoc;
    }
    public void setJFEmpleado(JFEmpleado empleado){
        this.empleadoc = empleado;
    }
    public JFEmpleadoA getJFEmpleadoA(){
        return empleadoa;
    }
    public void setJFEmpleadoA(JFEmpleadoA empleadoa){
        this.empleadoa = empleadoa;
    }
}
