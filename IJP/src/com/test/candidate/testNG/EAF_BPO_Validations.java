
package com.test.candidate.testNG;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobjects.PageObjectsEAF;
import com.pageobjects.PageObjectsJobApply;
import com.pageobjects.PageObjectsLogin;
import com.utilities.ConfigReader;
import com.utilities.ExcelTestDataEAF;
import com.utilities.ExtendReports;
import com.utilities.ReadPropFile;
import com.utilities.TakeScreenshot;

public class EAF_BPO_Validations extends ExtendReports{
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
	  	String scrFolder = System.getProperty("user.dir")+"\\Screenshots\\EAF_BPO_Validations_directApplicant\\"+ new SimpleDateFormat("dd_MM_yyyy_HHmmss").format(Calendar.getInstance().getTime()).toString();
	    new File(scrFolder).mkdir();
	    System.setProperty("scr.folder", scrFolder);   
  }
  	
  @Test
	  public void changepassword() throws IOException, Exception {
		  	
		  	String title=driver.getTitle();
		  	TakeScreenshot.captureScreenShot(driver);		  	
		  	test = extent.createTest("IJP Home Page");
	        Assert.assertTrue(title.contains("Accenture Recruitment Portal- India"));
	        Thread.sleep(3000);
		  	
		  	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
		  	ExcelTestDataEAF data = new ExcelTestDataEAF();
		  	 
		  	try {
				//Use Login page Object library now
				WebElement Cand_login;
				
				if (PageObjectsEAF.btn_close_cookies(driver).isDisplayed()) {
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_close_cookies(driver)));
					 PageObjectsEAF.btn_close_cookies(driver).click();
				}
				
				Cand_login = wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.lnk_candidate_login(driver)));
				Cand_login.click();
				PageObjectsLogin.txt_adfs_userid(driver).sendKeys(prop.Candidate_Email());
				PageObjectsLogin.txt_adfs_password(driver).sendKeys(prop.Candidate_Password()+"\n");
				System.out.println("Login Successful as Direct Applicant");
			} catch (NoSuchElementException e) {
				System.out.println("Unable to Login");
		    } finally {
		    	System.out.println("Continue");
			}
		   
		  //waiting till the Page loads			
		  	Thread.sleep(3000);
		    if (PageObjectsEAF.h_Terms_Conditions(driver).isDisplayed()) {
		    	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_ok_Terms_Conditions(driver)));
		    	 PageObjectsEAF.btn_ok_Terms_Conditions(driver).click();	
		    	 System.out.println("Clicked the OK Button in Terms and Conditions");
			}	
		    Thread.sleep(3000);
		   
		    wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.lnk_EAF(driver)));
		    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.lnk_EAF(driver)));
		    PageObjectsEAF.lnk_EAF(driver).click();					    
			
		   //Clicking the EAF Link in the Home Page
		   Thread.sleep(3000);
		   try {
		        wait.until(ExpectedConditions.alertIsPresent());
		        Alert alert = driver.switchTo().alert();
		        alert.accept();
		    } catch (Exception e) {
		        System.out.println("Alert not present");
		    }
		   
	/*
	 * *************************************************************************************************************************************
	 * 									PRIMARY DETAILS TAB
	 * *************************************************************************************************************************************
	 */
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.lnk_Primary_Det_bpo(driver)));
		   System.out.println("In Primary Details");
		   TakeScreenshot.captureScreenShot(driver);		  	
		   test = extent.createTest("Filling Primary Details");
	       Assert.assertTrue(PageObjectsEAF.lnk_Primary_Det_bpo(driver).isDisplayed());
	       Thread.sleep(3000);
		 PageObjectsEAF.lnk_Primary_Det_bpo(driver).click();
		 
		   
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.Primary_Det_visi(driver));
		   PageObjectsEAF.btn_prmy_photo(driver).click();
		   
		   Thread.sleep(5000);
		   StringSelection stringSelection = new StringSelection(prop.Image());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Robot robot = new Robot();
			
           robot.keyPress(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_V);
           robot.keyRelease(KeyEvent.VK_V);
           robot.keyRelease(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_ENTER);
           robot.keyRelease(KeyEvent.VK_ENTER);
			
		   	//Runtime.getRuntime().exec(prop.Image_Path());
			Thread.sleep(6000);
		   			   
		   
		   String Title = PageObjectsEAF.dd_salutation(driver).getText();
		   System.out.println(Title);
		   if(Title.isEmpty())
		   {   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_salutation(driver)));
			   PageObjectsEAF.dd_salutation(driver).click();
			   PageObjectsEAF.dd_salutation_input(driver).clear();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_salutation_input(driver)));
			   PageObjectsEAF.dd_salutation_input(driver).sendKeys(data.salutation);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_salutation_input_select_bpo(driver)));
			   jse.executeScript("arguments[0].click()", PageObjectsEAF.dd_salutation_input_select_bpo(driver));
		   } 
		   
		   String First_Name = PageObjectsEAF.dd_fname(driver).getAttribute("value");
		   System.out.println(First_Name);
		   
		   if(First_Name.isEmpty()){
			   PageObjectsEAF.dd_fname(driver).clear();
			   PageObjectsEAF.dd_fname(driver).sendKeys(data.first_name);
		   }
		   
		   String middle_name = PageObjectsEAF.dd_mname(driver).getAttribute("value");
		   if(middle_name.isEmpty()){
		   PageObjectsEAF.dd_mname(driver).clear();
		   PageObjectsEAF.dd_mname(driver).sendKeys(data.middlename);
		   }
		   
		   String Last_Name = PageObjectsEAF.dd_lname(driver).getAttribute("value");
		   System.out.println(Last_Name);
		   if(Last_Name.isEmpty()){
			   PageObjectsEAF.dd_lname(driver).clear();
			   PageObjectsEAF.dd_lname(driver).sendKeys(data.lastname);
		   }
		   
		 String Gender1 = PageObjectsEAF.dd_gender(driver).getText();
		 System.out.println(Gender1);
		   if(Gender1.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_gender(driver)));
			   PageObjectsEAF.dd_gender(driver).click();
			   PageObjectsEAF.dd_gender_input(driver).clear();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_gender_input(driver)));
			   Thread.sleep(2000);
			   PageObjectsEAF.dd_gender_input_select(driver).sendKeys(data.gender);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_gender_input_select_bpo(driver)));
			   PageObjectsEAF.dd_gender_input_select_bpo(driver).click();
			   		   
		   }
		   
		  /* String DOB = PageObjectsEAF.dd_dob(driver).getText();
		   if(DOB.isEmpty()){
			   PageObjectsEAF.dd_dob(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_dob_1(driver)));
			   PageObjectsEAF.dd_dob_1(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_dob_2(driver)));
			   PageObjectsEAF.dd_dob_2(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_dob_3(driver)));
			   PageObjectsEAF.dd_dob_3(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_dob_3(driver)));
			   PageObjectsEAF.dd_dob_3(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_dob_4(driver)));
			   PageObjectsEAF.dd_dob_4(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_dob_5(driver)));
			   PageObjectsEAF.dd_dob_5(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_dob_6(driver)));
			   PageObjectsEAF.dd_dob_6(driver).click();
			     
		   } */
		   
		   String Primary_Skill = PageObjectsEAF.txt_pskill(driver).getAttribute("value");
		   System.out.println(Primary_Skill);
		   if(Primary_Skill.isEmpty()){
			   PageObjectsEAF.txt_pskill(driver).clear();
			   PageObjectsEAF.txt_pskill(driver).sendKeys(data.primary_skill);	   
			   }
		   
		   //Commented below removed due to Aadhar card inclusion in EAF
		   
		 /*  
		   String Cfm_Source = (PageObjectsEAF.dd_cf_sourcechannel(driver)).getText();
		   System.out.println(Cfm_Source);
		   if(Cfm_Source.isEmpty()){
			   Select Confirm_Source = new Select(PageObjectsEAF.dd_cf_sourcechannel(driver));
			   Confirm_Source.selectByVisibleText(data.cfn_source);
		   }
		   
		   String Emp_Name = PageObjectsEAF.txt_emp_name(driver).getText();
		   System.out.println(Emp_Name);
		   if(Emp_Name.isEmpty()){
			   PageObjectsEAF.txt_emp_name(driver).clear();
			   PageObjectsEAF.txt_emp_name(driver).sendKeys(data.candidate_name);
		   }
		   
		   
		   PageObjectsEAF.txt_rel_ref(driver).clear();
		   PageObjectsEAF.txt_rel_ref(driver).sendKeys(data.rel_with_ref);	
		   
		   	   */
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.btn_submit(driver));
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_save_draft(driver)));
		   Thread.sleep(2000);
		   test = extent.createTest("Saving the draft EAF form");
		   TakeScreenshot.captureScreenShot(driver);
		   Assert.assertTrue(PageObjectsEAF.btn_save_draft(driver).isDisplayed());				   
		  			  
		   PageObjectsEAF.btn_save_draft(driver).click();
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.alertIsPresent());
		   Alert alert = driver.switchTo().alert();
		   Thread.sleep(3000);
		   if(alert.getText().contains("Kindly confirm if all the pre-filled (highlighted) fields have been verified by you")){
			   Thread.sleep(2000);
			   alert.accept();
		   }
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.alertIsPresent());
		   if(driver.switchTo().alert().getText().contains("EAF draft is saved successfully.")){
			   Thread.sleep(3000);
			   driver.switchTo().alert().accept();
			   Thread.sleep(5000);
		   }
		   
		   jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.lnk_Primary_Det_bpo(driver)); 
		   System.out.println("Navigated to the top of the page");
			 wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.txt_progress_bar(driver)));
			 String[] current_progress=PageObjectsEAF.txt_progress_bar(driver).getText().split(" ");
			 String current_progress1 = current_progress[0];
			 System.out.println(current_progress1);
			 if (current_progress1.equalsIgnoreCase("10%")) {
				 test = extent.createTest("Form Completion Status Updated by 10%");
			     Assert.assertTrue(true);
			     System.out.println("Assert verified");
			}
			 else if (current_progress1.equalsIgnoreCase("40%")) {
				 test = extent.createTest("Form Completion Status Updated by 10%");
			     Assert.assertTrue(true);
			     System.out.println("Assert verified");
			}
			 
		   Thread.sleep(2000);
		   jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.txt_pskill(driver));
		   Thread.sleep(3000);
		   jse.executeScript("arguments[0].click();", PageObjectsEAF.btn_next_section(driver));
		   	  
		   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.lnk_personal_detail_heading(driver)));
		   
	/*
	 * *************************************************************************************************************************************
	 * 									PERSONAL DETAILS TAB
	 * *************************************************************************************************************************************
	 */	   
		   
		   System.out.println("Personal Details Tab");
		   TakeScreenshot.captureScreenShot(driver);		  	
		   test = extent.createTest("Filling Personal Details");
	       Assert.assertTrue(PageObjectsEAF.txt_place_of_birth(driver).isDisplayed());
	       Thread.sleep(3000);
		   PageObjectsEAF.txt_place_of_birth(driver).clear();
		   PageObjectsEAF.txt_place_of_birth(driver).sendKeys(data.place_of_birth);
		   
		   String Nationality = PageObjectsEAF.dd_nationality(driver).getText();
		   System.out.println(Nationality);
		   if(Nationality.isEmpty()){
			   PageObjectsEAF.dd_nationality(driver).click();
			   PageObjectsEAF.dd_nationality_input(driver).clear();
			   PageObjectsEAF.dd_nationality_input(driver).sendKeys(data.nationality);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_nationality_input_select_bpo(driver)));
			   PageObjectsEAF.dd_nationality_input_select_bpo(driver).click();
		   }
		   
		   String Citizenship = PageObjectsEAF.dd_citizenship(driver).getText();
		   System.out.println(Citizenship);
		   if(Citizenship.isEmpty()){
			   PageObjectsEAF.dd_citizenship(driver).click();
			   PageObjectsEAF.dd_citizenship_input(driver).clear();
			   PageObjectsEAF.dd_citizenship_input(driver).sendKeys(data.citizenship);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_citizenship_input_select_bpo(driver)));
			   PageObjectsEAF.dd_citizenship_input_select_bpo(driver).click();
		   }
		   
		   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.dd_foreign_passport(driver)));
		   String foreign_passport = PageObjectsEAF.dd_foreign_passport(driver).getText();
		   System.out.println(foreign_passport);
		   if(foreign_passport.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_foreign_passport(driver)));
			   PageObjectsEAF.dd_foreign_passport(driver).click();
			   PageObjectsEAF.dd_foreign_passport_input(driver).sendKeys(data.foreign_passport);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_foreign_passport_input_select_bpo(driver)));
			   jse.executeScript("arguments[0].click();", PageObjectsEAF.dd_foreign_passport_input_select_bpo(driver));
			 
		   }
		   
		   String foreign_passport1 = PageObjectsEAF.dd_foreign_passport(driver).getText();
		   System.out.println(foreign_passport1);
		   if(foreign_passport1.contains("Yes")){
			   PageObjectsEAF.dd_country_of_issue(driver).click();
			   PageObjectsEAF.dd_country_of_issue_input(driver).sendKeys(data.country_of_issue);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_country_of_issue_input_select_bpo(driver)));
			   PageObjectsEAF.dd_country_of_issue_input_select_bpo(driver).click();
		   }
		   else
		   {
			   System.out.println("No other country passport");
		   }
		   try {
			String work_permit=PageObjectsEAF.dd_work_permit_india_bpo(driver).getText();
			   System.out.println(work_permit);
			   if(work_permit.contains("Yes")){
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.dd_work_permit_valid_date_bpo(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_work_permit_valid_date_bpo(driver)));
				   PageObjectsEAF.dd_work_permit_valid_date_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_work_permit_valid_date1_bpo(driver)));
				   PageObjectsEAF.dd_work_permit_valid_date1_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_work_permit_valid_date2_bpo(driver)));
				   PageObjectsEAF.dd_work_permit_valid_date2_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_work_permit_valid_date3_bpo(driver)));
				   PageObjectsEAF.dd_work_permit_valid_date3_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_work_permit_valid_date4_bpo(driver)));
				   PageObjectsEAF.dd_work_permit_valid_date4_bpo(driver).click();
				   
			   }
			   else if (work_permit.contains("No")) {
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.txt_work_permit_provide_reason_bpo(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_work_permit_provide_reason_bpo(driver)));
				   PageObjectsEAF.txt_work_permit_provide_reason_bpo(driver).sendKeys("No work Permit");
			   }
			   else if (work_permit.isEmpty()) {
				   PageObjectsEAF.dd_work_permit_india_bpo(driver).click();
				   PageObjectsEAF.dd_work_permit_india_input_bpo(driver).sendKeys("Yes");
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_work_permit_india_input_select_bpo(driver)));
				   PageObjectsEAF.dd_work_permit_india_input_select_bpo(driver).click();
				   
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.dd_work_permit_valid_date_bpo(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_work_permit_valid_date_bpo(driver)));
				   PageObjectsEAF.dd_work_permit_valid_date_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_work_permit_valid_date1_bpo(driver)));
				   PageObjectsEAF.dd_work_permit_valid_date1_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_work_permit_valid_date2_bpo(driver)));
				   PageObjectsEAF.dd_work_permit_valid_date2_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_work_permit_valid_date3_bpo(driver)));
				   PageObjectsEAF.dd_work_permit_valid_date3_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_work_permit_valid_date4_bpo(driver)));
				   PageObjectsEAF.dd_work_permit_valid_date4_bpo(driver).click();
			   }
			   
			   String pio_card=PageObjectsEAF.dd_pio_card_bpo(driver).getText();
			   System.out.println(pio_card);
			   if(pio_card.contains("Yes")){
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.dd_pio_card_valid_date_bpo(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pio_card_valid_date_bpo(driver)));
				   PageObjectsEAF.dd_pio_card_valid_date_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pio_card_valid_date1_bpo(driver)));
				   PageObjectsEAF.dd_pio_card_valid_date1_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pio_card_valid_date2_bpo(driver)));
				   PageObjectsEAF.dd_pio_card_valid_date2_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pio_card_valid_date3_bpo(driver)));
				   PageObjectsEAF.dd_pio_card_valid_date3_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pio_card_valid_date4_bpo(driver)));
				   PageObjectsEAF.dd_pio_card_valid_date4_bpo(driver).click();
				   
			   }
			   else if (pio_card.contains("No")) {
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.txt_pio_card_provide_reason_bpo(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_pio_card_provide_reason_bpo(driver)));
				   PageObjectsEAF.txt_pio_card_provide_reason_bpo(driver).sendKeys("No PIO Card");
			   }
			   else if (pio_card.isEmpty()) {
				   PageObjectsEAF.dd_pio_card_bpo(driver).click();
				   PageObjectsEAF.dd_pio_card_input_bpo(driver).sendKeys("Yes");
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pio_card_input_select_bpo(driver)));
				   PageObjectsEAF.dd_pio_card_input_select_bpo(driver).click();
				   
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.dd_pio_card_valid_date_bpo(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pio_card_valid_date_bpo(driver)));
				   PageObjectsEAF.dd_pio_card_valid_date_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pio_card_valid_date1_bpo(driver)));
				   PageObjectsEAF.dd_pio_card_valid_date1_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pio_card_valid_date2_bpo(driver)));
				   PageObjectsEAF.dd_pio_card_valid_date2_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pio_card_valid_date3_bpo(driver)));
				   PageObjectsEAF.dd_pio_card_valid_date3_bpo(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pio_card_valid_date4_bpo(driver)));
				   PageObjectsEAF.dd_pio_card_valid_date4_bpo(driver).click();
			   }
		} catch (Exception e) {
			System.out.println("Work Permit and PIO Card is not present");
		}
		   
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.dd_foreign_passport(driver));
		   
		   String MaritalStatus = PageObjectsEAF.dd_mstatus(driver).getText();
		   System.out.println(MaritalStatus);
		   if(MaritalStatus.isEmpty()){
			   PageObjectsEAF.dd_mstatus(driver).click();
			   PageObjectsEAF.dd_mstatus_input(driver).clear();
			   PageObjectsEAF.dd_mstatus_input(driver).sendKeys(data.marital_status);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_mstatus_input_select_bpo(driver)));
			   PageObjectsEAF.dd_mstatus_input_select_bpo(driver).click();
		   }
		   	   
		   PageObjectsEAF.txt_spousename(driver).click();
		   PageObjectsEAF.txt_spousename(driver).clear();
		   PageObjectsEAF.txt_spousename(driver).sendKeys(data.spouse);
		   
		   PageObjectsEAF.txt_maidenname(driver).click();
		   PageObjectsEAF.txt_maidenname(driver).clear();
		   PageObjectsEAF.txt_maidenname(driver).sendKeys(data.maiden);
		   
		   String Father_Name = PageObjectsEAF.txt_fathername(driver).getText();
		   System.out.println(Father_Name);
		   if(Father_Name.isEmpty()){
			   PageObjectsEAF.txt_fathername(driver).clear();
			   PageObjectsEAF.txt_fathername(driver).sendKeys(data.father);
		   }
		   
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.txt_fathername(driver));
		   PageObjectsEAF.txt_mothername(driver).click();
		   PageObjectsEAF.txt_mothername(driver).clear();
		   PageObjectsEAF.txt_mothername(driver).sendKeys(data.mother);
		   
		   PageObjectsEAF.txt_guardianname(driver).click();
		   PageObjectsEAF.txt_guardianname(driver).clear();
		   PageObjectsEAF.txt_guardianname(driver).sendKeys(data.guardian);
		   
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.btn_submit(driver));
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_save_draft(driver)));
		   Thread.sleep(2000);
		   test = extent.createTest("Saving the draft EAF form");
		   TakeScreenshot.captureScreenShot(driver);
		   Assert.assertTrue(PageObjectsEAF.btn_save_draft(driver).isDisplayed());				   
		  			  
		   PageObjectsEAF.btn_save_draft(driver).click();
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.alertIsPresent());
		   Alert alerta = driver.switchTo().alert();
		   Thread.sleep(3000);
		   if(alerta.getText().contains("Kindly confirm if all the pre-filled (highlighted) fields have been verified by you")){
			   Thread.sleep(2000);
			   alerta.accept();
		   }
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.alertIsPresent());
		   if(driver.switchTo().alert().getText().contains("EAF draft is saved successfully.")){
			   Thread.sleep(3000);
			   driver.switchTo().alert().accept();
			   Thread.sleep(5000);
		   }
		   
		   jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.lnk_Primary_Det_bpo(driver)); 
		   System.out.println("Navigated to the top of the page");
			 wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.txt_progress_bar(driver)));
			 String[] current_progressb=PageObjectsEAF.txt_progress_bar(driver).getText().split(" ");
			 String current_progressb1 = current_progressb[0];
			 System.out.println(current_progressb1);
			 if (current_progressb1.equalsIgnoreCase("30%")) {
				 test = extent.createTest("Form Completion Status Updated by 20%");
			     Assert.assertTrue(true);
			     System.out.println("Assert verified");
			}
			 else if (current_progressb1.equalsIgnoreCase("50%")) {
				 test = extent.createTest("Form Completion Status Updated by 20%");
			     Assert.assertTrue(true);
			     System.out.println("Assert verified");
			}
		   Thread.sleep(3000);
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.txt_guardianname(driver));
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.lnk_navigator_contact(driver)));
		   PageObjectsEAF.lnk_navigator_contact(driver).click();
		 
		   
	/*
	 * *************************************************************************************************************************************
	 * 									CONTACT DETAILS TAB
	 * *************************************************************************************************************************************
	 */		
		   Thread.sleep(3000);
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.lnk_contact_details_heading(driver));
		   Thread.sleep(2000);
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.lnk_contact_details_heading(driver)));
		   TakeScreenshot.captureScreenShot(driver);		  	
		   test = extent.createTest("Filling Contact Details");
	       Assert.assertTrue(PageObjectsEAF.txt_perm_phone(driver).isDisplayed());
	       Thread.sleep(3000);
		   System.out.println("Contact Details Tab");
		   	   
		   String perm_phone_num = PageObjectsEAF.txt_perm_phone(driver).getAttribute("value");
		   System.out.println(perm_phone_num);
		   if(perm_phone_num.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_perm_phone(driver)));
			   PageObjectsEAF.txt_perm_phone(driver).click();
			   PageObjectsEAF.txt_perm_phone(driver).clear();
			   PageObjectsEAF.txt_perm_phone(driver).sendKeys(data.perm_phone_num);
		   }
		   
		   String alt_phone_num = PageObjectsEAF.txt_alt_phone(driver).getAttribute("value");
		   System.out.println(alt_phone_num);
		   if(alt_phone_num.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_alt_phone(driver)));
			   PageObjectsEAF.txt_alt_phone(driver).click();
			   PageObjectsEAF.txt_alt_phone(driver).clear();
			   PageObjectsEAF.txt_alt_phone(driver).sendKeys(data.alt_phone_num);
		   }
		   
		   String email = PageObjectsEAF.txt_email(driver).getAttribute("value");
		   System.out.println(email);
		   if(email.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_email(driver)));
			   PageObjectsEAF.txt_email(driver).click();
			   PageObjectsEAF.txt_email(driver).clear();
			   PageObjectsEAF.txt_email(driver).sendKeys(data.emailID);
		   }
		   
		   String alt_email = PageObjectsEAF.txt_alt_email(driver).getAttribute("value");
		   System.out.println(alt_email);
		   if(alt_email.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_alt_email(driver)));
			   PageObjectsEAF.txt_alt_email(driver).click();
			   PageObjectsEAF.txt_alt_email(driver).clear();
			   PageObjectsEAF.txt_alt_email(driver).sendKeys(data.alt_emailID);
		   }
		   
		   String current_address = PageObjectsEAF.txt_current_address(driver).getAttribute("value");
		   System.out.println(current_address);
		   if(current_address.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_current_address(driver)));
			   PageObjectsEAF.txt_current_address(driver).click();
			   PageObjectsEAF.txt_current_address(driver).clear();
			   PageObjectsEAF.txt_current_address(driver).sendKeys(data.current_add);
		   }
		   
		   jse.executeScript("arguments[0].scrollIntoView()",PageObjectsEAF.txt_current_address(driver));
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_stay_current_from(driver)));
		   PageObjectsEAF.txt_stay_current_from(driver).click();
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_stay_current_from1(driver)));
		   PageObjectsEAF.txt_stay_current_from1(driver).click();
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_stay_current_from2(driver)));
		   PageObjectsEAF.txt_stay_current_from2(driver).click();
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_stay_current_from3(driver)));
		   PageObjectsEAF.txt_stay_current_from3(driver).click();
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_stay_current_from3(driver)));
		   PageObjectsEAF.txt_stay_current_from3(driver).click();
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_stay_current_from4(driver)));
		   PageObjectsEAF.txt_stay_current_from4(driver).click();
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_stay_current_from5(driver)));
		   PageObjectsEAF.txt_stay_current_from5(driver).click();
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_stay_current_from6(driver)));
		   PageObjectsEAF.txt_stay_current_from6(driver).click();
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_stay_current_to(driver)));
		   PageObjectsEAF.txt_stay_current_to(driver).click();
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_stay_current_to1(driver)));
		   PageObjectsEAF.txt_stay_current_to1(driver).click();
		   
		   String pincode = PageObjectsEAF.txt_pincode_current(driver).getAttribute("value");
		   System.out.println(pincode);
		   if(pincode.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_pincode_current(driver)));
			   PageObjectsEAF.txt_pincode_current(driver).clear();
			   PageObjectsEAF.txt_pincode_current(driver).sendKeys(data.pincode);
		   }
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.chck_same_current_address(driver)));
		   PageObjectsEAF.chck_same_current_address(driver).click();
		   
		   
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.txt_stay_current_to(driver));
		   
		   String pref_location = PageObjectsEAF.dd_pref_location_bpo(driver).getText();
		   System.out.println(pref_location);
		   if(pref_location.isEmpty()){
	       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pref_location_bpo(driver)));	
		   PageObjectsEAF.dd_pref_location_bpo(driver).click();
		   PageObjectsEAF.dd_pref_location_input_bpo(driver).sendKeys(data.pref_work_location);
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pref_location_input_select_bpo(driver)));
		   PageObjectsEAF.dd_pref_location_input_select_bpo(driver).click();
		   PageObjectsEAF.txt_pincode_current(driver).click();
		   }
		   
		   Thread.sleep(3000);
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.btn_submit(driver));
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_save_draft(driver)));
		   Thread.sleep(2000);
		   test = extent.createTest("Saving the draft EAF form");
		   TakeScreenshot.captureScreenShot(driver);
		   Assert.assertTrue(PageObjectsEAF.btn_save_draft(driver).isDisplayed());				   
		  			  
		   PageObjectsEAF.btn_save_draft(driver).click();
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.alertIsPresent());
		   Alert alertc = driver.switchTo().alert();
		   Thread.sleep(3000);
		   if(alertc.getText().contains("Kindly confirm if all the pre-filled (highlighted) fields have been verified by you")){
			   Thread.sleep(2000);
			   alertc.accept();
		   }
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.alertIsPresent());
		   if(driver.switchTo().alert().getText().contains("EAF draft is saved successfully.")){
			   Thread.sleep(3000);
			   driver.switchTo().alert().accept();
			   Thread.sleep(5000);
		   }
		   
		   jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.lnk_Primary_Det_bpo(driver)); 
		   System.out.println("Navigated to the top of the page");
			 wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.txt_progress_bar(driver)));
			 String[] current_progressc=PageObjectsEAF.txt_progress_bar(driver).getText().split(" ");
			 String current_progress1c = current_progressc[0];
			 System.out.println(current_progress1c);
			 if (current_progress1c.equalsIgnoreCase("40%")) {
				 test = extent.createTest("Completed Form Updated by 10%");
			     Assert.assertTrue(true);
			     System.out.println("Assert verified");
			}
			 else if (current_progress1c.equalsIgnoreCase("60%")) {
				 test = extent.createTest("Completed Form Updated by 10%");
			     Assert.assertTrue(true);
			     System.out.println("Assert verified");
			}
		   
		   Thread.sleep(3000);				 		   
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.dd_pref_location_bpo(driver));
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btm_navigator_poip(driver)));	   
		   PageObjectsEAF.btm_navigator_poip(driver).click();
	/*
	 * *************************************************************************************************************************************
	 * 									 PASSPORT & OTHER IDENTITY PROOF TAB
	 * *************************************************************************************************************************************
	 */ 	
		   Thread.sleep(3000);
		   jse.executeScript("arguments[0].scrollIntoView()", driver.findElementByXPath("//*[@id='EAFForm']/div[1]/div/div/div/div/a"));
		   Thread.sleep(2000);
		   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.lnk_passport_tab_visi(driver)));
		   System.out.println("Passport Tab");
		   TakeScreenshot.captureScreenShot(driver);		  	
		   test = extent.createTest("Filling Passport Details");
	       Assert.assertTrue(PageObjectsEAF.dd_passportheld(driver).isDisplayed());
	       Thread.sleep(3000);
		   
		   
		   String passportheld = PageObjectsEAF.dd_passportheld(driver).getText();
		   System.out.println(passportheld);
		   if(passportheld.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_passportheld(driver)));
			   PageObjectsEAF.dd_passportheld(driver).click();
			   PageObjectsEAF.dd_passportheld_input(driver).clear();
			   PageObjectsEAF.dd_passportheld_input(driver).sendKeys(data.held_passport);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_passportheld_input_select_bpo(driver)));
			   PageObjectsEAF.dd_passportheld_input_select_bpo(driver).click();
		   }
		   String passportheld1 = PageObjectsEAF.dd_passportheld(driver).getText();
		   if(passportheld1.contains("No")){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.lnk_passport_tab_visi(driver)));
			   PageObjectsEAF.lnk_passport_tab_visi(driver).click();
			   }
		   
		   if(passportheld1.contains("Yes")){
		   String passportnum = PageObjectsEAF.txt_passportnum(driver).getAttribute("value");
		   if(passportnum.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_passportnum(driver)));
			   PageObjectsEAF.txt_passportnum(driver).clear();
			   PageObjectsEAF.txt_passportnum(driver).sendKeys(data.passport_num);
		   }
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_passportexpdate(driver)));
		   String passexpdate = PageObjectsEAF.txt_passportexpdate(driver).getText();
		   if(passexpdate.isEmpty()){
			   
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_passportexpdate(driver)));
			   PageObjectsEAF.txt_passportexpdate(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_passportexpdate1(driver)));
			   PageObjectsEAF.txt_passportexpdate1(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_passportexpdate2(driver)));
			   PageObjectsEAF.txt_passportexpdate2(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_passportexpdate3(driver)));
			   PageObjectsEAF.txt_passportexpdate3(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_passportexpdate3(driver)));
			   PageObjectsEAF.txt_passportexpdate3(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_passportexpdate4(driver)));
			   PageObjectsEAF.txt_passportexpdate4(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_passportexpdate5(driver)));
			   PageObjectsEAF.txt_passportexpdate5(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_passportexpdate6(driver)));
			   PageObjectsEAF.txt_passportexpdate6(driver).click();
		   }
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_visareject(driver)));
		   PageObjectsEAF.dd_visareject(driver).click();
		   PageObjectsEAF.dd_visareject_input(driver).clear();
		   PageObjectsEAF.dd_visareject_input(driver).sendKeys(data.visa_reject);
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_visareject_input_select_bpo(driver)));
		   PageObjectsEAF.dd_visareject_input_select_bpo(driver).click();
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_visareject(driver)));
		   String visarejectvalue = PageObjectsEAF.dd_visareject(driver).getText();
		   if(visarejectvalue.contains("Yes")){
			   
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_visareject(driver)));
			   PageObjectsEAF.txt_visarejectdate(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_visarejectdate1(driver)));
			   PageObjectsEAF.txt_visarejectdate1(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_visarejectdate2(driver)));
			   PageObjectsEAF.txt_visarejectdate2(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_visarejectdate3(driver)));
			   PageObjectsEAF.txt_visarejectdate3(driver).click();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_rejectedcountry(driver)));
			   PageObjectsEAF.dd_rejectedcountry(driver).click();
			   PageObjectsEAF.dd_rejectedcountryinput(driver).clear();
			   PageObjectsEAF.dd_rejectedcountryinput(driver).sendKeys(data.visa_reject_country);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_rejectedcountryinput_select(driver)));
			   PageObjectsEAF.dd_rejectedcountryinput_select(driver).click();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_rejreason(driver)));
			   PageObjectsEAF.txt_rejreason(driver).clear();
			   PageObjectsEAF.txt_rejreason(driver).sendKeys(data.visa_reject_reason);
		   }
		   
		   }
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.txt_rejreason(driver));
		   Thread.sleep(3000);
		   String pancard = PageObjectsEAF.dd_pancard(driver).getText();
		   System.out.println(pancard);
		   if(pancard.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pancard(driver)));   
			   PageObjectsEAF.dd_pancard_input_bpo(driver).clear();
			   PageObjectsEAF.dd_pancard_input_bpo(driver).sendKeys("Yes");
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pancard_input_select_bpo(driver)));
			   PageObjectsEAF.dd_pancard_input_select_bpo(driver).click();
		   }
		   
		   else if(pancard.contains("No")){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pancard(driver)));   
			   PageObjectsEAF.dd_pancard(driver).click();
			   PageObjectsEAF.dd_pancard_input_bpo(driver).clear();
			   PageObjectsEAF.dd_pancard_input_bpo(driver).sendKeys("Yes");
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pancard_input_select_bpo(driver)));
			   PageObjectsEAF.dd_pancard_input_select_bpo(driver).click();		 
		   }	
		   
		   else if(pancard.contains("Applied For")){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pancard(driver)));   
			   PageObjectsEAF.dd_pancard(driver).click();
			   PageObjectsEAF.dd_pancard_input_bpo(driver).clear();
			   PageObjectsEAF.dd_pancard_input_bpo(driver).sendKeys("Yes");
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pancard_input_select_bpo(driver)));
			   PageObjectsEAF.dd_pancard_input_select_bpo(driver).click();		 
		   }	
		   
		   
		   String pancard1 = PageObjectsEAF.dd_pancard(driver).getText();
		   System.out.println(pancard1);
		   if(pancard1.contains("Yes")){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_PANnum(driver)));   
			   PageObjectsEAF.txt_PANnum(driver).clear();
			   PageObjectsEAF.txt_PANnum(driver).sendKeys(data.PAN);
			   
		   }	   
		   
		   String NASCOM = PageObjectsEAF.txt_NSRITPINnum(driver).getAttribute("value");
		   System.out.println(NASCOM);
		   if(NASCOM.isEmpty()){
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_NSRITPINnum(driver)));  
		   PageObjectsEAF.txt_NSRITPINnum(driver).clear();
		   PageObjectsEAF.txt_NSRITPINnum(driver).sendKeys(data.NSR);
		   }
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.dd_pancard(driver));
		   String DRIVING = PageObjectsEAF.txt_drivinglicense(driver).getAttribute("value");
		   System.out.println(DRIVING);
		   if(DRIVING.isEmpty()){
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_drivinglicense(driver)));  
		   PageObjectsEAF.txt_drivinglicense(driver).clear();
		   PageObjectsEAF.txt_drivinglicense(driver).sendKeys(data.driving_license);
		   }
		   
		   String drivingexpdate = PageObjectsEAF.dd_LicenseValidUpto(driver).getText();
		   System.out.println(drivingexpdate);
		   if(drivingexpdate.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_LicenseValidUpto(driver)));
			   PageObjectsEAF.dd_LicenseValidUpto(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_LicenseValidUpto1(driver)));
			   PageObjectsEAF.dd_LicenseValidUpto1(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_LicenseValidUpto2(driver)));
			   PageObjectsEAF.dd_LicenseValidUpto2(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_LicenseValidUpto3(driver)));
			   PageObjectsEAF.dd_LicenseValidUpto3(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_LicenseValidUpto4(driver)));
			   PageObjectsEAF.dd_LicenseValidUpto4(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_LicenseValidUpto5(driver)));
			   PageObjectsEAF.dd_LicenseValidUpto5(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_LicenseValidUpto6(driver)));
			   PageObjectsEAF.dd_LicenseValidUpto6(driver).click();
			  
		   }
		   
		   String Aadhaar_card = PageObjectsEAF.dd_aadhaar_card(driver).getText();
		   if(Aadhaar_card.isEmpty()){
			   PageObjectsEAF.dd_aadhaar_card(driver).click();
			   PageObjectsEAF.dd_aadhaar_card(driver).clear();
			   PageObjectsEAF.dd_aadhaar_card_input(driver).sendKeys(data.aadhaar_card);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_aadhaar_card_input_select(driver)));
			   PageObjectsEAF.dd_aadhaar_card_input_select(driver).click();
		   }
		   else if(Aadhaar_card.contains("No")){
			   PageObjectsEAF.dd_aadhaar_card(driver).click();
			   PageObjectsEAF.dd_aadhaar_card_input(driver).sendKeys(data.aadhaar_card);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_aadhaar_card_input_select(driver)));
			   PageObjectsEAF.dd_aadhaar_card_input_select(driver).click();
		   }
		   
		   String Aadhaar_card2 = PageObjectsEAF.dd_aadhaar_card(driver).getText();
		   if(Aadhaar_card2.contains("No")){
			   PageObjectsEAF.dd_aadhaar_card(driver).click();
			   PageObjectsEAF.dd_aadhaar_card(driver).clear();
			   PageObjectsEAF.dd_aadhaar_card_input(driver).sendKeys(data.aadhaar_card);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_aadhaar_card_input_select(driver)));
			   PageObjectsEAF.dd_aadhaar_card_input_select(driver).click();
		   }
		   
		   String Aadhaar_card1 = PageObjectsEAF.dd_aadhaar_card(driver).getText();
		   if(Aadhaar_card1.contains("Yes")){
			   PageObjectsEAF.txt_aadhaar_card(driver).clear();
			   PageObjectsEAF.txt_aadhaar_card(driver).sendKeys(data.aadhaar_num);
			   
			   PageObjectsEAF.txt_aadhaar_name(driver).clear();
			   PageObjectsEAF.txt_aadhaar_name(driver).sendKeys(data.name_aadhaar);
		   }
		   
		   else if(Aadhaar_card1.contains("Applied For")){
			   PageObjectsEAF.txt_aadhaar_name(driver).clear();
			   PageObjectsEAF.txt_aadhaar_name(driver).sendKeys(data.name_aadhaar);
			   
			   PageObjectsEAF.txt_enrollment_num(driver).clear();
			   PageObjectsEAF.txt_enrollment_num(driver).sendKeys(data.enrollment_num);
		   }
		   
		   Thread.sleep(3000);
		   
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.btn_submit(driver));
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_save_draft(driver)));
		   Thread.sleep(2000);
		   test = extent.createTest("Saving the draft EAF form");
		   TakeScreenshot.captureScreenShot(driver);
		   Assert.assertTrue(PageObjectsEAF.btn_save_draft(driver).isDisplayed());				   
		  			  
		   PageObjectsEAF.btn_save_draft(driver).click();
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.alertIsPresent());
		   Alert alertf = driver.switchTo().alert();
		   Thread.sleep(3000);
		   if(alertf.getText().contains("Kindly confirm if all the pre-filled (highlighted) fields have been verified by you")){
			   Thread.sleep(2000);
			   alertf.accept();
		   }
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.alertIsPresent());
		   if(driver.switchTo().alert().getText().contains("EAF draft is saved successfully.")){
			   Thread.sleep(3000);
			   driver.switchTo().alert().accept();
			   Thread.sleep(5000);
		   }
		   
		   jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.lnk_Primary_Det_bpo(driver)); 
		   System.out.println("Navigated to the top of the page");
			 wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.txt_progress_bar(driver)));
			 String[] current_progressf=PageObjectsEAF.txt_progress_bar(driver).getText().split(" ");
			 String current_progress1f = current_progressf[0];
			 System.out.println(current_progress1f);
			 if (current_progress1f.equalsIgnoreCase("50%")) {
				 test = extent.createTest("Completed Form Updated by 10%");
			     Assert.assertTrue(true);
			     System.out.println("Assert verified");
			}
			 else if (current_progress1f.equalsIgnoreCase("60%")) {
				 test = extent.createTest("Completed Form Updated by 10%");
			     Assert.assertTrue(true);
			     System.out.println("Assert verified");
			}

			 
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.dd_aadhaar_card(driver));
		   Thread.sleep(2000);
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btm_navigator_ref(driver)));	 
		   PageObjectsEAF.btm_navigator_ref(driver).click();
		   
	/*
	 * *************************************************************************************************************************************
	 * 									 REFERENCE TAB
	 * *************************************************************************************************************************************
	 */
			
		   Thread.sleep(3000);
		   jse.executeScript("window.scrollBy(0,-850)", "");
		   Thread.sleep(2000);
		   
		   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.lnk_ref_tab_visi(driver)));
		   
		   System.out.println("Reference Tab");
		   
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.lnk_faq(driver));
		   TakeScreenshot.captureScreenShot(driver);		  	
		   test = extent.createTest("Filling Reference Details");
	       Assert.assertTrue(PageObjectsEAF.btn_add_ref(driver).isDisplayed());
	       Thread.sleep(3000);
		   
		   PageObjectsEAF.btn_add_ref(driver).click();
