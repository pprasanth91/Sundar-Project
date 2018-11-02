package com.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties; 
public class ReadPropFile {

public java.util.Properties prop=null;

public void readPropertiesFile(){
    prop = new Properties();
    try {


        InputStream input = new 
FileInputStream("./src/dataFile.properties");
        prop.load(input);
    } catch (Exception e) {
        
        e.printStackTrace();
    }
  }
public String getPropertyValue(String key){
    return prop.getProperty(key);
 }

}