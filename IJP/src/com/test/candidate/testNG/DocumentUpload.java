package com.test.candidate.testNG;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.pageobjects.PageObjectDocUpload;
import com.pageobjects.PageObjectsEAF;
import com.pageobjects.PageObjectsJobApply;
import com.pageobjects.PageObjectsLogin;
import com.utilities.ConfigReader;
import com.utilities.ExcelTestDataEAF;
import com.utilities.ExtendReports;
import com.utilities.TakeScreenshot;

public class DocumentUpload extends ExtendReports {
	
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
	  	String scrFolder = System.getProperty("user.dir")+"\\Screenshots\\DocumentUpload_directApplicant\\"+ new SimpleDateFormat("dd_MM_yyyy_HHmmss").format(Calendar.getInstance().getTime()).toString();
	    new File(scrFolder).mkdir();
	    System.setProperty("scr.folder", scrFolder);
  }
  	
  @Test
  public void changepassword() throws IOException, Exception {
	  	
	  	String title=driver.getTitle();	  	 
	  	test = extent.createTest("IJP Home Page");
        Assert.assertTrue(title.contains("Accenture Recruitment Portal- India"));	  	
	  	
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
			    	
			    
			    StringSelection stringSelection = new StringSelection(prop.Image());
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
				Robot robot = new Robot();
				
			  //waiting till the Page loads
			    			        
			    switch(prop.Entity_DocumentUpload()){
			    case "SWF":{
			    	Thread.sleep(6000);
			    	 if (PageObjectsEAF.h_Terms_Conditions(driver).isDisplayed()) {
					    	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_ok_Terms_Conditions(driver)));
					    	 PageObjectsEAF.btn_ok_Terms_Conditions(driver).click();	
					    	 System.out.println("Clicked the OK Button in Terms and Conditions");
						}	
					    
			    	wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_upload_docs_swf(driver)));				    
			    	
				    wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_progress_bar_bpo(driver)));
				    String progress_current = PageObjectDocUpload.img_progress_bar_bpo(driver).getAttribute("value");
				    
				    test = extent.createTest("Clicking the Document Upload Link");
				    TakeScreenshot.captureScreenShot(driver);
				    Assert.assertTrue(PageObjectDocUpload.lnk_upload_docs_swf(driver).isDisplayed());	
				    
				    PageObjectDocUpload.lnk_upload_docs_swf(driver).click();
				    
				    Thread.sleep(10000);
				    
				    //Handle Windows Change to Document Upload Frame inside the Main page Of IJP

					driver.switchTo().frame(0);
					System.out.println("Navigated to document upload frame");
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.visi_doc_upload_swf(driver)));
					
					//Scrolling Down
					jse.executeScript("window.scrollBy(0,150)", "");
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_lets_get_started_swf(driver)));
					test = extent.createTest("Clicking Lets get started button");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_lets_get_started_swf(driver).isDisplayed());	
				    
					PageObjectDocUpload.btn_lets_get_started_swf(driver).click();
					Thread.sleep(3000);
								
					try {
						if(PageObjectDocUpload.visi_terms_cond_swf(driver).isDisplayed()){
							jse.executeScript("window.scrollBy(0,150)", "");
							wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_agree_terms_swf(driver)));
							PageObjectDocUpload.btn_agree_terms_swf(driver).click();
							Thread.sleep(6000);				
						}
					} catch (Exception e) {
						System.out.println("No terms and conditions are displayed\n" + e);
					}
					
					System.out.println("Navigated to Pan Card");
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.visi_doc_up_page_bpo(driver)));
					
					String progress_value = PageObjectDocUpload.value_percentage_progress_bpo(driver).getText();
					System.out.println(progress_value);
					
					jse.executeScript("window.scrollBy(0,150)", "");
					Thread.sleep(3000);
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.visi_PAN_swf(driver)));
					jse.executeScript("arguments[0].scrollIntoView()", PageObjectDocUpload.visi_PAN_swf(driver));
					test = extent.createTest("Uploading the PAN Card");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_PAN_swf(driver).isDisplayed());	
				    
			        PageObjectDocUpload.btn_plus_PAN_swf(driver).click();
			        Thread.sleep(2000);
			        robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
			        //Runtime.getRuntime().exec(prop.Image_Path());
					Thread.sleep(3000);
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_attach_pan_swf(driver)));
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.img_attach_pan_swf(driver)));
					PageObjectDocUpload.img_attach_pan_swf(driver).click();
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					System.out.println("Switched to the frame outside");
					jse.executeScript("window.scrollBy(0,-300)", "");
					Thread.sleep(3000);
					driver.switchTo().frame(0);
					System.out.println("Switched to the frame inside");
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.lnk_go_back_pan_swf(driver)));
					
					if(PageObjectDocUpload.visi_pan_copy_swf(driver).getText().contentEquals("PAN Copy")){
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_edit_pan_attach_swf(driver)));
						PageObjectDocUpload.btn_edit_pan_attach_swf(driver).click();
						Thread.sleep(2000);
//						Runtime.getRuntime().exec(prop.Image_Path());
						robot.keyPress(KeyEvent.VK_CONTROL);
			            robot.keyPress(KeyEvent.VK_V);
			            robot.keyRelease(KeyEvent.VK_V);
			            robot.keyRelease(KeyEvent.VK_CONTROL);
			            robot.keyPress(KeyEvent.VK_ENTER);
			            robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.btn_delete_pan_attach_swf(driver)));
						PageObjectDocUpload.btn_delete_pan_attach_swf(driver).click();						
					}
					
					Thread.sleep(3000);
					jse.executeScript("arguments[0].scrollIntoView()", PageObjectDocUpload.visi_PAN_swf(driver));
					
					PageObjectDocUpload.btn_plus_PAN_swf(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					
					jse.executeScript("window.scrollBy(0,200)", "");
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_upload_PAN_swf(driver)));
						PageObjectDocUpload.btn_upload_PAN_swf(driver).click();
						Thread.sleep(2000);
						
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_yes_swf(driver)));
						PageObjectDocUpload.btn_yes_swf(driver).click();
						
						Thread.sleep(8000);
						
						wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_pan_swf(driver)));
								
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_nxt_session_pan_swf(driver)));
					
					PageObjectDocUpload.lnk_nxt_session_pan_swf(driver).click();
					
					String progress_value_pan = PageObjectDocUpload.value_percentage_progress_bpo(driver).getText();
					System.out.println(progress_value_pan);
					
					System.out.println("Navigated to Aadhar Card");
					jse.executeScript("window.scrollBy(0,150)", "");
					Thread.sleep(3000);
					
