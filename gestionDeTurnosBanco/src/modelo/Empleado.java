/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * @author elker
 */
public class Empleado {
   
    String credencial;
    String contrasena;
    String nombre;
    int modulo;
    int sucursal;

    public Empleado() {
    }

    public Empleado(String credencial, String contrasena, String nombre, int modulo, int sucursal) {
        this.credencial = credencial;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.modulo = modulo;
        this.sucursal = sucursal;
    }

    
    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
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

    public int getModulo() {
        return modulo;
    }

    public void setModulo(int modulo) {
        this.modulo = modulo;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }
    
    public void registrarEmpleado(){
        Conexion c = new Conexion();
        c.ejecutar("insert into empleado (nombre, contrasena, modulo, sucursal, credencial) values('"+this.nombre+"','"+this.contrasena+"',"+this.modulo+"," + this.sucursal + ",'"+this.credencial+"');");
        c.cerrarSesion();
    }

    public void eliminarEmpleado(){
        Conexion c = new Conexion();
        c.ejecutar("delete from empleado where credencial='"+this.credencial + "'");
        c.cerrarSesion();
    }

    public void actualizarEmpleado(){
        Conexion c = new Conexion();
        c.ejecutar("update empleado set nombre ='"+this.nombre+"', contrasena='"+this.contrasena+"',modulo ="+this.modulo+",sucursal ="+this.sucursal + " where credencial='"+this.credencial+"'");
        c.cerrarSesion();
    }
    
    public Empleado buscarEmpleado(String credenciall){
        String sql = "SELECT * FROM empleado WHERE credencial = '" + credenciall +"'";
        Empleado empleado = new Empleado();
        Conexion c = new Conexion();
        ResultSet rs = c.ejecutarConsulta(sql);
        try {
            while(rs.next()){                 
                empleado.setNombre(rs.getString("nombre"));
                empleado.setContrasena(rs.getString("contrasena"));
                empleado.setModulo(rs.getInt("modulo"));
                empleado.setSucursal(rs.getInt("sucursal"));
                empleado.setCredencial(rs.getString("credencial"));
                return empleado;
            }
        } catch (java.sql.SQLException e) {
        }
        c.cerrarSesion();
        return null;
    }
    
    public Empleado encontrarEmpleado(String identificacion, String contrasena){
        Empleado empleado = null;
        String sql = "SELECT * FROM empleado WHERE credencial = '" + identificacion + "' and contrasena = '" + contrasena + "'";
        Conexion c = new Conexion();
        ResultSet rs = c.ejecutarConsulta(sql);
        
        try {
            while(rs.next()){
                empleado = new Empleado(rs.getString("credencial"),rs.getString("contrasena"),rs.getString("nombre"),rs.getInt("modulo"), rs.getInt("sucursal"));
            }
            
        } catch (java.sql.SQLException e) {
        }
        
        return empleado;
    }

    @Override
    public String toString() {
        return "Empleado{" + "credencial=" + credencial + ", contrasena=" + contrasena + ", nombre=" + nombre + ", modulo=" + modulo + ", sucursal=" + sucursal + '}';
    }
    
    
}