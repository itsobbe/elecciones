/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author owa_7
 */
import java.lang.Exception;

public class ApplicationException extends Exception{
    private String mensaje;
    private int codigo;
    private String ampliacion;
    public ApplicationException(String mensaje,int codigo,String ampliacion) {
        super(mensaje);
        this.codigo=codigo;
        this.ampliacion=ampliacion;
    }

    @Override
    public String toString() {
        return super.toString()+"["+codigo+"] "+ampliacion; //To change body of generated methods, choose Tools | Templates.
    }
    
}
