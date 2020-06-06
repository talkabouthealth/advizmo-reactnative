package com.globalsoft.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

import java.util.logging.Logger;
/**
*
* @author Karan
*/
public class PropertyReader {
    
    private static final Logger logger = Logger.getLogger(PropertyReader.class.getName());
    
    private static Properties envProperties = null;
    
    private static long lastModified = 0L;
    private static String env = null;
    static {
            envProperties = loadProperties();
    }
    
    private static Properties loadProperties() {
        FileInputStream fis = null;
        try {
        	env = System.getProperty("finapp.configuration.file.path");
            if (env == null) {
                String homeFolder = System.getenv("HOME");
                env = homeFolder + "/finance_app_configuration.properties";
            }

            File f = new File(env);
            Properties prop = new Properties();
            logger.info("Logging environment properties from :" + env);
            fis = new FileInputStream(env);
            prop.load(fis);
            lastModified = f.lastModified();
            return prop;
        } catch (Exception ex) {
            Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, "Exception while loading environment properties", ex);
            return null;
        }finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static String getValue(String key){
        File f = new File(env);
        logger.fine("File Last modified: " + f.lastModified() + " ; variable lastModified: " + lastModified);
        if(f.lastModified() > lastModified){
            envProperties = loadProperties();
        }
        return envProperties.getProperty(key);
    }
    
    public static void main(String args[]){
        
        String key="Fitbug.emailto";
        System.out.println("Value is:" + PropertyReader.getValue(key));
    }
}
