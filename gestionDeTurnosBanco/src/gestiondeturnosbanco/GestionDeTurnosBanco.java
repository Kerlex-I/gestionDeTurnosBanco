/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestiondeturnosbanco;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.sql.Timestamp;
import java.time.Period;

/**
 *
 * @author elker
 */
public class GestionDeTurnosBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // TODO code application logic here
        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
        System.out.println(timestamp);
        LocalTime time = LocalTime.now(); // Obtiene la hora actual 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String horaFormateada = time.format(formatter);
        System.out.println(horaFormateada);
    }
        
    
}
