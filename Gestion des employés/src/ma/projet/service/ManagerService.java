package ma.projet.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.beans.Developpeur;
import ma.projet.beans.Manager;
import ma.projet.connexion.connexion;
import ma.projet.dao.IDao;

public class ManagerService implements IDao<Manager> {
    private List<Manager> managers = new ArrayList<>();
    private List<Developpeur> developpeursSousSupervision = new ArrayList<>();
   @Override
   public boolean create(Manager manager) {
        try {
            String req = "INSERT INTO manager (nom, salaire) VALUES (?, ?)";
            Connection connection = connexion.getConnection(); // Utilisez le nom de classe en minuscules
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, manager.getNom());
            ps.setDouble(2, manager.getSalaire());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
 
    @Override
    public boolean update(Manager o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Manager o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Manager findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Manager> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  







  
}
