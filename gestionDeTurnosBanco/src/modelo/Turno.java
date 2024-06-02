/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.time.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author elker
 */
public class Turno {
    
    Usuario usuario;
    String tipo_tramite;
    int numero;
    String letra;
    String estado;
    String hora_solicitud;
    int tiempo_espera;
    String prioridad;

    public Turno() {
    }

    public Turno(Usuario usuario, String tipo_tramite, int numero, String letra, String estado, String hora_solicitud, int tiempo_espera, String prioridad) {
        this.usuario = usuario;
        this.tipo_tramite = tipo_tramite;
        this.numero = numero;
        this.letra = letra;
        this.estado = estado;
        this.hora_solicitud = hora_solicitud;
        this.tiempo_espera = tiempo_espera;
        this.prioridad = prioridad;
    }

    


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipo_tramite() {
        return tipo_tramite;
    }

    public void setTipo_tramite(String tipo_tramite) {
        this.tipo_tramite = tipo_tramite;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String isEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getHora_solicitud() {
        return hora_solicitud;
    }

    public void setHora_solicitud(String hora_solicitud) {
        this.hora_solicitud = hora_solicitud;
    }

    public int getTiempo_espera() {
        return tiempo_espera;
    }

    public void setTiempo_espera(int tiempo_espera) {
        this.tiempo_espera = tiempo_espera;
        
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    
 
    public void crearTurno(){
    Conexion c = new Conexion();
    c.ejecutar("insert into turno (cc_cliente,tipo_tramite,numero,letra,estado,hora_solicitud,prioridad)values('"+usuario.getCedula()+ "','" + tipo_tramite + "'," +numero+",'"+letra+"','"+estado+"','"+hora_solicitud+ "','" + prioridad + "');");
    
    }
    
    public void cargarPrioridades(HashMap<String, Integer> numeros){
        String sql = "SELECT" +
"    CASE" +
"        WHEN prioridad IN ('Embarazo', 'Tercera edad') THEN 'Embarazo'" +
"        ELSE prioridad" +
"    END as prioridad_agrupada, " +
"    COUNT(*) as count " +
"FROM turno " +
"WHERE tipo_tramite = 'Tramites en caja'" +
"GROUP BY prioridad_agrupada;";
        Conexion c = new Conexion();
        ResultSet rs= c.ejecutarConsulta(sql);       
        try{
            while(rs.next()){
                String c_prioridad = rs.getString("prioridad_agrupada");
                int count = rs.getInt("count");
                numeros.put(c_prioridad, count);
            }
        }catch(java.sql.SQLException e){
        }
    }
    public void cargarTramites(HashMap<String, Integer> numeros){
        String sql = "SELECT tipo_tramite, COUNT(*) as count FROM turno WHERE tipo_tramite != 'Tramites en caja' GROUP BY tipo_tramite";
        Conexion c = new Conexion();
        ResultSet rs= c.ejecutarConsulta(sql);       
        try{
            while(rs.next()){
                String tramite = rs.getString("tipo_tramite");
                int count = rs.getInt("count");
                numeros.put(tramite, count);
            }
        }catch(java.sql.SQLException e){
        }
    }
    
    public ArrayList<Turno> listarEnTabla(){
        
        String sql = "SELECT cc_cliente,tipo_tramite,tiempo_espera FROM turno";
        ArrayList<Turno> turnos = new ArrayList<>();
        Conexion c = new Conexion();
        ResultSet rs = c.ejecutarConsulta(sql);
        
        try {
            while(rs.next()){
                Turno t = new Turno();
                Usuario u = new Usuario();
                t.setUsuario(u);
                u.setCedula(rs.getString("cc_cliente"));
                t.setTipo_tramite(rs.getString("tipo_tramite"));
                t.setTiempo_espera(rs.getInt("tiempo_espera"));
                
                turnos.add(t);                
            }
            
        } catch (java.sql.SQLException e) {
        }
        
        return turnos;
        
    }
    @Override
    public String toString() {
        return "Turno{" + "usuario=" + usuario.toString() + ", tipo_tramite=" + tipo_tramite + ", numero=" + numero + ", letra=" + letra + ", estado=" + estado + ", hora_solicitud=" + hora_solicitud + ", tiempo_espera=" + tiempo_espera + '}';
    }
    
    
}
