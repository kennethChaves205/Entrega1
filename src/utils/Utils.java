package utils;

import java.io.InputStream;
import java.util.Properties;

public class Utils {

    public static Properties getProperties() throws Exception {
        Properties props = new Properties();

        // Cargar el archivo desde el classpath
        InputStream input = Utils.class.getClassLoader().getResourceAsStream("resources/db.properties");

        if (input == null) {
            throw new Exception(" ERROR: No se encontró el archivo db.properties en utils/");
        }

        props.load(input);
        return props;
    }
}
