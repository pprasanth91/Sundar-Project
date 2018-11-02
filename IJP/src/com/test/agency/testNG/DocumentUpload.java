package com.test.agency.testNG;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class DocumentUpload extends ExtendReports {
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
                                                String scrFolder = System.getProperty("user.dir")+"\\Screenshots\\DocumentUpload_Agency\\"+ new SimpleDateFormat("dd_MM_yyyy_HHmmss").format(Calendar.getInstance().getTime()).toString();
                                    new File(scrFolder).mkdir();
                                    System.setProperty("scr.folder", scrFolder);
                  }
                                
                  @Test
                  public void documentupload() throws Exception {
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
                                    TakeScreenshot.captureScreenShot(driver);
                                    String title1=PageObjectsAgency.visi_agency_home(driver).getText();   
                                    test = extent.createTest("Login as Agency");
                        Assert.assertTrue(title1.contains("Welcome"));
                                    
                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_upload_docs(driver))) ;
                                                PageObjectsAgency.lnk_upload_docs(driver).click();
                                                
                                                wait.until(ExpectedConditions.titleContains("Upload Document"));
                                                
                                                try {
                                                                if (driver.findElement(By.xpath("//*[@id=\"ctl00_Main_lblmessage\"]")).getText().contains("Please note that you are not allowed to upload documents now. Recruitment Team would contact you if documents are required for verifications.")) {
                                                                                test = extent.createTest("Document Upload is not applicable to this agency");
                                                                    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"ctl00_Main_lblmessage\"]")).isDisplayed());
                                                                }
                                                                else {
                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.dd_cid(driver)));
                                                                                PageObjectsAgency.dd_cid(driver).click();
                                                                                Thread.sleep(3000);
                                                                                
                                                                                File Excelfile = new File("./test-input/TestDataJobApplyAgency.xlsx");
                                                                                
                                                                                FileInputStream fis = new FileInputStream(Excelfile);
                                                                                XSSFWorkbook wb = new XSSFWorkbook(fis);
                                                                                XSSFSheet sheet = wb.getSheetAt(1);
                                                                                
                                                                                String CID = sheet.getRow(1).getCell(0).getStringCellValue();
                                                                                
                                                                                List<WebElement> cid = (List<WebElement>) driver.findElementsByXPath(".//*[@id='ctl00_Main_divCid']/div/div/ul/li");
                                                                                System.out.println(cid.size());
                                                                                for(WebElement cid1: cid){
                                                                                                String value = cid1.getText();
                                                                                                if(value.equalsIgnoreCase(CID)){
                                                                                                                cid1.click();
                                                                                                                System.out.println("Clicked CID");
                                                                                                                TakeScreenshot.captureScreenShot(driver);
                                                                                                                break;
                                                                                                }
                                                                                }
                                                                                
                                                                                Thread.sleep(5000);
                                                                                jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.visi_upload_documents(driver));
                                                                                
                                                                                
                                                                                int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
                                                                                for (int i = 1; i < rowCount+1; i++) {
                                                                                                Row row = sheet.getRow(i);
                                                                        //Create a loop to print cell values in a row
                                                                        for (int j = 1; j < row.getLastCellNum(); j++) {
                                                                            //Print Excel data in console
                                                                               
                                                                               String document = row.getCell(j).getStringCellValue();
                                                                               System.out.println(document+" is going to be uploaded");
                                                                               jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_cid(driver));
                                                                                                                wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.dd_doc_type(driver)));
                                                                                                                PageObjectsAgency.dd_doc_type(driver).click();
                                                                                                                Thread.sleep(3000);
                                                                                                                List<WebElement> cid1 = (List<WebElement>) driver.findElementsByXPath("//*[@id='ctl00_Main_divdocupload']/section/fieldset/div[2]/div/div/div/ul/li");
                                                                                                                System.out.println(cid1.size());
                                                                                                                                for(WebElement cid2: cid1){
                                                                                                                                String value = cid2.getText();
                                                                                                                                if(value.equalsIgnoreCase(document)){
                                                                                                                                                cid2.click();
                                                                                                                                                System.out.println("Clicked Document type");
                                                                                                                                                break;
                                                                                                                                }
                                                                                                                }
                                                                                                                                                                                                
                                                                                                                jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.dd_doc_type(driver));
                                                                                                                Thread.sleep(3000);
                                                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_choose(driver)));
                                                                                                                PageObjectsAgency.btn_choose(driver).click();
                                                                                                                
                                                                                                                Thread.sleep(6000);
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
                                                                                                                Thread.sleep(5000);
                                                                                                                
                                                                                                                PageObjectsAgency.txt_comments_doc(driver).sendKeys("Required documents has been uploaded");
                                                                                                                
                                                                                                                jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.btn_choose(driver));
                                                                                                                
                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.btn_save_doc(driver)));
                                                                                                                PageObjectsAgency.btn_save_doc(driver).click();
                                                                                                                Thread.sleep(6000);
                                                                                                                
                                                                                                                TakeScreenshot.captureScreenShot(driver);
                                                                                                                test = extent.createTest("Upload Successful" + document);
                                                                                        Assert.assertTrue(PageObjectsAgency.visi_doc_upload_success_message(driver).getText().equals("Uploaded successfully"));
                                                                                        Thread.sleep(6000);
                                                                                                                
                                                                                        try {
																							if (PageObjectsAgency.visi_doc_list(driver).isDisplayed()) {
																							                wait.until(ExpectedConditions.visibilityOf(PageObjectsAgency.visi_doc_list(driver)));
																							                                        Thread.sleep(5000);
																							                                        TakeScreenshot.captureScreenShot(driver);
																							                                        test = extent.createTest("Document Upload : " + document);
																							                Assert.assertTrue(PageObjectsAgency.visi_doc_list(driver).getText().equals("List of candidate document uploaded"));
																							                Thread.sleep(5000);
																							                                        jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.visi_upload_documents(driver));
																							                        }
																						} catch (Exception e) {
																							System.out
																									.println("Table for record saved is not displayed at the bottom of the page");
																						}
                                                                                                                                }                                      
                                                                        }
                                                                                
                                                                                jse.executeScript("arguments[0].scrollIntoView()", PageObjectsAgency.txt_comments_doc(driver));
                                                                                
                                                                                Thread.sleep(3000);       
                                                                                   wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.chc_doc_upload_status(driver)));
                                                                                PageObjectsAgency.chc_doc_upload_status(driver).click();
                                                                                Thread.sleep(6000);                                       
                                                                }
                                                } catch (Exception e) {
                                                                System.out.println("Agency is not applicable for document Upload");
                                                }
                                                                
                                                
                                                }

                  
                  @AfterTest
                                public void terminatetest() {
                                                wait.until(ExpectedConditions.elementToBeClickable(PageObjectsAgency.lnk_logout(driver)));
                                    test.log(Status.INFO, "Clicking the Logout Button");
                                    PageObjectsAgency.lnk_logout(driver).click(); 
                                   
                     driver.close();                   
                                }
}
