package com.krce.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() {

        prop = new Properties();

        try {
            FileInputStream file =
                    new FileInputStream("src/main/resources/config.properties");

            prop.load(file);

        } catch (IOException e) {

            System.out.println("Config file not found");
            e.printStackTrace();
        }
    }

    public String getURL() {
        return prop.getProperty("baseUrl");
    }

    public int getTimeout() {
        return Integer.parseInt(prop.getProperty("timeout"));
    }
}