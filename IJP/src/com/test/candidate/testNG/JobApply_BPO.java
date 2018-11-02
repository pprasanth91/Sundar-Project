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
import com.utilities.ExcelTestData_BPO;
import com.utilities.ExcelUtils_BPO;
import com.utilities.ExcelUtils_SWF;
import com.utilities.ExtendReports;
import com.utilities.TakeScreenshot;

public class JobApply_BPO extends ExtendReports {
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
		  	String scrFolder = System.getProperty("user.dir")+"\\Screenshots\\JobApply_BPO_DA\\"+ new SimpleDateFormat("dd_MM_yyyy_HHmmss").format(Calendar.getInstance().getTime()).toString();
		    new File(scrFolder).mkdir();
		    System.setProperty("scr.folder", scrFolder);
	  }
	 
	 @Test(dataProvider="JOBAPPLY")
	 
	    public void Job_Apply_BPO(String Candidate_Email_ID, String Job_Title, String First_Name, String Middle_Name, String Last_Name, String Gender, String DOB, String Email, String Previously_Worked_In_Accenture, String Pincode, String Present_Address, String Mobile, String Country_Code, String Area_Code, String Residential_Number, String Country, String State, String City, String Other_City, String Nationality, String Citizenship, String Notice_Period, String Relevant_Experience_In_Years, String Current_Annual_Salary, String Expected_Annual_Salary, String Is_Aadhar_Card_Available, String Aadhar_Number, String Aadhar_Enroll_Num, String Passport_Number, String Total_Experience, String Highest_Educational_Qualification, String Year_Graduated, String Specialization, String Is_Pan_Card_Available, String Pan_Number, String Is_Passport_Available, String College_Name, String How_Did_You_Hear_About_Us, String Chk_willing_other_roles, String Resume_Path)throws  Exception{
		 
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
			  	test = extent.createTest("Clicking Apply for Jobs Link");
			  	TakeScreenshot.captureScreenShot(driver);	
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
				test = extent.createTest("Accenture Jobs Search Page using Search Filters");
				TakeScreenshot.captureScreenShot(driver);	
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
			    
			    try {
					if (PageObjectsEAF.btn_close_cookies_careers1(driver).isDisplayed()) {
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_close_cookies_careers1(driver)));
						 PageObjectsEAF.btn_close_cookies_careers1(driver).click();
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
				TakeScreenshot.captureScreenShot(driver);	
		        Assert.assertTrue(driver.getTitle().contains("Accenture Recruitment Portal- India"));
		        	
				//Resume Upload Cases
				
				wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.lnk_resume_upload(driver)));
				test = extent.createTest("Verify whether the Resume Upload Link is Present");
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
				TakeScreenshot.captureScreenShot(driver);	
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
		        test = extent.createTest("Verify whether the User is Applying for the BPO WorkForce");
		        TakeScreenshot.captureScreenShot(driver);	
		        Assert.assertTrue(url.contains("WF=2"));
		        
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
			   
