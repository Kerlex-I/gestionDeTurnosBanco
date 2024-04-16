/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * @author elker
 */
public class Empleado {
   
    int credencial;
    String contrasena;
    String nombre;

    public Empleado() {
    }

    public Empleado(int credencial, String contrasena, String nombre) {
        this.credencial = credencial;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }

    public int getCredencial() {
        return credencial;
    }

    public void setCredencial(int credencial) {
        this.credencial = credencial;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empleado{" + "credencial=" + credencial + ", contrasena=" + contrasena + ", nombre=" + nombre + '}';
    }  
}