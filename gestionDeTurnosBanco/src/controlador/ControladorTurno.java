/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Turno;
import modelo.Usuario;
import vista.JFDatosPersonales;
import vista.JFTramite;
import java.util.HashMap;

/**
 *
 * @author elker
 */
public class ControladorTurno {
    

    JFTramite tramite;
    JFDatosPersonales datospersonales;
    ControladorUsuario cu;
    ArrayList<String> tipoTramite = new ArrayList<>();
    public static HashMap<String, Integer> numeros = new HashMap<>();
//    public final int[] numero = {0,0,0,0,0,0,0};
//    ArrayList<Integer> numero = new ArrayList<>();
    
    public ControladorTurno(){
      
        tipoTramite.add("A");
        tipoTramite.add("B");
        tipoTramite.add("C");
        tipoTramite.add("D");
        tipoTramite.add("E");
        tipoTramite.add("F");
        tipoTramite.add("G");
        
        Turno consultar = new Turno();
        
        consultar.cargarPrioridades(numeros);
        consultar.cargarTramites(numeros);
        
    }
    
    public Turno crearTurno(Usuario usuario){        
        
        Turno turnito = new Turno();
        String tipo_tramite = "";
        String prioridad = "";
        
        prioridad = usuario.getPrioridad();
        
        tipo_tramite = tramite.getTramite();
                       
        int index;
        int numerito = 0;
        int turnoActual = 0;
        
        String tipo = "";
        if("Tramites en caja".equals(tipo_tramite)){
            if(prioridad == "Tercera edad" || prioridad == "Embarazo"){
                index = 0;
                tipo = tipoTramite.get(index);
                if(!numeros.containsKey("Embarazo")){
                    numeros.put("Embarazo", 0);
                    turnoActual = numeros.get("Embarazo");
                }
                else{
                    numerito = numeros.get("Embarazo") + 1;
                    numeros.put("Embarazo", numerito);
                    turnoActual = numeros.get("Embarazo");
                }
                
            }
            else if("Discapacidad".equals(prioridad)){
                index = 1;
                tipo = tipoTramite.get(index);
                if(!numeros.containsKey("Discapacidad")){
                    numeros.put("Discapacidad", 0);
                    turnoActual = numeros.get("Discapacidad");
                }
                else{
                    numerito = numeros.get("Discapacidad") + 1;
                    numeros.put("Discapacidad", numerito);
                    turnoActual = numeros.get("Discapacidad");
                }
//                
            }
            else if("Ninguno".equals(prioridad)){
                index = 2;
                tipo = tipoTramite.get(index);
                if(!numeros.containsKey("Ninguno")){
                    numeros.put("Ninguno", 0);
                    turnoActual = numeros.get("Ninguno");
                }
                else{
                    numerito = numeros.get("Ninguno") + 1;
                    numeros.put("Ninguno", numerito);
                    turnoActual = numeros.get("Ninguno");
                }
            }
        }
        else if("Sacar un producto".equals(tipo_tramite)){
            index = 3;
            tipo = tipoTramite.get(index);
            if(!numeros.containsKey("Sacar un producto")){
                numeros.put("Sacar un producto", 0);
                turnoActual = numeros.get("Sacar un producto");
            }
            else{
                numerito = numeros.get("Sacar un producto") + 1;
                numeros.put("Sacar un producto", numerito);
                turnoActual = numeros.get("Sacar un producto");
            }
        }
        else if("Ayuda con tus productos".equals(tipo_tramite)){
            index = 4;
            tipo = tipoTramite.get(index);
            if(!numeros.containsKey("Ayuda con tus productos")){
                numeros.put("Ayuda con tus productos", 0);
                turnoActual = numeros.get("Ayuda con tus productos");
            }
            else{
                numerito = numeros.get("Ayuda con tus productos") + 1;
                numeros.put("Ayuda con tus productos", numerito);
                turnoActual = numeros.get("Ayuda con tus productos");
            }
            
        }
        else if("Cancela un producto".equals(tipo_tramite)){
            index = 5;
            tipo = tipoTramite.get(index);
            if(!numeros.containsKey("Cancela un producto")){               
                numeros.put("Embarazo", 0);
                turnoActual = numeros.get("Cancela un producto");
            }
            else{
                numerito = numeros.get("Cancela un producto") + 1;
                numeros.put("Cancela un producto", numerito);
                turnoActual = numeros.get("Cancela un producto");
            }
        }
        else{
            index = 6;
            tipo = tipoTramite.get(index);
            if(!numeros.containsKey("Pedir documentos")){               
                numeros.put("Embarazo", 0);
                turnoActual = numeros.get("Pedir documentos");
            }
            else{
                numerito = numeros.get("Pedir documentos") + 1;
                numeros.put("Pedir documentos", numerito);
                turnoActual = numeros.get("Pedir documentos");
            }
        }
        
        
        turnito.setLetra(tipo);
        turnito.setNumero(turnoActual);
        turnito.setTipo_tramite(tipo_tramite);
        turnito.setUsuario(usuario);
        turnito.setEstado(true);
        turnito.setHora_solicitud("03:51");
        turnito.setEstado(false);
        turnito.setPrioridad(usuario.getPrioridad());
        
        usuario.crearUsuario();
        turnito.crearTurno();
        
        return turnito;
    }
    
    public JFDatosPersonales getJFdatos_personales(){
        return datospersonales;
    }
    
    public void setJFdatos_personales(JFDatosPersonales datospersonales){
        this.datospersonales = datospersonales;
    }
    
    public JFTramite getJFtramite(){
        return tramite;
    }
    public void setJFtramite(JFTramite tramite){
        this.tramite = tramite;
    }
}
