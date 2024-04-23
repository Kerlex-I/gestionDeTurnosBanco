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
    
//    public Turno crearTurno(Usuario usuario, String tipo_tramite){
//        
//        Turno turnito = new Turno();
//        
//
//        String letra;
//        
//        letra = asignarLetra(tipo_tramite, usuario.getPrioridad());
//        turnito.setLetra(letra);
//        
//        
//        
//        
//        
//        return null;
//    }
//    
//    public String asignarLetra(String tipo_tramite, String prioridad){
//        String tipo = "";
//        if("tramite en caja".equals(tipo_tramite)){
//            if(prioridad == "Tercera edad" && prioridad == "Preñada"){
//                tipo = tipoTramite.get(0);
//            }
//            else if("Manquito".equals(prioridad)){
//                tipo = tipoTramite.get(1);
//            }
//            else if("Ninguno".equals(prioridad)){
//                tipo = tipoTramite.get(2);
//            }
//        }
//        else if("Sacar un producto".equals(tipo_tramite)){
//            tipo = tipoTramite.get(3);
//        }
//        else if("Ayuda con tus productos".equals(tipo_tramite)){
//            tipo = tipoTramite.get(4);
//        }
//        else if("Cancela un producto".equals(tipo_tramite)){
//            tipo = tipoTramite.get(5);
//        }
//        else{
//            tipo = tipoTramite.get(6);
//        }
//              
//        return tipo;
//    }
//    
//    public int asignarNumero(String tipo){
//        
//        int numero = 0;
//        
//        
//        return numero;
//    }
    
    public Turno crearTurno(Usuario usuario, String tipo_tramite, String prioridad){
        
        Turno turnito = new Turno();
                
        int index = 0;
        int numerito = 0;
        
        String tipo = "";
        if("tramite en caja".equals(tipo_tramite)){
            if(prioridad == "Tercera edad" || prioridad == "Preñada"){
                index = 0;
                tipo = tipoTramite.get(index);
                numerito = numero.get(index) + 1;
                
            }
            else if("Manquito".equals(prioridad)){
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
            numerito = numero.get(index);
        }
        
        turnito.setLetra(tipo);
        turnito.setNumero(numerito);
        turnito.setTipo_tramite(tipo_tramite);
        turnito.setUsuario(usuario);
        turnito.setEstado(true);
        return turnito;
    }
    
}
