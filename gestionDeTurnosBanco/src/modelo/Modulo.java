/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;

/**
 *
 * @author elker
 */
public class Modulo {
    int id_modulo;
    String nombre_modulo;
    String descripcion;
    int turnos_atendidos;

    public Modulo() {
    }

    public Modulo(int id_modulo, String nombre_modulo, String descripcion, int turnos_atendidos) {
        this.id_modulo = id_modulo;
        this.nombre_modulo = nombre_modulo;
        this.descripcion = descripcion;
        this.turnos_atendidos = turnos_atendidos;
    }

    public int getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(int id_modulo) {
        this.id_modulo = id_modulo;
    }

    public String getNombre_modulo() {
        return nombre_modulo;
    }

    public void setNombre_modulo(String nombre_modulo) {
        this.nombre_modulo = nombre_modulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTurnos_atendidos() {
        return turnos_atendidos;
    }

    public void setTurnos_atendidos(int turnos_atendidos) {
        this.turnos_atendidos = turnos_atendidos;
    }
    
    public String retornarTipoModulo(String modulo_id){
        String tipoModulo = null;
        String sql = "SELECT nombre_modulo FROM modulo WHERE id_modulo = " + modulo_id;
        Conexion c = new Conexion();
        ResultSet rs = c.ejecutarConsulta(sql);

        try{
            while(rs.next()){
                tipoModulo = rs.getString("nombre_modulo");
            }
        }catch(java.sql.SQLException e){
        }
        return tipoModulo;
    }

    @Override
    public String toString() {
        return "Modulo{" + "id_modulo=" + id_modulo + ", nombre_modulo=" + nombre_modulo + ", descripcion=" + descripcion + ", turnos_atendidos=" + turnos_atendidos + '}';
    }
    
    
}
