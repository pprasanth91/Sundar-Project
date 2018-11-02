package com.test.employee.testNG;

import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.pageobjects.PageObjectsEAF;
import com.pageobjects.PageObjectsEmployee;
import com.pageobjects.PageObjectsLogin;
import com.utilities.ConfigReader;
import com.utilities.ExcelTestDataEmployee;
import com.utilities.ExtendReports;
import com.utilities.ReadPropFile;
import com.utilities.TakeScreenshot;


public class IJP_Purge extends ExtendReports {
	static 	ConfigReader prop = new  ConfigReader();
	static{
		System.setProperty("webdriver.ie.driver", prop.IE_Driver_Path());
		}
	
	InternetExplorerDriver driver = new InternetExplorerDriver();
	WebDriverWait wait=new WebDriverWait(driver, 200);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
		
  @BeforeTest
  public void launchijp() {	  	
	   
	  driver.manage().deleteAllCookies();
	  driver.get(prop.URL());
	  driver.manage().window().maximize(); 
	  String scrFolder = System.getProperty("user.dir")+"\\Screenshots\\Employee\\"+ new SimpleDateFormat("dd_MM_yyyy_HHmmss").format(Calendar.getInstance().getTime()).toString();
	    new File(scrFolder).mkdir();
	    System.setProperty("scr.folder", scrFolder);
  }
  	