//			   if (middle_name.isEmpty()) {
//				   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_middle_name(driver)));
//				   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_middle_name(driver)));
//				   PageObjectsJobApply.txt_middle_name(driver).clear();
//				   PageObjectsJobApply.txt_middle_name(driver).sendKeys(Middle_Name);
//			   }
			   
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
			   
			  //Advance Details Tab Visibility
			   test = extent.createTest("Verify whether the User is navigated to the Advanced Details Tab");
			   TakeScreenshot.captureScreenShot(driver);	
		       Assert.assertTrue(PageObjectsJobApply.dd_country_b(driver).isDisplayed());	       
		       Thread.sleep(5000);
		      	 
		       String country1a = PageObjectsJobApply.dd_country_b(driver).getText();
		       System.out.println("Country is "+country1a);
		       
		       jse.executeScript("arguments[0].scrollIntoView()", PageObjectsJobApply.lnk_advanced_details(driver));
		       Thread.sleep(2000);
		       
		       if (country1a.isEmpty()||country1a.contains("Select Country")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_country_b(driver)));
			       test.log(Status.INFO,"Entering the Country");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_country_b(driver)));
			       PageObjectsJobApply.dd_country_b(driver).click();
			       PageObjectsJobApply.dd_country_input_b(driver).clear();
			       PageObjectsJobApply.dd_country_input_b(driver).sendKeys(Country);
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_country_input_select_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_country_input_select_b(driver)));
			       PageObjectsJobApply.dd_country_input_select_b(driver).click();			
		       }
		      
		       String state1 = PageObjectsJobApply.dd_state_b(driver).getText();
		       System.out.println("State is "+state1);
		       
		       if (state1.isEmpty()||state1.contains("Select State")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_state_b(driver)));
			       test.log(Status.INFO,"Entering the State");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_state_b(driver)));
			       PageObjectsJobApply.dd_state_b(driver).click();
			       PageObjectsJobApply.dd_state_input_b(driver).clear();
			       PageObjectsJobApply.dd_state_input_b(driver).sendKeys(State);//data.state
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_state_input_select_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_state_input_select_b(driver)));
			       PageObjectsJobApply.dd_state_input_select_b(driver).click(); 
		       }
		       
		       String city1 = PageObjectsJobApply.dd_city_b(driver).getText();
		       System.out.println("city is "+city1);
		       
		       if (city1.isEmpty()||city1.contains("Select City")) {
		    	   
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_city_b(driver)));
			       test.log(Status.INFO,"Entering the City");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_city_b(driver)));
			       PageObjectsJobApply.dd_city_b(driver).click();
			       PageObjectsJobApply.dd_city_input_b(driver).clear();
			       PageObjectsJobApply.dd_city_input_b(driver).sendKeys(City);
			       Thread.sleep(2000);//data.city
			       if (City.contains("Other")) {
			    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_city_input_select_b(driver)));
				       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_city_input_select_b(driver)));
				       PageObjectsJobApply.dd_city_input_select_b(driver).click();
				       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_other_city_b(driver)));
				       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_other_city_b(driver)));
				       PageObjectsJobApply.txt_other_city_b(driver).sendKeys(Other_City);//data.city
				       
			       } else {
					   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_city_input_select_b(driver)));
				       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_city_input_select_b(driver)));
				       PageObjectsJobApply.dd_city_input_select_b(driver).click();
				       
			       }
		    	   
		       }
		      	       
		       jse.executeScript("arguments[0].scrollIntoView();", PageObjectsJobApply.dd_city_b(driver)); 
		       Thread.sleep(3000);
		      	String nationality1 = PageObjectsJobApply.dd_nationality_b(driver).getText();
		       System.out.println("Nationality is "+nationality1);
		       
		       if (nationality1.isEmpty()||nationality1.contains("Select Nationality")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_nationality_b(driver)));
			       test.log(Status.INFO,"Entering the Nationality");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_nationality_b(driver)));
			       PageObjectsJobApply.dd_nationality_b(driver).click();
			       PageObjectsJobApply.dd_nationality_input_b(driver).clear();
			       PageObjectsJobApply.dd_nationality_input_b(driver).sendKeys(Nationality);//data.nationality
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_nationality_input_select_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_nationality_input_select_b(driver)));
			       PageObjectsJobApply.dd_nationality_input_select_b(driver).click();
		       }
		       
		       String citizenship1 = PageObjectsJobApply.dd_citizenship_b(driver).getText();
		       System.out.println("Citizenship is "+citizenship1);
		       
		       if (citizenship1.isEmpty()||citizenship1.contains("Select Citizenship")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_citizenship_b(driver)));
			       test.log(Status.INFO,"Entering the Citizenship");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_citizenship_b(driver)));
			       PageObjectsJobApply.dd_citizenship_b(driver).click();
			       PageObjectsJobApply.dd_citizenship_input_b(driver).clear();
			       PageObjectsJobApply.dd_citizenship_input_b(driver).sendKeys(Citizenship);//data.nationality
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_citizenship_input_select_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_citizenship_input_select_b(driver)));
			       PageObjectsJobApply.dd_citizenship_input_select_b(driver).click();
		       }
		      
		       String notice_period1 = PageObjectsJobApply.dd_notice_period_b(driver).getText();
		       System.out.println("Notice Period is "+notice_period1);
		       
		       if (notice_period1.isEmpty()||notice_period1.contains("Select Notice Period")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_notice_period_b(driver)));
			       test.log(Status.INFO,"Entering the Notice Period");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_notice_period_b(driver)));
			       PageObjectsJobApply.dd_notice_period_b(driver).click();
			       PageObjectsJobApply.dd_notice_period_input_b(driver).clear();
			       PageObjectsJobApply.dd_notice_period_input_b(driver).sendKeys(Notice_Period);
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_notice_period_input_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_notice_period_input_select_b(driver)));
			       PageObjectsJobApply.dd_notice_period_input_select_b(driver).click();
		       }
		              
		       String rel_exp_years = PageObjectsJobApply.txt_relevant_experience_in_years_b(driver).getText();
		       System.out.println(rel_exp_years);
		       if (rel_exp_years.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_relevant_experience_in_years_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_relevant_experience_in_years_b(driver)));
			       test.log(Status.INFO,"Entering the Relevant Experience (in Years)*");
			       PageObjectsJobApply.txt_relevant_experience_in_years_b(driver).clear();
			       PageObjectsJobApply.txt_relevant_experience_in_years_b(driver).sendKeys(Relevant_Experience_In_Years);
			}
		      
		       String current_annual_salary = PageObjectsJobApply.txt_Current_Annual_Salary_b(driver).getText();
		       System.out.println(current_annual_salary);
		       if (current_annual_salary.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_Current_Annual_Salary_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_Current_Annual_Salary_b(driver)));
			       test.log(Status.INFO,"Entering the Current Annual Salary");
			       PageObjectsJobApply.txt_Current_Annual_Salary_b(driver).clear();
			       PageObjectsJobApply.txt_Current_Annual_Salary_b(driver).sendKeys(Current_Annual_Salary);
			}
			   
		       String expected_annual_salary = PageObjectsJobApply.txt_Expected_Annual_Salary_b(driver).getText();
		       System.out.println(expected_annual_salary);
		       if (expected_annual_salary.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_Expected_Annual_Salary_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_Expected_Annual_Salary_b(driver)));
			       test.log(Status.INFO,"Entering the Expected Annual salary");
			       PageObjectsJobApply.txt_Expected_Annual_Salary_b(driver).clear();
			       PageObjectsJobApply.txt_Expected_Annual_Salary_b(driver).sendKeys(Expected_Annual_Salary);
			}
			    
		       String primary_skill = PageObjectsJobApply.txt_Primary_Skill_b(driver).getAttribute("value");
		       System.out.println(primary_skill);
		       test = extent.createTest("Verify whether the Primary Skill is populated by its own");
		       TakeScreenshot.captureScreenShot(driver);	
		       Verify.verify(!PageObjectsJobApply.txt_Primary_Skill_b(driver).getAttribute("value").isEmpty());
		       
		       String is_aadhar_card_available =  PageObjectsJobApply.dd_is_aadhaar_card_available_b(driver).getText();
		       System.out.println(is_aadhar_card_available);
		       
		       if (is_aadhar_card_available.contains("Select")||is_aadhar_card_available.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_is_aadhaar_card_available_b(driver)));
			       test.log(Status.INFO,"Entering the Is Aadhaar Card Available");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_is_aadhaar_card_available_b(driver)));
			       PageObjectsJobApply.dd_is_aadhaar_card_available_b(driver).click();
			       PageObjectsJobApply.dd_is_aadhaar_card_available_input_b(driver).clear();
			       PageObjectsJobApply.dd_is_aadhaar_card_available_input_b(driver).sendKeys(Is_Aadhar_Card_Available);//data.is_aadhar_card_available
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_is_aadhaar_card_available_input_select_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_is_aadhaar_card_available_input_select_b(driver)));
			       PageObjectsJobApply.dd_is_aadhaar_card_available_input_select_b(driver).click();		       
		       }
		       
		       
		       String is_aadhar_card_available1 =  PageObjectsJobApply.dd_is_aadhaar_card_available_b(driver).getText();
		       System.out.println(is_aadhar_card_available1);
		       
		       if (is_aadhar_card_available1.contains("Yes")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_aadhaar_number_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_aadhaar_number_b(driver)));
			       PageObjectsJobApply.txt_aadhaar_number_b(driver).sendKeys(Aadhar_Number);
			       
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_aadhaar_name_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_aadhaar_name_b(driver)));
			       PageObjectsJobApply.txt_aadhaar_name_b(driver).sendKeys(First_Name);
			}
		       else if (is_aadhar_card_available.contains("Applied For")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_aadhaar_enroll_num_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_aadhaar_enroll_num_b(driver)));
			       PageObjectsJobApply.txt_aadhaar_enroll_num_b(driver).sendKeys(Aadhar_Enroll_Num);
			       
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_aadhaar_name_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_aadhaar_name_b(driver)));
			       PageObjectsJobApply.txt_aadhaar_name_b(driver).sendKeys(First_Name);
			}
		       	       	       
		       jse.executeScript("arguments[0].scrollIntoView();", PageObjectsJobApply.txt_primary_skill(driver)); 
		       Thread.sleep(3000);
		       
		       String Passport_number = PageObjectsJobApply.txt_passport_no_b(driver).getText();
		       System.out.println(Passport_number);
		       if (Passport_number.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_passport_no_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_passport_no_b(driver)));
			       PageObjectsJobApply.txt_passport_no_b(driver).sendKeys(Passport_Number);	       
			}
		      
		       
		       String total_experience = PageObjectsJobApply.dd_total_exp_b(driver).getText();
		       System.out.println(total_experience);
		       if (total_experience.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_total_exp_b(driver)));
			       test.log(Status.INFO,"Entering the Total Experience");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_total_exp_b(driver)));
			       PageObjectsJobApply.dd_total_exp_b(driver).click();
			       PageObjectsJobApply.dd_total_exp_input_b(driver).clear();
			       PageObjectsJobApply.dd_total_exp_input_b(driver).sendKeys(Total_Experience);
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_total_exp_input_select_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_total_exp_input_select_b(driver)));
			       PageObjectsJobApply.dd_total_exp_input_select_b(driver).click();
			}
		             
		       String highest_educational_qualification =  PageObjectsJobApply.dd_highdeg_b(driver).getText();
		       System.out.println(highest_educational_qualification);
		       
		       if (highest_educational_qualification.isEmpty()||highest_educational_qualification.contains("Select Graduation")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_highdeg_b(driver)));
			       test.log(Status.INFO,"Entering the Highest Educational Qualification");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_highdeg_b(driver)));
			       PageObjectsJobApply.dd_highdeg_b(driver).click();
			       PageObjectsJobApply.dd_highdeg_input_b(driver).clear();
			       PageObjectsJobApply.dd_highdeg_input_b(driver).sendKeys(Highest_Educational_Qualification);
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_highdeg_input_select_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_highdeg_input_select_b(driver)));
			       PageObjectsJobApply.dd_highdeg_input_select_b(driver).click();
		       }
		       
		       String year_graduated = PageObjectsJobApply.txt_year_graduated_b(driver).getText();
		       System.out.println(year_graduated);
		       if (year_graduated.isEmpty()) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_year_graduated_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_year_graduated_b(driver)));
			       test.log(Status.INFO,"Entering the Year Graduated");
			       PageObjectsJobApply.txt_year_graduated_b(driver).clear();
			       PageObjectsJobApply.txt_year_graduated_b(driver).sendKeys(Year_Graduated);
			}
		       
		       String specialization =  PageObjectsJobApply.dd_specialization_b(driver).getText();
		       System.out.println(specialization);
		       
		       if (specialization.isEmpty()||specialization.contains("Select")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_specialization_b(driver)));
			       test.log(Status.INFO,"Entering the Specialization");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_specialization_b(driver)));
			       PageObjectsJobApply.dd_specialization_b(driver).click();
			       PageObjectsJobApply.dd_specialization_input_b(driver).clear();
			       PageObjectsJobApply.dd_specialization_input_b(driver).sendKeys(Specialization);
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_specialization_input_select_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_specialization_input_select_b(driver)));
			       PageObjectsJobApply.dd_specialization_input_select_b(driver).click();
		       }
		       
		       
		       String is_pan_card_available =  PageObjectsJobApply.dd_pancard_b(driver).getText();
		       System.out.println(is_pan_card_available);
		       
		       if (is_pan_card_available.isEmpty()||is_pan_card_available.contains("Applied For")||is_pan_card_available.contains("Not Applied For")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_pancard_b(driver)));
			       test.log(Status.INFO,"Entering the Is Pan Card Available");
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_pancard_b(driver)));
			       PageObjectsJobApply.dd_pancard_b(driver).click();
			       PageObjectsJobApply.dd_pancard_input_b(driver).clear();
			       PageObjectsJobApply.dd_pancard_input_b(driver).sendKeys(Is_Pan_Card_Available);
			       wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_pancard_input_select_b(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_pancard_input_select_b(driver)));
			       PageObjectsJobApply.dd_pancard_input_select_b(driver).click();
			       	       
		       }
		       
		       String is_pan_card_available1 =  PageObjectsJobApply.dd_pancard_b(driver).getText();
		       System.out.println(is_pan_card_available1);
		       if (is_pan_card_available1.contains("Yes")) {
		    	   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.txt_pancard(driver)));
			       wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.txt_pancard(driver)));
			       PageObjectsJobApply.txt_pancard(driver).sendKeys(Pan_Number);
				
			}
		       
		       	   
		       String college_name =  PageObjectsJobApply.dd_college_b(driver).getAttribute("value");
		       System.out.println(college_name);
		       
		       if (college_name.isEmpty()) {
		    	   
				wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_college_b(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_college_b(driver)));
				PageObjectsJobApply.dd_college_b(driver).click();
				PageObjectsJobApply.dd_college_input_b(driver).clear();
				PageObjectsJobApply.dd_college_input_b(driver).sendKeys(College_Name);
				Thread.sleep(2000);
				PageObjectsJobApply.dd_college_input_b(driver).sendKeys(Keys.ENTER);
			}
		       
		       jse.executeScript("arguments[0].scrollIntoView()", PageObjectsJobApply.txt_passport_no_b(driver));
		       Thread.sleep(3000);
		       String how_did_you_hear_about_us =  PageObjectsJobApply.dd_hear_b(driver).getText();
		       System.out.println(how_did_you_hear_about_us);
		       
		       if (how_did_you_hear_about_us.isEmpty()||how_did_you_hear_about_us.contains("Select")) {
		    	   
				wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_hear_b(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.dd_hear_b(driver)));
				PageObjectsJobApply.dd_hear_b(driver).click();
				wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.dd_hear_input_b(driver)));
				PageObjectsJobApply.dd_hear_input_b(driver).clear();
				PageObjectsJobApply.dd_hear_input_b(driver).sendKeys(How_Did_You_Hear_About_Us);
				Thread.sleep(2000);
				PageObjectsJobApply.dd_hear_input_b(driver).sendKeys(Keys.ENTER);
			}
		       
		       if(Chk_willing_other_roles.contains("Yes")) { //data.chk_willing_other_roles.
		    	   	wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.chk_willing_other_roles(driver)));
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsJobApply.chk_willing_other_roles(driver)));
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
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.visi_confirmation_bpo(driver)));
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsJobApply.visi_CID_bpo(driver)));
		       test = extent.createTest("Obtaining the CID and Time Stamp of Candidates Created");
		       TakeScreenshot.captureScreenShot(driver);	
		       Assert.assertTrue(PageObjectsJobApply.visi_CID_bpo(driver).isDisplayed());
		       test.log(Status.INFO,"CID is:");
		       test.log(Status.INFO,PageObjectsJobApply.visi_CID_bpo(driver).getText());
		       Thread.sleep(2000);
	 //End of your code
	 }
	 
	 @DataProvider
	 
	    public Object[][] JOBAPPLY() throws Exception{
	 
		 Object[][] testObjArray = ExcelUtils_BPO.getTableArray("./test-input/TestDataJobApply.xlsx","Job Apply BPO");
	 
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