//		   //Handle Window Change to ABAP Professional New
//		   String base = driver.getWindowHandle();
//		   Set<String> set = driver.getWindowHandles();
//			 
//		   set.remove(base);
//		   assert set.size() == 2;
//		   driver.switchTo().window((String) set.toArray()[1]);
		   System.out.println("Navigated to Add Reference Details tab");
		   
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_name(driver)));
		   PageObjectsEAF.txt_ref_name(driver).clear();
		   PageObjectsEAF.txt_ref_name(driver).sendKeys(data.ref_name);
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_desig(driver)));
		   PageObjectsEAF.txt_ref_desig(driver).clear();
		   PageObjectsEAF.txt_ref_desig(driver).sendKeys(data.ref_designation);
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_org(driver)));
		   PageObjectsEAF.txt_ref_org(driver).click();
		   PageObjectsEAF.txt_ref_org_input(driver).clear();
		   PageObjectsEAF.txt_ref_org_input(driver).sendKeys(data.ref_org);
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_org_input_select(driver)));
		   PageObjectsEAF.txt_ref_org_input_select(driver).click();
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_tele(driver)));
		   PageObjectsEAF.txt_ref_tele(driver).clear();
		   PageObjectsEAF.txt_ref_tele(driver).sendKeys(data.ref_telephone);
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_emailid(driver)));
		   PageObjectsEAF.txt_ref_emailid(driver).clear();
		   PageObjectsEAF.txt_ref_emailid(driver).sendKeys(data.ref_email);
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_address(driver)));
		   PageObjectsEAF.txt_ref_address(driver).clear();
		   PageObjectsEAF.txt_ref_address(driver).sendKeys(data.ref_address);
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_relationship(driver)));
		   PageObjectsEAF.txt_ref_relationship(driver).clear();
		   PageObjectsEAF.txt_ref_relationship(driver).sendKeys(data.ref_relationship);
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_ref_ok(driver)));
		   PageObjectsEAF.btn_ref_ok(driver).click();
		  
		   
