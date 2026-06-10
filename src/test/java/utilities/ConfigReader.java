package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    static {
        try {
            properties = new Properties();
            FileInputStream fis =
                    new FileInputStream(System.getProperty("user.dir")
                    		+ "/src/test/resources/config.properties");
            properties.load(fis);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property not found: " + key);
        }
        return value.trim();
    }
}