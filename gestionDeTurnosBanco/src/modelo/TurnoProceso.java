/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author elker
 */
public class TurnoProceso {
    int id_turno;
    int id_modulo;
    String hora_proceso;
    
    public TurnoProceso(){
        
    }

    public TurnoProceso(int id_turno, int id_modulo, String hora_proceso) {
        this.id_turno = id_turno;
        this.id_modulo = id_modulo;
        this.hora_proceso = hora_proceso;
    }

    

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public int getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(int id_modulo) {
        this.id_modulo = id_modulo;
    }

    public String getHora_proceso() {
        return hora_proceso;
    }

    public void setHora_proceso(String hora_proceso) {
        this.hora_proceso = hora_proceso;
    }
    
    
    public void crearTurnoProceso(){
        Conexion c = new Conexion();
        c.ejecutar("insert into turno_proceso (id_turno,id_modulo,hora_proceso)values("+id_turno+ "," + id_modulo + ", '"+ hora_proceso+ "');");
    }
    
    public void eliminarTurnoProceso(){
        Conexion c = new Conexion();
        c.ejecutar("delete from turno_proceso where id="+id_turno);
    }
    
    public int retornarUltimoTurnoProceso(){
        Conexion c = new Conexion();
        int id = 0;
        String sql = "SELECT id_turno FROM turno_proceso where id_modulo =" + this.getId_modulo() +" ORDER BY hora_proceso DESC LIMIT 1";
        ResultSet rs = c.ejecutarConsulta(sql);
        
        try {
            while(rs.next()){
                id = rs.getInt("id_turno");
            }        
        } catch (java.sql.SQLException e) {
        }
        c.cerrarSesion();
        return id;
    }
    
    public ArrayList<TurnoProceso> mostrarPantalla(){
        Conexion c = new Conexion();
        String sql = "SELECT * FROM turno_proceso" + " ORDER BY hora_proceso DESC LIMIT 10";
        ArrayList<TurnoProceso> turnosProceso = new ArrayList<>();
        ResultSet rs = c.ejecutarConsulta(sql);
        
        try {
            while(rs.next()){
                TurnoProceso tp = new TurnoProceso();
                
                tp.setId_turno(rs.getInt("id_turno"));
                tp.setId_modulo(rs.getInt("id_modulo"));
                tp.setHora_proceso(rs.getString("hora_proceso"));
                
                turnosProceso.add(tp);                
            }
        } catch (java.sql.SQLException e) {
        }
        c.cerrarSesion();
        return turnosProceso;
    }
    
    @Override
    public String toString() {
        return "TurnoProceso{" + "id_turno=" + id_turno + ", id_modulo=" + id_modulo + '}';
    }
    
    
}