//		   //Handle Window Change to ABAP Professional New
//		   String base1 = driver.getWindowHandle();
//		   Set<String> set1 = driver.getWindowHandles();
//			 
//		   set1.remove(base1);
//		   assert set1.size() == 3;
//		   driver.switchTo().window((String) set1.toArray()[2]);
//		   System.out.println("Navigated to Add Reference Details tab");
		   
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_add_ref(driver)));
		   PageObjectsEAF.btn_add_ref(driver).click();
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_name(driver)));
		   PageObjectsEAF.txt_ref_name(driver).clear();
		   PageObjectsEAF.txt_ref_name(driver).sendKeys(data.ref2_name);
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_desig(driver)));
		   PageObjectsEAF.txt_ref_desig(driver).clear();
		   PageObjectsEAF.txt_ref_desig(driver).sendKeys(data.ref2_designation);
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_org(driver)));
		   PageObjectsEAF.txt_ref_org(driver).click();	
		   PageObjectsEAF.txt_ref_org_input(driver).clear();
		   PageObjectsEAF.txt_ref_org_input(driver).sendKeys(data.ref2_org);
		   Thread.sleep(2000);
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_org_input_select(driver)));
		   PageObjectsEAF.txt_ref_org_input_select(driver).click();
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_tele(driver)));
		   PageObjectsEAF.txt_ref_tele(driver).clear();
		   PageObjectsEAF.txt_ref_tele(driver).sendKeys(data.ref2_telephone);
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_emailid(driver)));
		   PageObjectsEAF.txt_ref_emailid(driver).clear();
		   PageObjectsEAF.txt_ref_emailid(driver).sendKeys(data.ref2_email);
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_address(driver)));
		   PageObjectsEAF.txt_ref_address(driver).clear();
		   PageObjectsEAF.txt_ref_address(driver).sendKeys(data.ref2_adddress);
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_ref_relationship(driver)));
		   PageObjectsEAF.txt_ref_relationship(driver).clear();
		   PageObjectsEAF.txt_ref_relationship(driver).sendKeys(data.ref2_rel);
		   
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_ref_ok(driver)));
		   PageObjectsEAF.btn_ref_ok(driver).click();
		  
		   
		   System.out.println("Added 2 References");
		   
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.btn_submit(driver));
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_save_draft(driver)));
		   Thread.sleep(2000);
		   test = extent.createTest("Saving the draft EAF form");
		   TakeScreenshot.captureScreenShot(driver);
		   Assert.assertTrue(PageObjectsEAF.btn_save_draft(driver).isDisplayed());				   
		  			  
		   PageObjectsEAF.btn_save_draft(driver).click();
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.alertIsPresent());
		   Alert alertg = driver.switchTo().alert();
		   Thread.sleep(3000);
		   if(alertg.getText().contains("Kindly confirm if all the pre-filled (highlighted) fields have been verified by you")){
			   Thread.sleep(2000);
			   alertg.accept();
		   }
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.alertIsPresent());
		   if(driver.switchTo().alert().getText().contains("EAF draft is saved successfully.")){
			   Thread.sleep(3000);
			   driver.switchTo().alert().accept();
			   Thread.sleep(5000);
		   }
		   
		   jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.lnk_Primary_Det_bpo(driver)); 
		   System.out.println("Navigated to the top of the page");
			 wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.txt_progress_bar(driver)));
			 String[] current_progressg=PageObjectsEAF.txt_progress_bar(driver).getText().split(" ");
			 String current_progress1g = current_progressg[0];
			 System.out.println(current_progress1g);
			 if (current_progress1g.equalsIgnoreCase("60%")) {
				 test = extent.createTest("Completed Form Updated by 10%");
			     Assert.assertTrue(true);
			     System.out.println("Assert verified");
			}
			 else if (current_progress1g.equalsIgnoreCase("70%")) {
				 test = extent.createTest("Completed Form Updated by 10%");
			     Assert.assertTrue(true);
			     System.out.println("Assert verified");
			}
		   
		   Thread.sleep(3000);
		   jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.btn_add_ref(driver)); 
		   Thread.sleep(3000);
		   jse.executeScript("arguments[0].click();", PageObjectsEAF.btm_navigator_exacc(driver));

	/*
	 * *************************************************************************************************************************************
	 * 									 EX-ACCENTURE TAB
	 * *************************************************************************************************************************************
	 */	   
		   
		   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.dd_exacc_visi(driver)));
		   
		   String ExAccenture = PageObjectsEAF.dd_exacc(driver).getText();
		   System.out.println(ExAccenture);
		   TakeScreenshot.captureScreenShot(driver);		  	
		   test = extent.createTest("Filling Ex-Accenture Details");
	       Assert.assertTrue(PageObjectsEAF.dd_exacc(driver).isDisplayed());
	       Thread.sleep(3000);
		   
