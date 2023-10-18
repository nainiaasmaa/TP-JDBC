/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.beans.Employe;
import ma.projet.connexion.Connexion;

import ma.projet.dao.IDao;

/**
 *
 * @author Lenovo
 */
public class EmployeService implements IDao<Employe> {
@Override

public boolean create(Employe o) {
    try {
        String req = "INSERT INTO employe (nom, prenom) VALUES (?, ?)";
        Connection connection = Connexion.getConnection(); // Obtenez la connexion ici
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setString(1, o.getNom());
        ps.setString(2, o.getPrenom());
        
        int rowsAffected = ps.executeUpdate();
        return rowsAffected == 1;
    } catch (SQLException ex) {
        Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
}


@Override
public boolean update(Employe o) {
try {
String req ="update employe set nom = ? , prenom = ? where id =?";

PreparedStatement ps =
Connexion.getConnection().prepareStatement(req);
ps.setString(1, o.getNom());
ps.setString(2, o.getPrenom());
ps.setInt(3, o.getId());
if (ps.executeUpdate() == 1) {
return true;
}
} catch (SQLException ex) {
Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}
@Override
public boolean delete(Employe o) {
try {
String req = "delete from employe where id = ?";
PreparedStatement ps =
Connexion.getConnection().prepareStatement(req);
ps.setInt(1, o.getId());
if (ps.executeUpdate() == 1) {
return true;
}
} catch (SQLException ex) {
Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}
@Override
public Employe getById(int id) {
Employe employe = null;
try {
String req = "select * from employe where id = ?";
PreparedStatement ps =
Connexion.getConnection().prepareStatement(req);
ps.setInt(1, id);
ResultSet rs = ps.executeQuery();
if(rs.next())
employe = new Employe( rs.getString("nom"), rs.getString("prenom"));
} catch (SQLException ex) {
Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE,
null, ex);
}
return employe;
}
@Override
public List<Employe> getAll() {
List <Employe> employes = new ArrayList<>();
try {
String req = "select * from employe ";
PreparedStatement ps =
Connexion.getConnection().prepareStatement(req);
ResultSet rs = ps.executeQuery();
while(rs.next())
employes.add(new Employe(rs.getString("nom"), rs.getString("prenom")));
} catch (SQLException ex) {
Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE,
null, ex);
}
return employes;
}

}


