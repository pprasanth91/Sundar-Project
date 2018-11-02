package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectsGeneral {

	private static WebElement element = null;
	
	//Have you received an offer from Accenture?
	//Authenticate Your Offer Letter
	
	//Unique ID (required)
	public static WebElement txt_unique_id(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtUniqueId']"));
	      return element;
	   }
	
	//Candidate ID (required)
	public static WebElement txt_candidate_id(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtCandidateId']"));
	      return element;
	   }
	
	//Mobile Number (required)
	public static WebElement txt_mobile_num(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='txtMobileNumber']"));
	      return element;
	   }
	
	//Authenticate offer letter
	public static WebElement btn_authenticate_offer_letter(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='btnChkOfrLtr']"));
	      return element;
	   }
	
	
	
}
