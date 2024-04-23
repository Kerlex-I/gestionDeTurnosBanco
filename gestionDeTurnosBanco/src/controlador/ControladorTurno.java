/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Turno;
import modelo.Usuario;
import vista.JFTramite;

/**
 *
 * @author elker
 */
public class ControladorTurno {
    
    JFTramite tramite;
    
    ArrayList<String> tipoTramite = new ArrayList<>();
    ArrayList<Integer> numero = new ArrayList<>();
    
    public ControladorTurno(){
        tipoTramite.add("A");
        tipoTramite.add("B");
        tipoTramite.add("C");
        tipoTramite.add("D");
        tipoTramite.add("E");
        tipoTramite.add("F");
        tipoTramite.add("G");
        
        for(int i = 0; i < 7; i++){
            numero.add(-1);
        }
        
    }
    
    public Turno crearTurno(Usuario usuario, String tipo_tramite, String prioridad){
        
        Turno turnito = new Turno();
                
        int index;
        int numerito = 0;
        
        String tipo = "";
        if("Tramites en caja".equals(tipo_tramite)){
            if(prioridad == "Tercera edad" || prioridad == "Embarazo"){
                index = 0;
                tipo = tipoTramite.get(index);
                numerito = numero.get(index) + 1;
                
            }
            else if("Discapacidad".equals(prioridad)){
                index = 1;
                tipo = tipoTramite.get(index);
                numerito = numero.get(index) + 1;
            }
            else if("Ninguno".equals(prioridad)){
                index = 2;
                tipo = tipoTramite.get(index);
                numerito = numero.get(index) + 1;
            }
        }
        else if("Sacar un producto".equals(tipo_tramite)){
            index = 3;
            tipo = tipoTramite.get(index);
            numerito = numero.get(index) + 1;
        }
        else if("Ayuda con tus productos".equals(tipo_tramite)){
            index = 4;
            tipo = tipoTramite.get(index);
            numerito = numero.get(index) + 1;
            
        }
        else if("Cancela un producto".equals(tipo_tramite)){
            index = 5;
            tipo = tipoTramite.get(index);
            numerito = numero.get(index) + 1;
        }
        else{
            index = 6;
            tipo = tipoTramite.get(index);
            numerito = numero.get(index) + 1;
        }
        
        turnito.setLetra(tipo);
        turnito.setNumero(numerito);
        turnito.setTipo_tramite(tipo_tramite);
        turnito.setUsuario(usuario);
        turnito.setEstado(true);
        return turnito;
    }
    
}
