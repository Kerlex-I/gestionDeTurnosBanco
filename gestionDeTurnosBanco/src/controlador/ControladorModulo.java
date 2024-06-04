/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.JFEmpleado;
import vista.JFEmpleadoA;
import vista.JFTraslado;
import modelo.Turno;
import modelo.TurnoProceso;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author elker
 */
public class ControladorModulo {
    
    JFEmpleado empleadoc;
    JFEmpleadoA empleadoa;
    JFTraslado traslado;
    ControladorTurno ct = new ControladorTurno();
    LocalTime tiempo;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

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
  
    public void llamarTurnoCaja(int modulo){
        
        if(empleadoc.hayDatos()){
            String turno;
            String tramite;
            int idTabla;
            TurnoProceso turnoProceso = new TurnoProceso();
            String horaFormateada;
        
            tiempo = LocalTime.now();
            horaFormateada = tiempo.format(formato);
            
            idTabla = empleadoc.getIdDeTabla();
            ct.actualizarEstado(idTabla);
            
            turno = empleadoc.getTurnoTabla();
            empleadoc.setLblTurnoActual(turno);
            tramite = empleadoc.getTramiteTabla();
            empleadoc.setLblTramiteActual(tramite);
            
            turnoProceso.setId_turno(idTabla);
            turnoProceso.setId_modulo(modulo);
            turnoProceso.setHora_proceso(horaFormateada);
            
            turnoProceso.crearTurnoProceso();
        }else{
            JOptionPane.showMessageDialog(empleadoc, "No hay turnos en fila", "Error", 0);
        }
 
    }
    public void llamarTurnoAsesor(int modulo){
        
        if(empleadoa.hayDatos()){
            
            String turno;
            String tramite;
            int idTabla;
            TurnoProceso turnoProceso = new TurnoProceso();
            String horaFormateada;
        
            tiempo = LocalTime.now();
            horaFormateada = tiempo.format(formato);
            
            idTabla = empleadoa.getIdDeTabla();
            ct.actualizarEstado(idTabla);
            
        
            turno = empleadoa.getTurnoTabla();
            empleadoa.setLblTurnoActual(turno);
            tramite = empleadoa.getTramiteTabla();
            empleadoa.setLblTramiteActual(tramite);
            
            turnoProceso.setId_turno(idTabla);
            turnoProceso.setId_modulo(modulo);
            turnoProceso.setHora_proceso(horaFormateada);
            
            turnoProceso.crearTurnoProceso();            
        }else{
            JOptionPane.showMessageDialog(empleadoc, "No hay turnos en fila", "Error", 0);
        }        
    }
    
    public void trasladarTurno(int modulo){
        
        TurnoProceso turnoProceso = new TurnoProceso();
        int id_turno;
        String tramite;
        
        
        tramite = traslado.getTramite();
        turnoProceso.setId_modulo(modulo);
        id_turno = turnoProceso.retornarUltimoTurnoProceso();
        ct.actualizarEstado(id_turno);
        
        ct.actualizarTramite(id_turno, tramite);
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
    public JFTraslado getJFTraslado(){
        return traslado;
    }
    public void setJFTraslado(JFTraslado traslado){
        this.traslado = traslado;
    }
}
