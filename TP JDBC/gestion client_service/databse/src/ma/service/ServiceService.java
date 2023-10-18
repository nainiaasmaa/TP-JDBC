/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.beans.Service;
import ma.connexion.Connexion;
import ma.dao.IDao;

/**
 *
 * @author Lachgar
 */
public class ServiceService implements IDao<Service>{

    @Override
    public boolean create(Service o) {
        try {
            String req = "insert into service values (null, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            if(ps.executeUpdate() == 1)
                return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    @Override
   public boolean update(Service o) {
    try {
        String req = "UPDATE service SET nom=? WHERE id=?";
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
        ps.setString(1, o.getNom());
        ps.setInt(2, o.getId()); // Utilisez l'index 2 pour l'ID

        int rowsUpdated = ps.executeUpdate();

        return rowsUpdated > 0;
    } catch (SQLException ex) {
        System.out.println("Erreur de mise à jour du service: " + ex.getMessage());
    }
    return false;
}

    @Override
    public boolean delete(Service o) {
         try {
            String req = "delete from service where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            if(ps.executeUpdate() == 1)
                return true;
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Service findById(int id) {
        ResultSet rs = null;
         try {
            String req = "select * from service where id  = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next())
                return new Service(rs.getInt("id"), rs.getString("nom"));
        } catch (SQLException ex) {
        }
        return null;
    }

    @Override
    public List<Service> findAll() {
         List<Service> services = new ArrayList<>();
         ResultSet rs = null;
         try {
            String req = "select * from service";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
    
            rs = ps.executeQuery();
            while(rs.next())
                services.add(new Service(rs.getInt("id"), rs.getString("nom")));
        } catch (SQLException ex) {
        }
        return services;
    }
    
}
