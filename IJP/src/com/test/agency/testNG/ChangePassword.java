package com.test.agency.testNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pageobjects.PageObjectsAgency;
import com.pageobjects.PageObjectsEAF;
import com.pageobjects.PageObjectsLogin;
import com.utilities.ConfigReader;
import com.utilities.ExcelTestDataAgencyJobApply;
import com.utilities.ExtendReports;
import com.utilities.ReadPropFile;
import com.utilities.TakeScreenshot;

public class ChangePassword extends ExtendReports {
	static 	ConfigReader prop = new  ConfigReader();
	static{
	System.setProperty("webdriver.chrome.driver", prop.Chrome_Driver_Path());
	}
	
	ChromeDriver driver = new ChromeDriver();
	WebDriverWait wait=new WebDriverWait(driver, 120);
	JavascriptExecutor jse = (JavascriptExecutor)driver;  

	
  @BeforeTest
  public void launchijp() {	  	
	  	driver.get(prop.URL());
	  	driver.manage().window().maximize();	
	  	String scrFolder = System.getProperty("user.dir")+"\\Screenshots\\ChangePassword_Agency\\"+ new SimpleDateFormat("dd_MM_yyyy_HHmmss").format(Calendar.getInstance().getTime()).toString();
	    new File(scrFolder).mkdir();
	    System.setProperty("scr.folder", scrFolder);
  }
  	
  @Test
  public void changepassword() throws IOException, Exception {
	  	
	  	String title=driver.getTitle();	  	 
	  	test = extent.createTest("IJP Home Page");
        Assert.assertTrue(title.contains("Accenture Recruitment Portal- India"));	  	
        if (PageObjectsEAF.btn_close_cookies(driver).isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_close_cookies(driver)));
			 PageObjectsEAF.btn_close_cookies(driver).click();
		}
        
	  	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
	    ExcelTestDataAgencyJobApply data2 = new ExcelTestDataAgencyJobApply();

	    try {
			PageObjectsLogin.lnk_agency_login(driver).click();
			PageObjectsLogin.txt_agency_uname(driver).sendKeys(data2.agencyid);
			PageObjectsLogin.txt_agency_password(driver).sendKeys(prop.Agency_Current_Password()+"\n");
			System.out.println("Login Successful as Agency");
		} catch (NoSuchElementException e) {
			System.out.println("Unable to Login");
	    } finally {
	        System.out.println("Continue");
		}
	    
	  //Test Script
	    
	    
	    Thread.sleep(5000);
	     wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_agency_home(driver)));
	    System.out.println(PageObjectsAgency.visi_agency_home(driver).getText());
	    String title1=PageObjectsAgency.visi_agency_home(driver).getText();	  
	    test = extent.createTest("Login as Agency");
        Assert.assertTrue(title1.contains("Welcome"));
       
	    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_change_pwd(driver)));
	    PageObjectsAgency.lnk_change_pwd(driver).click();
	    test.log(Status.INFO,"Clicking the Change Password Hyperlink");
	    wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_change_pwd(driver)));
	    
	    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_old_pwd(driver)));
	    test.log(Status.INFO,"Entering the Old Password");
	    PageObjectsAgency.txt_old_pwd(driver).clear();
	    PageObjectsAgency.txt_old_pwd(driver).sendKeys(prop.Agency_Current_Password());
	    
	    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_new_pwd(driver)));
	    test.log(Status.INFO,"Entering the New Password");
	    PageObjectsAgency.txt_new_pwd(driver).clear();
	    PageObjectsAgency.txt_new_pwd(driver).sendKeys(prop.Agency_New_Password());
	    
	    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_cfm_new_pwd(driver)));
	    test.log(Status.INFO,"Entering the Confirm New Password");
	    PageObjectsAgency.txt_cfm_new_pwd(driver).clear();
	    PageObjectsAgency.txt_cfm_new_pwd(driver).sendKeys(prop.Agency_New_Password());
	    
	    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_submit_CP(driver)));
	    test.log(Status.INFO,"Clicking the Submit Change Password");
	    PageObjectsAgency.btn_submit_CP(driver).click();	    
	    
	    Thread.sleep(6000);
	    
	    TakeScreenshot.captureScreenShot(driver);
	    
	    String title2=PageObjectsAgency.visi_changed_password_cp(driver).getText();	  
	    test = extent.createTest("Password Change");
        Assert.assertTrue(title2.equals("Your Password has been Changed."));
        TakeScreenshot.captureScreenShot(driver);
        Thread.sleep(5000);    
	    
  }

    
  @AfterTest
  	public void terminatetest() {
	  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_logout(driver)));
	  test.log(Status.INFO, "Clicking the Logout Button");
	  PageObjectsAgency.lnk_logout(driver).click();
      driver.close();
  	}
  
}
