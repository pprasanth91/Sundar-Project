package com.test.candidate.testNG;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
import com.pageobjects.PageObjectsQueryManagement;
import com.utilities.ConfigReader;
import com.utilities.ExcelTestDataEAF;
import com.utilities.ExtendReports;
import com.utilities.ReadPropFile;
import com.utilities.TakeScreenshot;

public class QM extends ExtendReports{
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
                                String scrFolder = System.getProperty("user.dir")+"\\Screenshots\\Query_Management_directApplicant\\"+ new SimpleDateFormat("dd_MM_yyyy_HHmmss").format(Calendar.getInstance().getTime()).toString();
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
                                                   
                                                  //waiting till the Page loads                                         
                                                    if (PageObjectsEAF.h_Terms_Conditions(driver).isDisplayed()) {
                                                                    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsEAF.btn_ok_Terms_Conditions(driver)));
                                                                 PageObjectsEAF.btn_ok_Terms_Conditions(driver).click();           
                                                                 System.out.println("Clicked the OK Button in Terms and Conditions");
                                                                }              
                                                
                                                Thread.sleep(5000);
                                    
                                    wait.until(ExpectedConditions.visibilityOf(PageObjectsQueryManagement.lnk_write_to_us(driver)));
                                    PageObjectsQueryManagement.lnk_write_to_us(driver).click();
                                    
                                    Thread.sleep(10000);
                                   // wait.until(ExpectedConditions.textToBePresentInElement(PageObjectsQueryManagement.para_new_query_visi(driver), "Write to us..."));
                                    
                                    By qcategory = By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[1]/ul/li/a");
                                    test = extent.createTest("Clicking category");
                                    TakeScreenshot.captureScreenShot(driver);
                        Assert.assertTrue(driver.findElement(qcategory).isDisplayed());          
                                    List<WebElement> category = (List<WebElement>) driver.findElements(qcategory);
                                    
                                    System.out.println(category.size());
                                    System.out.println(category);
                                                for(WebElement category1: category){
                                                                String value = category1.getText();
                                                                if(value.equalsIgnoreCase("Joining Related")){
                                                                                category1.click();
                                                                                System.out.println("Clicked category specified");
                                                                                break;
                                                                }
                                                }
                                                
                                                
                                                Thread.sleep(3000);
                                    By qjoinrel = By.xpath(".//*[@id='incidentNewModal']/div/div/div[2]/div/div[2]/ul/li/a");
                                    test = extent.createTest("Clicking the related question");
                                    TakeScreenshot.captureScreenShot(driver);
                        Assert.assertTrue(driver.findElement(qjoinrel).isDisplayed());               
                                    
                                    List<WebElement> question_joining_related = (List<WebElement>) driver.findElements(qjoinrel);
                                    System.out.println(question_joining_related.size());
                                    System.out.println(question_joining_related);
                                                for(WebElement question_joining_related1: question_joining_related){
                                                                String value = question_joining_related1.getText();
                                                                if(value.equalsIgnoreCase("What are the inclusions in my relocation bonus?")){
                                                                                question_joining_related1.click();
                                                                                System.out.println("Clicked category specified");
                                                                                break;
                                                                }
                                                }
                                                
                                                   wait.until(ExpectedConditions.visibilityOf(PageObjectsQueryManagement.txt_answer(driver)));
                                                System.out.println("The Answer for the question is :" + PageObjectsQueryManagement.txt_answer(driver).getText());
                                                System.out.println("\n\nFeel free to enter 'Yes' if you are not satisfied with the answer");