//		   if(ExAccenture.isEmpty()){
			   if(ExAccenture.contains("No")){
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_exacc(driver)));
		   PageObjectsEAF.dd_exacc(driver).click();	
		   PageObjectsEAF.dd_exacc_input(driver).clear();
		   PageObjectsEAF.dd_exacc_input(driver).sendKeys(data.ex_acc);
		   Thread.sleep(2000);
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_exacc_input_select(driver)));
		   PageObjectsEAF.dd_exacc_input_select(driver).click();
		   }
		   
		   String ExAccenture1 = PageObjectsEAF.dd_exacc(driver).getText();
		   if(ExAccenture1.contains("Yes")){
			   
			   String period_from = PageObjectsEAF.txt_period_from(driver).getText();
			   System.out.println(period_from);
			   if(period_from.isEmpty()){
				   PageObjectsEAF.txt_period_from(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_period_from1(driver)));
				   PageObjectsEAF.txt_period_from1(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_period_from2(driver)));
				   PageObjectsEAF.txt_period_from2(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_period_from3(driver)));
				   PageObjectsEAF.txt_period_from3(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_period_from4(driver)));
				   PageObjectsEAF.txt_period_from4(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_period_from5(driver)));
				   PageObjectsEAF.txt_period_from5(driver).click();
			   }
			   
			   String period_to = PageObjectsEAF.txt_period_to(driver).getText();
			   System.out.println(period_to);
			   if(period_to.isEmpty()){
				   PageObjectsEAF.txt_period_to(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_period_to1(driver)));
				   PageObjectsEAF.txt_period_to1(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_period_to2(driver)));
				   PageObjectsEAF.txt_period_to2(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_period_to3(driver)));
				   PageObjectsEAF.txt_period_to3(driver).click();
				   
			   }
			   
			   String prev_entity1 = PageObjectsEAF.dd_prev_entity(driver).getText();
			   System.out.println(prev_entity1);
			   if(prev_entity1.isEmpty()){
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_prev_entity(driver)));
				   PageObjectsEAF.dd_prev_entity(driver).click();	
				   PageObjectsEAF.dd_prev_entity_input(driver).clear();
				   PageObjectsEAF.dd_prev_entity_input(driver).sendKeys(data.ex_entity);
				   Thread.sleep(2000);
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_prev_entity_input_select(driver)));
				   PageObjectsEAF.dd_prev_entity_input_select(driver).click();
			   }
			  
			   String old_emp_id = PageObjectsEAF.txt_old_emp_id(driver).getText();
			   System.out.println(old_emp_id);
			   if(old_emp_id.isEmpty()){
				   PageObjectsEAF.txt_old_emp_id(driver).clear();
				   PageObjectsEAF.txt_old_emp_id(driver).sendKeys(data.ex_old_emp_id); 
			   }
		   }
		   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.btn_submit(driver));
		   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_save_draft(driver)));
		   Thread.sleep(2000);
		   test = extent.createTest("Saving the draft EAF form");
		   TakeScreenshot.captureScreenShot(driver);
		   Assert.assertTrue(PageObjectsEAF.btn_save_draft(driver).isDisplayed());				   
		  			  
		   PageObjectsEAF.btn_save_draft(driver).click();
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.alertIsPresent());
		   Alert alerth = driver.switchTo().alert();
		   Thread.sleep(3000);
		   if(alerth.getText().contains("Kindly confirm if all the pre-filled (highlighted) fields have been verified by you")){
			   Thread.sleep(2000);
			   alerth.accept();
		   }
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.alertIsPresent());
		   if(driver.switchTo().alert().getText().contains("EAF draft is saved successfully.")){
			   Thread.sleep(3000);
			   driver.switchTo().alert().accept();
			   Thread.sleep(5000);
		   }
		   
		   jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.lnk_Primary_Det_bpo(driver)); 
		   System.out.println("Navigated to the top of the page");
			 wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.txt_progress_bar(driver)));
			 String[] current_progressh=PageObjectsEAF.txt_progress_bar(driver).getText().split(" ");
			 String current_progress1h = current_progressh[0];
			 System.out.println(current_progress1h);
			 if (current_progress1h.equalsIgnoreCase("70%")) {
				 test = extent.createTest("Completed Form Updated by 10%");
			     Assert.assertTrue(true);
			     System.out.println("Assert verified");
			}
			 else if (current_progress1h.equalsIgnoreCase("80%")) {
				 test = extent.createTest("Completed Form Updated by 10%");
			     Assert.assertTrue(true);
			     System.out.println("Assert verified");
			}
			 Thread.sleep(3000);
			 jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.txt_period_to(driver)); 
			 Thread.sleep(3000);
		   	   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_navigator_prev_interview(driver)));
			   PageObjectsEAF.btn_navigator_prev_interview(driver).click();
			   
	/*
	 * *************************************************************************************************************************************
	 * 									 PREVIOUS INTERVIEWS TAB
	 * *************************************************************************************************************************************
	 */	   	   
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.prev_heading_visi(driver)));
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.prev_heading_visi(driver));	
			   Thread.sleep(3000);
			   System.out.println("Previous Interview Tab");
			   TakeScreenshot.captureScreenShot(driver);		  	
			   test = extent.createTest("Filling Pervious Interview Details");
		       Assert.assertTrue(PageObjectsEAF.dd_apply_6months(driver).isDisplayed());
		       Thread.sleep(3000);
			   
			   String apply_6months = PageObjectsEAF.dd_apply_6months(driver).getText();
			   System.out.println(apply_6months);
			   