//					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_aadhar_card_swf(driver)));
//					PageObjectDocUpload.lnk_aadhar_card_swf(driver).click();
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.visi_aadhar_swf(driver)));
					
					String no_aadhar = "No";
					if(no_aadhar.contains("Yes")){
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.chk_i_dnt_have_aadhar_swf(driver)));
						PageObjectDocUpload.chk_i_dnt_have_aadhar_swf(driver).click();
						Thread.sleep(3000);
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.chk_aadhar_yes_bpo(driver)));
						PageObjectDocUpload.chk_aadhar_yes_bpo(driver).click();
						Thread.sleep(3000);
										
					}
					else{
						test = extent.createTest("Uploading the Aadhar Card");
						TakeScreenshot.captureScreenShot(driver);
				        Assert.assertTrue(PageObjectDocUpload.btn_plus_aadhar_swf(driver).isDisplayed());	
					    	
					PageObjectDocUpload.btn_plus_aadhar_swf(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					jse.executeScript("window.scrollBy(0,200)", "");
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_upload_aadhar_swf(driver)));
					PageObjectDocUpload.btn_upload_aadhar_swf(driver).click();
					
					Thread.sleep(2000);
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_yes_swf(driver)));
					PageObjectDocUpload.btn_yes_swf(driver).click();
					
					Thread.sleep(8000);
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_aadhar_bpo(driver)));
													
					}
								
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_nxt_session_aadhar_swf(driver)));
					
					PageObjectDocUpload.lnk_nxt_session_aadhar_swf(driver).click();
					
					String progress_value_aadhar = PageObjectDocUpload.value_percentage_progress_bpo(driver).getText();
					System.out.println(progress_value_aadhar);
					
					System.out.println("Navigated to Current Employment Details");
					
					jse.executeScript("window.scrollBy(0,150)", "");
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.visi_current_emp_swf(driver)));
//					
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_current_emp_swf(driver)));
					
					test = extent.createTest("Uploading the Current Employment Details");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_current_emp_swf(driver).isDisplayed());	
			        PageObjectDocUpload.btn_plus_current_emp_swf(driver).click();
			        Thread.sleep(2000);
//			        Runtime.getRuntime().exec(prop.Image_Path());
			        robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					jse.executeScript("window.scrollBy(0,250)", "");
					
									
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_upload_current_emp_swf(driver)));			
					PageObjectDocUpload.btn_upload_current_emp_swf(driver).click();
					
					Thread.sleep(2000);
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_yes_swf(driver)));
					PageObjectDocUpload.btn_yes_swf(driver).click();
					
					Thread.sleep(10000);
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_current_emp_swf(driver)));
									
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_nxt_session_current_emp_swf(driver)));
					PageObjectDocUpload.lnk_nxt_session_current_emp_swf(driver).click();
													
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					System.out.println("Navigated to Last 3 Payslips");
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_payslips_swf(driver));
					Thread.sleep(5000);
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_payslips_swf(driver)));
					test = extent.createTest("Uploading the Last 3 Payslips");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_payslips_swf(driver).isDisplayed());	
				    
					PageObjectDocUpload.btn_plus_payslips_swf(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.btn_plus_payslips_swf(driver));
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_upload_payslips_swf(driver)));
					PageObjectDocUpload.btn_upload_payslips_swf(driver).click();
					Thread.sleep(2000);
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_yes_swf(driver)));
					PageObjectDocUpload.btn_yes_swf(driver).click();
					
					Thread.sleep(8000);
								
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_3payslips_swf(driver)));
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_nxt_session_payslips_swf(driver)));
					PageObjectDocUpload.lnk_nxt_session_payslips_swf(driver).click();
					
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					System.out.println("Navigated to Increment Letter");
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_incre_letter_swf(driver));
					Thread.sleep(5000);
													
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_incre_letter_swf(driver)));
					test = extent.createTest("Uploading the Increment Letter");
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_incre_letter_swf(driver).isDisplayed());	
				    
					PageObjectDocUpload.btn_plus_incre_letter_swf(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_upload_incre_letter_swf(driver)));
					PageObjectDocUpload.btn_upload_incre_letter_swf(driver).click();
					Thread.sleep(2000);
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_yes_swf(driver)));
					PageObjectDocUpload.btn_yes_swf(driver).click();
					
					Thread.sleep(8000);
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_increment_letter_swf(driver)));
											
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_nxt_session_incre_letter_swf(driver)));
					PageObjectDocUpload.lnk_nxt_session_incre_letter_swf(driver).click();
					
					System.out.println("Navigated to Immediate Last Employment");
											
					jse.executeScript("window.scrollBy(0,100)", "");
					Thread.sleep(5000);
					
					String no_work_exp = "No";
					if(no_work_exp.contains("Yes")){
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.chk_no_work_exp_swf(driver)));
						PageObjectDocUpload.chk_no_work_exp_swf(driver).click();
						Thread.sleep(3000);
						jse.executeScript("window.scrollBy(0,150)", "");
					}
					else{
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_relieving_letter_swf(driver)));
						test = extent.createTest("Uploading the releiving letter");
						TakeScreenshot.captureScreenShot(driver);
				        Assert.assertTrue(PageObjectDocUpload.btn_plus_relieving_letter_swf(driver).isDisplayed());	
					    
						PageObjectDocUpload.btn_plus_relieving_letter_swf(driver).click();
						Thread.sleep(2000);						
//						Runtime.getRuntime().exec(prop.Image_Path());
						robot.keyPress(KeyEvent.VK_CONTROL);
			            robot.keyPress(KeyEvent.VK_V);
			            robot.keyRelease(KeyEvent.VK_V);
			            robot.keyRelease(KeyEvent.VK_CONTROL);
			            robot.keyPress(KeyEvent.VK_ENTER);
			            robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(3000);
						
						jse.executeScript("window.scrollBy(0,100)", "");
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_experience_letter_swf(driver)));
						PageObjectDocUpload.btn_plus_experience_letter_swf(driver).click();
						Thread.sleep(2000);
