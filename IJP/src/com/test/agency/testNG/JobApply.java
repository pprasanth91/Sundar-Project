package com.test.agency.testNG;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
import com.utilities.ExcelTestDataEAF;
import com.utilities.ExtendReports;
import com.utilities.ReadPropFile;
import com.utilities.TakeScreenshot;

public class JobApply extends ExtendReports {
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
		  	String scrFolder = System.getProperty("user.dir")+"\\Screenshots\\JobApply_Agency\\"+ new SimpleDateFormat("dd_MM_yyyy_HHmmss").format(Calendar.getInstance().getTime()).toString();
		    new File(scrFolder).mkdir();
		    System.setProperty("scr.folder", scrFolder);
	  }
	  	
	  @Test
  public void jobapply() throws Exception {
		  	String title=driver.getTitle();	  	 
		  	test = extent.createTest("IJP Home Page");
	        Assert.assertTrue(title.contains("Accenture Recruitment Portal- India"));	  	
	        if (PageObjectsEAF.btn_close_cookies(driver).isDisplayed()) {
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_close_cookies(driver)));
				 PageObjectsEAF.btn_close_cookies(driver).click();
			}
			
		    ExcelTestDataAgencyJobApply data = new ExcelTestDataAgencyJobApply();
		    	    
		    try {
				PageObjectsLogin.lnk_agency_login(driver).click();
				PageObjectsLogin.txt_agency_uname(driver).sendKeys(data.agencyid);
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
	        
		   if(data.entity.contentEquals("Solutions")){
			   
			   Actions builder = new Actions(driver);
			   builder.moveToElement(PageObjectsAgency.lnk_search_demands(driver)).build().perform();
			   builder.moveToElement(PageObjectsAgency.lnk_refer_candidate(driver)).build().perform();
			   builder.moveToElement(PageObjectsAgency.lnk_solutions(driver)).build().perform();
			   PageObjectsAgency.lnk_solutions(driver).click();
			     	
			   Thread.sleep(5000);
			   test = extent.createTest("Job Search Page");
		       Assert.assertTrue(driver.findElementByCssSelector("#ctl00_Main_lblHead").getText().contentEquals("Job Search"));
			   
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.lnk_job_search(driver));
			   System.out.println("Scrolled Down");
			   Thread.sleep(3000);

			   
			   PageObjectsAgency.btn_refer(driver).click();
			   System.out.println("Clicked the Refer button");
			   
			   wait.until(ExpectedConditions.titleContains("IDC Resume Upload"));
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.btn_choose_resume_cv(driver)));
			   PageObjectsAgency.btn_choose_resume_cv(driver).click();
			   StringSelection stringSelection = new StringSelection(prop.Word());
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
				
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_upload_resume_cv(driver)));
			   PageObjectsAgency.btn_upload_resume_cv(driver).click();
			   Thread.sleep(5000);
			   
			   wait.until(ExpectedConditions.titleContains("IDC Apply for Details"));
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_basic_details(driver)));
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.first_prefered_loca(driver));
			   
			   Thread.sleep(1000);
			  
			   PageObjectsAgency.txt_first_name(driver).click();
			   PageObjectsAgency.txt_first_name(driver).sendKeys(data.firstname);
			   
			   PageObjectsAgency.txt_middle_name(driver).click();
			   PageObjectsAgency.txt_middle_name(driver).sendKeys(data.middlename);
			   
			   PageObjectsAgency.txt_last_name(driver).click();
			   PageObjectsAgency.txt_last_name(driver).sendKeys(data.lastname);
			   
			   PageObjectsAgency.dd_gender(driver).click();
			   Thread.sleep(1000);
			   if(data.gender.contains("Male")){
				   PageObjectsAgency.dd_gender_male(driver).click(); 
			   }
			   else{
				   PageObjectsAgency.dd_gender_female(driver).click();
			   }

			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_last_name(driver));
			   	PageObjectsAgency.btn_dob(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob1(driver)));
			   	PageObjectsAgency.btn_dob1(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob2(driver)));
			   	PageObjectsAgency.btn_dob2(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob3(driver)));
			   	PageObjectsAgency.btn_dob3(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob4(driver)));
			   	PageObjectsAgency.btn_dob4(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob5(driver)));
			   	PageObjectsAgency.btn_dob5(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob6(driver)));
			   	PageObjectsAgency.btn_dob6(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob7(driver)));
			   	PageObjectsAgency.btn_dob7(driver).click();
			   	
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_gender(driver));
			   	PageObjectsAgency.lnk_email(driver).click();
			   	PageObjectsAgency.lnk_email(driver).sendKeys(data.email);
			   	
			   	PageObjectsAgency.dd_prev_acc(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_prev_acc_yes(driver)));
			   	PageObjectsAgency.dd_prev_acc_yes(driver).click();
			   	
			   	PageObjectsAgency.txt_add_corres(driver).click();
			   	PageObjectsAgency.txt_add_corres(driver).sendKeys(data.address);
			   	
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_prev_acc(driver));
			   	try {
					PageObjectsAgency.txt_pincode(driver).click();
					PageObjectsAgency.txt_pincode(driver).sendKeys(data.pincode);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Pin Code is not present");
				}
			   	
			   	PageObjectsAgency.txt_resi_no1(driver).click();
			   	PageObjectsAgency.txt_resi_no1(driver).sendKeys(data.resi_num_city_code);
			   	
			   	PageObjectsAgency.txt_resi_no2(driver).click();
			   	PageObjectsAgency.txt_resi_no2(driver).sendKeys(data.resi_num_area_code);
			   	
			   	PageObjectsAgency.txt_resi_no3(driver).click();
			   	PageObjectsAgency.txt_resi_no3(driver).sendKeys(data.resi_num_landline);
			   	
			   	PageObjectsAgency.txt_mobile_no(driver).click();
			   	PageObjectsAgency.txt_mobile_no(driver).sendKeys(data.mobile_num);
			   	
			   	test = extent.createTest("Filling Basic Details Page");
			    TakeScreenshot.captureScreenShot(driver);
			    
			    Assert.assertTrue(PageObjectsAgency.btn_next(driver).isDisplayed());
			   	
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_next(driver)));
			   	PageObjectsAgency.btn_next(driver).click();
			   	
			   	wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_advance(driver)));
			   	System.out.println(PageObjectsAgency.visi_advance(driver).getText());
			   	   
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_mobile_no(driver));
			   	
			  	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_country_swf(driver)));
			   	PageObjectsAgency.dd_country_swf(driver).click();
			   	List<WebElement> country_name = (List<WebElement>) driver.findElementsByXPath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[2]/div/div/div/ul/li");
			   	System.out.println(country_name.size());										
			   	for(WebElement country: country_name){
			   		String value = country.getText();
			   		if(value.equalsIgnoreCase(data.country)){
			   			country.click();
			   			System.out.println("Clicked Country name");
			   			break;
			   		}
			   	}
			   	
			   	Thread.sleep(3000);
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_state_swf(driver)));
			   	PageObjectsAgency.dd_state_swf(driver).click();
			   	
				List<WebElement> state_name = (List<WebElement>) driver.findElementsByXPath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[3]/div/div[1]/div/ul/li");
				System.out.println(state_name.size());											
			   	for(WebElement state: state_name){
			   		String value = state.getText();
			   		if(value.equalsIgnoreCase(data.state)){
			   			state.click();
			   			System.out.println("Clicked state name");
			   			break;
			   		}
			   	}
			   	
			   	Thread.sleep(3000);
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_city_swf(driver)));
			   	PageObjectsAgency.dd_city_swf(driver).click();
			   	
				List<WebElement> city_name = (List<WebElement>) driver.findElementsByXPath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[4]/div/div[1]/div/ul/li");
				System.out.println(city_name.size());										
				for(WebElement city: city_name){
			   		String value = city.getText();
			   		if(value.equalsIgnoreCase(data.city)){
			   			city.click();
			   			System.out.println("Clicked city name");
			   			break;
			   		}
			   	}
			   	
			   	
				Thread.sleep(3000);
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_state_swf(driver));
			   	
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_nationality_swf(driver)));
			   	PageObjectsAgency.dd_nationality_swf(driver).click();
			   	
				List<WebElement> nationality = (List<WebElement>) driver.findElementsByXPath("//*[@id=\"block-accenturecareers\"]/div/div/div/div/section/fieldset[2]/div[5]/div/div/div/ul/li");
				System.out.println(nationality.size());										
				for(WebElement nationality1: nationality){
			   		String value = nationality1.getText();
			   		if(value.equalsIgnoreCase(data.nationality)){
			   			nationality1.click();
			   			System.out.println("Clicked nationality name");
			   			break;
			   		}
			   	}
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_marital_status_swf(driver)));
			   	PageObjectsAgency.dd_marital_status_swf(driver).click();
			   	
				List<WebElement> marital_status = (List<WebElement>) driver.findElementsByXPath("//*[@id=\"ctl00_Main_divMS\"]/div/div/div/ul/li");
				System.out.println(marital_status.size());
				for(WebElement marital_status1: marital_status){
			   		String value = marital_status1.getText();
			   		if(value.equalsIgnoreCase(data.marital_status)){
			   			marital_status1.click();
			   			System.out.println("Clicked Marital Status");
			   			break;
			   		}
			   	}
				
				System.out.println("Entering Fact Sheet Details");
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_marital_status(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_relevant_exp(driver)));
				PageObjectsAgency.txt_relevant_exp(driver).click();
				PageObjectsAgency.txt_relevant_exp(driver).sendKeys(data.relevant_exp);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_ctc(driver)));
				PageObjectsAgency.txt_ctc(driver).click();
				PageObjectsAgency.txt_ctc(driver).sendKeys(data.ctc);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_ctc_expected(driver)));
				PageObjectsAgency.txt_ctc_expected(driver).click();
				PageObjectsAgency.txt_ctc_expected(driver).sendKeys(data.ctc_expected);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_notice_period(driver)));
				PageObjectsAgency.dd_notice_period(driver).click();
				
				List<WebElement> notice_period = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_divFactSheetDetails_block']/div[4]/div/div/div/ul/li");
				System.out.println(notice_period.size());										
				for(WebElement notice_period1: notice_period){
			   		String value = notice_period1.getText();
			   		if(value.equalsIgnoreCase(data.notice_period)){
			   			notice_period1.click();
			   			System.out.println("Clicked Notice Period");
			   			break;
			   		}
			   	}
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_name_poc(driver)));
				PageObjectsAgency.txt_name_poc(driver).click();
				PageObjectsAgency.txt_name_poc(driver).sendKeys(data.agency_name_poc);
				
