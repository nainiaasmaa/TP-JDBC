/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.connexion;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Lenovo
 */
public class connexion {

    private static Connection connection;

    static {
        try {
            FileInputStream f = new FileInputStream("base.properties");
            Properties p = new Properties();
            p.load(f);
            String url = p.getProperty("jdbc.url");
            String login = p.getProperty("jdbc.username");
            String password = p.getProperty("jdbc.password");
            String driver = p.getProperty("jdbc.driver");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, login, password);
        } catch (Exception ex) {
            System.out.println("" + ex.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