//						Runtime.getRuntime().exec(prop.Image_Path());
						robot.keyPress(KeyEvent.VK_CONTROL);
			            robot.keyPress(KeyEvent.VK_V);
			            robot.keyRelease(KeyEvent.VK_V);
			            robot.keyRelease(KeyEvent.VK_CONTROL);
			            robot.keyPress(KeyEvent.VK_ENTER);
			            robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(3000);
						jse.executeScript("window.scrollBy(0,150)", "");
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_upload_immi_last_emp_swf(driver)));
						PageObjectDocUpload.btn_upload_immi_last_emp_swf(driver).click();
						Thread.sleep(2000);
						
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_yes_swf(driver)));
						PageObjectDocUpload.btn_yes_swf(driver).click();
						
						Thread.sleep(8000);
									
						wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_experience_letter_swf(driver)));
					}											
					
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_nxt_session_immi_last_emp_swf(driver)));
					PageObjectDocUpload.lnk_nxt_session_immi_last_emp_swf(driver).click();
					
					System.out.println("Navigated to Photo ID with Address Proof");
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_photo_id_address_swf(driver));
					Thread.sleep(5000);							
																	
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_voterid_swf(driver)));
					test = extent.createTest("Uploading the Voter ID");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_voterid_swf(driver).isDisplayed());	
				    
					PageObjectDocUpload.btn_plus_voterid_swf(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					
					jse.executeScript("window.scrollBy(0,150)", "");
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_drive_license_swf(driver)));
					
					test = extent.createTest("Uploading the Driving License");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_drive_license_swf(driver).isDisplayed());
			        
			        PageObjectDocUpload.btn_plus_drive_license_swf(driver).click();
			        Thread.sleep(1000);			    					
//					Runtime.getRuntime().exec(prop.Image_Path());
			        robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(5000);
					
					jse.executeScript("window.scrollBy(0,150)", "");
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_passport_swf(driver)));
					test = extent.createTest("Uploading the Passport");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_passport_swf(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_passport_swf(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.btn_plus_passport_swf(driver));
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_upload_photo_id_address_swf(driver)));
					PageObjectDocUpload.btn_upload_photo_id_address_swf(driver).click();
					Thread.sleep(3000);
					
					jse.executeScript("window.scrollBy(0,-550)", "");
					jse.executeScript("arguments[0].scrollIntoView()", PageObjectDocUpload.btn_conf_files_yes(driver));
					
					driver.switchTo().defaultContent();
					jse.executeScript("window.scrollTo(document.body.scrollHeight,0)");
					Thread.sleep(2000);
					
					driver.switchTo().frame(0);
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_conf_files_yes(driver)));
					PageObjectDocUpload.btn_conf_files_yes(driver).click();
					Thread.sleep(6000);
						
					jse.executeScript("arguments[0].scrollIntoView()", PageObjectDocUpload.img_image_passport_swf(driver));
									
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_nxt_session_photo_id_address_swf(driver)));
					PageObjectDocUpload.lnk_nxt_session_photo_id_address_swf(driver).click();
					
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					System.out.println("Navigated to Highest Full Time Qualification");
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_high_full_qua_swf(driver));
					Thread.sleep(5000);
					
					jse.executeScript("window.scrollBy(0,200)", "");
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_deg_certif_swf(driver)));
					test = extent.createTest("Uploading the Degree Certificate");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_deg_certif_swf(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_deg_certif_swf(driver).click();
					Thread.sleep(1000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					
					jse.executeScript("window.scrollBy(0,150)", "");
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_final_sem_marksheet_swf(driver)));
					test = extent.createTest("Uploading the Final Semester Marksheet");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_final_sem_marksheet_swf(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_final_sem_marksheet_swf(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(5000);
					
					jse.executeScript("window.scrollBy(0,150)", "");
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_provisional_swf(driver)));
					test = extent.createTest("Uploading the Provisional Marksheet");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_provisional_swf(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_provisional_swf(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.btn_plus_provisional_swf(driver));
					Thread.sleep(2000);
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_all_sem_swf(driver)));
					test = extent.createTest("Uploading the All semester Marksheet");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_all_sem_swf(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_all_sem_swf(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					
					jse.executeScript("window.scrollBy(0,150)", "");
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_upload_high_ful_qua_swf(driver)));
					test = extent.createTest("Uploading the Highest Full time qualification");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_upload_high_ful_qua_swf(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_upload_high_ful_qua_swf(driver).click();
					Thread.sleep(3000);
					
					driver.switchTo().defaultContent();
					jse.executeScript("window.scrollTo(document.body.scrollHeight,0)");
					Thread.sleep(2000);
					
					driver.switchTo().frame(0);
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_conf_files_yes(driver)));
					PageObjectDocUpload.btn_conf_files_yes(driver).click();
					Thread.sleep(9000);		
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.img_image_allsem_swf(driver));
					Thread.sleep(3000);					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_allsem_swf(driver)));
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_nxt_session_high_ful_qua_swf(driver)));
					PageObjectDocUpload.lnk_nxt_session_high_ful_qua_swf(driver).click();
					
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					System.out.println("Navigated to Letter of Authorization");
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_letter_auth_swf(driver));
					Thread.sleep(5000);
					
					jse.executeScript("window.scrollBy(0,50)", "");
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_letter_auth_swf(driver)));
					test = extent.createTest("Uploading the letter of authorization");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_letter_auth_swf(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_letter_auth_swf(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_upload_loa_swf(driver)));
					PageObjectDocUpload.btn_upload_loa_swf(driver).click();
					Thread.sleep(8000);
					