//				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_channel(driver));
//				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_SR_num(driver)));
//				PageObjectsAgency.txt_SR_num(driver).click();
//				PageObjectsAgency.txt_SR_num(driver).sendKeys(data.sr_num);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_total_exp(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_high_deg(driver)));
				PageObjectsAgency.dd_high_deg(driver).click();
				
				List<WebElement> high_degree = (List<WebElement>) driver.findElementsByXPath("//*[@id=\"block-accenturecareers\"]/div/div/div/div/section/fieldset[2]/div[10]/div/div/div/ul/li");
				System.out.println(high_degree.size());
				for(WebElement high_degree1: high_degree){
			   		String value = high_degree1.getText();
			   		if(value.equalsIgnoreCase(data.highest_degree)){
			   			high_degree1.click();
			   			System.out.println("Clicked Highest Degree");
			   			break;
			   		}
			   	}
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_highest_edu(driver)));
				PageObjectsAgency.txt_highest_edu(driver).click();
				PageObjectsAgency.txt_highest_edu(driver).sendKeys(data.highest_edu_perc);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_highest_degree(driver)));
				PageObjectsAgency.dd_highest_degree(driver).click();
				
				List<WebElement> subject = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[14]/div/div/ul/li");
				System.out.println(subject.size());
				for(WebElement subject1: subject){
			   		String value = subject1.getText();
			   		if(value.equalsIgnoreCase(data.subject)){
			   			subject1.click();
			   			System.out.println("Clicked Highest Degree Subject");
			   			break;
			   		}
			   	}
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_pan(driver)));
				PageObjectsAgency.dd_pan(driver).click();
				
				List<WebElement> pan = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_divPANYN']/div/div/div/div/ul/li");
				System.out.println(pan.size());
				for(WebElement pan1: pan){
			   		String value = pan1.getText();
			   		if(value.equalsIgnoreCase(data.pan)){
			   			pan1.click();
			   			System.out.println("Clicked PAN");
			   			 			  			
			   			break;
			   		}
			   	}
				
				Thread.sleep(3000);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_high_deg(driver));
				String PAN_value = PageObjectsAgency.dd_pan(driver).getAttribute("title");
				System.out.println(PAN_value);
				if(PAN_value.equals("Yes")){
					PageObjectsAgency.dd_pan_no(driver).click();
					PageObjectsAgency.dd_pan_no(driver).sendKeys(data.pan_num);
					System.out.println("Clicked in loop");
				}
							
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_pan(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_passport(driver)));
				PageObjectsAgency.dd_passport(driver).click();
				
				List<WebElement> passport = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_divpanpass']/div[1]/div/div/div/ul/li");
				System.out.println(passport.size());
				for(WebElement passport1: passport){
			   		String value = passport1.getText();
			   		if(value.equalsIgnoreCase(data.passport)){
			   			passport1.click();
			   			System.out.println("Clicked Passport");
			   			break;
			   		}
			   	}
				Thread.sleep(3000);
				
				String Passport_value = PageObjectsAgency.dd_passport(driver).getAttribute("title");
				System.out.println(Passport_value);
				if(Passport_value.equalsIgnoreCase("Yes")) {
					PageObjectsAgency.txt_passport_no(driver).click();
					PageObjectsAgency.txt_passport_no(driver).sendKeys(data.passport_num);
				}
			
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_passport(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_aadhar_swf(driver)));
				PageObjectsAgency.dd_aadhar_swf(driver).click();			
				
				List<WebElement> aadhar = (List<WebElement>) driver.findElementsByXPath("//*[@id='ctl00_Main_divpanpass']/div[3]/div/div/div/ul/li");
				System.out.println(aadhar.size());
				for(WebElement aadhar1: aadhar){
			   		String value = aadhar1.getText();
			   		if(value.equalsIgnoreCase("Yes")){
			   			aadhar1.click();
			   			System.out.println("Clicked aadhar");
			   			wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_aadhar_num_swf(driver)));
						PageObjectsAgency.txt_aadhar_num_swf(driver).clear();
						PageObjectsAgency.txt_aadhar_num_swf(driver).sendKeys("776767679874");				
						
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_aadhar_name_swf(driver)));
						PageObjectsAgency.txt_aadhar_name_swf(driver).clear();
						PageObjectsAgency.txt_aadhar_name_swf(driver).sendKeys(data.firstname);		
						
			   			break;
			   		}
			   	}
				Thread.sleep(3000);
				
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_NSR(driver)));
				PageObjectsAgency.txt_NSR(driver).click();
				PageObjectsAgency.txt_NSR(driver).sendKeys("776767679874");
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_NSR(driver));
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_college(driver)));
				PageObjectsAgency.txt_college(driver).click();		
				Thread.sleep(1000);
				PageObjectsAgency.txt_college(driver).sendKeys("gover");
				Thread.sleep(4000);
//				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.txt_college_input_select(driver)));
//				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_college_input_select(driver)));
				PageObjectsAgency.txt_college(driver).sendKeys(Keys.DOWN);
				PageObjectsAgency.txt_college(driver).sendKeys(Keys.ENTER);
//				
//				PageObjectsAgency.txt_college_input_select(driver).click();
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_no_org(driver)));
				PageObjectsAgency.dd_no_org(driver).click();
				
				List<WebElement> no_org = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_divOrg']/div[1]/div/div/div/ul/li");
				System.out.println(no_org.size());
				for(WebElement no_org1: no_org){
			   		String value = no_org1.getText();
			   		if(value.equalsIgnoreCase(data.prev_worked_no_org)){
			   			no_org1.click();
			   			System.out.println("Clicked Number of organization worked");
			   			break;
			   		}
			   	}
				
				Thread.sleep(3000);
				String no_of_org = PageObjectsAgency.dd_no_org(driver).getText();
				System.out.println(no_of_org);
				if(no_of_org.contains("One")){
					jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_college(driver));
					Thread.sleep(3000);
					PageObjectsAgency.dd_current_org(driver).click();
					PageObjectsAgency.dd_current_org(driver).sendKeys("gov");
					Thread.sleep(4000);
//					wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.dd_current_org_first(driver)));
//					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_current_org_first(driver)));					
					PageObjectsAgency.dd_current_org(driver).sendKeys(Keys.DOWN);
					PageObjectsAgency.dd_current_org(driver).sendKeys(Keys.ENTER);
					
//					wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.dd_current_org_list(driver)));
//					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_current_org_list(driver)));
//					PageObjectsAgency.dd_current_org_list(driver).click();
					
//					List<WebElement> current_org = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_dvCollege']/div");
//					System.out.println(current_org.size());
//					for(WebElement current_org1: current_org){
//				   		String value = current_org1.getText();
//				   		if(value.equalsIgnoreCase(data.current_org1)){
//				   			current_org1.click();
//				   			System.out.println("Clicked Number of organization worked");
//				   			break;
//				   		}
//				   	}
					
				}
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.visi_speciality(driver));
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_ind_align(driver)));
				PageObjectsAgency.dd_ind_align(driver).click();
				
				List<WebElement> ind_align = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_divcapability']/div[3]/div/div/div/ul/li");
				System.out.println(ind_align.size());
				for(WebElement ind_align1: ind_align){
			   		String value = ind_align1.getText();
			   		if(value.equalsIgnoreCase(data.industry_alignment)){
			   			ind_align1.click();
			   			System.out.println("Clicked industry Alignment");
			   			break;
			   		}
			   	}
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_comments(driver)));
				PageObjectsAgency.txt_comments(driver).sendKeys(data.comments);
				
				String primary_skill = PageObjectsAgency.dd_primary_skill(driver).getAttribute("title");
				if (primary_skill.isEmpty() || primary_skill.contains("elect")) {
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_primary_skill(driver)));
					PageObjectsAgency.dd_primary_skill(driver).click();
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.dd_primary_skill_first(driver)));
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_primary_skill_first(driver)));
					PageObjectsAgency.dd_primary_skill_first(driver).click();					
				}
				
				String Year_it_was_last_put_in_practice = PageObjectsAgency.dd_last_year_practise_primary_skill(driver).getText();
				if (Year_it_was_last_put_in_practice.isEmpty() || Year_it_was_last_put_in_practice.contains("elect")) {
					wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.dd_last_year_practise_primary_skill(driver)));
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_last_year_practise_primary_skill(driver)));
					PageObjectsAgency.dd_last_year_practise_primary_skill(driver).click();		
					
					List<WebElement> Year_it_was_last_put_in_practices = (List<WebElement>) driver.findElementsByXPath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[23]/div[2]/div/div/ul/li");
					System.out.println(Year_it_was_last_put_in_practices.size());
					for(WebElement Year_it_was_last_put_in_practices1: Year_it_was_last_put_in_practices){
				   		String value = Year_it_was_last_put_in_practices1.getText();
				   		if(value.equalsIgnoreCase("2017")){
				   			Year_it_was_last_put_in_practices1.click();
				   			System.out.println("Clicked Year_it_was_last_put_in_practices ");
				   			break;
				   		}
				   	}						
				}
					
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_primary_skill(driver));
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_opt_skills1(driver)));
				PageObjectsAgency.dd_opt_skills1(driver).click();
				PageObjectsAgency.dd_opt_skills1(driver).sendKeys(data.opt_skill1);
				Thread.sleep(4000);
				PageObjectsAgency.dd_opt_skills1(driver).sendKeys(Keys.DOWN);
				PageObjectsAgency.dd_opt_skills1(driver).sendKeys(Keys.ENTER);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_exp_opt_skills1(driver)));
				PageObjectsAgency.txt_exp_opt_skills1(driver).clear();
				PageObjectsAgency.txt_exp_opt_skills1(driver).sendKeys("24");
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_last_used_opt_skills1(driver)));
				PageObjectsAgency.dd_last_used_opt_skills1(driver).click();
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.dd_last_used_first_opt_skills1(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_last_used_first_opt_skills1(driver)));
				PageObjectsAgency.dd_last_used_first_opt_skills1(driver).click();				
				
				if (PageObjectsAgency.chk_other_roles(driver).isSelected()) {
					System.out.println("I am willing to be considered for other roles Checkbox is already checked");					
				}
				else {
					PageObjectsAgency.chk_other_roles(driver).click();
				}
				
				if (PageObjectsAgency.chk_accurate_details(driver).isSelected()) {
					System.out.println("We agree that we have spoken to the Candidate and confirm that the details provided here accurate Checkbox is already checked");					
				}
				else {
					PageObjectsAgency.chk_accurate_details(driver).click();
				}
				
				test = extent.createTest("Clicking the submit button");
			    TakeScreenshot.captureScreenShot(driver);
			    
			    Assert.assertTrue(PageObjectsAgency.btn_save_bpo(driver).isDisplayed());
				
