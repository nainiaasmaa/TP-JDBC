/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connexion {
    private static String login = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/db";
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            connection = DriverManager.getConnection(url, login, password);
       
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver introvable");
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion");
        }
    }

    public static Connection getConnection() {
        return connection;
    }
    
  
    
    public static void main(String[] args) {
        new Connexion();
        System.out.println("main");
    }
}