//					wait.until(ExpectedConditions.alertIsPresent());
//					driver.switchTo().alert().accept();											
										
					try {
						if(PageObjectDocUpload.txt_thanks_swf(driver).isDisplayed()){
							test = extent.createTest("Verifying upload successful message on Uploading all the documents");
							Assert.assertTrue(PageObjectDocUpload.btn_ok_thanks_swf(driver).isDisplayed());
							PageObjectDocUpload.btn_ok_thanks_swf(driver).click();
						}
					} catch (Exception e) {
						System.out.println("Thanks for Submitting all documents Popup is not displaying");
					}
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_loa_swf(driver)));
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					driver.switchTo().defaultContent();
					break;
					
			    	
			    }
			    
			    case "BPO":{
			    	Thread.sleep(6000);
			    	 if (PageObjectsEAF.h_Terms_Conditions(driver).isDisplayed()) {
					    	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_ok_Terms_Conditions(driver)));
					    	 PageObjectsEAF.btn_ok_Terms_Conditions(driver).click();	
					    	 System.out.println("Clicked the OK Button in Terms and Conditions");
						}	
					    
				    wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_doc_up_bpo(driver)));
				    
				    wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_progress_bar_bpo(driver)));
				    String progress_current = PageObjectDocUpload.img_progress_bar_bpo(driver).getAttribute("value");
				    
				    test = extent.createTest("Clicking the Document Upload Link");
				    TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.lnk_doc_up_bpo(driver).isDisplayed());
			        
				    PageObjectDocUpload.lnk_doc_up_bpo(driver).click();
				    
				    Thread.sleep(10000);
				    
				        
				  //Handle Windows Change to Document Upload Frame inside the Main page Of IJP

					driver.switchTo().frame(0);
					System.out.println("Navigated to document upload frame");
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.visi_doc_upload_bpo(driver)));
					
					//Scrolling Down
					jse.executeScript("window.scrollBy(0,150)", "");
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.btn_lets_get_started_bpo(driver)));
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_lets_get_started_bpo(driver)));
					test = extent.createTest("Clicking the Lets get started Button");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_lets_get_started_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_lets_get_started_bpo(driver).click();
					Thread.sleep(3000);
					
					try {
						if(PageObjectDocUpload.visi_terms_and_cond_bpo(driver).isDisplayed()){
							jse.executeScript("window.scrollBy(0,150)", "");
							wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_agree_bpo(driver)));
							PageObjectDocUpload.btn_agree_bpo(driver).click();
							Thread.sleep(6000);				
						}
					} catch (Exception e) {
						System.out.println("No terms and conditions are displayed\n" + e);
					}
							
					
					System.out.println("Navigated to Pan Card");
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.visi_doc_up_page_bpo(driver)));
					
					String progress_value = PageObjectDocUpload.value_percentage_progress_bpo(driver).getText();
					System.out.println(progress_value);
					
					jse.executeScript("window.scrollBy(0,150)", "");
					Thread.sleep(3000);
					
//					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_pan_card_bpo(driver)));
//					PageObjectDocUpload.lnk_pan_card_bpo(driver).click();
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.visi_pan_card_bpo(driver)));
					
					String no_pan = "No";
					if(no_pan.contains("Yes")){
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.chk_pan_i_dont_have_one_bpo(driver)));
						PageObjectDocUpload.chk_pan_i_dont_have_one_bpo(driver).click();
						Thread.sleep(3000);
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.chk_pan_yes_bpo(driver)));
						PageObjectDocUpload.chk_pan_yes_bpo(driver).click();
						Thread.sleep(3000);
										
					}
					else{
						test = extent.createTest("Uploading the PAN Card");
						TakeScreenshot.captureScreenShot(driver);
				        Assert.assertTrue(PageObjectDocUpload.btn_plus_pan_bpo(driver).isDisplayed());
				        
						PageObjectDocUpload.btn_plus_pan_bpo(driver).click();
						Thread.sleep(2000);
//						Runtime.getRuntime().exec(prop.Image_Path());
						robot.keyPress(KeyEvent.VK_CONTROL);
			            robot.keyPress(KeyEvent.VK_V);
			            robot.keyRelease(KeyEvent.VK_V);
			            robot.keyRelease(KeyEvent.VK_CONTROL);
			            robot.keyPress(KeyEvent.VK_ENTER);
			            robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(3000);
						
						wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_attach_pan_swf(driver)));
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.img_attach_pan_swf(driver)));
						PageObjectDocUpload.img_attach_pan_swf(driver).click();
						Thread.sleep(3000);
						driver.switchTo().defaultContent();
						System.out.println("Switched to the frame outside");
						jse.executeScript("window.scrollBy(0,-300)", "");
						Thread.sleep(3000);
						driver.switchTo().frame(0);
						System.out.println("Switched to the frame inside");
						
						wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.lnk_go_back_pan_swf(driver)));
						
						if(PageObjectDocUpload.visi_pan_copy_swf(driver).getText().contentEquals("PAN Copy")){
							wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_edit_pan_attach_swf(driver)));
							PageObjectDocUpload.btn_edit_pan_attach_swf(driver).click();
							Thread.sleep(2000);
//							Runtime.getRuntime().exec(prop.Image_Path());
							robot.keyPress(KeyEvent.VK_CONTROL);
				            robot.keyPress(KeyEvent.VK_V);
				            robot.keyRelease(KeyEvent.VK_V);
				            robot.keyRelease(KeyEvent.VK_CONTROL);
				            robot.keyPress(KeyEvent.VK_ENTER);
				            robot.keyRelease(KeyEvent.VK_ENTER);
							Thread.sleep(3000);
							wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.btn_delete_pan_attach_swf(driver)));
							PageObjectDocUpload.btn_delete_pan_attach_swf(driver).click();						
						}
						
						Thread.sleep(3000);
						jse.executeScript("arguments[0].scrollIntoView()", PageObjectDocUpload.visi_pan_card_bpo(driver));
						PageObjectDocUpload.btn_plus_pan_bpo(driver).click();
						Thread.sleep(2000);
//						Runtime.getRuntime().exec(prop.Image_Path());
						robot.keyPress(KeyEvent.VK_CONTROL);
			            robot.keyPress(KeyEvent.VK_V);
			            robot.keyRelease(KeyEvent.VK_V);
			            robot.keyRelease(KeyEvent.VK_CONTROL);
			            robot.keyPress(KeyEvent.VK_ENTER);
			            robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(3000);						
						
						jse.executeScript("window.scrollBy(0,200)", "");
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_pan_upload_attached_files(driver)));
						PageObjectDocUpload.btn_pan_upload_attached_files(driver).click();
						Thread.sleep(8000);
						
						wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_pan_bpo(driver)));
					}
					
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_pan_next_section_bpo(driver)));
					
					PageObjectDocUpload.lnk_pan_next_section_bpo(driver).click();
					
					String progress_value_pan = PageObjectDocUpload.value_percentage_progress_bpo(driver).getText();
					System.out.println(progress_value_pan);
					
					System.out.println("Navigated to Aadhar Card");
					jse.executeScript("window.scrollBy(0,150)", "");
					Thread.sleep(3000);
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_aadhar_card_bpo(driver)));
					PageObjectDocUpload.lnk_aadhar_card_bpo(driver).click();
					
