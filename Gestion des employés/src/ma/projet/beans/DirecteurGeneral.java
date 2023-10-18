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
public class DirecteurGeneral extends Personne {
    private List<Manager> managers = new ArrayList<>();

    public void ajouterManager(Manager manager) {
        managers.add(manager);
    }

    public List<Manager> getManagers() {
        return managers;
    }
}
