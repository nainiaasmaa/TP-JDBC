/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class Message {
    private int id;
    private String objet;
    private String sujet;
    private Date date;
    private int idE; 
    private int idR;
    private String EmpEmetteur;
    private String EmpRecepteur;
    

    public Message() {
    }

    public Message(String objet, String sujet, Date date, int idE, int idR, String EmpEmetteur, String EmpRecepteur) {
        this.objet = objet;
        this.sujet = sujet;
        this.date = date;
        this.idE = idE;
        this.idR = idR;
        this.EmpEmetteur = EmpEmetteur;
        this.EmpRecepteur = EmpRecepteur;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getEmpEmetteur() {
        return EmpEmetteur;
    }

    public void setEmpEmetteur(String EmpEmetteur) {
        this.EmpEmetteur = EmpEmetteur;
    }

   

    public String getEmpRecepteur() {
        return EmpRecepteur;
    }

    public void setEmpRecepteur(String EmpRecepteur) {
        this.EmpRecepteur = EmpRecepteur;
    }
    

   

   

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", objet=" + objet + ", sujet=" + sujet + ", date=" + date + ", idE=" + idE + ", idR=" + idR + ", EmpEmetteur=" + EmpEmetteur + ", EmpRecepteur=" + EmpRecepteur + '}';
    }
    
    
    
    
}