//					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.visi_aadhar_card_bpo(driver)));
					
					String no_aadhar = "No";
					if(no_aadhar.contains("Yes")){
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.chk_aadhar_i_dont_have_one_bpo(driver)));
						PageObjectDocUpload.chk_aadhar_i_dont_have_one_bpo(driver).click();
						Thread.sleep(3000);
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.chk_aadhar_yes_bpo(driver)));
						PageObjectDocUpload.chk_aadhar_yes_bpo(driver).click();
						Thread.sleep(3000);
										
					}
					else{
						test = extent.createTest("Uploading the Aadhar card");
						TakeScreenshot.captureScreenShot(driver);
				        Assert.assertTrue(PageObjectDocUpload.btn_plus_aadhar_bpo(driver).isDisplayed());
				        
					PageObjectDocUpload.btn_plus_aadhar_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					
					StringSelection stringSelection1 = new StringSelection(prop.Invalid_Image());
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, null);
					Robot robot1 = new Robot();
					robot1.keyPress(KeyEvent.VK_CONTROL);
		            robot1.keyPress(KeyEvent.VK_V);
		            robot1.keyRelease(KeyEvent.VK_V);
		            robot1.keyRelease(KeyEvent.VK_CONTROL);
		            robot1.keyPress(KeyEvent.VK_ENTER);
		            robot1.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					
					//Handling the Invalid File Popup
					test = extent.createTest("Uploading the Invalid File and Verifying the validation");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_aadhar_invalid_file_ok_bpo(driver).isDisplayed());
			        
			        String invalid_file_message=PageObjectDocUpload.msg_aadhar_invalid_file_ok_bpo(driver).getText();
			        if (invalid_file_message.contains("File Name can contain only alphanumerics, space, underscore and hyphen. Please rename the file and Retry!")) {
						System.out.println("Validation for Invalid File is displayed");
						PageObjectDocUpload.btn_aadhar_invalid_file_ok_bpo(driver).click();
					}					
					
			        Thread.sleep(3000);
//			        wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.btn_plus_aadhar_bpo(driver)));
//			        wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_aadhar_bpo(driver)));
			        PageObjectDocUpload.btn_plus_aadhar_bpo(driver).click();
					Thread.sleep(2000);
			        
					StringSelection stringSelection2 = new StringSelection(prop.Image());
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection2, null);
					
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					
					jse.executeScript("window.scrollBy(0,200)", "");
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_aadhar_upload_attached_files(driver)));
					PageObjectDocUpload.btn_aadhar_upload_attached_files(driver).click();
					Thread.sleep(6000);
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_aadhar_bpo(driver)));
					
					}
								
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_aadhar_next_section_bpo(driver)));
					
					PageObjectDocUpload.lnk_aadhar_next_section_bpo(driver).click();
					
					String progress_value_aadhar = PageObjectDocUpload.value_percentage_progress_bpo(driver).getText();
					System.out.println(progress_value_aadhar);
					
					System.out.println("Navigated to Highest Qualification");
					
					jse.executeScript("window.scrollBy(0,200)", "");
					
//					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_high_qua_bpo(driver)));
//					PageObjectDocUpload.lnk_high_qua_bpo(driver).click();
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_deg_cert_bpo(driver)));
					test = extent.createTest("Uploading the Degree Certificate");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_deg_cert_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_deg_cert_bpo(driver).click();
					Thread.sleep(1000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					jse.executeScript("window.scrollBy(0,250)", "");
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_final_sem_bpo(driver)));
					test = extent.createTest("Uploading the Final Sem Marksheet");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_final_sem_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_final_sem_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.btn_plus_deg_cert_bpo(driver));
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_cons_marksheet_bpo(driver)));
					test = extent.createTest("Uploading the Consolidated Marksheet");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_cons_marksheet_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_cons_marksheet_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.btn_plus_cons_marksheet_bpo(driver));
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_allsem_marksheet_bpo(driver)));
					test = extent.createTest("Uploading the All Semester Marksheet");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_allsem_marksheet_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_allsem_marksheet_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					jse.executeScript("window.scrollBy(0,500)", "");
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.visi_provisional_bpo(driver)));
					test = extent.createTest("Uploading the Provisional Certificate");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_allsem_marksheet_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_provisional_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(5000);
					jse.executeScript("window.scrollBy(0,200)", "");
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_high_qua_upload_attached_files(driver)));			
					PageObjectDocUpload.btn_high_qua_upload_attached_files(driver).click();
					Thread.sleep(15000);
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.lnk_high_qua_next_section_bpo(driver)));
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_high_qua_next_section_bpo(driver)));
					PageObjectDocUpload.lnk_high_qua_next_section_bpo(driver).click();
					
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					System.out.println("Navigated to 12th Marksheet");
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_12th_bpo(driver));
					Thread.sleep(5000);
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_12th_bpo(driver)));
					test = extent.createTest("Uploading the 12 th certificate");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_12th_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_12th_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_12th_upload_attached_files(driver)));
					PageObjectDocUpload.btn_12th_upload_attached_files(driver).click();
					Thread.sleep(6000);
								
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_12th_bpo(driver)));
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_12th_next_section_bpo(driver)));
					PageObjectDocUpload.lnk_12th_next_section_bpo(driver).click();
					
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					System.out.println("Navigated to 10th Marksheet");
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_10th_bpo(driver));
					Thread.sleep(5000);
													
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_10th_bpo(driver)));
					test = extent.createTest("Uploading the 10 th certificate");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_10th_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_10th_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_10th_upload_attached_files(driver)));
					PageObjectDocUpload.btn_10th_upload_attached_files(driver).click();
					Thread.sleep(6000);
								
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_10th_bpo(driver)));
											
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					System.out.println("Navigated to Current/Most Recent Employment");
					
					String no_prev_exp = "No";
					if(no_prev_exp.contains("Yes")){
						
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.chk_prior_exp_bpo(driver)));
						PageObjectDocUpload.chk_prior_exp_bpo(driver).click();
						Thread.sleep(6000);
						
						System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					}
					
					else{				
						
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_10th_next_section_bpo(driver)));
					PageObjectDocUpload.lnk_10th_next_section_bpo(driver).click();
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_cur_emp_bpo(driver));
					Thread.sleep(5000);
													
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_recent_emp_bpo(driver)));
					test = extent.createTest("Uploading the Current/Most Recent Employment Details");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_recent_emp_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_recent_emp_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_recent_emp_upload_attached_files(driver)));
					PageObjectDocUpload.btn_recent_emp_upload_attached_files(driver).click();
					Thread.sleep(6000);
								
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_recent_emp_bpo(driver)));
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_recent_emp_next_section_bpo(driver)));
					PageObjectDocUpload.lnk_recent_emp_next_section_bpo(driver).click();
					
					System.out.println("Navigated to Compensation Proof");
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_comp_proof_bpo(driver));
					Thread.sleep(5000);
													
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_comp_proof_bpo(driver)));
					test = extent.createTest("Uploading the Compensation Proof");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_comp_proof_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_comp_proof_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_comp_proof_upload_attached_files(driver)));
					PageObjectDocUpload.btn_comp_proof_upload_attached_files(driver).click();
					Thread.sleep(3000);
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_conf_files_yes(driver)));
					PageObjectDocUpload.btn_conf_files_yes(driver).click();
					Thread.sleep(6000);
								
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_comp_proof_bpo(driver)));
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_comp_proof_next_section_bpo(driver)));
					PageObjectDocUpload.lnk_comp_proof_next_section_bpo(driver).click();
					
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					System.out.println("Navigated to Increment Letter");
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_incre_letter_bpo(driver));
					Thread.sleep(5000);
													
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_incre_letter_bpo(driver)));
					test = extent.createTest("Uploading the Increment Letter");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_incre_letter_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_incre_letter_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_incre_letter_upload_attached_files(driver)));
					PageObjectDocUpload.btn_incre_letter_upload_attached_files(driver).click();
					Thread.sleep(6000);
								
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_incre_letter_bpo(driver)));
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_incre_letter_next_section_bpo(driver)));
					PageObjectDocUpload.lnk_incre_letter_next_section_bpo(driver).click();
					
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					System.out.println("Navigated to Last Working Day Proof");
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_last_wrk_day_bpo(driver));
					Thread.sleep(5000);
													
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_last_wrk_day_bpo(driver)));
					test = extent.createTest("Uploading the last working day details");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_last_wrk_day_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_last_wrk_day_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_last_wrk_day_upload_attached_files(driver)));
					PageObjectDocUpload.btn_last_wrk_day_upload_attached_files(driver).click();
					Thread.sleep(6000);
								
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_last_wrk_day_bpo(driver)));
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_last_wrk_day_next_section_bpo(driver)));
					PageObjectDocUpload.lnk_last_wrk_day_next_section_bpo(driver).click();
					
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					System.out.println("Navigated to Previous Employment");
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_prev_emp_bpo(driver));
					Thread.sleep(5000);
													
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_exp_letter_bpo(driver)));
					test = extent.createTest("Uploading the Relieving Letter OR Experience Letter");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_exp_letter_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_exp_letter_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.btn_plus_exp_letter_bpo(driver));
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_last_off_letter_bpo(driver)));
					test = extent.createTest("Uploading the Last Employer Offer Letter details");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_last_off_letter_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_last_off_letter_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_prev_emp_upload_attached_files(driver)));
					PageObjectDocUpload.btn_prev_emp_upload_attached_files(driver).click();
					Thread.sleep(15000);
								
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_last_off_letter_bpo(driver)));
					
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_prev_emp_next_section_bpo(driver)));
					PageObjectDocUpload.lnk_prev_emp_next_section_bpo(driver).click();
					
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					System.out.println("Navigated to Other Previous Employment");
					
					jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_other_prev_emp_bpo(driver));
					Thread.sleep(5000);
													
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_other_prev_emp_bpo(driver)));
					test = extent.createTest("Uploading the other previous employment details");
					TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.btn_plus_other_prev_emp_bpo(driver).isDisplayed());
			        
					PageObjectDocUpload.btn_plus_other_prev_emp_bpo(driver).click();
					Thread.sleep(2000);
