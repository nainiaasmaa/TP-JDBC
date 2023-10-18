/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.beans.Developpeur;
import ma.projet.connexion.connexion;
import ma.projet.dao.IDao;

/**
 *
 * @author Lenovo
 */
public class DeveloppeurService implements IDao<Developpeur> {

   @Override
   public boolean create(Developpeur developpeur) {
        try {
            String req = "INSERT INTO developpeur (nom, salaire) VALUES (?, ?)";
            Connection connection = connexion.getConnection(); // Utilisez le nom de classe en minuscules
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, developpeur.getNom());
            ps.setDouble(2, developpeur.getSalaire());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Developpeur o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Developpeur o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Developpeur findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Developpeur> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