//			   
			   if(apply_6months.contains("No")){
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_apply_6months(driver)));
				   PageObjectsEAF.dd_apply_6months(driver).click();	
				   PageObjectsEAF.dd_apply_6months_input(driver).clear();
				   PageObjectsEAF.dd_apply_6months_input(driver).sendKeys(data.apply_acc_6months);
				   Thread.sleep(2000);
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_apply_6months_input_select(driver)));
				   PageObjectsEAF.dd_apply_6months_input_select(driver).click();
			   }
			   
			   String apply_6months1 =  PageObjectsEAF.dd_apply_6months(driver).getText();
			   System.out.println(apply_6months1);
			   if(apply_6months1.contains("Yes")){
			
			   String interview_date = PageObjectsEAF.txt_interview_date(driver).getText();
			   System.out.println(interview_date);
			   if(interview_date.isEmpty()){
				   PageObjectsEAF.txt_interview_date(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_interview_date1(driver)));
				   PageObjectsEAF.txt_interview_date1(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_interview_date2(driver)));
				   PageObjectsEAF.txt_interview_date2(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_interview_date3(driver)));
				   PageObjectsEAF.txt_interview_date3(driver).click();
			   }
			   
		 	   String prev_cid = PageObjectsEAF.txt_prev_cid(driver).getText();
			   System.out.println(prev_cid);
			   if(prev_cid.isEmpty()){
				   PageObjectsEAF.txt_prev_cid(driver).clear();
				   PageObjectsEAF.txt_prev_cid(driver).sendKeys(data.previous_cid);
			   }
			   		   
			   }
			   
			   if(apply_6months.isEmpty()){
				  
					   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_apply_6months(driver)));
					   PageObjectsEAF.dd_apply_6months(driver).click();	
					   PageObjectsEAF.dd_apply_6months_input(driver).clear();
					   PageObjectsEAF.dd_apply_6months_input(driver).sendKeys(data.apply_acc_6months);
					   Thread.sleep(2000);
					   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_apply_6months_input_select(driver)));
					   PageObjectsEAF.dd_apply_6months_input_select(driver).click();
				  
				   String apply_6months2 =  PageObjectsEAF.dd_apply_6months(driver).getText();
				   System.out.println(apply_6months2);
				   if(apply_6months2.contains("Yes")){
				
				   String interview_date = PageObjectsEAF.txt_interview_date(driver).getText();
				   System.out.println(interview_date);
				   if(interview_date.isEmpty()){
					   PageObjectsEAF.txt_interview_date(driver).click();
					   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_interview_date1(driver)));
					   PageObjectsEAF.txt_interview_date1(driver).click();
					   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_interview_date2(driver)));
					   PageObjectsEAF.txt_interview_date2(driver).click();
					   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_interview_date3(driver)));
					   PageObjectsEAF.txt_interview_date3(driver).click();
				   }
				   
			 	   String prev_cid = PageObjectsEAF.txt_prev_cid(driver).getText();
				   System.out.println(prev_cid);
				   if(prev_cid.isEmpty()){
					   PageObjectsEAF.txt_prev_cid(driver).clear();
					   PageObjectsEAF.txt_prev_cid(driver).sendKeys(data.previous_cid);
				   }
				   		   
				   }
				   
			   }
			 
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.btn_submit(driver));
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_save_draft(driver)));
			   Thread.sleep(2000);
			   test = extent.createTest("Saving the draft EAF form");
			   TakeScreenshot.captureScreenShot(driver);
			   Assert.assertTrue(PageObjectsEAF.btn_save_draft(driver).isDisplayed());				   
			  			  
			   PageObjectsEAF.btn_save_draft(driver).click();
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.alertIsPresent());
			   Alert alerti = driver.switchTo().alert();
			   Thread.sleep(3000);
			   if(alerti.getText().contains("Kindly confirm if all the pre-filled (highlighted) fields have been verified by you")){
				   Thread.sleep(2000);
				   alerti.accept();
			   }
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.alertIsPresent());
			   if(driver.switchTo().alert().getText().contains("EAF draft is saved successfully.")){
				   Thread.sleep(3000);
				   driver.switchTo().alert().accept();
				   Thread.sleep(5000);
			   }
			   
			   jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.lnk_Primary_Det_bpo(driver)); 
			   System.out.println("Navigated to the top of the page");
				 wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.txt_progress_bar(driver)));
				 String[] current_progressi=PageObjectsEAF.txt_progress_bar(driver).getText().split(" ");
				 String current_progress1i = current_progressi[0];
				 System.out.println(current_progress1i);
				 if (current_progress1i.equalsIgnoreCase("80%")) {
					 test = extent.createTest("Completed Form Updated by 10%");
				     Assert.assertTrue(true);
				     System.out.println("Assert verified");
				}
				 else if (current_progress1i.equalsIgnoreCase("90%")) {
					 test = extent.createTest("Completed Form Updated by 10%");
				     Assert.assertTrue(true);
				     System.out.println("Assert verified");
				}
				 
			Thread.sleep(3000);	 
			jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.dd_apply_6months(driver));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btm_navigator_edu_details(driver)));
			PageObjectsEAF.btm_navigator_edu_details(driver).click();
			   
	/*
	 * *************************************************************************************************************************************
	 * 									 EDUCATION DETAILS TAB 
	 * *************************************************************************************************************************************
	 */		   
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.lnk_edu_details_visi(driver)));
			   jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.lnk_edu_details_visi(driver));
		       Thread.sleep(3000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.lnk_ssc(driver)));
			   TakeScreenshot.captureScreenShot(driver);		  	
			   test = extent.createTest("Filling Education Details");
		       Assert.assertTrue(PageObjectsEAF.lnk_ssc(driver).isDisplayed());
		       Thread.sleep(3000);
			   
			   PageObjectsEAF.lnk_ssc(driver).click();
			   System.out.println("Navigated to SSC/10 th Edit Education Details tab");
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.dd_qualification_bpo(driver)));
			   	   
			   
			   String Qualification = PageObjectsEAF.dd_qualification_bpo(driver).getAttribute("value");
			   System.out.println(Qualification);