//				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_save(driver)));
//				PageObjectsAgency.btn_save(driver).click();
//				
//				Thread.sleep(10000);
//				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_confirmation_candidate(driver)));
//				TakeScreenshot.captureScreenShot(driver);
//				test = extent.createTest("Candidate Creation Confirmation");
//				Assert.assertTrue(PageObjectsAgency.visi_confirmation_candidate(driver).getText().contentEquals("Confirmation"));
//				
//				System.out.println(PageObjectsAgency.visi_cid_display(driver).getText());
//					
//				TakeScreenshot.captureScreenShot(driver);
//				Thread.sleep(10000);
			    
			    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_save_bpo(driver)));
				PageObjectsAgency.btn_save_bpo(driver).click();
				Thread.sleep(2000);
				
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.btn_yes_statement_complaince_bpo(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_yes_statement_complaince_bpo(driver)));
				PageObjectsAgency.btn_yes_statement_complaince_bpo(driver).click();				
				TakeScreenshot.captureScreenShot(driver);
				
				Thread.sleep(15000);
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_confirmation_candidate_bpo(driver)));
				TakeScreenshot.captureScreenShot(driver);
				test = extent.createTest("Candidate Creation Confirmation");
				Assert.assertTrue(PageObjectsAgency.visi_confirmation_candidate_bpo(driver).getText().contentEquals("Confirmation"));
				
				System.out.println(PageObjectsAgency.visi_cid_display_bpo(driver).getText());
				test = extent.createTest("Candidate Creation Confirmation"+PageObjectsAgency.visi_cid_display_bpo(driver).getText());	
				TakeScreenshot.captureScreenShot(driver);
				Thread.sleep(10000);			   			    
			   
		   }
		   
		   else if(data.entity.contentEquals("Services")){
			   
			   Actions builder = new Actions(driver);
			   builder.moveToElement(PageObjectsAgency.lnk_search_demands(driver)).build().perform();
			   builder.moveToElement(PageObjectsAgency.lnk_refer_candidate(driver)).build().perform();
			   builder.moveToElement(PageObjectsAgency.lnk_services(driver)).build().perform();
			   PageObjectsAgency.lnk_services(driver).click();
			     	
			   Thread.sleep(5000);
			   test = extent.createTest("Job Search Page");
		       Assert.assertTrue(driver.findElementByCssSelector("#ctl00_Main_lblHead").getText().contentEquals("Job Search"));
			   
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.lnk_job_search(driver));
			   System.out.println("Scrolled Down");
			   Thread.sleep(3000);

			   PageObjectsAgency.btn_refer(driver).click();
			   System.out.println("Clicked the Refer button");
			   
			   wait.until(ExpectedConditions.titleContains("BPO Resume Upload"));
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.btn_choose_resume_cv(driver)));
			   PageObjectsAgency.btn_choose_resume_cv(driver).click();
			   StringSelection stringSelection = new StringSelection(prop.Word());
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
				
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_upload_resume_cv(driver)));
			   PageObjectsAgency.btn_upload_resume_cv(driver).click();
			   Thread.sleep(5000);
			   
			   wait.until(ExpectedConditions.titleContains("BPO Apply for Details"));
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_basic_details(driver)));
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.first_prefered_loca(driver));
			   
			   Thread.sleep(1000);
			  
			   PageObjectsAgency.txt_first_name(driver).click();
			   PageObjectsAgency.txt_first_name(driver).sendKeys(data.firstname);
			   
			   PageObjectsAgency.txt_middle_name(driver).click();
			   PageObjectsAgency.txt_middle_name(driver).sendKeys(data.middlename);
			   
			   PageObjectsAgency.txt_last_name(driver).click();
			   PageObjectsAgency.txt_last_name(driver).sendKeys(data.lastname);
			   
			   PageObjectsAgency.dd_gender(driver).click();
			   Thread.sleep(1000);
			   if(data.gender.contains("Male")){
				   PageObjectsAgency.dd_gender_male(driver).click(); 
			   }
			   else{
				   PageObjectsAgency.dd_gender_female(driver).click();
			   }

			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_last_name(driver));
			   	PageObjectsAgency.btn_dob(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob1(driver)));
			   	PageObjectsAgency.btn_dob1(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob2(driver)));
			   	PageObjectsAgency.btn_dob2(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob3(driver)));
			   	PageObjectsAgency.btn_dob3(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob4(driver)));
			   	PageObjectsAgency.btn_dob4(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob5(driver)));
			   	PageObjectsAgency.btn_dob5(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob6(driver)));
			   	PageObjectsAgency.btn_dob6(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob7(driver)));
			   	PageObjectsAgency.btn_dob7(driver).click();
			   	
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_gender(driver));
			   	PageObjectsAgency.lnk_email(driver).click();
			   	PageObjectsAgency.lnk_email(driver).sendKeys(data.email);
			   	
			   	PageObjectsAgency.dd_prev_acc(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_prev_acc_yes(driver)));
			   	PageObjectsAgency.dd_prev_acc_yes(driver).click();
			   	
			   	PageObjectsAgency.txt_add_corres(driver).click();
			   	PageObjectsAgency.txt_add_corres(driver).sendKeys(data.address);
			   	
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_prev_acc(driver));
			   	try {
					PageObjectsAgency.txt_pincode(driver).click();
					PageObjectsAgency.txt_pincode(driver).sendKeys(data.pincode);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Pin Code is not present");
				}
			   	
			   	PageObjectsAgency.txt_resi_no1(driver).click();
			   	PageObjectsAgency.txt_resi_no1(driver).sendKeys(data.resi_num_city_code);
			   	
			   	PageObjectsAgency.txt_resi_no2(driver).click();
			   	PageObjectsAgency.txt_resi_no2(driver).sendKeys(data.resi_num_area_code);
			   	
			   	PageObjectsAgency.txt_resi_no3(driver).click();
			   	PageObjectsAgency.txt_resi_no3(driver).sendKeys(data.resi_num_landline);
			   	
			   	PageObjectsAgency.txt_mobile_no(driver).click();
			   	PageObjectsAgency.txt_mobile_no(driver).sendKeys(data.mobile_num);
			   	
			   	test = extent.createTest("Filling Basic Details Page");
			    TakeScreenshot.captureScreenShot(driver);
			    
			    Assert.assertTrue(PageObjectsAgency.btn_next(driver).isDisplayed());
			   	
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_next(driver)));
			   	PageObjectsAgency.btn_next(driver).click();
			   	
			   	wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_advance(driver)));
			   	System.out.println(PageObjectsAgency.visi_advance(driver).getText());
			   	   
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_mobile_no_after(driver));
			   	
			  	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_country_bpo(driver)));
			   	PageObjectsAgency.dd_country_bpo(driver).click();
			   	List<WebElement> country_name = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[14]/div/div/div/ul/li");
			   	System.out.println(country_name.size());										
			   	for(WebElement country: country_name){
			   		String value = country.getText();
			   		if(value.equalsIgnoreCase(data.country)){
			   			country.click();
			   			System.out.println("Clicked Country name");
			   			break;
			   		}
			   	}
			   	
			   	Thread.sleep(3000);
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_state_bpo(driver)));
			   	PageObjectsAgency.dd_state_bpo(driver).click();
			   	
				List<WebElement> state_name = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[15]/div/div/div/ul/li");
				System.out.println(state_name.size());											
			   	for(WebElement state: state_name){
			   		String value = state.getText();
			   		if(value.equalsIgnoreCase(data.state)){
			   			state.click();
			   			System.out.println("Clicked state name");
			   			break;
			   		}
			   	}
			   	
			   	Thread.sleep(3000);
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_city_bpo(driver)));
			   	PageObjectsAgency.dd_city_bpo(driver).click();
			   	
				List<WebElement> city_name = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[17]/div/div/div/ul/li");
				System.out.println(city_name.size());										
				for(WebElement city: city_name){
			   		String value = city.getText();
			   		if(value.equalsIgnoreCase(data.city)){
			   			city.click();
			   			System.out.println("Clicked city name");
			   			break;
			   		}
			   	}
			   	
			   	
				Thread.sleep(3000);
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_state_bpo(driver));
			   	
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_nationality_bpo(driver)));
			   	PageObjectsAgency.dd_nationality_bpo(driver).click();
			   	
				List<WebElement> nationality = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[19]/div/div/div/ul/li");
				System.out.println(nationality.size());										
				for(WebElement nationality1: nationality){
			   		String value = nationality1.getText();
			   		if(value.equalsIgnoreCase(data.nationality)){
			   			nationality1.click();
			   			System.out.println("Clicked nationality name");
			   			break;
			   		}
			   	}
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_citizenship_bpo(driver)));
			   	PageObjectsAgency.dd_citizenship_bpo(driver).click();
			   	
				List<WebElement> citizenship = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[20]/div/div/div/ul/li");
				System.out.println(citizenship.size());										
				for(WebElement citizenship1: citizenship){
			   		String value = citizenship1.getText();
			   		if(value.equalsIgnoreCase(data.citizenship)){
			   			citizenship1.click();
			   			System.out.println("Clicked citizenship name");
			   			break;
			   		}
			   	}
				
