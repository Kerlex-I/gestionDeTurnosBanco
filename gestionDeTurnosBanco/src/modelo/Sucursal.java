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
    
//    public void crearSucursal(){
//        Conexion c = new Conexion();
//        c.ejecutar("insert into turno (cc_cliente,tipo_tramite,numero,letra,estado,hora_solicitud,prioridad)values('"+usuario.getCedula()+ "','" + tipo_tramite + "'," +numero+",'"+letra+"',"+estado+",'"+hora_solicitud+ "','" + prioridad + "');");
//    }
    
    public int retornarIDSucursal(String ciudadS){
        String sql = "SELECT id_sucursal FROM sucursal WHERE ciudad = '" + ciudadS + "'";
        Conexion c = new Conexion();
        ResultSet rs = c.ejecutarConsulta(sql);
        
        try{
            while(rs.next()){
                int id_sucursals = rs.getInt("id_sucursal");
                return id_sucursals;
            }
        }catch(java.sql.SQLException e){
        }
        return 0;
    }
    
    public String retornarDireccionSucursal(String ciudadS){
        String sql = "SELECT direccion FROM sucursal WHERE ciudad = '" + ciudadS + "'";
        Conexion c = new Conexion();
        ResultSet rs = c.ejecutarConsulta(sql );
        
        try{
            while(rs.next()){
                String direccion_sucursal = rs.getString("direccion");
                return direccion_sucursal;
            }
        }catch(java.sql.SQLException e){
            
        }
        
        return null;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "id_sucursal=" + id_sucursal + ", ciudad=" + ciudad + ", direccion=" + direccion + '}';
    }
    
    
}