//                            Scanner didnt_help = new Scanner(System.in);
//                                String yes = didnt_help.next();
                                    String yes = "Yes";
                                    System.out.println(yes);
                                    
                                    if(yes.contains("Yes")){
                                                
                                                    wait.until(ExpectedConditions.visibilityOf(PageObjectsQueryManagement.btn_write_to_us(driver)));
                                                test = extent.createTest("Raising a new query");
                                                TakeScreenshot.captureScreenShot(driver);
                                        Assert.assertTrue(PageObjectsQueryManagement.btn_write_to_us(driver).isDisplayed());      
                                                    
                                                PageObjectsQueryManagement.btn_write_to_us(driver).click();
                                                
                                                Thread.sleep(5000);
                                    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsQueryManagement.para_new_query_visi(driver)));
                                                PageObjectsQueryManagement.dd_query_about(driver).click();
                                                    PageObjectsQueryManagement.dd_query_about_input(driver).sendKeys(prop.Query_Related_To());
                                                Thread.sleep(1000);
                                    wait.until(ExpectedConditions.elementToBeClickable(PageObjectsQueryManagement.dd_query_about_input_select(driver)));
                                                PageObjectsQueryManagement.dd_query_about_input_select(driver).click();
                                                                                                                
                                        wait.until(ExpectedConditions.elementToBeClickable(PageObjectsQueryManagement.txt_tell_us_about_it(driver)));
                                               PageObjectsQueryManagement.txt_tell_us_about_it(driver).click();
                                                PageObjectsQueryManagement.txt_tell_us_about_it(driver).sendKeys("Let me thinka nd tell");
                                                
                                                try {
                                                                if(PageObjectsQueryManagement.btn1_upload_doc(driver).isDisplayed()){
                                                                         wait.until(ExpectedConditions.elementToBeClickable(PageObjectsQueryManagement.btn1_upload_doc(driver)));  
                                                                                                PageObjectsQueryManagement.btn1_upload_doc(driver).click();
                                                                }
                                                                else{
                                                                         wait.until(ExpectedConditions.elementToBeClickable(PageObjectsQueryManagement.btn2_upload_doc(driver)));  
                                                                                                PageObjectsQueryManagement.btn2_upload_doc(driver).click();                                                                
                                                                }
                                                                                
                                                                                
                                                                } catch (Exception e) {
                                                                                
                                                                                e.printStackTrace();
                                                                }
                                                
                                                Thread.sleep(3000);
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
                                                //Runtime.getRuntime().exec(prop.getPropertyValue("Word_Path"));
                                                
                                                Thread.sleep(3000);
                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsQueryManagement.btn_post_query(driver)));
                                                test = extent.createTest("Submitting the new query");
                                                TakeScreenshot.captureScreenShot(driver);
                                        Assert.assertTrue(PageObjectsQueryManagement.btn_post_query(driver).isDisplayed());       
                                                    
                                                PageObjectsQueryManagement.btn_post_query(driver).click();
                                                
                                                wait.until(ExpectedConditions.alertIsPresent());
                                                Alert alert = driver.switchTo().alert();
                                                String a = alert.getText();
                                                System.out.println("The text inside the alert is " + alert.getText());
                                                
                                                alert.accept();


                                      String temp[]=a.split("The query has been successfully created and a number to track the progress is : "); 
                                       
                                      System.out.println("The Incident Number is: "+ temp[1]);  
                                                
                                      Thread.sleep(3000);
                                      wait.until(ExpectedConditions.elementToBeClickable(PageObjectsQueryManagement.lnk_replies(driver)));
                                       
                                      PageObjectsQueryManagement.lnk_replies(driver).click();
                                      
                                      Thread.sleep(5000);
                                      wait.until(ExpectedConditions.visibilityOf(PageObjectsQueryManagement.txt_replies_dash_visi(driver)));
                                      wait.until(ExpectedConditions.elementToBeClickable(PageObjectsQueryManagement.lnk_open(driver)));
                                      PageObjectsQueryManagement.lnk_open(driver).click();
                                                     
                                      By qcategoryopen = By.xpath(".//*[@id='incidentModal']/div/div/div[2]/div/div/div/div[2]/div[1]/ul/li/a");
                                                    List<WebElement> open_category = (List<WebElement>) driver.findElements(qcategory);
                                                    System.out.println(open_category.size());
                                                    System.out.println(open_category);
                                                                for(WebElement open_category1: open_category){
                                                                                String value = open_category1.getText();
                                                                                System.out.println(value);
                                                                                Thread.sleep(3000);
                                                                                if(value.equalsIgnoreCase("Document Upload")){
                                                                                                open_category1.click();
                                                                                                System.out.println("Clicked category specified");
                                                                                                break;
                                                                                }
                                                                }
                                                                
                                                  driver.findElement(By.linkText(prop.Query_Related_To())).click();
                                                  Thread.sleep(6000);
                                                  wait.until(ExpectedConditions.visibilityOf(PageObjectsQueryManagement.txt_incident_num_visi(driver)));
                                                  System.out.println(PageObjectsQueryManagement.txt_incident_num_visi(driver).getText());
                                      
                                      wait.until(ExpectedConditions.visibilityOf(PageObjectsQueryManagement.txt_incident_num_visi(driver)));
                                      wait.until(ExpectedConditions.visibilityOf(PageObjectsQueryManagement.txt_post_extra(driver)));
                                      PageObjectsQueryManagement.txt_post_extra(driver).sendKeys("Thanks for your response");
                                      
                                      wait.until(ExpectedConditions.visibilityOf(PageObjectsQueryManagement.btn_post(driver)));
                                      test = extent.createTest("Replying to the query answered");
                                      TakeScreenshot.captureScreenShot(driver);
                                      Assert.assertTrue(PageObjectsQueryManagement.btn_post(driver).isDisplayed());       
                                                   
                                      PageObjectsQueryManagement.btn_post(driver).click();
                                      
                                      Thread.sleep(6000);
                                      
                                      wait.until(ExpectedConditions.elementToBeClickable(PageObjectsQueryManagement.btn_close_page(driver)));
                                      PageObjectsQueryManagement.btn_close_page(driver).click();
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
