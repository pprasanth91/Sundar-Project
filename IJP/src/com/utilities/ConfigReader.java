package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class ConfigReader {
	
	
	Properties prop;
	
	public ConfigReader()
	{
		try {

			File src=new File("./dataFile.properties");
			FileInputStream fs=new FileInputStream(src);

			prop=new Properties();
			prop.load(fs);
			//PropertyConfigurator.configure("log4j.properties"); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String URL()
	{
		return prop.getProperty("URL");
	}
	
	public String Agency_Current_Password()
	{
		return prop.getProperty("Agency_Current_Password");
	}
	
	public String Agency_New_Password()
	{
		return prop.getProperty("Agency_New_Password");
	}
	
	public String Chrome_Driver_Path()
	{
		return prop.getProperty("Chrome_Driver_Path");
	}
	
	public String Word_Path()
	{
		return prop.getProperty("Word_Path");
	}
	
	public String Candidate_Email()
	{
		return prop.getProperty("Candidate_Email");
	}
	
	public String Candidate_Password()
	{
		return prop.getProperty("Candidate_Password");
	}
	
	public String Entity_JobApply()
	{
		return prop.getProperty("Entity_JobApply");
	}
	
	public String Image_Path()
	{
		return prop.getProperty("Image_Path");
	}
	
	public String Employee_Username()
	{
		return prop.getProperty("Employee_Username");
	}
	
	public String Employee_Password()
	{
		return prop.getProperty("Employee_Password");
	}

	public String Image() {
		return prop.getProperty("Image");
	}

	public String Entity_DocumentUpload() {
		return prop.getProperty("Entity_DocumentUpload");
	}

	public String Word() {
		
		return prop.getProperty("Word");
	}

	public String IE_Driver_Path() {
		return prop.getProperty("IE_Driver_Path");
	}

	public String Invalid_Image() {
		return prop.getProperty("Invalid_Image");
	}

	public String Query_Related_To() {
		return prop.getProperty("Query_Related_To");
	}

	public String Resume() {
		return prop.getProperty("Resume");
	}
	

}
