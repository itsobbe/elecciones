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
public class Escaño {
    private int id;
    private int numEscaños=0;
    private int id_partido;

    public Escaño(int id, int numEscaños, int id_partido) {
        this.id = id;
        this.numEscaños = numEscaños;
        this.id_partido = id_partido;
    }
    public Escaño(int id_partido) {
        this.id_partido = id_partido;
    }
    public Escaño() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumEscaños() {
        return numEscaños;
    }

    public void setNumEscaños(int numEscaños) {
        this.numEscaños = numEscaños;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }
    
    
}
