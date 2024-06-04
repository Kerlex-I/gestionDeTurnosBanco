package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO CORE 7
 */
public class Conexion {
    
    Connection conexion=null;
    String usuario ="postgres";
    String password="elkerman69";
    
    
      public  Conexion() {
        try {
            // Invocamos el driver d ela base de datos
           
            try { 
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
          
            //Conexion de la base de datos
            // Conectamos con la base de datos
            this.conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/proyecto_final_desarrollo",
                    usuario, password);
 
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }
      
      
    public void ejecutar(String sql){
 
        try { 
            PreparedStatement stm = this.conexion.prepareStatement(sql);
            stm.execute();
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }  
    
    public ResultSet ejecutarConsulta(String sql){
         try { 
            PreparedStatement stm = this.conexion.prepareStatement(sql);
            return stm.executeQuery();
        } catch (SQLException ex) {
           System.out.println(ex);
        }
         return null;
         
    }
    
    public void cerrarSesion(){
        try {
            this.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
}
