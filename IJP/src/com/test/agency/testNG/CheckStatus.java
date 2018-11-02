package com.test.agency.testNG;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
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
import com.utilities.ExcelTestDataAgencyCheckCandStatus;
import com.utilities.ExcelTestDataAgencyJobApply;
import com.utilities.ExcelTestDataEAF;
import com.utilities.ExtendReports;
import com.utilities.ReadPropFile;
import com.utilities.TakeScreenshot;

public class CheckStatus extends ExtendReports {
                static     ConfigReader prop = new  ConfigReader();
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
                                                String scrFolder = System.getProperty("user.dir")+"\\Screenshots\\CheckStatus_Agency\\"+ new SimpleDateFormat("dd_MM_yyyy_HHmmss").format(Calendar.getInstance().getTime()).toString();
                                    new File(scrFolder).mkdir();
                                    System.setProperty("scr.folder", scrFolder);
                  }
                                
                  @Test
                  public void checkstatus() throws Exception {
                                  
                                                String title=driver.getTitle();                        
                                                test = extent.createTest("IJP Home Page");
                        Assert.assertTrue(title.contains("Accenture Recruitment Portal- India"));      
                        if (PageObjectsEAF.btn_close_cookies(driver).isDisplayed()) {
                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_close_cookies(driver)));
                                                                PageObjectsEAF.btn_close_cookies(driver).click();
                                                }
                                                
                                  ExcelTestDataEAF data1 = new ExcelTestDataEAF();
                                  ExcelTestDataAgencyJobApply data2 = new ExcelTestDataAgencyJobApply();
                                  ExcelTestDataAgencyCheckCandStatus data = new ExcelTestDataAgencyCheckCandStatus();
                                                    
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
                        
                        if(data.entity.contentEquals("Solutions")){
                                                   
                                                   Actions builder = new Actions(driver);
                                                   builder.moveToElement(PageObjectsAgency.lnk_chk_status(driver)).build().perform();
                                                   builder.moveToElement(PageObjectsAgency.lnk_solutions_CS(driver)).build().perform();
                                                   PageObjectsAgency.lnk_solutions_CS(driver).click();
                                                               
                                                   wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_sol_srch_cand_stat(driver)));
                                                   test = extent.createTest("Displaying Search Candidate Page");
                                                   Assert.assertTrue(PageObjectsAgency.visi_sol_srch_cand_stat(driver).getText().contains("Search Candidate Status"));
                                                                                                   
                                                   if(data.firstname.isEmpty()){
                                                                   System.out.println("No first name was inputed in excel sheet");
                                                   }
                                                   else{
                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_fname_CS(driver)));
                                                                   PageObjectsAgency.txt_fname_CS(driver).sendKeys(data.firstname);
                                                                   test.log(Status.INFO,"Entered First Name");
                                                   }
                                                                                                  
                                                   if(data.lastname.isEmpty()){
                                                                   System.out.println("No last name was inputed in excel sheet");                                                  
                                                   }
                                                   else{
                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_lname_CS(driver)));
                                                                   PageObjectsAgency.txt_lname_CS(driver).sendKeys(data.lastname);
                                                                   test.log(Status.INFO,"Entered the last name");
                                                   }
                                                   
                                                   
                                                   if(data.candEmailID.isEmpty()){
                                                                   System.out.println("No last name was inputed in excel sheet");                               
                                                   }
                                                   else{
                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_cand_emailid_CS(driver)));
                                                                   PageObjectsAgency.txt_cand_emailid_CS(driver).sendKeys(data.candEmailID);
                                                                   test.log(Status.INFO,"Entered the email ID");
                                                   }
                                                  
                                                  
                                                   if(data.CID.isEmpty()){
                                                                   System.out.println("No CID was inputed in excel sheet");
                                                   }
                                                   else{
                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_cid_CS(driver)));
                                                                   PageObjectsAgency.txt_cid_CS(driver).sendKeys(data.CID);
                                                                   test.log(Status.INFO,"Entered the CID");
                                                                   
                                                   }
                                                   
                                                   if(data.refFromDate.isEmpty()){
                                                                   System.out.println("No Reference From Date was inputed in excel sheet");
                                                   }
                                                   else{
                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_cal_ref_frm_CS(driver)));
                                                                   PageObjectsAgency.btn_cal_ref_frm_CS(driver).click();
                                                                   PageObjectsAgency.btn_cal_ref_frm_CS(driver).sendKeys(data.refFromDate);
                                                                   test.log(Status.INFO,"Entered the Reference From Date");

                                                                                }
                                                  
                                                   if(data.refToDate.isEmpty()){
                                                                   System.out.println("No Reference To Date was inputed in excel sheet");
                                                   }
                                                   else{
                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_cal_ref_to_CS(driver)));
                                                                   PageObjectsAgency.btn_cal_ref_to_CS(driver).click();
                                                                   PageObjectsAgency.btn_cal_ref_to_CS(driver).sendKeys(data.refToDate);
                                                                   test.log(Status.INFO,"Entered the Reference To Date");
                                                   }
                                        
                                        
                                        if(data.workforce.isEmpty()){
                                               System.out.println("No workforce was inputed in excel sheet");
                                        }
                                                                
                                        else{
                                                        wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_workforce_CS(driver)));
                                                                                PageObjectsAgency.dd_workforce_CS(driver).click();
                                                                                
                                                                                List<WebElement> workforce = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_ddlWorkforce']/option");
                                                                                System.out.println(workforce.size());
                                                                                for(WebElement workforce1: workforce){
                                                                                                String value = workforce1.getText();
                                                                                                if(value.equalsIgnoreCase(data.workforce)){
                                                                                                                workforce1.click();
                                                                                                                System.out.println("Clicked workforce");
                                                                                                                test.log(Status.INFO,"Workforce Selected");
                                                                                                                break;
                                                                                                }
                                                                                }
                                                                                
                                        }
                                        
                                        
                                        if(data.candStatus.isEmpty()){
                                               System.out.println("No status was inputed in excel sheet");
                                        }
                                        else{
                                                        wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_status_CS(driver)));
                                                                                PageObjectsAgency.dd_status_CS(driver).click();
                                                                                
                                                                                List<WebElement> status = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_ddlStatus']/option");
                                                                                System.out.println(status.size());              
                                                                                for(WebElement status1: status){
                                                                                                String value = status1.getText();
                                                                                                if(value.equalsIgnoreCase(data.candStatus)){
                                                                                                                status1.click();
                                                                                                                System.out.println("Clicked Candidate Status");
                                                                                                                test.log(Status.INFO,"Candidate Status Selected");
                                                                                                                break;
                                                                                                }
                                                                                }
                                        }
                                                                
                                                                
                                                                if(data.speciality.isEmpty()){
                                                                                System.out.println("No speciality was inputed in excel sheet");
                                                                }
                                                                else{
                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.img_search_speciality_CS(driver)));
                                                                                PageObjectsAgency.img_search_speciality_CS(driver).click();
                                                                                String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
                                                                                String subWindowHandler = null;

                                                                                Set<String> handles = driver.getWindowHandles(); // get all window handles
                                                                                Iterator<String> iterator = handles.iterator();
                                                                                while (iterator.hasNext()){
                                                                                    subWindowHandler = iterator.next();
                                                                                }
                                                                                driver.switchTo().window(subWindowHandler); // switch to popup window
                                                                                wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.txt_search_criteria_CS(driver)));
                                                                                PageObjectsAgency.txt_search_criteria_CS(driver).clear();
                                                                                PageObjectsAgency.txt_search_criteria_CS(driver).sendKeys(data.speciality);
                                                                                if(PageObjectsAgency.chk_speciality_CS(driver).isSelected()){
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_search_skill_CS(driver)));
                                                                                                PageObjectsAgency.btn_search_skill_CS(driver).click();
                                                                                                Thread.sleep(3000);
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_srch_rslt_CS_spec(driver)));
                                                                                                PageObjectsAgency.lnk_srch_rslt_CS_spec(driver).click();
                                                                                                test.log(Status.INFO,"Selected the Speciality");
                                                                                                
                                                                                }
                                                                                
                                                                                driver.switchTo().window(parentWindowHandler);
                                                                }
                                                                
                                                                
                                                                if(data.skill.isEmpty()){
                                                                                System.out.println("No speciality was inputed in excel sheet");
                                                                }
                                                                else{
                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.img_search_skill_CS(driver)));
                                                                                PageObjectsAgency.img_search_skill_CS(driver).click();
                                                                                String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
                                                                                String subWindowHandler = null;

                                                                                Set<String> handles = driver.getWindowHandles(); // get all window handles
                                                                                Iterator<String> iterator = handles.iterator();
                                                                                while (iterator.hasNext()){
                                                                                    subWindowHandler = iterator.next();
                                                                                }
                                                                                driver.switchTo().window(subWindowHandler); // switch to popup window
                                                                                wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.txt_search_criteria_CS(driver)));
                                                                                PageObjectsAgency.txt_search_criteria_CS(driver).clear();
                                                                                PageObjectsAgency.txt_search_criteria_CS(driver).sendKeys(data.skill);
                                                                                if(PageObjectsAgency.chk_skill_CS(driver).isSelected()){
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_search_skill_CS(driver)));
                                                                                                PageObjectsAgency.btn_search_skill_CS(driver).click();
                                                                                                Thread.sleep(3000);
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_srch_rslt_CS_skill(driver)));
                                                                                                PageObjectsAgency.lnk_srch_rslt_CS_skill(driver).click();
                                                                                                test.log(Status.INFO,"Selected the Skill");
                                                                                                
                                                                                }
                                                                                
                                                                                driver.switchTo().window(parentWindowHandler);
                                                                }
                                                                
                                                                
                                                                
                                                                if(data.location.isEmpty()){
                                                                                System.out.println("No Location is selected in the dropdown");
                                                                }
                                                                else{
                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_location_CS(driver)));
                                                                                PageObjectsAgency.dd_location_CS(driver).click();
                                                                                
                                                                                List<WebElement> location = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_ddlLocation']/option");
                                                                                System.out.println(location.size());
                                                                                for(WebElement location1: location){
                                                                                                String value = location1.getText();
                                                                                                if(value.equalsIgnoreCase(data.location)){
                                                                                                                location1.click();
                                                                                                                System.out.println("Clicked Location");
                                                                                                                test.log(Status.INFO,"Entered the location");
                                                                                                                break;
                                                                                                }
                                                                                
                                                                }
                                                                }
                                                                
                                                                
