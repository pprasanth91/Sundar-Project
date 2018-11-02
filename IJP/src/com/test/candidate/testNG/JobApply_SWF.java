package com.test.candidate.testNG;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.Status;
import com.google.common.base.Verify;
import com.pageobjects.PageObjectsEAF;
import com.pageobjects.PageObjectsJobApply;
import com.pageobjects.PageObjectsLogin;
import com.utilities.ConfigReader;
import com.utilities.ExcelUtils_SWF;
import com.utilities.ExtendReports;
import com.utilities.TakeScreenshot;

public class JobApply_SWF extends ExtendReports {
	static 	ConfigReader prop = new  ConfigReader();
	static{
	System.setProperty("webdriver.chrome.driver", prop.Chrome_Driver_Path());
	}
	
	ChromeDriver driver; 
	WebDriverWait wait;
	JavascriptExecutor jse;
		
	 @BeforeMethod	 
	 public void launchijp() {
		 driver = new ChromeDriver();
		 wait=new WebDriverWait(driver, 120);
		 jse = (JavascriptExecutor)driver;
		 driver.manage().deleteAllCookies();
		 driver.get(prop.URL());
		  	driver.manage().window().maximize();	
		  	String scrFolder = System.getProperty("user.dir")+"\\Screenshots\\JobApply_SWF_DA\\"+ new SimpleDateFormat("dd_MM_yyyy_HHmmss").format(Calendar.getInstance().getTime()).toString();
		    new File(scrFolder).mkdir();
		    System.setProperty("scr.folder", scrFolder);
	  }
	 
	 @Test(dataProvider="JOBAPPLY")
	 
	    public void Job_Apply_SWF(String Candidate_Email_ID, String Job_Title, String First_Name, String Middle_Name, String Last_Name, String Gender, String DOB, String Email, String Previously_Worked_In_Accenture, String Pincode, String Present_Address, String Mobile, String Country_Code, String Area_Code, String Residential_Number, String Country, String State, String City, String Other_City, String Nationality, String Notice_Period, String Relevant_Experience_In_Months, String Current_Annual_Salary, String Expected_Annual_Salary, String Year_it_was_last_put_in_practice, String Optional_Skill, String Opt_Experience_Months, String Year_it_was_last_put_in_practice_Opt, String Highest_Educational_Qualification, String Year_Graduated, String Specialization, String Is_Pan_Card_Available, String Pan_Number, String Is_Aadhar_Card_Available, String Aadhar_Number, String Aadhar_Enroll_Num, String Is_Passport_Available, String Passport_Number, String College_Name, String How_Did_You_Hear_About_Us, String Chk_willing_other_roles, String Resume_Path)throws  Exception{
		 
		 ///Enter your code here
		 String title=driver.getTitle();	  	 
		  	test = extent.createTest("IJP Home Page");
		  	Assert.assertTrue(title.contains("Accenture Recruitment Portal- India"));	  	
		  	TakeScreenshot.captureScreenShot(driver);	
		  	
		  	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
		  		    	    
			    try {
					//Use Login page Object library now
					WebElement Cand_login;
					if (PageObjectsEAF.btn_close_cookies(driver).isDisplayed()) {
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_close_cookies(driver)));
						 PageObjectsEAF.btn_close_cookies(driver).click();
					}
					