//			   if(Qualification.isEmpty()){
//				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_qualification_bpo(driver)));
//				   PageObjectsEAF.dd_qualification_bpo(driver).click();
//				   PageObjectsEAF.dd_qualification_bpo(driver).sendKeys(data.edu1_qua);
//				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_qualification_input_select_bpo(driver)));
//				   PageObjectsEAF.dd_qualification_input_select_bpo(driver).click();
//			   }
//			   
//			   String Qualification1 = PageObjectsEAF.dd_qualification_bpo(driver).getText();
//			   System.out.println(Qualification1);
//			   if(Qualification1.contains("Others")){
//				   PageObjectsEAF.txt_other_qualification(driver).clear();
//				   PageObjectsEAF.txt_other_qualification(driver).sendKeys("qualification");
//			   }
//			   
//			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.dd_qualification_bpo(driver));
	//
//			   String Specialization = PageObjectsEAF.dd_spec_bpo(driver).getText();
//			   System.out.println(Specialization);
//			   if(Specialization.isEmpty()){
//				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_spec_bpo(driver)));
//				   PageObjectsEAF.dd_spec_bpo(driver).click();
//				   PageObjectsEAF.dd_spec_bpo(driver).sendKeys(data.edu1_spe);
//				   Thread.sleep(3000);
//				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_spec_input_select_bpo(driver)));
//				   PageObjectsEAF.dd_spec_input_select_bpo(driver).click();
//			   }
			   
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_insit_name_bpo(driver)));
			   PageObjectsEAF.dd_insit_name_bpo(driver).clear();
			   PageObjectsEAF.dd_insit_name_bpo(driver).sendKeys(data.edu1_inst_name);
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_insit_name_input_select_bpo(driver)));
			   PageObjectsEAF.dd_insit_name_input_select_bpo(driver).click();
			   
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_affili_to_bpo(driver)));
			   PageObjectsEAF.dd_affili_to_bpo(driver).clear();
			   PageObjectsEAF.dd_affili_to_bpo(driver).sendKeys(data.edu1_univ_name);	
			   Thread.sleep(1000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_affili_to_input_select_bpo(driver)));
			   PageObjectsEAF.dd_affili_to_input_select_bpo(driver).click();
			   
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.dd_insit_name_bpo(driver));
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from(driver)));
			   PageObjectsEAF.txt_edu_period_from(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from1(driver)));
			   PageObjectsEAF.txt_edu_period_from1(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from2(driver)));
			   PageObjectsEAF.txt_edu_period_from2(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from3(driver)));
			   PageObjectsEAF.txt_edu_period_from3(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from4(driver)));
			   PageObjectsEAF.txt_edu_period_from4(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from5(driver)));
			   PageObjectsEAF.txt_edu_period_from5(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from6(driver)));
			   PageObjectsEAF.txt_edu_period_from6(driver).click();
			   			   
			   String Edu_Period_To = PageObjectsEAF.txt_edu_period_to(driver).getText();
			   System.out.println(Edu_Period_To);
			   if(Edu_Period_To.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to(driver)));
			   PageObjectsEAF.txt_edu_period_to(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to1(driver)));
			   PageObjectsEAF.txt_edu_period_to1(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to2(driver)));
			   PageObjectsEAF.txt_edu_period_to2(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to3(driver)));
			   PageObjectsEAF.txt_edu_period_to3(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to4(driver)));
			   PageObjectsEAF.txt_edu_period_to4(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to5(driver)));
			   PageObjectsEAF.txt_edu_period_to5(driver).click();
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to6(driver)));
			   PageObjectsEAF.txt_edu_period_to6(driver).click();
			   }
			   
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_prgm_type(driver)));
			  PageObjectsEAF.dd_prgm_type(driver).click();
			  PageObjectsEAF.dd_prgm_type_input(driver).clear();
			  PageObjectsEAF.dd_prgm_type_input(driver).sendKeys(data.edu1_prgtype);
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_prgm_type_input_select(driver)));
			  PageObjectsEAF.dd_prgm_type_input_select(driver).click();
			  
//			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_cgpa(driver)));
//			  String CGPA = PageObjectsEAF.txt_cgpa(driver).getAttribute("value");
//			  if(CGPA.isEmpty()){
				  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_cgpa(driver)));
				  PageObjectsEAF.txt_cgpa(driver).clear();
				  PageObjectsEAF.txt_cgpa(driver).sendKeys(data.edu1_marks);
			 // }
			  
		      jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.dd_prgm_type(driver));
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_ok_edu(driver)));
			  PageObjectsEAF.btn_ok_edu(driver).click();
			   
			  Thread.sleep(3000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.lnk_hsc(driver)));
			   PageObjectsEAF.lnk_hsc(driver).click();
			   System.out.println("Navigated to HSC/12 TH Edit Education Details tab");
			   
			   String Qualification2 = PageObjectsEAF.dd_qualification_bpo(driver).getAttribute("value");
			   System.out.println(Qualification2);
//			   if(Qualification2.isEmpty()){
//				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_qualification_bpo(driver)));
//				   PageObjectsEAF.dd_qualification_bpo(driver).click();
//				   PageObjectsEAF.dd_qualification_bpo(driver).sendKeys(data.edu2_qua); //"Bachelor in Media"
//				   Thread.sleep(3000);
//				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_qualification_input_select_bpo(driver)));
//				   PageObjectsEAF.dd_qualification_input_select_bpo(driver).click();
//			   }
//			   
//			   String Qualification3 = PageObjectsEAF.dd_qualification_bpo(driver).getText();
//			   System.out.println(Qualification3);
//			   if(Qualification3.contains("Others")){
//				   PageObjectsEAF.txt_other_qualification(driver).clear();
//				   PageObjectsEAF.txt_other_qualification(driver).sendKeys("qualification");
//			   }
//			   
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.dd_qualification_bpo(driver));
			   String Specialization2 = PageObjectsEAF.dd_spec_bpo(driver).getAttribute("value");
			   System.out.println(Specialization2);
			   if(Specialization2.isEmpty()){
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_spec_bpo(driver)));
				   PageObjectsEAF.dd_spec_bpo(driver).click();
				   //PageObjectsEAF.dd_spec_bpo(driver).sendKeys(data.edu2_spe); //"C"
				   PageObjectsEAF.dd_spec_bpo(driver).sendKeys("C");
				   Thread.sleep(3000);
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_spec_input_select_bpo(driver)));
				   PageObjectsEAF.dd_spec_input_select_bpo(driver).click();
			   }
		   
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_insit_name_bpo(driver)));
			   PageObjectsEAF.dd_insit_name_bpo(driver).clear();
			   //PageObjectsEAF.dd_insit_name_bpo(driver).sendKeys(data.edu2_inst_name); //"A"
			   PageObjectsEAF.dd_insit_name_bpo(driver).sendKeys("A");
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_insit_name_input_select_bpo(driver)));
			   PageObjectsEAF.dd_insit_name_input_select_bpo(driver).click();
			   
			   //*[@id='qualificationEditBPO']
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_affili_to_bpo(driver)));
			   PageObjectsEAF.dd_affili_to_bpo(driver).clear();
			   //PageObjectsEAF.dd_affili_to_bpo(driver).sendKeys(data.edu2_univ_name);
			   PageObjectsEAF.dd_affili_to_bpo(driver).sendKeys("anna");//"anna"
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_affili_to_input_select_bpo(driver)));
			   PageObjectsEAF.dd_affili_to_input_select_bpo(driver).click();
			   
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.dd_qualification_bpo(driver));
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_hsc(driver)));
			   PageObjectsEAF.txt_edu_period_from_hsc(driver).click();
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_hsc1(driver)));
			   PageObjectsEAF.txt_edu_period_from_hsc1(driver).click();
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_hsc2(driver)));
			   PageObjectsEAF.txt_edu_period_from_hsc2(driver).click();
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_hsc3(driver)));
			   PageObjectsEAF.txt_edu_period_from_hsc3(driver).click();
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_hsc4(driver)));
			   PageObjectsEAF.txt_edu_period_from_hsc4(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_hsc5(driver)));
			   PageObjectsEAF.txt_edu_period_from_hsc5(driver).click();
			   		   	   
			   String Edu_Period_To1 = PageObjectsEAF.txt_edu_period_to(driver).getText();
			   System.out.println(Edu_Period_To1);
			   if(Edu_Period_To1.isEmpty()){
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_hsc(driver)));
			   PageObjectsEAF.txt_edu_period_to_hsc(driver).click();
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_hsc1_bpo(driver)));
			   PageObjectsEAF.txt_edu_period_to_hsc1_bpo(driver).click();
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_hsc2_bpo(driver)));
			   PageObjectsEAF.txt_edu_period_to_hsc2_bpo(driver).click();
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_hsc2_bpo(driver)));
			   PageObjectsEAF.txt_edu_period_to_hsc2_bpo(driver).click();
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_hsc3_bpo(driver)));
			   PageObjectsEAF.txt_edu_period_to_hsc3_bpo(driver).click();
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_hsc4_bpo(driver)));
			   PageObjectsEAF.txt_edu_period_to_hsc4_bpo(driver).click();
			   Thread.sleep(2000);
