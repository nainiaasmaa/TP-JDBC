/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import ma.projet.beans.Developpeur;
import ma.projet.beans.Manager;
import ma.projet.service.DeveloppeurService;
import ma.projet.service.ManagerService;

/**
 *
 * @author Lenovo
 */
public class Entreprise {
    public static void main(String[] args) {
        DeveloppeurService ds = new DeveloppeurService();
        ManagerService ms = new ManagerService();

        // Créez deux développeurs
        Developpeur developpeur1 = new Developpeur("wafaa", 200.0);
        Developpeur developpeur2 = new Developpeur("imane", 400.0);

        // Créez un manager
        Manager manager1 = new Manager("manager1", 100.0);

        // Ajoutez les développeurs sous supervision du manager
        ds.create(developpeur1);
        ds.create(developpeur2);
        ms.create(manager1);

        manager1.ajouterDeveloppeur(developpeur1);
        manager1.ajouterDeveloppeur(developpeur2);

        
    }
}