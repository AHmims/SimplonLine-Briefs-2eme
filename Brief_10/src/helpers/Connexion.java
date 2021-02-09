package helpers;

import java.io.InputStream;
import java.sql.*;
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
            e.printStackTrace();
            //System.out.println(e.getMessage());
            return null;
        }
    }

    //
    public static PreparedStatement initialisationRequetePreparee(Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement(sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
        for (int i = 0; i < objets.length; i++) {
            preparedStatement.setObject(i + 1, objets[i]);
        }
        return preparedStatement;
    }
}