//                                                            if(data.mobile_num.isEmpty()){
//                                                                            System.out.println("No Mobile Num is inputed");
//                                                            }
//                                                            else{
//                                                                            wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_mobile_no_CS(driver)));
//                                                                            PageObjectsAgency.txt_mobile_no_CS(driver).click();
//                                                                            PageObjectsAgency.txt_mobile_no_CS(driver).sendKeys(data.mobile_num);
//                                                            }
                                                                
                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_srch_CS(driver)));
                                                                PageObjectsAgency.btn_srch_CS(driver).click();
                                                                test.log(Status.INFO,"Clicked the search button");
                                                                
                                                                Thread.sleep(6000);
                                                                TakeScreenshot.captureScreenShot(driver);
                                                                                                                  
                                                    test = extent.createTest("Displaying the search results");
                                        Assert.assertTrue(PageObjectsAgency.visi_search_results_CS(driver).getText().contains("Search Results"));
                                        Thread.sleep(3000);
                                        
                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                test.log(Status.INFO,"Search Results are displayed");
                                                                                
                                                                                if(data.wannaChangeCIDDet.equals("Yes")){
                                                                                                
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_cand_id_results(driver)));
                                                                                                PageObjectsAgency.lnk_cand_id_results(driver).click();
                                                                                                
                                                                                                String parentWindowHandler1 = driver.getWindowHandle(); // Store your parent window
                                                                                                String subWindowHandler1 = null;

                                                                                                Set<String> handles1 = driver.getWindowHandles(); // get all window handles
                                                                                                Iterator<String> iterator1 = handles1.iterator();
                                                                                                while (iterator1.hasNext()){
                                                                                                    subWindowHandler1 = iterator1.next();
                                                                                                }
                                                                                                
                                                                                                driver.switchTo().window(subWindowHandler1); // switch to popup window
                                                                                                
                                                                                                                                                                
                                                                                                if(data.landline.isEmpty()){
                                                                                                                System.out.println("Change in Mobile and Landline number is not required");                                                                                 
                                                                                                }
                                                                                                else{
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_ISD_CS_CID(driver)));
                                                                                                                PageObjectsAgency.txt_ISD_CS_CID(driver).clear();
                                                                                                                PageObjectsAgency.txt_ISD_CS_CID(driver).sendKeys(data.ISD);
                                                                                                                test.log(Status.INFO,"Entered the ISD Code");
                                                                                                                
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_STD_CS_CID(driver)));
                                                                                                                PageObjectsAgency.txt_STD_CS_CID(driver).clear();
                                                                                                                PageObjectsAgency.txt_STD_CS_CID(driver).sendKeys(data.STD);
                                                                                                                test.log(Status.INFO,"Entered the STD Code");
                                                                                                                
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_Lnumber_CS_CID(driver)));
                                                                                                                PageObjectsAgency.txt_Lnumber_CS_CID(driver).clear();
                                                                                                                PageObjectsAgency.txt_Lnumber_CS_CID(driver).sendKeys(data.landline);
                                                                                                                test.log(Status.INFO,"Entered the Landline number");
                                                                                                                
                                                                                                                
                                                                                                                if(data.mobile.isEmpty()){
                                                                                                                                System.out.println("No Change required in Mobile number");
                                                                                                                }
                                                                                                                
                                                                                                                else{
                                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_mobileno_CS_CID(driver)));
                                                                                                                                PageObjectsAgency.txt_mobileno_CS_CID(driver).clear();
                                                                                                                                PageObjectsAgency.txt_mobileno_CS_CID(driver).sendKeys(data.mobile);
                                                                                                                                test.log(Status.INFO,"Entered the mobile number");
                                                                                                                }
                                                                                                                
                                                                                                            wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_new_comments_CS_CID(driver)));
                                                                                                                PageObjectsAgency.txt_new_comments_CS_CID(driver).clear();
                                                                                                                PageObjectsAgency.txt_new_comments_CS_CID(driver).sendKeys(data.newComments);
                                                                                                                test.log(Status.INFO,"Entered the new comments");
                                                                                                                
                                                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_submit_CS_CID(driver)));
                                                                                                                PageObjectsAgency.btn_submit_CS_CID(driver).click();
                                                                                                                
                                                                                                                Thread.sleep(3000);
                                                                                  
                                                                                                                test = extent.createTest("Changing the CID Details");
                                                                                                    Alert alert = driver.switchTo().alert();                                                                                                
                                                                                                                
                                                                                                                System.out.println(alert.getText());
                                                                                                                Assert.assertTrue(alert.getText().contains("OK") ||alert.getText().contains("Candidate details you have entered already exists ."));                                                                                             
                                                                                                                
                                                                                                                try {
                                                                                                                                if (alert.getText().contains("Candidate details you have entered already exists .")) {
                                                                                                                                                alert.accept();
                                                                                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                                                                                                TakeScreenshot.captureScreenShot(driver);
                                                                                                                                                wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.btn_close_CS_CID(driver)));
                                                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_close_CS_CID(driver)));
                                                                                                                                                PageObjectsAgency.btn_close_CS_CID(driver).click();
                                                                                                                                }
                                                                                                                } catch (Exception e1) {
                                                                                                                                System.out.println("Tried Once");
                                                                                                                }
                                                                                                                try {
                                                                                                                                if (alert.getText().contains("OK")) {
                                                                                                                                                alert.accept();
                                                                                                                                }
                                                                                                                } catch (Exception e1) {
                                                                                                                                System.out.println("Tried Twice");
                                                                                                                }
                                                                                                                
                                                                                                                Thread.sleep(3000);                                                                                                                                                                       
                                                                                                                
                                                                                                                                try {
                                                                                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_close_CS_CID(driver)));
                                                                                                                                                PageObjectsAgency.btn_close_CS_CID(driver).click();
                                                                                                                                } catch (Exception e) {
                                                                                                                                                System.out.println("Data is submitted");
                                                                                                                                                
                                                                                                                                }
                                                                                                                
                                                                                                                                
                                                                                                                                                                                                                
                                                                                                }                                                              
                                                                                                
                                                                                                driver.switchTo().window(parentWindowHandler1); //switch to parent window                                                                 
                                                                                                
                                                                                }
                                                                                
                                                                                try {
                                                                                                
                                                                                                if(data.uploadResume.equals("Yes")){
                                                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                                                                Thread.sleep(3000);
                                                                                                                jse.executeScript("window.scrollBy(1000,0)", "");
                                                                                                                Thread.sleep(3000);
                                                                                                                
                                                                                                             wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_resume_upload_results(driver)));
                                                                                                                PageObjectsAgency.lnk_resume_upload_results(driver).click();
                                                                                                                Thread.sleep(5000);
                                                                                                                Runtime.getRuntime().exec(prop.Word_Path());
                                                                                                                Thread.sleep(3000);
                                                                                                                test.log(Status.INFO,"Uploaded the resume");
                                                                                                }
                                                                                } catch (Exception e) {
                                                                                                System.out.println("Upload Resume Hyperlink is disabled");
                                                                                }
                                                                                
                                                                                
                                                                                if(data.viewIntDetails.equals("Yes")){
                                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                                                Thread.sleep(3000);
                                                                                                jse.executeScript("window.scrollBy(1500,0)", "");
                                                                                                Thread.sleep(3000);
                                                                   
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_int_status_results(driver)));
                                                                                                PageObjectsAgency.lnk_int_status_results(driver).click();
                                                                                                
                                                                                                String parentWindowHandler2 = driver.getWindowHandle(); // Store your parent window
                                                                                                String subWindowHandler2 = null;

                                                                                                Set<String> handles2 = driver.getWindowHandles(); // get all window handles
                                                                                                Iterator<String> iterator2 = handles2.iterator();
                                                                                                while (iterator2.hasNext()){
                                                                                                    subWindowHandler2 = iterator2.next();
                                                                                                }
                                                                                                
                                                                                                driver.switchTo().window(subWindowHandler2); // switch to popup window
                                                                                                
                                                                                                Thread.sleep(6000);
                                                                                                                                                                                                
                                                                                    test = extent.createTest("View Interview Details");
                                                                        Assert.assertTrue(PageObjectsAgency.visi_int_status_results(driver).getText().equals("Interview Status"));
                                                                        wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_close_CS_Int_stat(driver)));
                                                                                                TakeScreenshot.captureScreenShot(driver);
                                                                                                PageObjectsAgency.btn_close_CS_Int_stat(driver).click();                                                                                             
                                                                                                
                                                                                                driver.switchTo().window(parentWindowHandler2); // switch to Parent window
                                                                                                test.log(Status.INFO,"Entered the Interview Details");
                                                                                }
                                                                                                                                
                                                                                
                                                                                if(data.exportResults.equals("Yes")){
                                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_export_results(driver)));
                                                                                                PageObjectsAgency.btn_export_results(driver).click();
                                                                                                Thread.sleep(3000);
                                                                                                
                                                                                     wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_export_pwd_results_popup(driver)));
                                                                                                PageObjectsAgency.txt_export_pwd_results_popup(driver).click();
                                                                                                PageObjectsAgency.txt_export_pwd_results_popup(driver).sendKeys(data.passwordForExport);
                                                                                                Thread.sleep(3000);
                                                                                                
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_ok_results_popup(driver)));

                                                                                                TakeScreenshot.captureScreenShot(driver);
                                                                                                                                                                   
                                                                                    test = extent.createTest("Send to queue");
                                                                        Assert.assertTrue(PageObjectsAgency.btn_ok_results_popup(driver).isDisplayed());                                                                                         
                                                                                                
                                                                                                PageObjectsAgency.btn_ok_results_popup(driver).click();
                                                                                                Thread.sleep(3000);
                                                                                                test.log(Status.INFO,"Exported the results");
                                                                                                
                                                                                                
                                                                                }
                                                                                
                }//End for entity
                                                   
                                                   else if(data.entity.equals("Services")){
                                                                                Actions builder = new Actions(driver);
                                                                   builder.moveToElement(PageObjectsAgency.lnk_chk_status(driver)).build().perform();
                                                                   builder.moveToElement(PageObjectsAgency.lnk_services_CS(driver)).build().perform();
                                                                   PageObjectsAgency.lnk_services_CS(driver).click();
                                                                                                                  
                                                                   wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_sol_srch_cand_stat(driver)));
                                                                   test = extent.createTest("Displaying Search Candidate Page");
                                                                   Assert.assertTrue(PageObjectsAgency.visi_sol_srch_cand_stat(driver).getText().contains("Search Candidate Status"));
                                                                  
                                                                   
                                                                   if(data.firstname.isEmpty()){
                                                                                   System.out.println("No first name was inputed in excel sheet");
                                                                   }
                                                                   else{
                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_fname_CS(driver)));
                                                                                   PageObjectsAgency.txt_fname_CS(driver).sendKeys(data.firstname);
                                                                                   test.log(Status.INFO,"Entered the first Name");
                                                                   }
                                                                                                                  
                                                                   if(data.lastname.isEmpty()){
                                                                                   System.out.println("No last name was inputed in excel sheet");                                                  
                                                                   }
                                                                   else{
                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_lname_CS(driver)));
                                                                                   PageObjectsAgency.txt_lname_CS(driver).sendKeys(data.lastname);                    
                                                                                   test.log(Status.INFO,"Entered the Last Name");
                                                                   }
                                                                   
                                                                   
                                                                   if(data.candEmailID.isEmpty()){
                                                                                   System.out.println("No last name was inputed in excel sheet");                               
                                                                   }
                                                                   else{
                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_cand_emailid_CS(driver)));
                                                                                   PageObjectsAgency.txt_cand_emailid_CS(driver).sendKeys(data.candEmailID);
                                                                                   test.log(Status.INFO,"Entered the Candidate Email ID");
                                                                   }
                                                                  
                                                                  
                                                                   if(data.CID.isEmpty()){
                                                                                   System.out.println("No CID was inputed in excel sheet");
                                                                   }
                                                                   else{
                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_cid_CS(driver)));
                                                                                   PageObjectsAgency.txt_cid_CS(driver).sendKeys(data.CID);
                                                                                   test.log(Status.INFO,"Entered the CID");
                                                                                   
                                                                   }
                                                                   
                                                                   if(data.refFromDate.isEmpty()){
                                                                                   System.out.println("No Reference From Date was inputed in excel sheet");
                                                                   }
                                                                   else{
                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_cal_ref_frm_CS(driver)));
                                                                                   PageObjectsAgency.btn_cal_ref_frm_CS(driver).click();
                                                                                   PageObjectsAgency.btn_cal_ref_frm_CS(driver).sendKeys(data.refFromDate);
                                                                                   test.log(Status.INFO,"Entered the Refenence From Date");
                                                                   }
                                                                   
                                                                   if(data.refToDate.isEmpty()){
                                                                                   System.out.println("No Reference To Date was inputed in excel sheet");
                                                                   }
                                                                   else{
                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_cal_ref_to_CS(driver)));
                                                                                   PageObjectsAgency.btn_cal_ref_to_CS(driver).click();
                                                                                   PageObjectsAgency.btn_cal_ref_to_CS(driver).sendKeys(data.refToDate);
                                                                                   test.log(Status.INFO,"Entered the Reference To Date");
                                                                   }
                                                        
                                                        
                                                        if(data.workforce.isEmpty()){
                                                               System.out.println("No workforce was inputed in excel sheet");
                                                        }
                                                                                
                                                        else{
                                                                        wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_workforce_CS(driver)));
                                                                                                PageObjectsAgency.dd_workforce_CS(driver).click();
                                                                                                
                                                                                                List<WebElement> workforce = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_ddlWorkforce']/option");
                                                                                                System.out.println(workforce.size());
                                                                                                for(WebElement workforce1: workforce){
                                                                                                                String value = workforce1.getText();
                                                                                                                if(value.equalsIgnoreCase(data.workforce)){
                                                                                                                                workforce1.click();
                                                                                                                                System.out.println("Clicked workforce");
                                                                                                                                test.log(Status.INFO,"Workforce Selected");
                                                                                                                                break;
                                                                                                                }
                                                                                                }
                                                                                                
                                                        }
                                                        
                                                        
                                                        if(data.candStatus.isEmpty()){
                                                               System.out.println("No status was inputed in excel sheet");
                                                        }
                                                        else{
                                                                        wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_status_CS(driver)));
                                                                                                PageObjectsAgency.dd_status_CS(driver).click();
                                                                                                
                                                                                                List<WebElement> status = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_ddlStatus']/option");
                                                                                                System.out.println(status.size());              
                                                                                                for(WebElement status1: status){
                                                                                                                String value = status1.getText();
                                                                                                                if(value.equalsIgnoreCase(data.candStatus)){
                                                                                                                                status1.click();
                                                                                                                                System.out.println("Clicked Candidate Status");
                                                                                                                                test.log(Status.INFO,"Candidate Status Selected");
                                                                                                                                
                                                                                                                                break;
                                                                                                                }
                                                                                                }
                                                        }
                                                        
                                                       
                                                        if(data.location.isEmpty()){
                                                                                                System.out.println("No Location is selected in the dropdown");
                                                                                }
                                                                                else{
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_location_CS(driver)));
                                                                                                PageObjectsAgency.dd_location_CS(driver).click();
                                                                                                
                                                                                                List<WebElement> location = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_ddlLocation']/option");
                                                                                                System.out.println(location.size());
                                                                                                for(WebElement location1: location){
                                                                                                                String value = location1.getText();
                                                                                                                if(value.equalsIgnoreCase(data.location)){
                                                                                                                                location1.click();
                                                                                                                                System.out.println("Clicked Location");
                                                                                                                                test.log(Status.INFO,"Location Selected");
                                                                                                                                break;
                                                                                                                }
                                                                                                
                                                                                }
                                                                                }
                                                        
                                                        if(data.skill.isEmpty()){
                                                                                                System.out.println("No speciality was inputed in excel sheet");
                                                                                }
                                                                                else{
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.img_search_skill_CS(driver)));
                                                                                                PageObjectsAgency.img_search_skill_CS(driver).click();
                                                                                                String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
                                                                                                String subWindowHandler = null;

                                                                                                Set<String> handles = driver.getWindowHandles(); // get all window handles
                                                                                                Iterator<String> iterator = handles.iterator();
                                                                                                while (iterator.hasNext()){
                                                                                                    subWindowHandler = iterator.next();
                                                                                                }
                                                                                                driver.switchTo().window(subWindowHandler); // switch to popup window
                                                                                                wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.txt_search_criteria_CS(driver)));
                                                                                                PageObjectsAgency.txt_search_criteria_CS(driver).clear();
                                                                                                PageObjectsAgency.txt_search_criteria_CS(driver).sendKeys(data.skill);
                                                                                                if(PageObjectsAgency.chk_skill_CS(driver).isSelected()){
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_search_skill_CS(driver)));
                                                                                                                PageObjectsAgency.btn_search_skill_CS(driver).click();
                                                                                                                Thread.sleep(3000);
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_srch_rslt_CS_skill(driver)));
                                                                                                                PageObjectsAgency.lnk_srch_rslt_CS_skill(driver).click();
                                                                                                                test.log(Status.INFO,"Skill Selected");
                                                                                                                
                                                                                                }
                                                                                                
                                                                                                driver.switchTo().window(parentWindowHandler);
                                                                                }
                                                        
                                                        wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_mobile_no_CS(driver)));
                                                        
                                                        if(data.mobile_num.isEmpty()){
                                                                                                System.out.println("No Mobile Num is inputed");
                                                                                }
                                                                                else{
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_mobile_no_CS(driver)));
                                                                                                PageObjectsAgency.txt_mobile_no_CS(driver).click();
                                                                                                PageObjectsAgency.txt_mobile_no_CS(driver).sendKeys(data.mobile_num);
                                                                                                test.log(Status.INFO,"Entered the mobile number");
                                                                                }
                                                                                
                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_srch_CS(driver)));
                                                                                PageObjectsAgency.btn_srch_CS(driver).click();
                                                                                
                                                                                Thread.sleep(6000);
                                                                                TakeScreenshot.captureScreenShot(driver);
                                                                  
                                                                    test = extent.createTest("Displaying the search results");
                                                        Assert.assertTrue(PageObjectsAgency.visi_search_results_CS(driver).getText().contains("Search Results"));
                                                        Thread.sleep(3000);
                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");                                    
                                                                                                
                                                                                                if(data.wannaChangeCIDDet.equals("Yes")){
                                                                                                                
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_cand_id_results(driver)));
                                                                                                                PageObjectsAgency.lnk_cand_id_results(driver).click();
                                                                                                                
                                                                                                                String parentWindowHandler1 = driver.getWindowHandle(); // Store your parent window
                                                                                                                String subWindowHandler1 = null;

                                                                                                                Set<String> handles1 = driver.getWindowHandles(); // get all window handles
                                                                                                                Iterator<String> iterator1 = handles1.iterator();
                                                                                                                while (iterator1.hasNext()){
                                                                                                                    subWindowHandler1 = iterator1.next();
                                                                                                                }
                                                                                                                
                                                                                                                driver.switchTo().window(subWindowHandler1); // switch to popup window
                                                                                                                
                                                                                                                                                                                
                                                                                                                if(data.landline.isEmpty()){
                                                                                                                                System.out.println("Change in Mobile and Landline number is not required");                                                                                            
                                                                                                                }
                                                                                                                else{
                                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_ISD_CS_CID(driver)));
                                                                                                                                PageObjectsAgency.txt_ISD_CS_CID(driver).clear();
                                                                                                                                PageObjectsAgency.txt_ISD_CS_CID(driver).sendKeys(data.ISD);
                                                                                                                                test.log(Status.INFO,"Entered the ISD Code");
                                                                                                                                
                                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_STD_CS_CID(driver)));
                                                                                                                                PageObjectsAgency.txt_STD_CS_CID(driver).clear();
                                                                                                                                PageObjectsAgency.txt_STD_CS_CID(driver).sendKeys(data.STD);
                                                                                                                                test.log(Status.INFO,"Entered the STD Code");
                                                                                                                                
                                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_Lnumber_CS_CID(driver)));
                                                                                                                                PageObjectsAgency.txt_Lnumber_CS_CID(driver).clear();
                                                                                                                                PageObjectsAgency.txt_Lnumber_CS_CID(driver).sendKeys(data.landline);
                                                                                                                                test.log(Status.INFO,"Entered the Landline Number");
                                                                                                                                
                                                                                                                                
                                                                                                                                if(data.mobile.isEmpty()){
                                                                                                                                                System.out.println("No Change required in Mobile number");
                                                                                                                                }
                                                                                                                                
                                                                                                                                else{
                                                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_mobileno_CS_CID(driver)));
                                                                                                                                                PageObjectsAgency.txt_mobileno_CS_CID(driver).clear();
                                                                                                                                                PageObjectsAgency.txt_mobileno_CS_CID(driver).sendKeys(data.mobile);
                                                                                                                                                test.log(Status.INFO,"Entered the mobile number");
                                                                                                                                }
                                                                                                                                
                                                                                                                            wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_new_comments_CS_CID(driver)));
                                                                                                                                PageObjectsAgency.txt_new_comments_CS_CID(driver).clear();
                                                                                                                                PageObjectsAgency.txt_new_comments_CS_CID(driver).sendKeys(data.newComments);
                                                                                                                                test.log(Status.INFO,"Entered the new comments");
                                                                                                                                
                                                                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_submit_CS_CID(driver)));
                                                                                                                                PageObjectsAgency.btn_submit_CS_CID(driver).click();
                                                                                                                                                                                                                                                                                                                                
                                                                                                                                Thread.sleep(3000);
                                                                                                  
                                                                                                                                test = extent.createTest("Changing the CID Details");
                                                                                                                    Alert alert = driver.switchTo().alert();                                                                                                
                                                                                                                                
                                                                                                                                System.out.println(alert.getText());
                                                                                                                                Assert.assertTrue(alert.getText().contains("Successfully updated the details.") || alert.getText().contains("Candidate details you have entered already exists ."));                                                                                  
                                                                                                                                
                                                                                                                                try {
                                                                                                                                                if (alert.getText().contains("Candidate details you have entered already exists .")) {
                                                                                                                                                                alert.accept();
                                                                                                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                                                                                                                TakeScreenshot.captureScreenShot(driver);
                                                                                                                                                                wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.btn_close_CS_CID(driver)));
                                                                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_close_CS_CID(driver)));
                                                                                                                                                                PageObjectsAgency.btn_close_CS_CID(driver).click();
                                                                                                                                                }
                                                                                                                                } catch (Exception e1) {
                                                                                                                                                System.out.println("Tried Once");
                                                                                                                                }
                                                                                                                                try {
                                                                                                                                                if (alert.getText().contains("Successfully updated the details.")) {
                                                                                                                                                                alert.accept();
                                                                                                                                                }
                                                                                                                                } catch (Exception e1) {
                                                                                                                                                System.out.println("Tried Twice");
                                                                                                                                }
                                                                                                                                
                                                                                                                                Thread.sleep(3000);
                                                                                                                                
                                                                                                                                
                                                                                                                                                try {
                                                                                                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_close_CS_CID(driver)));
                                                                                                                                                                PageObjectsAgency.btn_close_CS_CID(driver).click();
                                                                                                                                                } catch (Exception e) {
                                                                                                                                                                System.out.println("Data is submitted");
                                                                                                                                                                
                                                                                                                                                }
                                                                                                                                
                                                                                                                                                                                                                                
                                                                                                                }                                                              
                                                                                                                
                                                                                                                driver.switchTo().window(parentWindowHandler1); //switch to parent window                                                                            
                                                                                                                
                                                                                                }
                                                                                                
                                                                                                try {
                                                                                                                
                                                                                                                if(data.uploadResume.equals("Yes")){
                                                                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                                                                                Thread.sleep(3000);
                                                                                                                                jse.executeScript("window.scrollBy(1000,0)", "");
                                                                                                                                Thread.sleep(3000);
                                                                                                                                
                                                                                                                             wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_resume_upload_results(driver)));
                                                                                                                                PageObjectsAgency.lnk_resume_upload_results(driver).click();
                                                                                                                                Thread.sleep(5000);
                                                                                                                               Runtime.getRuntime().exec(prop.Word_Path());
                                                                                                                                Thread.sleep(3000);
                                                                                                                                test.log(Status.INFO,"Uploaded the resume");
                                                                                                                }
                                                                                                } catch (Exception e) {
                                                                                                                System.out.println("Upload Resume Hyperlink is disabled");
                                                                                                }
                                                                                                
                                                                                                
                                                                                                if(data.viewIntDetails.equals("Yes")){
//                                                                                                            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//                                                                                                            Thread.sleep(3000);
//                                                                                                            jse.executeScript("window.scrollBy(1500,0)", "");
//                                                                                                            Thread.sleep(3000);
//                                                                               
//                                                                                                            wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_int_status_results(driver)));
//                                                                                                            PageObjectsAgency.lnk_int_status_results(driver).click();
//                                                                                                            
//                                                                                                            String parentWindowHandler2 = driver.getWindowHandle(); // Store your parent window
//                                                                                                            String subWindowHandler2 = null;
//
//                                                                                                            Set<String> handles2 = driver.getWindowHandles(); // get all window handles
//                                                                                                            Iterator<String> iterator2 = handles2.iterator();
//                                                                                                            while (iterator2.hasNext()){
//                                                                                                                subWindowHandler2 = iterator2.next();
//                                                                                                            }
//                                                                                                            
//                                                                                                            driver.switchTo().window(subWindowHandler2); // switch to popup window
//                                                                                                            
//                                                                                                            Thread.sleep(6000);
//                                                                                                            wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_close_CS_Int_stat(driver)));
//                                                                                                            PageObjectsAgency.btn_close_CS_Int_stat(driver).click();
//                                                                                                            
//                                                                                                            TakeScreenshot.captureScreenShot(driver);
//                                                                                                            test = extent.createTest("View Interview Details");
//                                                                                                            Assert.assertTrue(PageObjectsAgency.visi_int_status_results(driver).getText().equals("Interview Status"));
//                                                                                                            
//                                                                                                            driver.switchTo().window(parentWindowHandler2); // switch to Parent window
//                                                                                                            test.log(Status.INFO,"Entered the Interview Details");
                                                                                                }
                                                                                                                                                
                                                                                                
                                                                                                if(data.exportResults.equals("Yes")){
                                                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_export_results(driver)));
                                                                                                                PageObjectsAgency.btn_export_results(driver).click();
                                                                                                                Thread.sleep(3000);
                                                                                                                
                                                                                                     wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_export_pwd_results_popup(driver)));
                                                                                                                PageObjectsAgency.txt_export_pwd_results_popup(driver).click();
                                                                                                                PageObjectsAgency.txt_export_pwd_results_popup(driver).sendKeys(data.passwordForExport);
                                                                                                                Thread.sleep(3000);
                                                                                                                
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_ok_results_popup(driver)));
                                                                                                                TakeScreenshot.captureScreenShot(driver);
                                                                                                                   
                                                                                                    test = extent.createTest("Send to queue");
                                                                                        Assert.assertTrue(PageObjectsAgency.btn_ok_results_popup(driver).isDisplayed());
                                                                                                                PageObjectsAgency.btn_ok_results_popup(driver).click();
                                                                                                                Thread.sleep(3000);
                                                                                                                test.log(Status.INFO,"Exported the Search Results");
                                                                                                }
                                                                                                                
                                                                   
                                                   }
                                                   
                                                   else if ((data.entity.equals("Enterprise")) ||  (data.entity.equals("Consulting"))){
                                                                   
                                                                   Actions builder = new Actions(driver);
                                                                   builder.moveToElement(PageObjectsAgency.lnk_chk_status(driver)).build().perform();
                                                                   builder.moveToElement(PageObjectsAgency.lnk_enterprise_CS(driver)).build().perform();
                                                                   PageObjectsAgency.lnk_enterprise_CS(driver).click();
                                                                               
                                                                   wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_sol_srch_cand_stat(driver)));
                                                                   test = extent.createTest("Displaying Search Candidate Page");
                                                                   Assert.assertTrue(PageObjectsAgency.visi_sol_srch_cand_stat(driver).getText().contains("Search Candidate Status"));
                                                                  
                                                                                                                   
                                                                   if(data.firstname.isEmpty()){   
                                                                                   System.out.println("No first name was inputed in excel sheet");
                                                                   }
                                                                   else{
                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_fname_CS(driver)));
                                                                                   PageObjectsAgency.txt_fname_CS(driver).sendKeys(data.firstname);
                                                                                   test.log(Status.INFO,"Entered the first name");
                                                                   }
                                                                                                                  
                                                                   if(data.lastname.isEmpty()){
                                                                                   System.out.println("No last name was inputed in excel sheet");                                                  
                                                                   }
                                                                   else{
                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_lname_CS(driver)));
                                                                                   PageObjectsAgency.txt_lname_CS(driver).sendKeys(data.lastname);    
                                                                                   test.log(Status.INFO,"Entered the Last Name");
                                                                   }
                                                                   
                                                                   
                                                                   if(data.candEmailID.isEmpty()){
                                                                                   System.out.println("No last name was inputed in excel sheet");                               
                                                                   }
                                                                   else{
                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_cand_emailid_CS(driver)));
                                                                                   PageObjectsAgency.txt_cand_emailid_CS(driver).sendKeys(data.candEmailID);
                                                                                   test.log(Status.INFO,"Entered the Candidate Email ID");
                                                                   }
                                                                  
                                                                  
                                                                   if(data.CID.isEmpty()){
                                                                                   System.out.println("No CID was inputed in excel sheet");
                                                                   }
                                                                   else{
                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_cid_CS(driver)));
                                                                                   PageObjectsAgency.txt_cid_CS(driver).sendKeys(data.CID);
                                                                                   test.log(Status.INFO,"Entered the CID");
                                                                                   
                                                                   }
                                                                   
                                                                   if(data.refFromDate.isEmpty()){
                                                                                   System.out.println("No Reference From Date was inputed in excel sheet");
                                                                   }
                                                                   else{
                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_cal_ref_frm_CS(driver)));
                                                                                   PageObjectsAgency.btn_cal_ref_frm_CS(driver).click();
                                                                                   PageObjectsAgency.btn_cal_ref_frm_CS(driver).sendKeys(data.refFromDate);
                                                                                   test.log(Status.INFO,"Entered the Reference From Date");
                                                                   }
                                                                   
                                                                   if(data.refToDate.isEmpty()){
                                                                                   System.out.println("No Reference To Date was inputed in excel sheet");
                                                                   }
                                                                   else{
                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_cal_ref_to_CS(driver)));
                                                                                   PageObjectsAgency.btn_cal_ref_to_CS(driver).click();
                                                                                   PageObjectsAgency.btn_cal_ref_to_CS(driver).sendKeys(data.refToDate);
                                                                                   test.log(Status.INFO,"Entered the Refered To Date");
                                                                   }
                                                        
                                                        
                                                        if(data.workforce.isEmpty()){
                                                               System.out.println("No workforce was inputed in excel sheet");
                                                        }
                                                                                
                                                        else{
                                                                        wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_workforce_CS(driver)));
                                                                                                PageObjectsAgency.dd_workforce_CS(driver).click();
                                                                                                
                                                                                                List<WebElement> workforce = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_ddlWorkforce']/option");
                                                                                                System.out.println(workforce.size());
                                                                                                for(WebElement workforce1: workforce){
                                                                                                                String value = workforce1.getText();
                                                                                                                if(value.equalsIgnoreCase(data.workforce)){
                                                                                                                                workforce1.click();
                                                                                                                                System.out.println("Clicked workforce");
                                                                                                                                test.log(Status.INFO,"Workforce Selected");
                                                                                                                                break;
                                                                                                                }
                                                                                                }
                                                                                                
                                                        }
                                                        
                                                        
                                                        if(data.candStatus.isEmpty()){
                                                               System.out.println("No status was inputed in excel sheet");
                                                        }
                                                        else{
                                                                        wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_status_CS(driver)));
                                                                                                PageObjectsAgency.dd_status_CS(driver).click();
                                                                                                
                                                                                                List<WebElement> status = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_ddlStatus']/option");
                                                                                                System.out.println(status.size());              
                                                                                                for(WebElement status1: status){
                                                                                                                String value = status1.getText();
                                                                                                                if(value.equalsIgnoreCase(data.candStatus)){
                                                                                                                                status1.click();
                                                                                                                                System.out.println("Clicked Candidate Status");
                                                                                                                                test.log(Status.INFO,"Candidate Status Selected");
                                                                                                                                break;
                                                                                                                }
                                                                                                }
                                                        }
                                                        
                                                       
                                                        if(data.location.isEmpty()){
                                                                                                System.out.println("No Location is selected in the dropdown");
                                                                                }
                                                                                else{
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_location_CS(driver)));
                                                                                                PageObjectsAgency.dd_location_CS(driver).click();
                                                                                                
                                                                                                List<WebElement> location = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_ddlLocation']/option");
                                                                                                System.out.println(location.size());
                                                                                                for(WebElement location1: location){
                                                                                                                String value = location1.getText();
                                                                                                                if(value.equalsIgnoreCase(data.location)){
                                                                                                                                location1.click();
                                                                                                                                System.out.println("Clicked Location");
                                                                                                                                test.log(Status.INFO,"Location Selected");
                                                                                                                                break;
                                                                                                                }
                                                                                                
                                                                                }
                                                                                }
                                                        
                                                        if(data.skill.isEmpty()){
                                                                                                System.out.println("No speciality was inputed in excel sheet");
                                                                                }
                                                                                else{
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.img_search_skill_CS(driver)));
                                                                                                PageObjectsAgency.img_search_skill_CS(driver).click();
                                                                                                String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
                                                                                                String subWindowHandler = null;

                                                                                                Set<String> handles = driver.getWindowHandles(); // get all window handles
                                                                                                Iterator<String> iterator = handles.iterator();
                                                                                                while (iterator.hasNext()){
                                                                                                    subWindowHandler = iterator.next();
                                                                                                }
                                                                                                driver.switchTo().window(subWindowHandler); // switch to popup window
                                                                                                wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.txt_search_criteria_CS(driver)));
                                                                                                PageObjectsAgency.txt_search_criteria_CS(driver).clear();
                                                                                                PageObjectsAgency.txt_search_criteria_CS(driver).sendKeys(data.skill);
                                                                                                if(PageObjectsAgency.chk_skill_CS(driver).isSelected()){
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_search_skill_CS(driver)));
                                                                                                                PageObjectsAgency.btn_search_skill_CS(driver).click();
                                                                                                                Thread.sleep(3000);
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_srch_rslt_CS_skill(driver)));
                                                                                                                PageObjectsAgency.lnk_srch_rslt_CS_skill(driver).click();
                                                                                                                test.log(Status.INFO,"Skill Selected");
                                                                                                                
                                                                                                }
                                                                                                
                                                                                                driver.switchTo().window(parentWindowHandler);
                                                                                }
                                                        
                                                        if(data.position_no.isEmpty()){
                                                                                                System.out.println("No Position Number is Inputed");
                                                                                }
                                                                                else{
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_position_num(driver)));
                                                                                                PageObjectsAgency.txt_position_num(driver).clear();
                                                                                                PageObjectsAgency.txt_position_num(driver).sendKeys(data.position_no);
                                                                                                test.log(Status.INFO,"Entered the Position Number");
                                                                                                                                                                                
                                                                                }
                                                        
                                                        if(data.mobile_num.isEmpty()){
                                                                                                System.out.println("No Mobile Num is inputed");
                                                                                }
                                                                                else{
                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_mobile_no_CS(driver)));
                                                                                                PageObjectsAgency.txt_mobile_no_CS(driver).click();
                                                                                                PageObjectsAgency.txt_mobile_no_CS(driver).sendKeys(data.mobile_num);
                                                                                                test.log(Status.INFO,"Entered the Mobile Number");
                                                                                }
                                                                                
                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_srch_CS(driver)));
                                                                                PageObjectsAgency.btn_srch_CS(driver).click();
                                                                                
                                                                                Thread.sleep(6000);
                                                                                
                                                                                TakeScreenshot.captureScreenShot(driver);
                                                                  
                                                                    test = extent.createTest("Displaying the search results");
                                                        Assert.assertTrue(PageObjectsAgency.visi_search_results_CS(driver).getText().contains("Search Results"));
                                                        Thread.sleep(3000);
                                                        
                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");                                    
                                                                                                
                                                                                                try {
																									if(data.wannaChangeCIDDet.equals("Yes")){
																									                if (PageObjectsAgency.lnk_cand_id_results(driver).isEnabled()) {
																									                	wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_cand_id_results(driver)));
																									                    PageObjectsAgency.lnk_cand_id_results(driver).click();
																									                    
																									                    String parentWindowHandler1 = driver.getWindowHandle(); // Store your parent window
																									                    String subWindowHandler1 = null;

																									                    Set<String> handles1 = driver.getWindowHandles(); // get all window handles
																									                    Iterator<String> iterator1 = handles1.iterator();
																									                    while (iterator1.hasNext()){
																									                        subWindowHandler1 = iterator1.next();
																									                    }
																									                    
																									                    driver.switchTo().window(subWindowHandler1); // switch to popup window
																									                    
																									                                                                                    
																									                    if(data.landline.isEmpty()){
																									                                    System.out.println("Change in Mobile and Landline number is not required");                                                                                            
																									                    }
																									                    else{
																									                                    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_ISD_CS_CID(driver)));
																									                                    PageObjectsAgency.txt_ISD_CS_CID(driver).clear();
																									                                    PageObjectsAgency.txt_ISD_CS_CID(driver).sendKeys(data.ISD);
																									                                    test.log(Status.INFO,"Entered the ISD Code");
																									                                    
																									                                    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_STD_CS_CID(driver)));
																									                                    PageObjectsAgency.txt_STD_CS_CID(driver).clear();
																									                                    PageObjectsAgency.txt_STD_CS_CID(driver).sendKeys(data.STD);
																									                                    test.log(Status.INFO,"Entered the STD Code");
																									                                    
																									                                    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_Lnumber_CS_CID(driver)));
																									                                    PageObjectsAgency.txt_Lnumber_CS_CID(driver).clear();
																									                                    PageObjectsAgency.txt_Lnumber_CS_CID(driver).sendKeys(data.landline);
																									                                    test.log(Status.INFO,"Entered the Landline Number");
																									                                    
																									                                    
																									                                    if(data.mobile.isEmpty()){
																									                                                    System.out.println("No Change required in Mobile number");
																									                                    }
																									                                    
																									                                    else{
																									                                                    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_mobileno_CS_CID(driver)));
																									                                                    PageObjectsAgency.txt_mobileno_CS_CID(driver).clear();
																									                                                    PageObjectsAgency.txt_mobileno_CS_CID(driver).sendKeys(data.mobile);
																									                                                    test.log(Status.INFO,"Entered the Mobile Number");
																									                                    }
																									                                    
																									                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_new_comments_CS_CID(driver)));
																									                                    PageObjectsAgency.txt_new_comments_CS_CID(driver).sendKeys(data.newComments);
																									                                    
																									                                    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
																									                                    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_submit_CS_CID(driver)));
																									                                    PageObjectsAgency.btn_submit_CS_CID(driver).click();
																									                                    
																									                                    Thread.sleep(3000);
                                                     
																									                                    test = extent.createTest("Changing the CID Details");
																									                        Alert alert = driver.switchTo().alert();                                                                                                
																									                                    
																									                                    System.out.println(alert.getText());
																									                                    Assert.assertTrue(alert.getText().contains("OK") ||alert.getText().contains("Candidate details you have entered already exists ."));                                                                                             
																									                                    
																									                                    try {
																									                                                    if (alert.getText().contains("Candidate details you have entered already exists .")) {
																									                                                                    alert.accept();
																									                                                                    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
																									                                                                    TakeScreenshot.captureScreenShot(driver);
																									                                                                    wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.btn_close_CS_CID(driver)));
																									                                                                    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_close_CS_CID(driver)));
																									                                                                    PageObjectsAgency.btn_close_CS_CID(driver).click();
																									                                                    }
																									                                    } catch (Exception e1) {
																									                                                    System.out.println("Tried Once");
																									                                    }
																									                                    try {
																									                                                    if (alert.getText().contains("OK")) {
																									                                                                    alert.accept();
																									                                                    }
																									                                    } catch (Exception e1) {
																									                                                    System.out.println("Tried Twice");
																									                                    }
																									                                    
																									                                    Thread.sleep(3000);
																									                                    
																									                                                    try {
																									                                                                    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
																									                                                                    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_close_CS_CID(driver)));
																									                                                                    PageObjectsAgency.btn_close_CS_CID(driver).click();
																									                                                    } catch (Exception e) {
																									                                                                    System.out.println("Data is submitted");
																									                                                                    
																									                                                    }
																									                                    
																									                                                    driver.switchTo().window(parentWindowHandler1); //switch to parent window                                                                            
																									                                                                                                                                                        
																									                    }                                                              
                                                     
																													}
																									                                                              
																									                
																									}
																								} catch (Exception e1) {
																									System.out
																											.println("CID Hyperlink is not enabled");
																								}
                                                                                                
                                                                                                try {
                                                                                                                
                                                                                                                if(data.uploadResume.equals("Yes")){
                                                                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                                                                                Thread.sleep(3000);
                                                                                                                                jse.executeScript("window.scrollBy(1000,0)", "");
                                                                                                                                Thread.sleep(3000);
                                                                                                                                
                                                                                                                             if (PageObjectsAgency.lnk_resume_upload_results(driver).isEnabled()) {
                                                                                                                            	 wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_resume_upload_results(driver)));
                                                                                                                                 PageObjectsAgency.lnk_resume_upload_results(driver).click();
                                                                                                                                 Thread.sleep(5000);
                                                                                                                                 Runtime.getRuntime().exec(prop.Word_Path());
                                                                                                                                 Thread.sleep(3000);
                                                                                                                                 test.log(Status.INFO,"Uploaded the resume");
																															}
                                                                                                                }
                                                                                                } catch (Exception e) {
                                                                                                                System.out.println("Upload Resume Hyperlink is disabled");
                                                                                                }
                                                                                                
                                                                                                
                                                                                                try {
																									if(data.viewIntDetails.equals("Yes")){
																									            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
																									            Thread.sleep(3000);
																									            jse.executeScript("window.scrollBy(1500,0)", "");
																									            Thread.sleep(3000);
																									            if (PageObjectsAgency.lnk_int_status_results(driver).isEnabled()) {
																										            wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_int_status_results(driver)));
																										            PageObjectsAgency.lnk_int_status_results(driver).click();
																										            
																										            String parentWindowHandler2 = driver.getWindowHandle(); // Store your parent window
																										            String subWindowHandler2 = null;

																										            Set<String> handles2 = driver.getWindowHandles(); // get all window handles
																										            Iterator<String> iterator2 = handles2.iterator();
																										            while (iterator2.hasNext()){
																										                subWindowHandler2 = iterator2.next();
																										            }
																										            
																										            driver.switchTo().window(subWindowHandler2); // switch to popup window
																										            
																										            Thread.sleep(6000);
																										            wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_close_CS_Int_stat(driver)));
																										            PageObjectsAgency.btn_close_CS_Int_stat(driver).click();
																										            
																										            TakeScreenshot.captureScreenShot(driver);
																										            test = extent.createTest("View Interview Details");
																										            Assert.assertTrue(PageObjectsAgency.visi_int_status_results(driver).getText().equals("Interview Status"));
																										            
																										            driver.switchTo().window(parentWindowHandler2); // switch to Parent window
																										            test.log(Status.INFO,"Entered the Interview Details");
																												}
														
																									}
																								} catch (Exception e) {
																									System.out
																											.println("Interview Link is disabled");
																								}
                                                                                                
                                                                                                if(data.exportResults.equals("Yes")){
                                                                                                                jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_export_results(driver)));
                                                                                                                PageObjectsAgency.btn_export_results(driver).click();
                                                                                                                Thread.sleep(3000);
                                                                                                                
                                                                                                     wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.txt_export_pwd_results_popup(driver)));
                                                                                                                PageObjectsAgency.txt_export_pwd_results_popup(driver).click();
                                                                                                                PageObjectsAgency.txt_export_pwd_results_popup(driver).sendKeys(data.passwordForExport);
                                                                                                                Thread.sleep(3000);
                                                                                                                
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_ok_results_popup(driver)));

                                                                                                                TakeScreenshot.captureScreenShot(driver);
                                                                                                                                                                                   
                                                                                                    test = extent.createTest("Send to queue");
                                                                                        Assert.assertTrue(PageObjectsAgency.btn_ok_results_popup(driver).isDisplayed());                                                                                         
                                                                                                                
                                                                                                                PageObjectsAgency.btn_ok_results_popup(driver).click();
                                                                                                                Thread.sleep(3000);
                                                                                                                test.log(Status.INFO,"Exported the Results");
                                                                                                                                                                                                                
                                                                                                }                                                                                              
                                                   
                                                   }                   
                        
                  }
                  
                  @AfterTest
                                public void terminatetest() {
//                             wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_logout(driver)));
//                              test.log(Status.INFO, "Clicking the Logout Button");
//                              PageObjectsAgency.lnk_logout(driver).click();  
//                              driver.close();
                                }
}
