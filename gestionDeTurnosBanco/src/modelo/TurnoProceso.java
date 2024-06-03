/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author elker
 */
public class TurnoProceso {
    int id_turno;
    int id_modulo;
    
    public TurnoProceso(){
        
    }

    public TurnoProceso(int id_turno, int id_modulo) {
        this.id_turno = id_turno;
        this.id_modulo = id_modulo;
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

    @Override
    public String toString() {
        return "TurnoProceso{" + "id_turno=" + id_turno + ", id_modulo=" + id_modulo + '}';
    }
    
    
}
