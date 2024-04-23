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
            numero.add(0);
        }
        
    }
    
    public Turno crearTurno(Usuario usuario, String tipo_tramite){
        

        String letra;
        
        letra = asignarLetra(tipo_tramite, usuario.getPrioridad());
        
        return null;
    }
    
    public String asignarLetra(String tipo_tramite, String prioridad){
        String tipo = "";
        if("tramite en caja".equals(tipo_tramite)){
            if(prioridad == "Tercera edad" && prioridad == "Preñada"){
                tipo = tipoTramite.get(0);
            }
            else if("Manquito".equals(prioridad)){
                tipo = tipoTramite.get(1);
            }
            else if("Ninguno".equals(prioridad)){
                tipo = tipoTramite.get(2);
            }
        }
        else if("Sacar un producto".equals(tipo_tramite)){
            tipo = tipoTramite.get(3);
        }
        else if("Ayuda con tus productos".equals(tipo_tramite)){
            tipo = tipoTramite.get(4);
        }
        else if("Cancela un producto".equals(tipo_tramite)){
            tipo = tipoTramite.get(5);
        }
        else{
            tipo = tipoTramite.get(6);
        }
              
        return tipo;
    }
    
    
}
