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
public class Parametros {
    private int id;
    private String circunscripcion;
    private int numCandidatos;
    private String tipoConsulta;
    private LocalDate fechaConsulta;
    private String escrutinioAbierto;
    private String consultaAbierta;

    public Parametros(String circunscripcion, int numCandidatos, String tipoConsulta, LocalDate fechaConsulta, String escrutinioAbierto, String consultaAbierta) {
        this.circunscripcion = circunscripcion;
        this.numCandidatos = numCandidatos;
        this.tipoConsulta = tipoConsulta;
        this.fechaConsulta = fechaConsulta;
        this.escrutinioAbierto = escrutinioAbierto;
        this.consultaAbierta = consultaAbierta;
    }

    public Parametros(int id, String circunscripcion, int numCandidatos, String tipoConsulta, LocalDate fechaConsulta, String escrutinioAbierto, String consultaAbierta) {
        this.id = id;
        this.circunscripcion = circunscripcion;
        this.numCandidatos = numCandidatos;
        this.tipoConsulta = tipoConsulta;
        this.fechaConsulta = fechaConsulta;
        this.escrutinioAbierto = escrutinioAbierto;
        this.consultaAbierta = consultaAbierta;
    }

    public Parametros() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCircunscripcion() {
        return circunscripcion;
    }

    public void setCircunscripcion(String circnscripcion) {
        this.circunscripcion = circnscripcion;
    }

    public int getNumCandidatos() {
        return numCandidatos;
    }

    public void setNumCandidatos(int numCandidatos) {
        this.numCandidatos = numCandidatos;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getEscrutinioAbierto() {
        return escrutinioAbierto;
    }

    public void setEscrutinioAbierto(String escrutinioAbierto) {
        this.escrutinioAbierto = escrutinioAbierto;
    }

    public String getConsultaAbierta() {
        return consultaAbierta;
    }

    public void setConsultaAbierta(String consultaAbierta) {
        this.consultaAbierta = consultaAbierta;
    }
    
    
    
    
    
    
}
