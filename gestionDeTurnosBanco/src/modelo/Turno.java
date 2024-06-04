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
    
    int id_turno;
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

    public Turno(int id_turno, Usuario usuario, String tipo_tramite, int numero, String letra, String estado, String hora_solicitud, int tiempo_espera, String prioridad) {
        this.id_turno = id_turno;
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

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }
    
    // Inserta un turno solicitado en la base de datos
    public void crearTurno(){
    Conexion c = new Conexion();
    c.ejecutar("insert into turno (cc_cliente,tipo_tramite,numero,letra,estado,hora_solicitud,prioridad)values('"+usuario.getCedula()+ "','" + tipo_tramite + "'," +numero+",'"+letra+"','"+estado+"','"+hora_solicitud+ "','" + prioridad + "');");
    c.cerrarSesion();
    
    }
    
    //Carga los turnos ya generados en la base de datos
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
        c.cerrarSesion();
    }
    // Muestra los datos en el modulo de Caja
    public ArrayList<Turno> listarEnTablaCaja(){
        
        String sql = "SELECT id_turno,cc_cliente,tipo_tramite,tiempo_espera,numero,letra FROM turno WHERE tipo_tramite = 'Tramites en caja' and estado = 'Pendiente'";
        ArrayList<Turno> turnos = new ArrayList<>();
        Conexion c = new Conexion();
        ResultSet rs = c.ejecutarConsulta(sql);
        
        try {
            while(rs.next()){
                Turno t = new Turno();
                t.setId_turno(rs.getInt("id_turno"));
                Usuario u = new Usuario();
                t.setUsuario(u);
                u.setCedula(rs.getString("cc_cliente"));
                t.setTipo_tramite(rs.getString("tipo_tramite"));
                t.setTiempo_espera(rs.getInt("tiempo_espera"));
                t.setLetra(rs.getString("letra"));
                t.setNumero(rs.getInt("numero"));          
                
                turnos.add(t);                
            }
            
        } catch (java.sql.SQLException e) {
        }
        c.cerrarSesion();
        return turnos;        
    }
    // Muestra los turnos en el modulo de Asesor
    public ArrayList<Turno> listarEnTablaAsesor(){
        
        String sql = "SELECT id_turno,cc_cliente,tipo_tramite,tiempo_espera,numero,letra FROM turno WHERE tipo_tramite != 'Tramites en caja' and estado = 'Pendiente'";
        ArrayList<Turno> turnos = new ArrayList<>();
        Conexion c = new Conexion();
        ResultSet rs = c.ejecutarConsulta(sql);
        
        try {
            while(rs.next()){
                Turno t = new Turno();
                Usuario u = new Usuario();
                t.setId_turno(rs.getInt("id_turno"));
                t.setUsuario(u);
                u.setCedula(rs.getString("cc_cliente"));
                t.setTipo_tramite(rs.getString("tipo_tramite"));
                t.setTiempo_espera(rs.getInt("tiempo_espera"));
                t.setLetra(rs.getString("letra"));
                t.setNumero(rs.getInt("numero"));              
                
                turnos.add(t);                
            }
        } catch (java.sql.SQLException e) {
        }
        c.cerrarSesion();
        return turnos;        
    }
    
    // Actualiza un estado del turno
    public void actualizarEstadoTurno(){
        Conexion c = new Conexion();
        c.ejecutar("UPDATE turno SET estado = '"+ this.estado + "' WHERE id_turno="+this.id_turno);
        c.cerrarSesion();
    }
    
    public void actualizarTramite(){
        Conexion c = new Conexion();
        c.ejecutar("UPDATE turno SET tipo_tramite = '"+ this.tipo_tramite + "' WHERE id_turno="+this.id_turno);
        c.cerrarSesion();
    }
    
    // Nos retorna un estado de cualquier turno cuando sea necesario
    public String retornarEstadoTurno(){
        Conexion c = new Conexion();
        String estadoTurno = null;
        String sql = "SELECT estado FROM turno WHERE id_turno = " + this.id_turno;
        ResultSet rs = c.ejecutarConsulta(sql);
        
        try {
            while(rs.next()){
                estadoTurno = rs.getString("estado");
            }        
        } catch (java.sql.SQLException e) {
        }
        
        c.cerrarSesion();
        return estadoTurno;
    }
    public int calcularPromedio(){
        Conexion c = new Conexion();
        int promedio = 0;
        ArrayList<Integer> tiempos = new ArrayList<>();
        String sql = "SELECT tiempo_espera FROM turno WHERE tiempo_espera != null;";
        ResultSet rs = c.ejecutarConsulta(sql);
        int count = 0;
        
        try {
            while(rs.next()){
                promedio = rs.getInt("tiempo_espera");
                tiempos.add(promedio);
                count++;
            }        
        } catch (java.sql.SQLException e) {
        }
        
        
        return promedio;
    }
    

    @Override
    public String toString() {
        return "Turno{" + "id_turno=" + id_turno + ", usuario=" + usuario + ", tipo_tramite=" + tipo_tramite + ", numero=" + numero + ", letra=" + letra + ", estado=" + estado + ", hora_solicitud=" + hora_solicitud + ", tiempo_espera=" + tiempo_espera + ", prioridad=" + prioridad + '}';
    }    
}