  @Test
  public void employee() throws IOException, Exception {
	  	
	  ExcelTestDataEmployee data = new ExcelTestDataEmployee();
	  	String title=driver.getTitle();	  	 
	  	TakeScreenshot.captureScreenShot(driver);
	  	test = extent.createTest("IJP Home Page");
        Assert.assertTrue(title.contains("Accenture Recruitment Portal- India"));	
       	 
        try {
			if (PageObjectsEAF.btn_close_cookies(driver).isDisplayed()) {
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_close_cookies(driver)));
				 PageObjectsEAF.btn_close_cookies(driver).click();
			}
		} catch (Exception e1) {
			System.out.println("GDPR Cookies is not displayed");
		}
		
	  	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
	  	
	  	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsLogin.lnk_Employee_login(driver)));
	    PageObjectsLogin.lnk_Employee_login(driver).click();
	    PageObjectsLogin.btn_employee_login(driver).click();
	    
	    Thread.sleep(15000);
	    wait.until(ExpectedConditions.visibilityOf(PageObjectsLogin.txt_employee_uname(driver)));
	    System.out.println(data.enterpriseid + data.password);
	    PageObjectsLogin.txt_employee_uname(driver).sendKeys(prop.Employee_Username());
		PageObjectsLogin.txt_employee_pwd(driver).sendKeys(prop.Employee_Password()+"\n");
		System.out.println("Login Successful as Employee");
		
		Thread.sleep(50000);
		 
		TakeScreenshot.captureScreenShot(driver);
	  	test = extent.createTest("Employee Home Page Login");
        Assert.assertTrue(driver.getTitle().contains("Employee - Overview"));	 
        
		wait.until(ExpectedConditions.visibilityOf(PageObjectsEmployee.lnk_queries_emp(driver)));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(PageObjectsEmployee.lnk_queries_emp(driver)).build().perform();
		builder.moveToElement(PageObjectsEmployee.lnk_search_queries_emp(driver)).build().perform();
		jse.executeScript("arguments[0].click();", PageObjectsEmployee.lnk_search_queries_emp(driver));
		Thread.sleep(15000);
		
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();		
			alert.accept();		
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Alert is not present");
		}  
			
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(PageObjectsEmployee.visi_query_manage_emp(driver)));	
		
		TakeScreenshot.captureScreenShot(driver);
		test = extent.createTest("Query Management - Filter By");
        Assert.assertTrue(PageObjectsEmployee.visi_query_manage_emp(driver).getText().contains("Query Management"));	 
		
		jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEmployee.visi_query_manage_emp(driver));		  
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.dd_entity_emp(driver)));
		PageObjectsEmployee.dd_entity_emp(driver).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText(data.entity)).click();
		   	
		Thread.sleep(3000);	   	
		   	
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.dd_cate_emp(driver)));
		PageObjectsEmployee.dd_cate_emp(driver).click();
		Thread.sleep(3000);	   	
		driver.findElement(By.partialLinkText(data.category)).click();
		Thread.sleep(3000);
		  
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.dd_status_emp(driver)));
		PageObjectsEmployee.dd_status_emp(driver).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText(data.status)).click();
		Thread.sleep(3000);
			   	
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.txt_created_by_emp(driver)));
		PageObjectsEmployee.txt_created_by_emp(driver).clear();
		PageObjectsEmployee.txt_created_by_emp(driver).sendKeys(data.created_by);
		 
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.btn_date_range_emp(driver)));
		PageObjectsEmployee.btn_date_range_emp(driver).click();
		wait.until(ExpectedConditions.visibilityOf(PageObjectsEmployee.txt_date_from_emp(driver)));
		PageObjectsEmployee.txt_date_from_emp(driver).clear();
		PageObjectsEmployee.txt_date_from_emp(driver).sendKeys(data.date_from);
		wait.until(ExpectedConditions.visibilityOf(PageObjectsEmployee.txt_date_to_emp(driver)));		
		PageObjectsEmployee.txt_date_to_emp(driver).clear();
		PageObjectsEmployee.txt_date_to_emp(driver).sendKeys(data.date_to+"\n");
		Thread.sleep(3000);
		PageObjectsEmployee.visi_outside_date_emp(driver).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.dd_sla_breach_emp(driver)));
		PageObjectsEmployee.dd_sla_breach_emp(driver).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText(data.sla_breach)).click();
		   	
		Thread.sleep(3000);	  
		
		if (data.entity=="Solutions") {
			wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.dd_ig_emp(driver)));
			PageObjectsEmployee.dd_ig_emp(driver).click();
			Thread.sleep(3000);
			driver.findElement(By.partialLinkText(data.select_ig)).click();
			Thread.sleep(3000);
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.txt_CID_emp(driver)));
		PageObjectsEmployee.txt_CID_emp(driver).clear();
		PageObjectsEmployee.txt_CID_emp(driver).sendKeys(data.cid);
		
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.txt_incident_num_emp(driver)));
		PageObjectsEmployee.txt_incident_num_emp(driver).clear();
		PageObjectsEmployee.txt_incident_num_emp(driver).sendKeys(data.incident_number);
				
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.btn_search_emp(driver)));		
		PageObjectsEmployee.btn_search_emp(driver).click();
		
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOf(PageObjectsEmployee.lnk_open_emp(driver)));
		PageObjectsEmployee.lnk_open_emp(driver).click();
		Thread.sleep(3000);
		
		TakeScreenshot.captureScreenShot(driver);
		test = extent.createTest("Search Results displayed");
        Assert.assertTrue(PageObjectsEmployee.lnk_open_emp(driver).isDisplayed());	 
				
		wait.until(ExpectedConditions.visibilityOf(PageObjectsEmployee.lnk_first_query_ans_emp(driver)));
		PageObjectsEmployee.lnk_first_query_ans_emp(driver).click();
		Thread.sleep(15000);
					
		wait.until(ExpectedConditions.visibilityOf(PageObjectsEmployee.visi_inci_num_emp(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.txt_message_emp(driver)));
		PageObjectsEmployee.txt_message_emp(driver).clear();
		PageObjectsEmployee.txt_message_emp(driver).sendKeys(data.message);
		
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.btn_post_message_emp(driver)));
		PageObjectsEmployee.btn_post_message_emp(driver).click();
		Thread.sleep(6000);

		TakeScreenshot.captureScreenShot(driver);
		test = extent.createTest("Replying to the query raised");
        Assert.assertTrue(PageObjectsEmployee.btn_close_query_emp(driver).isDisplayed());	
        
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.btn_close_query_emp(driver)));
		PageObjectsEmployee.btn_close_query_emp(driver).click();
		Thread.sleep(5000);
		
		jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEmployee.lnk_open_emp(driver));;
		wait.until(ExpectedConditions.visibilityOf(PageObjectsEmployee.btn_export_to_queue_emp(driver)));
		PageObjectsEmployee.btn_export_to_queue_emp(driver).click();
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1 = driver.switchTo().alert();		
		alert1.accept();		
		Thread.sleep(5000);  
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,-900)", "");
		Thread.sleep(2000);
								
		builder.moveToElement(PageObjectsEmployee.lnk_queries_emp(driver)).build().perform();
		builder.moveToElement(PageObjectsEmployee.lnk_export_results_emp(driver)).build().perform();
		jse.executeScript("arguments[0].click();", PageObjectsEmployee.lnk_export_results_emp(driver));
		Thread.sleep(15000);
		
		wait.until(ExpectedConditions.visibilityOf(PageObjectsEmployee.visi_export_results_emp(driver)));
		Thread.sleep(3000);
		
		TakeScreenshot.captureScreenShot(driver);
		test = extent.createTest("Exporting the results");
        Assert.assertTrue(PageObjectsEmployee.visi_export_results_emp(driver).isDisplayed());	
        		
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.btn_que_from_emp(driver)));
		PageObjectsEmployee.btn_que_from_emp(driver).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.btn_que_from_emp(driver)));
		PageObjectsEmployee.btn_que_from_emp(driver).click();
		PageObjectsEmployee.btn_que_from_date_emp(driver).click();
		Thread.sleep(3000);
		PageObjectsEmployee.visi_calendar_export_emp(driver).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.btn_que_to_emp(driver)));
		PageObjectsEmployee.btn_que_to_emp(driver).click();
		PageObjectsEmployee.btn_que_to_date_emp(driver).click();
		Thread.sleep(3000);
		PageObjectsEmployee.visi_calendar_export_emp(driver).click();
				
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.btn_search_exp_emp(driver)));
		PageObjectsEmployee.btn_search_exp_emp(driver).click();
		Thread.sleep(6000);
		
		wait.until(ExpectedConditions.visibilityOf(PageObjectsEmployee.visi_search_results_emp(driver)));
		
		List<WebElement> download = (List<WebElement>) driver.findElementsByXPath(".//a[text()='Download']");
	   	System.out.println(download.size());	
	   	download.get(0).click();
	   	   	
//		wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.lnk_download_export_emp(driver)));
//		PageObjectsEmployee.lnk_download_export_emp(driver).click();				
		
		Thread.sleep(6000);		
		
		TakeScreenshot.captureScreenShot(driver);
		test = extent.createTest("View the exported Results");
        Assert.assertTrue(PageObjectsEmployee.lnk_logout_emp(driver).isDisplayed());	
        
        Robot robotObj = new Robot(); 	
        
        // Press tab key twice, goto save button.
		for(int i=0;i<30;i++)
		{
			Thread.sleep(2000);	
			robotObj.keyPress(KeyEvent.VK_TAB);
		}
		
		// Press down save button.
        Thread.sleep(2000);	
        robotObj.keyPress(KeyEvent.VK_ENTER);
        // Release up save button to start download process.
        Thread.sleep(2000);
        robotObj.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);      
         	
  }
  
  @AfterTest
	public void terminatetest() {
	  	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEmployee.lnk_logout_emp(driver)));
		PageObjectsEmployee.lnk_logout_emp(driver).click();
		driver.close();
	}
}
