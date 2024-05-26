/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author elker
 */
public class Sucursal {
    int id_sucursal;
    String ciudad;
    String direccion;

    public Sucursal() {
    }

    public Sucursal(int id_sucursal, String ciudad, String direccion) {
        this.id_sucursal = id_sucursal;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "id_sucursal=" + id_sucursal + ", ciudad=" + ciudad + ", direccion=" + direccion + '}';
    }
    
    
}
