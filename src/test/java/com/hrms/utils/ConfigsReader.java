package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
    static Properties prop;
    /**
     * This method reads any given property file
     * @param filePath
     * @return Properties
     */
    public static void readProperties(String filePath){
        try{
            FileInputStream fileInputStream = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fileInputStream);
            fileInputStream.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method retrieves single value based on the specified key
     * @param key
     * @return
     */
    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }

}