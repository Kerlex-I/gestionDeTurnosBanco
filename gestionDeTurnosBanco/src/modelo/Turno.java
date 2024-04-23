/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author elker
 */
public class Turno {
    
    Usuario usuario;
    String tipo_tramite;
    int numero;
    boolean estado;

    public Turno() {
    }

    public Turno(Usuario usuario, String tipo_tramite, int numero, boolean estado) {
        this.usuario = usuario;
        this.tipo_tramite = tipo_tramite;
        this.numero = numero;
        this.estado = estado;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Turno{" + "usuario=" + usuario + ", tipo_tramite=" + tipo_tramite + ", numero=" + numero + ", estado=" + estado + '}';
    }
    
    
    
}
