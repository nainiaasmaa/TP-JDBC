/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.sql.Date;
import ma.projet.beans.Employe;
import ma.projet.beans.Message;
import ma.projet.service.EmployeService;
import ma.projet.service.MessageService;

/**
 *
 * @author Lenovo
 */
public class Test {
    public static void main(String[] args) {
        EmployeService es = new EmployeService();
        MessageService ms = new MessageService();
      
      // Créez 3 employés
        Employe employe1 = new Employe("LACHGAR", "Mohamed");
        Employe employe2 = new Employe("RAMI", "ALI");
        Employe employe3 = new Employe("SAFI", "Fatima");

        es.create(employe1);
        es.create(employe2);
        es.create(employe3);

        // Obtenez la date et l'heure actuelles en millisecondes
long currentTimeMillis = System.currentTimeMillis();

// Créez une instance de java.sql.Date avec la date actuelle
java.sql.Date currentDate = new java.sql.Date(currentTimeMillis);

        Message message1to2 = new Message("Objet1", "Sujet1", new Date(System.currentTimeMillis()), employe1.getId(), employe2.getId(), employe1.getNom(), employe2.getNom());
        ms.create(message1to2);
 
        // Le 1er employé envoie un message au 3ème
        Message message1to3 = new Message("Objet2", "Sujet2", new Date(System.currentTimeMillis()), employe1.getId(), employe3.getId(), employe1.getNom(), employe3.getNom());
        ms.create(message1to3);

    }
}
