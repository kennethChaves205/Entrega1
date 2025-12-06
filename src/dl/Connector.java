package dl;

import utils.Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connector {

    private static Connection conn;

    public static Connection getConnection() throws Exception {

        if (conn == null || conn.isClosed()) {
            Properties props = Utils.getProperties();

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("✔ Conexión a MySQL exitosa.");
        }

        return conn;
    }
}