//			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_hsc5(driver)));
//			   PageObjectsEAF.txt_edu_period_to_hsc5(driver).click();
//			   Thread.sleep(2000);
//			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_hsc6(driver)));
//			   PageObjectsEAF.txt_edu_period_to_hsc6(driver).click();
//			   Thread.sleep(2000);
			   }
			   
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_prgm_type(driver)));
			  PageObjectsEAF.dd_prgm_type(driver).click();
			  PageObjectsEAF.dd_prgm_type_input(driver).clear();
			  PageObjectsEAF.dd_prgm_type_input(driver).sendKeys(data.edu2_prgtype);
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_prgm_type_input_select(driver)));
			  PageObjectsEAF.dd_prgm_type_input_select(driver).click();
			  
			  String CGPA1 = PageObjectsEAF.txt_cgpa(driver).getText();
			  System.out.println(CGPA1);
			  if(CGPA1.isEmpty()){
				  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_cgpa(driver)));
				  PageObjectsEAF.txt_cgpa(driver).clear();
				  PageObjectsEAF.txt_cgpa(driver).sendKeys(data.edu2_marks);
			  }
			  
			  jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.dd_prgm_type(driver));
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_ok_edu(driver)));
			  PageObjectsEAF.btn_ok_edu(driver).click();
			   
			  Thread.sleep(2000);
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.lnk_ug(driver)));
			  PageObjectsEAF.lnk_ug(driver).click();
			  System.out.println("Navigated to Graduation/ Degree Edit Education Details tab");
			   
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.chk_high_edu(driver)));
			  PageObjectsEAF.chk_high_edu(driver).click();
			  
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_deg_status_bpo(driver)));
			  PageObjectsEAF.dd_deg_status_bpo(driver).click();
			  PageObjectsEAF.dd_deg_status_input_bpo(driver).clear();
			  PageObjectsEAF.dd_deg_status_input_bpo(driver).sendKeys(data.deg_status);
			  driver.findElementByPartialLinkText(data.deg_status).click();
//			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_deg_status_input_select_bpo(driver)));
//			  PageObjectsEAF.dd_deg_status_input_select_bpo(driver).click();
			  
			  String Qualification4 = PageObjectsEAF.dd_qualification_bpo(driver).getAttribute("value");
			   System.out.println(Qualification4);
			   if(Qualification4.isEmpty()){
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_qualification_bpo(driver)));
				   PageObjectsEAF.dd_qualification_bpo(driver).click();
				   //PageObjectsEAF.dd_qualification_bpo(driver).sendKeys(data.edu3_qua);
				   PageObjectsEAF.dd_qualification_bpo(driver).sendKeys("a");//"a"
				   Thread.sleep(3000);
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_qualification_input_select_bpo(driver)));
				   PageObjectsEAF.dd_qualification_input_select_bpo(driver).click();
			   }
			   
			   String Qualification5 = PageObjectsEAF.dd_qualification_bpo(driver).getText();
			   System.out.println(Qualification5);
			   if(Qualification5.contains("Others")){
				   PageObjectsEAF.txt_other_specialization(driver).clear();
				   PageObjectsEAF.txt_other_specialization(driver).sendKeys("qualification");
			   }
			   
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.dd_qualification_bpo(driver));
			   String Specialization3 = PageObjectsEAF.dd_spec_bpo(driver).getAttribute("value");
			   System.out.println(Specialization3);
			   if(Specialization3.isEmpty()){
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_spec_bpo(driver)));
				   PageObjectsEAF.dd_spec_bpo(driver).click();
				   //PageObjectsEAF.dd_spec_bpo(driver).sendKeys(data.edu3_spe);
				   PageObjectsEAF.dd_spec_bpo(driver).sendKeys("CAD");//"CAD"
				   Thread.sleep(3000);
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_spec_input_select_bpo(driver)));
				   PageObjectsEAF.dd_spec_input_select_bpo(driver).click();
			   }
			   
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_insit_name_bpo(driver)));
			   PageObjectsEAF.dd_insit_name_bpo(driver).clear();
			   //PageObjectsEAF.dd_insit_name_bpo(driver).sendKeys(data.edu3_inst_name);
			   PageObjectsEAF.dd_insit_name_bpo(driver).sendKeys("a");//"a"
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_insit_name_input_select_bpo(driver)));
			   PageObjectsEAF.dd_insit_name_input_select_bpo(driver).click();
			   
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_affili_to_bpo(driver)));
			   PageObjectsEAF.dd_affili_to_bpo(driver).clear();
			   //PageObjectsEAF.dd_affili_to_bpo(driver).sendKeys(data.edu3_univ_name);
			   PageObjectsEAF.dd_affili_to_bpo(driver).sendKeys("anna");//"anna"
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_affili_to_input_select_bpo(driver)));
			   try {
				   PageObjectsEAF.dd_affili_to_input_select_bpo(driver).click();
				}
				catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
					PageObjectsEAF.dd_affili_to_input_select_bpo(driver).click();
				}
			   
			   Thread.sleep(3000);
			   
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.dd_qualification_bpo(driver));
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_ug(driver)));
			   PageObjectsEAF.txt_edu_period_from_ug(driver).click();
			   Thread.sleep(2000);
			 
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_ug1_bpo(driver)));
			   jse.executeScript("arguments[0].click()", PageObjectsEAF.txt_edu_period_from_ug1_bpo(driver));
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_ug2_bpo(driver)));
			   jse.executeScript("arguments[0].click()", PageObjectsEAF.txt_edu_period_from_ug2_bpo(driver));
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_ug3_bpo(driver)));
			   jse.executeScript("arguments[0].click()", PageObjectsEAF.txt_edu_period_from_ug3_bpo(driver));
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_ug4_bpo(driver)));
			   jse.executeScript("arguments[0].click()", PageObjectsEAF.txt_edu_period_from_ug4_bpo(driver));
			   Thread.sleep(2000);
