package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        try {
            FileInputStream file = new FileInputStream("config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            System.out.println("Failed to load configuration file: " + e.getMessage());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