//					Runtime.getRuntime().exec(prop.Image_Path());
					robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_other_prev_emp_upload_attached_files(driver)));
					PageObjectDocUpload.btn_other_prev_emp_upload_attached_files(driver).click();
					Thread.sleep(6000);
								
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_other_prev_emp_bpo(driver)));
					System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
					
					//////////////////////////////
					
					
					try {
						if (PageObjectDocUpload.lnk_passport_next_section_bpo(driver).isDisplayed()) {
							
							wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_passport_next_section_bpo(driver)));
							PageObjectDocUpload.lnk_passport_next_section_bpo(driver).click();
							Thread.sleep(3000);
							
							//Passport
							try {
							if (PageObjectDocUpload.btn_plus_passport_bpo(driver).isDisplayed()) {
								
								System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
								System.out.println("Navigated to Passport");
								
								jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_passport_bpo(driver));
								Thread.sleep(5000);
																
								wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_passport_bpo(driver)));
								test = extent.createTest("Uploading the Passport details");
								TakeScreenshot.captureScreenShot(driver);
						        Assert.assertTrue(PageObjectDocUpload.btn_plus_passport_bpo(driver).isDisplayed());
						        
								PageObjectDocUpload.btn_plus_passport_bpo(driver).click();
								Thread.sleep(2000);
//								Runtime.getRuntime().exec(prop.Image_Path());
								robot.keyPress(KeyEvent.VK_CONTROL);
					            robot.keyPress(KeyEvent.VK_V);
					            robot.keyRelease(KeyEvent.VK_V);
					            robot.keyRelease(KeyEvent.VK_CONTROL);
					            robot.keyPress(KeyEvent.VK_ENTER);
					            robot.keyRelease(KeyEvent.VK_ENTER);
								Thread.sleep(3000);
								wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_passport_upload_attached_files(driver)));
								PageObjectDocUpload.btn_passport_upload_attached_files(driver).click();
								Thread.sleep(6000);
								
								//wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_passport_bpo(driver)));
								System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
								wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_pio_next_section_bpo(driver)));
								PageObjectDocUpload.lnk_pio_next_section_bpo(driver).click();
								Thread.sleep(3000);
							}
							}catch (Exception e) {
								
								
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_pio_next_section_bpo(driver)));
									PageObjectDocUpload.lnk_pio_next_section_bpo(driver).click();
							}
							
							//PIO Card
							try {
								if (PageObjectDocUpload.btn_plus_pio_bpo(driver).isDisplayed()) {
									
									System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
									System.out.println("Navigated to PIO CARD");
									
									jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_pio_bpo(driver));
									Thread.sleep(5000);
																	
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_pio_bpo(driver)));
									test = extent.createTest("Uploading the PIO CARD details");
									TakeScreenshot.captureScreenShot(driver);
							        Assert.assertTrue(PageObjectDocUpload.btn_plus_pio_bpo(driver).isDisplayed());
							        
									PageObjectDocUpload.btn_plus_pio_bpo(driver).click();
									Thread.sleep(2000);
