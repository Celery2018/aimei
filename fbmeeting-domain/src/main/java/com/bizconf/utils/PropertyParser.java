package com.bizconf.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by peter on 21/6/2017.
 */
public class PropertyParser {

    private Properties properties = null;

    public PropertyParser(String propertyFileName) {
        properties = new Properties();
        try {
            InputStream in = PropertyParser.class.getResourceAsStream(propertyFileName);
            properties.clear();
            properties.load(in);
        } catch (FileNotFoundException e) {
            e.getLocalizedMessage();
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

    public String getProperty(String key) {
        if (properties == null) {
            return null;
        }
        return properties.getProperty(key);
    }

}