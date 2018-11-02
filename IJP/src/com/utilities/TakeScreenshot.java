package com.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import java.io.IOException; 
import org.openqa.selenium.TakesScreenshot; 

public class TakeScreenshot {
	public static void captureScreenShot(WebDriver driver){
		String timeStamp;
		File screenShotName;
		// Take screenshot and store as a file format       
		String scrFolder = System.getProperty("scr.folder");
		System.out.println(scrFolder);
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);           
		try{
			timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
			String dest = scrFolder+"/"+timeStamp+".jpg";
			screenShotName = new File(dest);
			FileUtils.copyFile(src, screenShotName);
		}			 
		catch (IOException e){
		  System.out.println(e.getMessage());
		}
		
		  }
}