//				Thread.sleep(3000);
//				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_marital_status_swf(driver)));
//			   	PageObjectsAgency.dd_marital_status_swf(driver).click();
//			   	
//				List<WebElement> marital_status = (List<WebElement>) driver.findElementsByXPath("//*[@id=\"ctl00_Main_divMS\"]/div/div/div/ul/li");
//				System.out.println(marital_status.size());
//				for(WebElement marital_status1: marital_status){
//			   		String value = marital_status1.getText();
//			   		if(value.equalsIgnoreCase(data.marital_status)){
//			   			marital_status1.click();
//			   			System.out.println("Clicked Marital Status");
//			   			break;
//			   		}
//			   	}
				
				System.out.println("Entering Fact Sheet Details");
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_citizenship_bpo(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_notice_period_bpo1(driver)));
				PageObjectsAgency.dd_notice_period_bpo1(driver).click();
				
				List<WebElement> notice_period = (List<WebElement>) driver.findElementsByXPath("//*[@id='ctl00_Main_FactSheetDetails']/div/div/div/div/ul/li");
				System.out.println(notice_period.size());										
				for(WebElement notice_period1: notice_period){
			   		String value = notice_period1.getText();
			   		if(value.equalsIgnoreCase("16 to 30 days")){
			   			notice_period1.click();
			   			System.out.println("Clicked Notice Period");
			   			break;
			   		}
			   	}
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_channel_bpo(driver));
				
				System.out.println("Entering the Qualification and Experience:");
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_qualification_bpo1(driver)));
				PageObjectsAgency.dd_qualification_bpo1(driver).click();
				
				List<WebElement> qualification_bpo = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[23]/div/div/div/ul/li");
				System.out.println(qualification_bpo.size());										
				for(WebElement qualification_bpo1: qualification_bpo){
			   		String value = qualification_bpo1.getText();
			   		if(value.equalsIgnoreCase("B.B.M")){
			   			qualification_bpo1.click();
			   			System.out.println("Clicked qualification Details");
			   			break;
			   		}
			   	}
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_year_of_passing_bpo1(driver)));
				PageObjectsAgency.txt_year_of_passing_bpo1(driver).click();
				PageObjectsAgency.txt_year_of_passing_bpo1(driver).sendKeys(data.year_of_passing);	
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_pan_bpo(driver)));
				PageObjectsAgency.dd_pan_bpo(driver).click();
				
				List<WebElement> pan = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_divPANYN']/div/div/div/div/ul/li");
				System.out.println(pan.size());
				for(WebElement pan1: pan){
			   		String value = pan1.getText();
			   		if(value.equalsIgnoreCase(data.pan)){
			   			pan1.click();
			   			System.out.println("Clicked PAN");
			   			
			   			if (data.pan.contentEquals("Yes")) {
			   				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_pan_no_bpo(driver)));
							PageObjectsAgency.txt_pan_no_bpo(driver).click();
							PageObjectsAgency.txt_pan_no_bpo(driver).sendKeys(data.pan_num);	
						}
			   			 			  			
			   			break;
			   		}
			   	}
				
				Thread.sleep(3000);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_pan_bpo(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_passport_bpo(driver)));
				PageObjectsAgency.txt_passport_bpo(driver).clear();
				PageObjectsAgency.txt_passport_bpo(driver).sendKeys(data.passport_num);
				
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_passport_bpo(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_aadhar_bpo(driver)));
				PageObjectsAgency.dd_aadhar_bpo(driver).click();			
				
				List<WebElement> aadhar = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[28]/div/div/div/ul/li");
				System.out.println(aadhar.size());
				for(WebElement aadhar1: aadhar){
			   		String value = aadhar1.getText();
			   		if(value.equalsIgnoreCase("Yes")){
			   			aadhar1.click();
			   			System.out.println("Clicked aadhar");
			   			wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_aadhar_num_bpo(driver)));
						PageObjectsAgency.txt_aadhar_num_bpo(driver).clear();
						PageObjectsAgency.txt_aadhar_num_bpo(driver).sendKeys("776767679874");				
						
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_aadhar_name_bpo(driver)));
						PageObjectsAgency.txt_aadhar_name_bpo(driver).clear();
						PageObjectsAgency.txt_aadhar_name_bpo(driver).sendKeys(data.firstname);		
						
			   			break;
			   		}
			   	}
				Thread.sleep(3000);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_aadhar_name_bpo(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_total_exp_bpo1(driver)));
				PageObjectsAgency.dd_total_exp_bpo1(driver).click();
				
				List<WebElement> total_exp = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[32]/div/div/div/ul/li");
				System.out.println(total_exp.size());										
				for(WebElement total_exp1: total_exp){
			   		String value = total_exp1.getText();
			   		if(value.equalsIgnoreCase("7 years")){
			   			total_exp1.click();
			   			System.out.println("Clicked total experience Details");
			   			break;
			   		}
			   	}
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_relevant_exp_bpo(driver)));
				PageObjectsAgency.txt_relevant_exp_bpo(driver).click();
				PageObjectsAgency.txt_relevant_exp_bpo(driver).sendKeys(data.relevant_exp);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_ctc_bpo(driver)));
				PageObjectsAgency.txt_ctc_bpo(driver).click();
				PageObjectsAgency.txt_ctc_bpo(driver).sendKeys(data.ctc);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_ctc_expected_bpo(driver)));
				PageObjectsAgency.txt_ctc_expected_bpo(driver).click();
				PageObjectsAgency.txt_ctc_expected_bpo(driver).sendKeys(data.ctc_expected);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_ctc_bpo(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_specialization_bpo1(driver)));
				PageObjectsAgency.dd_specialization_bpo1(driver).click();
				
				List<WebElement> specialization_bpo = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[34]/div/div/div/ul/li");
				System.out.println(specialization_bpo.size());
				for(WebElement specialization_bpo1: specialization_bpo){
			   		String value = specialization_bpo1.getText();
			   		if(value.equalsIgnoreCase("Accounting")){
			   			specialization_bpo1.click();
			   			System.out.println("Clicked Specialization");
			   			break;
			   		}
			   	}
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_specialization_bpo1(driver));
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_college_bpo(driver)));
				PageObjectsAgency.txt_college_bpo(driver).click();		
				Thread.sleep(1000);
				PageObjectsAgency.txt_college_bpo(driver).sendKeys("gover");
				Thread.sleep(4000);
				PageObjectsAgency.txt_college_bpo(driver).sendKeys(Keys.DOWN);
				PageObjectsAgency.txt_college_bpo(driver).sendKeys(Keys.ENTER);
				
				
				if (PageObjectsAgency.chk_other_roles_bpo(driver).isSelected()) {
					System.out.println("I am willing to be considered for other roles Checkbox is already checked");					
				}
				else {
					PageObjectsAgency.chk_other_roles_bpo(driver).click();
				}
				
				test = extent.createTest("Clicking the submit button");
			    TakeScreenshot.captureScreenShot(driver);
			    
			    Assert.assertTrue(PageObjectsAgency.btn_save_bpo(driver).isDisplayed());
				
			    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_save_bpo(driver)));
				PageObjectsAgency.btn_save_bpo(driver).click();
				Thread.sleep(2000);
				
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.btn_yes_statement_complaince_bpo(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_yes_statement_complaince_bpo(driver)));
				PageObjectsAgency.btn_yes_statement_complaince_bpo(driver).click();				
				TakeScreenshot.captureScreenShot(driver);
				
				Thread.sleep(15000);
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_confirmation_candidate_bpo(driver)));
				TakeScreenshot.captureScreenShot(driver);
				test = extent.createTest("Candidate Creation Confirmation");
				Assert.assertTrue(PageObjectsAgency.visi_confirmation_candidate_bpo(driver).getText().contentEquals("Confirmation"));
				
				System.out.println(PageObjectsAgency.visi_cid_display_bpo(driver).getText());
				test = extent.createTest("Candidate Creation Confirmation"+PageObjectsAgency.visi_cid_display_bpo(driver).getText());	
				TakeScreenshot.captureScreenShot(driver);
				Thread.sleep(10000);			   			    
				
				
				/*
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_relevant_exp(driver)));
				PageObjectsAgency.txt_relevant_exp(driver).click();
				PageObjectsAgency.txt_relevant_exp(driver).sendKeys(data.relevant_exp);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_ctc(driver)));
				PageObjectsAgency.txt_ctc(driver).click();
				PageObjectsAgency.txt_ctc(driver).sendKeys(data.ctc);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_ctc_expected(driver)));
				PageObjectsAgency.txt_ctc_expected(driver).click();
				PageObjectsAgency.txt_ctc_expected(driver).sendKeys(data.ctc_expected);
				
				
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_name_poc(driver)));
				PageObjectsAgency.txt_name_poc(driver).click();
				PageObjectsAgency.txt_name_poc(driver).sendKeys(data.agency_name_poc);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_channel(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_SR_num(driver)));
				PageObjectsAgency.txt_SR_num(driver).click();
				PageObjectsAgency.txt_SR_num(driver).sendKeys(data.sr_num);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_total_exp(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_high_deg(driver)));
				PageObjectsAgency.dd_high_deg(driver).click();
				
				List<WebElement> high_degree = (List<WebElement>) driver.findElementsByXPath("//*[@id=\"block-accenturecareers\"]/div/div/div/div/section/fieldset[2]/div[10]/div/div/div/ul/li");
				System.out.println(high_degree.size());
				for(WebElement high_degree1: high_degree){
			   		String value = high_degree1.getText();
			   		if(value.equalsIgnoreCase(data.highest_degree)){
			   			high_degree1.click();
			   			System.out.println("Clicked Highest Degree");
			   			break;
			   		}
			   	}
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_highest_edu(driver)));
				PageObjectsAgency.txt_highest_edu(driver).click();
				PageObjectsAgency.txt_highest_edu(driver).sendKeys(data.highest_edu_perc);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_highest_degree(driver)));
				PageObjectsAgency.dd_highest_degree(driver).click();
				
				List<WebElement> subject = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[14]/div/div/ul/li");
				System.out.println(subject.size());
				for(WebElement subject1: subject){
			   		String value = subject1.getText();
			   		if(value.equalsIgnoreCase(data.subject)){
			   			subject1.click();
			   			System.out.println("Clicked Highest Degree Subject");
			   			break;
			   		}
			   	}
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_pan(driver)));
				PageObjectsAgency.dd_pan(driver).click();
				
				List<WebElement> pan = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_divPANYN']/div/div/div/div/ul/li");
				System.out.println(pan.size());
				for(WebElement pan1: pan){
			   		String value = pan1.getText();
			   		if(value.equalsIgnoreCase(data.pan)){
			   			pan1.click();
			   			System.out.println("Clicked PAN");
			   			 			  			
			   			break;
			   		}
			   	}
				
				Thread.sleep(3000);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_high_deg(driver));
				String PAN_value = PageObjectsAgency.dd_pan(driver).getAttribute("title");
				System.out.println(PAN_value);
				if(PAN_value.equals("Yes")){
					PageObjectsAgency.dd_pan_no(driver).click();
					PageObjectsAgency.dd_pan_no(driver).sendKeys(data.pan_num);
					System.out.println("Clicked in loop");
				}
							
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_pan(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_passport(driver)));
				PageObjectsAgency.dd_passport(driver).click();
				
				List<WebElement> passport = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_divpanpass']/div[1]/div/div/div/ul/li");
				System.out.println(passport.size());
				for(WebElement passport1: passport){
			   		String value = passport1.getText();
			   		if(value.equalsIgnoreCase(data.passport)){
			   			passport1.click();
			   			System.out.println("Clicked Passport");
			   			break;
			   		}
			   	}
				Thread.sleep(3000);
				
				String Passport_value = PageObjectsAgency.dd_passport(driver).getAttribute("title");
				System.out.println(Passport_value);
				if(Passport_value.equalsIgnoreCase("Yes")) {
					PageObjectsAgency.txt_passport_no(driver).click();
					PageObjectsAgency.txt_passport_no(driver).sendKeys(data.passport_num);
				}
			
				
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_NSR(driver)));
				PageObjectsAgency.txt_NSR(driver).click();
				PageObjectsAgency.txt_NSR(driver).sendKeys("776767679874");
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_NSR(driver));
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_college(driver)));
				PageObjectsAgency.txt_college(driver).click();		
				Thread.sleep(1000);
				PageObjectsAgency.txt_college(driver).sendKeys("gover");
				Thread.sleep(4000);
//				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.txt_college_input_select(driver)));
//				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_college_input_select(driver)));
				PageObjectsAgency.txt_college(driver).sendKeys(Keys.DOWN);
				PageObjectsAgency.txt_college(driver).sendKeys(Keys.ENTER);
//				
//				PageObjectsAgency.txt_college_input_select(driver).click();
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_no_org(driver)));
				PageObjectsAgency.dd_no_org(driver).click();
				
				List<WebElement> no_org = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_divOrg']/div[1]/div/div/div/ul/li");
				System.out.println(no_org.size());
				for(WebElement no_org1: no_org){
			   		String value = no_org1.getText();
			   		if(value.equalsIgnoreCase(data.prev_worked_no_org)){
			   			no_org1.click();
			   			System.out.println("Clicked Number of organization worked");
			   			break;
			   		}
			   	}
				
				Thread.sleep(3000);
				String no_of_org = PageObjectsAgency.dd_no_org(driver).getText();
				System.out.println(no_of_org);
				if(no_of_org.contains("One")){
					jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_college(driver));
					Thread.sleep(3000);
					PageObjectsAgency.dd_current_org(driver).click();
					PageObjectsAgency.dd_current_org(driver).sendKeys("gov");
					Thread.sleep(4000);
//					wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.dd_current_org_first(driver)));
//					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_current_org_first(driver)));					
					PageObjectsAgency.dd_current_org(driver).sendKeys(Keys.DOWN);
					PageObjectsAgency.dd_current_org(driver).sendKeys(Keys.ENTER);
					
//					wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.dd_current_org_list(driver)));
//					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_current_org_list(driver)));
//					PageObjectsAgency.dd_current_org_list(driver).click();
					
//					List<WebElement> current_org = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_dvCollege']/div");
//					System.out.println(current_org.size());
//					for(WebElement current_org1: current_org){
//				   		String value = current_org1.getText();
//				   		if(value.equalsIgnoreCase(data.current_org1)){
//				   			current_org1.click();
//				   			System.out.println("Clicked Number of organization worked");
//				   			break;
//				   		}
//				   	}
					
				}
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.visi_speciality(driver));
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_ind_align(driver)));
				PageObjectsAgency.dd_ind_align(driver).click();
				
				List<WebElement> ind_align = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_divcapability']/div[3]/div/div/div/ul/li");
				System.out.println(ind_align.size());
				for(WebElement ind_align1: ind_align){
			   		String value = ind_align1.getText();
			   		if(value.equalsIgnoreCase(data.industry_alignment)){
			   			ind_align1.click();
			   			System.out.println("Clicked industry Alignment");
			   			break;
			   		}
			   	}
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_comments(driver)));
				PageObjectsAgency.txt_comments(driver).sendKeys(data.comments);
				
				String primary_skill = PageObjectsAgency.dd_primary_skill(driver).getAttribute("title");
				if (primary_skill.isEmpty() || primary_skill.contains("elect")) {
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_primary_skill(driver)));
					PageObjectsAgency.dd_primary_skill(driver).click();
					
					wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.dd_primary_skill_first(driver)));
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_primary_skill_first(driver)));
					PageObjectsAgency.dd_primary_skill_first(driver).click();					
				}
				
				String Year_it_was_last_put_in_practice = PageObjectsAgency.dd_last_year_practise_primary_skill(driver).getText();
				if (Year_it_was_last_put_in_practice.isEmpty() || Year_it_was_last_put_in_practice.contains("elect")) {
					wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.dd_last_year_practise_primary_skill(driver)));
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_last_year_practise_primary_skill(driver)));
					PageObjectsAgency.dd_last_year_practise_primary_skill(driver).click();		
					
					List<WebElement> Year_it_was_last_put_in_practices = (List<WebElement>) driver.findElementsByXPath(".//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset[2]/div[23]/div[2]/div/div/ul/li");
					System.out.println(Year_it_was_last_put_in_practices.size());
					for(WebElement Year_it_was_last_put_in_practices1: Year_it_was_last_put_in_practices){
				   		String value = Year_it_was_last_put_in_practices1.getText();
				   		if(value.equalsIgnoreCase("2017")){
				   			Year_it_was_last_put_in_practices1.click();
				   			System.out.println("Clicked Year_it_was_last_put_in_practices ");
				   			break;
				   		}
				   	}						
				}
					
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_primary_skill(driver));
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_opt_skills1(driver)));
				PageObjectsAgency.dd_opt_skills1(driver).click();
				PageObjectsAgency.dd_opt_skills1(driver).sendKeys(data.opt_skill1);
				Thread.sleep(4000);
				PageObjectsAgency.dd_opt_skills1(driver).sendKeys(Keys.DOWN);
				PageObjectsAgency.dd_opt_skills1(driver).sendKeys(Keys.ENTER);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_exp_opt_skills1(driver)));
				PageObjectsAgency.txt_exp_opt_skills1(driver).clear();
				PageObjectsAgency.txt_exp_opt_skills1(driver).sendKeys("24");
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_last_used_opt_skills1(driver)));
				PageObjectsAgency.dd_last_used_opt_skills1(driver).click();
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.dd_last_used_first_opt_skills1(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_last_used_first_opt_skills1(driver)));
				PageObjectsAgency.dd_last_used_first_opt_skills1(driver).click();				
				
				if (PageObjectsAgency.chk_other_roles(driver).isSelected()) {
					System.out.println("I am willing to be considered for other roles Checkbox is already checked");					
				}
				else {
					PageObjectsAgency.chk_other_roles(driver).click();
				}
				
				if (PageObjectsAgency.chk_accurate_details(driver).isSelected()) {
					System.out.println("We agree that we have spoken to the Candidate and confirm that the details provided here accurate Checkbox is already checked");					
				}
				else {
					PageObjectsAgency.chk_accurate_details(driver).click();
				}
				
				test = extent.createTest("Clicking the submit button");
			    TakeScreenshot.captureScreenShot(driver);
			    
			    Assert.assertTrue(PageObjectsAgency.btn_save_bpo(driver).isDisplayed());
				
			    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_save_bpo(driver)));
				PageObjectsAgency.btn_save_bpo(driver).click();
				Thread.sleep(2000);
				
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.btn_yes_statement_complaince_bpo(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_yes_statement_complaince_bpo(driver)));
				PageObjectsAgency.btn_yes_statement_complaince_bpo(driver).click();				
				TakeScreenshot.captureScreenShot(driver);
				
				Thread.sleep(15000);
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_confirmation_candidate_bpo(driver)));
				TakeScreenshot.captureScreenShot(driver);
				test = extent.createTest("Candidate Creation Confirmation");
				Assert.assertTrue(PageObjectsAgency.visi_confirmation_candidate_bpo(driver).getText().contentEquals("Confirmation"));
				
				System.out.println(PageObjectsAgency.visi_cid_display_bpo(driver).getText());
				test = extent.createTest("Candidate Creation Confirmation"+PageObjectsAgency.visi_cid_display_bpo(driver).getText());	
				TakeScreenshot.captureScreenShot(driver);
				Thread.sleep(10000);			   			    
			   
				
//				test = extent.createTest("Filling Advanced Details Page");
//			    TakeScreenshot.captureScreenShot(driver);
//			    
//			    jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_college_bpo(driver));
//			    Assert.assertTrue(PageObjectsAgency.btn_save_bpo(driver).isDisplayed());
//				
//				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_save_bpo(driver)));
//				PageObjectsAgency.btn_save_bpo(driver).click();
//				Thread.sleep(2000);
//				
//				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.btn_yes_statement_complaince_bpo(driver)));
//				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_yes_statement_complaince_bpo(driver)));
//				PageObjectsAgency.btn_yes_statement_complaince_bpo(driver).click();				
//				TakeScreenshot.captureScreenShot(driver);
//				
//				Thread.sleep(15000);
//				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_confirmation_candidate_bpo(driver)));
//				TakeScreenshot.captureScreenShot(driver);
//				test = extent.createTest("Candidate Creation Confirmation");
//				Assert.assertTrue(PageObjectsAgency.visi_confirmation_candidate_bpo(driver).getText().contentEquals("Confirmation"));
//				
//				System.out.println(PageObjectsAgency.visi_cid_display_bpo(driver).getText());
//				test = extent.createTest("Candidate Creation Confirmation"+PageObjectsAgency.visi_cid_display_bpo(driver).getText());	
//				TakeScreenshot.captureScreenShot(driver);
//				Thread.sleep(10000);*/
				   			    
			   
		   }
		   
		   
		   //*********************************************************EWF/ICO JOB APPLY****************************************************************************
		   
		   else if(data.entity.contentEquals("Enterprise" )){
			   
			   Actions builder = new Actions(driver);
			   builder.moveToElement(PageObjectsAgency.lnk_search_demands(driver)).build().perform();
			   builder.moveToElement(PageObjectsAgency.lnk_refer_candidate(driver)).build().perform();
			   builder.moveToElement(PageObjectsAgency.lnk_enterprise(driver)).build().perform();
			   PageObjectsAgency.lnk_enterprise(driver).click();
					   
			   Thread.sleep(5000);
			   test = extent.createTest("Job Search Page");
		       Assert.assertTrue(driver.findElementByCssSelector("#ctl00_Main_lblHead").getText().contentEquals("Job Search"));
			   
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.lnk_job_search(driver));
			   System.out.println("Scrolled Down");
			   Thread.sleep(3000);

			   PageObjectsAgency.btn_refer(driver).click();
			   System.out.println("Clicked the Refer button");
			   wait.until(ExpectedConditions.titleContains("EWF Resume Upload"));
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.btn_choose_resume_cv(driver)));
			   PageObjectsAgency.btn_choose_resume_cv(driver).click();
			   StringSelection stringSelection = new StringSelection(prop.Word());
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
				
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_upload_resume_cv(driver)));
			   PageObjectsAgency.btn_upload_resume_cv(driver).click();
			   Thread.sleep(5000);
			   
			   wait.until(ExpectedConditions.titleContains("EWF Apply for Details"));
			  			   
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_basic_details(driver)));
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.first_prefered_loca(driver));
			   
			   Thread.sleep(1000);
			   
			   PageObjectsAgency.txt_first_name(driver).click();
			   PageObjectsAgency.txt_first_name(driver).sendKeys(data.firstname);
			   
			   PageObjectsAgency.txt_middle_name(driver).click();
			   PageObjectsAgency.txt_middle_name(driver).sendKeys(data.middlename);
			   
			   PageObjectsAgency.txt_last_name(driver).click();
			   PageObjectsAgency.txt_last_name(driver).sendKeys(data.lastname);
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_middle_name(driver));
			   
			   PageObjectsAgency.dd_gender(driver).click();
			   Thread.sleep(1000);
			   if(data.gender.contains("Male")){
				   PageObjectsAgency.dd_gender_male(driver).click(); 
			   }
			   else{
				   PageObjectsAgency.dd_gender_female(driver).click();
			   }
	   
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_last_name(driver));
			   	PageObjectsAgency.btn_dob(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob1(driver)));
			   	PageObjectsAgency.btn_dob1(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob2(driver)));
			   	PageObjectsAgency.btn_dob2(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob3(driver)));
			   	PageObjectsAgency.btn_dob3(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob4(driver)));
			   	PageObjectsAgency.btn_dob4(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob5(driver)));
			   	PageObjectsAgency.btn_dob5(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob6(driver)));
			   	PageObjectsAgency.btn_dob6(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob7(driver)));
			   	PageObjectsAgency.btn_dob7(driver).click();
			   	
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_gender(driver));
			   	PageObjectsAgency.lnk_email(driver).click();
			   	PageObjectsAgency.lnk_email(driver).sendKeys(data.email);
			   	
			   	PageObjectsAgency.dd_prev_acc(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_prev_acc_yes(driver)));
			   	PageObjectsAgency.dd_prev_acc_yes(driver).click();
			   	
			   	PageObjectsAgency.txt_add_corres(driver).click();
			   	PageObjectsAgency.txt_add_corres(driver).sendKeys(data.address);
			   	
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_prev_acc(driver));
			   	try {
					PageObjectsAgency.txt_pincode(driver).click();
					PageObjectsAgency.txt_pincode(driver).sendKeys(data.pincode);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Pin code is not present");
				}
			   	
			   	PageObjectsAgency.txt_resi_no1(driver).click();
			   	PageObjectsAgency.txt_resi_no1(driver).sendKeys(data.resi_num_city_code);
			   	
			   	PageObjectsAgency.txt_resi_no2(driver).click();
			   	PageObjectsAgency.txt_resi_no2(driver).sendKeys(data.resi_num_area_code);
			   	
			   	PageObjectsAgency.txt_resi_no3(driver).click();
			   	PageObjectsAgency.txt_resi_no3(driver).sendKeys(data.resi_num_landline);
			   	
			   	PageObjectsAgency.txt_mobile_no(driver).click();
			   	PageObjectsAgency.txt_mobile_no(driver).sendKeys(data.mobile_num);
			   	
			   	test = extent.createTest("Filling Basic Details Page");
			    TakeScreenshot.captureScreenShot(driver);
			    
			    Assert.assertTrue(PageObjectsAgency.btn_next(driver).isDisplayed());
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_next(driver)));
			   	PageObjectsAgency.btn_next(driver).click();
			   	
			   	Thread.sleep(5000);
			   	
			   	wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_job_title(driver)));
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_gender_ent(driver));
			   	
			   	Thread.sleep(2000);
			   	
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_marital_status_ent(driver)));
			   	PageObjectsAgency.dd_marital_status_ent(driver).click();
			   	
			   	List<WebElement> marital_status = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_divMaritalStatus']/div/div/div/div/ul/li");
				System.out.println(marital_status.size());
				for(WebElement marital_status1: marital_status){
			   		String value = marital_status1.getText();
			   		if(value.equalsIgnoreCase(data.marital_status)){
			   			marital_status1.click();
			   			System.out.println("Clicked Marital Status");
			   			break;
			   		}
			   	}
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_email_id(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_alt_email_id(driver)));
				PageObjectsAgency.txt_alt_email_id(driver).sendKeys(data.alt_email_id);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_prev_acc(driver));
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_nationality_ent(driver)));
				PageObjectsAgency.dd_nationality_ent(driver).click();
				PageObjectsAgency.dd_nationality_ent(driver).sendKeys(data.nationality_ent_key);
				Thread.sleep(3000);
				driver.findElementByPartialLinkText(data.nationality_ent).click();
				Thread.sleep(3000);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_citizenship_ent(driver)));
				Actions actions = new Actions(driver);
				actions.moveToElement(PageObjectsAgency.dd_citizenship_ent(driver));
				actions.click();
				actions.sendKeys("I");
				actions.build().perform();
				Thread.sleep(3000);
				driver.findElementByPartialLinkText(data.nationality_ent).click();
				Thread.sleep(3000);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_prev_acc(driver));								
				Thread.sleep(5000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_state_ent(driver)));
				PageObjectsAgency.dd_state_ent(driver).click();				
				PageObjectsAgency.dd_state_ent(driver).sendKeys("T");
				Thread.sleep(3000);
				driver.findElementByPartialLinkText(data.state).click();
				Thread.sleep(3000);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_country_ent(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_city_ent(driver)));
				PageObjectsAgency.dd_city_ent(driver).click();
				
				List<WebElement> city = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[20]/div/div/div/ul/li/a");
				System.out.println(city.size());
				for(WebElement city1: city){
			   		String value = city1.getText();
			   		if(value.equalsIgnoreCase(data.city)){
			   			Thread.sleep(2000);
			   			city1.click();
			   			System.out.println("Clicked City");
			   			break;
			   		}
			   	}
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_total_exp_ent(driver)));
				PageObjectsAgency.dd_total_exp_ent(driver).click();
				Thread.sleep(3000);
				driver.findElementByLinkText(data.total_exp_ent).click();
								
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_rel_exp_months_ent(driver)));
				PageObjectsAgency.txt_rel_exp_months_ent(driver).clear();
				PageObjectsAgency.txt_rel_exp_months_ent(driver).sendKeys(data.rel_exp_months_ent);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_notice_period_ent(driver)));
				PageObjectsAgency.dd_notice_period_ent(driver).click();
				List<WebElement> notice_period = (List<WebElement>) driver.findElementsByXPath("//*[@id='ctl00_Main_divOthrDA']/div[2]/div/div/div/ul/li");
				System.out.println(notice_period.size());
				for(WebElement notice_period1: notice_period){
			   		String value = notice_period1.getText();
			   		if(value.equalsIgnoreCase("0-15")){
			   			notice_period1.click();
			   			System.out.println("Clicked notice period");
			   			break;
			   		}
			   	}
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_current_salary_ent(driver)));
				PageObjectsAgency.txt_current_salary_ent(driver).clear();
				PageObjectsAgency.txt_current_salary_ent(driver).sendKeys(data.ctc);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_expected_salary_ent(driver)));
				PageObjectsAgency.txt_expected_salary_ent(driver).clear();
				PageObjectsAgency.txt_expected_salary_ent(driver).sendKeys(data.ctc_expected);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_total_exp_ent(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_manage_level_ent(driver)));
				PageObjectsAgency.dd_manage_level_ent(driver).click();
				
				List<WebElement> manage_level = (List<WebElement>) driver.findElementsByXPath("//*[@id='ctl00_Main_divOthrDA']/div[5]/div/div/div/ul/li");
				System.out.println(manage_level.size());
				for(WebElement manage_level1: manage_level){
			   		String value = manage_level1.getText();
			   		if(value.equalsIgnoreCase(data.management_level)){
			   			manage_level1.click();
			   			System.out.println("Clicked Management Level");
			   			break;
			   		}
			   	}
								
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_rel_exp_months_ent(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.img_search_current_org_ent(driver)));
				PageObjectsAgency.img_search_current_org_ent(driver).click();
				
				String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
				String subWindowHandler = null;

				Set<String> handles = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext()){
				    subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler); // switch to popup window

				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_search_box(driver)));
				PageObjectsAgency.txt_search_box(driver).clear();
				PageObjectsAgency.txt_search_box(driver).sendKeys(data.current_org_ent);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_search(driver)));
				PageObjectsAgency.btn_search(driver).click();
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_search_results(driver)));
				PageObjectsAgency.lnk_search_results(driver).click();
				
				driver.switchTo().window(parentWindowHandler);  // switch back to parent window
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.img_search_high_edu_ent(driver)));
				PageObjectsAgency.img_search_high_edu_ent(driver).click();
				
				String parentWindowHandler1 = driver.getWindowHandle(); // Store your parent window
				String subWindowHandler1 = null;

				Set<String> handles1 = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator1 = handles1.iterator();
				while (iterator1.hasNext()){
				    subWindowHandler1 = iterator1.next();
				}
				driver.switchTo().window(subWindowHandler1); // switch to popup window

				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_search_box_high(driver)));
				PageObjectsAgency.txt_search_box_high(driver).clear();
				PageObjectsAgency.txt_search_box_high(driver).sendKeys(data.higher_edu_ent);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_search_high(driver)));
				PageObjectsAgency.btn_search_high(driver).click();
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_search_results_high(driver)));
				PageObjectsAgency.lnk_search_results_high(driver).click();
				
				driver.switchTo().window(parentWindowHandler1);  // switch back to parent window
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.img_search_high_edu_ent(driver));
							
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.dd_pan_num(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_pan_num(driver)));
				PageObjectsAgency.dd_pan_num(driver).click();
								
				List<WebElement> pan = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div[1]/section/fieldset/div[28]/div/div/div/ul/li");
				System.out.println(pan.size());
				for(WebElement pan1: pan){
			   		String value = pan1.getText();
			   		if(value.equalsIgnoreCase(data.pan)){
			   			pan1.click();
			   			System.out.println("Clicked pan");
			   			wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_pan_num(driver)));
						PageObjectsAgency.txt_pan_num(driver).clear();
						PageObjectsAgency.txt_pan_num(driver).sendKeys(data.pan_num);
						
			   			break;
			   		}
			   	}
								
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_passport_num(driver)));
				PageObjectsAgency.dd_passport_num(driver).click();
				
				List<WebElement> passport = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div[1]/section/fieldset/div[30]/div/div/div/ul/li");
				System.out.println(passport.size());
				for(WebElement passport1: passport){
			   		String value = passport1.getText();
			   		if(value.equalsIgnoreCase(data.passport)){
			   			passport1.click();
			   			System.out.println("Clicked passport");
			   			break;
			   		}
			   	}
				
				if (data.passport.contains("Yes")) {
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_passport_num(driver)));
					PageObjectsAgency.txt_passport_num(driver).clear();
					PageObjectsAgency.txt_passport_num(driver).sendKeys(data.passport_num);
					
				}
				
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_aadhar_ent(driver)));
				PageObjectsAgency.dd_aadhar_ent(driver).click();
				
				List<WebElement> aadhar = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div[1]/section/fieldset/div[32]/div/div/div/ul/li");
				System.out.println(aadhar.size());
				for(WebElement aadhar1: aadhar){
			   		String value = aadhar1.getText();
			   		if(value.equalsIgnoreCase("Yes")){
			   			aadhar1.click();
			   			System.out.println("Clicked aadhar");
			   			wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_aadhar_ent(driver)));
						PageObjectsAgency.txt_aadhar_ent(driver).clear();
						PageObjectsAgency.txt_aadhar_ent(driver).sendKeys("846545645645");
						
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_name_aadhar_ent(driver)));
						PageObjectsAgency.txt_name_aadhar_ent(driver).clear();
						PageObjectsAgency.txt_name_aadhar_ent(driver).sendKeys(data.firstname);						
						
			   			break;
			   		}
			   	}
																
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_aadhar_ent(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_current_loca(driver)));
				PageObjectsAgency.dd_current_loca(driver).click();
								
				List<WebElement> current_location = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_dvloc']/div[2]/div/div/div/ul/li");
				System.out.println(current_location.size());
				for(WebElement current_location1: current_location){
			   		String value = current_location1.getText();
			   		if(value.equalsIgnoreCase(data.current_location_ent)){
			   			current_location1.click();
			   			System.out.println("Clicked Current Location");
			   			break;
			   		}
			   	}
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_channel_ent(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_comments_ent(driver)));
				PageObjectsAgency.txt_comments_ent(driver).clear();
				PageObjectsAgency.txt_comments_ent(driver).sendKeys(data.comments_ent);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.chk_other_talent_seg_ent(driver)));
				PageObjectsAgency.chk_other_talent_seg_ent(driver).click();
						    
			    Assert.assertTrue(PageObjectsAgency.btn_submit(driver).isDisplayed());
			
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_submit(driver)));
				PageObjectsAgency.btn_submit(driver).click();
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.btn_yes_statement_complaince_bpo(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_yes_statement_complaince_bpo(driver)));
				PageObjectsAgency.btn_yes_statement_complaince_bpo(driver).click();				
				TakeScreenshot.captureScreenShot(driver);
								
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_confirmation_candidate_icf(driver)));
			    test = extent.createTest("Candidate Creation Confirmation");
				Assert.assertTrue(PageObjectsAgency.visi_confirmation_candidate_icf(driver).getText().contentEquals("Confirmation"));
				
				TakeScreenshot.captureScreenShot(driver);
				System.out.println(PageObjectsAgency.visi_cid_display_icf(driver).getText());
				Thread.sleep(10000);
				test.log(Status.INFO,"Created Candidate ID is : "+ PageObjectsAgency.visi_cid_display_icf(driver).getText() );
				
		   }
		    
		   else if(data.entity.contentEquals("Consulting")){
			   
			   Actions builder = new Actions(driver);
			   builder.moveToElement(PageObjectsAgency.lnk_search_demands(driver)).build().perform();
			   builder.moveToElement(PageObjectsAgency.lnk_refer_candidate(driver)).build().perform();
			   builder.moveToElement(PageObjectsAgency.lnk_enterprise(driver)).build().perform();
			   PageObjectsAgency.lnk_enterprise(driver).click();
					   
			   Thread.sleep(5000);
			   test = extent.createTest("Job Search Page");
		       Assert.assertTrue(driver.findElementByCssSelector("#ctl00_Main_lblHead").getText().contentEquals("Job Search"));
			   
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.lnk_job_search(driver));
			   System.out.println("Scrolled Down");
			   Thread.sleep(3000);

			   PageObjectsAgency.btn_refer(driver).click();
			   System.out.println("Clicked the Refer button");
			   wait.until(ExpectedConditions.titleContains("EWF Resume Upload"));
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.btn_choose_resume_cv(driver)));
			   PageObjectsAgency.btn_choose_resume_cv(driver).click();
			   StringSelection stringSelection = new StringSelection(prop.Word());
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
				
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_upload_resume_cv(driver)));
			   PageObjectsAgency.btn_upload_resume_cv(driver).click();
			   Thread.sleep(5000);
			   
			   wait.until(ExpectedConditions.titleContains("EWF Apply for Details"));
			  			   
			   wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_basic_details(driver)));
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.first_prefered_loca(driver));
			   
			   Thread.sleep(1000);
			   
			   PageObjectsAgency.txt_first_name(driver).click();
			   PageObjectsAgency.txt_first_name(driver).sendKeys(data.firstname);
			   
			   PageObjectsAgency.txt_middle_name(driver).click();
			   PageObjectsAgency.txt_middle_name(driver).sendKeys(data.middlename);
			   
			   PageObjectsAgency.txt_last_name(driver).click();
			   PageObjectsAgency.txt_last_name(driver).sendKeys(data.lastname);
			   jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_middle_name(driver));
			   
			   PageObjectsAgency.dd_gender(driver).click();
			   Thread.sleep(1000);
			   if(data.gender.contains("Male")){
				   PageObjectsAgency.dd_gender_male(driver).click(); 
			   }
			   else{
				   PageObjectsAgency.dd_gender_female(driver).click();
			   }
	   
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_last_name(driver));
			   	PageObjectsAgency.btn_dob(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob1(driver)));
			   	PageObjectsAgency.btn_dob1(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob2(driver)));
			   	PageObjectsAgency.btn_dob2(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob3(driver)));
			   	PageObjectsAgency.btn_dob3(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob4(driver)));
			   	PageObjectsAgency.btn_dob4(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob5(driver)));
			   	PageObjectsAgency.btn_dob5(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob6(driver)));
			   	PageObjectsAgency.btn_dob6(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_dob7(driver)));
			   	PageObjectsAgency.btn_dob7(driver).click();
			   	
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_gender(driver));
			   	PageObjectsAgency.lnk_email(driver).click();
			   	PageObjectsAgency.lnk_email(driver).sendKeys(data.email);
			   	
			   	PageObjectsAgency.dd_prev_acc(driver).click();
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_prev_acc_yes(driver)));
			   	PageObjectsAgency.dd_prev_acc_yes(driver).click();
			   	
			   	PageObjectsAgency.txt_add_corres(driver).click();
			   	PageObjectsAgency.txt_add_corres(driver).sendKeys(data.address);
			   	
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_prev_acc(driver));
			   	try {
					PageObjectsAgency.txt_pincode(driver).click();
					PageObjectsAgency.txt_pincode(driver).sendKeys(data.pincode);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Pin code is not present");
				}
			   	
			   	PageObjectsAgency.txt_resi_no1(driver).click();
			   	PageObjectsAgency.txt_resi_no1(driver).sendKeys(data.resi_num_city_code);
			   	
			   	PageObjectsAgency.txt_resi_no2(driver).click();
			   	PageObjectsAgency.txt_resi_no2(driver).sendKeys(data.resi_num_area_code);
			   	
			   	PageObjectsAgency.txt_resi_no3(driver).click();
			   	PageObjectsAgency.txt_resi_no3(driver).sendKeys(data.resi_num_landline);
			   	
			   	PageObjectsAgency.txt_mobile_no(driver).click();
			   	PageObjectsAgency.txt_mobile_no(driver).sendKeys(data.mobile_num);
			   	
			   	test = extent.createTest("Filling Basic Details Page");
			    TakeScreenshot.captureScreenShot(driver);
			    
			    Assert.assertTrue(PageObjectsAgency.btn_next(driver).isDisplayed());
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_next(driver)));
			   	PageObjectsAgency.btn_next(driver).click();
			   	
			   	Thread.sleep(5000);
			   	
			   	wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_job_title(driver)));
			   	jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_gender_ent(driver));
			   	
			   	Thread.sleep(2000);
			   	
			   	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_marital_status_ent(driver)));
			   	PageObjectsAgency.dd_marital_status_ent(driver).click();
			   	
			   	List<WebElement> marital_status = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_divMaritalStatus']/div/div/div/div/ul/li");
				System.out.println(marital_status.size());
				for(WebElement marital_status1: marital_status){
			   		String value = marital_status1.getText();
			   		if(value.equalsIgnoreCase(data.marital_status)){
			   			marital_status1.click();
			   			System.out.println("Clicked Marital Status");
			   			break;
			   		}
			   	}
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_email_id(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_alt_email_id(driver)));
				PageObjectsAgency.txt_alt_email_id(driver).sendKeys(data.alt_email_id);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_prev_acc(driver));
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_nationality_ent(driver)));
				PageObjectsAgency.dd_nationality_ent(driver).click();
				PageObjectsAgency.dd_nationality_ent(driver).sendKeys(data.nationality_ent_key);
				Thread.sleep(3000);
				driver.findElementByPartialLinkText(data.nationality_ent).click();
				Thread.sleep(3000);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_citizenship_ent(driver)));
				Actions actions = new Actions(driver);
				actions.moveToElement(PageObjectsAgency.dd_citizenship_ent(driver));
				actions.click();
				actions.sendKeys("I");
				actions.build().perform();
				Thread.sleep(3000);
				driver.findElementByPartialLinkText(data.nationality_ent).click();
				Thread.sleep(3000);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_prev_acc(driver));								
				Thread.sleep(5000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_state_ent(driver)));
				PageObjectsAgency.dd_state_ent(driver).click();				
				PageObjectsAgency.dd_state_ent(driver).sendKeys("T");
				Thread.sleep(3000);
				driver.findElementByPartialLinkText(data.state).click();
				Thread.sleep(3000);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_country_ent(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_city_ent(driver)));
				PageObjectsAgency.dd_city_ent(driver).click();
				
				List<WebElement> city = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div/section/fieldset/div[20]/div/div/div/ul/li/a");
				System.out.println(city.size());
				for(WebElement city1: city){
			   		String value = city1.getText();
			   		if(value.equalsIgnoreCase(data.city)){
			   			Thread.sleep(2000);
			   			city1.click();
			   			System.out.println("Clicked City");
			   			break;
			   		}
			   	}
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_total_exp_ent(driver)));
				PageObjectsAgency.dd_total_exp_ent(driver).click();
				Thread.sleep(3000);
				driver.findElementByLinkText(data.total_exp_ent).click();
								
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_rel_exp_months_ent(driver)));
				PageObjectsAgency.txt_rel_exp_months_ent(driver).clear();
				PageObjectsAgency.txt_rel_exp_months_ent(driver).sendKeys(data.rel_exp_months_ent);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_notice_period_ent(driver)));
				PageObjectsAgency.dd_notice_period_ent(driver).click();
				List<WebElement> notice_period = (List<WebElement>) driver.findElementsByXPath("//*[@id='ctl00_Main_divOthrDA']/div[2]/div/div/div/ul/li");
				System.out.println(notice_period.size());
				for(WebElement notice_period1: notice_period){
			   		String value = notice_period1.getText();
			   		if(value.equalsIgnoreCase("0-15")){
			   			notice_period1.click();
			   			System.out.println("Clicked notice period");
			   			break;
			   		}
			   	}
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_current_salary_ent(driver)));
				PageObjectsAgency.txt_current_salary_ent(driver).clear();
				PageObjectsAgency.txt_current_salary_ent(driver).sendKeys(data.ctc);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_expected_salary_ent(driver)));
				PageObjectsAgency.txt_expected_salary_ent(driver).clear();
				PageObjectsAgency.txt_expected_salary_ent(driver).sendKeys(data.ctc_expected);
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_total_exp_ent(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_manage_level_ent(driver)));
				PageObjectsAgency.dd_manage_level_ent(driver).click();
				
				List<WebElement> manage_level = (List<WebElement>) driver.findElementsByXPath("//*[@id='ctl00_Main_divOthrDA']/div[5]/div/div/div/ul/li");
				System.out.println(manage_level.size());
				for(WebElement manage_level1: manage_level){
			   		String value = manage_level1.getText();
			   		if(value.equalsIgnoreCase(data.management_level)){
			   			manage_level1.click();
			   			System.out.println("Clicked Management Level");
			   			break;
			   		}
			   	}
								
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_rel_exp_months_ent(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.img_search_current_org_ent(driver)));
				PageObjectsAgency.img_search_current_org_ent(driver).click();
				
				String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
				String subWindowHandler = null;

				Set<String> handles = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext()){
				    subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler); // switch to popup window

				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_search_box(driver)));
				PageObjectsAgency.txt_search_box(driver).clear();
				PageObjectsAgency.txt_search_box(driver).sendKeys(data.current_org_ent);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_search(driver)));
				PageObjectsAgency.btn_search(driver).click();
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_search_results(driver)));
				PageObjectsAgency.lnk_search_results(driver).click();
				
				driver.switchTo().window(parentWindowHandler);  // switch back to parent window
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.img_search_high_edu_ent(driver)));
				PageObjectsAgency.img_search_high_edu_ent(driver).click();
				
				String parentWindowHandler1 = driver.getWindowHandle(); // Store your parent window
				String subWindowHandler1 = null;

				Set<String> handles1 = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator1 = handles1.iterator();
				while (iterator1.hasNext()){
				    subWindowHandler1 = iterator1.next();
				}
				driver.switchTo().window(subWindowHandler1); // switch to popup window

				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_search_box_high(driver)));
				PageObjectsAgency.txt_search_box_high(driver).clear();
				PageObjectsAgency.txt_search_box_high(driver).sendKeys(data.higher_edu_ent);
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_search_high(driver)));
				PageObjectsAgency.btn_search_high(driver).click();
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_search_results_high(driver)));
				PageObjectsAgency.lnk_search_results_high(driver).click();
				
				driver.switchTo().window(parentWindowHandler1);  // switch back to parent window
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.img_search_high_edu_ent(driver));
							
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.dd_pan_num(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_pan_num(driver)));
				PageObjectsAgency.dd_pan_num(driver).click();
								
				List<WebElement> pan = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div[1]/section/fieldset/div[28]/div/div/div/ul/li");
				System.out.println(pan.size());
				for(WebElement pan1: pan){
			   		String value = pan1.getText();
			   		if(value.equalsIgnoreCase(data.pan)){
			   			pan1.click();
			   			System.out.println("Clicked pan");
			   			wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_pan_num(driver)));
						PageObjectsAgency.txt_pan_num(driver).clear();
						PageObjectsAgency.txt_pan_num(driver).sendKeys(data.pan_num);
						
			   			break;
			   		}
			   	}
								
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_passport_num(driver)));
				PageObjectsAgency.dd_passport_num(driver).click();
				
				List<WebElement> passport = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div[1]/section/fieldset/div[30]/div/div/div/ul/li");
				System.out.println(passport.size());
				for(WebElement passport1: passport){
			   		String value = passport1.getText();
			   		if(value.equalsIgnoreCase(data.passport)){
			   			passport1.click();
			   			System.out.println("Clicked passport");
			   			break;
			   		}
			   	}
				
				if (data.passport.contains("Yes")) {
					wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_passport_num(driver)));
					PageObjectsAgency.txt_passport_num(driver).clear();
					PageObjectsAgency.txt_passport_num(driver).sendKeys(data.passport_num);
					
				}
				
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_aadhar_ent(driver)));
				PageObjectsAgency.dd_aadhar_ent(driver).click();
				
				List<WebElement> aadhar = (List<WebElement>) driver.findElementsByXPath("//*[@id='block-accenturecareers']/div/div/div/div[1]/section/fieldset/div[32]/div/div/div/ul/li");
				System.out.println(aadhar.size());
				for(WebElement aadhar1: aadhar){
			   		String value = aadhar1.getText();
			   		if(value.equalsIgnoreCase("Yes")){
			   			aadhar1.click();
			   			System.out.println("Clicked aadhar");
			   			wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_aadhar_ent(driver)));
						PageObjectsAgency.txt_aadhar_ent(driver).clear();
						PageObjectsAgency.txt_aadhar_ent(driver).sendKeys("846545645645");
						
						wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_name_aadhar_ent(driver)));
						PageObjectsAgency.txt_name_aadhar_ent(driver).clear();
						PageObjectsAgency.txt_name_aadhar_ent(driver).sendKeys(data.firstname);						
						
			   			break;
			   		}
			   	}
																
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_aadhar_ent(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_current_loca(driver)));
				PageObjectsAgency.dd_current_loca(driver).click();
								
				List<WebElement> current_location = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_dvloc']/div[2]/div/div/div/ul/li");
				System.out.println(current_location.size());
				for(WebElement current_location1: current_location){
			   		String value = current_location1.getText();
			   		if(value.equalsIgnoreCase(data.current_location_ent)){
			   			current_location1.click();
			   			System.out.println("Clicked Current Location");
			   			break;
			   		}
			   	}
				
				jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.scroll_channel_ent(driver));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_comments_ent(driver)));
				PageObjectsAgency.txt_comments_ent(driver).clear();
				PageObjectsAgency.txt_comments_ent(driver).sendKeys(data.comments_ent);
				
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.chk_other_talent_seg_ent(driver)));
				PageObjectsAgency.chk_other_talent_seg_ent(driver).click();
						    
			    Assert.assertTrue(PageObjectsAgency.btn_submit(driver).isDisplayed());
			
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_submit(driver)));
				PageObjectsAgency.btn_submit(driver).click();
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.btn_yes_statement_complaince_bpo(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_yes_statement_complaince_bpo(driver)));
				PageObjectsAgency.btn_yes_statement_complaince_bpo(driver).click();				
				TakeScreenshot.captureScreenShot(driver);
								
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_confirmation_candidate_icf(driver)));
			    test = extent.createTest("Candidate Creation Confirmation");
				Assert.assertTrue(PageObjectsAgency.visi_confirmation_candidate_icf(driver).getText().contentEquals("Confirmation"));
				
				TakeScreenshot.captureScreenShot(driver);
				System.out.println(PageObjectsAgency.visi_cid_display_icf(driver).getText());
				Thread.sleep(10000);
				test.log(Status.INFO,"Created Candidate ID is : "+ PageObjectsAgency.visi_cid_display_icf(driver).getText() );
				
			   	
		   }
  }
	  
	  @AfterTest
	  	public void terminatetest() {
//		  wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_logout(driver)));
//		  test.log(Status.INFO, "Clicking the Logout Button");
//		  PageObjectsAgency.lnk_logout(driver).click();
//	      driver.close();
	  	}
}
