package utils;

import java.io.InputStream;
import java.util.Properties;

public class configuration {

    private Properties properties;

    public configuration(){
        properties=new Properties();
        try (InputStream inputStream=getClass().getClassLoader().getResourceAsStream("application.properties")){
            if(inputStream==null){
                return;
            }
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getProperty(String key) {
        String value = System.getProperty(key);   // from Maven / CI
        if (value == null || value.isEmpty()) {
            value = System.getenv(key);          // from environment variables
        }
        if (value == null || value.isEmpty()) {
            value = properties.getProperty(key); // from application.properties
        }
        return value;
    }
}
