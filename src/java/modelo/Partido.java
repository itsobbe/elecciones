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
public class Partido {
    private int id;
    private String denominacion;
    private String siglas;
    private String logo;
    private int votos;

    public Partido(int id, String denominacion, String siglas, int votos) {
        this.id = id;
        this.denominacion = denominacion;
        this.siglas = siglas;
        this.votos = votos;
    }

    public Partido(){
        
    }

    public Partido(int id, String denominacion, String logo) {
        this.id = id;
        this.denominacion = denominacion;
        this.logo = logo;
    }
    public Partido(int votos,String siglas){
        this.votos=votos;
        this.siglas=siglas;
    }
    public Partido(int id){
        this.id=id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
    
}
