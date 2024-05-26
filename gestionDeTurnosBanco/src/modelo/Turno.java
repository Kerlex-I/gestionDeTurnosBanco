/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.*;
import java.util.Date;
import java.sql.Timestamp;
/**
 *
 * @author elker
 */
public class Turno {
    
    Usuario usuario;
    String tipo_tramite;
    int numero;
    String letra;
    boolean estado;
    String hora_solicitud;
    int tiempo_espera;

    public Turno() {
    }

    public Turno(Usuario usuario, String tipo_tramite, int numero, String letra, boolean estado, String hora_solicitud, int tiempo_espera) {
        this.usuario = usuario;
        this.tipo_tramite = tipo_tramite;
        this.numero = numero;
        this.letra = letra;
        this.estado = estado;
        this.hora_solicitud = hora_solicitud;
        this.tiempo_espera = tiempo_espera;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
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
    
    
    
    public void crearTurno(){
    Conexion c = new Conexion();
    c.ejecutar("insert into turno (cc_cliente,tipo_tramite,numero,letra,estado,hora_solicitud)values('"+usuario.getCedula()+ "','" + tipo_tramite + "'," +numero+",'"+letra+"',"+estado+",'"+hora_solicitud+ "');");
    
    }

    @Override
    public String toString() {
        return "Turno{" + "usuario=" + usuario.toString() + ", tipo_tramite=" + tipo_tramite + ", numero=" + numero + ", letra=" + letra + ", estado=" + estado + ", hora_solicitud=" + hora_solicitud + ", tiempo_espera=" + tiempo_espera + '}';
    }
    
    
}
