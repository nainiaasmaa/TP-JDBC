package ma.projet.connexion;

import com.mysql.jdbc.Connection;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.util.Properties;

public class Connexion {
    
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
            connection = (Connection) DriverManager.getConnection(url, login, password);
        } catch (Exception ex) {
            System.out.println(""+ex.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
