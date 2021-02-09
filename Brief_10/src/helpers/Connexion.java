package helpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public class Connexion {
    public static Connection db_connect() {
        try {
            InputStream in = Connexion.class.getResourceAsStream("/DB.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();
            //
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/%s", props.getProperty("__HOST"), props.getProperty("__PORT"), props.getProperty("__DB_NAME")), props.getProperty("__USER"), props.getProperty("__PASSWORD"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