//									Runtime.getRuntime().exec(prop.Image_Path());
									robot.keyPress(KeyEvent.VK_CONTROL);
						            robot.keyPress(KeyEvent.VK_V);
						            robot.keyRelease(KeyEvent.VK_V);
						            robot.keyRelease(KeyEvent.VK_CONTROL);
						            robot.keyPress(KeyEvent.VK_ENTER);
						            robot.keyRelease(KeyEvent.VK_ENTER);
									Thread.sleep(3000);
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_pio_upload_attached_files(driver)));
									PageObjectDocUpload.btn_pio_upload_attached_files(driver).click();
									Thread.sleep(6000);
									
									//wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_pio_bpo(driver)));
									System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_voter_id_next_section_bpo(driver)));
									PageObjectDocUpload.lnk_voter_id_next_section_bpo(driver).click();
									Thread.sleep(3000);
									
								}
								}catch (Exception e) {								
									
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_voter_id_next_section_bpo(driver)));
									PageObjectDocUpload.lnk_voter_id_next_section_bpo(driver).click();
									Thread.sleep(2000);		
									
								}
							
							//Voter ID
							try {
								if (PageObjectDocUpload.btn_plus_voter_id_bpo(driver).isDisplayed()) {						
									
									System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
									System.out.println("Navigated to Voter ID");
									
									jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_voter_id_bpo(driver));
									Thread.sleep(5000);
																	
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_voter_id_bpo(driver)));
									test = extent.createTest("Uploading the Citizenship Certificate details");
									TakeScreenshot.captureScreenShot(driver);
							        Assert.assertTrue(PageObjectDocUpload.btn_plus_voter_id_bpo(driver).isDisplayed());
							        
									PageObjectDocUpload.btn_plus_voter_id_bpo(driver).click();
									Thread.sleep(2000);
//									Runtime.getRuntime().exec(prop.Image_Path());
									robot.keyPress(KeyEvent.VK_CONTROL);
						            robot.keyPress(KeyEvent.VK_V);
						            robot.keyRelease(KeyEvent.VK_V);
						            robot.keyRelease(KeyEvent.VK_CONTROL);
						            robot.keyPress(KeyEvent.VK_ENTER);
						            robot.keyRelease(KeyEvent.VK_ENTER);
									Thread.sleep(3000);
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_voter_id_upload_attached_files(driver)));
									PageObjectDocUpload.btn_voter_id_upload_attached_files(driver).click();
									Thread.sleep(6000);
									
									//wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_citi_bpo(driver)));
									System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_citizenship_certificate_next_section_bpo(driver)));
									PageObjectDocUpload.lnk_citizenship_certificate_next_section_bpo(driver).click();
									Thread.sleep(2000);		
								}
								
							} catch (Exception e) {
								wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_citizenship_certificate_next_section_bpo(driver)));
								PageObjectDocUpload.lnk_citizenship_certificate_next_section_bpo(driver).click();
								Thread.sleep(2000);	
							}
							
							//Citizenship Certificate
							try {
								if (PageObjectDocUpload.btn_plus_citi_bpo(driver).isDisplayed()) {						
									
									System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
									System.out.println("Navigated to Citizenship Certificate");
									
									jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_citi_id_bpo(driver));
									Thread.sleep(5000);
																	
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_citi_bpo(driver)));
									test = extent.createTest("Uploading the Citizenship Certificate details");
									TakeScreenshot.captureScreenShot(driver);
							        Assert.assertTrue(PageObjectDocUpload.btn_plus_citi_bpo(driver).isDisplayed());
							        
									PageObjectDocUpload.btn_plus_citi_bpo(driver).click();
									Thread.sleep(2000);
//									Runtime.getRuntime().exec(prop.Image_Path());
									robot.keyPress(KeyEvent.VK_CONTROL);
						            robot.keyPress(KeyEvent.VK_V);
						            robot.keyRelease(KeyEvent.VK_V);
						            robot.keyRelease(KeyEvent.VK_CONTROL);
						            robot.keyPress(KeyEvent.VK_ENTER);
						            robot.keyRelease(KeyEvent.VK_ENTER);
									Thread.sleep(3000);
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_citi_upload_attached_files(driver)));
									PageObjectDocUpload.btn_citi_upload_attached_files(driver).click();
									Thread.sleep(6000);
									
									//wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_citi_bpo(driver)));
									System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_work_permit_next_section_bpo(driver)));
									PageObjectDocUpload.lnk_work_permit_next_section_bpo(driver).click();
									Thread.sleep(2000);		
								}
							} catch (Exception e) {
								wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_work_permit_next_section_bpo(driver)));
								PageObjectDocUpload.lnk_work_permit_next_section_bpo(driver).click();
								Thread.sleep(2000);	
							}
							
							//Work Permit
							try {
								if (PageObjectDocUpload.btn_plus_work_permit_bpo(driver).isDisplayed()) {							
									
									System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
									System.out.println("Navigated to Work Permit Certificate");
									
									jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_work_permit_bpo(driver));
									Thread.sleep(5000);
																	
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_work_permit_bpo(driver)));
									test = extent.createTest("Uploading the Work Permit Certificate details");
									TakeScreenshot.captureScreenShot(driver);
							        Assert.assertTrue(PageObjectDocUpload.btn_plus_work_permit_bpo(driver).isDisplayed());
							        
									PageObjectDocUpload.btn_plus_work_permit_bpo(driver).click();
									Thread.sleep(2000);
//									Runtime.getRuntime().exec(prop.Image_Path());
									robot.keyPress(KeyEvent.VK_CONTROL);
						            robot.keyPress(KeyEvent.VK_V);
						            robot.keyRelease(KeyEvent.VK_V);
						            robot.keyRelease(KeyEvent.VK_CONTROL);
						            robot.keyPress(KeyEvent.VK_ENTER);
						            robot.keyRelease(KeyEvent.VK_ENTER);
									Thread.sleep(3000);
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_work_permit_upload_attached_files(driver)));
									PageObjectDocUpload.btn_work_permit_upload_attached_files(driver).click();
									Thread.sleep(6000);
									
									//wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_work_permit_bpo(driver)));
									System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_coc_next_section_bpo(driver)));
									PageObjectDocUpload.lnk_coc_next_section_bpo(driver).click();
									Thread.sleep(2000);		
								}
								
							} catch (Exception e) {
								wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_coc_next_section_bpo(driver)));
								PageObjectDocUpload.lnk_coc_next_section_bpo(driver).click();
								Thread.sleep(2000);	
							}
							
							//Certificate of Coverage
							try {
								if (PageObjectDocUpload.btn_plus_coc_bpo(driver).isDisplayed()) {
									
									
									System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
									System.out.println("Navigated to Certificate of Coverage");
									
									jse.executeScript("arguments[0].scrollIntoView(true);",PageObjectDocUpload.visi_coc_bpo(driver));
									Thread.sleep(5000);
																	
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_plus_coc_bpo(driver)));
									test = extent.createTest("Uploading the Work Permit Certificate details");
									TakeScreenshot.captureScreenShot(driver);
							        Assert.assertTrue(PageObjectDocUpload.btn_plus_coc_bpo(driver).isDisplayed());
							        
									PageObjectDocUpload.btn_plus_coc_bpo(driver).click();
									Thread.sleep(2000);
