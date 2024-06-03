/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
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
    ControladorTurno ct = new ControladorTurno();

    public ControladorModulo() {
    }
    
    public void abrirModuloCaja(){
        empleadoc.limpiarTabla();
        Turno t = new Turno();
        ArrayList<Turno> turnos = t.listarEnTablaCaja();
        
        for(Turno turn: turnos){
            String datos[] = {String.valueOf(turn.getId_turno()), turn.getUsuario().getCedula(), turn.getTipo_tramite(), String.valueOf(turn.getTiempo_espera()), turn.getLetra() + String.valueOf(turn.getNumero())};
            empleadoc.agregarFila(datos);
        }
    }
    public void abrirModuloAsesor(){
        empleadoa.limpiarTabla();
        Turno t = new Turno();
        ArrayList<Turno> turnos = t.listarEnTablaAsesor();
        
        for(Turno turn: turnos){
            String datos[] = {String.valueOf(turn.getId_turno()), turn.getUsuario().getCedula(), turn.getTipo_tramite(), String.valueOf(turn.getTiempo_espera()), turn.getLetra() + String.valueOf(turn.getNumero())};
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
  
    public void llamarTurnoCaja(){
        
        if(empleadoc.hayDatos()){
            ct.actualizarEstado(empleadoc.getIdDeTabla());
            String turno;
            String tramite;
        
            turno = empleadoc.getTurnoTabla();
            empleadoc.setLblTurnoActual(turno);
            tramite = empleadoc.getTramiteTabla();
            empleadoc.setLblTramiteActual(tramite);
        }else{
            JOptionPane.showMessageDialog(empleadoc, "No hay turnos en fila", "Error", 0);
        }
 
    }
    public void llamarTurnoAsesor(){
        
        if(empleadoa.hayDatos()){
            ct.actualizarEstado(empleadoa.getIdDeTabla());
            String turno;
            String tramite;
        
            turno = empleadoa.getTurnoTabla();
            empleadoa.setLblTurnoActual(turno);
            tramite = empleadoa.getTramiteTabla();
            empleadoa.setLblTramiteActual(tramite);
        }else{
            JOptionPane.showMessageDialog(empleadoc, "No hay turnos en fila", "Error", 0);
        }
        
        
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
