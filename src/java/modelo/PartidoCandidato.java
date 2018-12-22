/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author owa_7
 */
public class PartidoCandidato extends Partido{
    private int escaños;
    private ArrayList<Candidato> candidato;

    public PartidoCandidato(int escaños, int id, String denominacion, String siglas, String logo, int votos) {
        super(id,denominacion, siglas, logo, votos);
        this.escaños = escaños;
        this.candidato=new ArrayList();
    }
    

    public PartidoCandidato() {
    }

    public int getEscaños() {
        return escaños;
    }

    public void setEscaños(int escaños) {
        this.escaños = escaños;
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidato;
    }

    public void setCandidatos(ArrayList<Candidato> candidato) {
        this.candidato = candidato;
    }
    
    public void setCandidato(Candidato candidato) {
        this.candidato.add(candidato);
    }
    
    
//    public int compareTo(PartidoCandidato partido) {
//	
//		int compareQuantity = ((Fruit) compareFruit).getQuantity(); 
//		
//		//ascending order
//		return this.quantity - compareQuantity;
//		
//		//descending order
//		//return compareQuantity - this.quantity;
//		
//	}
}
