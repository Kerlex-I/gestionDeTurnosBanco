/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author elker
 */
public class Usuario {
    
    String cedula;
    String telefono;
    String prioridad;

    public Usuario() {
    }

    public Usuario(String cedula, String telefono, String prioridad) {
        this.cedula = cedula;
        this.telefono = telefono;
        this.prioridad = prioridad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", telefono=" + telefono + ", prioridad=" + prioridad + '}';
    }
    
    
    
}
