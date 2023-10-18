/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Manager extends Personne {
     private List<Developpeur> developpeurs;

    public Manager(String nom, double salaire) {
    super(nom, salaire);
    this.developpeurs = new ArrayList<>();
}


    public List<Developpeur> getDeveloppeurs() {
        return developpeurs;
    }

    public void setDeveloppeurs(List<Developpeur> developpeurs) {
        this.developpeurs = developpeurs;
    }
    public void ajouterDeveloppeur(Developpeur developpeur) {
        developpeurs.add(developpeur);
    }
    
    

   // public void afficherHierarchie() {
        // Affiche le nom et le salaire du manager
       // System.out.println("Manager : " + getNom() + " - Salaire : " + getSalaire());

        // Affiche les noms et salaires des développeurs sous la supervision du manager
        //if (developpeurs != null && !developpeurs.isEmpty()) {
          //  System.out.println("Développeurs sous supervision :");
            //for (Developpeur developpeur : developpeurs) {
              //  System.out.println(" - " + developpeur.getNom() + " - Salaire : " + developpeur.getSalaire());
            }
        
    


  
  
    