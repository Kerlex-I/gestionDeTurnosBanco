/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestiondeturnosbanco;
import controlador.ControladorTurno;
import modelo.Turno;
import modelo.Usuario;

/**
 *
 * @author elker
 */
public class GestionDeTurnosBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorTurno controladorturno = new ControladorTurno();
        Usuario usuario = new Usuario();
        Turno turno = new Turno();
        
        
        
        usuario.setCedula("100000");
        usuario.setPrioridad("Preñada");
        usuario.setTelefono("311121");
        
        
        
        turno = controladorturno.crearTurno(usuario, "Cancela un producto", usuario.getPrioridad());
        
        String numero = Integer.toString(turno.getNumero());
        String letra = turno.getLetra();
        
        
        System.out.println(letra + numero);
        // TODO code application logic here
    }
    
}
