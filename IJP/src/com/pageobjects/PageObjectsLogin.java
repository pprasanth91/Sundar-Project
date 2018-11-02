package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageObjectsLogin  {

private static WebElement element = null;
	
	//Sign In as Candidate Login
	public static WebElement lnk_candidate_login(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='btnCandLogin']"));
	      return element;
	   }
		
	// ADFS User name
	public static WebElement txt_adfs_userid(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_UsernameTextBox']"));
	      return element;
	   }
	
	// ADFS Password
	public static WebElement txt_adfs_password(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_PasswordTextBox']"));
	      return element;
	   }
	
	//ADFS login
	public static WebElement btn_adfs_login(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_SubmitButton']"));
	      return element;
	   }
	
	/* ------------------------------------------------------------------------------------------------------------------------------
	 * 									AGENCY LOGIN
	 * -----------------------------------------------------------------------------------------------------------------------------*/


	//Sign In as Agency
	public static WebElement lnk_agency_login(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Agency"));
	      return element;
	   }
	
	//Agency Username
	public static WebElement txt_agency_uname(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtUserId']"));
	      return element;
	   }
	
	//Agency Password
	public static WebElement txt_agency_password(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtPassword']"));
	      return element;
	   }
	
	//Agency Login Button
	public static WebElement btn_agency_login(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='btnAgencySingIn']"));
	      return element;
	   }
	
	/* ------------------------------------------------------------------------------------------------------------------------------
	 * 										EMPLOYEE LOGIN
	 * -----------------------------------------------------------------------------------------------------------------------------*/
	
	
	//Sign In as Employee
	public static WebElement lnk_Employee_login(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Employee"));
	      return element;
	   }
	
	//Employee Login button
	public static WebElement btn_employee_login(WebDriver driver)
	   {
	      element = driver.findElement(By.id("btnEmpLogIn"));
	      return element;
	   }
	
	//Employee ADFS User name
	public static WebElement txt_employee_uname(WebDriver driver)
	   {
	      element = driver.findElement(By.id("userNameInput"));
	      return element;
	   }
	
	//Employee ADFS Password
	public static WebElement txt_employee_pwd(WebDriver driver)
	   {
	      element = driver.findElement(By.id("passwordInput"));
	      return element;
	   }
	
	//Employee ADFS Login button
	public static WebElement btn_employee_adfs_login(WebDriver driver)
	   {
	      element = driver.findElement(By.id("submitButton"));
	      return element;
	   }
	
	
	//Upload Documents Link
		public static WebElement lnk_upload_doc(WebDriver driver)
		   {
		      element = driver.findElement(By.xpath(".//*[@id='indexdivcontentview']/ng-view/section/div/div[2]/div/div[2]/div[2]/div[1]/a"));
		      return element;
		   }
	
	
	
}
