/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author owa_7
 */
public class Votante {
    private String nombre;
    private String apellidos;
    private String domicilio;
    private LocalDate fechaNac;
    private String contraseña;
    private String nif;
    private String votado;
    private String rol;
    public Votante(String nombre, String apellidos, String domicilio, LocalDate fechaNac, String contraseña,String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.fechaNac = fechaNac;
        this.contraseña = contraseña;
        this.nif=nif;
    }
    public Votante(){
        
    } 
    public Votante(String nif,String votado,String rol){
        this.nif=nif;
        this.votado=votado;
        this.rol=rol;
    }
    public Votante(String nombre, String apellidos, String domicilio, LocalDate fechaNac,String nif,String rol,String votado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.fechaNac = fechaNac;
        this.contraseña = contraseña;
        this.nif=nif;
        this.rol=rol;
        this.votado=votado;
    }
    

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getVotado() {
        return votado;
    }

    public void setVotado(String votado) {
        this.votado = votado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