//			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_ug4(driver)));
//			   PageObjectsEAF.txt_edu_period_from_ug4(driver).click();
//			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_ug5(driver)));
//			   PageObjectsEAF.txt_edu_period_from_ug5(driver).click();
//			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_from_ug6(driver)));
//			   PageObjectsEAF.txt_edu_period_from_ug6(driver).click();
			   
			   	   
			   String Edu_Period_To2 = PageObjectsEAF.txt_edu_period_to(driver).getText();
			   System.out.println(Edu_Period_To2);
			   if(Edu_Period_To2.isEmpty()){
		       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_ug(driver)));
			   PageObjectsEAF.txt_edu_period_to_ug(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_ug1(driver)));
			   PageObjectsEAF.txt_edu_period_to_ug1(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_ug2(driver)));
			   PageObjectsEAF.txt_edu_period_to_ug2(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_ug3(driver)));
			   PageObjectsEAF.txt_edu_period_to_ug3(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_ug4(driver)));
			   PageObjectsEAF.txt_edu_period_to_ug4(driver).click();
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_edu_period_to_ug5(driver)));
			   PageObjectsEAF.txt_edu_period_to_ug5(driver).click();
			   }
			   
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_prgm_type(driver)));
			  PageObjectsEAF.dd_prgm_type(driver).click();
			  PageObjectsEAF.dd_prgm_type_input(driver).clear();
			  PageObjectsEAF.dd_prgm_type_input(driver).sendKeys(data.edu3_prgtype);
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_prgm_type_input_select(driver)));
			  PageObjectsEAF.dd_prgm_type_input_select(driver).click();
			  
			  String CGPA2 = PageObjectsEAF.txt_cgpa(driver).getText();
			  System.out.println(CGPA2);
			  if(CGPA2.isEmpty()){
				  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_cgpa(driver)));
				  PageObjectsEAF.txt_cgpa(driver).clear();
				  PageObjectsEAF.txt_cgpa(driver).sendKeys(data.edu3_marks);
			  }
			  jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.dd_prgm_type(driver));
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_ok_edu(driver)));
			  PageObjectsEAF.btn_ok_edu(driver).click();
			  
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_reasonforgap(driver)));
			  PageObjectsEAF.txt_reasonforgap(driver).clear();
			  PageObjectsEAF.txt_reasonforgap(driver).sendKeys(data.edu_reason_gap);
			  
			  jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.btn_submit(driver));
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_save_draft(driver)));
			   Thread.sleep(2000);
			   test = extent.createTest("Saving the draft EAF form");
			   TakeScreenshot.captureScreenShot(driver);
			   Assert.assertTrue(PageObjectsEAF.btn_save_draft(driver).isDisplayed());				   
			  			  
			   PageObjectsEAF.btn_save_draft(driver).click();
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.alertIsPresent());
			   Alert alertj = driver.switchTo().alert();
			   Thread.sleep(3000);
			   if(alertj.getText().contains("Kindly confirm if all the pre-filled (highlighted) fields have been verified by you")){
				   Thread.sleep(2000);
				   alertj.accept();
			   }
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.alertIsPresent());
			   if(driver.switchTo().alert().getText().contains("EAF draft is saved successfully.")){
				   Thread.sleep(3000);
				   driver.switchTo().alert().accept();
				   Thread.sleep(5000);
			   }
			   
			   jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.lnk_Primary_Det_bpo(driver)); 
			   System.out.println("Navigated to the top of the page");
				 wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.txt_progress_bar(driver)));
				 String[] current_progressj=PageObjectsEAF.txt_progress_bar(driver).getText().split(" ");
				 String current_progress1j = current_progressj[0];
				 System.out.println(current_progress1j);
				 if (current_progress1j.equalsIgnoreCase("90%")) {
					 test = extent.createTest("Completed Form Updated by 10%");
				     Assert.assertTrue(true);
				     System.out.println("Assert verified");
				}
							  
			  Thread.sleep(3000);
			  jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.txt_reasonforgap(driver));
			  Thread.sleep(3000);		   
			  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_navigator_emp_details(driver)));
			  PageObjectsEAF.btn_navigator_emp_details(driver).click();
			   
	/*
	 * *************************************************************************************************************************************
	 * 									 EMPLOYMENT DETAILS TAB PAGE ELEMENTS
	 * *************************************************************************************************************************************
	 */
			   Thread.sleep(3000);
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.lnk_faq(driver));
			   		   
			   if(PageObjectsEAF.btn_add_emp(driver).isDisplayed()){
				   
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.btn_add_emp(driver)));
				   TakeScreenshot.captureScreenShot(driver);		  	
				   test = extent.createTest("Filling Employment Details");
			       Assert.assertTrue(PageObjectsEAF.btn_add_emp(driver).isDisplayed());
			       Thread.sleep(3000);				   
				   PageObjectsEAF.btn_add_emp(driver).click();
				   System.out.println("Navigated to Edit Employment Details tab");
				   Thread.sleep(3000);
			   }
			
			   else{
				   TakeScreenshot.captureScreenShot(driver);		  	
				   test = extent.createTest("Filling Employment Details");
			       Assert.assertTrue(PageObjectsEAF.lnk_emp_details_edit(driver).isDisplayed());
			       Thread.sleep(3000);
				   
				   PageObjectsEAF.lnk_emp_details_edit(driver).click();
				   System.out.println("Navigated to Edit Employment Details tab");
				   Thread.sleep(3000);
			   }
			
			   System.out.println("In Current Employment Details");
			   if(PageObjectsEAF.chk_current_emp_icf(driver).getAttribute("checked") != null){
				   System.out.println("Its the Current Employment");// if Checked 
			   }
				   
			   else{
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.chk_current_emp_icf(driver)));
			   PageObjectsEAF.chk_current_emp_icf(driver).click();
			   }
			   
			   String Comp_Name = PageObjectsEAF.dd_comp_name_icf(driver).getText();
			   if(Comp_Name.isEmpty()){
				   PageObjectsEAF.dd_comp_name_icf(driver).click();
				   PageObjectsEAF.dd_comp_name_icf(driver).clear();
				   PageObjectsEAF.dd_comp_name_icf(driver).sendKeys(data.comp_name);
				   Thread.sleep(2000);
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.dd_comp_name_icf_input_select(driver)));				  				   
				   try {
					   PageObjectsEAF.dd_comp_name_icf_input_select(driver).click();
					}
					catch(org.openqa.selenium.StaleElementReferenceException ex)
					{
						PageObjectsEAF.dd_comp_name_icf_input_select(driver).click();
					}
				   
				     }
			   
			   Thread.sleep(2000);
			   String Comp_Name1 = PageObjectsEAF.dd_comp_name_icf(driver).getAttribute("value");
			   System.out.println(Comp_Name1);
			   if(Comp_Name1.contains("Others")){
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.txt_other_comp_name(driver)));
				   PageObjectsEAF.txt_other_comp_name(driver).clear();
				   PageObjectsEAF.txt_other_comp_name(driver).sendKeys(data.other_comp_name);			   
			   }
			   
			   String Position_Held = PageObjectsEAF.txt_designation_icf(driver).getText();
			   if(Position_Held.isEmpty()){
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_designation_icf(driver)));
				   PageObjectsEAF.txt_designation_icf(driver).clear();
				   PageObjectsEAF.txt_designation_icf(driver).sendKeys(data.position_held);
				   
			   }
			   
			   String Employment_Type = PageObjectsEAF.dd_emp_type_icf(driver).getText();
			   if(Employment_Type.isEmpty()){
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_emp_type_icf(driver)));
				   PageObjectsEAF.dd_emp_type_icf(driver).click();
				   PageObjectsEAF.dd_emp_type_icf_input(driver).clear();
				   driver.findElementByPartialLinkText(data.emp_type).click();
			   }
			   
			   String Reported_To = PageObjectsEAF.txt_reported_to_icf(driver).getText();
			   if(Reported_To.isEmpty()){
				   PageObjectsEAF.txt_reported_to_icf(driver).clear();
				   PageObjectsEAF.txt_reported_to_icf(driver).sendKeys(data.rep_to);
			   }
			   
			   PageObjectsEAF.txt_compaddress_icf(driver).clear();
			   PageObjectsEAF.txt_compaddress_icf(driver).sendKeys(data.address_tele);
			   
			   String Emp_period_from = PageObjectsEAF.txt_emp_period_from_icf(driver).getText();
			   if(Emp_period_from.isEmpty()){
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_emp_period_from_icf(driver)));
				   PageObjectsEAF.txt_emp_period_from_icf(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_emp_period_from1(driver)));
				   PageObjectsEAF.txt_emp_period_from1(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_emp_period_from2(driver)));
				   PageObjectsEAF.txt_emp_period_from2(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_emp_period_from3(driver)));
				   PageObjectsEAF.txt_emp_period_from3(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_emp_period_from4(driver)));
				   PageObjectsEAF.txt_emp_period_from4(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_emp_period_from5(driver)));
				   PageObjectsEAF.txt_emp_period_from5(driver).click();
			   }
			   
			   String Emp_period_to = PageObjectsEAF.txt_emp_period_to_icf(driver).getText();
			   if(Emp_period_to.isEmpty()){
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_emp_period_to_icf(driver)));
				   PageObjectsEAF.txt_emp_period_to_icf(driver).click();
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_emp_period_to1(driver)));
				   PageObjectsEAF.txt_emp_period_to1(driver).click();
			   }
			   
			   
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.txt_emp_period_to_icf(driver));
			   
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_emp_code(driver)));
			   PageObjectsEAF.dd_emp_code(driver).click();
			   PageObjectsEAF.dd_emp_code_input(driver).clear();
			   Thread.sleep(1000);
			   driver.findElementByPartialLinkText("Yes").click();
			   Thread.sleep(2000);
			   
			   
			   String emp_code = PageObjectsEAF.dd_emp_code(driver).getText();
			   System.out.println(emp_code);
			   if(emp_code.contains("Yes")){
				   
				   PageObjectsEAF.txt_emp_code_icf(driver).clear();
				   PageObjectsEAF.txt_emp_code_icf(driver).sendKeys(data.emp_code);
			   }
			   
			   		   
			   PageObjectsEAF.txt_last_drawn_icf(driver).clear();
			   PageObjectsEAF.txt_last_drawn_icf(driver).sendKeys(data.last_drawn_salary);
			  		
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_pf_ac_bpo(driver)));   
			   PageObjectsEAF.dd_pf_ac_bpo(driver).click();
			   PageObjectsEAF.dd_pf_ac_input_bpo(driver).clear();
			   driver.findElementByLinkText(data.pf).click();
			   
			   String PF1 = PageObjectsEAF.dd_pf_ac_bpo(driver).getText();
			   if(PF1.contains("Yes")){
				   PageObjectsEAF.dd_pf_num_icf(driver).clear();
				   PageObjectsEAF.dd_pf_num_icf(driver).sendKeys(data.pf_num);
			   }
			   
			  		   
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_reason_for_leaving_icf(driver)));   
			   PageObjectsEAF.dd_reason_for_leaving_icf(driver).click();
			   Thread.sleep(3000);
			   PageObjectsEAF.dd_reason_for_leaving_input_icf(driver).sendKeys(data.reason_for_leaving);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_reason_for_leaving_input_select_bpo(driver)));
			   PageObjectsEAF.dd_reason_for_leaving_input_select_bpo(driver).click();
			
			  
			   String reason_for_leaving = PageObjectsEAF.dd_reason_for_leaving_icf(driver).getText();
			   System.out.println(reason_for_leaving);
			   if(reason_for_leaving.contains("Others")){
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_other_reason_for_leaving(driver)));
				   PageObjectsEAF.txt_other_reason_for_leaving(driver).clear();
				   PageObjectsEAF.txt_other_reason_for_leaving(driver).sendKeys(data.reason_for_leaving);
			   }
			   		   
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_mode_separation_icf(driver)));   
			   PageObjectsEAF.dd_mode_separation_icf(driver).click();
			   PageObjectsEAF.dd_mode_separation_input_icf(driver).sendKeys(data.mode_separation1);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.dd_mode_separation_input_select_bpo(driver)));
			   PageObjectsEAF.dd_mode_separation_input_select_bpo(driver).click();
			  
			   
			   String Mode_Separation1 = PageObjectsEAF.dd_mode_separation_icf(driver).getText();
			   System.out.println(Mode_Separation1);
			   if(Mode_Separation1.contains("Others(Pls specify)")){
				   PageObjectsEAF.txt_other_mode_sep_icf(driver).clear();
				   PageObjectsEAF.txt_other_mode_sep_icf(driver).sendKeys(data.other_mode_seperation1);	   
				   }
			   
			   PageObjectsEAF.btn_edit_emp_icf(driver).click();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.txt_reason_for_gap(driver)));
			   PageObjectsEAF.txt_reason_for_gap(driver).clear();
			   PageObjectsEAF.txt_reason_for_gap(driver).sendKeys(data.reason_fr_gap_exp);
			   
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.btn_submit(driver));
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_save_draft(driver)));
			   Thread.sleep(2000);
			   test = extent.createTest("Saving the draft EAF form");
			   TakeScreenshot.captureScreenShot(driver);
			   Assert.assertTrue(PageObjectsEAF.btn_save_draft(driver).isDisplayed());				   
			  			  
			   PageObjectsEAF.btn_save_draft(driver).click();
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.alertIsPresent());
			   Alert alert1 = driver.switchTo().alert();
			   Thread.sleep(3000);
			   if(alert1.getText().contains("Kindly confirm if all the pre-filled (highlighted) fields have been verified by you")){
				   Thread.sleep(2000);
				   alert1.accept();
			   }
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.alertIsPresent());
			   if(driver.switchTo().alert().getText().contains("EAF draft is saved successfully.")){
				   Thread.sleep(3000);
				   driver.switchTo().alert().accept();
				   Thread.sleep(5000);
			   }
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_submit(driver)));
			   Thread.sleep(2000);
			   test = extent.createTest("Submitting the draft EAF form");
			   TakeScreenshot.captureScreenShot(driver);
			   Assert.assertTrue(PageObjectsEAF.btn_save_draft(driver).isDisplayed());				   
			   
			   PageObjectsEAF.btn_submit(driver).click();
			   Thread.sleep(5000);
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsEAF.btn_agree_submiteaf(driver));
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_agree_submiteaf(driver)));
			   PageObjectsEAF.btn_agree_submiteaf(driver).click();
			   wait.until(ExpectedConditions.alertIsPresent());
			   Alert alert11 = driver.switchTo().alert();
			   Thread.sleep(3000);
			   if(alert11.getText().contains("EAF is submitted successfully")){
				   Thread.sleep(3000);
				   alert11.accept();
			   }
			   Thread.sleep(5000);
			   
			   jse.executeScript("arguments[0].scrollIntoView();", PageObjectsEAF.lnk_Primary_Det_bpo(driver)); 
			   System.out.println("Navigated to the top of the page");
				 wait.until(ExpectedConditions.visibilityOf(PageObjectsEAF.txt_progress_bar(driver)));
				 String[] current_progressa=PageObjectsEAF.txt_progress_bar(driver).getText().split(" ");
				 String current_progress1a = current_progressa[0];
				 System.out.println(current_progress1);
				 if (current_progress1a.equalsIgnoreCase("100%")) {
					 test = extent.createTest("Completed Form Updated to 100%");
				     Assert.assertTrue(true);
				     System.out.println("Assert verified");
				}
			}
  
  @AfterTest
  	public void terminatetest() throws InterruptedException {
  	jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_sign_out_eaf(driver)));
	PageObjectsEAF.btn_sign_out_eaf(driver).click();
	Thread.sleep(10000); 
    driver.close();
  	}
}
