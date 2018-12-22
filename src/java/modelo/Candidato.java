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
public class Candidato {
    private int id;
    private String nombre_apellidos;
    private int orden;
    private int id_partido;

    public Candidato(int id, String nombre_apellidos, int orden, int id_partido) {
        this.id = id;
        this.nombre_apellidos = nombre_apellidos;
        this.orden = orden;
        this.id_partido = id_partido;
    }

    public Candidato(String nombre_apellidos, int orden, int id_partido) {
        this.nombre_apellidos = nombre_apellidos;
        this.orden = orden;
        this.id_partido = id_partido;
    }

    public Candidato(String nombre_apellidos, int orden) {
        this.nombre_apellidos = nombre_apellidos;
        this.orden = orden;
    }
    

    public Candidato() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_apellidos() {
        return nombre_apellidos;
    }

    public void setNombre_apellidos(String nombre_apellidos) {
        this.nombre_apellidos = nombre_apellidos;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }
    
    
}
