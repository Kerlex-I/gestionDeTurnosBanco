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
    int sucursal_id;

    public Usuario() {
    }

    public Usuario(String cedula, String telefono, String prioridad, int sucursal_id) {
        this.cedula = cedula;
        this.telefono = telefono;
        this.prioridad = prioridad;
        this.sucursal_id = sucursal_id;
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

    public int getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(int sucursal_id) {
        this.sucursal_id = sucursal_id;
    }

    
    
    public void crearUsuario(){
    Conexion c = new Conexion();
    c.ejecutar("insert into usuario (cedula,telefono,prioridad,sucursal_id)values('"+cedula+ "','" + telefono + "','" +prioridad+"',"+ sucursal_id + ");");
    
    }
    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", telefono=" + telefono + ", prioridad=" + prioridad + ", sucursal=" + sucursal_id + '}';
    }

    
    
    
    
}
