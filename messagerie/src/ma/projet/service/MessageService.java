/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.beans.Message;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

/**
 *
 * @author Lenovo
 */
public class MessageService implements IDao<Message> {
       private EmployeService es;

       public MessageService() {
       es = new EmployeService();
}
@Override
public boolean create(Message o) {
try {
String req = "insert into message (objet, sujet, date, idE, idR)values(?,?,?,?,?)";
PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
ps.setString(1, o.getObjet());
ps.setString(2, o.getSujet());
ps.setDate(3, new Date(o.getDate().getTime()));
ps.setInt(4, o.getIdE());
ps.setInt(5, o.getIdR());
if (ps.executeUpdate() == 1) {
return true;
}
} catch (SQLException ex) {Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}
@Override
public boolean update(Message o) {
    try{
        String req = "UPDATE message SET objet = ?, sujet = ?, date = ?, idE = ?, idR = ? WHERE id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getObjet());
            ps.setString(2, o.getSujet());
            ps.setDate(3, o.getDate());
            ps.setInt(4, o.getIdE());
            ps.setInt(5, o.getIdR());
            ps.setInt(6, o.getId());
            if (ps.executeUpdate() == 1) {
}
} catch (SQLException ex) {Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}
@Override
public boolean delete(Message o) {
    try {
            String req = "DELETE FROM message WHERE id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }






@Override
public Message getById(int id) {
    Message message = null;
    try {
        String req = "SELECT * FROM message WHERE id = ?";
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            message = new Message(
                rs.getString("objet"),
                rs.getString("sujet"),
                rs.getDate("date"),
                rs.getInt("idE"),
                rs.getInt("idR"),
                rs.getString("EmpEmetteur"),
                rs.getString("EmpRecepteur")
            );
            message.setId(rs.getInt("id")); // N'oubliez pas de définir l'ID
        }
    } catch (SQLException ex) {
        Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return message;
}





@Override
public List<Message> getAll() {
    List<Message> messages = new ArrayList<>();
    try {
        String req = "select * from message ";
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Message message = new Message(
                rs.getString("objet"),
                rs.getString("sujet"),
                rs.getDate("date"),
                rs.getInt("idE"),
                rs.getInt("idR"),
                rs.getString("EmpEmetteur"),
                rs.getString("EmpRecepteur")
            );
            message.setId(rs.getInt("id")); // N'oubliez pas de définir l'ID
            messages.add(message);
        }
    } catch (SQLException ex) {
        Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return messages;
}

}