					Cand_login = wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.lnk_candidate_login(driver)));
					Cand_login.click();
					PageObjectsLogin.txt_adfs_userid(driver).sendKeys(Candidate_Email_ID);
					PageObjectsLogin.txt_adfs_password(driver).sendKeys(prop.Candidate_Password()+"\n");
					System.out.println("Login Successful as Direct Applicant");
				} catch (NoSuchElementException e) {
					System.out.println("Unable to Login");
			    } finally {
			    	System.out.println("Continue");
				}
			   
			  //waiting till the Page loads			  
			    if (PageObjectsEAF.h_Terms_Conditions(driver).isDisplayed()) {
			    	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_ok_Terms_Conditions(driver)));
			    	 PageObjectsEAF.btn_ok_Terms_Conditions(driver).click();	
			    	 System.out.println("Clicked the OK Button in Terms and Conditions");
				}	
			    
			  //Use Job Apply Object Library Now
			  	wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.lnk_search_jobs(driver)));		  
			  	TakeScreenshot.captureScreenShot(driver);	
			  	test = extent.createTest("Clicking Apply for Jobs Link");
		        Assert.assertTrue(PageObjectsJobApply.lnk_search_jobs(driver).isDisplayed());	  	
			    PageObjectsJobApply.lnk_search_jobs(driver).click();
			    
			    //Handle Windows Change	to Search for Jobs Page  
				String base = driver.getWindowHandle();
				Set<String> set = driver.getWindowHandles();
				 
				set.remove(base);
				assert set.size() == 1;
				driver.switchTo().window((String) set.toArray()[0]);
				System.out.println("Navigated to new tab"); 
			    
				wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_search_input(driver)));
				TakeScreenshot.captureScreenShot(driver);	
				test = extent.createTest("Accenture Jobs Search Page using Search Filters");
			  	Assert.assertTrue(driver.getTitle().contains("Accenture Jobs"));	
			  	Thread.sleep(6000);
			  	//Closing the cookies popup displaying
			  	try {
					if (PageObjectsEAF.btn_close_cookies_careers(driver).isDisplayed()) {
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_close_cookies_careers(driver)));
						 PageObjectsEAF.btn_close_cookies_careers(driver).click();
					}
				} catch (Exception e1) {
					System.out.println("Cookies accept popup is not displaying");
				}
			   			   
			    test = extent.createTest("Entering values in Search open positions at Accenture");
			    TakeScreenshot.captureScreenShot(driver);	
		        Assert.assertTrue(PageObjectsJobApply.txt_search_input(driver).isDisplayed());	  
				PageObjectsJobApply.txt_search_input(driver).sendKeys(Job_Title);
			   	PageObjectsJobApply.btn_search_inputjobs(driver).click();
			   	
			   	Thread.sleep(5000);
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsJobApply.txt_search_input(driver));
			   	test = extent.createTest("Clicking the Job Link");
			   	TakeScreenshot.captureScreenShot(driver);	
			   	Assert.assertTrue(PageObjectsJobApply.lnk_searched_keyword(driver).isDisplayed());	 
			   	PageObjectsJobApply.lnk_searched_keyword(driver).click();		   	
			   	
			   	wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.visi_job_listing(driver)));
			   	PageObjectsJobApply.lnk_apply(driver).click();
			   	
			  //Handle Window Change to Searched Job Listing Input
			   	String base1 = driver.getWindowHandle();
				Set<String> set1 = driver.getWindowHandles();
				 
				set1.remove(base1);
				assert set1.size() == 2;
				driver.switchTo().window((String) set1.toArray()[1]);
				System.out.println("Navigated to new tab");
				Thread.sleep(4000);
				
				wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.visi_terms_cond(driver)));
				wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.btn_terms_agree(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.btn_terms_agree(driver)));
							
				test = extent.createTest("Agreeing the Terms and Conditions");
				TakeScreenshot.captureScreenShot(driver);	
		        Assert.assertTrue(PageObjectsJobApply.btn_terms_agree(driver).isDisplayed());	 
				PageObjectsJobApply.btn_terms_agree(driver).click();
				System.out.println("Clicked I Agree button");
				Thread.sleep(3000);
				
				test = extent.createTest("Entering values in Search open positions at Accenture");
		        Assert.assertTrue(driver.getTitle().contains("Accenture Recruitment Portal- India"));
		        	
				//Resume Upload Cases
				
				wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.lnk_resume_upload(driver)));
				test = extent.createTest("Verify whether the Resume Upload Link is Present");
				TakeScreenshot.captureScreenShot(driver);	
		        Assert.assertTrue(PageObjectsJobApply.lnk_resume_upload(driver).isDisplayed());
		        System.out.println("Done");
		        
		        wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.btn_browse_resume(driver)));
		        wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.btn_browse_resume(driver)));
		        PageObjectsJobApply.btn_browse_resume(driver).click();
		        
		        Thread.sleep(5000);
			   	StringSelection stringSelection = new StringSelection(Resume_Path);
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
			    
				test = extent.createTest("Verify whether the Upload Button is Present");
		        Assert.assertTrue(PageObjectsJobApply.btn_upload_resume(driver).isDisplayed());	
		        PageObjectsJobApply.btn_upload_resume(driver).click();
		        Thread.sleep(5000);
		        
		        wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_first_name(driver)));
		        
		        //Navigating to the Basic Details Page after Uploading the Resume
		        test = extent.createTest("Verify whether the User is navigated to the Basic Details Page after Uploading the Resume");
		        TakeScreenshot.captureScreenShot(driver);	
		        Assert.assertTrue(PageObjectsJobApply.txt_first_name(driver).isDisplayed());	
		        Thread.sleep(3000);
		        
		        String url = driver.getCurrentUrl();
		        test = extent.createTest("Verify whether the User is Applying for the SWF WorkForce");
		        Assert.assertTrue(url.contains("WF=1"));
		        
		        //Verifying the prefilled data and entering the required data which is not prefilled
		        
		       String first_name = PageObjectsJobApply.txt_first_name(driver).getAttribute("value");
			   System.out.println(first_name);
			   		   
			   if (first_name.isEmpty()) {
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_first_name(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_first_name(driver)));
				   PageObjectsJobApply.txt_first_name(driver).clear();
				   PageObjectsJobApply.txt_first_name(driver).sendKeys(First_Name);
			   }
			   
			   
			   String middle_name = PageObjectsJobApply.txt_middle_name(driver).getAttribute("value");
			   System.out.println(middle_name);
			   
			   if (middle_name.isEmpty()) {
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_middle_name(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_middle_name(driver)));
				   PageObjectsJobApply.txt_middle_name(driver).clear();
				   PageObjectsJobApply.txt_middle_name(driver).sendKeys(Middle_Name);
			   }
			   
			   String last_name = PageObjectsJobApply.txt_last_name(driver).getAttribute("value");
			   System.out.println(last_name);
			   
			   if (last_name.isEmpty()) {
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_last_name(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_last_name(driver)));
				   PageObjectsJobApply.txt_last_name(driver).clear();
				   PageObjectsJobApply.txt_last_name(driver).sendKeys(Last_Name);
			   }
			   
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsJobApply.txt_first_name(driver));
			   Thread.sleep(3000);
			   String gender = PageObjectsJobApply.dd_gender(driver).getText();
			   System.out.println(gender);
			   
			   if (gender.contains("Select Gender")||gender.isEmpty()) {
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_gender(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_gender(driver)));
				   PageObjectsJobApply.dd_gender(driver).click();
				   wait.until(ExpectedConditions.visibilityOf(driver.findElementByLinkText(Gender)));
				   wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByLinkText(Gender)));
				   driver.findElementByLinkText(Gender).click();
			   }
			   
			   String dob = PageObjectsJobApply.txt_dob(driver).getAttribute("value");
			   System.out.println(dob);
			   
			   if (dob.isEmpty()) {
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_dob(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_dob(driver)));
				   PageObjectsJobApply.txt_dob(driver).clear();
				   PageObjectsJobApply.txt_dob(driver).sendKeys(DOB);
				   PageObjectsJobApply.txt_email(driver).click();
			   }
			   
			   String email = PageObjectsJobApply.txt_email(driver).getAttribute("value");
			   System.out.println(email);
			   
			   if (email.isEmpty()) {
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_email(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_email(driver)));
				   PageObjectsJobApply.txt_email(driver).clear();
				   PageObjectsJobApply.txt_email(driver).sendKeys(Email);
			   }
			   
			   String prev_worked_in_acc = PageObjectsJobApply.dd_previously_wiacc(driver).getText();
			   System.out.println(prev_worked_in_acc);
			   
			   if (prev_worked_in_acc.isEmpty()||prev_worked_in_acc.contains("Select")) {
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_previously_wiacc(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_previously_wiacc(driver)));
				   PageObjectsJobApply.dd_previously_wiacc(driver).click();
				   wait.until(ExpectedConditions.visibilityOf(driver.findElementByLinkText(Previously_Worked_In_Accenture)));
				   wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByLinkText(Previously_Worked_In_Accenture)));
				   driver.findElementByLinkText(Previously_Worked_In_Accenture).click();
			   }
			   
			   String pincode = PageObjectsJobApply.txt_pincode(driver).getAttribute("value");
			   System.out.println(pincode);
			   
			   if (pincode.isEmpty()) {
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_pincode(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_pincode(driver)));
				   PageObjectsJobApply.txt_pincode(driver).clear();
				   PageObjectsJobApply.txt_pincode(driver).sendKeys(Pincode);
			   }
			   
			   String present_address = PageObjectsJobApply.txt_present_address(driver).getAttribute("value");
			   System.out.println(present_address);
			   
			   if (present_address.isEmpty()) {
				   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_present_address(driver)));
				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_present_address(driver)));
				   PageObjectsJobApply.txt_present_address(driver).clear();
				   PageObjectsJobApply.txt_present_address(driver).sendKeys(Present_Address);
			   }
			   
			   if (!Mobile.isEmpty()) {
				   
				   PageObjectsJobApply.txt_res_countrycode(driver).click();
				   PageObjectsJobApply.txt_res_countrycode(driver).clear();
				   PageObjectsJobApply.txt_res_areacode(driver).click();
				   PageObjectsJobApply.txt_res_areacode(driver).clear();
				   PageObjectsJobApply.txt_res_num(driver).click();
				   PageObjectsJobApply.txt_res_num(driver).clear();
				   
				   String mobile_num = PageObjectsJobApply.txt_mobile_num(driver).getAttribute("value");
				   System.out.println(mobile_num);
				   System.out.println(mobile_num.length());
//				   System.out.println(mobile_num.substring(mobile_num.length()-10, mobile_num.length()));
				   String mobile_num1 = PageObjectsJobApply.txt_mobile_num(driver).getAttribute("value");
				   
				   try {
					if (mobile_num.isEmpty()) {
						   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_mobile_num(driver)));
						   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_mobile_num(driver)));
						   PageObjectsJobApply.txt_mobile_num(driver).clear();
						   PageObjectsJobApply.txt_mobile_num(driver).sendKeys(Mobile);
					   }			   			   
					   else if (mobile_num.substring(mobile_num.length()-10, mobile_num.length()).equals("10")) {
					   
						   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_mobile_num(driver)));
						   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_mobile_num(driver)));
						   PageObjectsJobApply.txt_mobile_num(driver).clear();
						   PageObjectsJobApply.txt_mobile_num(driver).sendKeys(mobile_num.substring((mobile_num.length()-10), (mobile_num.length())));
					}
					   else if (mobile_num.substring(mobile_num.length()-11, mobile_num.length()).equals("10")) {
						   
						   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_mobile_num(driver)));
						   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_mobile_num(driver)));
						   PageObjectsJobApply.txt_mobile_num(driver).clear();
						   PageObjectsJobApply.txt_mobile_num(driver).sendKeys(mobile_num.substring((mobile_num.length()-11), (mobile_num.length())));
					}				
					
					
				} catch (Exception e) {
					System.out.println("Mobile number is edited");
				}			   
				   
			}
			   else {
				   String Country_Code1 = PageObjectsJobApply.txt_res_countrycode(driver).getAttribute("value");
				   System.out.println(Country_Code1);
				   
				   if (Country_Code1.isEmpty()) {
					   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_res_countrycode(driver)));
					   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_res_countrycode(driver)));
					   PageObjectsJobApply.txt_res_countrycode(driver).clear();
					   PageObjectsJobApply.txt_res_countrycode(driver).sendKeys(Country_Code);
				   }
				   			   
				   String Area_Code1 = PageObjectsJobApply.txt_res_areacode(driver).getAttribute("value");
				   System.out.println(Area_Code1);
				   
				   if (Area_Code1.isEmpty()) {
					   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_res_areacode(driver)));
					   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_res_areacode(driver)));
					   PageObjectsJobApply.txt_res_areacode(driver).clear();
					   PageObjectsJobApply.txt_res_areacode(driver).sendKeys(Area_Code);
				   }
				   
				   String Res_Num = PageObjectsJobApply.txt_res_num(driver).getAttribute("value");
				   System.out.println(Res_Num);
				   
				   if (Res_Num.isEmpty()) {
					   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_res_num(driver)));
					   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_res_num(driver)));
					   PageObjectsJobApply.txt_res_num(driver).clear();
					   PageObjectsJobApply.txt_res_num(driver).sendKeys(Residential_Number);
				   }
						   
			}
			   		   
			   //Clicking the Next Button to proceed to the Advance Details Page
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.btn_next_adv(driver)));
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.btn_next_adv(driver)));
			   PageObjectsJobApply.btn_next_adv(driver).click();
			   Thread.sleep(5000);
			   
			  //Advance Details Tab Visibility
			   test = extent.createTest("Verify whether the User is navigated to the Advanced Details Tab");
			   TakeScreenshot.captureScreenShot(driver);	
		       Assert.assertTrue(PageObjectsJobApply.dd_country(driver).isDisplayed());	       
		       Thread.sleep(5000);
		      	 
		       String country1a = PageObjectsJobApply.dd_country(driver).getText();
		       System.out.println("Country is "+country1a);
		       
		       jse.executeScript("arguments[0].scrollIntoView()", PageObjectsJobApply.lnk_advanced_details(driver));
		       Thread.sleep(2000);
		       
		       if (country1a.isEmpty()||country1a.contains("Select Country")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_country(driver)));
			       test.log(Status.INFO,"Entering the Country");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_country(driver)));
			       PageObjectsJobApply.dd_country(driver).click();
			       PageObjectsJobApply.dd_country_input(driver).clear();
			       PageObjectsJobApply.dd_country_input(driver).sendKeys(Country);
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_country_input_select(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_country_input_select(driver)));
			       PageObjectsJobApply.dd_country_input_select(driver).click();			
		       }
		      
		       String state1 = PageObjectsJobApply.dd_state(driver).getText();
		       System.out.println("State is "+state1);
		       
		       if (state1.isEmpty()||state1.contains("Select State")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_state(driver)));
			       test.log(Status.INFO,"Entering the State");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_state(driver)));
			       PageObjectsJobApply.dd_state(driver).click();
			       PageObjectsJobApply.dd_state_input(driver).clear();
			       PageObjectsJobApply.dd_state_input(driver).sendKeys(State);//data.state
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_state_input_select(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_state_input_select(driver)));
			       PageObjectsJobApply.dd_state_input_select(driver).click(); 
		       }
		       
		       String city1 = PageObjectsJobApply.dd_city(driver).getText();
		       System.out.println("city is "+city1);
		       
		       if (city1.isEmpty()||city1.contains("Select City")) {
		    	   
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_city(driver)));
			       test.log(Status.INFO,"Entering the City");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_city(driver)));
			       PageObjectsJobApply.dd_city(driver).click();
			       PageObjectsJobApply.dd_city_input(driver).clear();
			       PageObjectsJobApply.dd_city_input(driver).sendKeys(City);
			       Thread.sleep(2000);//data.city
			       if (City.contains("Others")) {
			    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_city_input_select(driver)));
				       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_city_input_select(driver)));
				       PageObjectsJobApply.dd_city_input_select(driver).click();
				       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_others_city(driver)));
				       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_others_city(driver)));
				       PageObjectsJobApply.txt_others_city(driver).sendKeys(Other_City);//data.city
				       
			       } else {
					   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_city_input_select(driver)));
				       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_city_input_select(driver)));
				       PageObjectsJobApply.dd_city_input_select(driver).click();
				       
			       }
		    	   
		       }
		      	       
		       jse.executeScript("arguments[0].scrollIntoView();", PageObjectsJobApply.dd_city(driver)); 
		       Thread.sleep(3000);
		      	String nationality1 = PageObjectsJobApply.dd_nationality(driver).getText();
		       System.out.println("Nationality is "+nationality1);
		       
		       if (nationality1.isEmpty()||nationality1.contains("Select Nationality")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_nationality(driver)));
			       test.log(Status.INFO,"Entering the Nationality");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_nationality(driver)));
			       PageObjectsJobApply.dd_nationality(driver).click();
			       PageObjectsJobApply.dd_nationality_input(driver).clear();
			       PageObjectsJobApply.dd_nationality_input(driver).sendKeys(Nationality);//data.nationality
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_nationality_input_select(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_nationality_input_select(driver)));
			       PageObjectsJobApply.dd_nationality_input_select(driver).click();
		       }
		      
		       String notice_period1 = PageObjectsJobApply.dd_notice_period(driver).getText();
		       System.out.println("Notice Period is "+notice_period1);
		       
		       if (notice_period1.isEmpty()||notice_period1.contains("Select Notice Period")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_notice_period(driver)));
			       test.log(Status.INFO,"Entering the Notice Period");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_notice_period(driver)));
			       PageObjectsJobApply.dd_notice_period(driver).click();
			       PageObjectsJobApply.dd_notice_period_input(driver).clear();
			       PageObjectsJobApply.dd_notice_period_input(driver).sendKeys(Notice_Period);
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_notice_period_input_select(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_notice_period_input_select(driver)));
			       PageObjectsJobApply.dd_notice_period_input_select(driver).click();
		       }
		              
		       String rel_exp_months = PageObjectsJobApply.txt_relevant_exp_in_months(driver).getText();
		       System.out.println(rel_exp_months);
		       if (rel_exp_months.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_relevant_exp_in_months(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_relevant_exp_in_months(driver)));
			       test.log(Status.INFO,"Entering the Relevant Experience (in months)*");
			       PageObjectsJobApply.txt_relevant_exp_in_months(driver).clear();
			       PageObjectsJobApply.txt_relevant_exp_in_months(driver).sendKeys(Relevant_Experience_In_Months);
			}
		      
		       String current_annual_salary = PageObjectsJobApply.txt_current_annual_salary(driver).getText();
		       System.out.println(current_annual_salary);
		       if (current_annual_salary.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_current_annual_salary(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_current_annual_salary(driver)));
			       test.log(Status.INFO,"Entering the Current Annual Salary");
			       PageObjectsJobApply.txt_current_annual_salary(driver).clear();
			       PageObjectsJobApply.txt_current_annual_salary(driver).sendKeys(Current_Annual_Salary);
			}
			   
		       String expected_annual_salary = PageObjectsJobApply.txt_expected_annual_salary(driver).getText();
		       System.out.println(expected_annual_salary);
		       if (expected_annual_salary.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_expected_annual_salary(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_expected_annual_salary(driver)));
			       test.log(Status.INFO,"Entering the Expected Annual salary");
			       PageObjectsJobApply.txt_expected_annual_salary(driver).clear();
			       PageObjectsJobApply.txt_expected_annual_salary(driver).sendKeys(Expected_Annual_Salary);
			}
			    
		       String primary_skill = PageObjectsJobApply.txt_primary_skill(driver).getAttribute("value");
		       System.out.println(primary_skill);
		       test = extent.createTest("Verify whether the Primary Skill is populated by its own");
		       TakeScreenshot.captureScreenShot(driver);	
		       Verify.verify(!PageObjectsJobApply.txt_primary_skill(driver).getAttribute("value").isEmpty());
		       
		       String year_last_put_in_practice =  PageObjectsJobApply.dd_year_put_in_practice(driver).getText();
		       System.out.println(year_last_put_in_practice);
		       
		       if (year_last_put_in_practice.isEmpty()||year_last_put_in_practice.contains("Select")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_year_put_in_practice(driver)));
			       test.log(Status.INFO,"Entering the Year it was last put in practice");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_year_put_in_practice(driver)));
			       PageObjectsJobApply.dd_year_put_in_practice(driver).click();
			       PageObjectsJobApply.dd_year_put_in_practice_input(driver).clear();
			       PageObjectsJobApply.dd_year_put_in_practice_input(driver).sendKeys(Year_it_was_last_put_in_practice);
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_year_put_in_practice_input_select(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_year_put_in_practice_input_select(driver)));
			       PageObjectsJobApply.dd_year_put_in_practice_input_select(driver).click();
		       }
		       
		       jse.executeScript("arguments[0].scrollIntoView();", PageObjectsJobApply.txt_primary_skill(driver)); 
		       Thread.sleep(3000);
		       String optional_skill = PageObjectsJobApply.txt_optional_skill(driver).getText();
		       System.out.println(optional_skill);
		       if (optional_skill.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_optional_skill(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_optional_skill(driver)));
			       test.log(Status.INFO,"Entering the Additional Skill 1");
			       PageObjectsJobApply.txt_optional_skill(driver).clear();
			       PageObjectsJobApply.txt_optional_skill(driver).sendKeys(Optional_Skill);
			       Thread.sleep(2000);
			       PageObjectsJobApply.txt_optional_skill(driver).sendKeys(Keys.ENTER);
			}
			    
		       String experience_months = PageObjectsJobApply.txt_experience_in_months(driver).getAttribute("value");
		       System.out.println(experience_months);
		       if (experience_months.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_experience_in_months(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_experience_in_months(driver)));
			       test.log(Status.INFO,"Entering the Experience in Months");
			       PageObjectsJobApply.txt_experience_in_months(driver).clear();
			       PageObjectsJobApply.txt_experience_in_months(driver).sendKeys(Opt_Experience_Months);
			}
		              
		       String year_last_put_in_practice_opt =  PageObjectsJobApply.dd_year_put_in_practice_opt(driver).getText();
		       System.out.println(year_last_put_in_practice_opt);
		       
		       if (year_last_put_in_practice_opt.isEmpty()||year_last_put_in_practice_opt.contains("Select")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_year_put_in_practice_opt(driver)));
			       test.log(Status.INFO,"Entering the Year it was last put in practice for Optional Skills");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_year_put_in_practice_opt(driver)));
			       PageObjectsJobApply.dd_year_put_in_practice_opt(driver).click();
			       PageObjectsJobApply.dd_year_put_in_practice_input_opt(driver).clear();
			       PageObjectsJobApply.dd_year_put_in_practice_input_opt(driver).sendKeys(Year_it_was_last_put_in_practice_Opt);
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_year_put_in_practice_input_Select_opt(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_year_put_in_practice_input_Select_opt(driver)));
			       PageObjectsJobApply.dd_year_put_in_practice_input_Select_opt(driver).click();
		       }
			    
		       
		       String total_experience = PageObjectsJobApply.dd_total_experience(driver).getText();
		       System.out.println(total_experience);
		       test = extent.createTest("Verify whether the Total Experience is populated by its own");
		       TakeScreenshot.captureScreenShot(driver);	
		       Verify.verify(PageObjectsJobApply.dd_total_experience(driver).isDisplayed());
		       
		       String highest_educational_qualification =  PageObjectsJobApply.dd_highdeg(driver).getText();
		       System.out.println(highest_educational_qualification);
		       
		       if (highest_educational_qualification.isEmpty()||highest_educational_qualification.contains("Select Graduation")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_highdeg(driver)));
			       test.log(Status.INFO,"Entering the Highest Educational Qualification");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_highdeg(driver)));
			       PageObjectsJobApply.dd_highdeg(driver).click();
			       PageObjectsJobApply.dd_highdeg_input(driver).clear();
			       PageObjectsJobApply.dd_highdeg_input(driver).sendKeys(Highest_Educational_Qualification);
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_highdeg_input_select(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_highdeg_input_select(driver)));
			       PageObjectsJobApply.dd_highdeg_input_select(driver).click();
		       }
		       
		       String year_graduated = PageObjectsJobApply.txt_year_graduated(driver).getText();
		       System.out.println(year_graduated);
		       if (year_graduated.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_year_graduated(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_year_graduated(driver)));
			       test.log(Status.INFO,"Entering the Year Graduated");
			       PageObjectsJobApply.txt_year_graduated(driver).clear();
			       PageObjectsJobApply.txt_year_graduated(driver).sendKeys(Year_Graduated);
			}
		       
		       String specialization =  PageObjectsJobApply.dd_specialization(driver).getText();
		       System.out.println(specialization);
		       
		       if (specialization.isEmpty()||specialization.contains("Select")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_specialization(driver)));
			       test.log(Status.INFO,"Entering the Specialization");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_specialization(driver)));
			       PageObjectsJobApply.dd_specialization(driver).click();
			       PageObjectsJobApply.dd_specialization_input(driver).clear();
			       PageObjectsJobApply.dd_specialization_input(driver).sendKeys(Specialization);
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_specialization_input_select(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_specialization_input_select(driver)));
			       PageObjectsJobApply.dd_specialization_input_select(driver).click();
		       }       
		       
		       String is_pan_card_available =  PageObjectsJobApply.dd_is_pancard_available(driver).getText();
		       System.out.println(is_pan_card_available);
		       
		       if (is_pan_card_available.isEmpty()||is_pan_card_available.contains("Applied For")||is_pan_card_available.contains("Not Applied For")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_is_pancard_available(driver)));
			       test.log(Status.INFO,"Entering the Is Pan Card Available");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_is_pancard_available(driver)));
			       PageObjectsJobApply.dd_is_pancard_available(driver).click();
			       PageObjectsJobApply.dd_is_pancard_available_input(driver).clear();
			       PageObjectsJobApply.dd_is_pancard_available_input(driver).sendKeys(Is_Pan_Card_Available);
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_is_pancard_available_input_select(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_is_pancard_available_input_select(driver)));
			       PageObjectsJobApply.dd_is_pancard_available_input_select(driver).click();
			       
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_pancard(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_pancard(driver)));
			       PageObjectsJobApply.txt_pancard(driver).sendKeys(Pan_Number);
		       }
		       else if (is_pan_card_available.contains("Yes")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_pancard(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_pancard(driver)));
			       PageObjectsJobApply.txt_pancard(driver).sendKeys(Pan_Number);
				
			}
		       
		       
		       String is_aadhar_card_available =  PageObjectsJobApply.dd_is_aadhaar_card_available(driver).getText();
		       System.out.println(is_aadhar_card_available);
		       
		       if (is_aadhar_card_available.contains("Select")||is_aadhar_card_available.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_is_aadhaar_card_available(driver)));
			       test.log(Status.INFO,"Entering the Is Aadhaar Card Available");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_is_aadhaar_card_available(driver)));
			       PageObjectsJobApply.dd_is_aadhaar_card_available(driver).click();
			       PageObjectsJobApply.dd_is_aadhaar_card_available_input(driver).clear();
			       PageObjectsJobApply.dd_is_aadhaar_card_available_input(driver).sendKeys(Is_Aadhar_Card_Available);//data.is_aadhar_card_available
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_is_aadhaar_card_available_input_select(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_is_aadhaar_card_available_input_select(driver)));
			       PageObjectsJobApply.dd_is_aadhaar_card_available_input_select(driver).click();		       
		       }
		       
		       
		       String is_aadhar_card_available1 =  PageObjectsJobApply.dd_is_aadhaar_card_available(driver).getText();
		       System.out.println(is_aadhar_card_available1);
		       
		       if (is_aadhar_card_available1.contains("Yes")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_aadhaar_number(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_aadhaar_number(driver)));
			       PageObjectsJobApply.txt_aadhaar_number(driver).sendKeys(Aadhar_Number);
			       
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_aadhaar_name(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_aadhaar_name(driver)));
			       PageObjectsJobApply.txt_aadhaar_name(driver).sendKeys(First_Name);
			}
		       else if (is_aadhar_card_available.contains("Applied For")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_aadhaar_enroll_num(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_aadhaar_enroll_num(driver)));
			       PageObjectsJobApply.txt_aadhaar_enroll_num(driver).sendKeys(Aadhar_Enroll_Num);
			       
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_aadhaar_name(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_aadhaar_name(driver)));
			       PageObjectsJobApply.txt_aadhaar_name(driver).sendKeys(First_Name);
			}
		       
		       String is_passport_available =  PageObjectsJobApply.dd_passport_available(driver).getText();
		       System.out.println(is_passport_available);
		       
		       if (is_passport_available.contains("Select")||is_passport_available.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_passport_available(driver)));
			       test.log(Status.INFO,"Entering the Is Passport Available");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_passport_available(driver)));
			       PageObjectsJobApply.dd_passport_available(driver).click();
			       PageObjectsJobApply.dd_passport_available_input(driver).clear();
			       PageObjectsJobApply.dd_passport_available_input(driver).sendKeys(Is_Passport_Available);//data.is_passport_available
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_passport_available_input_select(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_passport_available_input_select(driver)));
			       PageObjectsJobApply.dd_passport_available_input_select(driver).click();		       
		       }
		       
		       
		       String is_passport_available1 =  PageObjectsJobApply.dd_passport_available(driver).getText();
		       System.out.println(is_passport_available1);
		       
		       if (is_passport_available1.contains("Yes")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_passport_no(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_passport_no(driver)));
			       PageObjectsJobApply.txt_passport_no(driver).sendKeys(Passport_Number);
			       
			}
		       else if (is_passport_available1.contains("Applied For")||is_passport_available1.contains("Not Applied For")) {
		    	   System.out.println("Its in not applied for status");
			}
		   	   
		       String college_name =  PageObjectsJobApply.dd_college_name(driver).getAttribute("value");
		       System.out.println(college_name);
		       
		       if (college_name.isEmpty()) {
		    	   
				wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_college_name(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_college_name(driver)));
				test.log(Status.INFO,"Entering the College Details");
				PageObjectsJobApply.dd_college_name(driver).click();
				PageObjectsJobApply.dd_college_name(driver).clear();
				PageObjectsJobApply.dd_college_name(driver).sendKeys(College_Name);
				Thread.sleep(2000);
				PageObjectsJobApply.dd_college_name(driver).sendKeys(Keys.ENTER);
			}
		       if (college_name.contains("Others")) {
		    	   	wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_other_college_name(driver)));
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_other_college_name(driver)));
					test.log(Status.INFO,"Entering the Other College Details");
					PageObjectsJobApply.txt_other_college_name(driver).click();
					PageObjectsJobApply.txt_other_college_name(driver).clear();
					PageObjectsJobApply.txt_other_college_name(driver).sendKeys(College_Name);
			}
		       
		       jse.executeScript("arguments[0].scrollIntoView()", PageObjectsJobApply.dd_passport_available(driver));
		       Thread.sleep(3000);
		       
		       String organization_name =  PageObjectsJobApply.dd_org_name(driver).getAttribute("value");
		       System.out.println(organization_name);
		       
		       if (organization_name.isEmpty()) {
		    	   
				wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_org_name(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_org_name(driver)));
				test.log(Status.INFO,"Entering the Organization Details");
				PageObjectsJobApply.dd_org_name(driver).click();
				PageObjectsJobApply.dd_org_name(driver).clear();
				PageObjectsJobApply.dd_org_name(driver).sendKeys(College_Name);
				Thread.sleep(2000);
				PageObjectsJobApply.dd_org_name(driver).sendKeys(Keys.ENTER);
			}
		       if (organization_name.contains("Others")) {
		    	   	wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_org_name_others(driver)));
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_org_name_others(driver)));
					test.log(Status.INFO,"Entering the Other Organization Details");
					PageObjectsJobApply.dd_org_name_others(driver).click();
					PageObjectsJobApply.dd_org_name_others(driver).clear();
					PageObjectsJobApply.dd_org_name_others(driver).sendKeys(College_Name);
			}
		       
		       String how_did_you_hear_about_us =  PageObjectsJobApply.dd_hear(driver).getText();
		       System.out.println(how_did_you_hear_about_us);
		       
		       if (how_did_you_hear_about_us.isEmpty()||how_did_you_hear_about_us.contains("Select")) {
		    	   
				wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_hear(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_hear(driver)));
				test.log(Status.INFO,"Entering the How did you hear about us Details");
				PageObjectsJobApply.dd_hear(driver).click();
				wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_hear_input(driver)));
				PageObjectsJobApply.dd_hear_input(driver).clear();
				PageObjectsJobApply.dd_hear_input(driver).sendKeys(How_Did_You_Hear_About_Us);
				Thread.sleep(2000);
				PageObjectsJobApply.dd_hear_input(driver).sendKeys(Keys.ENTER);
			}
		       
		       if(Chk_willing_other_roles.contains("Yes")) { //data.chk_willing_other_roles.
		    	   	wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.chk_willing_other_roles(driver)));
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.chk_willing_other_roles(driver)));
					test.log(Status.INFO,"Entering the willingness for other roles Details");
					PageObjectsJobApply.chk_willing_other_roles(driver).click();
		       }
		       
		       test = extent.createTest("Clicking the Apply for Oppurtunity");
		       TakeScreenshot.captureScreenShot(driver);	
		        Assert.assertTrue(PageObjectsJobApply.btn_apply_ft_oppur(driver).isDisplayed());
		       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.btn_apply_ft_oppur(driver)));
		       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.btn_apply_ft_oppur(driver)));
			   PageObjectsJobApply.btn_apply_ft_oppur(driver).click();
			   test.log(Status.INFO,"Clicked the Apply for Oppurtunity Button");
			   
			   Thread.sleep(5000);
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.visi_confirmation_swf(driver)));
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.visi_timestamp_swf(driver)));
		       test = extent.createTest("Obtaining the CID and Time Stamp of Candidates Created");
		       TakeScreenshot.captureScreenShot(driver);	
		       Assert.assertTrue(PageObjectsJobApply.visi_timestamp_swf(driver).isDisplayed());
		       test.log(Status.INFO,"Candidate Created Time Stamp");
		       test.log(Status.INFO,PageObjectsJobApply.visi_timestamp_swf(driver).getText());
		       Thread.sleep(2000);
	 //End of your code
	 }
	 
	 @DataProvider
	 
	    public Object[][] JOBAPPLY() throws Exception{
	 
		 Object[][] testObjArray = ExcelUtils_SWF.getTableArray("./test-input/TestDataJobApply.xlsx","Job Apply SWF");
	 
	         return (testObjArray);
	 
			}
	 
	    @AfterMethod
	 
	    public void terminatetest() throws InterruptedException {
	 	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("SIGN OUT"))));
	 	   driver.findElement(By.linkText("SIGN OUT")).click();
	 	   Thread.sleep(10000); 
	    	 String originalHandle = driver.getWindowHandle();

	    	    //Do something to open new tabs

	    	    for(String handle : driver.getWindowHandles()) {
	    	        if (!handle.equals(originalHandle)) {
	    	            driver.switchTo().window(handle);
	    	            driver.close();
	    	        }
	    	    }

	    	    driver.switchTo().window(originalHandle);
	    	    driver.close();
	 	}
	    
	    @AfterClass
	    public void closetest() throws InterruptedException {
		 	   driver.quit();
		 	}
	    
}