//									Runtime.getRuntime().exec(prop.Image_Path());
									robot.keyPress(KeyEvent.VK_CONTROL);
						            robot.keyPress(KeyEvent.VK_V);
						            robot.keyRelease(KeyEvent.VK_V);
						            robot.keyRelease(KeyEvent.VK_CONTROL);
						            robot.keyPress(KeyEvent.VK_ENTER);
						            robot.keyRelease(KeyEvent.VK_ENTER);
									Thread.sleep(3000);
									wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_coc_upload_attached_files(driver)));
									PageObjectDocUpload.btn_coc_upload_attached_files(driver).click();
									Thread.sleep(6000);
									
									//wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.img_image_coc_bpo(driver)));
									System.out.println(PageObjectDocUpload.value_percentage_progress_bpo(driver).getText());
									Thread.sleep(2000);		
								}
							} catch (Exception e) {
								System.out.println("All documents uploaded");		
							}
														
						}
					} catch (Exception e) {
						
							System.out.println("Its not an International Worker");
						
					}
												
					}
									
					driver.switchTo().defaultContent();
			    	break;
			    }
			    case "EWF":{
			    	Thread.sleep(6000);
			    	 if (PageObjectsEAF.h_Terms_Conditions(driver).isDisplayed()) {
					    	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_ok_Terms_Conditions(driver)));
					    	 PageObjectsEAF.btn_ok_Terms_Conditions(driver).click();	
					    	 System.out.println("Clicked the OK Button in Terms and Conditions");
						}	
					    
				    wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.lnk_doc_up_bpo(driver)));
				    test = extent.createTest("Clicking the Upload Documents Hyperlink");
				    TakeScreenshot.captureScreenShot(driver);
			        Assert.assertTrue(PageObjectDocUpload.lnk_doc_up_bpo(driver).isDisplayed());
			        
				    PageObjectDocUpload.lnk_doc_up_bpo(driver).click();
				  //Handle Windows Change to Document Upload Frame inside the Main page Of IJP

					driver.switchTo().frame("iframemobile");
					System.out.println("Navigated to document upload frame");
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.visi_docs_upload_icf(driver)));
					System.out.println(PageObjectDocUpload.visi_docs_upload_icf(driver).getText());
					
					File Excelfile = new File("C:\\Users\\sundar.sp\\eclipse-workspace\\IJP\\test-input\\TestDataJobApplyAgency.xlsx");
				   	
				   	FileInputStream fis = new FileInputStream(Excelfile);
				   	XSSFWorkbook wb = new XSSFWorkbook(fis);
				   	XSSFSheet sheet = wb.getSheetAt(3);
				   			   	
				   	
				   	int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
				   	for (int i = 1; i < rowCount+1; i++) {
				   		Row row = sheet.getRow(i);
				        //Create a loop to print cell values in a row
				        for (int j = 1; j<row.getLastCellNum(); j++) {
				            //Print Excel data in console
				        	
				        	String document = row.getCell(j).getStringCellValue();
				        	System.out.println(document+" is going to be uploaded");
				        	wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.dd_doc_type_icf(driver)));
				        	PageObjectDocUpload.dd_doc_type_icf(driver).click();
						   	Thread.sleep(3000);
						   	List<WebElement> cid1 = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ddlDocType']/option");
						   	System.out.println(cid1.size());
								for(WebElement cid2: cid1){
						   		String value = cid2.getText();
						   		if(value.equalsIgnoreCase(document)){
						   			cid2.click();
						   			System.out.println("Clicked Document type");
						   			break;
						   		}
						   	}
						   	
							Thread.sleep(2000);
						   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_browse_icf(driver)));
						   	test = extent.createTest("Uploading the "+document + " details");
						   	TakeScreenshot.captureScreenShot(driver);
					        Assert.assertTrue(PageObjectDocUpload.btn_browse_icf(driver).isDisplayed());
					        Thread.sleep(2000);
						   	PageObjectDocUpload.btn_browse_icf(driver).click();
						   	
						   	Thread.sleep(2000);
										
				            robot.keyPress(KeyEvent.VK_CONTROL);
				            robot.keyPress(KeyEvent.VK_V);
				            robot.keyRelease(KeyEvent.VK_V);
				            robot.keyRelease(KeyEvent.VK_CONTROL);
				            robot.keyPress(KeyEvent.VK_ENTER);
				            robot.keyRelease(KeyEvent.VK_ENTER);
							
						   	//Runtime.getRuntime().exec(prop.Image_Path());
							Thread.sleep(3000);
							
							PageObjectDocUpload.txt_comments_icf(driver).sendKeys("Required documents has been uploaded");
							
							wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_save_icf(driver)));
							PageObjectDocUpload.btn_save_icf(driver).click();
							
							wait.until(ExpectedConditions.visibilityOf(PageObjectDocUpload.visi_doc_list(driver)));
							Thread.sleep(5000);
							jse.executeScript("arguments[0].scrollIntoView()", PageObjectDocUpload.visi_docs_upload_icf(driver));
				        }
				        System.out.println();
				    }
						
						
				   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.chk_doc_upload_comp_icf(driver)));
				   	PageObjectDocUpload.chk_doc_upload_comp_icf(driver).click();
				   	Thread.sleep(6000);
				   	driver.switchTo().defaultContent();
				    
			    	break;
			    }
			    }
		  }		 
		 
		 @AfterTest
		  	public void terminatetest() {
			 	driver.switchTo().defaultContent();
			 	wait.until(ExpectedConditions.elementToBeClickable(PageObjectDocUpload.btn_logout_swf(driver)));
			 	PageObjectDocUpload.btn_logout_swf(driver).click();
			 	driver.close();
		  	}
}
