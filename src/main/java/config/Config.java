package config;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties PROPS = new Properties();

    static {
        try (InputStream is = Config.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            PROPS.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Cannot load config.properties", e);
        }
    }

    public static String getBaseUrl() {
        return PROPS.getProperty("baseUrl");
    }
}