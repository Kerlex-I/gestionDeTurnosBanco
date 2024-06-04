/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.ArrayList;
import vista.JFPantalla;
import modelo.TurnoProceso;
/**
 *
 * @author elker
 */
public class ControladorTurnoProceso {
    
    JFPantalla pantalla;
    
    public ControladorTurnoProceso() {
    }
    
    public void mostrarTurnosPantalla(){
        pantalla.limpiarTabla();
        
        TurnoProceso tp = new TurnoProceso();
        ArrayList<TurnoProceso> turnos = tp.mostrarPantalla();
        
        for(TurnoProceso turn: turnos){
            String datos[] = {String.valueOf(turn.getId_turno()),String.valueOf(turn.getId_modulo())};
            pantalla.agregarFila(datos);
        }
        
    }
    public void mostrar(){
        HiloC hilo = new HiloC(this);
        hilo.start();
    }
    public JFPantalla getJFPantalla(){
        return pantalla;
    }
    public void setJFPantalla(JFPantalla pantalla){
        this.pantalla = pantalla;
    }
}
