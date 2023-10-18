/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.beans;

/**
 *
 * @author Lachgar
 */
public class Service {
    
    private int id; 
    private String nom;

    public Service(String nom) {
        this.nom = nom;
    }

    public Service(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom ;
    }
    
    
    
}
